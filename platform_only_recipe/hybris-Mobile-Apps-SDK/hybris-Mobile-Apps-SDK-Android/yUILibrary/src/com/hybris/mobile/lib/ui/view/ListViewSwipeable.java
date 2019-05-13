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
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.hybris.mobile.lib.ui.R;


/**
 * ListView extension with swipeable item capability
 */
public class ListViewSwipeable extends ListView {

    private ListViewSwipeableListener listViewSwipeableActions;

    private float mDownX;
    private View mViewToSwipe;
    private boolean mIsSwiping = false;
    private boolean mSwipePaused = false;
    private float mPercentMaxPositionLeft;
    private float mPercentLimitAutoSwipe;
    private int mSwipeSpeed;

    // Default values
    private static final int DEFAULT_MAX_POSITION_LEFT = 30;
    private static final int DEFAULT_POSITION_AUTO_SWIPE = 85;
    private static final int DEFAULT_SWIPE_SPEED = 200;

    public ListViewSwipeable(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public ListViewSwipeable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ListViewSwipeable(Context context) {
        super(context);
        init(null);
    }

    /**
     * Init the list view
     *
     * @param attrs Group of Properties
     */
    private void init(AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ListViewSwipeable, 0, 0);

            if (typedArray != null) {
                try {
                    int tempInt = typedArray.getInt(R.styleable.ListViewSwipeable_maxPositionLeft, DEFAULT_MAX_POSITION_LEFT);
                    mPercentMaxPositionLeft = tempInt / 100f;

                    tempInt = typedArray.getInt(R.styleable.ListViewSwipeable_positionAutoSwipe, DEFAULT_POSITION_AUTO_SWIPE);
                    mPercentLimitAutoSwipe = tempInt / 100f;

                    mSwipeSpeed = typedArray.getInt(R.styleable.ListViewSwipeable_swipeSpeed, DEFAULT_SWIPE_SPEED);
                } finally {
                    typedArray.recycle();
                }
            }

        }

        // Disable the swipe when scrolling
        setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // We disallow the swipe
                mSwipePaused = (scrollState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);

                // And we reset the position of the last swipped item
                if (mSwipePaused) {
                    resetLastSwipedItemPosition(true);
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }

        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performClick();

        // For every touch events
        if (listViewSwipeableActions != null) {
            listViewSwipeableActions.onTouch();
        }

        // If the swipe is not paused
        if (!mSwipePaused) {

            switch (event.getActionMasked()) {

                // The user just clicked on the view
                case MotionEvent.ACTION_DOWN:

                    Rect rectItem = new Rect();
                    int[] productListCoords = new int[2];

                    // Get the list view coordinates
                    getLocationOnScreen(productListCoords);

                    int x = (int) event.getRawX() - productListCoords[0];
                    int y = (int) event.getRawY() - productListCoords[1];

                    boolean viewFound = false;
                    int i = getHeaderViewsCount();
                    View currentItem = null;

                    // We loop the list view child to find the item the user clicked
                    while (i < getChildCount() && !viewFound) {
                        currentItem = getChildAt(i);
                        currentItem.getHitRect(rectItem);
                        viewFound = rectItem.contains(x, y);
                        i++;
                    }

                    // View found, we save it and disable the touch event on the drawer
                    if (viewFound) {

                        // We get the second child of the item view (first child is the hidden view behind the swiped view)
                        currentItem = ((ViewGroup) currentItem).getChildAt(1);

                        // If we already have a view to swipe and the view is the same as the one we just clicked, we disable the gesture for the next events
                        if (mViewToSwipe != null && currentItem == mViewToSwipe) {
                            mSwipePaused = true;
                            return super.onTouchEvent(event);
                        }

                        // We reset the last swiped item position (we are swiping a new item)
                        resetLastSwipedItemPosition(true);

                        // When swipe begins
                        if (listViewSwipeableActions != null) {
                            listViewSwipeableActions.onBeginSwipe();
                        }

                        mViewToSwipe = currentItem;

                        // We get the swiped back view to show it as we started to swipe
                        ((ViewGroup) mViewToSwipe.getParent()).getChildAt(0).setVisibility(VISIBLE);

                        mDownX = event.getRawX();
                    }
                    // View not found, we can disable the gesture for the next events and reset the last swiped item
                    else {
                        resetLastSwipedItemPosition(true);
                        mSwipePaused = true;
                        return super.onTouchEvent(event);
                    }

                    break;

                // The user is moving his thumb on the view
                case MotionEvent.ACTION_MOVE:
                    if (mViewToSwipe != null) {

                        // We get the delta between the current thumb position and the first position
                        float mXCoord = event.getRawX() - mDownX;

                        // To begin a swipe the finger must be 30p on the right (or the swipe already begun)
                        if (mXCoord < -30 || mIsSwiping) {

                            // Then we can swipe only to the left (<0)
                            if (mXCoord <= 0) {
                                // And never before the PERCENT_LIMIT_SWIPE_LEFT on the left
                                if (mXCoord >= -(mViewToSwipe.getWidth() * (1 - mPercentMaxPositionLeft))) {
                                    mViewToSwipe.setTranslationX(mXCoord);
                                }

                                // If we are swiping, we consume the event and don't allow the scroll at the same time
                                mIsSwiping = true;
                                return true;
                            }

                        }

                    }
                    break;

                // The user just released his thumb from the view
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:

                    if (mViewToSwipe != null) {
                        // If the view position is before the limit to auto swipe, we auto swipe to the left
                        if ((mViewToSwipe.getX() + mViewToSwipe.getWidth()) <= (mViewToSwipe.getWidth() * mPercentLimitAutoSwipe)) {
                            mViewToSwipe.animate().translationX(-(mViewToSwipe.getWidth() * (1 - mPercentMaxPositionLeft)))
                                    .setDuration(mSwipeSpeed).setListener(null);
                        }
                        // Otherwise we revert the position
                        else {
                            resetLastSwipedItemPosition(true);
                        }
                    }

                    finishSwipeAction();

                    break;
            }
        }
        // Else we re-enable the swipe on action up or cancel
        else if (event.getActionMasked() == MotionEvent.ACTION_UP || event.getActionMasked() == MotionEvent.ACTION_CANCEL) {
            finishSwipeAction();
        }

        return super.onTouchEvent(event);
    }

    /**
     * Revert the last swiped item to its origin
     *
     * @param withAnimation animate the last swiped item to its origin
     */
    public void resetLastSwipedItemPosition(boolean withAnimation) {
        if (mViewToSwipe != null) {
            // We get the swiped back view
            final View backSwipeView = ((ViewGroup) mViewToSwipe.getParent()).getChildAt(0);

            if (withAnimation) {
                // Hide the back swiped view at the end of the animation
                mViewToSwipe.animate().translationX(0).setDuration(mSwipeSpeed).setListener(new AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        backSwipeView.setVisibility(GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }
                });
            } else {
                mViewToSwipe.setX(0);
                backSwipeView.setVisibility(GONE);
            }

            // We remove the reference to the swiped item
            mViewToSwipe = null;

        }
    }

    /**
     * Called when a swipe is finished
     */
    private void finishSwipeAction() {
        // We enable the touch event on the drawer
        if (listViewSwipeableActions != null) {
            listViewSwipeableActions.onFinishSwipe();
        }

        // We disable the swipe
        mSwipePaused = false;
        mIsSwiping = false;
    }

    /**
     * Register the ListViewSwipeableListener
     *
     * @param listViewSwipeableActions A ListView where each row can be slide aside
     */
    public void setListViewSwipeableActions(ListViewSwipeableListener listViewSwipeableActions) {
        this.listViewSwipeableActions = listViewSwipeableActions;
    }

    /**
     * Listener for swipe actions
     */
    public interface ListViewSwipeableListener {
        /**
         * Called when a swipe begins
         */
        void onBeginSwipe();

        /**
         * Called when a swipe finishes
         */
        void onFinishSwipe();

        /**
         * Called on each touch event
         */
        void onTouch();
    }

}
