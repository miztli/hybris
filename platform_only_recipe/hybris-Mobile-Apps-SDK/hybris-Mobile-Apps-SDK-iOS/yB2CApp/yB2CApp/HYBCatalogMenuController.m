//
// HYBCatalogMenuController.m
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

#import "HYBCatalogMenuController.h"
#import "HYBCategoryHierarchy.h"
#import "HYBB2CService.h"
#import "HYBBaseMenuCellView.h"

@interface HYBCatalogMenuController ()

@property (nonatomic) HYBBaseMenuView *mainView;
@property (nonatomic) CGFloat menuHeight;
@property (nonatomic) HYBCategoryHierarchy *categoriesTree;

@property(nonatomic, readonly) HYBCategoryHierarchy *currentlyShownCat;

@end

@implementation HYBCatalogMenuController


- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    if (self = [super initWithBackEndService:backendService]) {
        
        self.automaticallyAdjustsScrollViewInsets = YES;
        self.ignoreSearchFrame = YES;
        
        [self setupPayload];
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    //table view
    if (!_mainView) {
        _mainView = [[HYBBaseMenuView alloc] initWithFrame:self.view.frame];
        _mainView.accessibilityIdentifier = @"ACCESS_MAIN_MENU";
    }
    
    _mainView.menuTableView.delegate    = self;
    _mainView.menuTableView.dataSource  = self;
    
    _mainView.menuTableView.accessibilityIdentifier = @"ACCESS_CATALOG_MENU";
    
    [_mainView.menuTableView registerClass:[HYBBaseMenuCellView class] forCellReuseIdentifier:MENU_CELL_ID];
    
    //assign
    self.view = _mainView;

}

- (BOOL)isClosedMenu {    
    
    DDLogDebug(@"Is open menu on %@ with current shown category %@", self, _currentlyShownCat);
    if (_currentlyShownCat == nil) {
        return NO;
    } else {
        return NO; //[_currentlyShownCat isLeaf];
    }
}

- (void)setupPayload {
    
    _categories = [NSArray array];
    
    _menuHeight = 80;
    
    [self.backendService resetPagination];

    [self.backendService getCategoriesAndExecute:^(NSArray *foundCategories, NSError *error) {
        if (error) {
            DDLogError(@"Problems during the retrieval of the categories: %@", [error localizedDescription]);
        } else {
            if ([foundCategories count] > 0) {
                _categoriesTree = [foundCategories firstObject];
            }
            DDLogDebug(@"category tree loaded with %@", _categoriesTree);
            [self setCategoriesRefresh:foundCategories];
        }
    }];
}

- (void)setCategoriesRefresh:(NSArray *)categories {
    
    if (_currentlyShownCat == nil) {
        DDLogDebug(@"Currently shown not found, starting full load...");
        NSString *lastShownCatId = [[self.backendService userStorage] objectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
        if (lastShownCatId) {
            DDLogDebug(@"Last time stored %@ was found and will be rendered", lastShownCatId);
            if (_categoriesTree != nil && [_categoriesTree hasSubcategories]) {
                DDLogDebug(@"Saved category ID found %@, retrieving category from tree by id.", lastShownCatId);
                HYBCategoryHierarchy *startCat = [_categoriesTree findCategoryByIdInsideTree:lastShownCatId];
                NSAssert(startCat != nil, @"The category for stored id %@ is nil", lastShownCatId);
                [self setNavigationFromStartCategory:startCat];
            } else {
                DDLogError(@"Categories Tree seems to be not fully loaded.");
            }
        } else {
            DDLogDebug(@"No last saved found.");
            if ([[categories firstObject] isRoot]) {
                DDLogDebug(@"Root category identified as _currentlyShownCateogry and will be set ...");
                HYBCategoryHierarchy *startCategory = [categories firstObject];
                [self setNavigationFromStartCategory:startCategory];
            } else {
                NSString *msg = @"A wrong state in the navigation has occured, there must be either a last shown "
                "category saved or the delivered category must be the root.";
                @throw([NSException exceptionWithName:@"InitException" reason:msg userInfo:nil]);
            }
        }
    } else {
        [self setNavigationFromStartCategory:_currentlyShownCat];
    }
    
    
    [_mainView.menuTableView reloadData];
}


- (void)setNavigationFromStartCategory:(HYBCategoryHierarchy *)startCategory {
  
    NSAssert(startCategory != nil, @"Start category was nil.");
    [self setCurrentlyShown:startCategory];
    if ([_currentlyShownCat hasSubcategories]) {
        if ([startCategory isRoot]) {
            _categories = [startCategory subcategories];
        } else {
            _categories = [_currentlyShownCat listItSelfIncludingChildren];
        }
    } else {
        _categories = [[_currentlyShownCat parentCategory] listItSelfIncludingChildren];
    }
   
}

- (NSArray *)subcategoriesForCategory:(HYBCategoryHierarchy*)selectedCategory {
    
    NSArray *result = nil;
  
    BOOL shouldNavigateToParent = (selectedCategory == _currentlyShownCat);

    DDLogDebug(@"selected category is %@", selectedCategory);
    
    if (shouldNavigateToParent) {
        DDLogDebug(@"Navigation to parent ...");
        HYBCategoryHierarchy *parentOfSelected = [selectedCategory parentCategory];
        if ([parentOfSelected isRoot]) {
            DDLogDebug(@"Parent is root, no higher categories are present, staying at the same level.");
            result = [NSArray arrayWithArray:[parentOfSelected subcategories]];
        } else {
            DDLogDebug(@"Setting to content of category %@ its subcategories are %@", parentOfSelected, [parentOfSelected subcategories]);
            result = [parentOfSelected listItSelfIncludingChildren];
        }
        [self setCurrentlyShown:parentOfSelected];
        
    } else {
        
        if ([selectedCategory hasSubcategories]) {
            DDLogDebug(@"Selected %@ has subcategories %@", selectedCategory, [selectedCategory subcategories]);
            [self setCurrentlyShown:selectedCategory];
            result = [selectedCategory listItSelfIncludingChildren];
        } else {
            DDLogDebug(@"Selected %@ has NO subcategories ...", selectedCategory);
            [self setCurrentlyShown:[selectedCategory parentCategory]];
            result = [[selectedCategory parentCategory] listItSelfIncludingChildren];
        }
        
    }
 
    
    return [NSArray arrayWithArray:result];
     
}

- (void)setCurrentlyShown:(HYBCategoryHierarchy *)currentlyShown {
    DDLogDebug(@"Setting currently shown to %@", currentlyShown);
    
    _currentlyShownCat = currentlyShown;
    [[self.backendService userStorage] setObject:currentlyShown.id forKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
    [[self.backendService userStorage] synchronize];
}

#pragma mark Table Delegate Implementation

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_categories count]+1;
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return _menuHeight;
}

- (id)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBBaseMenuCellView *cell = [tableView dequeueReusableCellWithIdentifier:MENU_CELL_ID];    
    
    //clean up before reuse
    cell.accessibilityIdentifier = nil;
    cell.imageView.image = nil;
    cell.accessoryType = UITableViewCellAccessoryNone;
    cell.accessoryView = nil;
    cell.accessoryView.accessibilityIdentifier = nil;
    
    NSString *menuTiltle = @"";
    NSString *accessID = @"";
    NSString *iconName = nil;
    
    if(indexPath.row == 0) {
        menuTiltle = NSLocalizedString(@"sidebar_main_menu", @"Main Menu");
        accessID = @"ACCESS_CATALOG_MENU_ITEM_MAINMENU";
        iconName = @"Arrow_drawerBack.png";
    } else {
        HYBCategoryHierarchy *category = [_categories objectAtIndex:indexPath.row-1];
        
        BOOL isParentCategory = ([category.id isEqualToString:_currentlyShownCat.id]);
        
        menuTiltle = category.name;
        accessID = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_CATALOG_MENU_ITEM", (long)[indexPath row]];
        
        if (isParentCategory) {
            iconName = @"Arrow_drawerBack.png";
            cell.accessoryView.accessibilityIdentifier = @"ACCESS_CATALOG_MENU_ITEM_L_ARROW";
        } else if([category hasSubcategories]) {
            cell.accessoryView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"Arrow_drawerNext.png"]];
            cell.accessoryView.accessibilityIdentifier = @"ACCESS_CATALOG_MENU_ITEM_R_ARROW";
            cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
        }
        
    }    
    
    if (iconName) cell.imageView.image = [UIImage imageNamed:iconName];
    
    NSMutableDictionary *tmpParams = [NSMutableDictionary dictionaryWithObjectsAndKeys:
                                      menuTiltle,MENU_TITLE,
                                      accessID,MENU_ACCESSID,
                                      nil];
    
    [cell setupWithParams:[NSDictionary dictionaryWithDictionary:tmpParams]];
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    //top of navigation : back to main menu
    if (indexPath.row == 0) {
        DDLogDebug(@"back to main menu");
        [self popMenuControllerToRoot];
    } else {
        
        HYBCategoryHierarchy *tappedCategory = [_categories objectAtIndex:indexPath.row - 1];
        DDLogDebug(@"Category %@ was tapped.", tappedCategory);
        
        //second row : navigate back to parent category if not root
        if (indexPath.row == 1 && ([tappedCategory.id isEqualToString:_currentlyShownCat.id] || [tappedCategory.id isEqualToString:[_currentlyShownCat parentCategory].id])) {
            DDLogDebug(@"back to parent category");
            [self popMenuController];
            [self openCategoryInCatalog:[tappedCategory parentCategory]];
        } else {
            
            //else default category navigation behavior
            
            //open products on catalog view
            [self openCategoryInCatalog:tappedCategory];
            
            //toggle drawer
            if ([tappedCategory isLeaf]) {
                DDLogDebug(@"Leaf category tapped, closing the drawer.");
                [self setCurrentlyShown:tappedCategory];
                
                [self toggleLeftDrawer];
            } else {
                //display sub categories menu
                DDLogDebug(@"Category with sub categories tapped, refreshing the categories list.");
                
                HYBCatalogMenuController *subcategoryController = [[HYBCatalogMenuController alloc] initWithBackEndService:[self backEndService]];
                
                NSArray *resultingCategories = [self subcategoriesForCategory:tappedCategory];
                [subcategoryController setCategoriesRefresh:resultingCategories];
                
                [self pushMenuController:subcategoryController];
            }
        }
    }
}


@end