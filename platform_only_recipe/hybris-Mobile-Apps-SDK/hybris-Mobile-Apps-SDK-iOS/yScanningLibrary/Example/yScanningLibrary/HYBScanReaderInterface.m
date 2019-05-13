//
//  HYBScanReaderInterface.m
//  Pods
//
//  Created by Yann Bouschet on 05/05/2015.
//
//

#import "HYBScanReaderInterface.h"

@interface HYBScanReaderInterface ()

@end

@implementation HYBScanReaderInterface

- (void)addObserver:(id)observer {
    if(_observers && [_observers containsObject:observer]) {
        NSMutableArray *tmpArray = [NSMutableArray arrayWithArray:_observers];
        [tmpArray addObject:observer];
        _observers = [NSArray arrayWithArray:tmpArray];
    }
}

- (void)notifyObservers {
    for (id observer in _observers) {
        if ([observer respondsToSelector:@selector(didUpdate:)]) {
            [observer performSelector:@selector(didUpdate:) withObject:_reader];
        }
    }
}

@end
