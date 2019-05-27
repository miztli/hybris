/*******************************************************************************
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 ******************************************************************************/
package com.hybris.mobile.app.commerce.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.commerce.data.product.VariantOption;
import com.hybris.mobile.lib.commerce.data.product.VariantOptionQualifier;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Adapter for the variant for Multi-Dimensional Products for Spinner
 */
public class VariantAdapter extends ArrayAdapter<VariantOption>
{
	public static final String TAG = VariantAdapter.class.getCanonicalName();


	public VariantAdapter(Context context, int textViewResourceId, List<VariantOption> productVariants)
	{
		super(context, textViewResourceId, productVariants);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		return getCustomView(position, convertView, parent);
	}

	/**
	 * Create the view for spinner item
	 *
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	public View getCustomView(int position, View convertView, ViewGroup parent)
	{

		View rowView;

		if (convertView == null)
		{
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.item_product_variant, parent, false);
		}
		else
		{
			rowView = convertView;
		}

		VariantOption productVariant = getItem(position);

		TextView productVariantName = (TextView) rowView.findViewById(R.id.product_variant_name);
		final ImageView productVariantImage = (ImageView) rowView.findViewById(R.id.product_variant_image);
		final ProgressBar productVariantProgressBar = (ProgressBar) rowView.findViewById(R.id.product_variant_image_loading);

		productVariantName.setText(((List<VariantOptionQualifier>) productVariant.getVariantOptionQualifiers()).get(0).getValue());

		if (((List<VariantOptionQualifier>) productVariant.getVariantOptionQualifiers()).get(0).getImage() != null)
		{ // Loading the product image
			if (CommerceApplication.isOnline())
			{

				if (StringUtils.isNotBlank(
						((List<VariantOptionQualifier>) productVariant.getVariantOptionQualifiers()).get(0).getImage().getUrl()))
				{

					CommerceApplication.getContentServiceHelper().loadImage(
							((List<VariantOptionQualifier>) productVariant.getVariantOptionQualifiers()).get(0).getImage().getUrl(),
							null,
							productVariantImage, 0, 0, true, new OnRequestListener()
							{

								@Override
								public void beforeRequest()
								{
									productVariantImage.setImageResource(android.R.color.transparent);
									productVariantImage.setVisibility(View.GONE);
									productVariantProgressBar.setVisibility(View.VISIBLE);
								}

                                @Override
                                public void afterRequestBeforeResponse() {

                                }

                                @Override
								public void afterRequest(boolean isDataSynced)
								{
									productVariantImage.setVisibility(View.VISIBLE);
									productVariantProgressBar.setVisibility(View.GONE);
								}
							}, true);
				}

			}
			else
			{
				Log.i(TAG, "Application offline, displaying no image for variant " + productVariant.getCode());
				productVariantImage.setImageDrawable(getContext().getResources().getDrawable(R.drawable.no_image_product));
				productVariantImage.setVisibility(View.VISIBLE);
			}

		}

		return rowView;
	}
}
