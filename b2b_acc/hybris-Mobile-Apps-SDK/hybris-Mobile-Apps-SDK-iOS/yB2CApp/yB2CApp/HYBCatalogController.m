//
// HYBCatalogController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//

#import "HYBCatalogController.h"
#import "HYBB2CService.h"
#import "HYBAppDelegate.h"
#import "HYBCategoryHierarchy.h"
#import "HYBListViewCell.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBCatalogView.h"
#import "HYBActivityIndicator.h"
#import "HYBCollectionViewCell.h"
#import "HYBSearchResultsBar.h"

@interface HYBCatalogController ()
@property (nonatomic) HYBCatalogView *mainView;
@property (nonatomic) BOOL isGridView;
@end

@implementation HYBCatalogController

dispatch_queue_t backgroundDownloadQueue;

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        
        _isGridView = NO;
        
        backgroundDownloadQueue = dispatch_queue_create("backgroundDownloadQueue", 0);
        
        NSAssert(self.backendService != nil, @"Provide a valid backEndService.");
        
        _products = [NSArray array];
        
    }
    
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    if (!_mainView) {
        _mainView = [HYBCatalogView new];
    }
    
    self.view = _mainView;
    
    //table view
    _mainView.productsTable.delegate = self;
    _mainView.productsTable.dataSource = self;
    [_mainView.productsTable registerClass:[HYBListViewCell class] forCellReuseIdentifier:@"HYBListViewCellID"];
    
    _mainView.productsTable.separatorStyle = UITableViewCellSeparatorStyleNone;
    
    //grid view
    _mainView.productsGrid.delegate = self;
    _mainView.productsGrid.dataSource = self;
    
    [self displayCurrentLayout];
    
    //keyboard monitor
    NSNotificationCenter *notificationCenter = [NSNotificationCenter defaultCenter];
    
    [notificationCenter addObserver:self selector:@selector(keyboardDidShow:)
                               name:UIKeyboardDidShowNotification
                             object:nil];
    
    [notificationCenter addObserver:self selector:@selector(keyboardDidHide:)
                               name:UIKeyboardWillHideNotification
                             object:nil];
    
    //header interactions
    
    //grid switch action
    UITapGestureRecognizer *gridIconTapped = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                     action:@selector(gridIconTapped)];
    [_mainView.gridSwitch addGestureRecognizer:gridIconTapped];
    
    //list switch action
    UITapGestureRecognizer *listIconTapped = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                     action:@selector(listIconTapped)];
    [_mainView.listSwitch addGestureRecognizer:listIconTapped];
    
    
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
    
    self.blockScroll = YES;
    
    [self updateGridListButtons];
    
    NSString *didChangeStore = [[self.backendService userStorage] objectForKey:DID_CHANGE_SERVER];
    
    if ([didChangeStore boolValue]) {
        _products = [NSArray array];
        [[self.backendService userStorage] removeObjectForKey:DID_CHANGE_SERVER];
        [[self.backendService userStorage] synchronize];
    }
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
    
    if(![self topToolbar].searchString) {
        [self loadAllProducts];
    }
}

- (void)loadAllProducts {
    NSString *lastShownCatId = [[self.backendService userStorage] objectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
    
    [self.backendService getCategoriesAndExecute:^(NSArray *foundCategories, NSError *error) {
        
        HYBCategoryHierarchy *category =[[foundCategories firstObject] findCategoryByIdInsideTree:lastShownCatId];
        if (category == nil) {
            DDLogDebug(@"No category was given all products will be loaded.");
            [self loadProducts];
        } else {
            DDLogDebug(@"Products from category %@ will be loaded.", category.id);
            [self loadProductsByCategoryId:category.id];
        }
    }];
}

- (UIView *)loadingView {
    
    UIView *container  = [UIView    new];
    UILabel *textLabel = [UILabel   new];
    
    UIActivityIndicatorView *spinner = nil;
    
    if (self.allItemsLoaded) {
        textLabel.text = NSLocalizedString(@"all_items_loaded", @"");
    } else {
        textLabel.text = NSLocalizedString(@"loading", @"");
        
        spinner = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleGray];
        [spinner startAnimating];
        [container addSubview:spinner];
    }
    
    textLabel.accessibilityIdentifier = @"ACCESS_CATALOG_LOADING_CELL";
    
    [textLabel sizeToFit];
    [container addSubview:textLabel];
    
    //geometry
    CGFloat totalWidth = textLabel.bounds.size.width;
    CGFloat totalHeight = textLabel.bounds.size.height;
    
    if (spinner) {
        CGFloat marge = 10.f;
        
        totalWidth += spinner.bounds.size.width + marge;
        if (spinner.bounds.size.height > totalHeight) totalHeight = spinner.bounds.size.height;
        
        [textLabel setCenter:CGPointMake((totalWidth + spinner.bounds.size.width + marge) / 2, totalHeight / 2)];
    }
    
    [container setFrame:CGRectMake(0, 0, totalWidth, totalHeight)];
    
    return container;
}

#pragma mark tableView delegate

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    int mod = 0;
    if (self.loading && !self.allItemsLoaded) mod = 1;
    
    return [self.products count] + mod;
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 100.f;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (self.loading && indexPath.row == [self.products count]) {
        UITableViewCell *uniqueCell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"defaultCell"];
        
        UIView *loadingView = [self loadingView];
        
        [loadingView setCenter:CGPointMake(384, 50)];
        [uniqueCell.contentView addSubview:loadingView];
        
        return uniqueCell;
    }
    
    //default cell
    HYBListViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"HYBListViewCellID"
                                                            forIndexPath:indexPath];
    
    
    
    
    if (indexPath.row >= [self.products count]) return cell;
    
    HYBProduct *prod = [self.products objectAtIndex:indexPath.row];
    
    //update cell only if needed
    if(!cell.productCodeLabel.text || ![cell.productCodeLabel.text isEqualToString:[prod code]]) {
        
        cell.selectionStyle = UITableViewCellSelectionStyleNone;
        NSString *cellAccessId = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_CONTENT_CATALOG_LIST_CELL", (long)[indexPath row]];
        cell.accessibilityIdentifier = cellAccessId;
        [cell setUserInteractionEnabled:YES];
        
        UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(listCellTapped:)];
        tapRecognizer.numberOfTapsRequired = 1;
        tapRecognizer.delegate = self;
        [cell.tapArea addGestureRecognizer:tapRecognizer];
        [cell.tapArea setTag:indexPath.row];
        
        cell.productNameLabel.text = prod.name;
        cell.productCodeLabel.text = prod.code;
        cell.priceLabel.text = prod.price.formattedValue;
        
        cell.quantityInputField.text = @"1";
        cell.quantityInputField.delegate = self;
        
        [cell.quantityInputField addTarget:self action:@selector(updateTotalAmount:) forControlEvents:UIControlEventEditingChanged];
        
        cell.quantityInputField.returnKeyType = UIReturnKeyDone;
        
        cell.productNameLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_NAME", cellAccessId];
        cell.productCodeLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_NO", cellAccessId];
        cell.priceLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_PRICE", cellAccessId];
        cell.quantityInputField.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_QTY", cellAccessId];
        cell.addToCartButton.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_ATC", cellAccessId];
        cell.totalItemPrice.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_TOTAL", cellAccessId];
        
        cell.stockLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_STOCK", cellAccessId];
        
        NSString *stockLabelValue = @"";
        
        BOOL buttonEnabled = YES;
        
        if (prod.multidimensional) {
            [self setHiddenForAddToCartArea:cell toValue:YES];
        } else {
            [self setHiddenForAddToCartArea:cell toValue:NO];
            
            // stock info in the live view is present only for not multi-d products
            if (prod.isInStock && !prod.lowStock) {
                stockLabelValue = NSLocalizedString(@"product_list_in_stock", nil);
                cell.stockLabel.textColor = hybris_green;
            } else if (prod.lowStock) {
                stockLabelValue = [NSString stringWithFormat:NSLocalizedString(@"product_list_low_stock_number", nil), [prod.stock.stockLevel intValue]];
                cell.stockLabel.textColor = hybris_red;
            } else if (!prod.isInStock) {
                buttonEnabled = NO;
                stockLabelValue = NSLocalizedString(@"product_list_out_of_stock", @"out of stock");
                cell.stockLabel.textColor = hybris_red;
            }
        }
        
        cell.stockLabel.text = stockLabelValue;
        
        [self calculateTotalsForCell:cell withProduct:prod];
        
        cell.addToCartButton.tag = indexPath.row;
        
        if (buttonEnabled) {
            [cell.addToCartButton addTarget:self
                                     action:@selector(addToCartPressed:)
                           forControlEvents:UIControlEventTouchUpInside];
            
            cell.addToCartButton.alpha = 1.f;
        } else {
            [cell.addToCartButton removeTarget:self
                                        action:@selector(addToCartPressed:)
                              forControlEvents:UIControlEventTouchUpInside];
            
            cell.addToCartButton.alpha = .33;
        }
        
        cell.quantityInputField.tag = indexPath.row;
        
        cell.productIcon.alpha = 0;
        cell.productIcon.image = nil;
        
        dispatch_async(backgroundDownloadQueue, ^{
            [self loadImageForProduct:prod inCellAtIndexPath:indexPath];
        });
        
        cell.accessibilityIdentifier = [NSString stringWithFormat:@"%@_%@_%@_%ld", [self class], @"ProductList", @"Cell", (long)indexPath.row];
        
    }
    return cell;
}

- (void)scrollViewDidScroll:(UIScrollView *)scrollView {
    //block initial table view scroll
    if (self.blockScroll) return;
    
    // UITableView only moves in one direction, y axis
    CGFloat currentOffset = scrollView.contentOffset.y;
    CGFloat maximumOffset = scrollView.contentSize.height - scrollView.frame.size.height;
    
    // Change 10.0 to adjust the distance from bottom
    if (maximumOffset - currentOffset <= 10.0) {
        if (!self.allItemsLoaded) [self loadNextProducts];
    }
}

- (void)setHiddenForAddToCartArea:(HYBListViewCell *)cell toValue:(BOOL)value {
    [cell.addToCartButton setHidden:value];
    [cell.quantityInputField setHidden:value];
    [cell.totalItemPrice setHidden:value];
}

- (void)itemsQuantityChanged:(UITextField*)field andAddToCart:(BOOL)addToCart {
    
    NSInteger selectedIndex = field.tag;
    NSIndexPath *indexPath = [NSIndexPath indexPathForItem:selectedIndex inSection:0];
    
    HYBListViewCell *cell = (HYBListViewCell *) [_mainView.productsTable cellForRowAtIndexPath:indexPath];
    
    HYBProduct *product = [_products objectAtIndex:selectedIndex];
    [self calculateTotalsForCell:cell withProduct:product];
    
    NSAssert([cell hyb_isNotBlank], @"Cell was not found");
    
    if(addToCart) [self addProductToCartFromCell:cell selectedIndex:selectedIndex];
    
}

- (void)listCellTapped:(UITapGestureRecognizer*)sender {
    NSInteger index = [(UITapGestureRecognizer*)sender view].tag;
    [self openDetailPageForProductAtIndex:index];
}

- (void)openDetailPageForProductAtIndex:(NSInteger)index {
    HYBProduct *selectedProduct = [self.products objectAtIndex:index];
    [self pushDetailControllerWithProduct:selectedProduct toggleDrawer:NO];
}

- (void)calculateTotalsForCell:(HYBListViewCell *)cell withProduct:(HYBProduct *)prod {
    NSNumber *quantity = [[[NSNumberFormatter alloc] init] numberFromString:cell.quantityInputField.text];
    if (quantity && [[prod price] hyb_isNotBlank]) {
        CGFloat totalPrice = [prod.price.value floatValue] * [cell.quantityInputField.text integerValue];
        
        //TODO: adapt for currencyIso
        NSString *currencySign = @"$";
        NSString *totalPriceLabelValue = [[NSString alloc] initWithFormat:@"%@%.02f", currencySign, totalPrice];
        [cell.totalItemPrice setText:totalPriceLabelValue];
        [cell setNeedsLayout];
    }
}

- (void)addToCartPressed:(id)sender {
    UIButton *addToCartButton = (UIButton *) sender;
    
    
    NSInteger selectedIndex = addToCartButton.tag;
    DDLogDebug(@"Add to cart pressed at row %ld", (long)selectedIndex);
    
    NSIndexPath *indexPath = [NSIndexPath indexPathForRow:selectedIndex inSection:0];
    
    HYBListViewCell *cell = (HYBListViewCell *) [_mainView.productsTable cellForRowAtIndexPath:indexPath];
    [self addProductToCartFromCell:cell selectedIndex:selectedIndex];
    
}

- (void)addProductToCartFromCell:(HYBListViewCell *)cell selectedIndex:(NSInteger)selectedIndex {
    UITextField *orderInputField = cell.quantityInputField;
    
    [orderInputField resignFirstResponder];
    
    HYBProduct *product = [_products objectAtIndex:selectedIndex];
    
    NSNumber *amount = [[[NSNumberFormatter alloc] init] numberFromString:orderInputField.text];
    
    if (amount) {
        
        DDLogDebug(@"Adding product %@ in amount %d to cart ", product.code, amount.intValue);
        
        @weakify(self);
        [self.backendService addProductToCurrentCart:product.code
                                          amount:amount
                                           andExecute:^(HYBCart *cart, NSError *error) {
                                               @strongify(self);
                                               
                                               if (cart == nil) {
                                                   DDLogError(@"Product %@ not added to cart.", product.code);
                                               } else {
                                                   orderInputField.text = @"1";
                                                   [self calculateTotalsForCell:cell withProduct:product];
                                               }
                                               
                                               [self showNotifyMessage:error.localizedDescription];
                                           }];
    }
}


- (void)loadImageForProduct:(HYBProduct *)prod inCellAtIndexPath:(NSIndexPath*)indexPath {
    
    NSString *imageUrl = prod.thumbnailURL;
    
    [self.backendService loadImageByUrl:imageUrl andExecute:^(UIImage *fetchedImage, NSError *error) {
        if (error) {
            DDLogDebug(@"Can not retrieve image for url: %@ reason: %@", imageUrl, [error localizedDescription]);
        }
        
        if(fetchedImage) {
            id cell = nil;
            UIImageView *cellImageView = nil;
            
            if(_isGridView) {
                cell = (HYBCollectionViewCell *)[_mainView.productsGrid cellForItemAtIndexPath:indexPath];
                if(cell) cellImageView = [cell productImageView];
            } else {
                cell = (HYBListViewCell *)[_mainView.productsTable cellForRowAtIndexPath:indexPath];
                if(cell) cellImageView = [cell productIcon];
            }
            
            if (cellImageView) {
                
                dispatch_async(dispatch_get_main_queue(), ^{
                    cellImageView.image = fetchedImage;
                    
                    NSString *cellAccessId = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_CONTENT_CATALOG_LIST_CELL", (long)indexPath.row];
                    cellImageView.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_IMAGE", cellAccessId];
                    
                    [UIView animateWithDuration:defaultAnimationDuration animations:^() {
                        cellImageView.alpha = 1.f;
                    }];
                });
                
            }
        }
    }];
}


- (void)cacheCurrentCategoryId:(NSString *)newCatID {
    if (!_currentCategoryId || ![_currentCategoryId isEqualToString:newCatID]) {
        _currentCategoryId = [NSString stringWithString:newCatID];
    }
}

#pragma mark loading methods

- (void)initialLoadProducts {
    [self.backendService resetPagination];
    [self findCategories];
}

- (void)findCategories {
    NSString *lastShownCatId = [[self.backendService userStorage] objectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
    
    [self.backendService getCategoriesAndExecute:^(NSArray *foundCategories, NSError *error) {

        HYBCategoryHierarchy *category = [[foundCategories firstObject] findCategoryByIdInsideTree:lastShownCatId];
        
        if (category == nil) {
            DDLogDebug(@"No category was given all products will be loaded.");
            _currentCategoryId = nil;
            [self loadNextProducts];
        } else {
            DDLogDebug(@"Products from category %@ will be loaded.", category.id);
            [self loadProductsByCategoryId:category.id];
        }
    }];
}

- (void)loadNextProducts {
    if (!self.loading) {
        self.loading = YES;
        [self forceReload];
        
        //small delay to allow ui to display loading indicator
        
        [self performSelector:@selector(doLoad) withObject:nil afterDelay:.2];
    }
}

- (void)doLoad {
    if ([self.currentSearchQuery hyb_isNotBlank]) {
        [self doPerformSearch];
    } else {
        if (_currentCategoryId) {
            [self loadProductsByCategoryId:_currentCategoryId];
        } else {
            [self loadProducts];
        }
    }
}

- (void)loadBaseProductsByCategoryId:(NSString *)categoryId {
    
    [self.backendService resetPagination];
    self.products = [NSArray array];
    self.allItemsLoaded = NO;
    self.loading = YES;
    
    [self loadProductsByCategoryId:categoryId];
}

- (void)loadProductsByCategoryId:(NSString *)categoryId {
    [self cacheCurrentCategoryId:categoryId];
    
    DDLogDebug(@"Loading products for category %@", _currentCategoryId);
    
    [self.backendService findProductsByCategoryId:_currentCategoryId
                                    andExecute:^(NSArray *products, NSError *error) {
                                        if (error) {
                                            DDLogError(@"Problems during the retrieval of the products from the web service: %@", [error localizedDescription]);
                                        } else {
                                            [self processNewProducts:products];
                                        }
                                    }];
}

- (void)loadProducts {
    [self.backendService getProductsAndExecute:^(NSArray *products, NSError *error) {
        if (error) {
            DDLogError(@"Problems during the retrieval of the products from the web service: %@", [error localizedDescription]);
        } else {
            [self processNewProducts:products];
        }
    }];
}

- (void)checkProductsCount {
    if ([self.products count] == 0) {
        NSString *msg = NSLocalizedString(@"catalog_no_products_found_title", nil);
        [self showNotifyMessage:msg];
    }
}

/**
 *  refresh ui with new products added by scrolling down
 *
 *  @param newProducts array of products
 */
- (void)processNewProducts:(NSArray *)newProducts {
    
    self.loading = NO;
    self.blockScroll = NO;
    
    BOOL forceReload = NO;
    
    if (!newProducts || [newProducts count] == 0) {
        self.allItemsLoaded = YES;
        
        if ([self.backendService currentPage] == 0 && [self.products count] == 0) {
            DDLogDebug(@"empty category");
            NSString *msg = NSLocalizedString(@"catalog_no_products_found_title", nil);
            [self showNotifyMessage:msg];
            
            forceReload = YES;
        }
    } else {
        if ([newProducts count] < [self.backendService pageSize]) {
            self.allItemsLoaded = YES;
        }
        
        if ([newProducts count] > 0 && [self.products count] == 0) {
            DDLogDebug(@"new Category or new Search ");
            forceReload = YES;
        }
    }
    
    if (forceReload) {
        self.products = [NSArray arrayWithArray:newProducts];
        [self forceReload];
        [self.backendService nextPage];
    } else {
        
        //debounce products (prevent adding same product coming from cache and server)
        
        //1- keep only products to add in an array
        NSMutableArray *tempArray = [NSMutableArray array];
        
        BOOL add = YES;
        
        for (HYBProduct *newProduct in newProducts) {
            add = YES;
            for (HYBProduct *oldProduct in self.products) {
                if ([newProduct.code isEqualToString:oldProduct.code]) {
                    add = NO;
                    break;
                }
            }
            
            if (add) {
                [tempArray addObject:newProduct];
            }
        }
        
        //if we have any new result to add
        if ([tempArray count] > 0) {
            
            //2 - create indexPaths array
            NSMutableArray *tmpIndexPaths = [NSMutableArray array];
            int origin = (int)[self.products count]-1;
            if (origin < 0) origin = 0;
            
            for (int i = 0; i < [tempArray count]; i++) {
                NSIndexPath *indexPath = [NSIndexPath indexPathForItem:i+origin inSection:0];
                [tmpIndexPaths addObject:indexPath];
            }
            
            NSArray *indexPaths = [NSArray arrayWithArray:tmpIndexPaths];
            
            //3 - join data
            NSArray *finalArray = [self.products arrayByAddingObjectsFromArray:tempArray];
            
            self.products = [NSArray arrayWithArray:finalArray];
            
            // - insert new cells
            
            if (indexPaths && [indexPaths count] > 0) {
                
                if(_isGridView) {
                    [_mainView.productsGrid performBatchUpdates:^{
                        [_mainView.productsGrid insertItemsAtIndexPaths:indexPaths];
                    }
                                                     completion:nil];
                } else {
                    [_mainView.productsTable reloadData];
                }
            }
            
            [self.backendService nextPage];
        }
    }
}


//insertItemsAtIndexPaths
#pragma mark display layout

/**
 *  reload all data in grid or tableview
 */
- (void)forceReload {
    
    [self displayCurrentLayout];
    
    if (_isGridView) {
        dispatch_async(dispatch_get_main_queue(), ^() {
            [_mainView.productsGrid reloadData];
        });
    } else {
        [_mainView.productsTable reloadData];
    }
}

/**
 *  adapt ui according to user grid vs list layout
 */
-(void)displayCurrentLayout {
    [_mainView.productsGrid  setHidden:!_isGridView];
    [_mainView.productsTable setHidden:_isGridView];
}

#pragma mark text field delegate manage editing

- (void)updateTotalAmount:(id)sender {
    [self itemsQuantityChanged:sender andAddToCart:NO];
}

- (BOOL)textFieldShouldBeginEditing:(UITextField *)textField {
    
    _firstResponderOriginalValue = textField.text;
    return YES;
}

- (BOOL)textFieldShouldEndEditing:(UITextField *)textField {
    if (!textField.text || textField.text.length <= 0) {
        textField.text = _firstResponderOriginalValue;
    }
    return YES;
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    [self itemsQuantityChanged:textField andAddToCart:YES];
    
    [textField resignFirstResponder];
    return NO;
}

#pragma mark grid view delegates

- (UIEdgeInsets)collectionView:(UICollectionView *)collectionView
                        layout:(UICollectionViewLayout*)collectionViewLayout
        insetForSectionAtIndex:(NSInteger)section{
    CGFloat marge = 10.f;
    return UIEdgeInsetsMake(marge, marge, marge, marge);
}

- (NSInteger)collectionView:(UICollectionView *)collectionView
     numberOfItemsInSection:(NSInteger)section {
    return [self.products count];
}

- (CGSize)collectionView:(UICollectionView *)collectionView
                  layout:(UICollectionViewLayout *)collectionViewLayout
  sizeForItemAtIndexPath:(NSIndexPath *)indexPath {
    
    return CGSizeMake(246, 300);
}

- (HYBCollectionViewCell *)collectionView:(UICollectionView *)collectionView
                   cellForItemAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBCollectionViewCell *cell = [collectionView dequeueReusableCellWithReuseIdentifier:@"collectionViewCellId" forIndexPath:indexPath];
    NSString *cellAccessId = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_CONTENT_CATALOG_LIST_GRID", (long)[indexPath row]];
    cell.accessibilityIdentifier = cellAccessId;
    
    HYBProduct *product = [self.products objectAtIndex:indexPath.row];
    
    //security
    if (indexPath.row >= [self.products count]) return cell;
    
    //update cell only if needed
    if(!cell.productCodeLabel.text || ![cell.productCodeLabel.text isEqualToString:product.code]) {
        cell.productNameLabel.text  = product.name;
        cell.productCodeLabel.text  = product.code;
        cell.productPriceLabel.text = product.formattedPrice;
        
        cell.productNameLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_NAME", cellAccessId];
        cell.productCodeLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_NO", cellAccessId];
        cell.productPriceLabel.accessibilityIdentifier = [NSString stringWithFormat:@"%@_PRODUCT_PRICE", cellAccessId];
        
        cell.productImageView.alpha = 0;
        cell.productImageView.image = nil;
        
        dispatch_async(backgroundDownloadQueue, ^{
            [self loadImageForProduct:product inCellAtIndexPath:indexPath];
        });
        
    }
    return cell;
}

- (void)collectionView:(UICollectionView *)collectionView didSelectItemAtIndexPath:(NSIndexPath *)indexPath {
    [self openDetailPageForProductAtIndex:indexPath.row];
}

#pragma mark search + searchbar delegate

- (void)cancelSearch {
    if(self.searchResultsBar) {
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             [self.searchResultsBar collapse];
                             [self didUpdateSearchResultsBarFrameAnimated:YES];
                         }
                         completion:^(BOOL done) {
                             [self.searchResultsBar removeFromSuperview];
                             self.searchResultsBar = nil;
                         }
         ];
    }
}

- (void)performSearchForString:(NSString *)searchString {
    DDLogDebug(@"search %@ in catalog controller",searchString);
    
    if (searchString && searchString.length > 0) {
        if(self) {
            self.currentSearchQuery = [searchString copy];
            [self setProducts:[NSArray array]];
            self.allItemsLoaded = NO;
        }
        
        [self.backendService resetPagination];
        [self doPerformSearch];
    }
}

- (void)doPerformSearch {
    DDLogDebug(@"Searching for products by query %@ ...", self.currentSearchQuery);
    
    [HYBActivityIndicator show];
    
    @weakify(self);
    [self.backendService getProductsByQuery:self.currentSearchQuery
                                 andExecute:^(NSArray *products, NSString *spellingSuggestion, NSError *error) {
                                     
                                     @strongify(self);
        [HYBActivityIndicator hide];
        
        if (error) {
            DDLogError(@"Problems during the retrieval of the products from the web service: %@", [error localizedDescription]);
        } else {
            
            NSMutableDictionary *tmpParams = [NSMutableDictionary dictionary];
            
            BOOL hasDYM = NO;
            
            if ([spellingSuggestion hyb_isNotBlank]) {
                tmpParams[SEARCH_DYM] = [NSString stringWithString:spellingSuggestion];
                hasDYM = YES;
            }
            
            tmpParams[SEARCH_RESULT] = [NSString stringWithString:self.currentSearchQuery];
            tmpParams[SEARCH_COUNT]  = [NSString stringWithFormat:@"%d",self.backendService.totalSearchResults];
            
            NSDictionary *params = [NSDictionary dictionaryWithDictionary:tmpParams];
            
            //create/update search results if needed
            if(!self.searchResultsBar) {
                self.searchResultsBar = [[HYBSearchResultsBar alloc] initWithFrame:CGRectMake(0, [_mainView.headerToolbar bottom], [_mainView bW], 000)];
                [self.view addSubview:self.searchResultsBar];
            }
            
            if (self.searchResultsBar) {
                [self.searchResultsBar updateSearchResultWithParams:params animated:YES];
                [self didUpdateSearchResultsBarFrameAnimated:YES];
                
                if(hasDYM) {
                    //action
                    self.searchResultsBar.searchDidYouMeanPanel.userInteractionEnabled = YES;
                    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(didYouMeanTapped)];
                    [self.searchResultsBar.searchDidYouMeanPanel addGestureRecognizer:tapGesture];
                }
                
            }
            
            //process received products
            [self processNewProducts:products];
            
            [self checkProductsCount];
        }
    }];
}

- (void)didUpdateSearchResultsBarFrameAnimated:(BOOL)animated {
    DDLogDebug(@"Default didUpdateSearchResultsBarFrameAnimated:%d",animated);
    
    if (animated) {
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             [self searchResultsBarSizing];
                         }];
    } else {
        [self searchResultsBarSizing];
    }
}

- (void)searchResultsBarSizing {
    self.searchResultsBar.center = CGPointMake([_mainView bW]/2,
                                               [_mainView.headerToolbar bottom] + self.searchResultsBar.nextRect.size.height/2);
    
    _mainView.contentView.frame = CGRectMake(0,
                                             self.searchResultsBar.nextRect.origin.y + self.searchResultsBar.nextRect.size.height,
                                             [_mainView bW],
                                             [_mainView.contentView bH] - [_mainView.headerToolbar bottom] + self.searchResultsBar.nextRect.size.height);
    
}

- (void)didYouMeanTapped {
    NSString *DYMString = self.searchResultsBar.searchDidYouMeanString;
    
    [self performSearchForString:DYMString];
    [self topToolbar].searchField.text = DYMString;
    [self topToolbar].searchString = DYMString;
}


#pragma mark header interactions

- (void)gridIconTapped {
    [self switchToGridLayout:YES];
}

- (void)listIconTapped {
    [self switchToGridLayout:NO];
}

- (void)switchToGridLayout:(BOOL)useGridLayout {
    
    //modify only if selection changed
    if(_isGridView != useGridLayout) {
        _isGridView = useGridLayout;
        
        //navigation
        [[self drawerController] checkPageDismiss];
        
        //ui update
        [self didSelectListOrGridLayout];
    }
}

- (void)didSelectListOrGridLayout {
    
    //shut any open keyboard
    [[self drawerController] resignActiveResponder];
    
    //shut drawers
    [[self drawerController] closeDrawersIfNeeded];
    
    //reload grid or list layout
    [[self drawerController] refreshLayout];
    
    //update buttons hilighting
    [self updateGridListButtons];
    
}

- (void)updateGridListButtons {
    _mainView.gridSwitch.highlighted = _isGridView;
    _mainView.listSwitch.highlighted = !_isGridView;
}

//bridge
- (HYBAppDelegate *)getDelegate {
    return (HYBAppDelegate *)[[UIApplication sharedApplication] delegate];
}

- (HYBDrawerController*)drawerController {
    return (HYBDrawerController*)[self getDelegate].window.rootViewController;
}

@end
