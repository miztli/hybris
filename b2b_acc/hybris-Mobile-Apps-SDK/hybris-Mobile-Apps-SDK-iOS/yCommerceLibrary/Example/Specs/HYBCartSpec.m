//
// HYBCartSpec.m
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

#import <Specta/Specta.h>
#define EXP_SHORTHAND
#import <Expecta/Expecta.h>
#import "HYBB2BService.h"
#import "HYBObjects.h"

SpecBegin(HYBCart)
describe(@"NewHYBCart", ^{
    __block NSDictionary *json;
    __block HYBCart *cart;
    beforeAll(^{
        NSString *filePath = [[NSBundle bundleForClass:[self class]] pathForResource:@"createCartSampleResponse" ofType:@"json"];
        NSData *data = [NSData dataWithContentsOfFile:filePath];
        
        json = (NSDictionary *)[NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
        
        NSLog(@"NewHYBCart");
        cart = [HYBCart cartWithParams:json];
        [cart assignPromotions];
        expect(cart).to.beTruthy();
        
    });
    it(@"should create new cart from json", ^{
        expect(cart.code).to.beTruthy();
        expect([cart.totalItems intValue]).to.equal(0);
        expect([cart.totalPrice.value intValue]).to.equal(0);
    });
    it(@"should create present cart from json", ^{
        expect(cart.code).to.beTruthy();
        expect([cart.totalItems intValue]).to.equal(0);
        expect([cart.totalPrice.value intValue]).to.equal(0);
    });
});
describe(@"PresentHYBCart", ^{
    __block NSDictionary *json;
    __block HYBCart *cart;
    __block HYBOrderEntry *cartItem;
    
    __block HYBOrderEntry *firstEntry;
    
    beforeAll(^{
        NSString *filePath = [[NSBundle bundleForClass:[self class]] pathForResource:@"presentCartSampleResponse" ofType:@"json"];
        NSData *data = [NSData dataWithContentsOfFile:filePath];
        
        json = (NSDictionary *)[NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
        NSLog(@"PresentHYBCart");
        cart = [HYBCart cartWithParams:json];
        [cart assignPromotions];
        cartItem = [cart.entries firstObject];
        expect(cart).to.beTruthy();
        
        firstEntry = [cart.entries firstObject];
        
    });
    it(@"should create new cart from json", ^{
        expect(cart.code).to.beTruthy();
        expect(cart.code).to.beTruthy();
        expect([cart.totalItems intValue] > 0).to.beTruthy();
        expect(cart.totalPrice.value).to.equal(524.77);
        expect(cart.totalPrice.formattedValue).to.equal(@"$524.77");
        expect(cart.totalPriceWithTax.value).to.equal(524.77);
        expect(cart.totalUnitCount).to.equal(10);
        expect(cart.subTotal.formattedValue).to.equal(@"$541.00");
        expect(cart.orderDiscounts.formattedValue).to.equal(@"$16.23");
        NSString *msg = cart.orderDiscountsMessage;
        expect([msg isEqualToString:@"You saved $16.23 for spending over $500.00"]).to.beTruthy();
    });
    it(@"should contain the cart items", ^{
        expect(cart.entries).to.beTruthy();
        expect(cart.entries.count > 0).to.beTruthy();
    });
    it(@"should contain a proper items inside the items list", ^{
        expect(cartItem).to.beTruthy();
        HYBProduct *product = cartItem.product;
        expect(product).to.beTruthy();
        expect(product.code).to.beTruthy();
        expect(product.name).to.beTruthy();
        expect([cartItem.entryNumber intValue]).to.equal(0);
        expect(cartItem.quantity).to.equal(5);
        expect(cartItem.totalPrice.formattedValue).to.equal(@"$116.00");
        expect(cartItem.basePrice.formattedValue).to.beTruthy();
    });
    it(@"should handle a multid cartItem product", ^{
        cartItem = [cart.entries lastObject];
        expect(cartItem).to.beTruthy();
        HYBProduct *product = cartItem.product;
        expect(product.multidimensional).to.beTruthy();
        expect(product.formattedPrice).to.equal(@"$85.00-$85.00");
    });
    it(@"should save and retrieve the whole cart to archive", ^{
        NSString *cartKey = @"mySavedCartItem";
        
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        
        //encode and save
        NSData *encodedObject = [NSKeyedArchiver archivedDataWithRootObject:cartItem];
        [defaults setObject:encodedObject forKey:cartKey];
        [defaults synchronize];
        
        //load and decode
        NSData *loadedObject = [defaults objectForKey:cartKey];
        HYBOrderEntry *retrievedItem = [NSKeyedUnarchiver unarchiveObjectWithData:loadedObject];
        
        expect(retrievedItem).to.beTruthy();
        expect(retrievedItem.product).to.beTruthy();
        [defaults removeObjectForKey:cartKey];
    });
    
    //new HYBCart tests
    
    it(@"should check new HYBCart object", ^{
        expect(cart).to.beTruthy();
        
        expect(cart.calculated).to.beTruthy();
        expect(cart.net).to.beTruthy();
        expect(cart.code).to.equal(@"00000147");
        
        expect(cart.deliveryItemsQuantity).to.equal(10);
        
        expect(cart.guid).to.equal(@"39363cd996d5c867ddc168fb5821a7d58767935d");
        
        expect(cart.pickupItemsQuantity).to.equal(0);
        
        expect(cart.site).to.equal(@"powertools");
        expect(cart.store).to.equal(@"powertools");
        
        expect(cart.totalItems).to.equal(2);
        expect(cart.totalUnitCount).to.equal(10);
        
        expect(cart.deliveryMode.code).to.beFalsy();
        expect(cart.deliveryCost).to.beFalsy();
    });
    
    it(@"should check HYBCart potentialProductPromotions", ^{
        expect(cart.potentialProductPromotions).to.beTruthy();
        expect([cart.potentialProductPromotions count]).to.equal(1);
        
        HYBPromotionResult *productPromotion = [cart.potentialProductPromotions firstObject];
        expect(productPromotion).to.beTruthy();
        expect(productPromotion.promotion.descriptor).to.equal(@"Buy 2 Power Drills, Get 1 Free");
        
        expect(productPromotion.consumedEntries).to.beTruthy();
        expect([productPromotion.consumedEntries count]).to.equal(1);
        
        HYBPromotionOrderEntryConsumed * consumedEntry = [productPromotion.consumedEntries firstObject];
        expect(consumedEntry).to.beTruthy();
        expect(consumedEntry.code).to.beTruthy();
        expect(consumedEntry.adjustedUnitPrice).to.equal(29);
        expect(consumedEntry.quantity).to.equal(2);
        expect(consumedEntry.orderEntryNumber).to.equal(0);
        
        HYBPromotion *promotion = productPromotion.promotion;
        expect(promotion).to.beTruthy();
        expect(promotion.code).to.equal(@"B2GOFPowerDrills");
        expect(promotion.couldFireMessages).to.beTruthy();
        expect(promotion.descriptor).to.equal(@"Buy 2 Power Drills, Get 1 Free");
        expect(promotion.endDate).to.equal(@"2099-01-01T00:00:00");
        expect(promotion.promotionType).to.equal(@"AcceleratorProductBOGOFPromotion");
        expect(promotion.firedMessages).to.beTruthy();
        expect([promotion.firedMessages count]).to.equal(1);
        
        
    });
        
    it(@"should check the totalTax in the cart", ^{
        expect(cart.totalTax).to.beTruthy();
        expect(cart.totalTax.currencyIso).to.equal(@"USD");
        expect(cart.totalTax.formattedValue).to.equal(@"$0.00");
        expect(cart.totalTax.priceType).to.equal(@"BUY");
        expect(cart.totalTax.value).to.equal(0);
        expect(cart.totalTax.minQuantity).to.beFalsy();
        expect(cart.totalTax.maxQuantity).to.beFalsy();
    });
    
    it(@"should check the subTotal in the cart", ^{
        expect(cart.subTotal).to.beTruthy();
        expect(cart.subTotal.currencyIso).to.equal(@"USD");
        expect(cart.subTotal.formattedValue).to.equal(@"$541.00");
        expect(cart.subTotal.priceType).to.equal(@"BUY");
        expect(cart.subTotal.value).to.equal(541);
        expect(cart.subTotal.minQuantity).to.beFalsy();
        expect(cart.subTotal.maxQuantity).to.beFalsy();
    });
    
    it(@"should check the totalDiscounts in the cart", ^{
        expect(cart.totalDiscounts).to.beTruthy();
        expect(cart.totalDiscounts.currencyIso).to.equal(@"USD");
        expect(cart.totalDiscounts.formattedValue).to.equal(@"$45.23");
        expect(cart.totalDiscounts.priceType).to.equal(@"BUY");
        expect(cart.totalDiscounts.minQuantity).to.beFalsy();
        expect(cart.totalDiscounts.maxQuantity).to.beFalsy();
    });
    
    it(@"should check the productDiscounts in the cart", ^{
        expect(cart.productDiscounts).to.beTruthy();
        expect(cart.productDiscounts.currencyIso).to.equal(@"USD");
        expect(cart.productDiscounts.formattedValue).to.equal(@"$29.00");
        expect(cart.productDiscounts.priceType).to.equal(@"BUY");
        expect(cart.productDiscounts.value).to.equal(29);
        expect(cart.productDiscounts.minQuantity).to.beFalsy();
        expect(cart.productDiscounts.maxQuantity).to.beFalsy();
    });
    
    it(@"should check HYBCart deliveryOrderGroups", ^{
        expect(cart.deliveryOrderGroups).to.beTruthy();
        expect([cart.deliveryOrderGroups count]).to.equal(1);
        
        HYBDeliveryOrderEntryGroup *deliveryOrderGroup = [cart.deliveryOrderGroups firstObject];
        expect(deliveryOrderGroup).to.beTruthy();
        
        expect(deliveryOrderGroup.entries).to.beTruthy();
        expect([deliveryOrderGroup.entries count]).to.equal(2);
        
        expect(deliveryOrderGroup.totalPriceWithTax).to.beTruthy();
        expect(deliveryOrderGroup.totalPriceWithTax).to.beTruthy();
        expect(deliveryOrderGroup.totalPriceWithTax.currencyIso).to.equal(@"USD");
        expect(deliveryOrderGroup.totalPriceWithTax.formattedValue).to.equal(@"$541.00");
        expect(deliveryOrderGroup.totalPriceWithTax.priceType).to.equal(@"BUY");
        expect(deliveryOrderGroup.totalPriceWithTax.value).to.equal(541);
        expect(deliveryOrderGroup.totalPriceWithTax.minQuantity).to.beFalsy();
        expect(deliveryOrderGroup.totalPriceWithTax.maxQuantity).to.beFalsy();
        
    });
    
    it(@"should partially check one HYBEntry from HYBDeliveryOrderGroup of the cart", ^{
        
        HYBDeliveryOrderEntryGroup *deliveryOrderGroup = [cart.deliveryOrderGroups firstObject];
        
        HYBOrderEntry *entry = [deliveryOrderGroup.entries firstObject];
        
        expect(entry).to.beTruthy();
        expect(entry.entryNumber).to.equal(0);
        expect(entry.updateable).to.beTruthy();
        expect(entry.quantity).to.equal(5);
        expect(entry.discountMessage).to.beFalsy();
        
        expect(entry.product).to.beTruthy();
        expect(entry.product.code).to.equal(@"3884636");
        expect(entry.product.manufacturer).to.equal(@"Skil");
        expect(entry.product.name).to.equal(@"Hammer drill 6365");
        
        expect(entry.basePrice).to.beTruthy();
        expect(entry.basePrice.currencyIso).to.equal(@"USD");
        expect(entry.basePrice.formattedValue).to.equal(@"$29.00");
        expect(entry.basePrice.priceType).to.equal(@"BUY");
        expect(entry.basePrice.value).to.equal(29);
        expect(entry.basePrice.minQuantity).to.beFalsy();
        expect(entry.basePrice.maxQuantity).to.beFalsy();
        
        expect(entry.totalPrice).to.beTruthy();
        expect(entry.totalPrice.currencyIso).to.equal(@"USD");
        expect(entry.totalPrice.formattedValue).to.equal(@"$116.00");
        expect(entry.totalPrice.priceType).to.equal(@"BUY");
        expect(entry.totalPrice.value).to.equal(116);
        expect(entry.totalPrice.minQuantity).to.beFalsy();
        expect(entry.totalPrice.maxQuantity).to.beFalsy();
    });
    
    it(@"should check HYBCart appliedOrderPromotions", ^{
        expect(cart.appliedOrderPromotions).to.beTruthy();
        expect([cart.appliedOrderPromotions count]).to.equal(1);
        
        HYBPromotionResult *orderPromotion = [cart.appliedOrderPromotions firstObject];
        expect(orderPromotion).to.beTruthy();
        expect(orderPromotion.descriptor).to.equal(@"You saved $16.23 for spending over $500.00");
        
        HYBPromotion *promotion = orderPromotion.promotion;
        expect(promotion).to.beTruthy();
        expect(promotion.code).to.equal(@"3PercentDiscountOver500");
        expect(promotion.couldFireMessages).to.beFalsy();
        expect(promotion.descriptor).to.equal(@"3% off orders over $500");
        expect(promotion.endDate).to.equal(@"2099-01-01T00:00:00");
        expect(promotion.promotionType).to.equal(@"Order threshold fixed percentage discount");
        expect(promotion.firedMessages).to.beTruthy();
        expect([promotion.firedMessages count]).to.equal(1);
        
    });
    
    it(@"should check HYBCart appliedProductPromotions", ^{
        expect(cart.appliedProductPromotions).to.beTruthy();
        expect([cart.appliedProductPromotions count]).to.equal(1);
        
        HYBPromotionResult *productPromotion = [cart.appliedProductPromotions firstObject];
        expect(productPromotion).to.beTruthy();
        expect(productPromotion.descriptor).to.equal(@"You get 1 Power Drill free for purchasing 2 Power Drills");
        
        expect(productPromotion.consumedEntries).to.beTruthy();
        expect([productPromotion.consumedEntries count]).to.equal(2);
        
        HYBPromotionOrderEntryConsumed * consumedEntry = [productPromotion.consumedEntries firstObject];
        expect(consumedEntry).to.beTruthy();
        expect(consumedEntry.code).to.beTruthy();
        expect(consumedEntry.adjustedUnitPrice).to.equal(29);
        expect(consumedEntry.quantity).to.equal(2);
        expect(consumedEntry.orderEntryNumber).to.equal(0);
        
        HYBPromotion *promotion = productPromotion.promotion;
        expect(promotion).to.beTruthy();
        expect(promotion.code).to.equal(@"B2GOFPowerDrills");
        expect(promotion.couldFireMessages).to.beTruthy();
        expect(promotion.descriptor).to.equal(@"Buy 2 Power Drills, Get 1 Free");
        expect(promotion.endDate).to.equal(@"2099-01-01T00:00:00");
        expect(promotion.promotionType).to.equal(@"AcceleratorProductBOGOFPromotion");
        expect(promotion.firedMessages).to.beTruthy();
        expect([promotion.firedMessages count]).to.equal(1);
    });
    
    it(@"should check HYBCart entries", ^{
        expect(cart.entries).to.beTruthy();
        expect([cart.entries count]).to.equal(2);
    });
    
    it(@"should check one HYBEntry from the cart", ^{
        expect(firstEntry).to.beTruthy();
        expect(firstEntry.entryNumber).to.equal(0);
        expect(firstEntry.updateable).to.beTruthy();
        expect(firstEntry.quantity).to.equal(5);
        expect(firstEntry.discountMessage).to.beTruthy();
        expect(firstEntry.discountMessage).to.equal(@"Buy 2 Power Drills, Get 1 Free");
    });
    
    it(@"should check the basePrice from the first HYBEntry in the cart", ^{
        expect(firstEntry.basePrice).to.beTruthy();
        expect(firstEntry.basePrice.currencyIso).to.equal(@"USD");
        expect(firstEntry.basePrice.formattedValue).to.equal(@"$29.00");
        expect(firstEntry.basePrice.priceType).to.equal(@"BUY");
        expect(firstEntry.basePrice.value).to.equal(29);
        expect(firstEntry.basePrice.minQuantity).to.beFalsy();
        expect(firstEntry.basePrice.maxQuantity).to.beFalsy();
    });
    
    it(@"should check the product from the first HYBEntry in the cart", ^{
        //product
        expect(firstEntry.product).to.beTruthy();
        
        HYBProduct *product = firstEntry.product;
        expect(product.code).to.equal(@"3884636");
        expect(product.manufacturer).to.equal(@"Skil");
        
        expect(product.name).to.equal(@"Hammer drill 6365");
        
        //HYBImage check
        expect(product.images).to.beTruthy();
        expect([product.images count]).to.equal(4);
        
        HYBImage *image = [product.images firstObject];
        expect(image.altText).to.beTruthy();
        expect(image.altText).to.equal(@"Hammer drill 6365");
        expect(image.format).to.beTruthy();
        expect(image.format).to.equal(@"zoom");
        expect(image.imageType).to.beTruthy();
        expect(image.imageType).to.equal(@"PRIMARY");
        expect(image.url).to.beTruthy();
        expect(image.url).to.equal(@"/medias/?context=bWFzdGVyfGltYWdlc3wyNjIzN3xpbWFnZS9qcGVnfGltYWdlcy9oNjIvaDdmLzg3OTYxODA0MTQ0OTQuanBnfGIwMzliZjdjNzc0ZjNlYTY4ZmI5MDUzZWUyM2ZkMWZiYzkxMjcwMTM3MzZiYmI1NmNjMmY3NTQxOGZlMDlhMWQ");
        
        //HYBStock check
        expect(product.stock).to.beTruthy();
        expect(product.stock.stockLevel).to.equal(491);
        expect(product.stock.stockLevelStatus).to.equal(@"inStock");
        
        expect(product.url).to.equal(@"/Open-Catalogue/Tools/Power-Drills/Hammer-drill-6365/p/3884636");
        
    });
    
    it(@"should check the totalPrice from the first HYBEntry in the cart", ^{
        expect(firstEntry.totalPrice).to.beTruthy();
        expect(firstEntry.totalPrice.currencyIso).to.equal(@"USD");
        expect(firstEntry.totalPrice.formattedValue).to.equal(@"$116.00");
        expect(firstEntry.totalPrice.priceType).to.equal(@"BUY");
        expect(firstEntry.totalPrice.value).to.equal(116);
        expect(firstEntry.totalPrice.minQuantity).to.beFalsy();
        expect(firstEntry.totalPrice.maxQuantity).to.beFalsy();
    });
    
    
});
describe(@"PresentHYBCartFromGetCartsList", ^{
    __block NSDictionary *json;
    __block HYBCart *cart;
    __block HYBOrderEntry *cartItem;
    beforeAll(^{
        NSString *filePath = [[NSBundle bundleForClass:[self class]] pathForResource:@"getCartsSampleResponse" ofType:@"json"];
        NSData *data = [NSData dataWithContentsOfFile:filePath];
        
        json = (NSDictionary *)[NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
        
        NSDictionary *cartJson = [[json objectForKey:@"carts"] firstObject];
        expect(cartJson).to.beTruthy();
        NSLog(@"PresentHYBCartFromGetCartsList");
        cart = [HYBCart cartWithParams:cartJson];
        [cart assignPromotions];
        cartItem = [cart.entries firstObject];
        expect(cart).to.beTruthy();
    });
    it(@"should create new cart from json", ^{
        expect(cart.code).to.beTruthy();
        expect(cart.code).to.beTruthy();
        expect([cart.totalItems intValue] > 0).to.beTruthy();
        expect(cart.totalPrice).to.beTruthy();
        expect(cart.totalPrice.formattedValue).to.beTruthy();
        expect(cart.totalPriceWithTax.value).to.equal(884.64);
        expect(cart.totalUnitCount).to.equal(22);
        expect(cart.subTotal.formattedValue).to.equal(@"$912.00");
        
    });
    it(@"should contain the cart items", ^{
        expect(cart.entries).to.beTruthy();
        expect(cart.entries.count > 0).to.beTruthy();
    });
    it(@"should contain a proper items inside the items list", ^{
        expect(cartItem).to.beTruthy();
        HYBProduct *product = cartItem.product;
        expect(product).to.beTruthy();
        expect(product.code).to.beTruthy();
        expect(product.name).to.beTruthy();
        expect([cartItem.entryNumber intValue]).to.equal(0);
        expect(cartItem.quantity).to.equal(10);
        expect(cartItem.totalPrice.formattedValue).to.beTruthy();
        expect(cartItem.basePrice.formattedValue).to.beTruthy();
        NSString *itemDiscount = cartItem.discountMessage;
        expect(itemDiscount).to.beTruthy();
    });
    it(@"should contain order promotions and cart item discounts", ^{
        expect(cart.orderDiscounts.formattedValue).to.equal(@"$27.36");
        expect(@"You saved $16.23 for spending over $500.00").to.equal(@"You saved $16.23 for spending over $500.00");
        
        cartItem = [cart.entries firstObject];
        expect(cartItem.discountMessage).to.beTruthy();
        
        cartItem = [cart.entries objectAtIndex:1];
        expect(cartItem.discountMessage).to.beTruthy();
    });
    it(@"should save and retrieve the whole cart to archive", ^{
        NSString *cartKey = @"mySavedCartItem";
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        
        //encode and save
        NSData *encodedObject = [NSKeyedArchiver archivedDataWithRootObject:cartItem];
        [defaults setObject:encodedObject forKey:cartKey];
        [defaults synchronize];
        
        //load and decode
        NSData *loadedObject = [defaults objectForKey:cartKey];
        HYBOrderEntry *retrievedItem = [NSKeyedUnarchiver unarchiveObjectWithData:loadedObject];
        
        expect(retrievedItem).to.beTruthy();
        expect(retrievedItem.product).to.beTruthy();
        [defaults removeObjectForKey:cartKey];
    });
});
SpecEnd
