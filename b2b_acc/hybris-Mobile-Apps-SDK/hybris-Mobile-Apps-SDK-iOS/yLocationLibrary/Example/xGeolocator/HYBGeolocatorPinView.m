//
//  HYBGeolocatorPinView.m
//  xGeolocator
// [y] hybris Platform
//
// Copyright (c) 2000-2014 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.


#import "HYBGeolocatorPinView.h"
#import <CoreText/CoreText.h>

#define defautPinFrame CGRectMake(0,0,100 ,145)

@interface HYBGeolocatorPinView ()

@property (nonatomic) UIColor   *pinColor;
@property (nonatomic) NSInteger  pinIndex;

@property (nonatomic) NSAttributedString *attributedString;

@end

@implementation HYBGeolocatorPinView

+ (instancetype)pinWithColor:(UIColor*)pinColor forIndex:(NSInteger)pinIndex {
    return [[HYBGeolocatorPinView alloc] initWithColor:pinColor forIndex:pinIndex];
}

- (instancetype)initWithColor:(UIColor*)pinColor forIndex:(NSInteger)pinIndex {
    
    if(self = [super initWithFrame:defautPinFrame]) {
        _pinColor = pinColor;
        _pinIndex = pinIndex;
        self.opaque = NO;
        
        CTFontRef fontRef = CTFontCreateWithName((CFStringRef)@"HelveticaNeue-Bold", 22.0f, NULL);
        
        NSDictionary *attrDictionary = [NSDictionary dictionaryWithObjectsAndKeys:
                                        (id)CFBridgingRelease(fontRef),         (NSString *)kCTFontAttributeName,
                                        (id)[[UIColor blackColor] CGColor],     (NSString *)(kCTForegroundColorAttributeName),
                                        nil];
        
        _attributedString = [[NSAttributedString alloc] initWithString:[NSString stringWithFormat:@"%ld",(long)_pinIndex]
                                                            attributes:attrDictionary];
        
    }
    
    return self;
}

- (void)drawRect:(CGRect)rect {
    CGContextRef context = UIGraphicsGetCurrentContext();
    
    CGContextSetTextMatrix(context, CGAffineTransformIdentity);
    CGContextTranslateCTM(context, 0, self.bounds.size.height);
    CGContextScaleCTM(context, 1.0, -1.0);
    
    CGRect bounds = self.bounds;
    CGFloat padding = CGRectGetMaxX(bounds)*.1;
    
    CGFloat minx = CGRectGetMinX(bounds)+padding, midx = CGRectGetMidX(bounds), maxx = CGRectGetMaxX(bounds)-padding;
    CGFloat miny = CGRectGetMinY(bounds)+padding, midy = CGRectGetMidY(bounds), maxy = CGRectGetMaxY(bounds)-padding;
   
    CGFloat unit = maxx-padding;
    
    CGFloat modX = midx*.05;
    CGFloat customY = midy*1.025;
    
    CGContextSetFillColorWithColor(context,_pinColor.CGColor);
    
    CGContextSetStrokeColorWithColor(context, _pinColor.CGColor);
    CGContextSetLineWidth(context, 4.0);
    
    CGContextAddEllipseInRect(context, CGRectMake(minx, maxy-padding/2-unit, unit, unit));
    
    CGContextMoveToPoint  (context,
                           minx+modX,
                           customY);
    
    CGContextAddLineToPoint(context, midx, miny);
    CGContextAddLineToPoint(context, maxx-modX, customY);
    
    CGContextDrawPath(context, kCGPathFill);
    
    CGContextSetFillColorWithColor(context,[UIColor whiteColor].CGColor);
    CGContextAddEllipseInRect(context, CGRectMake(minx+padding*1.5, maxy-(unit-padding), unit-padding*3, unit-padding*3));
    
    CGContextDrawPath(context, kCGPathFill);
    
    //text
    CTLineRef line = CTLineCreateWithAttributedString((CFAttributedStringRef)_attributedString);
    
    CGFloat ascent, descent, leading, width;
    width = CTLineGetTypographicBounds(line, &ascent,  &descent, &leading);
    
    CGContextSetTextPosition(context, midx-width/2, maxy-(unit/2)-descent-padding/2);
    CTLineDraw(line, context);
    CFRelease(line);
    
}



@end
