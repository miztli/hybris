//
// HYBCatalogView.m
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

#import "HYBCatalogView.h"
#import "HYBConstants.h"

#import "HYBCollectionViewCell.h"
#import "HYBListViewCell.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

@interface HYBCatalogView ()

@end

CGFloat headerHeight = 40.f;

@implementation HYBCatalogView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];        
    }
    return self;
}

- (void)setup {
    
    self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    self.autoresizesSubviews = YES;
    
    //header
    
     CGRect toolbarFrame = CGRectMake(0, defaultToolbarHeight, [self fW], headerHeight);
    _headerToolbar = [[HYBToolbar alloc] initWithFrame:toolbarFrame];
    _headerToolbar.backgroundColor = catalog_toolbar_background;
    
    [_headerToolbar setStatusbarMod:0];
    [_headerToolbar setToolbarHeight:headerHeight];
    
    //grid/list switch
    
    //grid icon
    _gridSwitch = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"ic_subnav_grid_grey.png"] highlightedImage:[UIImage imageNamed:@"ic_subnav_grid_white.png"]];
    _gridSwitch.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_GRID_SWITCH";
    _gridSwitch.userInteractionEnabled = YES;
    
    //list icon
    _listSwitch = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"ic_subnav_list_grey.png"] highlightedImage:[UIImage imageNamed:@"ic_subnav_list_white.png"]];
    _listSwitch.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_LIST_SWITCH";
    _listSwitch.userInteractionEnabled = YES;
    
       
     _headerToolbar.rightItems = [NSArray arrayWithObjects:_listSwitch, _gridSwitch, nil];
    
    
    //contentView
    
    CGRect contentBounds = CGRectMake(0, 0, [self bW], [self bH] - headerHeight - defaultToolbarHeight);

    CGRect contentFrame  = CGRectMake([self fX], headerHeight + defaultToolbarHeight, CGRectGetWidth(contentBounds), CGRectGetHeight(contentBounds));
    _contentView = [[UIView alloc] initWithFrame:contentFrame];

    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    
    //tableView
    _productsTable = [[UITableView alloc] initWithFrame:contentBounds style:UITableViewStylePlain];
    _productsTable.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_RESULTS_TABLE";
    [_productsTable registerClass:[HYBListViewCell class] forCellReuseIdentifier:@"HYBListViewCellID"];
    
    _productsTable.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _productsTable.autoresizesSubviews = YES;
    

    //grid view
    UICollectionViewFlowLayout *layout = [[UICollectionViewFlowLayout alloc] init];
    layout.itemSize = CGSizeMake(246, 300);
    layout.minimumInteritemSpacing = 5;
    layout.minimumLineSpacing = 5;

    _productsGrid = [[UICollectionView alloc] initWithFrame:contentBounds collectionViewLayout:layout];
    [_productsGrid registerClass:[HYBCollectionViewCell class] forCellWithReuseIdentifier:@"collectionViewCellId"];
    
    _productsGrid.backgroundColor = catalog_grid_background;
    _productsGrid.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _productsGrid.autoresizesSubviews = YES;
    
    
    //pile up
    [_contentView addSubview:_productsTable];
    [_contentView addSubview:_productsGrid];
    
    [self addSubview:_headerToolbar];
    [self addSubview:_contentView];
}

- (void)layoutSubviews {
    _contentView.frame = CGRectMake([_contentView fX], [_contentView fY], [self bW], [self bH] - [_contentView fY]);
    _productsTable.frame = _contentView.bounds;
    _productsGrid.frame  = _contentView.bounds;
}


@end