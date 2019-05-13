//
//  HYBScanReaderInterface.h
//  Pods
//
//  Created by Yann Bouschet on 05/05/2015.
//
//

#import <UIKit/UIKit.h>

@interface HYBScanReaderInterface : NSObject

@property (nonatomic) id        reader;
@property (nonatomic) UIView    *view;
@property (nonatomic) NSArray   *allowedBarcodeTypes;
@property (nonatomic) NSArray   *observers;



@end
