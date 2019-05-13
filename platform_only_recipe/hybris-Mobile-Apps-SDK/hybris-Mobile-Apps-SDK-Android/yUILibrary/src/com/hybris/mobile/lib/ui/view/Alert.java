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
package com.hybris.mobile.lib.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hybris.mobile.lib.ui.R;
import com.hybris.mobile.lib.ui.view.Alert.Configuration.Orientation;
import com.hybris.mobile.lib.ui.view.Alert.Configuration.Position;

import org.apache.commons.lang3.StringUtils;


/**
 * Alert panel
 */
public class Alert {

    // Configuration
    private static final int HEIGHT = 100;
    private static final int DURATION = 3000;
    private static final int DURATION_OUT = 200;
    private static final int DURATION_IN = 200;
    private static final Handler handler = new Handler();

    private Alert() {

    }

    /**
     * Enum for message type
     */
    private enum Type {
        CRITICAL("CRITICAL"), ERROR("ERROR"), SUCCESS("SUCCESS"), WARNING("WARNING");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    /**
     * Show the alert success with optional configuration
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     * @param text          message to be displayed
     */
    public static void showSuccess(Activity context, Configuration configuration, String text) {
        showAlert(context, Type.SUCCESS, configuration, text, false);
    }

    /**
     * Show the alert warning with optional configuration
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     * @param text          message to be displayed
     */
    public static void showWarning(Activity context, Configuration configuration, String text) {
        showAlert(context, Type.WARNING, configuration, text, false);
    }

    /**
     * Show the alert error with optional configuration
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     * @param text          message to be displayed
     */
    public static void showError(Activity context, Configuration configuration, String text) {
        showAlert(context, Type.ERROR, configuration, text, false);
    }

    /**
     * Show the alert critical with optional configuration
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     * @param text          message to be displayed
     */
    public static void showCritical(Activity context, Configuration configuration, String text) {
        showAlert(context, Type.CRITICAL, configuration, text, false);
    }

    /**
     * Show the alert success
     *
     * @param context application-specific resources
     * @param text    message to be displayed
     */
    public static void showSuccess(Activity context, String text) {
        showAlert(context, Type.SUCCESS, null, text, false);
    }

    /**
     * Show the alert warning
     *
     * @param context application-specific resources
     * @param text    message to be displayed
     */
    public static void showWarning(Activity context, String text) {
        showAlert(context, Type.WARNING, null, text, false);
    }

    /**
     * Show the alert error
     *
     * @param context application-specific resources
     * @param text    message to be displayed
     */
    public static void showError(Activity context, String text) {
        showAlert(context, Type.ERROR, null, text, false);
    }

    /**
     * Show the alert critical
     *
     * @param context application-specific resources
     * @param text    message to be displayed
     */
    public static void showCritical(Activity context, String text) {
        showAlert(context, Type.CRITICAL, null, text, false);
    }

    /**
     * Show a custom alert by providing a configuration
     *
     * @param context                 application-specific resources
     * @param configuration           describes all device configuration information
     * @param text                    message to be displayed
     * @param forceClearPreviousAlert true will clear previous alert else keep it
     */
    public static void show(Activity context, Configuration configuration, String text, boolean forceClearPreviousAlert) {
        if (configuration == null) {
            throw new IllegalArgumentException("You must provide a configuration for the alert.");
        }

        showAlert(context, null, configuration, text, forceClearPreviousAlert);
    }

    /**
     * Configure and call the method to show the alert
     *
     * @param context       application-specific resources
     * @param messageType   CRITICAL, ERROR, SUCCESS, WARNING
     * @param configuration describes all device configuration information
     * @param text          message to be displayed
     */
    private static void showAlert(Activity context, Type messageType, Configuration configuration, String text,
                                  boolean forceClearPreviousAlert) {
        showAlertOnScreen(context, setUpConfiguration(context, configuration, messageType), text, forceClearPreviousAlert);
    }

    /**
     * Configure the alert
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     * @param messageType   CRITICAL, ERROR, SUCCESS, WARNING
     * @return Device configuration information
     */
    private static Configuration setUpConfiguration(Activity context, Configuration configuration, Type messageType) {

        if (configuration == null) {
            configuration = new Configuration();
        }

        // Main configuration
        if (configuration.getHeight() == -1) {
            configuration.setHeight();
        }

        if (configuration.getDuration() == -1) {
            configuration.setDuration();
        }

        if (configuration.getIconResId() == -1 && configuration.isCloseable()) {
            configuration.setIconResId(R.drawable.alert_close_icon_white);
        }

        if (configuration.getIconPosition() == null) {
            configuration.setIconPosition(Position.RIGHT);
        }

        if (configuration.getOrientation() == null) {
            configuration.setOrientation(Orientation.TOP);
        }

        // Configuration specific to the message type
        if (messageType != null) {
            configuration.setMessageType(messageType.getType());

            switch (messageType) {
                case CRITICAL:
                    configuration.setUpBackgroundColor(context.getResources().getColor(R.color.background_alert_critical));
                    configuration.setUpTextColor(context.getResources().getColor(R.color.text_alert_critical));
                    break;

                case ERROR:
                    configuration.setUpBackgroundColor(context.getResources().getColor(R.color.background_alert_error));
                    configuration.setUpTextColor(context.getResources().getColor(R.color.text_alert_error));
                    break;

                case WARNING:
                    configuration.setUpBackgroundColor(context.getResources().getColor(R.color.background_alert_warning));
                    configuration.setUpTextColor(context.getResources().getColor(R.color.text_alert_warning));
                    break;

                case SUCCESS:
                    configuration.setUpBackgroundColor(context.getResources().getColor(R.color.background_alert_success));
                    configuration.setUpTextColor(context.getResources().getColor(R.color.text_alert_success));
                    break;
            }
        }

        return configuration;
    }


    /**
     * Show the alert
     *
     * @param context                 application-specific resources
     * @param configuration           describes all device configuration information
     * @param text                    message to be displayed
     * @param forceClearPreviousAlert true will clear previous alert else keep it
     */
    @SuppressLint("NewApi")
    private static void showAlertOnScreen(final Activity context, final Configuration configuration, final String text,
                                          boolean forceClearPreviousAlert) {

        final ViewGroup mainView = ((ViewGroup) context.findViewById(android.R.id.content));
        boolean currentlyDisplayed = false;
        int viewId = R.id.alert_view_top;
        final TextView textView;
        boolean alertAlreadyExists = false;

        if (configuration.getOrientation().equals(Configuration.Orientation.BOTTOM)) {
            viewId = R.id.alert_view_bottom;
        }

        // Retrieving the view
        RelativeLayout relativeLayout = (RelativeLayout) mainView.findViewById(viewId);

        if (forceClearPreviousAlert) {
            mainView.removeView(relativeLayout);
            relativeLayout = null;
        }

        // Creating the view
        if (relativeLayout == null) {

            // Main layout
            relativeLayout = new RelativeLayout(context);
            relativeLayout.setId(viewId);
            relativeLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, configuration.getHeight()));
            relativeLayout.setGravity(Gravity.CENTER);

            // Textview
            textView = new TextView(context);
            textView.setId(R.id.alert_view_text);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            relativeLayout.addView(textView);

            setIcon(context, configuration, relativeLayout, textView);

            if (configuration.getOrientation().equals(Configuration.Orientation.TOP)) {
                relativeLayout.setY(-configuration.getHeight());
            } else {
                relativeLayout.setY(mainView.getHeight());
            }

            // Adding the view to the global layout
            mainView.addView(relativeLayout, 0);
            relativeLayout.bringToFront();
            relativeLayout.requestLayout();
            relativeLayout.invalidate();
        }
        // View already exists
        else {
            alertAlreadyExists = true;
            textView = (TextView) relativeLayout.findViewById(R.id.alert_view_text);

            if (configuration.getOrientation().equals(Configuration.Orientation.TOP)) {
                if (relativeLayout.getY() == 0) {
                    currentlyDisplayed = true;
                }
            } else {
                if (relativeLayout.getY() < mainView.getHeight()) {
                    currentlyDisplayed = true;
                }
            }

            // The view is currently shown to the user
            if (currentlyDisplayed) {

                // If the message is not the same, we hide the current message and display the new one
                if (!StringUtils.equals(text, textView.getText())) {
                    // Anim out the current message
                    ViewPropertyAnimator viewPropertyAnimator = animOut(configuration, mainView, relativeLayout);

                    final RelativeLayout relativeLayoutFinal = relativeLayout;

                    if (viewPropertyAnimator != null) {
                        // Anim in the new message after the animation out has finished
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                            viewPropertyAnimator.setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    setIcon(context, configuration, relativeLayoutFinal, textView);
                                    animIn(configuration, relativeLayoutFinal, textView, mainView, text);
                                }
                            });
                        } else {
                            viewPropertyAnimator.withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    setIcon(context, configuration, relativeLayoutFinal, textView);
                                    animIn(configuration, relativeLayoutFinal, textView, mainView, text);
                                }
                            });
                        }
                    } else {
                        setIcon(context, configuration, relativeLayoutFinal, textView);
                        animIn(configuration, relativeLayoutFinal, textView, mainView, text);
                    }
                }
            }
        }

        final RelativeLayout relativeLayoutFinal = relativeLayout;

        // Close the alert by clicking the layout
        if (configuration.isCloseable()) {
            relativeLayout.setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    animOut(configuration, mainView, relativeLayoutFinal);
                    v.performClick();
                    return true;
                }
            });
        }

        if (!currentlyDisplayed) {
            // Set the icon in case the alert already exists but it's not currently displayed
            if (alertAlreadyExists) {
                setIcon(context, configuration, relativeLayoutFinal, textView);
            }

            // We anim in the alert
            animIn(configuration, relativeLayoutFinal, textView, mainView, text);
        }
    }

    /**
     * Set the icon on the alert
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     * @param mainView      ViewGroup resources
     * @param textView      alert message to be viewed message to be displayedView
     */
    @SuppressLint("NewApi")
    private static void setIcon(Activity context, Configuration configuration, ViewGroup mainView, TextView textView) {

        ImageView imageView = (ImageView) mainView.findViewById(R.id.alert_view_icon);

        // Reset the current icon
        if (imageView != null) {
            mainView.removeView(imageView);
        }

        // On the textview as well
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        textView.setCompoundDrawablePadding(0);

        if (configuration.getIconResId() != -1) {

            imageView = new ImageView(context);
            imageView.setId(R.id.alert_view_icon);

            imageView.setImageResource(configuration.getIconResId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);

            switch (configuration.getIconPosition()) {
                case LEFT_TEXT:
                    textView.setCompoundDrawablesWithIntrinsicBounds(configuration.getIconResId(), 0, 0, 0);
                    textView.setCompoundDrawablePadding(10);
                    break;

                case RIGHT_TEXT:
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, configuration.getIconResId(), 0);
                    textView.setCompoundDrawablePadding(10);
                    break;

                case LEFT:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START);
                    }

                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    layoutParams.setMargins(25, 0, 0, 0);
                    mainView.addView(imageView);

                    // We redefine the layout params otherwise the image is not well aligned
                    textView.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                            LayoutParams.WRAP_CONTENT));
                    break;
                case RIGHT:
                default:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
                    }

                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    layoutParams.setMargins(0, 0, 25, 0);
                    mainView.addView(imageView);

                    // We redefine the layout params otherwise the image is not well aligned
                    textView.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                            LayoutParams.WRAP_CONTENT));
                    break;
            }
        }
    }

    /**
     * Hide the alert
     *
     * @param context       application-specific resources
     * @param configuration describes all device configuration information
     */
    public static void hide(Activity context, Configuration configuration) {
        if (context == null) {
            throw new IllegalArgumentException("You must provide a configuration and/or context for the alert.");
        }

        ViewGroup mainView = (ViewGroup) context.findViewById(android.R.id.content);
        int viewId = R.id.alert_view_top;

        configuration = setUpConfiguration(context, configuration, null);

        if (configuration.getOrientation().equals(Configuration.Orientation.BOTTOM)) {
            viewId = R.id.alert_view_bottom;
        }

        animOut(configuration, mainView, mainView.findViewById(viewId));
    }

    /**
     * Alert animation out
     *
     * @param configuration describes all device configuration information
     * @param alertView     View Resources to animate
     * @return Animated views
     */
    private static ViewPropertyAnimator animOut(final Configuration configuration, ViewGroup mainView, View alertView) {
        // Remove the anim out callback
        handler.removeCallbacksAndMessages(null);

        if (alertView != null && configuration != null) {
            if (configuration.getOrientation().equals(Configuration.Orientation.TOP)) {
                return animViews(alertView, mainView, configuration, -configuration.getHeight(), 0, false);
            } else {
                return animViews(alertView, mainView, configuration, mainView.getHeight(), configuration.getHeight(), false);
            }
        }

        return null;
    }

    /**
     * Alert animation in
     * @param configuration describes all device configuration information
     * @param alertView     View Resources to animate
     * @param textView      alert message to be viewed
     * @param mainView      ViewGroup resources
     * @param text          message to be displayed
     */
    private static void animIn(final Configuration configuration, final View alertView, TextView textView,
                               final ViewGroup mainView, String text) {
        // Colors
        textView.setTextColor(configuration.getColorTextResId());
        alertView.setBackgroundColor(configuration.getColorBackgroundResId());

        // Content Description
        alertView.setContentDescription(configuration.getMessageType());

        // Setting the text
        textView.setText(text);

        // Animation In
        if (configuration.getOrientation().equals(Configuration.Orientation.TOP)) {
            animViews(alertView, mainView, configuration, 0, configuration.getHeight(), true);
        } else {
            animViews(alertView, mainView, configuration, mainView.getHeight() - configuration.getHeight(),
                    -configuration.getHeight(), true);
        }

        // Delayed animation out
        if (configuration.isCloseable()) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animOut(configuration, mainView, alertView);
                }
            }, configuration.getDuration());
        }
    }

    /**
     * Anim the alert and the main view accordingly
     *
     * @param alertView         View Resources to animate
     * @param mainView          ViewGroup resources
     * @param configuration     describes all device configuration information
     * @param translationYAlert Move alert panel to be displayed
     * @param translationYMain  Move main windows screen
     * @param animIn            true animate panel to be displayed else animate panel to hide
     * @return Animated views
     */
    private static ViewPropertyAnimator animViews(View alertView, final ViewGroup mainView, final Configuration configuration,
                                                  int translationYAlert, int translationYMain, final boolean animIn) {
        long duration = animIn ? DURATION_IN : DURATION_OUT;
        ViewPropertyAnimator viewPropertyAnimator = null;


        if (configuration.isWithAnim()) {
            viewPropertyAnimator = alertView.animate().translationY(translationYAlert).setDuration(duration);

            if (configuration.isShiftContent()) {
                final View viewToResize = mainView.getChildAt(0);

                // Resizing the view after the animation only alert is not on screen otherwise keep size
                viewToResize.animate().translationY(translationYMain).setDuration(duration).setListener(
                        new AnimatorListenerAdapter() {

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                resizeViewHeight(viewToResize, configuration.getHeight(), !animIn, mainView.getHeight());
                            }
                        });
            }
        } else {
            alertView.setTranslationY(translationYAlert);

            if (configuration.isShiftContent()) {
                final View viewToResize = mainView.getChildAt(0);
                viewToResize.setTranslationY(translationYMain);

                // Resizing the view
                resizeViewHeight(viewToResize, configuration.getHeight(), !animIn, mainView.getHeight());
            }
        }

        return viewPropertyAnimator;
    }

    /**
     * Resize a view height and request the re-draw of the view
     *
     * @param viewToResize Main Screen Windows to
     * @param height       Amount of pixel can be seeing
     * @param addValue     true increase size else decrease
     */
    private static void resizeViewHeight(View viewToResize, int height, boolean addValue, int realScreenHeight) {

        if (addValue) {
            viewToResize.getLayoutParams().height = viewToResize.getHeight() + height;
        } else {
            viewToResize.getLayoutParams().height = realScreenHeight - height;
        }

        viewToResize.requestLayout();
    }

    /**
     * Class to manage setting for the Custom Alert panel such as Position, Orientation, Duration, Icon, Animation, Message and Color.
     */
    public static class Configuration {
        private int mDuration = -1;
        private int mHeight = -1;
        private int mColorBackgroundResId = -1;
        private int mColorTextResId = -1;
        private int mIconResId = -1;
        private Position mIconPosition = Position.RIGHT;
        private Orientation mOrientation = Orientation.TOP;
        private String mMessageType;
        private boolean mCloseable = true;
        private boolean mOverlayContent = true;
        private boolean mWithAnim = true;

        public enum Orientation {
            TOP, BOTTOM
        }

        public enum Position {
            LEFT, RIGHT, LEFT_TEXT, RIGHT_TEXT
        }

        public Orientation getOrientation() {
            return mOrientation;
        }

        public void setOrientation(Orientation orientation) {
            this.mOrientation = orientation;
        }

        public int getDuration() {
            return mDuration;
        }

        public void setDuration() {
            this.mDuration = Alert.DURATION;
        }

        public int getHeight() {
            return mHeight;
        }

        public void setHeight() {
            this.mHeight = Alert.HEIGHT;
        }

        public int getColorBackgroundResId() {
            return mColorBackgroundResId;
        }

        public void setColorBackgroundResId(int colorBackgroundResId) {
            this.mColorBackgroundResId = colorBackgroundResId;
        }

        public int getColorTextResId() {
            return mColorTextResId;
        }

        public void setColorTextResId(int colorTextResId) {
            this.mColorTextResId = colorTextResId;
        }

        public int getIconResId() {
            return mIconResId;
        }

        public void setIconResId(int iconResId) {
            this.mIconResId = iconResId;
        }

        public Position getIconPosition() {
            return mIconPosition;
        }

        public void setIconPosition(Position iconPosition) {
            this.mIconPosition = iconPosition;
        }

        public String getMessageType() {
            return mMessageType;
        }

        public void setMessageType(String messageType) {
            this.mMessageType = messageType;
        }

        private void setUpBackgroundColor(int resId) {
            if (this.getColorBackgroundResId() == -1) {
                this.setColorBackgroundResId(resId);
            }
        }

        private void setUpTextColor(int resId) {
            if (this.getColorTextResId() == -1) {
                this.setColorTextResId(resId);
            }
        }

        public boolean isCloseable() {
            return mCloseable;
        }

        public void setCloseable(boolean closeable) {
            this.mCloseable = closeable;
        }

        public boolean isShiftContent() {
            return !mOverlayContent;
        }

        public void setOverlayContent(boolean overlayContent) {
            this.mOverlayContent = overlayContent;
        }

        public boolean isWithAnim() {
            return mWithAnim;
        }

        public void setWithAnim(boolean withAnim) {
            this.mWithAnim = withAnim;
        }
    }
}
