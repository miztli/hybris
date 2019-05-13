/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.jdbcwrapper.interceptor.recover;

import de.hybris.bootstrap.annotations.ManualTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLongArray;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;


@ManualTest
public class SQLRecoverableExceptionHandlerDemoTest
{
	private static final AtomicLongArray THREAD_STATUS = new AtomicLongArray(64);

	@Test
	public void demo() throws InterruptedException, SQLException, InvocationTargetException
	{
		final JFrame frame = showDemoFrame();

		Registry.activateStandaloneMode();
		Registry.activateMasterTenant();

		for (int i = 0; i < THREAD_STATUS.length(); i++)
		{
			new TestThread(i, Registry.getCurrentTenant()).start();
		}

		while (true)
		{
			Thread.sleep(10);
			SwingUtilities.invokeAndWait(() -> frame.repaint());
		}
	}

	private JFrame showDemoFrame()
	{
		final int side = (int) Math.max(Math.sqrt(THREAD_STATUS.length()), 1);
		final int sideCeil = (int) Math.ceil(Math.max(Math.sqrt(THREAD_STATUS.length()), 1));
		final Color[] scale = new Color[]
		{ Color.GREEN, Color.GREEN.darker(), Color.GREEN.darker().darker(), Color.GREEN.darker().darker().darker(), Color.RED };

		final JFrame frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		final JPanel panel = new JPanel(true)
		{
			@Override
			protected void paintComponent(final Graphics g)
			{
				super.paintComponent(g);

				final long now = System.currentTimeMillis();

				for (int i = 0; i < THREAD_STATUS.length(); i++)
				{
					final Color color = scale[(int) Math.min((Math.abs(now - THREAD_STATUS.get(i)) / 5000), scale.length - 1)];
					final int x = i % side;
					final int y = i / side;
					g.setColor(color);
					g.fillRect(5 + x * 25, 5 + y * 25, 20, 20);
				}
			}
		};
		panel.setPreferredSize(new Dimension(Math.min(side * 25 + 5, 1024), Math.min(sideCeil * 25 + 5, 768)));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		return frame;
	}

	static class TestThread extends Thread
	{
		private static final Logger LOG = LoggerFactory.getLogger(TestThread.class);
		private final Tenant tenant;

		public TestThread(final int id, final Tenant tenant)
		{
			super("" + id);
			this.tenant = tenant;
		}

		@Override
		public void run()
		{
			try
			{
				Registry.runAsTenant(tenant, () -> {
					doTheTest();
					return null;
				});
			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		}

		private static void doTheTest()
		{
			final FlexibleSearchService fs = Registry.getCoreApplicationContext().getBean("flexibleSearchService",
					FlexibleSearchService.class);
			while (true)
			{
				try
				{
					fs.search("select {PK} from {Principal} where {creationtime} < ?now", Collections.singletonMap("now", new Date()));
					THREAD_STATUS.set(Integer.parseInt(Thread.currentThread().getName()), System.currentTimeMillis());
				}
				catch (final Throwable t)
				{
					if (!Throwables.getCausalChain(t).stream().anyMatch(SQLException.class::isInstance))
					{
						LOG.error("Received non SQLException.", t);
					}
				}
			}
		}
	}
}


