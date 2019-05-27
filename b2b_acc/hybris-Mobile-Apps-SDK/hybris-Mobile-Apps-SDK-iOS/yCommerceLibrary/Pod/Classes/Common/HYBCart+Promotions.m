//
//  HYBCart+Promotions.m
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

#import "HYBCart+Promotions.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBPromotionResult.h"
#import "HYBPromotion.h"
#import "HYBPromotionOrderEntryConsumed.h"
#import "HYBOrderEntry.h"
#import "HYBOrderEntry+Discounts.h"

@implementation HYBCart (Promotions)


- (void)assignPromotions {
    if ([self.appliedProductPromotions hyb_isNotBlank]) {
        
        for (HYBPromotionResult *promo in self.appliedProductPromotions) {
            
            NSString *promotionDescription  = promo.promotion.descriptor;
            NSArray *consumedEntries        = promo.consumedEntries;
            
            for (HYBPromotionOrderEntryConsumed *consumedEntry in consumedEntries) {
                
                NSNumber *entryNumber = consumedEntry.orderEntryNumber;
                
                for (HYBOrderEntry *entry in self.entries) {
                    if([[entry entryNumber] intValue] == [entryNumber intValue]) {
                        entry.discountMessage = [NSString stringWithString:promotionDescription];
                        break;
                    }
                }
            }
        }
    }
}

- (NSString*)orderDiscountsMessage {
    if([self.appliedOrderPromotions hyb_isNotBlank]) {
        return [[self.appliedOrderPromotions firstObject] descriptor];
    }
    return nil;
}

@end
