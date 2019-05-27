//
//  HYBCategoryHierarchy+Tree.m
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

#import "HYBCategoryHierarchy+Tree.h"
#import <objc/runtime.h>

static char PARENT_CATEGORY;

@implementation HYBCategoryHierarchy (Tree)

//Dynamic association
@dynamic parent;


- (void)setParent:(HYBCategoryHierarchy *)parent{
    objc_setAssociatedObject(self,
                             &PARENT_CATEGORY,
                             parent,
                             OBJC_ASSOCIATION_RETAIN_NONATOMIC);
}

- (HYBCategoryHierarchy *)parent {
    return objc_getAssociatedObject(self,
                                    &PARENT_CATEGORY);
}

// helpers

- (void)assignParent {
    if(self.subcategories) {
        for(HYBCategoryHierarchy *currentCategory in self.subcategories) {
            currentCategory.parent = self;
            [currentCategory assignParent];
        }
    }
}

- (NSString *)description {
    NSMutableString *description = [NSMutableString stringWithFormat:@"%@: ", NSStringFromClass([self class])];
    
    if([self isRoot]){
        [description appendString:@",Root: "];
    }
    
    if(self.name) {
        [description appendString:self.name];
    }
    
    if ([self hasSubcategories]) {
        NSString *subCats = [[NSString alloc] initWithFormat:@", Subcategories:%lu", (unsigned long)[self.subcategories count]];
        [description appendString:subCats];
    }
    
    return description;
}

- (BOOL)hasSubcategories {
    return [self.subcategories count] > 0;
}

- (HYBCategoryHierarchy *)parentCategory {
    return self.parent;
}

- (BOOL)isRoot {
    return (self.parentCategory == nil);
}

- (BOOL)isLeaf {
    return ![self hasSubcategories];
}

- (NSArray *)listItSelfIncludingChildren {
    NSMutableArray *categoriesContainer = [[NSMutableArray alloc] initWithObjects:self, nil];
    [categoriesContainer addObjectsFromArray:self.subcategories];
    return [NSArray arrayWithArray:categoriesContainer];
}

- (HYBCategoryHierarchy *)findCategoryByIdInsideTree:(NSString *)categoryId {
    HYBCategoryHierarchy *result = nil;
    NSString *ownId = self.id;
    if ([categoryId isEqualToString:ownId]) {
        result = self;
    } else {
        if ([self hasSubcategories]) {
            for (HYBCategoryHierarchy *currentCat in self.subcategories) {
                result = [currentCat findCategoryByIdInsideTree:categoryId];
                if (result != nil) {
                    break;
                }
            }
        }
    }
    return result;
}

- (BOOL)hasChildId:(NSString *)categoryId {
    return ([self findCategoryByIdInsideTree:categoryId] != nil);
}

@end
