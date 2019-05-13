//
//  MapCalloutAnnotationView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "MapCalloutAnnotationView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"

#define maxWidth 250

#define mapCalloutWidth     50.0
#define mapCalloutHeight    80.0

@implementation MapCalloutAnnotationView

@dynamic leftCalloutAccessoryView;
@dynamic rightCalloutAccessoryView;

- (id)initWithAnnotation:(id <MKAnnotation>)annotation reuseIdentifier:(NSString *)reuseIdentifier {
    
    if (self = [super initWithAnnotation:annotation reuseIdentifier:reuseIdentifier]) {
        
        self.frame = CGRectMake(0,0, maxWidth, mapCalloutHeight);
        self.backgroundColor = [UIColor clearColor];
        
        _containerView = [[UIView alloc] initWithFrame:self.frame];
        _roundedBackgroundView = [[UIView alloc] initWithFrame:self.frame];
        
        _titleLabel = [UILabel new];
        _titleLabel.text = @"title";
        _titleLabel.font = [UIFont fontWithName:@"HelveticaNeue-Light" size:17];
        _titleLabel.textColor =  hybris_blue;
        [_titleLabel sizeToFit];
        _titleLabel.center = CGPointMake(0, self.frame.size.height/3);
        
        _subtitleLabel = [UILabel new];
        _subtitleLabel.text = @"subtitle";
        _subtitleLabel.font = [UIFont fontWithName:@"HelveticaNeue-Light" size:12];
        _subtitleLabel.textColor = hybris_black;
        _subtitleLabel.numberOfLines = 0;
        _subtitleLabel.lineBreakMode = NSLineBreakByWordWrapping;
        _subtitleLabel.center = CGPointMake(0, self.frame.size.height/3*2);
        
        _leftCalloutAccessoryPlaceholder    = [UIView new];
        _rightCalloutAccessoryPlaceholder   = [UIView new];
        
        _bubblePoint = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"bubblePoint.png"]];
        
        _roundedBackgroundView.backgroundColor = hybris_white;
        _roundedBackgroundView.layer.masksToBounds = YES;
        _roundedBackgroundView.layer.cornerRadius = 8.f;
        
        [_roundedBackgroundView addSubview:_titleLabel];
        [_roundedBackgroundView addSubview:_subtitleLabel];
        [_roundedBackgroundView addSubview:_leftCalloutAccessoryPlaceholder];
        [_roundedBackgroundView addSubview:_rightCalloutAccessoryPlaceholder];
        
        [_containerView addSubview:_roundedBackgroundView];
        [_containerView addSubview:_bubblePoint];
        
        _containerView.layer.shadowColor = [UIColor blackColor].CGColor;
        _containerView.layer.shadowOpacity = .3;
        _containerView.layer.shadowRadius = 2;
        _containerView.layer.shadowOffset = CGSizeMake(0, 0);
       
        [self addSubview:_containerView];
        
    }
    return self;
}

- (void)setAnnotation:(id <MKAnnotation>)annotation {
    [super setAnnotation:annotation];
    [self setNeedsDisplay];
}

-(void)drawRect:(CGRect)rect {
    
    [super drawRect:rect];
    
    CGFloat marge = 15.f;
    
    _titleLabel.text = self.title;
    [_titleLabel sizeToFit];
    
    _subtitleLabel.text = self.subtitle;
    [_subtitleLabel sizeToFit];
    
    if(self.leftCalloutAccessoryView) {
        [_leftCalloutAccessoryPlaceholder removeSubviews];
        [_leftCalloutAccessoryPlaceholder addSubview:self.leftCalloutAccessoryView];
        [_leftCalloutAccessoryPlaceholder setBounds:self.leftCalloutAccessoryView.bounds];
    } else {
        [_leftCalloutAccessoryPlaceholder setBounds:CGRectZero];
    }
    
    if(self.rightCalloutAccessoryView) {
        [_rightCalloutAccessoryPlaceholder removeSubviews];
        [_rightCalloutAccessoryPlaceholder addSubview:self.rightCalloutAccessoryView];
        [_rightCalloutAccessoryPlaceholder setBounds:self.rightCalloutAccessoryView.bounds];
    } else {
        [_rightCalloutAccessoryPlaceholder setBounds:CGRectZero];
    }
        
    //check if a text field is too long and rectify if needed
    CGFloat maxTextWidth = maxWidth - (_leftCalloutAccessoryPlaceholder.bounds.size.width + marge*2 + _rightCalloutAccessoryPlaceholder.bounds.size.width);
    
    if (self.titleLabel.bounds.size.width > maxTextWidth) {
         [self.titleLabel setBounds:CGRectMake(0, 0, maxTextWidth, _titleLabel.bounds.size.height)];
    }
    
    if (self.subtitleLabel.bounds.size.width > maxTextWidth) {
        [self.subtitleLabel setBounds:CGRectMake(0, 0, maxTextWidth, _subtitleLabel.bounds.size.height)];
    }
    
    //calculate frame width and apply it
    CGFloat textWidth = MAX(self.titleLabel.bounds.size.width, _subtitleLabel.bounds.size.width);
    CGFloat width = _leftCalloutAccessoryPlaceholder.bounds.size.width + marge*2 + textWidth + _rightCalloutAccessoryPlaceholder.bounds.size.width;
    
    self.frame = CGRectMake(0, 0, width, self.frame.size.height);
    
    [_roundedBackgroundView setFrame:self.frame];
    [_containerView setFrame:CGRectMake(0, 0, width, self.frame.size.height+25)];
    
    //layout items
    [_leftCalloutAccessoryPlaceholder  setCenter:CGPointMake(_leftCalloutAccessoryPlaceholder.bounds.size.width/2, self.bounds.size.height/2)];
    [_rightCalloutAccessoryPlaceholder setCenter:CGPointMake(self.bounds.size.width - _rightCalloutAccessoryPlaceholder.bounds.size.width/2 + 5, self.bounds.size.height/2)];
    
    CGFloat offset = _leftCalloutAccessoryPlaceholder.bounds.size.width + marge;
    
    [_titleLabel    setCenter:CGPointMake(_titleLabel.bounds.size.width/2   +offset, self.frame.size.height/3)];
    [_subtitleLabel setCenter:CGPointMake(_subtitleLabel.bounds.size.width/2+offset, self.frame.size.height/3*2+3)];
    
    [_bubblePoint setCenter:CGPointMake(_containerView.center.x, _roundedBackgroundView.bounds.size.height+_bubblePoint.bounds.size.height/2)];
}

@end
