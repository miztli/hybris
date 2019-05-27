//
//  HYBProductDetailsController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
#import "HYBProductDetailsController.h"

#import "HYBCart.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBProductDetailsView.h"

@interface HYBProductDetailsController ()

@property (nonatomic) HYBProductDetailsView *mainView;

@end

@implementation HYBProductDetailsController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService productId:(NSString *)selectedProductId {
    
    if (self = [super initWithBackEndService:backendService]) {
        _code = selectedProductId;
    }
    return self;
}

//lock swipe back navigation gesture to let the drawers work
- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
    
    //mask tap dismiss pickers
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [_mainView.maskView addGestureRecognizer:tapRecognizer];
    
    self.navigationController.interactivePopGestureRecognizer.enabled = NO;
}

- (void)viewWillDisappear:(BOOL)animated {
    [super viewWillDisappear:animated];
    self.navigationController.interactivePopGestureRecognizer.enabled = YES;
}

- (void)refresh {
    DDLogDebug(@"HYBProductInfosController refresh");
    
    if(_mainView) {
        [_mainView refreshWithProduct:_product];
        [self loadAllProductImages];
    }
}

- (void)loadAllProductImages {
    [self.backendService loadImagesForProduct:_product
                                    andExecute:^(NSArray *fetchedImages, NSError *error) {
        if (error) {
            DDLogError(@"Can not retrieve images for product %@ - %@", _product.code, [error localizedDescription]);
        } else {
            DDLogDebug(@"Retrieved %lu images, starting controller images init...", (unsigned long) [fetchedImages count]);
            [_mainView displayProductsImages:fetchedImages];
        }
    }];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    if (!_mainView) {
        _mainView = [[HYBProductDetailsView alloc] initWithFrame:self.view.frame];
        _mainView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    }
    
    self.view = _mainView;
    
    //close button action
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                 action:@selector(backButtonPressed)];
    
    [_mainView.closeIcon addGestureRecognizer:tapGesture];
    
    _mainView.imagesScrollView.delegate = self;
    _mainView.imagesScrollView.pagingEnabled = YES;
    
    [_mainView.imagesScrollControl addTarget:self
                                      action:@selector(pageControlTapped)
                            forControlEvents:UIControlEventValueChanged];
    
    [_mainView.addToCartButton addTarget:self
                                  action:@selector(addToCartPressed)
                        forControlEvents:UIControlEventTouchUpInside];
    

    [_mainView.variantSelectionDoneButton addTarget:self
                                             action:@selector(variantSelectionDonePressed)
                                   forControlEvents:UIControlEventTouchUpInside];
    
    [_mainView.variantSelectionCancelButton addTarget:self
                                               action:@selector(dismissPicker)
                                     forControlEvents:UIControlEventTouchUpInside];    

    
    [self loadProduct];
    
    //keyboard monitor
    NSNotificationCenter *center = [NSNotificationCenter defaultCenter];
    
    [center addObserver:self selector:@selector(keyboardDidShow:)
                   name:UIKeyboardDidShowNotification
                 object:nil];
    
    [center addObserver:self selector:@selector(keyboardWillHide:)
                   name:UIKeyboardWillHideNotification
                 object:nil];
}

- (void)loadProduct {
    DDLogDebug(@"Loading product with code %@", _code);
    [self.backendService getProductForCode:_code
                           andExecute:^(HYBProduct *product, NSError *error) {
                               if (error) {
                                   DDLogError(@"Error while retrieving product with code %@, reason:", [error localizedDescription]);
                               } else {
                                   DDLogDebug(@"Product loaded %@", [product name]);
                                   _product = product;
                                   [self refresh];
                               }
                           }];
}

//Actions

- (void)dismissPicker {
    [_mainView hideVariantPicker];
}

- (void)variantSelectionDonePressed {
    DDLogDebug(@"Variant Selection done pressed.");
    
    [self dismissPicker];
    
    NSString *newSelectedProductCode = _mainView.selectedVariantCode;
    if (newSelectedProductCode) {
        _code = newSelectedProductCode;
        DDLogDebug(@"New variant code was set to %@", _code);
        [self loadProduct];
    }
}

- (void)backButtonPressed {
    DDLogDebug(@"Navigating back to the categories ...");
    [self.navigationController popViewControllerAnimated:NO];
}

- (void)scrollViewDidScroll:(UIScrollView *)scrollView {
    if (scrollView == _mainView.imagesScrollView) {
        CGFloat pageWidth = _mainView.imagesScrollView.frame.size.width;
        NSInteger newCurrent = (NSInteger) floor((_mainView.imagesScrollView.contentOffset.x * 2.0f + pageWidth) / (pageWidth * 2.0f));
        _mainView.imagesScrollControl.currentPage = newCurrent;
    }
}

- (void)pageControlTapped {
    CGFloat pageWidth = _mainView.imagesScrollView.frame.size.width;
    CGPoint scrollTo = CGPointMake(pageWidth * _mainView.imagesScrollControl.currentPage, 0);
    [_mainView.imagesScrollView setContentOffset:scrollTo animated:YES];
}

- (void)addToCartPressed {
    DDLogDebug(@"Adding items to cart");
    
    NSNumber *amountToAdd = [_mainView quantity];
    
    if (amountToAdd.intValue > 0) {
        if (amountToAdd.intValue > [_product.stock.stockLevel intValue]) {
            amountToAdd = [[NSNumber alloc] initWithInt:[_product.stock.stockLevel intValue]];
        }
        
        [[self backendService] addProductToCurrentCart:_product.code
                                                amount:amountToAdd
                                            andExecute:^(HYBCart *cart, NSError *error) {
            if ([cart hyb_isNotBlank]) {
                [_mainView setQuantity:@"1"];
            } else {
                DDLogError(@"Product %@ not added to cart. Reason is %@", _product.code, error.localizedDescription);
            }
            [self showNotifyMessage:error.localizedDescription];
        }];
    }
}

//keyboard manager

- (void)dismissKeyboard {
    [[self.view findFirstResponder] resignFirstResponder];
}

- (void)keyboardDidShow:(NSNotification *)notification {
    
    [_mainView showMaskView];

    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    CGPoint nextPoint = CGPointMake(0, 50);
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        nextPoint = CGPointMake(0, 260);
    }
    
    [UIView animateWithDuration:defaultAnimationDuration/2
                     animations:^() {
                         _mainView.contentView.contentOffset = nextPoint;
                     }];
}

- (void)keyboardWillHide:(NSNotification *)notification {
    
    [_mainView hideMaskView];
    
    [UIView animateWithDuration:defaultAnimationDuration/2
                     animations:^() {
                         _mainView.contentView.contentOffset = CGPointMake(0, 0);
                     }];
}

#pragma mark search delegate

- (void)performSearchForString:(NSString *)searchString {
    [super performSearchForString:searchString];
}
/*
 - (void)searchbar:(HYBSearchbar*)searchbar didUpdateSearchBarFrameAnimated:(BOOL)animated {
 [super searchbar:searchbar didUpdateSearchBarFrameAnimated:YES];
 }
 
 - (void)searchbar:(HYBSearchbar*)searchbar didTapDidYouMeanWithQuery:(NSString*)query {
 [super searchbar:searchbar didTapDidYouMeanWithQuery:query];
 }
 */
@end