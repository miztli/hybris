//
//  HYBDropDownButton.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBDropDownButton.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"

@interface HYBDropDownButton ()
@property (nonatomic) NSMutableDictionary *backgroundStates;
@property (nonatomic) NSMutableDictionary *textStates;
@property (nonatomic) UIControlState currentState;
@end

@implementation HYBDropDownButton

//default inits
- (id)init {
    if(self = [super init]) {
        [self setup];
    }
    return self;
}

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (id)initWithCoder:(NSCoder *)aDecoder {
    if(self = [super initWithCoder:aDecoder]) {
        [self setup];
    }
    return self;
}

//setup default

- (void)setup {
    
    self.clipsToBounds = YES;
    
    _label = [UILabel new];
    _label.font = font_light_small;
    _label.textColor = hybris_black;
    
    self.layer.borderWidth = 1.f;
    self.layer.borderColor = [hybris_gray CGColor];
    
    [self setTitleColor:drop_down_button_default_text  forState:UIControlStateNormal];
    [self setTitleColor:drop_down_button_default_text  forState:UIControlStateHighlighted];
    [self setTitleColor:drop_down_button_disabled_text forState:UIControlStateDisabled];
    [self setTitleColor:drop_down_button_default_text  forState:UIControlStateSelected];
    
    [self setBackgroundColor:drop_down_button_default_background      forState:UIControlStateNormal];
    [self setBackgroundColor:drop_down_button_hilighted_background    forState:UIControlStateHighlighted];
    [self setBackgroundColor:drop_down_button_disabled_background     forState:UIControlStateDisabled];
    [self setBackgroundColor:drop_down_button_selected_background     forState:UIControlStateSelected];
    
    [self addSubview:_label];
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    [_label sizeToFit];
    
    CGPoint aCenter = CGPointMake(_label.bounds.size.width / 2 + [self bH] / 4,
                                  [self bH] / 2);
    
    _label.center = aCenter;
}

- (void)addTarget:(id)aTarget action:(SEL)anAction {
    
    self.userInteractionEnabled = YES;
    
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:aTarget
                                                                                    action:anAction];
    [self addGestureRecognizer:tapRecognizer];
    tapRecognizer.delegate = self;
}

- (void)setText:(NSString *)aText {
    _label.text = aText;
    [self layoutSubviews];
    [self refresh];
}

//state management
- (void)refresh {
    self.backgroundColor = [self backgroundColorForState:_currentState];
    _label.textColor = [self titleColorForState:_currentState];
}

- (void)setEnabled:(BOOL)enabled {
    self.userInteractionEnabled = enabled;
    if(!enabled) _currentState = UIControlStateDisabled;
    else _currentState = UIControlStateNormal;
    [self refresh];
}

- (BOOL)enabled {
    return self.userInteractionEnabled;
}

- (void)setHighlighted:(BOOL)highlighted {
    if(highlighted) _currentState = UIControlStateHighlighted;
    else _currentState = UIControlStateNormal;
    [self refresh];
}

- (BOOL)isHighlighted {
    return (_currentState == UIControlStateHighlighted);
}

- (void)setSelected:(BOOL)selected {
    if(selected) _currentState = UIControlStateSelected;
    else _currentState = UIControlStateNormal;
    [self refresh];
}

- (BOOL)selected {
    return (_currentState == UIControlStateSelected);
}

//color management

//background
- (void)setBackgroundColor:(UIColor *)_backgroundColor forState:(UIControlState)_state {
    if (_backgroundStates == nil) _backgroundStates = [NSMutableDictionary dictionary];
    [_backgroundStates setObject:_backgroundColor forKey:[NSNumber numberWithInt:_state]];
    
    [self refresh];
}

- (UIColor*)backgroundColorForState:(UIControlState)_state {
    return [_backgroundStates objectForKey:[NSNumber numberWithInt:_state]];
}

//text
- (void)setTitleColor:(UIColor *)_textColor forState:(UIControlState)_state {
    if (_textStates == nil) _textStates = [NSMutableDictionary dictionary];
    [_textStates setObject:_textColor forKey:[NSNumber numberWithInt:_state]];
    
    [self refresh];
}

- (UIColor*)titleColorForState:(UIControlState)_state {
    return [_textStates objectForKey:[NSNumber numberWithInt:_state]];
}

@end
