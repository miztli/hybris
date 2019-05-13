//
//  HYBProduct+Extends.m
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

#import "HYBProduct+Extends.h"
#import <objc/runtime.h>
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBObjects.h"


static char THUMB_URL;
static char IMAGE_URL;
static char IMAGES_DATA;
@implementation HYBProduct (Images)

//Dynamic association
@dynamic thumbnailURL;
@dynamic imageURL;
@dynamic galleryImagesData;

-(void)setThumbnailURL:(NSString *)thumbnailURL {
    objc_setAssociatedObject(self, &THUMB_URL, thumbnailURL, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
}

- (NSString*)thumbnailURL {
    
    NSString *pict = objc_getAssociatedObject(self, &THUMB_URL);
    
    if(self.firstVariantImage) return self.firstVariantImage;

    if (pict) return pict;
    
    return [self extractImages:THUMB];
}

-(void)setImageURL:(NSString *)imageURL {
    objc_setAssociatedObject(self, &IMAGE_URL, imageURL, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
}

- (NSString*)imageURL {
    
    NSString *pict = objc_getAssociatedObject(self, &IMAGE_URL);
    
    if (pict) return pict;
    
    return [self extractImages:IMAGE];
    
}

-(void)setGalleryImagesData:(NSArray *)galleryImagesData {
    objc_setAssociatedObject(self, &IMAGES_DATA, galleryImagesData, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
}

- (NSArray*)galleryImagesData {
    
    NSArray *picts = objc_getAssociatedObject(self, &IMAGES_DATA);
    
    if (picts) return picts;
    
    return [self extractImages:DATA];
}

//helpers

- (id)extractImages:(NSString*)returnType {
    
    NSMutableArray *tmpArray = [NSMutableArray array];
    
    BOOL canReturnThumb = NO;
    BOOL canReturnImage = NO;
    BOOL canReturnData = NO;
    
    NSString *thumbnailURLAntiLoop = nil;
    NSString *imageURLAntiLoop = nil;
    
    for (HYBImage *image in self.images) {
        
        //check format
        if([image.format isEqualToString:@"thumbnail"]) {
            if(image.url) {
                self.thumbnailURL = [NSString stringWithString:image.url];
                thumbnailURLAntiLoop = [NSString stringWithString:image.url];
                canReturnThumb = YES;
            }
        }
        
        else if([image.format isEqualToString:@"product"]) {
            if(image.url) {
                self.imageURL = [NSString stringWithString:image.url];
                imageURLAntiLoop = [NSString stringWithString:image.url];
                canReturnImage = YES;
            }
        }
        
        //check type
        if([image.imageType isEqualToString:GALLERY]) {
            //NSDictionary *imageDict = [image asDictionnary];
            //[tmpArray addObject:imageDict];
            
            [tmpArray addObject:image];
            canReturnData = YES;
        }
    }
    
    if ([tmpArray hyb_isNotBlank]) {
        self.galleryImagesData = [NSArray arrayWithArray:tmpArray];
    } else {
        self.galleryImagesData = [NSArray array];
    }
    
    if([returnType isEqualToString:THUMB] && canReturnThumb) {
        return thumbnailURLAntiLoop;
    }
    
    else if([returnType isEqualToString:IMAGE] && canReturnImage) {
        return imageURLAntiLoop;
    }
    
    else if([returnType isEqualToString:DATA] && canReturnData) {
        return self.galleryImagesData;
    }
    
    return nil;
}

- (NSString*)formattedPrice {
    
    if (self.priceRange) {
        NSString *min = self.priceRange.minPrice.formattedValue;
        NSString *max = self.priceRange.maxPrice.formattedValue;
        
        if ([min hyb_isNotBlank] && [max hyb_isNotBlank]) {
            return [NSString stringWithFormat:@"%@-%@", min, max];
        }
    }
    
    return self.price.formattedValue;
}

- (int)variantDimensionsNumber {
    if ([self.variantMatrix hyb_isNotBlank]) {
        return [self recursiveDimensionOfElement:[self.variantMatrix firstObject]];
    }
    
    return 0;
}

- (int)recursiveDimensionOfElement:(HYBVariantMatrixElement*)variant {
    if ([variant.elements hyb_isNotBlank]) {
        return 1 + [self recursiveDimensionOfElement:[variant.elements firstObject]];
    }
    
    return 1;
}

- (NSString *)pricingValueForItemAtIndex:(int)index {
    NSString *result = nil;
    
    if ([self.volumePrices hyb_isNotBlank]) {
        HYBPrice *price = [self.volumePrices objectAtIndex:index];
        result = price.formattedValue;
    }
    
    return result;
}

- (NSString *)quantityValueForItemAtIndex:(int)index {
    NSString *result = @"";
    if ([self.volumePrices hyb_isNotBlank]) {
        HYBPrice *price = self.volumePrices[index];
        result = [NSString stringWithFormat:@"%@-%@", price.minQuantity, price.maxQuantity];
    }
    return result;
}

- (BOOL)lowStock {
    if ([self.stock.stockLevelStatus isEqualToString:@"lowStock"]) return YES;
    return NO;
}

- (BOOL)isInStock {
    
    BOOL isInStock = NO;
    
    if (self.stock) {
        int intStock = [self.stock.stockLevel intValue];
        if(intStock > 0 || intStock == -1) {
            isInStock = YES;
        }
        
        if([self.stock.stockLevelStatus isEqualToString:@"inStock"]) {
            isInStock = YES;
        }
    }
    
    return isInStock;
}

@end
