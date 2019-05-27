#import "enunciate-common.h"
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision_H

/**
 * (no documentation provided)
 */
enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision
{

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ACCEPT,

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REVIEW,

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REJECT,

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ERROR
};
/**
 * Reads a CisDecision from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The CisDecision, or NULL if unable to be read.
 */
static enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *xmlTextReaderReadHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(xmlTextReaderPtr reader);

/**
 * Writes a CisDecision to XML.
 *
 * @param writer The XML writer.
 * @param _cisDecision The CisDecision to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(xmlTextWriterPtr writer, enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *_cisDecision);

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _cisDecision The string to format.
 * @return The enum value or NULL on error.
 */
static enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *formatStringToHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(NSString *_cisDecision);

/**
 * Utility method for getting the string value of CisDecision.
 *
 * @param _cisDecision The CisDecision to format.
 * @return The string value or NULL on error.
 */
static NSString *formatHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionTypeToString(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *_cisDecision);
#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType_H

/**
 * (no documentation provided)
 */
enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType
{

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_TO,

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_FROM,

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_BILL_TO,

  /**
   * (no documentation provided)
   */
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_ADMIN_ORIGIN
};
/**
 * Reads a CisAddressType from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The CisAddressType, or NULL if unable to be read.
 */
static enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *xmlTextReaderReadHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(xmlTextReaderPtr reader);

/**
 * Writes a CisAddressType to XML.
 *
 * @param writer The XML writer.
 * @param _cisAddressType The CisAddressType to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(xmlTextWriterPtr writer, enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *_cisAddressType);

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _cisAddressType The string to format.
 * @return The enum value or NULL on error.
 */
static enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *formatStringToHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(NSString *_cisAddressType);

/**
 * Utility method for getting the string value of CisAddressType.
 *
 * @param _cisAddressType The CisAddressType to format.
 * @return The string value or NULL on error.
 */
static NSString *formatHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeTypeToString(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *_cisAddressType);
#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType_H */

@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult;
@class HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest;

#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress_H

/**
 *  Representation of an address.
 *  
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress : NSObject <EnunciateXML>
{
  @private
    enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *_type;
    NSString *_title;
    NSString *_firstName;
    NSString *_lastName;
    NSString *_email;
    NSString *_addressLine1;
    NSString *_addressLine2;
    NSString *_addressLine3;
    NSString *_addressLine4;
    NSString *_zipCode;
    NSString *_city;
    NSString *_state;
    NSString *_country;
    NSString *_phone;
    NSString *_company;
    NSString *_longitude;
    NSString *_latitude;
    NSString *_facilityType;
    NSString *_facilityName;
    NSString *_faxNumber;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
}

/**
 * Type of the address.
 */
- (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *) type;

/**
 * Type of the address.
 */
- (void) setType: (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *) newType;

/**
 * Title.
 */
- (NSString *) title;

/**
 * Title.
 */
- (void) setTitle: (NSString *) newTitle;

/**
 * First name.
 */
- (NSString *) firstName;

/**
 * First name.
 */
- (void) setFirstName: (NSString *) newFirstName;

/**
 * Last name.
 */
- (NSString *) lastName;

/**
 * Last name.
 */
- (void) setLastName: (NSString *) newLastName;

/**
 * Email.
 */
- (NSString *) email;

/**
 * Email.
 */
- (void) setEmail: (NSString *) newEmail;

/**
 * First address line.
 */
- (NSString *) addressLine1;

/**
 * First address line.
 */
- (void) setAddressLine1: (NSString *) newAddressLine1;

/**
 * Second address line.
 */
- (NSString *) addressLine2;

/**
 * Second address line.
 */
- (void) setAddressLine2: (NSString *) newAddressLine2;

/**
 * Third address line.
 */
- (NSString *) addressLine3;

/**
 * Third address line.
 */
- (void) setAddressLine3: (NSString *) newAddressLine3;

/**
 * Fourth address line.
 */
- (NSString *) addressLine4;

/**
 * Fourth address line.
 */
- (void) setAddressLine4: (NSString *) newAddressLine4;

/**
 * Zip/Postal code.
 */
- (NSString *) zipCode;

/**
 * Zip/Postal code.
 */
- (void) setZipCode: (NSString *) newZipCode;

/**
 * City.
 */
- (NSString *) city;

/**
 * City.
 */
- (void) setCity: (NSString *) newCity;

/**
 * Second part of the ISO 3166-2 subdivision code (e.g. state or province code without country).
 */
- (NSString *) state;

/**
 * Second part of the ISO 3166-2 subdivision code (e.g. state or province code without country).
 */
- (void) setState: (NSString *) newState;

/**
 * 2 letter ISO 3166-1 alpha-2 country code.
 */
- (NSString *) country;

/**
 * 2 letter ISO 3166-1 alpha-2 country code.
 */
- (void) setCountry: (NSString *) newCountry;

/**
 * The phone number.
 */
- (NSString *) phone;

/**
 * The phone number.
 */
- (void) setPhone: (NSString *) newPhone;

/**
 * The company name.
 */
- (NSString *) company;

/**
 * The company name.
 */
- (void) setCompany: (NSString *) newCompany;

/**
 * Longitude of the address. Negative values are in the Western hemisphere. Positive values are in the Eastern hemisphere.
 */
- (NSString *) longitude;

/**
 * Longitude of the address. Negative values are in the Western hemisphere. Positive values are in the Eastern hemisphere.
 */
- (void) setLongitude: (NSString *) newLongitude;

/**
 * Latitude of the address. Negative values are in the Southern hemisphere. Positive values are in the Northern hemisphere.
 */
- (NSString *) latitude;

/**
 * Latitude of the address. Negative values are in the Southern hemisphere. Positive values are in the Northern hemisphere.
 */
- (void) setLatitude: (NSString *) newLatitude;

/**
 * the type of the facility.
 */
- (NSString *) facilityType;

/**
 * the type of the facility.
 */
- (void) setFacilityType: (NSString *) newFacilityType;

/**
 * The name of the facility.
 */
- (NSString *) facilityName;

/**
 * The name of the facility.
 */
- (void) setFacilityName: (NSString *) newFacilityName;

/**
 * The fax number belonging to this address.
 */
- (NSString *) faxNumber;

/**
 * The fax number belonging to this address.
 */
- (void) setFaxNumber: (NSString *) newFaxNumber;

/**
 * Vendor specific values to pass in the request.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * Vendor specific values to pass in the request.
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult : NSObject
{
  @private
    NSString *_clientRefId;
    NSString *_vendorId;
    NSString *_vendorReasonCode;
    NSString *_vendorStatusCode;
    NSString *_identifier;
    NSString *_href;
    enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *_decision;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorResponses;
}

/**
 * (no documentation provided)
 */
- (NSString *) clientRefId;

/**
 * (no documentation provided)
 */
- (void) setClientRefId: (NSString *) newClientRefId;

/**
 * (no documentation provided)
 */
- (NSString *) vendorId;

/**
 * (no documentation provided)
 */
- (void) setVendorId: (NSString *) newVendorId;

/**
 * (no documentation provided)
 */
- (NSString *) vendorReasonCode;

/**
 * (no documentation provided)
 */
- (void) setVendorReasonCode: (NSString *) newVendorReasonCode;

/**
 * (no documentation provided)
 */
- (NSString *) vendorStatusCode;

/**
 * (no documentation provided)
 */
- (void) setVendorStatusCode: (NSString *) newVendorStatusCode;

/**
 * (no documentation provided)
 */
- (NSString *) identifier;

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier;

/**
 * (no documentation provided)
 */
- (NSString *) href;

/**
 * (no documentation provided)
 */
- (void) setHref: (NSString *) newHref;

/**
 * (no documentation provided)
 */
- (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *) decision;

/**
 * (no documentation provided)
 */
- (void) setDecision: (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *) newDecision;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorResponses;

/**
 * (no documentation provided)
 */
- (void) setVendorResponses: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorResponses;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem : NSObject
{
  @private
    int *_identifier;
    NSString *_itemCode;
    int *_quantity;
    NSString *_productDescription;
    NSDecimalNumber *_unitPrice;
    NSString *_taxCode;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
}

/**
 * (no documentation provided)
 */
- (int *) identifier;

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (int *) newIdentifier;

/**
 * (no documentation provided)
 */
- (NSString *) itemCode;

/**
 * (no documentation provided)
 */
- (void) setItemCode: (NSString *) newItemCode;

/**
 * (no documentation provided)
 */
- (int *) quantity;

/**
 * (no documentation provided)
 */
- (void) setQuantity: (int *) newQuantity;

/**
 * (no documentation provided)
 */
- (NSString *) productDescription;

/**
 * (no documentation provided)
 */
- (void) setProductDescription: (NSString *) newProductDescription;

/**
 * (no documentation provided)
 */
- (NSDecimalNumber *) unitPrice;

/**
 * (no documentation provided)
 */
- (void) setUnitPrice: (NSDecimalNumber *) newUnitPrice;

/**
 * (no documentation provided)
 */
- (NSString *) taxCode;

/**
 * (no documentation provided)
 */
- (void) setTaxCode: (NSString *) newTaxCode;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest_H

/**
 *  
 *  Customer usage request that holds customer usage information.
 *  
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest : NSObject <EnunciateXML>
{
  @private
    NSDate *_fromDate;
    NSDate *_toDate;
    NSString *_customerId;
    NSString *_subscriptionId;
    NSString *_usageChargeName;
    NSDecimalNumber *_unitsConsumed;
}

/**
 * from date for the customer usage.
 */
- (NSDate *) fromDate;

/**
 * from date for the customer usage.
 */
- (void) setFromDate: (NSDate *) newFromDate;

/**
 * to date for the customer usage.
 */
- (NSDate *) toDate;

/**
 * to date for the customer usage.
 */
- (void) setToDate: (NSDate *) newToDate;

/**
 * customer id for the current usage.
 */
- (NSString *) customerId;

/**
 * customer id for the current usage.
 */
- (void) setCustomerId: (NSString *) newCustomerId;

/**
 * the subscription id.
 */
- (NSString *) subscriptionId;

/**
 * the subscription id.
 */
- (void) setSubscriptionId: (NSString *) newSubscriptionId;

/**
 * usage charge name for the customer usage.
 */
- (NSString *) usageChargeName;

/**
 * usage charge name for the customer usage.
 */
- (void) setUsageChargeName: (NSString *) newUsageChargeName;

/**
 * units consumed.
 */
- (NSDecimalNumber *) unitsConsumed;

/**
 * units consumed.
 */
- (void) setUnitsConsumed: (NSDecimalNumber *) newUnitsConsumed;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry : NSObject
{
  @private
    NSString *_oneTimeChargeTime;
    NSDecimalNumber *_chargePrice;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
    int *_numberOfCycles;
}

/**
 * (no documentation provided)
 */
- (NSString *) oneTimeChargeTime;

/**
 * (no documentation provided)
 */
- (void) setOneTimeChargeTime: (NSString *) newOneTimeChargeTime;

/**
 * (no documentation provided)
 */
- (NSDecimalNumber *) chargePrice;

/**
 * (no documentation provided)
 */
- (void) setChargePrice: (NSDecimalNumber *) newChargePrice;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;

/**
 * (no documentation provided)
 */
- (int *) numberOfCycles;

/**
 * (no documentation provided)
 */
- (void) setNumberOfCycles: (int *) newNumberOfCycles;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest_H

/**
 *  A payment request to for example authorize or capture an amount.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest : NSObject <EnunciateXML>
{
  @private
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_parameters;
}

/**
 * Vendor specific parameters which aren't represented in the generic interface.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) parameters;

/**
 * Vendor specific parameters which aren't represented in the generic interface.
 */
- (void) setParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newParameters;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod : NSObject
{
  @private
    NSString *_ccNumber;
    BOOL _enabled;
    int _expirationMonth;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_billingAddress;
    int _expirationYear;
    NSString *_merchantPaymentMethodId;
    NSString *_cardHolder;
    NSString *_cardType;
}

/**
 * (no documentation provided)
 */
- (NSString *) ccNumber;

/**
 * (no documentation provided)
 */
- (void) setCcNumber: (NSString *) newCcNumber;

/**
 * (no documentation provided)
 */
- (BOOL) enabled;

/**
 * (no documentation provided)
 */
- (void) setEnabled: (BOOL) newEnabled;

/**
 * (no documentation provided)
 */
- (int) expirationMonth;

/**
 * (no documentation provided)
 */
- (void) setExpirationMonth: (int) newExpirationMonth;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) billingAddress;

/**
 * (no documentation provided)
 */
- (void) setBillingAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newBillingAddress;

/**
 * (no documentation provided)
 */
- (int) expirationYear;

/**
 * (no documentation provided)
 */
- (void) setExpirationYear: (int) newExpirationYear;

/**
 * (no documentation provided)
 */
- (NSString *) merchantPaymentMethodId;

/**
 * (no documentation provided)
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;

/**
 * (no documentation provided)
 */
- (NSString *) cardHolder;

/**
 * (no documentation provided)
 */
- (void) setCardHolder: (NSString *) newCardHolder;

/**
 * (no documentation provided)
 */
- (NSString *) cardType;

/**
 * (no documentation provided)
 */
- (void) setCardType: (NSString *) newCardType;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge : NSObject
{
  @private
    NSString *_name;
    NSString *_type;
    NSString *_unitId;
    NSArray *_tiers;
}

/**
 * (no documentation provided)
 */
- (NSString *) name;

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName;

/**
 * (no documentation provided)
 */
- (NSString *) type;

/**
 * (no documentation provided)
 */
- (void) setType: (NSString *) newType;

/**
 * (no documentation provided)
 */
- (NSString *) unitId;

/**
 * (no documentation provided)
 */
- (void) setUnitId: (NSString *) newUnitId;

/**
 * (no documentation provided)
 */
- (NSArray *) tiers;

/**
 * (no documentation provided)
 */
- (void) setTiers: (NSArray *) newTiers;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier : NSObject
{
  @private
    int *_numberOfUnits;
    NSDecimalNumber *_chargePrice;
}

/**
 * (no documentation provided)
 */
- (int *) numberOfUnits;

/**
 * (no documentation provided)
 */
- (void) setNumberOfUnits: (int *) newNumberOfUnits;

/**
 * (no documentation provided)
 */
- (NSDecimalNumber *) chargePrice;

/**
 * (no documentation provided)
 */
- (void) setChargePrice: (NSDecimalNumber *) newChargePrice;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService : NSObject
{
  @private
    NSString *_identifier;
    int _billingCycleDay;
    NSString *_billingPlanName;
    NSString *_name;
    NSString *_billingPlanId;
    NSString *_billingFrequency;
    NSString *_frequency;
    int _number;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
    BOOL *_cancellable;
    BOOL *_autoRenewal;
}

/**
 * (no documentation provided)
 */
- (NSString *) identifier;

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier;

/**
 * (no documentation provided)
 */
- (int) billingCycleDay;

/**
 * (no documentation provided)
 */
- (void) setBillingCycleDay: (int) newBillingCycleDay;

/**
 * (no documentation provided)
 */
- (NSString *) billingPlanName;

/**
 * (no documentation provided)
 */
- (void) setBillingPlanName: (NSString *) newBillingPlanName;

/**
 * (no documentation provided)
 */
- (NSString *) name;

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName;

/**
 * (no documentation provided)
 */
- (NSString *) billingPlanId;

/**
 * (no documentation provided)
 */
- (void) setBillingPlanId: (NSString *) newBillingPlanId;

/**
 * (no documentation provided)
 */
- (NSString *) billingFrequency;

/**
 * (no documentation provided)
 */
- (void) setBillingFrequency: (NSString *) newBillingFrequency;

/**
 * (no documentation provided)
 */
- (NSString *) frequency;

/**
 * (no documentation provided)
 */
- (void) setFrequency: (NSString *) newFrequency;

/**
 * (no documentation provided)
 */
- (int) number;

/**
 * (no documentation provided)
 */
- (void) setNumber: (int) newNumber;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;

/**
 * (no documentation provided)
 */
- (BOOL *) cancellable;

/**
 * (no documentation provided)
 */
- (void) setCancellable: (BOOL *) newCancellable;

/**
 * (no documentation provided)
 */
- (BOOL *) autoRenewal;

/**
 * (no documentation provided)
 */
- (void) setAutoRenewal: (BOOL *) newAutoRenewal;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo_H

/**
 *  Sub-Element defining a billing for subscription.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo : NSObject <EnunciateXML>
{
  @private
    NSString *_billingId;
    NSString *_billingPeriod;
    NSString *_billingDate;
    NSString *_amount;
    NSString *_status;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_customFields;
}

/**
 * (no documentation provided)
 */
- (NSString *) billingId;

/**
 * (no documentation provided)
 */
- (void) setBillingId: (NSString *) newBillingId;

/**
 * (no documentation provided)
 */
- (NSString *) billingPeriod;

/**
 * (no documentation provided)
 */
- (void) setBillingPeriod: (NSString *) newBillingPeriod;

/**
 * (no documentation provided)
 */
- (NSString *) billingDate;

/**
 * (no documentation provided)
 */
- (void) setBillingDate: (NSString *) newBillingDate;

/**
 * (no documentation provided)
 */
- (NSString *) amount;

/**
 * (no documentation provided)
 */
- (void) setAmount: (NSString *) newAmount;

/**
 * (no documentation provided)
 */
- (NSString *) status;

/**
 * (no documentation provided)
 */
- (void) setStatus: (NSString *) newStatus;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) customFields;

/**
 * (no documentation provided)
 */
- (void) setCustomFields: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newCustomFields;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType : NSObject
{
  @private
    NSString *_key;
    NSString *_value;
}

/**
 * (no documentation provided)
 */
- (NSString *) key;

/**
 * (no documentation provided)
 */
- (void) setKey: (NSString *) newKey;

/**
 * (no documentation provided)
 */
- (NSString *) value;

/**
 * (no documentation provided)
 */
- (void) setValue: (NSString *) newValue;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem : NSObject
{
  @private
    NSString *_identifier;
    NSString *_code;
    NSString *_name;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService *_subscriptionTerm;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan *_subscriptionPlan;
}

/**
 * (no documentation provided)
 */
- (NSString *) identifier;

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier;

/**
 * (no documentation provided)
 */
- (NSString *) code;

/**
 * (no documentation provided)
 */
- (void) setCode: (NSString *) newCode;

/**
 * (no documentation provided)
 */
- (NSString *) name;

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService *) subscriptionTerm;

/**
 * (no documentation provided)
 */
- (void) setSubscriptionTerm: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService *) newSubscriptionTerm;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan *) subscriptionPlan;

/**
 * (no documentation provided)
 */
- (void) setSubscriptionPlan: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan *) newSubscriptionPlan;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder_H

/**
 *  A subscription order containing a list of subscription items.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder : NSObject <EnunciateXML>
{
  @private
    NSString *_identifier;
    NSDate *_date;
    NSString *_currency;
    NSArray *_addresses;
    NSArray *_lineItems;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
    NSString *_merchantAccountId;
    NSArray *_items;
}

/**
 * Unique id (e.g order/shipment/return number).
 */
- (NSString *) identifier;

/**
 * Unique id (e.g order/shipment/return number).
 */
- (void) setIdentifier: (NSString *) newIdentifier;

/**
 * Date used for records (e.g. order/shipping/return date).
 */
- (NSDate *) date;

/**
 * Date used for records (e.g. order/shipping/return date).
 */
- (void) setDate: (NSDate *) newDate;

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency;

/**
 * List of addresses.
 */
- (NSArray *) addresses;

/**
 * List of addresses.
 */
- (void) setAddresses: (NSArray *) newAddresses;

/**
 * List of line items. intended for "Buy now" items in cart
 */
- (NSArray *) lineItems;

/**
 * List of line items. intended for "Buy now" items in cart
 */
- (void) setLineItems: (NSArray *) newLineItems;

/**
 * Vendor specific values to pass in the request.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * Vendor specific values to pass in the request.
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;

/**
 * unique identifier for a specific account.
 */
- (NSString *) merchantAccountId;

/**
 * unique identifier for a specific account.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId;

/**
 * List of subscription items.
 */
- (NSArray *) items;

/**
 * List of subscription items.
 */
- (void) setItems: (NSArray *) newItems;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan : NSObject
{
  @private
    NSString *_identifier;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_vendorParameters;
    NSArray *_usageCharges;
    NSArray *_charges;
    NSString *_name;
}

/**
 * (no documentation provided)
 */
- (NSString *) identifier;

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters;

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters;

/**
 * (no documentation provided)
 */
- (NSArray *) usageCharges;

/**
 * (no documentation provided)
 */
- (void) setUsageCharges: (NSArray *) newUsageCharges;

/**
 * (no documentation provided)
 */
- (NSArray *) charges;

/**
 * (no documentation provided)
 */
- (void) setCharges: (NSArray *) newCharges;

/**
 * (no documentation provided)
 */
- (NSString *) name;

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap : NSObject
{
  @private
    NSArray *_entries;
}

/**
 * (no documentation provided)
 */
- (NSArray *) entries;

/**
 * (no documentation provided)
 */
- (void) setEntries: (NSArray *) newEntries;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest_H

/**
 *  A payment request to initiate payment session.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_returnUrl;
    NSString *_cancelReturnUrl;
    NSString *_ipAddress;
    NSString *_merchantAccountId;
}

/**
 * If the service approves the transaction, the customer will be redirected to this URL.
 */
- (NSString *) returnUrl;

/**
 * If the service approves the transaction, the customer will be redirected to this URL.
 */
- (void) setReturnUrl: (NSString *) newReturnUrl;

/**
 * If the service cancels the transaction or discovers an error, the customer will be redirected to this URL.
 */
- (NSString *) cancelReturnUrl;

/**
 * If the service cancels the transaction or discovers an error, the customer will be redirected to this URL.
 */
- (void) setCancelReturnUrl: (NSString *) newCancelReturnUrl;

/**
 * The ipAddress of the client.
 */
- (NSString *) ipAddress;

/**
 * The ipAddress of the client.
 */
- (void) setIpAddress: (NSString *) newIpAddress;

/**
 * Identifying attribute of the buyer.
 */
- (NSString *) merchantAccountId;

/**
 * Identifying attribute of the buyer.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult_H

/**
 *  The result of a payment transaction such as authorizing or capturing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult <EnunciateXML>
{
  @private
    NSDecimalNumber *_amount;
    NSString *_sessionTransactionToken;
    NSString *_merchantProductId;
}

/**
 * The amount / subscription price .
 */
- (NSDecimalNumber *) amount;

/**
 * The amount / subscription price .
 */
- (void) setAmount: (NSDecimalNumber *) newAmount;

/**
 * (no documentation provided)
 */
- (NSString *) sessionTransactionToken;

/**
 * (no documentation provided)
 */
- (void) setSessionTransactionToken: (NSString *) newSessionTransactionToken;

/**
 * The transaction verification key.
 */
- (NSString *) merchantProductId;

/**
 * The transaction verification key.
 */
- (void) setMerchantProductId: (NSString *) newMerchantProductId;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest_H

/**
 *  A request to finalize a transactional WebSession based on an issued token.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_authorizationRequestId;
    NSString *_authorizationRequestToken;
}

/**
 * the request id of the authorization to capture on.
 */
- (NSString *) authorizationRequestId;

/**
 * the request id of the authorization to capture on.
 */
- (void) setAuthorizationRequestId: (NSString *) newAuthorizationRequestId;

/**
 * the authorization request token used.
 */
- (NSString *) authorizationRequestToken;

/**
 * the authorization request token used.
 */
- (void) setAuthorizationRequestToken: (NSString *) newAuthorizationRequestToken;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest_H

/**
 *  A request to replace the payment method for an existing subscription with another existing payment method.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_merchantSubscriptionId;
    NSString *_merchantPaymentMethodId;
}

/**
 * identifying attribute of the subscription.
 */
- (NSString *) merchantSubscriptionId;

/**
 * identifying attribute of the subscription.
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId;

/**
 * identifying attribute of the payment method.
 */
- (NSString *) merchantPaymentMethodId;

/**
 * identifying attribute of the payment method.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult_H

/**
 *  Result type for payment method related requests.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult <EnunciateXML>
{
  @private
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *_paymentMethod;
}

/**
 * The payment method.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) paymentMethod;

/**
 * The payment method.
 */
- (void) setPaymentMethod: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) newPaymentMethod;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList_H

/**
 *  Retrieves a billing activity list for subscription.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult <EnunciateXML>
{
  @private
    NSString *_merchantSubscriptionId;
    NSArray *_billings;
}

/**
 * Merchant ID of a subscription.
 */
- (NSString *) merchantSubscriptionId;

/**
 * Merchant ID of a subscription.
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId;

/**
 * List billings.
 */
- (NSArray *) billings;

/**
 * List billings.
 */
- (void) setBillings: (NSArray *) newBillings;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest_H

/**
 *  A request to cancel an existing subscription.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_merchantSubscriptionId;
    NSString *_cancelationMode;
    BOOL _force;
}

/**
 * Identifying attribute of the subscription.
 */
- (NSString *) merchantSubscriptionId;

/**
 * Identifying attribute of the subscription.
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId;

/**
 * The cancellation mode.
 */
- (NSString *) cancelationMode;

/**
 * The cancellation mode.
 */
- (void) setCancelationMode: (NSString *) newCancelationMode;

/**
 * If subscription should be canceled immediately.
 */
- (BOOL) force;

/**
 * If subscription should be canceled immediately.
 */
- (void) setForce: (BOOL) newForce;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest_H

/**
 *  Request for subscription creation.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_orderId;
    NSString *_currency;
    NSDate *_orderDate;
    NSString *_merchantAccountId;
    NSString *_merchantPaymentMethodId;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem *_subscriptionItem;
}

/**
 * Identifying order that subscription related to.
 */
- (NSString *) orderId;

/**
 * Identifying order that subscription related to.
 */
- (void) setOrderId: (NSString *) newOrderId;

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency;

/**
 * (no documentation provided)
 */
- (NSDate *) orderDate;

/**
 * (no documentation provided)
 */
- (void) setOrderDate: (NSDate *) newOrderDate;

/**
 * Identifying attribute of the buyer.
 */
- (NSString *) merchantAccountId;

/**
 * Identifying attribute of the buyer.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId;

/**
 * ID of the payment method.
 */
- (NSString *) merchantPaymentMethodId;

/**
 * ID of the payment method.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem *) subscriptionItem;

/**
 * (no documentation provided)
 */
- (void) setSubscriptionItem: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem *) newSubscriptionItem;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest_H

/**
 *  A subscription order request.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_merchantAccountId;
    NSString *_merchantPaymentMethodId;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *_subscriptionOrder;
    NSString *_currency;
}

/**
 * Identifying attribute of the buyer.
 */
- (NSString *) merchantAccountId;

/**
 * Identifying attribute of the buyer.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId;

/**
 * Identifying attribute of the payment method (if available).
 */
- (NSString *) merchantPaymentMethodId;

/**
 * Identifying attribute of the payment method (if available).
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;

/**
 * The subscription order.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *) subscriptionOrder;

/**
 * The subscription order.
 */
- (void) setSubscriptionOrder: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *) newSubscriptionOrder;

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest_H

/**
 *  A payment request to for example authorize or capture an amount.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSDecimalNumber *_amount;
    NSString *_currency;
    NSString *_profileId;
    NSString *_paymentMethodId;
    NSString *_merchantTransactionId;
    NSString *_merchantTransactionDescription;
    NSArray *_lineItems;
    NSString *_transactionMode;
}

/**
 * The amount of the transaction.
 */
- (NSDecimalNumber *) amount;

/**
 * The amount of the transaction.
 */
- (void) setAmount: (NSDecimalNumber *) newAmount;

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency;

/**
 * ID of a payment profile.
 */
- (NSString *) profileId;

/**
 * ID of a payment profile.
 */
- (void) setProfileId: (NSString *) newProfileId;

/**
 * ID of the payment method.
 */
- (NSString *) paymentMethodId;

/**
 * ID of the payment method.
 */
- (void) setPaymentMethodId: (NSString *) newPaymentMethodId;

/**
 * Merchant ID of the transaction.
 */
- (NSString *) merchantTransactionId;

/**
 * Merchant ID of the transaction.
 */
- (void) setMerchantTransactionId: (NSString *) newMerchantTransactionId;

/**
 * Descriptive text for transaction.
 */
- (NSString *) merchantTransactionDescription;

/**
 * Descriptive text for transaction.
 */
- (void) setMerchantTransactionDescription: (NSString *) newMerchantTransactionDescription;

/**
 * List of line items.
 */
- (NSArray *) lineItems;

/**
 * List of line items.
 */
- (void) setLineItems: (NSArray *) newLineItems;

/**
 * Transaction mode (AUTH, CAPTURE or AUTHCAPTURE).
 */
- (NSString *) transactionMode;

/**
 * Transaction mode (AUTH, CAPTURE or AUTHCAPTURE).
 */
- (void) setTransactionMode: (NSString *) newTransactionMode;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest_H

/**
 *  Contains profile information.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_profileId;
    NSString *_customerName;
    NSString *_company;
    NSString *_currency;
    NSString *_emailPreference;
    NSString *_languagePreference;
    NSString *_emailAddress;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_shippingAddress;
}

/**
 * ID of a customer/account profile.
 */
- (NSString *) profileId;

/**
 * ID of a customer/account profile.
 */
- (void) setProfileId: (NSString *) newProfileId;

/**
 * Profile name.
 */
- (NSString *) customerName;

/**
 * Profile name.
 */
- (void) setCustomerName: (NSString *) newCustomerName;

/**
 * Company.
 */
- (NSString *) company;

/**
 * Company.
 */
- (void) setCompany: (NSString *) newCompany;

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency;

/**
 * Email preference, either "plaintext", "html" or "multipart".
 */
- (NSString *) emailPreference;

/**
 * Email preference, either "plaintext", "html" or "multipart".
 */
- (void) setEmailPreference: (NSString *) newEmailPreference;

/**
 * Language preference, ISO 639-1 two-letter language code, e.g. de,en,.. .
 */
- (NSString *) languagePreference;

/**
 * Language preference, ISO 639-1 two-letter language code, e.g. de,en,.. .
 */
- (void) setLanguagePreference: (NSString *) newLanguagePreference;

/**
 * ID of a payment profile.
 */
- (NSString *) emailAddress;

/**
 * ID of a payment profile.
 */
- (void) setEmailAddress: (NSString *) newEmailAddress;

/**
 * The shipping address.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) shippingAddress;

/**
 * The shipping address.
 */
- (void) setShippingAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newShippingAddress;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData_H

/**
 *  Retrieves subscription data from a Subscription Billing Provider.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult <EnunciateXML>
{
  @private
    NSString *_merchantAccountId;
    NSString *_currency;
    NSString *_subscriptionId;
    NSString *_subscriptionName;
    NSString *_subscriptionDescription;
    NSString *_subscriptionProductId;
    NSString *_subscriptionOrderId;
    NSString *_subscriptionOrderEntryId;
    NSString *_billingSystemId;
    NSDate *_subscriptionStartDate;
    NSDate *_subscriptionEndDate;
    NSString *_subscriptionStatus;
    BOOL *_cancellationPossible;
    NSString *_billingFrequency;
    NSString *_contractDuration;
    NSDate *_orderDate;
    NSDate *_cancelDate;
    NSString *_comments;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *_paymentMethod;
    BOOL *_autoRenewal;
}

/**
 * merchant ID of a customer account.
 */
- (NSString *) merchantAccountId;

/**
 * merchant ID of a customer account.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId;

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (void) setCurrency: (NSString *) newCurrency;

/**
 * Merchant ID of a subscription.
 */
- (NSString *) subscriptionId;

/**
 * Merchant ID of a subscription.
 */
- (void) setSubscriptionId: (NSString *) newSubscriptionId;

/**
 * Merchant name of a subscription product.
 */
- (NSString *) subscriptionName;

/**
 * Merchant name of a subscription product.
 */
- (void) setSubscriptionName: (NSString *) newSubscriptionName;

/**
 * Merchant description of a subscription product.
 */
- (NSString *) subscriptionDescription;

/**
 * Merchant description of a subscription product.
 */
- (void) setSubscriptionDescription: (NSString *) newSubscriptionDescription;

/**
 * Merchant ID of a subscription product.
 */
- (NSString *) subscriptionProductId;

/**
 * Merchant ID of a subscription product.
 */
- (void) setSubscriptionProductId: (NSString *) newSubscriptionProductId;

/**
 * Merchant order number containing this subscription product.
 */
- (NSString *) subscriptionOrderId;

/**
 * Merchant order number containing this subscription product.
 */
- (void) setSubscriptionOrderId: (NSString *) newSubscriptionOrderId;

/**
 * Merchant order entry number containing this subscription product.
 */
- (NSString *) subscriptionOrderEntryId;

/**
 * Merchant order entry number containing this subscription product.
 */
- (void) setSubscriptionOrderEntryId: (NSString *) newSubscriptionOrderEntryId;

/**
 * Billing system id.
 */
- (NSString *) billingSystemId;

/**
 * Billing system id.
 */
- (void) setBillingSystemId: (NSString *) newBillingSystemId;

/**
 * Start date of a subscription.
 */
- (NSDate *) subscriptionStartDate;

/**
 * Start date of a subscription.
 */
- (void) setSubscriptionStartDate: (NSDate *) newSubscriptionStartDate;

/**
 * End date of a subscription.
 */
- (NSDate *) subscriptionEndDate;

/**
 * End date of a subscription.
 */
- (void) setSubscriptionEndDate: (NSDate *) newSubscriptionEndDate;

/**
 * Status of a subscription.
 */
- (NSString *) subscriptionStatus;

/**
 * Status of a subscription.
 */
- (void) setSubscriptionStatus: (NSString *) newSubscriptionStatus;

/**
 * Determines if a subscription is cancellable.
 */
- (BOOL *) cancellationPossible;

/**
 * Determines if a subscription is cancellable.
 */
- (void) setCancellationPossible: (BOOL *) newCancellationPossible;

/**
 * Billing frequency.
 */
- (NSString *) billingFrequency;

/**
 * Billing frequency.
 */
- (void) setBillingFrequency: (NSString *) newBillingFrequency;

/**
 * Contract duration.
 */
- (NSString *) contractDuration;

/**
 * Contract duration.
 */
- (void) setContractDuration: (NSString *) newContractDuration;

/**
 * When was the subscription order placed originally.
 */
- (NSDate *) orderDate;

/**
 * When was the subscription order placed originally.
 */
- (void) setOrderDate: (NSDate *) newOrderDate;

/**
 * When was the subscription order cancelled.
 */
- (NSDate *) cancelDate;

/**
 * When was the subscription order cancelled.
 */
- (void) setCancelDate: (NSDate *) newCancelDate;

/**
 * Comments about the creation.
 */
- (NSString *) comments;

/**
 * Comments about the creation.
 */
- (void) setComments: (NSString *) newComments;

/**
 * Copy of the payment method of the corresponding account used by this subscription.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) paymentMethod;

/**
 * Copy of the payment method of the corresponding account used by this subscription.
 */
- (void) setPaymentMethod: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) newPaymentMethod;

/**
 * AutoRenewal flag of a subscription.
 */
- (BOOL *) autoRenewal;

/**
 * AutoRenewal flag of a subscription.
 */
- (void) setAutoRenewal: (BOOL *) newAutoRenewal;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest_H

/**
 *  Request for updating an existing payment method.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_merchantPaymentMethodId;
    BOOL *_enabled;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_billingAddress;
    BOOL *_propagate;
}

/**
 * The payment method to change.
 */
- (NSString *) merchantPaymentMethodId;

/**
 * The payment method to change.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;

/**
 * Enable or disable the payment method.
 */
- (BOOL *) enabled;

/**
 * Enable or disable the payment method.
 */
- (void) setEnabled: (BOOL *) newEnabled;

/**
 * Updated billing address.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) billingAddress;

/**
 * Updated billing address.
 */
- (void) setBillingAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newBillingAddress;

/**
 * Indicates whether the updates should also be applied to subscriptions that use the payment method.
 */
- (BOOL *) propagate;

/**
 * Indicates whether the updates should also be applied to subscriptions that use the payment method.
 */
- (void) setPropagate: (BOOL *) newPropagate;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult_H

/**
 *  The result of a pass customer usage call.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult <EnunciateXML>
{
  @private
}
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult_H

/**
 *  Presents result of billing activity detail request.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult <EnunciateXML>
{
  @private
    NSData *_bytes;
    NSString *_mimeType;
    NSString *_fileName;
}

/**
 * Byte stream for file downloading.
 */
- (NSData *) bytes;

/**
 * Byte stream for file downloading.
 */
- (void) setBytes: (NSData *) newBytes;

/**
 * Describes content type.
 */
- (NSString *) mimeType;

/**
 * Describes content type.
 */
- (void) setMimeType: (NSString *) newMimeType;

/**
 * The file name.
 */
- (NSString *) fileName;

/**
 * The file name.
 */
- (void) setFileName: (NSString *) newFileName;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest_H

/**
 *  A request for changing an existing payment method.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest <EnunciateXML>
{
  @private
    NSString *_merchantPaymentMethodId;
    NSString *_action;
    NSString *_newValue;
    BOOL _propagate;
}

/**
 * The payment method to change.
 */
- (NSString *) merchantPaymentMethodId;

/**
 * The payment method to change.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;

/**
 * The action to perform.
 */
- (NSString *) action;

/**
 * The action to perform.
 */
- (void) setAction: (NSString *) newAction;

/**
 * New value to be provided.
 */
- (NSString *) newValue;

/**
 * New value to be provided.
 */
- (void) setNewValue: (NSString *) newNewValue;

/**
 * Indicates if the changes should also be applied to subscriptions that use the payment method.
 */
- (BOOL) propagate;

/**
 * Indicates if the changes should also be applied to subscriptions that use the payment method.
 */
- (void) setPropagate: (BOOL) newPropagate;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest_H

/**
 * (no documentation provided)
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest
{
  @private
    NSString *_effectiveFrom;
    NSString *_merchantSubscriptionId;
}

/**
 * (no documentation provided)
 */
- (NSString *) effectiveFrom;

/**
 * (no documentation provided)
 */
- (void) setEffectiveFrom: (NSString *) newEffectiveFrom;

/**
 * (no documentation provided)
 */
- (NSString *) merchantSubscriptionId;

/**
 * (no documentation provided)
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest_H

/**
 *  Generic request type for subscription upgrades.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest <EnunciateXML>
{
  @private
    NSString *_merchantSourceSubscriptionId;
    NSString *_settlement;
    NSString *_effectiveFrom;
    BOOL _preview;
}

/**
 * (no documentation provided)
 */
- (NSString *) merchantSourceSubscriptionId;

/**
 * (no documentation provided)
 */
- (void) setMerchantSourceSubscriptionId: (NSString *) newMerchantSourceSubscriptionId;

/**
 * (no documentation provided)
 */
- (NSString *) settlement;

/**
 * (no documentation provided)
 */
- (void) setSettlement: (NSString *) newSettlement;

/**
 * Indicates when the upgrade will be effective.
 */
- (NSString *) effectiveFrom;

/**
 * Indicates when the upgrade will be effective.
 */
- (void) setEffectiveFrom: (NSString *) newEffectiveFrom;

/**
 * Indicates whether it's preview upgrade call or real upgrade.
 */
- (BOOL) preview;

/**
 * Indicates whether it's preview upgrade call or real upgrade.
 */
- (void) setPreview: (BOOL) newPreview;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult_H

/**
 *  The result of a subscription upgrade call.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData <EnunciateXML>
{
  @private
    NSArray *_futureBillings;
}

/**
 * (no documentation provided)
 */
- (NSArray *) futureBillings;

/**
 * (no documentation provided)
 */
- (void) setFutureBillings: (NSArray *) newFutureBillings;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest_H

/**
 *  Generic request type for subscription updates.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest <EnunciateXML>
{
  @private
    NSString *_merchantPaymentMethodId;
    BOOL *_autoRenewal;
    int *_contractDurationExtension;
}

/**
 * The merchantPaymentMethodId.
 */
- (NSString *) merchantPaymentMethodId;

/**
 * The merchantPaymentMethodId.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId;

/**
 * (no documentation provided)
 */
- (BOOL *) autoRenewal;

/**
 * (no documentation provided)
 */
- (void) setAutoRenewal: (BOOL *) newAutoRenewal;

/**
 * (no documentation provided)
 */
- (int *) contractDurationExtension;

/**
 * (no documentation provided)
 */
- (void) setContractDurationExtension: (int *) newContractDurationExtension;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult_H

/**
 *  Retrieves customer profile info from a Subscription Billing Provider.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult <EnunciateXML>
{
  @private
    NSString *_profileId;
    NSString *_currency;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *_validationResult;
    NSArray *_paymentMethods;
    NSArray *_subscriptions;
    HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_customerAddress;
    NSString *_comments;
}

/**
 * ID of a payment profile.
 */
- (NSString *) profileId;

/**
 * ID of a payment profile.
 */
- (void) setProfileId: (NSString *) newProfileId;

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (NSString *) currency;

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (void) setCurrency: (NSString *) newCurrency;

/**
 * Result of either a profile check or of a set up fee capture used to validate the credit card.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *) validationResult;

/**
 * Result of either a profile check or of a set up fee capture used to validate the credit card.
 */
- (void) setValidationResult: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *) newValidationResult;

/**
 * List of payment methods.
 */
- (NSArray *) paymentMethods;

/**
 * List of payment methods.
 */
- (void) setPaymentMethods: (NSArray *) newPaymentMethods;

/**
 * Placeholder to contain list of subscriptions.
 */
- (NSArray *) subscriptions;

/**
 * Placeholder to contain list of subscriptions.
 */
- (void) setSubscriptions: (NSArray *) newSubscriptions;

/**
 * Customer information.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) customerAddress;

/**
 * Customer information.
 */
- (void) setCustomerAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newCustomerAddress;

/**
 * Comments about the creation.
 */
- (NSString *) comments;

/**
 * Comments about the creation.
 */
- (void) setComments: (NSString *) newComments;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult_H */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest_H
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest_H

/**
 *  Generic request type for subscription state changes.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest : HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest <EnunciateXML>
{
  @private
    NSString *_newState;
}

/**
 * (no documentation provided)
 */
- (NSString *) newState;

/**
 * (no documentation provided)
 */
- (void) setNewState: (NSString *) newNewState;
@end /* interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest_H */
