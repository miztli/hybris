//
//  HYBActionButton.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBActionButton.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

@interface HYBActionButton ()
@property (nonatomic) NSMutableDictionary *backgroundStates;
@end

@implementation HYBActionButton

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

//setup default colors
- (void)setup {
    
    [self setTitleColor:button_default_text forState:UIControlStateNormal];
    [self setTitleColor:button_default_text forState:UIControlStateHighlighted];
    [self setTitleColor:button_default_text forState:UIControlStateDisabled];
    [self setTitleColor:button_default_text forState:UIControlStateSelected];
    
    [self setBackgroundColor:button_default_background      forState:UIControlStateNormal];
    [self setBackgroundColor:button_hilighted_background    forState:UIControlStateHighlighted];
    [self setBackgroundColor:button_disabled_background     forState:UIControlStateDisabled];
    [self setBackgroundColor:button_selected_background     forState:UIControlStateSelected];

}

//toggle
- (BOOL)toggle {
    if (self.type == checkbox) {
        self.selected = !self.selected;
        [self refresh];
        return self.selected;
    }
    
    return NO;
}

//state management
- (void)refresh {
    self.backgroundColor = [self backgroundColorForState:[self state]];
}

- (void)setEnabled:(BOOL)enabled {
    [super setEnabled:enabled];
    [self refresh];
}

- (void)setHighlighted:(BOOL)highlighted {
    [super setHighlighted:highlighted];
    [self refresh];
}

- (void)setSelected:(BOOL)selected {
    [super setSelected:selected];
    [self refresh];
}

//color management
- (void)setBackgroundColor:(UIColor *) _backgroundColor forState:(UIControlState)_state {
    if (_backgroundStates == nil) _backgroundStates = [NSMutableDictionary dictionary];
    [_backgroundStates setObject:_backgroundColor forKey:[NSNumber numberWithInt:_state]];
    
    [self refresh];
}

- (UIColor*)backgroundColorForState:(UIControlState)_state {
    return [_backgroundStates objectForKey:[NSNumber numberWithInt:_state]];
}


@end
