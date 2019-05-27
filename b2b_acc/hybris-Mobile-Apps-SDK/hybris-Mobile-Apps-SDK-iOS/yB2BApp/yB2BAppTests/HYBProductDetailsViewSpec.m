//
// HYBProductDetailsViewSpec.m
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
#import <CocoaLumberjack/DDTTYLogger.h>
#import <CocoaLumberjack/DDASLLogger.h>
#import "HYBProductDetailsView.h"
#import "HYBProduct.h"
#import "HYBB2BService.h"
#import "HYBAppDelegate.h"
#import "HYBConstants.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBFileToJsonConverter.h"

SpecBegin(HYBProductDetailsViewSpec)
   describe(@"HYBProductDetailsViewSpec", ^{
       __block HYBProductDetailsView *view;
       __block HYBProduct *product;
       beforeAll(^{
           HYBFileToJsonConverter *jsonConverter = [[HYBFileToJsonConverter alloc] init];
           view = [[HYBProductDetailsView alloc] init];
           product = [jsonConverter sampleProduct];
           [view refreshWithProduct:product];
       });
       it(@"should render the volume prices table", ^{
           [view toggleVolumePricing];
           [view toggleVolumePricing];
       });
       it(@"should render the variant picker", ^{
           UIPickerView *pickerView = nil;

           int numberOfDimensionsInPickerView = (int)[view numberOfComponentsInPickerView:pickerView];
           expect(numberOfDimensionsInPickerView).to.equal(@3);

           int valuesInFirstDimension = (int)[view pickerView:nil numberOfRowsInComponent:0];
           expect(valuesInFirstDimension).to.equal(@3);


           NSString *titleForRow = [view pickerView:pickerView titleForRow:0 forComponent:0];
           expect(titleForRow).to.equal(@"Black");

           titleForRow = [view pickerView:pickerView titleForRow:1 forComponent:0];
           expect(titleForRow).to.equal(@"Brown");

           titleForRow = [view pickerView:pickerView titleForRow:2 forComponent:0];
           expect(titleForRow).to.equal(@"Dark Brown");

           titleForRow = [view pickerView:pickerView titleForRow:0 forComponent:1];
           expect(titleForRow).to.equal(@"M");

           titleForRow = [view pickerView:pickerView titleForRow:1 forComponent:1];
           expect(titleForRow).to.equal(@"W");

           titleForRow = [view pickerView:pickerView titleForRow:0 forComponent:2];
           expect(titleForRow).to.equal(@"5");

           titleForRow = [view pickerView:pickerView titleForRow:2 forComponent:2];
           expect(titleForRow).to.equal(@"6");
       });
       it(@"should rotate the picker and adjust values", ^{
           UIPickerView *pickerView = [[UIPickerView alloc] init];

           NSString *titleForRow = [view pickerView:pickerView titleForRow:0 forComponent:0];
           expect(titleForRow).to.equal(@"Black");

           [view pickerView:pickerView didSelectRow:1 inComponent:0];

           [view pickerView:pickerView didSelectRow:1 inComponent:1];

           titleForRow = [view pickerView:pickerView titleForRow:0 forComponent:1];
           expect(titleForRow).to.equal(@"M");

           titleForRow = [view pickerView:pickerView titleForRow:12 forComponent:2];
           expect(titleForRow).to.equal(@"11");
       });
   });

SpecEnd
