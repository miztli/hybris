//
//  FakeData.m
// [y] hybris Platform
//
// Copyright (c) 2000-2014 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.


#import "FakeData.h"
#import "HYBGeolocatorObject.h"

NSString *loremIpsum = @"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut efficitur, libero sed fermentum sagittis, purus arcu commodo justo, a tristique justo lacus eu elit. Aliquam hendrerit, ligula in aliquet elementum, justo mauris porttitor magna, consectetur posuere justo neque hendrerit mi. Morbi dictum eget erat non sodales. In hac habitasse platea dictumst. Ut sagittis urna sed diam ullamcorper euismod. Ut laoreet est vel quam varius, at commodo ex egestas. Nunc porta, justo et maximus congue, leo massa maximus velit, ac condimentum sem lorem id nulla. Phasellus a velit non erat placerat congue non ac elit. Aliquam fringilla massa risus. Pellentesque ac nibh et sem consectetur vulputate id et ipsum.\n\nMaecenas ac dignissim ipsum, vel tempus magna. Quisque id nulla in elit molestie vulputate sed ullamcorper libero. Sed euismod, felis eu mattis elementum, nisi risus cursus nulla, a aliquet arcu eros vitae ex. Pellentesque id neque id ex viverra tincidunt. Nulla convallis, metus ut faucibus eleifend, turpis ex sodales orci, ut lobortis nibh tellus eget est. Sed vel leo quam. Suspendisse a ex et risus imperdiet maximus. Morbi ornare lacinia dolor ac finibus. Morbi a elit in massa aliquet commodo eu eget justo. Praesent quis massa faucibus, aliquam libero a, lobortis ligula. Maecenas tempor consectetur elit, non aliquet urna ornare non. Duis rutrum sed eros ac luctus. Nullam scelerisque nulla vitae sapien mollis mattis. Pellentesque sit amet mattis ante.\n\nPhasellus eget vestibulum purus. Nam semper posuere ornare. Aenean quis iaculis mi. Nulla facilisi. Phasellus ac lobortis sapien. Fusce maximus justo urna. In vitae metus et diam laoreet euismod. Curabitur nec ligula lectus. Nunc tristique nibh nisl, sit amet pulvinar leo maximus tincidunt. Sed fermentum volutpat augue ac iaculis. Aliquam sagittis elit et lacus dignissim, et varius dolor auctor. Fusce sollicitudin egestas nisl, a fringilla velit interdum at. Fusce pretium efficitur lacinia. Praesent egestas bibendum vulputate. Praesent pellentesque viverra pharetra.\n\nIn hendrerit, odio ultrices feugiat sodales, mauris ex bibendum dui, eu accumsan odio lacus id magna. Proin tristique a leo et feugiat. Nullam non nisi vitae eros consequat blandit a et nisi. Duis nunc velit, malesuada vitae ipsum vestibulum, fermentum gravida ligula. Phasellus sed neque enim. Integer ut ultrices est, a bibendum neque. Sed maximus tempor purus, eu luctus justo sodales sed. Vestibulum libero nunc, laoreet eu faucibus a, venenatis vitae nibh. Maecenas blandit et diam et rhoncus. Morbi gravida lacus convallis posuere tincidunt. Nulla at malesuada lorem.\n\nPraesent id lorem eget nulla commodo aliquet vel ac odio. Phasellus et nibh ac lectus facilisis iaculis. Cras turpis erat, dignissim vel interdum eu, placerat eu metus. Donec eget libero risus. In leo nisl, cursus convallis lobortis id, bibendum quis purus. Donec ac magna ac lorem pretium tincidunt. Maecenas pellentesque tellus ac augue pretium, eu imperdiet odio gravida.";

@implementation FakeData

//random utilities

int randomInt(int low, int high) {
    return (arc4random() % (high-low+1)) + low;
}

BOOL randomBool() {
    return (BOOL)randomInt(0, 1);
}

double randomRangedFloat(double smallNumber, double bigNumber) {
    double diff = bigNumber - smallNumber;
    return (((double) (arc4random() % ((unsigned)RAND_MAX + 1)) / RAND_MAX) * diff) + smallNumber;
}

+ (double)randomMove:(double)base {

    double variation = randomRangedFloat(.0001,.01);
    
    double final = base + variation;
    if (!randomBool()) final = base - variation;
    
    return final;
}

+ (NSDictionary*)randomData {   
    NSMutableDictionary *tmpDict = [NSMutableDictionary dictionary];
    
    [tmpDict setValue:[NSNumber numberWithInt:randomInt(0,10)] forKey:HYBGEOTYPE];
    [tmpDict setValue:[FakeData randomName] forKey:HYBGEONAME];
    [tmpDict setValue:[FakeData randomDescription] forKey:HYBGEODESCRIPTION];
    
    return [NSDictionary dictionaryWithDictionary:tmpDict];
}

+ (NSString*)randomName {
    NSString *splitOne = [loremIpsum substringFromIndex:randomInt(0,(int)loremIpsum.length)];
    if(splitOne.length <= 30) return splitOne;
    
    NSString *splitTwo = [splitOne substringToIndex:randomInt(5,30)];
    return splitTwo;
}

+ (NSString*)randomDescription {
    NSString *splitOne = [loremIpsum substringFromIndex:randomInt(0,(int)loremIpsum.length)];
    if(splitOne.length <= 200) return splitOne;
    
    NSString *splitTwo = [splitOne substringToIndex:randomInt(50,200)];
    return splitTwo;
}


//fake it!
+ (NSArray*)fakeGeoData:(NSInteger)number aroundLocation:(CLLocation*)location {
    
    NSMutableArray *tmpArray = [NSMutableArray array];
    
    for (int i = 0; i < number; i++) {
        
        double randomLatitude   = [FakeData randomMove:(double)location.coordinate.latitude];
        double randomLongitude  = [FakeData randomMove:(double)location.coordinate.longitude];
        
        NSDictionary *tmpDict = [NSDictionary dictionaryWithObjectsAndKeys:
                                 [NSNumber numberWithDouble:randomLatitude], HYBGEOLATITUDE,
                                 [NSNumber numberWithDouble:randomLongitude],HYBGEOLONGITUDE,
                                 [FakeData randomData],HYBGEODATA,
                                 nil];
        
        HYBGeolocatorObject *geolocatorObject = [HYBGeolocatorObject objectWithParams:tmpDict];
        
        [tmpArray addObject:geolocatorObject];
    }
    
    return [NSArray arrayWithArray:tmpArray];
}

@end
