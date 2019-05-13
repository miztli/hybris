//
// HYBZoomView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//

#import "HYBZoomView.h"
#import "HYBConstants.h"

@interface HYBZoomView ()
@property (nonatomic, strong) UIImageView *productImageView;
@property (nonatomic, strong) UIImageView *closeButton;
@property (nonatomic) BOOL isFullFit;
@end

CGRect originalFrame;

@implementation HYBZoomView

/**
 *  shortcut to create a zoom view of a product image
 *
 *  @param frame        dimensions of the zoomview
 *  @param productImage image to use in the zoomview
 *
 *  @return a HYBZoomView
 */
+ (id)zoomViewWithFrame:(CGRect)frame andImage:(UIImage*)productImage {
    return [[HYBZoomView alloc] initViewWithFrame:frame andImage:productImage];
}

/**
 *  create a zoom view of a product image
 *
 *  @param frame        dimensions of the zoomview
 *  @param productImage image to use in the zoomview
 *
 *  @return a HYBZoomView
 */
- (id)initViewWithFrame:(CGRect)frame andImage:(UIImage*)productImage {
    if(self = [super initWithFrame:frame]) {
        self.backgroundColor = [UIColor whiteColor];
        self.opaque = YES;
        
        _isFullFit = NO;
        
        //close button
        _closeButton = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"Close_Icon.png"]];
        _closeButton.center = CGPointMake(_closeButton.bounds.size.width, _closeButton.bounds.size.height*3.25);
        _closeButton.contentMode = UIViewContentModeScaleAspectFit;
        _closeButton.accessibilityIdentifier = @"ACCESS_ZOOM_PRODUCTDETAILS_BACK";
        
        UITapGestureRecognizer *dismissTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismiss)];
        [_closeButton addGestureRecognizer:dismissTap];
        
        //product image
        _productImageView = [[UIImageView alloc] initWithImage:productImage];
        _productImageView.center = CGPointMake(frame.size.width/2, frame.size.height/2);
        _productImageView.contentMode = UIViewContentModeScaleAspectFit;
        _productImageView.accessibilityIdentifier = @"ACCESS_ZOOM_PRODUCTDETAILS_PRODUCT_IMAGE";
        
        //save original setup
        originalFrame = _productImageView.frame;
        
        //interactions
        _closeButton.userInteractionEnabled = YES;
        _productImageView.userInteractionEnabled = YES;
        self.userInteractionEnabled = YES;
        
        //double tap - on main view
        UITapGestureRecognizer *doubleTapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(handleDoubleTap:)];
        doubleTapRecognizer.numberOfTapsRequired = 2;
        [self addGestureRecognizer:doubleTapRecognizer];
        
        //pan - on product
        UIPanGestureRecognizer *panRecognizer = [[UIPanGestureRecognizer alloc]initWithTarget:self action:@selector(handlePan:)];
        [_productImageView addGestureRecognizer:panRecognizer];
        [panRecognizer requireGestureRecognizerToFail:doubleTapRecognizer];
        
        //pinch - on product
        UIPinchGestureRecognizer *pinchRecognizer = [[UIPinchGestureRecognizer alloc]initWithTarget:self action:@selector(handlePinch:)];
        [_productImageView addGestureRecognizer:pinchRecognizer];
        
        //pile up
        [self addSubview:_productImageView];
        [self addSubview:_closeButton];
    }
    return self;
}

/**
 *  auto dismiss or the zoomview
 */
- (void)dismiss {
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         self.alpha = 0.f;
                     }
                     completion:^(BOOL done) {
                         [self removeFromSuperview];
                     }];
}

/**
 *  handle the double tap gesture : zoom full screen or return to original size
 *
 *  @param recognizer sender
 */
- (void)handleDoubleTap:(UITapGestureRecognizer*)recognizer {
    
    CGRect nextFrame = CGRectZero;
    
    BOOL willFullFit = NO;
    
    if(_isFullFit) {
        //reset frame
        nextFrame = originalFrame;
        willFullFit = NO;
    } else {
        //fit frame
        willFullFit = YES;
        nextFrame = self.frame;
    }
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _productImageView.frame = nextFrame;
                     }
                     completion:^(BOOL done) {
                         _isFullFit = willFullFit;
                     }];
}

/**
 *  handle the pan gesture : move the picutre around
 *
 *  @param recognizer sender
 */
- (void)handlePan:(UIPanGestureRecognizer *)recognizer {
    
    CGPoint translation = [recognizer translationInView:self];
    CGPoint imageViewPosition = _productImageView.center;
    imageViewPosition.x += translation.x;
    imageViewPosition.y += translation.y;
    
    _productImageView.center = imageViewPosition;
    [recognizer setTranslation:CGPointZero inView:self];
    
    _isFullFit = NO;
}

/**
 *  handle the pinch gesture : zoom in or out the original picture
 *
 *  @param recognizer sender
 */
- (void)handlePinch:(UIPinchGestureRecognizer *)recognizer {
    
    recognizer.view.transform = CGAffineTransformScale(recognizer.view.transform, recognizer.scale, recognizer.scale);
    recognizer.scale = 1;
    
    _isFullFit = NO;
}

@end
