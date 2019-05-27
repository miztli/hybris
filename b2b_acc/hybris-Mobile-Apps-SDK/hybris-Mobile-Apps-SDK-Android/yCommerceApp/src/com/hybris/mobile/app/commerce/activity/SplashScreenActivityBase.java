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
package com.hybris.mobile.app.commerce.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hybris.mobile.app.commerce.R;


/**
 * SplashScreen
 */
public abstract class SplashScreenActivityBase extends ApplicationActivity implements AnimationListener {

    private final static int SPLASH_SCREEN_TIMEOUT_IN_SECONDS = 2;
    private final static boolean SPLASH_SCREEN_ENABLE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (SPLASH_SCREEN_ENABLE) {
            setContentView(R.layout.activity_splashscreen);
            this.setAnimation();
            this.setSplashScreenDuration();
        } else {
            redirectToApp();
        }

    }

    /**
     * Redirection to the authenticate page or the app main page
     */
    protected abstract void redirectToApp();

    /**
     * How long will last the animation
     */
    private void setSplashScreenDuration() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                redirectToApp();
            }
        }, SPLASH_SCREEN_TIMEOUT_IN_SECONDS * 1000);
    }

    /**
     * Different motions settings
     */
    private void setAnimation() {

        ImageView hybrisLogoImg = (ImageView) findViewById(R.id.hybrisLogo);
        ImageView b2bAppLogoImg = (ImageView) findViewById(R.id.b2bAppLogo);

        Animation animHybrisLogo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);
        animHybrisLogo.setAnimationListener(this);
        hybrisLogoImg.setVisibility(View.VISIBLE);
        hybrisLogoImg.startAnimation(animHybrisLogo);

        Animation animB2bAppLogo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animB2bAppLogo.setAnimationListener(this);
        b2bAppLogoImg.setVisibility(View.VISIBLE);
        b2bAppLogoImg.startAnimation(animB2bAppLogo);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }
}
