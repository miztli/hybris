//
//  HYBProductDetailsView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBProductDetailsView.h"

#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "HYBZoomView.h"
#import "NSObject+HYBAdditionalMethods.h"


#define TAG_OFFSET 1234951

#define TAG_PRODUCT_DETAILS_TITLE       35600
#define TAG_PRODUCT_DETAILS_CONTENT     35601

#define TAG_PRODUCT_DELIVERY_TITLE      35602
#define TAG_PRODUCT_DELIVERY_CONTENT    35603

#define TAG_PRODUCT_REVIEWS_TITLE       35604
#define TAG_PRODUCT_REVIEWS_CONTENT     35605

CGFloat variableHeight;
CGFloat padding = -14.f;

@interface HYBProductDetailsView ()

@property (nonatomic) HYBProduct *currentProduct;
@property (nonatomic) UIView *topPanel;
@property (nonatomic) NSArray *sortedImagesArray;

//tabs management
@property (nonatomic) UITableView  *tabsTable;
@property (nonatomic) NSArray      *tableContent;
@property (nonatomic) NSArray      *visibleTableContent;
@property (nonatomic) NSMutableDictionary *tableCellsCacheDict;

//variants
@property (nonatomic) UIView         *variantsMaskView;
@property (nonatomic) NSMutableArray *variantSelectionButtons;
@property (nonatomic) NSArray        *currentVariantsMatrix;
@property (nonatomic) NSDictionary   *selectedVariantsDict;
@property (nonatomic) UIView         *variantValuePickerPanel;
@property (nonatomic) UIPickerView   *variantValuePicker;

@end

@implementation HYBProductDetailsView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
        _selectedVariantsDict = [NSDictionary dictionary];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.025;
    CGFloat lineHeight = 18.f;
    
    _maskView.frame = self.frame;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 14.f;
    }
    
    _topPanel.frame = CGRectMake([self bX],
                                 defaultTopMargin ,
                                 [self bW],
                                 defaultTopMargin);
    
    _closeIcon.center = CGPointMake([_closeIcon bW]/2+margin,
                                    [_topPanel bH]/2);
    
    
    [_productNameLabel sizeToFit];
    _productNameLabel.center = CGPointMake([_closeIcon right] + [_productNameLabel bW]/2 + margin,
                                           [_productNameLabel bH]/2+margin);
    
    [_productCodeLabel sizeToFit];
    _productCodeLabel.center = CGPointMake([_closeIcon right] + [_productCodeLabel bW]/2 + margin,
                                           [_productNameLabel bottom] + [_productCodeLabel bH]/2);
    
    
    _contentView.frame = CGRectMake([self bX],
                                    [_topPanel bottom],
                                    [self bW],
                                    [self bH] - [_topPanel bottom]);
    
    
    _imagesScrollView.frame = CGRectMake(margin,
                                         margin,
                                         [self bW]-2*margin,
                                         [self bH]/3);
    
    [self displayProductsImages:_sortedImagesArray];
    
    _imagesScrollControl.frame = CGRectMake(margin,
                                            [_imagesScrollView bottom] + lineHeight/2,
                                            [self bW]-2*margin,
                                            lineHeight*2);
    
    [_productPriceLabel sizeToFit];
    _productPriceLabel.center = CGPointMake([_productPriceLabel bW]/2 + margin,
                                            [_imagesScrollControl bottom] + [_productCodeLabel bH]/2);
    
    if(_volumePricingButton) {
        _volumePricingButton.frame = CGRectMake(0,
                                                0,
                                                [_contentView bW]/5,
                                                lineHeight*2);
        
        _volumePricingButton.center = CGPointMake([_productPriceLabel right] + [_volumePricingButton bW]/2 + margin,
                                                  _productPriceLabel.center.y);
    }
    
    if(_priceMatrix) {
        _priceMatrix.center = CGPointMake ([_productPriceLabel left]    + [_priceMatrix bW]/2,
                                           [_productPriceLabel bottom] - padding + [_priceMatrix bH]/2);
    }
    
    
    int nbOfLines = [self numberOfLinesInTextView:_summaryTextView];
    
    if (nbOfLines > 5) nbOfLines = 5;
    
    _summaryTextView.frame = CGRectMake(margin,
                                        [_productPriceLabel bottom] + lineHeight,
                                        [self bW]-2*margin,
                                        lineHeight*2*nbOfLines);
    
    if (_currentProduct.multidimensional) {
        _variantButtonsPanel.frame = CGRectMake(margin,
                                                [_summaryTextView bottom] + lineHeight,
                                                [_contentView bW] - margin*2,
                                                lineHeight*3);
        
        int subviewsCount = (int)[[_variantButtonsPanel subviews] count];
        int count = 0;
        
        for (UIView *view in [_variantButtonsPanel subviews]) {
            
            CGFloat baseWidth = [_variantButtonsPanel bW] / subviewsCount - margin;
            
            view.frame = CGRectMake((baseWidth + margin)*count++,
                                    0,
                                    baseWidth,
                                    lineHeight*3);
            
        }
        
    } else {
        _variantButtonsPanel.frame = CGRectMake(margin,
                                                [_summaryTextView bottom] + lineHeight,
                                                0,
                                                0);
    }
    
    _quantityPanel.frame = CGRectMake(margin,
                                      [_variantButtonsPanel bottom] + lineHeight,
                                      [_contentView bW] - margin*2,
                                      lineHeight*3);
    
    [_availabilityLabel sizeToFit];
    _availabilityLabel.center = CGPointMake([_availabilityLabel bW]/2,
                                            [_quantityPanel bH]/2);
    
    
    _quantityInputField.frame = CGRectMake(0,
                                           0,
                                           [_quantityPanel bW]/7,
                                           lineHeight*2);
    
    _quantityInputField.center = CGPointMake([_quantityPanel bW]/2,
                                             [_quantityPanel bH]/2);
    
    [_quantityLabel sizeToFit];
    _quantityLabel.center = CGPointMake([_quantityInputField left] -  [_quantityLabel bW]/2 - margin,
                                        [_quantityPanel bH]/2);
    
    
    [_totalItemPrice sizeToFit];
    _totalItemPrice.center = CGPointMake([_quantityInputField right] + [_totalItemPrice bW]/2 + margin,
                                         [_quantityPanel bH]/2);
    
    
    _addToCartButton.frame = CGRectMake(margin,
                                        [_quantityPanel bottom] + lineHeight,
                                        [_contentView bW] - margin*2,
                                        lineHeight*3);
    
    _tabsTable.frame = CGRectMake(margin,
                                  [_addToCartButton bottom] + margin,
                                  [_contentView bW] - margin*2,
                                  lineHeight);
    
    
    _tableCellsCacheDict = [NSMutableDictionary dictionary];
    
    [self updateVisibleTableContent];
}

- (void)setup {
    
    self.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS";
    
    //mask
    
    _maskView = [UIView new];
    _maskView.backgroundColor = hybris_clear;
    _maskView.alpha = 0.8;
    _maskView.hidden = YES;
    
    //top panel (fixed)
    
    _topPanel = [UIView new];
    _topPanel.userInteractionEnabled = YES;
    _topPanel.backgroundColor = product_details_header_background;
    
    _closeIcon = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"Close_Icon.png"]];
    _closeIcon.contentMode = UIViewContentModeScaleAspectFit;
    _closeIcon.userInteractionEnabled = YES;
    _closeIcon.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_BACK";
    
    _productNameLabel = [UILabel new];
    _productNameLabel.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_TITLE";
    _productNameLabel.font = product_details_font_header_product_name;
    _productNameLabel.textColor = product_details_header_product_name;
    
    _productCodeLabel = [UILabel new];
    _productCodeLabel.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_CODE";
    _productCodeLabel.font = product_details_font_header_product_code;
    _productCodeLabel.textColor = product_details_header_product_code;
    
    
    //scrolling content
    
    _contentView = [UIScrollView new];
    _contentView.backgroundColor = product_details_background;
    _contentView.userInteractionEnabled = YES;
    
    
    //product images
    
    _imagesScrollView       = [UIScrollView new];
    _imagesScrollView.pagingEnabled = YES;
    _imagesScrollView.showsHorizontalScrollIndicator = NO;
    
    _imagesScrollControl    = [UIPageControl new];
    _imagesScrollControl.pageIndicatorTintColor = product_details_default_image_bullet;
    _imagesScrollControl.currentPageIndicatorTintColor = product_details_current_image_bullet;
    
    
    //price
    _productPriceLabel = [UILabel new];
    _productPriceLabel.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_PRICE";
    _productPriceLabel.font = product_details_font_price;
    _productPriceLabel.textColor = product_details_price;
    
    
    //summary
    
    _summaryTextView = [UITextView new];
    _summaryTextView.editable = NO;
    _summaryTextView.contentInset = UIEdgeInsetsMake(0,-4,0,-4);
    _summaryTextView.textAlignment = NSTextAlignmentLeft;
    _summaryTextView.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_SUMMARY";
    _summaryTextView.font = product_details_font_summary;
    _summaryTextView.textColor = product_details_summary;
    
    
    //variants
    
    _variantButtonsPanel = [UIView new];
    _variantSelectionCancelButton   = [HYBActionButton new];
    _variantSelectionDoneButton     = [HYBActionButton new];
    
    //quantityPanel
    
    _quantityPanel = [UIView new];
    
    _availabilityLabel = [UILabel new];
    _availabilityLabel.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_STOCK";
    _availabilityLabel.font = product_details_font_availability;
    
    _quantityLabel = [UILabel new];
    _quantityLabel.text = NSLocalizedString(@"QTY", nil);
    _quantityLabel.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_QTY";
    _quantityLabel.textColor = product_details_quantity;
    _quantityLabel.font = product_details_font_quantity;
    
    _quantityInputField = [UITextField new];
    _quantityInputField.text = @"1";
    _quantityInputField.keyboardType = UIKeyboardTypeNumberPad;
    _quantityInputField.borderStyle = UITextBorderStyleRoundedRect;
    _quantityInputField.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_AMT";
    _quantityInputField.delegate = self;
    _quantityInputField.backgroundColor = product_details_quantity_input_background;
    _quantityInputField.textColor = product_details_quantity_input;
    _quantityInputField.font = product_details_font_quantity_input;
    
    [self.quantityInputField addTarget:self
                                action:@selector(calculateTotalPrice)
                      forControlEvents:UIControlEventEditingChanged];
    
    _totalItemPrice = [UILabel new];
    _totalItemPrice.text = @"0";
    _totalItemPrice.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_TOTAL";
    _totalItemPrice.textColor = product_details_total_price;
    _totalItemPrice.font = product_details_font_total_price;
    
    
    //add button
    
    _addToCartButton = [HYBActionButton new];
    [_addToCartButton setTitle:NSLocalizedString(@"product_details_buttons_add_to_cart", nil) forState:UIControlStateNormal];
    _addToCartButton.enabled = NO;
    _addToCartButton.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_ATC";
    
    
    //tabs table
    
    _tabsTable = [UITableView new];
    _tabsTable.delegate     = self;
    _tabsTable.dataSource   = self;
    
    _tabsTable.scrollEnabled    = NO;
    
    _tabsTable.contentInset     = UIEdgeInsetsZero;
    _tabsTable.separatorInset   = UIEdgeInsetsZero;
    
    _tabsTable.separatorStyle   = UITableViewCellSeparatorStyleNone;
    
    //initial frame
    _tabsTable.frame = CGRectZero;
    
    //pile up
    
    [_topPanel addSubview:_productNameLabel];
    [_topPanel addSubview:_productCodeLabel];
    [_topPanel addSubview:_closeIcon];
    
    [self addSubview:_topPanel];
    
    [_contentView addSubview:_imagesScrollView];
    [_contentView addSubview:_imagesScrollControl];
    
    [_contentView addSubview:_productPriceLabel];
    
    [_contentView addSubview:_summaryTextView];
    
    [_contentView addSubview:_variantButtonsPanel];
    
    [_quantityPanel addSubview:_availabilityLabel];
    [_quantityPanel addSubview:_quantityLabel];
    [_quantityPanel addSubview:_quantityInputField];
    [_quantityPanel addSubview:_totalItemPrice];
    
    [_contentView addSubview:_quantityPanel];
    
    [_contentView addSubview:_addToCartButton];
    
    [_contentView addSubview:_tabsTable];
    
    [self addSubview:_contentView];
}

- (void)refreshWithProduct:(HYBProduct*)product {
    _currentProduct = product;
    
    _productNameLabel.text      = _currentProduct.name;
    _productCodeLabel.text      = _currentProduct.code;
    
    _productPriceLabel.text     = _currentProduct.price.formattedValue;
    _summaryTextView.text       = _currentProduct.summary;
    
    _availabilityLabel.text     = [NSString stringWithFormat:NSLocalizedString(@"%d in stock", nil), [_currentProduct.stock.stockLevel integerValue]];
    
    if (_currentProduct.lowStock) _availabilityLabel.textColor = product_details_low_stock;
    else _availabilityLabel.textColor = product_details_availability;
    
    _addToCartButton.enabled = ([product.stock.stockLevel intValue] > 0);
    
    [self configPricingPanelForProduct:product];
    [self calculateTotalPrice];
    [self buildUpVariants];
    [self prepareTabs];
    
    [self layoutSubviews];
}

#pragma mark - tap dismiss

- (void)showMaskView {
    _maskView.hidden = NO;
    [self addSubview:_maskView];
}

- (void)hideMaskView {
    _maskView.hidden = YES;
    [_maskView removeFromSuperview];
}

#pragma mark - Variants Methods (Picker View for Variants)

//recursively browse products variants, looking for matching product code

-(void)recursivePreselectionVariants {
    [self isChildOfVariant:_currentProduct.variantMatrix depth:0];
}

-(void)isChildOfVariant:(NSArray*)variantElements depth:(int)depth {
    
    NSString *lookupCode = _currentProduct.code;
    
    int idx = 0;
    
    for (HYBVariantMatrixElement *childVariant in variantElements) {
        if([childVariant.variantOption.code isEqualToString:lookupCode]) {
            depth++;
            [self isChildOfVariant:childVariant.elements depth:depth];
            
            NSMutableDictionary *tempDict = [NSMutableDictionary dictionaryWithDictionary:_selectedVariantsDict];
            [tempDict setValue:[NSNumber numberWithInt:idx] forKey:[NSString stringWithFormat:@"%d",depth-1]];
            [self setSelectedVariantsDict:[NSDictionary dictionaryWithDictionary:tempDict]];
            
            break;
        }
        idx++;
    }
    
}

- (void)buildUpVariants {
    
    //find the currently selected item based on product code and prefill the values
    [self recursivePreselectionVariants];
    
    //get current variant
    _currentVariantsMatrix = [self variantsAsMatrix];
    
    if ([_currentVariantsMatrix hyb_isNotBlank]) {
        self.variantSelectionButtons = [NSMutableArray array];
        
        [_variantButtonsPanel removeSubviews];
        
        for (int j = 0; j < _currentVariantsMatrix.count; j++) {
            
            NSString *buttonTitle = nil;
            
            NSString *key = [NSString stringWithFormat:@"%d",j];
            NSNumber *selectedRow = _selectedVariantsDict[key];
            
            if(selectedRow) {
                buttonTitle = [[_currentVariantsMatrix[j] objectAtIndex:[selectedRow intValue]] variantValueCategory].name;
            } else {
                buttonTitle = [[_currentVariantsMatrix[j] firstObject] parentVariantCategory].name;
            }
            
            HYBDropDownButton *variantButton = [HYBDropDownButton new];
            [variantButton setText:buttonTitle];
            
            NSString *buttonAccessId = [NSString stringWithFormat:@"%@_%d", @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_VARIANTS_BUTTON", j];
            variantButton.accessibilityIdentifier = buttonAccessId;
            
            [_variantButtonsPanel addSubview:variantButton];
            [_variantSelectionButtons addObject:variantButton];
            
            [variantButton addTarget:self action:@selector(showVariantPicker)];
        }
        
    }
}

- (NSArray *)variantsAsMatrix {
    NSMutableArray *result = [NSMutableArray array];
    
    if ([_currentProduct.variantMatrix hyb_isNotBlank]) {
        
        NSArray *parentVariantMatrixElements = _currentProduct.variantMatrix;
        
        for (int currentDimension = 0; currentDimension < [_currentProduct variantDimensionsNumber]; currentDimension++) {
            NSString *key = [NSString stringWithFormat:@"%d",currentDimension];
            int index = [self.selectedVariantsDict[key] intValue];
            
            NSArray *siblingVariants = parentVariantMatrixElements;
            [result addObject:siblingVariants];
            parentVariantMatrixElements = [(HYBVariantMatrixElement*)siblingVariants[index] elements];
        }
    }
    
    return result;
}

- (void)hideVariantPicker {
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         _variantValuePickerPanel.frame = CGRectMake(0, CGRectGetMaxY(self.bounds), [self bW], [self bH] * 1 / 3);
                         _variantsMaskView.alpha = 0.f;
                     }
                     completion:^(BOOL finished) {
                         [_variantValuePickerPanel removeFromSuperview];
                         [_variantsMaskView removeFromSuperview];
                         [self buildUpVariants];
                     }
     ];
}


- (void)showVariantPicker {
    float pickerHeight = 216.0;
    
    _variantsMaskView = [[UIView alloc] initWithFrame:self.frame];
    _variantsMaskView.backgroundColor = [UIColor whiteColor];
    _variantsMaskView.alpha = 0.f;
    
    [self addSubview:_variantsMaskView];
    
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(hideVariantPicker)];
    tapRecognizer.numberOfTapsRequired = 1;
    
    [_variantsMaskView addGestureRecognizer:tapRecognizer];
    
    CGFloat pickerPanelHeight = [self bH] * 1 / 3;
    _variantValuePickerPanel = [[UIView alloc] initWithFrame:CGRectMake(0, CGRectGetMaxY(self.bounds), [self bW], pickerPanelHeight)];
    _variantValuePickerPanel.alpha = 0.f;
    _variantValuePickerPanel.backgroundColor = product_details_variant_picker_background;
    [self addSubview:_variantValuePickerPanel];
    
    CGFloat pickerMargin = 30.f;
    
    CGRect pickerFrame = CGRectMake(pickerMargin,
                                    pickerMargin,
                                    [self bW] - 2 * pickerMargin,
                                    pickerHeight);
    
    _variantValuePicker = [[UIPickerView alloc] initWithFrame:pickerFrame];
    _variantValuePicker.dataSource = self;
    _variantValuePicker.delegate = self;
    
    
    if([[_selectedVariantsDict allKeys] count] > 0) {
        //preload previous selection
        
        int nbOfComp = (int)[self numberOfComponentsInPickerView:_variantValuePicker];
        
        for (int i = 0; i < nbOfComp; i++) {
            int preselectedRow = [[_selectedVariantsDict valueForKey:[NSString stringWithFormat:@"%d",i]] intValue];
            [_variantValuePicker selectRow:preselectedRow inComponent:i animated:NO];
        }
    }
    
    //
    CGFloat buttonHeight = 36.f;
    
    CGPoint position = CGPointMake(pickerMargin,
                                   CGRectGetMaxY(_variantValuePickerPanel.bounds)
                                   - buttonHeight - pickerMargin);
    
    
    CGFloat buttonWitdh =  _variantValuePickerPanel.bounds.size.width/2 - position.x * 1.5;
    
    //cancel picker btn
    _variantSelectionCancelButton.frame = CGRectMake(position.x, position.y, buttonWitdh, buttonHeight);
    [_variantSelectionCancelButton setTitle:NSLocalizedString(@"product_details_buttons_cancel_variant", nil) forState:UIControlStateNormal];
    
    [_variantValuePickerPanel addSubview:_variantSelectionCancelButton];
    
    _variantSelectionCancelButton.accessibilityIdentifier = @"ACCESS_VARIANT_PICKER_CANCEL";
    
    // apply picker btn
    _variantSelectionDoneButton.frame = CGRectMake(position.x*2+buttonWitdh, position.y,buttonWitdh, buttonHeight);
    [_variantSelectionDoneButton setTitle:NSLocalizedString(@"product_details_buttons_select_variant", nil) forState:UIControlStateNormal];
    
    _variantSelectionDoneButton.accessibilityIdentifier = @"ACCESS_VARIANT_PICKER_APPLY";
    
    [_variantValuePickerPanel addSubview:_variantSelectionDoneButton];
    [_variantValuePickerPanel addSubview:_variantValuePicker];
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         
                         _variantValuePickerPanel.frame = CGRectMake(0, self.bounds.size.height * 1 / 3, [self bW], pickerPanelHeight);
                         
                         _variantsMaskView.alpha = .8;
                         _variantValuePickerPanel.alpha = 1.f;
                     }];
}

- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView {
    return [_currentVariantsMatrix count];
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component {
    return [(NSArray*)_currentVariantsMatrix[component] count];
}

- (NSString *)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component {
    HYBVariantValueCategory *valueCat = [[_currentVariantsMatrix[component] objectAtIndex:row] variantValueCategory];
    return valueCat.name;
}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component {
    
    [self selectPathWithComponent:component andRow:row];
    
    if (component < _currentProduct.variantDimensionsNumber - 1) {
        
        //not leaf selected, refresh needed for all previous components
        for (int subComponentIndex = (int)component + 1; subComponentIndex < _currentProduct.variantDimensionsNumber; ++subComponentIndex) {
            [pickerView selectRow:0 inComponent:subComponentIndex animated:YES];
            [pickerView reloadComponent:subComponentIndex];
        }
    }
    
    NSString *key = [NSString stringWithFormat:@"%d",_currentProduct.variantDimensionsNumber - 1];
    int lastDimensionRow = [self.selectedVariantsDict[key] intValue];
    
    HYBVariantOption *variantOption = [[_currentVariantsMatrix[_currentProduct.variantDimensionsNumber - 1] objectAtIndex:lastDimensionRow] variantOption];
    
    _selectedVariantCode = variantOption.code;
    
    // set the selected value on the button
    NSString *value = [self pickerView:pickerView titleForRow:row forComponent:component];
    [(HYBDropDownButton*)[self.variantSelectionButtons objectAtIndex:component] setText:value];
    
}

- (void)selectPathWithComponent:(NSInteger)component andRow:(NSInteger)row {
    
    NSMutableDictionary *tmpDict = [NSMutableDictionary dictionaryWithDictionary:self.selectedVariantsDict];
    
    [tmpDict setObject:[NSNumber numberWithInteger:row] forKey:[NSString stringWithFormat:@"%d",(int)component]];
    
    if (component < [[tmpDict allKeys] count] - 1) {
        // set all the following component indexes to 0, since parent has changed
        for (int subComponent = (int)component + 1; subComponent < _currentProduct.variantDimensionsNumber; ++subComponent) {
            [tmpDict setObject:@0 forKey:[NSString stringWithFormat:@"%d",(int)subComponent]];
        }
    }
    
    self.selectedVariantsDict = [NSDictionary dictionaryWithDictionary:tmpDict];
    
    //reload variants
    _currentVariantsMatrix = [self variantsAsMatrix];
}

//tabs

- (void)prepareTabs {
    
    _tableContent = [NSArray arrayWithObjects:
                     
                     //first cell title
                     [NSDictionary dictionaryWithObjectsAndKeys:
                      NSLocalizedString(@"product_details_details", @"Details"),@"content",
                      [NSNumber numberWithInt:TAG_PRODUCT_DETAILS_TITLE],@"tag",
                      @"title",@"status",
                      @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_DETAILS_TITLE",@"accessId",
                      nil],
                     
                     //first cell content
                     [NSDictionary dictionaryWithObjectsAndKeys:
                      [_currentProduct descriptor],@"content",
                      [NSNumber numberWithInt:TAG_PRODUCT_DETAILS_CONTENT],@"tag",
                      @"closed",@"status",
                      @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_DETAILS_CONTENT",@"accessId",
                      nil],
                     
                     //second cell title
                     [NSDictionary dictionaryWithObjectsAndKeys:
                      NSLocalizedString(@"product_details_delivery", @"Delivery"),@"content",
                      [NSNumber numberWithInt:TAG_PRODUCT_DELIVERY_TITLE],@"tag",
                      @"title",@"status",
                      @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_DELIVERY_TITLE",@"accessId",
                      nil],
                     
                     //second cell content
                     [NSDictionary dictionaryWithObjectsAndKeys:
                      @"default_delivery_details",@"content",
                      [NSNumber numberWithInt:TAG_PRODUCT_DELIVERY_CONTENT],@"tag",
                      @"closed",@"status",
                      @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_DELIVERY_CONTENT",@"accessId",
                      nil],
                     
                     nil];
    
}

//quantity accessors
- (NSNumber*)quantity {
    return [[NSNumberFormatter new] numberFromString:_quantityInputField.text];
}

- (void)setQuantity:(NSString *)quantity {
    _quantityInputField.text = quantity;
    [self calculateTotalPrice];
}

// price manager
- (void)calculateTotalPrice {
    
    NSNumber *quantity = [self quantity];
    
    if (quantity) {
        CGFloat unitPrice = 0.f;
        
        if ([_currentProduct.volumePrices hyb_isNotBlank]) {
            for (HYBPrice *price in _currentProduct.volumePrices) {
                
                BOOL selectPrice = NO;
                
                NSNumber *maxQuantity = price.maxQuantity;
                NSNumber *minQuantity = price.minQuantity;
                
                if (minQuantity && maxQuantity) {
                    if ([quantity intValue] >= [minQuantity intValue] && [quantity intValue] <= [maxQuantity intValue]) {
                        selectPrice = YES;
                    }
                } else if (minQuantity && !maxQuantity) {
                    selectPrice = YES;
                }
                
                if(selectPrice) {
                    unitPrice = [price.value doubleValue];
                    _productPriceLabel.text = price.formattedValue;
                    break;
                }
                
            }
        } else {
            unitPrice = [_currentProduct.price.value floatValue];
        }
        
        CGFloat totalPrice = unitPrice * [quantity intValue];
        _totalItemPrice.text = [NSString stringWithFormat:@"%.02f %@", totalPrice, _currentProduct.price.currencyIso];
        
        CGFloat margin = [self bW]*.025;
        
        [_totalItemPrice sizeToFit];
        _totalItemPrice.center = CGPointMake([_quantityInputField right] + [_totalItemPrice bW]/2 + margin,
                                             [_quantityPanel bH]/2);
    }
}

- (void)configPricingPanelForProduct:(HYBProduct*)product {
    
    if(_volumePricingButton != nil) {
        [_volumePricingButton removeFromSuperview];
        _volumePricingButton = nil;
    }
    
    if ([product.volumePrices hyb_isNotBlank]) {
        
        _volumePricingButton = [HYBDropDownButton new];
        [_volumePricingButton setText:NSLocalizedString(@"product_details_volume_pricing", nil)];
        [_volumePricingButton addTarget:self
                                 action:@selector(toggleVolumePricing)];
        
        [_contentView addSubview:_volumePricingButton];
        
        [self buildPriceMatrix];
    }
}

- (void)buildPriceMatrix {
    
    DDLogDebug(@"buildPriceMatrix");
    
    if(_priceMatrix != nil) {
        [_priceMatrix removeFromSuperview];
        _priceMatrix = nil;
    }
    
    _priceMatrix = [UIView new];
    UIView *container = [UIView new];
    
    int count = 0;
    CGFloat totalHeight = 0;
    
    UIView *lineView = [self priceMatrixLineWithQuantity:NSLocalizedString(@"Quantity", nil)
                                                andPrice:NSLocalizedString(@"Price", nil)
                                                 isTitle:YES];
    
    count++;
    totalHeight += [lineView bH]*2;
    
    [container addSubview:lineView];
    
    for (HYBPrice *price in _currentProduct.volumePrices) {
        
        NSString *formattedValue = price.formattedValue;
        
        NSString *maxQuantity = [price.maxQuantity stringValue];
        NSString *minQuantity = [price.minQuantity stringValue];
        
        NSString *quantityRange = nil;
        
        if (minQuantity && maxQuantity) quantityRange = [NSString stringWithFormat:@"%@ - %@",minQuantity,maxQuantity];
        else if (minQuantity) quantityRange = [NSString stringWithFormat:@"%@ +",minQuantity];
        
        if (quantityRange) {
            UIView *lineView = [self priceMatrixLineWithQuantity:quantityRange andPrice:formattedValue isTitle:NO];
            lineView.center = CGPointMake([lineView bW]/2, [lineView bH]/2 + [lineView bH]* ++count);
            [container addSubview:lineView];
            totalHeight += [lineView bH];
        }
    }
    
    container.frame = CGRectMake(0,
                                 0,
                                 [lineView bW],
                                 totalHeight);
    
    
    [_priceMatrix addSubview:container];
    
    _priceMatrix.frame = CGRectInset(container.frame, padding, padding);
    
    container.center = CGPointMake([_priceMatrix bW]/2, [_priceMatrix bH]/2);
    
    _priceMatrix.backgroundColor = product_details_price_matrix_background;
    _priceMatrix.center = CGPointMake ([_productPriceLabel left]    + [_priceMatrix bW]/2,
                                       [_productPriceLabel bottom] - padding + [_priceMatrix bH]/2);
    
    _priceMatrix.hidden = YES;
    _priceMatrix.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_VOLUME_PRICING_CLOSED";
    
    UITapGestureRecognizer *tapPriceMatrix = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(toggleVolumePricing)];
    _priceMatrix.userInteractionEnabled = YES;
    [_priceMatrix addGestureRecognizer:tapPriceMatrix];
}

- (void)toggleVolumePricing {
    if(_priceMatrix.hidden) {
        _priceMatrix.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_VOLUME_PRICING_CLOSED";
        [_contentView addSubview:_priceMatrix];
        _priceMatrix.alpha = 0.f;
        _priceMatrix.hidden = NO;
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             _priceMatrix.alpha = 1.f;
                         }];
    } else {
        _priceMatrix.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_VOLUME_PRICING_EXPANDED";
        _priceMatrix.alpha = 1.f;
        _priceMatrix.hidden = NO;
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             _priceMatrix.alpha = 0.f;
                         }
                         completion:^(BOOL done) {
                             _priceMatrix.hidden = YES;
                             [_priceMatrix removeFromSuperview];
                         }
         ];
    }
}

- (UIView*)priceMatrixLineWithQuantity:(NSString*)quantity andPrice:(NSString*)price isTitle:(BOOL)isTitle {
    UIView *lineView = [UIView new];
    
    //setup
    UILabel *quantityLabel = [UILabel new];
    quantityLabel.text = quantity;
    quantityLabel.textColor = product_details_price_matrix_quantity;
    quantityLabel.font = product_details_font_price_matrix_quantity;
    quantityLabel.textAlignment = NSTextAlignmentCenter;
    
    UILabel *priceLabel = [UILabel new];
    priceLabel.text = price;
    priceLabel.textColor = product_details_price_matrix_price;
    priceLabel.font = product_details_font_price_matrix_price;
    priceLabel.textAlignment = NSTextAlignmentCenter;
    
    //pile up
    [lineView addSubview:quantityLabel];
    [lineView addSubview:priceLabel];
    
    if(isTitle){
        quantityLabel.textColor = product_details_price_matrix_quantity_title;
        quantityLabel.font = product_details_font_price_matrix_quantity_title;
        priceLabel.textColor = product_details_price_matrix_price_title;
        priceLabel.font = product_details_font_price_matrix_price_tilte;
    }
    
    //layout
    [quantityLabel sizeToFit];
    [priceLabel sizeToFit];
    
    CGFloat lineHeight = [quantityLabel bH] * 1.25;
    
    lineView.frame      = CGRectMake(0,                 0, [_contentView bW]/4,   lineHeight);
    quantityLabel.frame = CGRectMake(0,                 0, [lineView bW]/2,       lineHeight);
    priceLabel.frame    = CGRectMake([lineView bW]/2,   0, [lineView bW]/2,       lineHeight);
    
    return lineView;
}

- (void)displayProductsImages:(NSArray*)productImages {
    
    DDLogDebug(@"displayProductsImages: %@", [productImages description]);
    
    NSArray *sortedArray = [productImages sortedArrayUsingComparator:^NSComparisonResult(UIImage *image1, UIImage *image2){
        NSNumber *sizeImage1 = [NSNumber numberWithFloat:(image1.size.width * image1.size.height)];
        NSNumber *sizeImage2 = [NSNumber numberWithFloat:(image2.size.width * image2.size.height)];
        return ([sizeImage1 compare:sizeImage2] == NSOrderedAscending);
    }];
    
    DDLogDebug(@"Rendering %lu  images inside the scroll view of detail page", (unsigned long)sortedArray.count);
    NSAssert(_imagesScrollControl != nil, @"Images scroll control must be present.");
    
    _imagesScrollControl.currentPage = 0;
    _imagesScrollControl.numberOfPages = [sortedArray count];
    _imagesScrollControl.accessibilityIdentifier = @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_IMAGE_INDICATOR";
    
    CGSize pagesScrollViewSize = _imagesScrollView.frame.size;
    
    _imagesScrollView.contentSize = CGSizeMake(pagesScrollViewSize.width * sortedArray.count,
                                               pagesScrollViewSize.height);
    
    if (sortedArray != nil) {
        
        _sortedImagesArray = [NSArray arrayWithArray:sortedArray];
        
        for (int pageIndex = 0; pageIndex < sortedArray.count; pageIndex++) {
            
            int tagIndex = pageIndex+TAG_OFFSET;
            
            //debounce, only keep the newest image
            UIView *oldPageView = [_imagesScrollView viewWithTag:tagIndex];
            if(oldPageView) [oldPageView removeFromSuperview];
            
            UIImageView *pageView = [[UIImageView alloc] initWithFrame:self.imagesScrollView.bounds];
            UIImage *image = [sortedArray objectAtIndex:pageIndex];
            
            if (image.size.width > self.imagesScrollView.bounds.size.width || image.size.height > self.imagesScrollView.bounds.size.height) {
                pageView.contentMode = UIViewContentModeScaleAspectFit;
            } else {
                pageView.contentMode = UIViewContentModeCenter;
            }
            
            [pageView setImage:image];
            
            NSString *imageAccessId = [NSString stringWithFormat:@"%@_%d", @"ACCESS_CONTENT_PRODUCTDETAILS_PRODUCT_IMAGE", pageIndex];
            pageView.accessibilityIdentifier = imageAccessId;
            
            pageView.center = CGPointMake(pagesScrollViewSize.width/2+pagesScrollViewSize.width*pageIndex, pagesScrollViewSize.height/2);
            
            pageView.tag = tagIndex;
            
            [_imagesScrollView addSubview:pageView];
            
            [pageView setUserInteractionEnabled:YES];
            
            //zoom interaction
            UITapGestureRecognizer *zoomTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(openZoomForProductImageAtIndex:)];
            
            [pageView addGestureRecognizer:zoomTap];
            
        }
    }
}

- (void)openZoomForProductImageAtIndex:(UITapGestureRecognizer*)sender {
    
    int index = (int)sender.view.tag - TAG_OFFSET;
    
    if(index < [_sortedImagesArray count]) {
        UIImage *image = [_sortedImagesArray objectAtIndex:index];
        
        HYBZoomView *zoomView = [HYBZoomView zoomViewWithFrame:self.frame andImage:image];
        zoomView.alpha = 0.f;
        [self addSubview:zoomView];
        
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             zoomView.alpha = 1.f;
                         }];
    }
}

#pragma mark table sizing

- (void)updateVisibleTableContent {
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (NSDictionary *dict in _tableContent) {
        if([dict[@"status"]isEqualToString:@"title"] || [dict[@"status"]isEqualToString:@"open"]) {
            [tempArray addObject:dict];
        }
    }
    
    _visibleTableContent = [NSArray arrayWithArray:tempArray];
    
    [_tabsTable reloadData];
    
    [UIView animateWithDuration:defaultAnimationDuration/2
                     animations:^() {
                         [self resizeTable];
                     }];
    
}

- (void)resizeTable {
    
    variableHeight = 0.f;
    
    for(int i = 0; i < [_visibleTableContent count]; i++) {
        CGFloat cellHeight = [self tableView:_tabsTable heightForRowAtIndexPath:[NSIndexPath indexPathForRow:i inSection:0]];
        variableHeight += cellHeight;
    }
    
    CGRect oldRect = _tabsTable.frame;
    CGRect newRect = CGRectMake(oldRect.origin.x, oldRect.origin.y, oldRect.size.width, variableHeight);
    
    _tabsTable.frame = newRect;
    
    // update Master ScrollView Conten Size
    
    CGFloat tableOriginY  = [_tabsTable fY];
    CGFloat tableOverFlow = [_tabsTable bottom];
    
    CGFloat marge = 12.f;
    
    CGFloat width  = _contentView.frame.size.width;
    CGFloat height = tableOverFlow + marge;
    
    _contentView.contentSize = CGSizeMake(width, height);
    
    for (NSDictionary *dict in _tableContent) {
        if([dict[@"status"]isEqualToString:@"open"]) {
            CGRect visibleTabFrame = CGRectMake(0, tableOriginY, width, variableHeight+marge);
            [_contentView scrollRectToVisible:visibleTabFrame animated:YES];
            break;
        }
    }
}

#pragma mark - Bottom Tabs Methods

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"cellIdentifier"];
    
    if(!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"cellIdentifier"];
    }
    
    [cell.contentView removeSubviews];
    
    NSDictionary *dict = self.visibleTableContent[indexPath.row];
    
    NSString *status = dict[@"status"];
    
    BOOL isOpen = NO;
    
    cell.backgroundColor = product_details_tabs_content_background;
    
    if([status isEqualToString:@"title"]) {
        cell.backgroundColor = product_details_tabs_title_background;
        
        if (indexPath.row < [self.visibleTableContent count]-1) {
            NSDictionary *contentDict = self.visibleTableContent[indexPath.row+1];
            NSString *contentStatus = contentDict[@"status"];
            if([contentStatus isEqualToString:@"open"]) {
                isOpen = YES;
            }
        }
        
        UILabel *label = [UILabel new];
        label.font = [UIFont fontWithName:@"HelveticaNeue" size:16.f];
        
        NSString *accessTag = nil;
        
        if (isOpen) {
            label.text = @"-";
            accessTag = [NSString stringWithFormat:@"ACCESS_PRODUCTDETAIL_TABS_CLOSE_CELL_%ld",(long)indexPath.row];
        } else {
            label.text = @"+";
            accessTag = [NSString stringWithFormat:@"ACCESS_PRODUCTDETAIL_TABS_OPEN_CELL_%ld",(long)indexPath.row];
        }
        
        [label sizeToFit];
        
        cell.accessoryView.accessibilityIdentifier = accessTag;
        cell.accessoryView = label;
    } else {
        cell.accessoryView = nil;
    }
    
    NSString *cacheKey =  dict[@"accessId"];
    
    
    UIView *view = _tableCellsCacheDict[cacheKey];
    
    if(!view) {
        view = [self viewForContentDict:dict];
        [_tableCellsCacheDict setObject:view forKey:cacheKey];
    }
    
    [cell.contentView addSubview:view];
    
    cell.accessibilityIdentifier = dict[@"accessId"];
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSDictionary *currentCellDict = self.visibleTableContent[indexPath.row];
    int currentTag = [currentCellDict[@"tag"] intValue];
    
    for (NSDictionary *dict in self.tableContent) {
        if([dict[@"tag"] intValue] == currentTag) {
            
            //tap on the title
            if([dict[@"status"] isEqualToString:@"title"]) {
                int titleIndex = (int)[self.tableContent indexOfObject:dict];
                [self toggleCellForTitleIndex:titleIndex];
            }
            
            //tap on the content
            else if([dict[@"status"] isEqualToString:@"open"]) {
                int titleIndex = (int)[self.tableContent indexOfObject:dict];
                [self toggleCellForTitleIndex:titleIndex-1];
            }
            
            break;
        }
    }
    
    [self updateVisibleTableContent];
}

- (void)toggleCellForTitleIndex:(int)titleIndex {
    
    NSMutableArray *tmpArray = [NSMutableArray arrayWithArray:self.tableContent];
    
    int contentIndex = titleIndex+1;
    
    NSMutableDictionary *dict = [NSMutableDictionary dictionaryWithDictionary:[self.tableContent objectAtIndex:contentIndex]];
    
    if([dict[@"status"] isEqualToString:@"closed"]) {
        [dict setObject:@"open" forKey:@"status"];
    } else {
        [dict setObject:@"closed" forKey:@"status"];
    }
    
    [tmpArray replaceObjectAtIndex:contentIndex withObject:[NSDictionary dictionaryWithDictionary:dict]];
    
    self.tableContent = [NSArray arrayWithArray:tmpArray];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    UIView *view = [self viewForContentDict:_visibleTableContent[indexPath.row]];
    return [view bH] + 30;
}

- (UIView*)viewForContentDict:(NSDictionary*)dict {
    
    UIView *container = [UIView new];
    
    NSString *content = dict[@"content"];
    NSString *status  = dict[@"status"];
    
    //setup styling size
    
    UIFont *tmpFont = product_details_tabs_content_font;
    
    UIColor *tmpColor = product_details_tabs_content;
    
    if([status isEqualToString:@"title"]) {
        tmpFont = product_details_tabs_title_font;
        tmpColor = product_details_tabs_title;
    }
    
    NSString *fontName = [tmpFont fontName];
    NSString *fontSize = [NSString stringWithFormat:@"%.0f",[tmpFont pointSize]];
    NSString *fontColor = [tmpColor hexStringValue];
    
    NSString *styledContent = [NSString stringWithFormat:@"<div style=\"font-family:'%@';font-size:%@px;color:#%@;\">%@</div>", fontName, fontSize, fontColor, content];
    
    //render string
    NSAttributedString *attributedContent = [[NSAttributedString alloc] initWithData:[styledContent dataUsingEncoding:NSUnicodeStringEncoding]
                                                                             options:@{NSDocumentTypeDocumentAttribute:NSHTMLTextDocumentType}
                                                                  documentAttributes:nil
                                                                               error:nil];
    
    //sizing
    CGFloat padding = 10.f;
    CGFloat maxWidth = [_contentView bW]-padding*3;
    CGSize constraint = CGSizeMake(maxWidth,NSUIntegerMax);
    
    
    CGRect rect = [attributedContent boundingRectWithSize:constraint
                                                  options:(NSStringDrawingUsesLineFragmentOrigin|NSStringDrawingUsesFontLeading)
                                                  context:nil];
    
    // Construct label
    UILabel* label = [[UILabel alloc] initWithFrame:CGRectMake(padding,
                                                               padding,
                                                               maxWidth,
                                                               rect.size.height+padding)];
    
    label.attributedText = attributedContent;
    label.textAlignment = NSTextAlignmentLeft;
    label.lineBreakMode = NSLineBreakByWordWrapping;
    label.numberOfLines = 0;
    
    [container setFrame:label.frame];
    [container addSubview:label];
    
    return container;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_visibleTableContent count];
}

//utility

- (int)numberOfLinesInTextView:(UITextView*)textView {
    id<UITextInputTokenizer> tokenizer = textView.tokenizer;
    UITextPosition *pos = textView.endOfDocument; int lines = 0;
    
    while (true){
        UITextPosition *lineEnd = [tokenizer positionFromPosition:pos toBoundary:UITextGranularityLine inDirection:UITextStorageDirectionBackward];
        
        if([textView comparePosition:pos toPosition:lineEnd] == NSOrderedSame){
            pos = [tokenizer positionFromPosition:lineEnd toBoundary:UITextGranularityCharacter inDirection:UITextStorageDirectionBackward];
            
            if([textView comparePosition:pos toPosition:lineEnd] == NSOrderedSame) break;
            
            continue;
        }
        
        lines++; pos = lineEnd;
    }
    
    lines--; // Compensation for extra line calculated
    return lines;
}

@end
