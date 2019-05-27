//
//  HYBTopToolbar.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBTopToolbar.h"
#import "HYBAppDelegate.h"
#import "UIViewController+Navigation.h"
#import "HYBDrawerController.h"
#import "HYBBadgeView.h"
#import "HYBCart.h"
#import "MYEnvironmentConfig.h"
#import "MYEnvironmentConfig+HYBAdditionalMethods.h"
#import "DDLog.h"
#import "HYBConstants.h"
#import "HYBB2CService.h"
#import "HYBSettingsViewController.h"

@interface HYBTopToolbar ()

@property (nonatomic) UIImageView *hambugerButtonView;
@property (nonatomic) UIImageView *logoView;
@property (nonatomic) UIImageView *scanButtonView;
@property (nonatomic) UIImageView *searchButtonView;
@property (nonatomic) HYBBadgeView *cartBadgeView;
@property (nonatomic) UIImageView *feedbackButtonView;

//search
@property (nonatomic) BOOL isSearchOpen;
@property (nonatomic) UIView *searchContainer;
@property (nonatomic) UILabel *searchCancelLabel;

@end

@implementation HYBTopToolbar

- (id)initWithFrame:(CGRect)frame {
    
    if(self = [super initWithFrame:frame]) {
        self.accessibilityIdentifier = @"ACCESS_TOPTOOLBAR";
        [self setup];
        [self updateCart];
    }
    
    return self;
}

-(void)setup {
    
    //vars
    _isSearchOpen = NO;
    
    //left hand corner elements
    
    self.backgroundColor = topToolbar_background;
    
    //hambuger button
    _hambugerButtonView = [[UIImageView alloc] initWithImage:[self hambugerButtonImage]];
    _hambugerButtonView.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_MENU";
    _hambugerButtonView.userInteractionEnabled = YES;
    
    //hambuger action
    UITapGestureRecognizer *toggleMenuGesture = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                        action:@selector(hambugerButtonAction)];
    [_hambugerButtonView addGestureRecognizer:toggleMenuGesture];
    
    //logo
    _logoView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"Logo.png"]];
    _logoView.accessibilityIdentifier = @"ACCESS_TOPNAV_IMAGE";
    
    //pack up left payload
    self.leftItems = [NSArray arrayWithObjects:_hambugerButtonView, _logoView, nil];
    
    //---------------//
    
    //right hand corner elements
    
    //scan button
    _scanButtonView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"B2BIcon_Scan.png"]];
    _scanButtonView.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_SCAN";
    _scanButtonView.userInteractionEnabled = YES;
    
    //scan action
    UITapGestureRecognizer *scanIconTapped = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                     action:@selector(scanIconTapped)];
    [_scanButtonView addGestureRecognizer:scanIconTapped];

    //search button
    _searchButtonView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"B2BIcon_search.png"] highlightedImage:[UIImage imageNamed:@"B2BIcon_search_on.png"]];
    _searchButtonView.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_SEARCH";
    _searchButtonView.userInteractionEnabled = YES;
    
    //search action
    UITapGestureRecognizer *searchIconTapped = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                       action:@selector(searchIconTapped:)];
    [_searchButtonView addGestureRecognizer:searchIconTapped];
    
    //cart badged button
    _cartBadgeView = [HYBBadgeView badgeViewWithBackgroundImageNamed:@"B2BIcon_cart.png"];
    _cartBadgeView.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_CART";
    _cartBadgeView.userInteractionEnabled = YES;
    _cartBadgeView.badgeOffset = CGPointMake(0, -10);
    
    _cartBadgeView.badgeBackgroundColor = badge_background;
    _cartBadgeView.badgeTextColor  = badge_text;
    
    [self observeCartUpdates];
    
    //cart button action
    UITapGestureRecognizer *cartIconTapped = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                     action:@selector(cartIconTapped)];
    [_cartBadgeView addGestureRecognizer:cartIconTapped];
    
    //feedback button
    
    _feedbackButtonView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"B2BIcon_feedback.png"]];
    _feedbackButtonView.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_FEEDBACK";
    _feedbackButtonView.userInteractionEnabled = YES;
    
    //search action
    UITapGestureRecognizer *feedbackButtonTapped = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                           action:@selector(feedbackButtonTapped)];
    [_feedbackButtonView addGestureRecognizer:feedbackButtonTapped];
    
    
    //pack up initial right payload
    self.rightItems = [NSArray arrayWithObjects:_scanButtonView, _searchButtonView, _cartBadgeView,_feedbackButtonView, nil];
    
    
    //create search panel
    
    _searchCancelLabel = [UILabel new];
    _searchCancelLabel.text = NSLocalizedString(@"search_cancel", nil);
    _searchCancelLabel.textColor = searchbar_cancel_color;
    _searchCancelLabel.font = font_medium;
    _searchCancelLabel.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_FIELD_CANCEL";
    [_searchCancelLabel sizeToFit];
    
    //cancel action
    UITapGestureRecognizer *tapCancel = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(toggleSearch)];
    _searchCancelLabel.userInteractionEnabled = YES;
    [_searchCancelLabel addGestureRecognizer:tapCancel];
    
    _searchField = [UITextField new];
    _searchField.borderStyle = UITextBorderStyleRoundedRect;
    _searchField.frame = CGRectMake(0, 0, [self bW]/2, [self bH]/2);
    _searchField.clearButtonMode    = UITextFieldViewModeAlways;
    _searchField.returnKeyType      = UIReturnKeySearch;
    _searchField.borderStyle        = UITextBorderStyleRoundedRect;
    _searchField.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_FIELD";
    _searchField.delegate = self;
    
    _searchContainer = [UIView new];
    _searchContainer.frame = CGRectMake(0, 0, [_searchField bW]+ [_searchCancelLabel bW] + 10.f, [self bH]/2);
    _searchContainer.clipsToBounds = YES;
    
    _searchCancelLabel.center = CGPointMake([_searchContainer bW] - [_searchCancelLabel bW]/2, [_searchContainer bH]/2);
    _searchField.center = CGPointMake([_searchField bW]/2, [_searchContainer bH]/2);
    
    [_searchContainer addSubview:_searchField];
    [_searchContainer addSubview:_searchCancelLabel];
}


//cart update manager

- (void)updateCart {
    HYBCart *cart = [[self backEndService] currentCartFromCache];
    if (_cartBadgeView && cart) _cartBadgeView.value = [cart.totalUnitCount stringValue];
}

- (void)observeCartUpdates {
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(updateCart)
                                                 name:NOTIFICATION_CART_UPDATED
                                               object:[self backEndService]];
}

- (void)dealloc {
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}

//utilities
- (UIImage *)hambugerButtonImage {
    CGFloat border = 44.f;
    CGFloat padding = border*.1;
    
    UIGraphicsBeginImageContextWithOptions(CGSizeMake(border, border), NO, 0);
    
    CGFloat thickness = 4.f;
    
    UIBezierPath *topBarPath    = [UIBezierPath bezierPathWithRect:CGRectMake(padding, padding*1.25+thickness/2         , border-2*padding, thickness)];
    UIBezierPath *middleBarPath = [UIBezierPath bezierPathWithRect:CGRectMake(padding, border/2                         , border-2*padding, thickness)];
    UIBezierPath *bottomBarPath = [UIBezierPath bezierPathWithRect:CGRectMake(padding, border-padding*1.25-thickness/2  , border-2*padding, thickness)];
    
    [[UIColor whiteColor] setFill];
    
    [topBarPath     fill];
    [middleBarPath  fill];
    [bottomBarPath  fill];
    
    UIImage *drawerButtonImage = UIGraphicsGetImageFromCurrentImageContext();
    
    UIGraphicsEndImageContext();
    
    return drawerButtonImage;
}


#pragma mark actions

- (void)cartIconTapped {
    
    //toggle cart drawer (right side)
    
    [self resignActiveResponder];
    
    if([self drawerController].openSide == MMDrawerSideLeft) {
        [[self drawerController] closeDrawersIfNeededWithCompletionBlock:^(BOOL done) {
            [[self drawerController] toggleDrawerSide:MMDrawerSideRight animated:YES completion:nil];
        }];
    } else {
        [[self drawerController] toggleDrawerSide:MMDrawerSideRight animated:YES completion:nil];
    }
}

- (void)scanIconTapped {
    [self resignActiveResponder];
    
    if([self drawerController].openSide != MMDrawerSideNone) {
        [[self drawerController] closeDrawersIfNeededWithCompletionBlock:^(BOOL done) {
            [[[self drawerController] centerViewController] openScanner];
        }];
    } else {
        [[[self drawerController] centerViewController] openScanner];
    }
}

- (void)searchIconTapped:(UITapGestureRecognizer*)sender {
    [self closeDrawersIfNeeded];
    [self toggleSearch];
}


- (void)feedbackButtonTapped {
    HYBSettingsViewController *settingsVC = [[HYBSettingsViewController alloc] initWithBackEndService:[self backEndService]];
    [[self drawerController] presentViewController:settingsVC animated:YES completion:nil];
}

#pragma mark search

- (void)closeSearchIfNeeded {
    if(_isSearchOpen) {
        _isSearchOpen = NO;
        [self displaySearch:_isSearchOpen animated:YES];
    }
}

- (void)toggleSearch {
    _isSearchOpen = !_isSearchOpen;
    [self displaySearch:_isSearchOpen animated:YES];
}

- (void)displaySearch:(BOOL)display animated:(BOOL)animated {
    
    @weakify(self);
    if(animated) {
        [self setRightItemsViewHidden:YES
                           completion:^() {
                               @strongify(self);
                               [self swapDisplay:display];
                           }];
    } else {
        [self swapDisplay:display];
    }
}

- (void)swapDisplay:(BOOL)display {
    if(display) {
        [_searchField becomeFirstResponder];
        self.rightItems = [NSArray arrayWithObject:_searchContainer];
    } else {
        [_searchField resignFirstResponder];
        self.rightItems = [NSArray arrayWithObjects:_scanButtonView, _searchButtonView, _cartBadgeView, nil];
        [self clearSearch];
    }
}

- (void)clearSearch {
    _searchString = nil;
    _searchField.text = _searchString;
    [self removeSearchResults];
}

- (void)removeSearchResults {
    if(_searchDelegate && [_searchDelegate respondsToSelector:@selector(cancelSearch)]) {
        DDLogDebug(@"Remove Search Results");
        [_searchDelegate cancelSearch];
    }
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    
    _searchString = textField.text;
    
    [self doSearch];
    
    [textField resignFirstResponder];
    
    return NO;
}

- (void)doSearch {
    if(_searchDelegate && [_searchDelegate respondsToSelector:@selector(performSearchForString:)]) {
        DDLogDebug(@"Regular Search");
        [_searchDelegate performSearchForString:_searchString];
    }
}

#pragma mark bridge
- (HYBAppDelegate *)getDelegate {
    return (HYBAppDelegate *)[[UIApplication sharedApplication] delegate];
}

- (id)backEndService {
    return [[self getDelegate] backEndService];
}

- (HYBDrawerController*)drawerController {
    return (HYBDrawerController*)[self getDelegate].window.rootViewController;
}

- (void)hambugerButtonAction {
    //close search
    [self closeSearchIfNeeded];
    
    //close drawer
    [self toggleLeftDrawer];
}

- (void)toggleLeftDrawer {
    if([self drawerController].openSide == MMDrawerSideRight) {
        [[self drawerController] closeDrawersIfNeededWithCompletionBlock:^(BOOL done) {
            [[self drawerController] toggleDrawerSide:MMDrawerSideLeft animated:YES completion:nil];
        }];
    } else {
        [[self drawerController] toggleDrawerSide:MMDrawerSideLeft animated:YES completion:nil];
    }
}

- (void)closeDrawersIfNeeded {
    [[self drawerController] closeDrawersIfNeeded];
}

- (void)resignActiveResponder {
    [[self drawerController] resignActiveResponder];
}

- (void)checkPageDismiss {
    [[self drawerController] checkPageDismiss];
}

@end
