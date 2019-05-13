#import "hybris-cis-mock-subscription-web.h"
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress_M

/**
 *  Representation of an address.
 *  
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress

/**
 * Type of the address.
 */
- (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *) type
{
  return _type;
}

/**
 * Type of the address.
 */
- (void) setType: (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *) newType
{
  if (_type != NULL) {
    free(_type);
  }
  _type = newType;
}

/**
 * Title.
 */
- (NSString *) title
{
  return _title;
}

/**
 * Title.
 */
- (void) setTitle: (NSString *) newTitle
{
  [newTitle retain];
  [_title release];
  _title = newTitle;
}

/**
 * First name.
 */
- (NSString *) firstName
{
  return _firstName;
}

/**
 * First name.
 */
- (void) setFirstName: (NSString *) newFirstName
{
  [newFirstName retain];
  [_firstName release];
  _firstName = newFirstName;
}

/**
 * Last name.
 */
- (NSString *) lastName
{
  return _lastName;
}

/**
 * Last name.
 */
- (void) setLastName: (NSString *) newLastName
{
  [newLastName retain];
  [_lastName release];
  _lastName = newLastName;
}

/**
 * Email.
 */
- (NSString *) email
{
  return _email;
}

/**
 * Email.
 */
- (void) setEmail: (NSString *) newEmail
{
  [newEmail retain];
  [_email release];
  _email = newEmail;
}

/**
 * First address line.
 */
- (NSString *) addressLine1
{
  return _addressLine1;
}

/**
 * First address line.
 */
- (void) setAddressLine1: (NSString *) newAddressLine1
{
  [newAddressLine1 retain];
  [_addressLine1 release];
  _addressLine1 = newAddressLine1;
}

/**
 * Second address line.
 */
- (NSString *) addressLine2
{
  return _addressLine2;
}

/**
 * Second address line.
 */
- (void) setAddressLine2: (NSString *) newAddressLine2
{
  [newAddressLine2 retain];
  [_addressLine2 release];
  _addressLine2 = newAddressLine2;
}

/**
 * Third address line.
 */
- (NSString *) addressLine3
{
  return _addressLine3;
}

/**
 * Third address line.
 */
- (void) setAddressLine3: (NSString *) newAddressLine3
{
  [newAddressLine3 retain];
  [_addressLine3 release];
  _addressLine3 = newAddressLine3;
}

/**
 * Fourth address line.
 */
- (NSString *) addressLine4
{
  return _addressLine4;
}

/**
 * Fourth address line.
 */
- (void) setAddressLine4: (NSString *) newAddressLine4
{
  [newAddressLine4 retain];
  [_addressLine4 release];
  _addressLine4 = newAddressLine4;
}

/**
 * Zip/Postal code.
 */
- (NSString *) zipCode
{
  return _zipCode;
}

/**
 * Zip/Postal code.
 */
- (void) setZipCode: (NSString *) newZipCode
{
  [newZipCode retain];
  [_zipCode release];
  _zipCode = newZipCode;
}

/**
 * City.
 */
- (NSString *) city
{
  return _city;
}

/**
 * City.
 */
- (void) setCity: (NSString *) newCity
{
  [newCity retain];
  [_city release];
  _city = newCity;
}

/**
 * Second part of the ISO 3166-2 subdivision code (e.g. state or province code without country).
 */
- (NSString *) state
{
  return _state;
}

/**
 * Second part of the ISO 3166-2 subdivision code (e.g. state or province code without country).
 */
- (void) setState: (NSString *) newState
{
  [newState retain];
  [_state release];
  _state = newState;
}

/**
 * 2 letter ISO 3166-1 alpha-2 country code.
 */
- (NSString *) country
{
  return _country;
}

/**
 * 2 letter ISO 3166-1 alpha-2 country code.
 */
- (void) setCountry: (NSString *) newCountry
{
  [newCountry retain];
  [_country release];
  _country = newCountry;
}

/**
 * The phone number.
 */
- (NSString *) phone
{
  return _phone;
}

/**
 * The phone number.
 */
- (void) setPhone: (NSString *) newPhone
{
  [newPhone retain];
  [_phone release];
  _phone = newPhone;
}

/**
 * The company name.
 */
- (NSString *) company
{
  return _company;
}

/**
 * The company name.
 */
- (void) setCompany: (NSString *) newCompany
{
  [newCompany retain];
  [_company release];
  _company = newCompany;
}

/**
 * Longitude of the address. Negative values are in the Western hemisphere. Positive values are in the Eastern hemisphere.
 */
- (NSString *) longitude
{
  return _longitude;
}

/**
 * Longitude of the address. Negative values are in the Western hemisphere. Positive values are in the Eastern hemisphere.
 */
- (void) setLongitude: (NSString *) newLongitude
{
  [newLongitude retain];
  [_longitude release];
  _longitude = newLongitude;
}

/**
 * Latitude of the address. Negative values are in the Southern hemisphere. Positive values are in the Northern hemisphere.
 */
- (NSString *) latitude
{
  return _latitude;
}

/**
 * Latitude of the address. Negative values are in the Southern hemisphere. Positive values are in the Northern hemisphere.
 */
- (void) setLatitude: (NSString *) newLatitude
{
  [newLatitude retain];
  [_latitude release];
  _latitude = newLatitude;
}

/**
 * the type of the facility.
 */
- (NSString *) facilityType
{
  return _facilityType;
}

/**
 * the type of the facility.
 */
- (void) setFacilityType: (NSString *) newFacilityType
{
  [newFacilityType retain];
  [_facilityType release];
  _facilityType = newFacilityType;
}

/**
 * The name of the facility.
 */
- (NSString *) facilityName
{
  return _facilityName;
}

/**
 * The name of the facility.
 */
- (void) setFacilityName: (NSString *) newFacilityName
{
  [newFacilityName retain];
  [_facilityName release];
  _facilityName = newFacilityName;
}

/**
 * The fax number belonging to this address.
 */
- (NSString *) faxNumber
{
  return _faxNumber;
}

/**
 * The fax number belonging to this address.
 */
- (void) setFaxNumber: (NSString *) newFaxNumber
{
  [newFaxNumber retain];
  [_faxNumber release];
  _faxNumber = newFaxNumber;
}

/**
 * Vendor specific values to pass in the request.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * Vendor specific values to pass in the request.
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

- (void) dealloc
{
  [self setType: NULL];
  [self setTitle: nil];
  [self setFirstName: nil];
  [self setLastName: nil];
  [self setEmail: nil];
  [self setAddressLine1: nil];
  [self setAddressLine2: nil];
  [self setAddressLine3: nil];
  [self setAddressLine4: nil];
  [self setZipCode: nil];
  [self setCity: nil];
  [self setState: nil];
  [self setCountry: nil];
  [self setPhone: nil];
  [self setCompany: nil];
  [self setLongitude: nil];
  [self setLatitude: nil];
  [self setFacilityType: nil];
  [self setFacilityName: nil];
  [self setFaxNumber: nil];
  [self setVendorParameters: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress from an XML reader. The element to be read is
 * "address".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *_cisAddress = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element address."];
    }
  }

  if (xmlStrcmp(BAD_CAST "address", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}address.");
#endif
    _cisAddress = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}address.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress. Expected element address. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress. Expected element address. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisAddress;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress to XML under element name "address".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisAddress The CisAddress to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "address", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}address. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisAddress for root element {}address...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisAddress for root element {}address...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}address. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "type", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setType: ((enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType*) _child_accessor)];
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "title", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}title of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}title of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setTitle: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "firstName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}firstName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}firstName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setFirstName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "lastName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}lastName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}lastName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setLastName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "email", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}email of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}email of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setEmail: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "addressLine1", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}addressLine1 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}addressLine1 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAddressLine1: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "addressLine2", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}addressLine2 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}addressLine2 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAddressLine2: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "addressLine3", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}addressLine3 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}addressLine3 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAddressLine3: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "addressLine4", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}addressLine4 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}addressLine4 of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAddressLine4: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "zipCode", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}zipCode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}zipCode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setZipCode: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "city", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}city of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}city of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCity: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "state", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}state of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}state of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setState: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "country", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}country of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}country of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCountry: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "phone", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}phone of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}phone of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setPhone: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "company", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}company of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}company of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCompany: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "longitude", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}longitude of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}longitude of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setLongitude: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "latitude", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}latitude of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}latitude of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setLatitude: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "facilityType", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}facilityType of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}facilityType of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setFacilityType: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "facilityName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}facilityName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}facilityName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setFacilityName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "faxNumber", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}faxNumber of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}faxNumber of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setFaxNumber: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self type] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "type", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}type."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}type...");
#endif
    status = xmlTextWriterWriteHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(writer, [self type]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}type...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}type."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}type."];
    }
  }
  if ([self title]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "title", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}title."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}title...");
#endif
    [[self title] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}title...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}title."];
    }
  }
  if ([self firstName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "firstName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}firstName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}firstName...");
#endif
    [[self firstName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}firstName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}firstName."];
    }
  }
  if ([self lastName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "lastName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}lastName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}lastName...");
#endif
    [[self lastName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}lastName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}lastName."];
    }
  }
  if ([self email]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "email", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}email."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}email...");
#endif
    [[self email] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}email...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}email."];
    }
  }
  if ([self addressLine1]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "addressLine1", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}addressLine1."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}addressLine1...");
#endif
    [[self addressLine1] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}addressLine1...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}addressLine1."];
    }
  }
  if ([self addressLine2]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "addressLine2", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}addressLine2."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}addressLine2...");
#endif
    [[self addressLine2] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}addressLine2...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}addressLine2."];
    }
  }
  if ([self addressLine3]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "addressLine3", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}addressLine3."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}addressLine3...");
#endif
    [[self addressLine3] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}addressLine3...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}addressLine3."];
    }
  }
  if ([self addressLine4]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "addressLine4", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}addressLine4."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}addressLine4...");
#endif
    [[self addressLine4] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}addressLine4...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}addressLine4."];
    }
  }
  if ([self zipCode]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "zipCode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}zipCode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}zipCode...");
#endif
    [[self zipCode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}zipCode...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}zipCode."];
    }
  }
  if ([self city]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "city", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}city."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}city...");
#endif
    [[self city] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}city...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}city."];
    }
  }
  if ([self state]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "state", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}state."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}state...");
#endif
    [[self state] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}state...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}state."];
    }
  }
  if ([self country]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "country", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}country."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}country...");
#endif
    [[self country] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}country...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}country."];
    }
  }
  if ([self phone]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "phone", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}phone."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}phone...");
#endif
    [[self phone] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}phone...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}phone."];
    }
  }
  if ([self company]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "company", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}company."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}company...");
#endif
    [[self company] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}company...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}company."];
    }
  }
  if ([self longitude]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "longitude", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}longitude."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}longitude...");
#endif
    [[self longitude] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}longitude...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}longitude."];
    }
  }
  if ([self latitude]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "latitude", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}latitude."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}latitude...");
#endif
    [[self latitude] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}latitude...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}latitude."];
    }
  }
  if ([self facilityType]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "facilityType", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}facilityType."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}facilityType...");
#endif
    [[self facilityType] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}facilityType...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}facilityType."];
    }
  }
  if ([self facilityName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "facilityName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}facilityName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}facilityName...");
#endif
    [[self facilityName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}facilityName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}facilityName."];
    }
  }
  if ([self faxNumber]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "faxNumber", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}faxNumber."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}faxNumber...");
#endif
    [[self faxNumber] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}faxNumber...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}faxNumber."];
    }
  }
  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision_M

/**
 * Reads a CisDecision from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The CisDecision, or NULL if unable to be read.
 */
static enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *xmlTextReaderReadHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(xmlTextReaderPtr reader)
{
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *value = calloc(1, sizeof(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision));
  if (enumValue != NULL) {
    if (xmlStrcmp(enumValue, BAD_CAST "ACCEPT") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ACCEPT;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "REVIEW") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REVIEW;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "REJECT") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REJECT;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "ERROR") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ERROR;
      free(enumValue);
      return value;
    }
#if DEBUG_ENUNCIATE
    NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    NSLog(@"Attempt to read enum value failed: NULL value.");
  }
#endif

  return NULL;
}

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _cisDecision The string to format.
 * @return The enum value or NULL on error.
 */
enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *formatStringToHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(NSString *_cisDecision)
{
  enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *value = calloc(1, sizeof(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision));
  if ([@"ACCEPT" isEqualToString:_cisDecision]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ACCEPT;
  }
  else if ([@"REVIEW" isEqualToString:_cisDecision]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REVIEW;
  }
  else if ([@"REJECT" isEqualToString:_cisDecision]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REJECT;
  }
  else if ([@"ERROR" isEqualToString:_cisDecision]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ERROR;
  }
  else{
#if DEBUG_ENUNCIATE
  NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", [_cisDecision UTF8String]);
#endif
    value = NULL;
  }
  return value;
}

/**
 * Writes a CisDecision to XML.
 *
 * @param writer The XML writer.
 * @param _cisDecision The CisDecision to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(xmlTextWriterPtr writer, enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *_cisDecision)
{
  switch (*_cisDecision) {
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ACCEPT:
      return xmlTextWriterWriteString(writer, BAD_CAST "ACCEPT");
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REVIEW:
      return xmlTextWriterWriteString(writer, BAD_CAST "REVIEW");
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REJECT:
      return xmlTextWriterWriteString(writer, BAD_CAST "REJECT");
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ERROR:
      return xmlTextWriterWriteString(writer, BAD_CAST "ERROR");
  }

#if DEBUG_ENUNCIATE
  NSLog(@"Unable to write enum value (no valid value found).");
#endif
  return -1;
}

/**
 * Utility method for getting the string value of CisDecision.
 *
 * @param _cisDecision The CisDecision to format.
 * @return The string value or NULL on error.
 */
static NSString *formatHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionTypeToString(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *_cisDecision)
{
  switch (*_cisDecision) {
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ACCEPT:
      return @"ACCEPT";
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REVIEW:
      return @"REVIEW";
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_REJECT:
      return @"REJECT";
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISDECISION_ERROR:
      return @"ERROR";
    default:
      return NULL;
  }

  return NULL;
}
#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult

/**
 * (no documentation provided)
 */
- (NSString *) clientRefId
{
  return _clientRefId;
}

/**
 * (no documentation provided)
 */
- (void) setClientRefId: (NSString *) newClientRefId
{
  [newClientRefId retain];
  [_clientRefId release];
  _clientRefId = newClientRefId;
}

/**
 * (no documentation provided)
 */
- (NSString *) vendorId
{
  return _vendorId;
}

/**
 * (no documentation provided)
 */
- (void) setVendorId: (NSString *) newVendorId
{
  [newVendorId retain];
  [_vendorId release];
  _vendorId = newVendorId;
}

/**
 * (no documentation provided)
 */
- (NSString *) vendorReasonCode
{
  return _vendorReasonCode;
}

/**
 * (no documentation provided)
 */
- (void) setVendorReasonCode: (NSString *) newVendorReasonCode
{
  [newVendorReasonCode retain];
  [_vendorReasonCode release];
  _vendorReasonCode = newVendorReasonCode;
}

/**
 * (no documentation provided)
 */
- (NSString *) vendorStatusCode
{
  return _vendorStatusCode;
}

/**
 * (no documentation provided)
 */
- (void) setVendorStatusCode: (NSString *) newVendorStatusCode
{
  [newVendorStatusCode retain];
  [_vendorStatusCode release];
  _vendorStatusCode = newVendorStatusCode;
}

/**
 * (no documentation provided)
 */
- (NSString *) identifier
{
  return _identifier;
}

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier
{
  [newIdentifier retain];
  [_identifier release];
  _identifier = newIdentifier;
}

/**
 * (no documentation provided)
 */
- (NSString *) href
{
  return _href;
}

/**
 * (no documentation provided)
 */
- (void) setHref: (NSString *) newHref
{
  [newHref retain];
  [_href release];
  _href = newHref;
}

/**
 * (no documentation provided)
 */
- (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *) decision
{
  return _decision;
}

/**
 * (no documentation provided)
 */
- (void) setDecision: (enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision *) newDecision
{
  if (_decision != NULL) {
    free(_decision);
  }
  _decision = newDecision;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorResponses
{
  return _vendorResponses;
}

/**
 * (no documentation provided)
 */
- (void) setVendorResponses: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorResponses
{
  [newVendorResponses retain];
  [_vendorResponses release];
  _vendorResponses = newVendorResponses;
}

- (void) dealloc
{
  [self setClientRefId: nil];
  [self setVendorId: nil];
  [self setVendorReasonCode: nil];
  [self setVendorStatusCode: nil];
  [self setIdentifier: nil];
  [self setHref: nil];
  [self setDecision: NULL];
  [self setVendorResponses: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "clientRefId", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}clientRefId...");
#endif
    [self setClientRefId: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}clientRefId...");
#endif
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "vendorId", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}vendorId...");
#endif
    [self setVendorId: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}vendorId...");
#endif
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "vendorReasonCode", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}vendorReasonCode...");
#endif
    [self setVendorReasonCode: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}vendorReasonCode...");
#endif
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "vendorStatusCode", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}vendorStatusCode...");
#endif
    [self setVendorStatusCode: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}vendorStatusCode...");
#endif
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "id", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}id...");
#endif
    [self setIdentifier: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}id...");
#endif
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "href", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}href...");
#endif
    [self setHref: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}href...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "decision", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setDecision: ((enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecision*) _child_accessor)];
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorResponses", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorResponses of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorResponses of type {}annotationHashMap.");
#endif

    [self setVendorResponses: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self clientRefId]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "clientRefId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}clientRefId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}clientRefId...");
#endif
    [[self clientRefId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}clientRefId...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}clientRefId."];
    }
  }
  if ([self vendorId]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "vendorId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}vendorId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}vendorId...");
#endif
    [[self vendorId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}vendorId...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}vendorId."];
    }
  }
  if ([self vendorReasonCode]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "vendorReasonCode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}vendorReasonCode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}vendorReasonCode...");
#endif
    [[self vendorReasonCode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}vendorReasonCode...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}vendorReasonCode."];
    }
  }
  if ([self vendorStatusCode]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "vendorStatusCode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}vendorStatusCode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}vendorStatusCode...");
#endif
    [[self vendorStatusCode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}vendorStatusCode...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}vendorStatusCode."];
    }
  }
  if ([self identifier]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "id", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}id."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}id...");
#endif
    [[self identifier] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}id...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}id."];
    }
  }
  if ([self href]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "href", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}href."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}href...");
#endif
    [[self href] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}href...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}href."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self decision] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "decision", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}decision."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}decision...");
#endif
    status = xmlTextWriterWriteHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisDecisionType(writer, [self decision]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}decision...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}decision."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}decision."];
    }
  }
  if ([self vendorResponses]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorResponses", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorResponses."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorResponses...");
#endif
    [[self vendorResponses] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorResponses...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorResponses."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem

/**
 * (no documentation provided)
 */
- (int *) identifier
{
  return _identifier;
}

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (int *) newIdentifier
{
  if (_identifier != NULL) {
    free(_identifier);
  }
  _identifier = newIdentifier;
}

/**
 * (no documentation provided)
 */
- (NSString *) itemCode
{
  return _itemCode;
}

/**
 * (no documentation provided)
 */
- (void) setItemCode: (NSString *) newItemCode
{
  [newItemCode retain];
  [_itemCode release];
  _itemCode = newItemCode;
}

/**
 * (no documentation provided)
 */
- (int *) quantity
{
  return _quantity;
}

/**
 * (no documentation provided)
 */
- (void) setQuantity: (int *) newQuantity
{
  if (_quantity != NULL) {
    free(_quantity);
  }
  _quantity = newQuantity;
}

/**
 * (no documentation provided)
 */
- (NSString *) productDescription
{
  return _productDescription;
}

/**
 * (no documentation provided)
 */
- (void) setProductDescription: (NSString *) newProductDescription
{
  [newProductDescription retain];
  [_productDescription release];
  _productDescription = newProductDescription;
}

/**
 * (no documentation provided)
 */
- (NSDecimalNumber *) unitPrice
{
  return _unitPrice;
}

/**
 * (no documentation provided)
 */
- (void) setUnitPrice: (NSDecimalNumber *) newUnitPrice
{
  [newUnitPrice retain];
  [_unitPrice release];
  _unitPrice = newUnitPrice;
}

/**
 * (no documentation provided)
 */
- (NSString *) taxCode
{
  return _taxCode;
}

/**
 * (no documentation provided)
 */
- (void) setTaxCode: (NSString *) newTaxCode
{
  [newTaxCode retain];
  [_taxCode release];
  _taxCode = newTaxCode;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

- (void) dealloc
{
  [self setIdentifier: NULL];
  [self setItemCode: nil];
  [self setQuantity: NULL];
  [self setProductDescription: nil];
  [self setUnitPrice: nil];
  [self setTaxCode: nil];
  [self setVendorParameters: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "id", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}id...");
#endif
    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to read the attribute value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading attribute {}id."];
    }
    [self setIdentifier: ((int*) _child_accessor)];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}id...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "itemCode", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}itemCode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}itemCode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setItemCode: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "quantity", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setQuantity: ((int*) _child_accessor)];
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "productDescription", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}productDescription of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}productDescription of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setProductDescription: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "unitPrice", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}unitPrice of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif
    __child = [NSDecimalNumber readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}unitPrice of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif

    [self setUnitPrice: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "taxCode", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}taxCode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}taxCode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setTaxCode: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self identifier] != NULL) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "id", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}id."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}id...");
#endif
    status = xmlTextWriterWriteIntType(writer, [self identifier]);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing attribute {}id."];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}id...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}id."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self itemCode]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "itemCode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}itemCode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}itemCode...");
#endif
    [[self itemCode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}itemCode...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}itemCode."];
    }
  }
  if ([self quantity] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "quantity", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}quantity."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}quantity...");
#endif
    status = xmlTextWriterWriteIntType(writer, [self quantity]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}quantity...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}quantity."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}quantity."];
    }
  }
  if ([self productDescription]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "productDescription", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}productDescription."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}productDescription...");
#endif
    [[self productDescription] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}productDescription...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}productDescription."];
    }
  }
  if ([self unitPrice]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "unitPrice", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}unitPrice."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}unitPrice...");
#endif
    [[self unitPrice] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}unitPrice...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}unitPrice."];
    }
  }
  if ([self taxCode]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "taxCode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}taxCode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}taxCode...");
#endif
    [[self taxCode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}taxCode...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}taxCode."];
    }
  }
  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest_M

/**
 *  
 *  Customer usage request that holds customer usage information.
 *  
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest

/**
 * from date for the customer usage.
 */
- (NSDate *) fromDate
{
  return _fromDate;
}

/**
 * from date for the customer usage.
 */
- (void) setFromDate: (NSDate *) newFromDate
{
  [newFromDate retain];
  [_fromDate release];
  _fromDate = newFromDate;
}

/**
 * to date for the customer usage.
 */
- (NSDate *) toDate
{
  return _toDate;
}

/**
 * to date for the customer usage.
 */
- (void) setToDate: (NSDate *) newToDate
{
  [newToDate retain];
  [_toDate release];
  _toDate = newToDate;
}

/**
 * customer id for the current usage.
 */
- (NSString *) customerId
{
  return _customerId;
}

/**
 * customer id for the current usage.
 */
- (void) setCustomerId: (NSString *) newCustomerId
{
  [newCustomerId retain];
  [_customerId release];
  _customerId = newCustomerId;
}

/**
 * the subscription id.
 */
- (NSString *) subscriptionId
{
  return _subscriptionId;
}

/**
 * the subscription id.
 */
- (void) setSubscriptionId: (NSString *) newSubscriptionId
{
  [newSubscriptionId retain];
  [_subscriptionId release];
  _subscriptionId = newSubscriptionId;
}

/**
 * usage charge name for the customer usage.
 */
- (NSString *) usageChargeName
{
  return _usageChargeName;
}

/**
 * usage charge name for the customer usage.
 */
- (void) setUsageChargeName: (NSString *) newUsageChargeName
{
  [newUsageChargeName retain];
  [_usageChargeName release];
  _usageChargeName = newUsageChargeName;
}

/**
 * units consumed.
 */
- (NSDecimalNumber *) unitsConsumed
{
  return _unitsConsumed;
}

/**
 * units consumed.
 */
- (void) setUnitsConsumed: (NSDecimalNumber *) newUnitsConsumed
{
  [newUnitsConsumed retain];
  [_unitsConsumed release];
  _unitsConsumed = newUnitsConsumed;
}

- (void) dealloc
{
  [self setFromDate: nil];
  [self setToDate: nil];
  [self setCustomerId: nil];
  [self setSubscriptionId: nil];
  [self setUsageChargeName: nil];
  [self setUnitsConsumed: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest from an XML reader. The element to be read is
 * "customerUsageRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest *_cisCustomerUsageRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element customerUsageRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "customerUsageRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}customerUsageRequest.");
#endif
    _cisCustomerUsageRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}customerUsageRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest. Expected element customerUsageRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest. Expected element customerUsageRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisCustomerUsageRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest to XML under element name "customerUsageRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisCustomerUsageRequest The CisCustomerUsageRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "customerUsageRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}customerUsageRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisCustomerUsageRequest for root element {}customerUsageRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisCustomerUsageRequest for root element {}customerUsageRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}customerUsageRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "fromDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}fromDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}fromDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setFromDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "toDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}toDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}toDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setToDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "customerId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}customerId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}customerId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCustomerId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "usageChargeName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}usageChargeName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}usageChargeName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setUsageChargeName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "unitsConsumed", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}unitsConsumed of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif
    __child = [NSDecimalNumber readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}unitsConsumed of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif

    [self setUnitsConsumed: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self fromDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "fromDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}fromDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}fromDate...");
#endif
    [[self fromDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}fromDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}fromDate."];
    }
  }
  if ([self toDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "toDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}toDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}toDate...");
#endif
    [[self toDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}toDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}toDate."];
    }
  }
  if ([self customerId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "customerId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}customerId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}customerId...");
#endif
    [[self customerId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}customerId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}customerId."];
    }
  }
  if ([self subscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionId...");
#endif
    [[self subscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionId."];
    }
  }
  if ([self usageChargeName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "usageChargeName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}usageChargeName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}usageChargeName...");
#endif
    [[self usageChargeName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}usageChargeName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}usageChargeName."];
    }
  }
  if ([self unitsConsumed]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "unitsConsumed", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}unitsConsumed."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}unitsConsumed...");
#endif
    [[self unitsConsumed] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}unitsConsumed...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}unitsConsumed."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry

/**
 * (no documentation provided)
 */
- (NSString *) oneTimeChargeTime
{
  return _oneTimeChargeTime;
}

/**
 * (no documentation provided)
 */
- (void) setOneTimeChargeTime: (NSString *) newOneTimeChargeTime
{
  [newOneTimeChargeTime retain];
  [_oneTimeChargeTime release];
  _oneTimeChargeTime = newOneTimeChargeTime;
}

/**
 * (no documentation provided)
 */
- (NSDecimalNumber *) chargePrice
{
  return _chargePrice;
}

/**
 * (no documentation provided)
 */
- (void) setChargePrice: (NSDecimalNumber *) newChargePrice
{
  [newChargePrice retain];
  [_chargePrice release];
  _chargePrice = newChargePrice;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

/**
 * (no documentation provided)
 */
- (int *) numberOfCycles
{
  return _numberOfCycles;
}

/**
 * (no documentation provided)
 */
- (void) setNumberOfCycles: (int *) newNumberOfCycles
{
  if (_numberOfCycles != NULL) {
    free(_numberOfCycles);
  }
  _numberOfCycles = newNumberOfCycles;
}

- (void) dealloc
{
  [self setOneTimeChargeTime: nil];
  [self setChargePrice: nil];
  [self setVendorParameters: nil];
  [self setNumberOfCycles: NULL];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "oneTimeChargeTime", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}oneTimeChargeTime of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}oneTimeChargeTime of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setOneTimeChargeTime: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "chargePrice", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}chargePrice of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif
    __child = [NSDecimalNumber readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}chargePrice of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif

    [self setChargePrice: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "numberOfCycles", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setNumberOfCycles: ((int*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self oneTimeChargeTime]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "oneTimeChargeTime", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}oneTimeChargeTime."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}oneTimeChargeTime...");
#endif
    [[self oneTimeChargeTime] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}oneTimeChargeTime...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}oneTimeChargeTime."];
    }
  }
  if ([self chargePrice]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "chargePrice", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}chargePrice."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}chargePrice...");
#endif
    [[self chargePrice] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}chargePrice...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}chargePrice."];
    }
  }
  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
  if ([self numberOfCycles] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "numberOfCycles", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}numberOfCycles."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}numberOfCycles...");
#endif
    status = xmlTextWriterWriteIntType(writer, [self numberOfCycles]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}numberOfCycles...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}numberOfCycles."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}numberOfCycles."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest_M

/**
 *  A payment request to for example authorize or capture an amount.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest

/**
 * Vendor specific parameters which aren't represented in the generic interface.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) parameters
{
  return _parameters;
}

/**
 * Vendor specific parameters which aren't represented in the generic interface.
 */
- (void) setParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newParameters
{
  [newParameters retain];
  [_parameters release];
  _parameters = newParameters;
}

- (void) dealloc
{
  [self setParameters: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest from an XML reader. The element to be read is
 * "subscriptionRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest *_cisSubscriptionRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionRequest.");
#endif
    _cisSubscriptionRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest. Expected element subscriptionRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest. Expected element subscriptionRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest to XML under element name "subscriptionRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionRequest The CisSubscriptionRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionRequest for root element {}subscriptionRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionRequest for root element {}subscriptionRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setParameters: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self parameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self parameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod

/**
 * (no documentation provided)
 */
- (NSString *) ccNumber
{
  return _ccNumber;
}

/**
 * (no documentation provided)
 */
- (void) setCcNumber: (NSString *) newCcNumber
{
  [newCcNumber retain];
  [_ccNumber release];
  _ccNumber = newCcNumber;
}

/**
 * (no documentation provided)
 */
- (BOOL) enabled
{
  return _enabled;
}

/**
 * (no documentation provided)
 */
- (void) setEnabled: (BOOL) newEnabled
{
  _enabled = newEnabled;
}

/**
 * (no documentation provided)
 */
- (int) expirationMonth
{
  return _expirationMonth;
}

/**
 * (no documentation provided)
 */
- (void) setExpirationMonth: (int) newExpirationMonth
{
  _expirationMonth = newExpirationMonth;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) billingAddress
{
  return _billingAddress;
}

/**
 * (no documentation provided)
 */
- (void) setBillingAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newBillingAddress
{
  [newBillingAddress retain];
  [_billingAddress release];
  _billingAddress = newBillingAddress;
}

/**
 * (no documentation provided)
 */
- (int) expirationYear
{
  return _expirationYear;
}

/**
 * (no documentation provided)
 */
- (void) setExpirationYear: (int) newExpirationYear
{
  _expirationYear = newExpirationYear;
}

/**
 * (no documentation provided)
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * (no documentation provided)
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

/**
 * (no documentation provided)
 */
- (NSString *) cardHolder
{
  return _cardHolder;
}

/**
 * (no documentation provided)
 */
- (void) setCardHolder: (NSString *) newCardHolder
{
  [newCardHolder retain];
  [_cardHolder release];
  _cardHolder = newCardHolder;
}

/**
 * (no documentation provided)
 */
- (NSString *) cardType
{
  return _cardType;
}

/**
 * (no documentation provided)
 */
- (void) setCardType: (NSString *) newCardType
{
  [newCardType retain];
  [_cardType release];
  _cardType = newCardType;
}

- (void) dealloc
{
  [self setCcNumber: nil];
  [self setBillingAddress: nil];
  [self setMerchantPaymentMethodId: nil];
  [self setCardHolder: nil];
  [self setCardType: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "ccNumber", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}ccNumber of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}ccNumber of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCcNumber: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "enabled", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setEnabled: *((BOOL*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "expirationMonth", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setExpirationMonth: *((int*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingAddress", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingAddress of type {}cisAddress.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingAddress of type {}cisAddress.");
#endif

    [self setBillingAddress: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "expirationYear", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setExpirationYear: *((int*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cardHolder", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}cardHolder of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}cardHolder of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCardHolder: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cardType", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}cardType of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}cardType of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCardType: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self ccNumber]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "ccNumber", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}ccNumber."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}ccNumber...");
#endif
    [[self ccNumber] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}ccNumber...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}ccNumber."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "enabled", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}enabled."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}enabled...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, &_enabled);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}enabled...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}enabled."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}enabled."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "expirationMonth", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}expirationMonth."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}expirationMonth...");
#endif
    status = xmlTextWriterWriteIntType(writer, &_expirationMonth);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}expirationMonth...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}expirationMonth."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}expirationMonth."];
    }
  }
  if ([self billingAddress]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingAddress", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingAddress."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingAddress...");
#endif
    [[self billingAddress] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingAddress...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingAddress."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "expirationYear", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}expirationYear."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}expirationYear...");
#endif
    status = xmlTextWriterWriteIntType(writer, &_expirationYear);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}expirationYear...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}expirationYear."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}expirationYear."];
    }
  }
  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
  if ([self cardHolder]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cardHolder", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cardHolder."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cardHolder...");
#endif
    [[self cardHolder] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cardHolder...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cardHolder."];
    }
  }
  if ([self cardType]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cardType", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cardType."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cardType...");
#endif
    [[self cardType] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cardType...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cardType."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge

/**
 * (no documentation provided)
 */
- (NSString *) name
{
  return _name;
}

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName
{
  [newName retain];
  [_name release];
  _name = newName;
}

/**
 * (no documentation provided)
 */
- (NSString *) type
{
  return _type;
}

/**
 * (no documentation provided)
 */
- (void) setType: (NSString *) newType
{
  [newType retain];
  [_type release];
  _type = newType;
}

/**
 * (no documentation provided)
 */
- (NSString *) unitId
{
  return _unitId;
}

/**
 * (no documentation provided)
 */
- (void) setUnitId: (NSString *) newUnitId
{
  [newUnitId retain];
  [_unitId release];
  _unitId = newUnitId;
}

/**
 * (no documentation provided)
 */
- (NSArray *) tiers
{
  return _tiers;
}

/**
 * (no documentation provided)
 */
- (void) setTiers: (NSArray *) newTiers
{
  [newTiers retain];
  [_tiers release];
  _tiers = newTiers;
}

- (void) dealloc
{
  [self setName: nil];
  [self setType: nil];
  [self setUnitId: nil];
  [self setTiers: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "name", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "type", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}type of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}type of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setType: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "unitId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}unitId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}unitId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setUnitId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "tier", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}tier of type {}cisUsageChargeTier.");
#endif

     __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}tier of type {}cisUsageChargeTier.");
#endif

    if ([self tiers]) {
      [self setTiers: [[self tiers] arrayByAddingObject: __child]];
    }
    else {
      [self setTiers: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self name]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "name", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}name."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}name...");
#endif
    [[self name] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}name...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}name."];
    }
  }
  if ([self type]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "type", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}type."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}type...");
#endif
    [[self type] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}type...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}type."];
    }
  }
  if ([self unitId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "unitId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}unitId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}unitId...");
#endif
    [[self unitId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}unitId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}unitId."];
    }
  }
  if ([self tiers]) {
    __enumerator = [[self tiers] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "tier", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}tier."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}tier...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}tier...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}tier."];
      }
    } //end item iterator.
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier

/**
 * (no documentation provided)
 */
- (int *) numberOfUnits
{
  return _numberOfUnits;
}

/**
 * (no documentation provided)
 */
- (void) setNumberOfUnits: (int *) newNumberOfUnits
{
  if (_numberOfUnits != NULL) {
    free(_numberOfUnits);
  }
  _numberOfUnits = newNumberOfUnits;
}

/**
 * (no documentation provided)
 */
- (NSDecimalNumber *) chargePrice
{
  return _chargePrice;
}

/**
 * (no documentation provided)
 */
- (void) setChargePrice: (NSDecimalNumber *) newChargePrice
{
  [newChargePrice retain];
  [_chargePrice release];
  _chargePrice = newChargePrice;
}

- (void) dealloc
{
  [self setNumberOfUnits: NULL];
  [self setChargePrice: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "numberOfUnits", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setNumberOfUnits: ((int*) _child_accessor)];
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "chargePrice", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}chargePrice of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif
    __child = [NSDecimalNumber readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}chargePrice of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif

    [self setChargePrice: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self numberOfUnits] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "numberOfUnits", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}numberOfUnits."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}numberOfUnits...");
#endif
    status = xmlTextWriterWriteIntType(writer, [self numberOfUnits]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}numberOfUnits...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}numberOfUnits."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}numberOfUnits."];
    }
  }
  if ([self chargePrice]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "chargePrice", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}chargePrice."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}chargePrice...");
#endif
    [[self chargePrice] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}chargePrice...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}chargePrice."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageChargeTier_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService

/**
 * (no documentation provided)
 */
- (NSString *) identifier
{
  return _identifier;
}

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier
{
  [newIdentifier retain];
  [_identifier release];
  _identifier = newIdentifier;
}

/**
 * (no documentation provided)
 */
- (int) billingCycleDay
{
  return _billingCycleDay;
}

/**
 * (no documentation provided)
 */
- (void) setBillingCycleDay: (int) newBillingCycleDay
{
  _billingCycleDay = newBillingCycleDay;
}

/**
 * (no documentation provided)
 */
- (NSString *) billingPlanName
{
  return _billingPlanName;
}

/**
 * (no documentation provided)
 */
- (void) setBillingPlanName: (NSString *) newBillingPlanName
{
  [newBillingPlanName retain];
  [_billingPlanName release];
  _billingPlanName = newBillingPlanName;
}

/**
 * (no documentation provided)
 */
- (NSString *) name
{
  return _name;
}

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName
{
  [newName retain];
  [_name release];
  _name = newName;
}

/**
 * (no documentation provided)
 */
- (NSString *) billingPlanId
{
  return _billingPlanId;
}

/**
 * (no documentation provided)
 */
- (void) setBillingPlanId: (NSString *) newBillingPlanId
{
  [newBillingPlanId retain];
  [_billingPlanId release];
  _billingPlanId = newBillingPlanId;
}

/**
 * (no documentation provided)
 */
- (NSString *) billingFrequency
{
  return _billingFrequency;
}

/**
 * (no documentation provided)
 */
- (void) setBillingFrequency: (NSString *) newBillingFrequency
{
  [newBillingFrequency retain];
  [_billingFrequency release];
  _billingFrequency = newBillingFrequency;
}

/**
 * (no documentation provided)
 */
- (NSString *) frequency
{
  return _frequency;
}

/**
 * (no documentation provided)
 */
- (void) setFrequency: (NSString *) newFrequency
{
  [newFrequency retain];
  [_frequency release];
  _frequency = newFrequency;
}

/**
 * (no documentation provided)
 */
- (int) number
{
  return _number;
}

/**
 * (no documentation provided)
 */
- (void) setNumber: (int) newNumber
{
  _number = newNumber;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

/**
 * (no documentation provided)
 */
- (BOOL *) cancellable
{
  return _cancellable;
}

/**
 * (no documentation provided)
 */
- (void) setCancellable: (BOOL *) newCancellable
{
  if (_cancellable != NULL) {
    free(_cancellable);
  }
  _cancellable = newCancellable;
}

/**
 * (no documentation provided)
 */
- (BOOL *) autoRenewal
{
  return _autoRenewal;
}

/**
 * (no documentation provided)
 */
- (void) setAutoRenewal: (BOOL *) newAutoRenewal
{
  if (_autoRenewal != NULL) {
    free(_autoRenewal);
  }
  _autoRenewal = newAutoRenewal;
}

- (void) dealloc
{
  [self setIdentifier: nil];
  [self setBillingPlanName: nil];
  [self setName: nil];
  [self setBillingPlanId: nil];
  [self setBillingFrequency: nil];
  [self setFrequency: nil];
  [self setVendorParameters: nil];
  [self setCancellable: NULL];
  [self setAutoRenewal: NULL];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "id", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}id...");
#endif
    [self setIdentifier: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}id...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingCycleDay", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setBillingCycleDay: *((int*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingPlanName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingPlanName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingPlanName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingPlanName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "name", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingPlanId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingPlanId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingPlanId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingPlanId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingFrequency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingFrequency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingFrequency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingFrequency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "frequency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}frequency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}frequency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setFrequency: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "number", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setNumber: *((int*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cancellable", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setCancellable: ((BOOL*) _child_accessor)];
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "autoRenewal", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setAutoRenewal: ((BOOL*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self identifier]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "id", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}id."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}id...");
#endif
    [[self identifier] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}id...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}id."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingCycleDay", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingCycleDay."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingCycleDay...");
#endif
    status = xmlTextWriterWriteIntType(writer, &_billingCycleDay);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingCycleDay...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}billingCycleDay."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingCycleDay."];
    }
  }
  if ([self billingPlanName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingPlanName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingPlanName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingPlanName...");
#endif
    [[self billingPlanName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingPlanName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingPlanName."];
    }
  }
  if ([self name]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "name", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}name."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}name...");
#endif
    [[self name] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}name...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}name."];
    }
  }
  if ([self billingPlanId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingPlanId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingPlanId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingPlanId...");
#endif
    [[self billingPlanId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingPlanId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingPlanId."];
    }
  }
  if ([self billingFrequency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingFrequency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingFrequency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingFrequency...");
#endif
    [[self billingFrequency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingFrequency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingFrequency."];
    }
  }
  if ([self frequency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "frequency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}frequency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}frequency...");
#endif
    [[self frequency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}frequency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}frequency."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "number", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}number."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}number...");
#endif
    status = xmlTextWriterWriteIntType(writer, &_number);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}number...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}number."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}number."];
    }
  }
  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
  if ([self cancellable] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cancellable", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cancellable."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cancellable...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self cancellable]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cancellable...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}cancellable."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cancellable."];
    }
  }
  if ([self autoRenewal] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "autoRenewal", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}autoRenewal."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}autoRenewal...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self autoRenewal]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}autoRenewal...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}autoRenewal."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}autoRenewal."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType_M

/**
 * Reads a CisAddressType from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The CisAddressType, or NULL if unable to be read.
 */
static enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *xmlTextReaderReadHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(xmlTextReaderPtr reader)
{
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *value = calloc(1, sizeof(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType));
  if (enumValue != NULL) {
    if (xmlStrcmp(enumValue, BAD_CAST "SHIP_TO") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_TO;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "SHIP_FROM") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_FROM;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "BILL_TO") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_BILL_TO;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "ADMIN_ORIGIN") == 0) {
      *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_ADMIN_ORIGIN;
      free(enumValue);
      return value;
    }
#if DEBUG_ENUNCIATE
    NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    NSLog(@"Attempt to read enum value failed: NULL value.");
  }
#endif

  return NULL;
}

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _cisAddressType The string to format.
 * @return The enum value or NULL on error.
 */
enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *formatStringToHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(NSString *_cisAddressType)
{
  enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *value = calloc(1, sizeof(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType));
  if ([@"SHIP_TO" isEqualToString:_cisAddressType]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_TO;
  }
  else if ([@"SHIP_FROM" isEqualToString:_cisAddressType]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_FROM;
  }
  else if ([@"BILL_TO" isEqualToString:_cisAddressType]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_BILL_TO;
  }
  else if ([@"ADMIN_ORIGIN" isEqualToString:_cisAddressType]) {
    *value = HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_ADMIN_ORIGIN;
  }
  else{
#if DEBUG_ENUNCIATE
  NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", [_cisAddressType UTF8String]);
#endif
    value = NULL;
  }
  return value;
}

/**
 * Writes a CisAddressType to XML.
 *
 * @param writer The XML writer.
 * @param _cisAddressType The CisAddressType to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeType(xmlTextWriterPtr writer, enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *_cisAddressType)
{
  switch (*_cisAddressType) {
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_TO:
      return xmlTextWriterWriteString(writer, BAD_CAST "SHIP_TO");
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_FROM:
      return xmlTextWriterWriteString(writer, BAD_CAST "SHIP_FROM");
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_BILL_TO:
      return xmlTextWriterWriteString(writer, BAD_CAST "BILL_TO");
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_ADMIN_ORIGIN:
      return xmlTextWriterWriteString(writer, BAD_CAST "ADMIN_ORIGIN");
  }

#if DEBUG_ENUNCIATE
  NSLog(@"Unable to write enum value (no valid value found).");
#endif
  return -1;
}

/**
 * Utility method for getting the string value of CisAddressType.
 *
 * @param _cisAddressType The CisAddressType to format.
 * @return The string value or NULL on error.
 */
static NSString *formatHYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressTypeTypeToString(enum HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType *_cisAddressType)
{
  switch (*_cisAddressType) {
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_TO:
      return @"SHIP_TO";
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_SHIP_FROM:
      return @"SHIP_FROM";
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_BILL_TO:
      return @"BILL_TO";
    case HYBRIS_CIS_MOCK_SUBSCRIPTION_WEB_NS0_CISADDRESSTYPE_ADMIN_ORIGIN:
      return @"ADMIN_ORIGIN";
    default:
      return NULL;
  }

  return NULL;
}
#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddressType_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo_M

/**
 *  Sub-Element defining a billing for subscription.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo

/**
 * (no documentation provided)
 */
- (NSString *) billingId
{
  return _billingId;
}

/**
 * (no documentation provided)
 */
- (void) setBillingId: (NSString *) newBillingId
{
  [newBillingId retain];
  [_billingId release];
  _billingId = newBillingId;
}

/**
 * (no documentation provided)
 */
- (NSString *) billingPeriod
{
  return _billingPeriod;
}

/**
 * (no documentation provided)
 */
- (void) setBillingPeriod: (NSString *) newBillingPeriod
{
  [newBillingPeriod retain];
  [_billingPeriod release];
  _billingPeriod = newBillingPeriod;
}

/**
 * (no documentation provided)
 */
- (NSString *) billingDate
{
  return _billingDate;
}

/**
 * (no documentation provided)
 */
- (void) setBillingDate: (NSString *) newBillingDate
{
  [newBillingDate retain];
  [_billingDate release];
  _billingDate = newBillingDate;
}

/**
 * (no documentation provided)
 */
- (NSString *) amount
{
  return _amount;
}

/**
 * (no documentation provided)
 */
- (void) setAmount: (NSString *) newAmount
{
  [newAmount retain];
  [_amount release];
  _amount = newAmount;
}

/**
 * (no documentation provided)
 */
- (NSString *) status
{
  return _status;
}

/**
 * (no documentation provided)
 */
- (void) setStatus: (NSString *) newStatus
{
  [newStatus retain];
  [_status release];
  _status = newStatus;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) customFields
{
  return _customFields;
}

/**
 * (no documentation provided)
 */
- (void) setCustomFields: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newCustomFields
{
  [newCustomFields retain];
  [_customFields release];
  _customFields = newCustomFields;
}

- (void) dealloc
{
  [self setBillingId: nil];
  [self setBillingPeriod: nil];
  [self setBillingDate: nil];
  [self setAmount: nil];
  [self setStatus: nil];
  [self setCustomFields: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo from an XML reader. The element to be read is
 * "billing".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo *_cisSubscriptionBillingInfo = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element billing."];
    }
  }

  if (xmlStrcmp(BAD_CAST "billing", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}billing.");
#endif
    _cisSubscriptionBillingInfo = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}billing.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo. Expected element billing. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo. Expected element billing. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionBillingInfo;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo to XML under element name "billing".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionBillingInfo The CisSubscriptionBillingInfo to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billing", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}billing. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionBillingInfo for root element {}billing...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionBillingInfo for root element {}billing...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}billing. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingPeriod", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingPeriod of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingPeriod of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingPeriod: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingDate of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingDate of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "amount", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}amount of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}amount of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAmount: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "status", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}status of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}status of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setStatus: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "customFields", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}customFields of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}customFields of type {}annotationHashMap.");
#endif

    [self setCustomFields: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self billingId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingId...");
#endif
    [[self billingId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingId."];
    }
  }
  if ([self billingPeriod]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingPeriod", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingPeriod."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingPeriod...");
#endif
    [[self billingPeriod] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingPeriod...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingPeriod."];
    }
  }
  if ([self billingDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingDate...");
#endif
    [[self billingDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingDate."];
    }
  }
  if ([self amount]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "amount", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}amount."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}amount...");
#endif
    [[self amount] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}amount...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}amount."];
    }
  }
  if ([self status]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "status", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}status."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}status...");
#endif
    [[self status] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}status...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}status."];
    }
  }
  if ([self customFields]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "customFields", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}customFields."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}customFields...");
#endif
    [[self customFields] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}customFields...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}customFields."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType

/**
 * (no documentation provided)
 */
- (NSString *) key
{
  return _key;
}

/**
 * (no documentation provided)
 */
- (void) setKey: (NSString *) newKey
{
  [newKey retain];
  [_key release];
  _key = newKey;
}

/**
 * (no documentation provided)
 */
- (NSString *) value
{
  return _value;
}

/**
 * (no documentation provided)
 */
- (void) setValue: (NSString *) newValue
{
  [newValue retain];
  [_value release];
  _value = newValue;
}

- (void) dealloc
{
  [self setKey: nil];
  [self setValue: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "key", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}key...");
#endif
    [self setKey: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}key...");
#endif
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "value", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}value...");
#endif
    [self setValue: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}value...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self key]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "key", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}key."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}key...");
#endif
    [[self key] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}key...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}key."];
    }
  }
  if ([self value]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "value", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}value."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}value...");
#endif
    [[self value] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}value...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}value."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem

/**
 * (no documentation provided)
 */
- (NSString *) identifier
{
  return _identifier;
}

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier
{
  [newIdentifier retain];
  [_identifier release];
  _identifier = newIdentifier;
}

/**
 * (no documentation provided)
 */
- (NSString *) code
{
  return _code;
}

/**
 * (no documentation provided)
 */
- (void) setCode: (NSString *) newCode
{
  [newCode retain];
  [_code release];
  _code = newCode;
}

/**
 * (no documentation provided)
 */
- (NSString *) name
{
  return _name;
}

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName
{
  [newName retain];
  [_name release];
  _name = newName;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService *) subscriptionTerm
{
  return _subscriptionTerm;
}

/**
 * (no documentation provided)
 */
- (void) setSubscriptionTerm: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService *) newSubscriptionTerm
{
  [newSubscriptionTerm retain];
  [_subscriptionTerm release];
  _subscriptionTerm = newSubscriptionTerm;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan *) subscriptionPlan
{
  return _subscriptionPlan;
}

/**
 * (no documentation provided)
 */
- (void) setSubscriptionPlan: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan *) newSubscriptionPlan
{
  [newSubscriptionPlan retain];
  [_subscriptionPlan release];
  _subscriptionPlan = newSubscriptionPlan;
}

- (void) dealloc
{
  [self setIdentifier: nil];
  [self setCode: nil];
  [self setName: nil];
  [self setVendorParameters: nil];
  [self setSubscriptionTerm: nil];
  [self setSubscriptionPlan: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "id", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}id...");
#endif
    [self setIdentifier: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}id...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "code", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}code of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}code of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCode: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "name", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionTerm", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionTerm of type {}cisTermsOfService.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisTermsOfService readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionTerm of type {}cisTermsOfService.");
#endif

    [self setSubscriptionTerm: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionPlan", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionPlan of type {}cisSubscriptionPlan.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionPlan of type {}cisSubscriptionPlan.");
#endif

    [self setSubscriptionPlan: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self identifier]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "id", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}id."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}id...");
#endif
    [[self identifier] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}id...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}id."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self code]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "code", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}code."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}code...");
#endif
    [[self code] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}code...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}code."];
    }
  }
  if ([self name]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "name", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}name."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}name...");
#endif
    [[self name] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}name...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}name."];
    }
  }
  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
  if ([self subscriptionTerm]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionTerm", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionTerm."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionTerm...");
#endif
    [[self subscriptionTerm] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionTerm...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionTerm."];
    }
  }
  if ([self subscriptionPlan]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionPlan", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionPlan."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionPlan...");
#endif
    [[self subscriptionPlan] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionPlan...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionPlan."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder_M

/**
 *  A subscription order containing a list of subscription items.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder

/**
 * Unique id (e.g order/shipment/return number).
 */
- (NSString *) identifier
{
  return _identifier;
}

/**
 * Unique id (e.g order/shipment/return number).
 */
- (void) setIdentifier: (NSString *) newIdentifier
{
  [newIdentifier retain];
  [_identifier release];
  _identifier = newIdentifier;
}

/**
 * Date used for records (e.g. order/shipping/return date).
 */
- (NSDate *) date
{
  return _date;
}

/**
 * Date used for records (e.g. order/shipping/return date).
 */
- (void) setDate: (NSDate *) newDate
{
  [newDate retain];
  [_date release];
  _date = newDate;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

/**
 * List of addresses.
 */
- (NSArray *) addresses
{
  return _addresses;
}

/**
 * List of addresses.
 */
- (void) setAddresses: (NSArray *) newAddresses
{
  [newAddresses retain];
  [_addresses release];
  _addresses = newAddresses;
}

/**
 * List of line items. intended for "Buy now" items in cart
 */
- (NSArray *) lineItems
{
  return _lineItems;
}

/**
 * List of line items. intended for "Buy now" items in cart
 */
- (void) setLineItems: (NSArray *) newLineItems
{
  [newLineItems retain];
  [_lineItems release];
  _lineItems = newLineItems;
}

/**
 * Vendor specific values to pass in the request.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * Vendor specific values to pass in the request.
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

/**
 * unique identifier for a specific account.
 */
- (NSString *) merchantAccountId
{
  return _merchantAccountId;
}

/**
 * unique identifier for a specific account.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId
{
  [newMerchantAccountId retain];
  [_merchantAccountId release];
  _merchantAccountId = newMerchantAccountId;
}

/**
 * List of subscription items.
 */
- (NSArray *) items
{
  return _items;
}

/**
 * List of subscription items.
 */
- (void) setItems: (NSArray *) newItems
{
  [newItems retain];
  [_items release];
  _items = newItems;
}

- (void) dealloc
{
  [self setIdentifier: nil];
  [self setDate: nil];
  [self setCurrency: nil];
  [self setAddresses: nil];
  [self setLineItems: nil];
  [self setVendorParameters: nil];
  [self setMerchantAccountId: nil];
  [self setItems: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder from an XML reader. The element to be read is
 * "subscriptionorder".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *_cisSubscriptionOrder = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionorder."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionorder", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionorder.");
#endif
    _cisSubscriptionOrder = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionorder.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder. Expected element subscriptionorder. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder. Expected element subscriptionorder. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionOrder;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder to XML under element name "subscriptionorder".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionOrder The CisSubscriptionOrder to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionorder", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionorder. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionOrder for root element {}subscriptionorder...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionOrder for root element {}subscriptionorder...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionorder. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "id", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}id...");
#endif
    [self setIdentifier: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}id...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "date", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}date of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}date of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "addresses", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}addresses...");
#endif
      //start wrapper element "{}addresses"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "address", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}address of type {}cisAddress.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}address of type {}cisAddress.");
#endif

    if ([self addresses]) {
      [self setAddresses: [[self addresses] arrayByAddingObject: __child]];
    }
    else {
      [self setAddresses: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}addresses...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setAddresses: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "lineItems", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}lineItems...");
#endif
      //start wrapper element "{}lineItems"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "lineItem", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}lineItem of type {}cisLineItem.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}lineItem of type {}cisLineItem.");
#endif

    if ([self lineItems]) {
      [self setLineItems: [[self lineItems] arrayByAddingObject: __child]];
    }
    else {
      [self setLineItems: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}lineItems...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setLineItems: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantAccountId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantAccountId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "items", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}items...");
#endif
      //start wrapper element "{}items"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "item", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}item of type {}cisSubscriptionItem.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}item of type {}cisSubscriptionItem.");
#endif

    if ([self items]) {
      [self setItems: [[self items] arrayByAddingObject: __child]];
    }
    else {
      [self setItems: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}items...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setItems: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self identifier]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "id", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}id."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}id...");
#endif
    [[self identifier] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}id...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}id."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self date]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "date", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}date."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}date...");
#endif
    [[self date] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}date...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}date."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
  if ([self addresses]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "addresses", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}addresses."];
    }
    __enumerator = [[self addresses] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "address", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}address."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}address...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}address...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}address."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}addresses."];
    }
  }
  if ([self lineItems]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "lineItems", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}lineItems."];
    }
    __enumerator = [[self lineItems] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "lineItem", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}lineItem."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}lineItem...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}lineItem...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}lineItem."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}lineItems."];
    }
  }
  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
  if ([self merchantAccountId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantAccountId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantAccountId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantAccountId...");
#endif
    [[self merchantAccountId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantAccountId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantAccountId."];
    }
  }
  if ([self items]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "items", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}items."];
    }
    __enumerator = [[self items] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "item", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}item."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}item...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}item...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}item."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}items."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan

/**
 * (no documentation provided)
 */
- (NSString *) identifier
{
  return _identifier;
}

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier
{
  [newIdentifier retain];
  [_identifier release];
  _identifier = newIdentifier;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) vendorParameters
{
  return _vendorParameters;
}

/**
 * (no documentation provided)
 */
- (void) setVendorParameters: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *) newVendorParameters
{
  [newVendorParameters retain];
  [_vendorParameters release];
  _vendorParameters = newVendorParameters;
}

/**
 * (no documentation provided)
 */
- (NSArray *) usageCharges
{
  return _usageCharges;
}

/**
 * (no documentation provided)
 */
- (void) setUsageCharges: (NSArray *) newUsageCharges
{
  [newUsageCharges retain];
  [_usageCharges release];
  _usageCharges = newUsageCharges;
}

/**
 * (no documentation provided)
 */
- (NSArray *) charges
{
  return _charges;
}

/**
 * (no documentation provided)
 */
- (void) setCharges: (NSArray *) newCharges
{
  [newCharges retain];
  [_charges release];
  _charges = newCharges;
}

/**
 * (no documentation provided)
 */
- (NSString *) name
{
  return _name;
}

/**
 * (no documentation provided)
 */
- (void) setName: (NSString *) newName
{
  [newName retain];
  [_name release];
  _name = newName;
}

- (void) dealloc
{
  [self setIdentifier: nil];
  [self setVendorParameters: nil];
  [self setUsageCharges: nil];
  [self setCharges: nil];
  [self setName: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  if ((xmlStrcmp(BAD_CAST "id", xmlTextReaderConstLocalName(reader)) == 0) && (xmlTextReaderConstNamespaceUri(reader) == NULL)) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read attribute {}id...");
#endif
    [self setIdentifier: (NSString*) [NSString readXMLType: reader]];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read attribute {}id...");
#endif
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "vendorParameters", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}vendorParameters of type {}annotationHashMap.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}vendorParameters of type {}annotationHashMap.");
#endif

    [self setVendorParameters: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "usageCharges", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}usageCharges...");
#endif
      //start wrapper element "{}usageCharges"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "usageCharge", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}usageCharge of type {}cisUsageCharge.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisUsageCharge readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}usageCharge of type {}cisUsageCharge.");
#endif

    if ([self usageCharges]) {
      [self setUsageCharges: [[self usageCharges] arrayByAddingObject: __child]];
    }
    else {
      [self setUsageCharges: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}usageCharges...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setUsageCharges: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "charges", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}charges...");
#endif
      //start wrapper element "{}charges"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "charge", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}charge of type {}cisChargeEntry.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChargeEntry readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}charge of type {}cisChargeEntry.");
#endif

    if ([self charges]) {
      [self setCharges: [[self charges] arrayByAddingObject: __child]];
    }
    else {
      [self setCharges: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}charges...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setCharges: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "name", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}name of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setName: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

  if ([self identifier]) {

    status = xmlTextWriterStartAttributeNS(writer, NULL, BAD_CAST "id", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start attribute {}id."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing attribute {}id...");
#endif
    [[self identifier] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote attribute {}id...");
#endif

    status = xmlTextWriterEndAttribute(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end attribute {}id."];
    }
  }
}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self vendorParameters]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "vendorParameters", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}vendorParameters."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}vendorParameters...");
#endif
    [[self vendorParameters] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}vendorParameters...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}vendorParameters."];
    }
  }
  if ([self usageCharges]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "usageCharges", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}usageCharges."];
    }
    __enumerator = [[self usageCharges] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "usageCharge", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}usageCharge."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}usageCharge...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}usageCharge...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}usageCharge."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}usageCharges."];
    }
  }
  if ([self charges]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "charges", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}charges."];
    }
    __enumerator = [[self charges] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "charge", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}charge."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}charge...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}charge...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}charge."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}charges."];
    }
  }
  if ([self name]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "name", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}name."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}name...");
#endif
    [[self name] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}name...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}name."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPlan_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap

/**
 * (no documentation provided)
 */
- (NSArray *) entries
{
  return _entries;
}

/**
 * (no documentation provided)
 */
- (void) setEntries: (NSArray *) newEntries
{
  [newEntries retain];
  [_entries release];
  _entries = newEntries;
}

- (void) dealloc
{
  [self setEntries: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "parameter", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}parameter of type {}annotationHashMapEntryType.");
#endif

     __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMapEntryType readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}parameter of type {}annotationHashMapEntryType.");
#endif

    if ([self entries]) {
      [self setEntries: [[self entries] arrayByAddingObject: __child]];
    }
    else {
      [self setEntries: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self entries]) {
    __enumerator = [[self entries] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "parameter", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}parameter."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}parameter...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}parameter...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}parameter."];
      }
    } //end item iterator.
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AnnotationHashMap_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest_M

/**
 *  A payment request to initiate payment session.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest

/**
 * If the service approves the transaction, the customer will be redirected to this URL.
 */
- (NSString *) returnUrl
{
  return _returnUrl;
}

/**
 * If the service approves the transaction, the customer will be redirected to this URL.
 */
- (void) setReturnUrl: (NSString *) newReturnUrl
{
  [newReturnUrl retain];
  [_returnUrl release];
  _returnUrl = newReturnUrl;
}

/**
 * If the service cancels the transaction or discovers an error, the customer will be redirected to this URL.
 */
- (NSString *) cancelReturnUrl
{
  return _cancelReturnUrl;
}

/**
 * If the service cancels the transaction or discovers an error, the customer will be redirected to this URL.
 */
- (void) setCancelReturnUrl: (NSString *) newCancelReturnUrl
{
  [newCancelReturnUrl retain];
  [_cancelReturnUrl release];
  _cancelReturnUrl = newCancelReturnUrl;
}

/**
 * The ipAddress of the client.
 */
- (NSString *) ipAddress
{
  return _ipAddress;
}

/**
 * The ipAddress of the client.
 */
- (void) setIpAddress: (NSString *) newIpAddress
{
  [newIpAddress retain];
  [_ipAddress release];
  _ipAddress = newIpAddress;
}

/**
 * Identifying attribute of the buyer.
 */
- (NSString *) merchantAccountId
{
  return _merchantAccountId;
}

/**
 * Identifying attribute of the buyer.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId
{
  [newMerchantAccountId retain];
  [_merchantAccountId release];
  _merchantAccountId = newMerchantAccountId;
}

- (void) dealloc
{
  [self setReturnUrl: nil];
  [self setCancelReturnUrl: nil];
  [self setIpAddress: nil];
  [self setMerchantAccountId: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest from an XML reader. The element to be read is
 * "subscriptionSessionInitRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest *_cisSubscriptionSessionInitRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionSessionInitRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionSessionInitRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionSessionInitRequest.");
#endif
    _cisSubscriptionSessionInitRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionSessionInitRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest. Expected element subscriptionSessionInitRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest. Expected element subscriptionSessionInitRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionSessionInitRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest to XML under element name "subscriptionSessionInitRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionSessionInitRequest The CisSubscriptionSessionInitRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionSessionInitRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionSessionInitRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionSessionInitRequest for root element {}subscriptionSessionInitRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionSessionInitRequest for root element {}subscriptionSessionInitRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionSessionInitRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "returnUrl", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}returnUrl of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}returnUrl of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setReturnUrl: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cancelReturnUrl", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}cancelReturnUrl of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}cancelReturnUrl of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCancelReturnUrl: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "ipAddress", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}ipAddress of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}ipAddress of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setIpAddress: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantAccountId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantAccountId: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self returnUrl]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "returnUrl", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}returnUrl."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}returnUrl...");
#endif
    [[self returnUrl] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}returnUrl...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}returnUrl."];
    }
  }
  if ([self cancelReturnUrl]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cancelReturnUrl", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cancelReturnUrl."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cancelReturnUrl...");
#endif
    [[self cancelReturnUrl] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cancelReturnUrl...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cancelReturnUrl."];
    }
  }
  if ([self ipAddress]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "ipAddress", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}ipAddress."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}ipAddress...");
#endif
    [[self ipAddress] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}ipAddress...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}ipAddress."];
    }
  }
  if ([self merchantAccountId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantAccountId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantAccountId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantAccountId...");
#endif
    [[self merchantAccountId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantAccountId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantAccountId."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionInitRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult_M

/**
 *  The result of a payment transaction such as authorizing or capturing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult

/**
 * The amount / subscription price .
 */
- (NSDecimalNumber *) amount
{
  return _amount;
}

/**
 * The amount / subscription price .
 */
- (void) setAmount: (NSDecimalNumber *) newAmount
{
  [newAmount retain];
  [_amount release];
  _amount = newAmount;
}

/**
 * (no documentation provided)
 */
- (NSString *) sessionTransactionToken
{
  return _sessionTransactionToken;
}

/**
 * (no documentation provided)
 */
- (void) setSessionTransactionToken: (NSString *) newSessionTransactionToken
{
  [newSessionTransactionToken retain];
  [_sessionTransactionToken release];
  _sessionTransactionToken = newSessionTransactionToken;
}

/**
 * The transaction verification key.
 */
- (NSString *) merchantProductId
{
  return _merchantProductId;
}

/**
 * The transaction verification key.
 */
- (void) setMerchantProductId: (NSString *) newMerchantProductId
{
  [newMerchantProductId retain];
  [_merchantProductId release];
  _merchantProductId = newMerchantProductId;
}

- (void) dealloc
{
  [self setAmount: nil];
  [self setSessionTransactionToken: nil];
  [self setMerchantProductId: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult from an XML reader. The element to be read is
 * "subscriptionTransactionResult".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *_cisSubscriptionTransactionResult = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionTransactionResult."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionTransactionResult", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionTransactionResult.");
#endif
    _cisSubscriptionTransactionResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionTransactionResult.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult. Expected element subscriptionTransactionResult. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult. Expected element subscriptionTransactionResult. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionTransactionResult;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult to XML under element name "subscriptionTransactionResult".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionTransactionResult The CisSubscriptionTransactionResult to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionTransactionResult", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionTransactionResult. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionTransactionResult for root element {}subscriptionTransactionResult...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionTransactionResult for root element {}subscriptionTransactionResult...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionTransactionResult. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "amount", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}amount of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif
    __child = [NSDecimalNumber readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}amount of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif

    [self setAmount: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "sessionTransactionToken", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}sessionTransactionToken of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}sessionTransactionToken of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSessionTransactionToken: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantProductId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantProductId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantProductId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantProductId: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self amount]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "amount", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}amount."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}amount...");
#endif
    [[self amount] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}amount...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}amount."];
    }
  }
  if ([self sessionTransactionToken]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "sessionTransactionToken", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}sessionTransactionToken."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}sessionTransactionToken...");
#endif
    [[self sessionTransactionToken] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}sessionTransactionToken...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}sessionTransactionToken."];
    }
  }
  if ([self merchantProductId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantProductId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantProductId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantProductId...");
#endif
    [[self merchantProductId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantProductId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantProductId."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest_M

/**
 *  A request to finalize a transactional WebSession based on an issued token.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest

/**
 * the request id of the authorization to capture on.
 */
- (NSString *) authorizationRequestId
{
  return _authorizationRequestId;
}

/**
 * the request id of the authorization to capture on.
 */
- (void) setAuthorizationRequestId: (NSString *) newAuthorizationRequestId
{
  [newAuthorizationRequestId retain];
  [_authorizationRequestId release];
  _authorizationRequestId = newAuthorizationRequestId;
}

/**
 * the authorization request token used.
 */
- (NSString *) authorizationRequestToken
{
  return _authorizationRequestToken;
}

/**
 * the authorization request token used.
 */
- (void) setAuthorizationRequestToken: (NSString *) newAuthorizationRequestToken
{
  [newAuthorizationRequestToken retain];
  [_authorizationRequestToken release];
  _authorizationRequestToken = newAuthorizationRequestToken;
}

- (void) dealloc
{
  [self setAuthorizationRequestId: nil];
  [self setAuthorizationRequestToken: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest from an XML reader. The element to be read is
 * "subscriptionSessionFinalization".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest *_cisSubscriptionSessionFinalizeRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionSessionFinalization."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionSessionFinalization", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionSessionFinalization.");
#endif
    _cisSubscriptionSessionFinalizeRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionSessionFinalization.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest. Expected element subscriptionSessionFinalization. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest. Expected element subscriptionSessionFinalization. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionSessionFinalizeRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest to XML under element name "subscriptionSessionFinalization".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionSessionFinalizeRequest The CisSubscriptionSessionFinalizeRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionSessionFinalization", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionSessionFinalization. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionSessionFinalizeRequest for root element {}subscriptionSessionFinalization...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionSessionFinalizeRequest for root element {}subscriptionSessionFinalization...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionSessionFinalization. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "authorizationRequestId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}authorizationRequestId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}authorizationRequestId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAuthorizationRequestId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "authorizationRequestToken", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}authorizationRequestToken of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}authorizationRequestToken of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAuthorizationRequestToken: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self authorizationRequestId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "authorizationRequestId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}authorizationRequestId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}authorizationRequestId...");
#endif
    [[self authorizationRequestId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}authorizationRequestId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}authorizationRequestId."];
    }
  }
  if ([self authorizationRequestToken]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "authorizationRequestToken", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}authorizationRequestToken."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}authorizationRequestToken...");
#endif
    [[self authorizationRequestToken] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}authorizationRequestToken...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}authorizationRequestToken."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionSessionFinalizeRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest_M

/**
 *  A request to replace the payment method for an existing subscription with another existing payment method.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest

/**
 * identifying attribute of the subscription.
 */
- (NSString *) merchantSubscriptionId
{
  return _merchantSubscriptionId;
}

/**
 * identifying attribute of the subscription.
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId
{
  [newMerchantSubscriptionId retain];
  [_merchantSubscriptionId release];
  _merchantSubscriptionId = newMerchantSubscriptionId;
}

/**
 * identifying attribute of the payment method.
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * identifying attribute of the payment method.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

- (void) dealloc
{
  [self setMerchantSubscriptionId: nil];
  [self setMerchantPaymentMethodId: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest from an XML reader. The element to be read is
 * "subscriptionReplacePaymentMethodRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest *_cisSubscriptionReplacePaymentMethodRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionReplacePaymentMethodRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionReplacePaymentMethodRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionReplacePaymentMethodRequest.");
#endif
    _cisSubscriptionReplacePaymentMethodRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionReplacePaymentMethodRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest. Expected element subscriptionReplacePaymentMethodRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest. Expected element subscriptionReplacePaymentMethodRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionReplacePaymentMethodRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest to XML under element name "subscriptionReplacePaymentMethodRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionReplacePaymentMethodRequest The CisSubscriptionReplacePaymentMethodRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionReplacePaymentMethodRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionReplacePaymentMethodRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionReplacePaymentMethodRequest for root element {}subscriptionReplacePaymentMethodRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionReplacePaymentMethodRequest for root element {}subscriptionReplacePaymentMethodRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionReplacePaymentMethodRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantSubscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantSubscriptionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantSubscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantSubscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantSubscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantSubscriptionId...");
#endif
    [[self merchantSubscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantSubscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantSubscriptionId."];
    }
  }
  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionReplacePaymentMethodRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult_M

/**
 *  Result type for payment method related requests.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult

/**
 * The payment method.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) paymentMethod
{
  return _paymentMethod;
}

/**
 * The payment method.
 */
- (void) setPaymentMethod: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) newPaymentMethod
{
  [newPaymentMethod retain];
  [_paymentMethod release];
  _paymentMethod = newPaymentMethod;
}

- (void) dealloc
{
  [self setPaymentMethod: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult from an XML reader. The element to be read is
 * "paymentMethodResult".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult *_cisPaymentMethodResult = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element paymentMethodResult."];
    }
  }

  if (xmlStrcmp(BAD_CAST "paymentMethodResult", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}paymentMethodResult.");
#endif
    _cisPaymentMethodResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}paymentMethodResult.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult. Expected element paymentMethodResult. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult. Expected element paymentMethodResult. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisPaymentMethodResult;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult to XML under element name "paymentMethodResult".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisPaymentMethodResult The CisPaymentMethodResult to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethodResult", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}paymentMethodResult. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisPaymentMethodResult for root element {}paymentMethodResult...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisPaymentMethodResult for root element {}paymentMethodResult...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}paymentMethodResult. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "paymentMethod", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}paymentMethod of type {}cisPaymentMethod.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}paymentMethod of type {}cisPaymentMethod.");
#endif

    [self setPaymentMethod: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self paymentMethod]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethod", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}paymentMethod."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}paymentMethod...");
#endif
    [[self paymentMethod] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}paymentMethod...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}paymentMethod."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList_M

/**
 *  Retrieves a billing activity list for subscription.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList

/**
 * Merchant ID of a subscription.
 */
- (NSString *) merchantSubscriptionId
{
  return _merchantSubscriptionId;
}

/**
 * Merchant ID of a subscription.
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId
{
  [newMerchantSubscriptionId retain];
  [_merchantSubscriptionId release];
  _merchantSubscriptionId = newMerchantSubscriptionId;
}

/**
 * List billings.
 */
- (NSArray *) billings
{
  return _billings;
}

/**
 * List billings.
 */
- (void) setBillings: (NSArray *) newBillings
{
  [newBillings retain];
  [_billings release];
  _billings = newBillings;
}

- (void) dealloc
{
  [self setMerchantSubscriptionId: nil];
  [self setBillings: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList from an XML reader. The element to be read is
 * "billingActivityList".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList *_cisSubscriptionBillingActivityList = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element billingActivityList."];
    }
  }

  if (xmlStrcmp(BAD_CAST "billingActivityList", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}billingActivityList.");
#endif
    _cisSubscriptionBillingActivityList = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}billingActivityList.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList. Expected element billingActivityList. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList. Expected element billingActivityList. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionBillingActivityList;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList to XML under element name "billingActivityList".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionBillingActivityList The CisSubscriptionBillingActivityList to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingActivityList", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}billingActivityList. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionBillingActivityList for root element {}billingActivityList...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionBillingActivityList for root element {}billingActivityList...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}billingActivityList. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantSubscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantSubscriptionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billings", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}billings...");
#endif
      //start wrapper element "{}billings"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billing", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billing of type {}cisSubscriptionBillingInfo.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billing of type {}cisSubscriptionBillingInfo.");
#endif

    if ([self billings]) {
      [self setBillings: [[self billings] arrayByAddingObject: __child]];
    }
    else {
      [self setBillings: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}billings...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setBillings: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantSubscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantSubscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantSubscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantSubscriptionId...");
#endif
    [[self merchantSubscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantSubscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantSubscriptionId."];
    }
  }
  if ([self billings]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billings", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}billings."];
    }
    __enumerator = [[self billings] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billing", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}billing."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}billing...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}billing...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}billing."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}billings."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingActivityList_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest_M

/**
 *  A request to cancel an existing subscription.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest

/**
 * Identifying attribute of the subscription.
 */
- (NSString *) merchantSubscriptionId
{
  return _merchantSubscriptionId;
}

/**
 * Identifying attribute of the subscription.
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId
{
  [newMerchantSubscriptionId retain];
  [_merchantSubscriptionId release];
  _merchantSubscriptionId = newMerchantSubscriptionId;
}

/**
 * The cancellation mode.
 */
- (NSString *) cancelationMode
{
  return _cancelationMode;
}

/**
 * The cancellation mode.
 */
- (void) setCancelationMode: (NSString *) newCancelationMode
{
  [newCancelationMode retain];
  [_cancelationMode release];
  _cancelationMode = newCancelationMode;
}

/**
 * If subscription should be canceled immediately.
 */
- (BOOL) force
{
  return _force;
}

/**
 * If subscription should be canceled immediately.
 */
- (void) setForce: (BOOL) newForce
{
  _force = newForce;
}

- (void) dealloc
{
  [self setMerchantSubscriptionId: nil];
  [self setCancelationMode: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest from an XML reader. The element to be read is
 * "subscriptionCancelSubscriptionRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest *_cisSubscriptionCancelSubscriptionRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionCancelSubscriptionRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionCancelSubscriptionRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionCancelSubscriptionRequest.");
#endif
    _cisSubscriptionCancelSubscriptionRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionCancelSubscriptionRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest. Expected element subscriptionCancelSubscriptionRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest. Expected element subscriptionCancelSubscriptionRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionCancelSubscriptionRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest to XML under element name "subscriptionCancelSubscriptionRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionCancelSubscriptionRequest The CisSubscriptionCancelSubscriptionRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionCancelSubscriptionRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionCancelSubscriptionRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionCancelSubscriptionRequest for root element {}subscriptionCancelSubscriptionRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionCancelSubscriptionRequest for root element {}subscriptionCancelSubscriptionRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionCancelSubscriptionRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantSubscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantSubscriptionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cancelationMode", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}cancelationMode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}cancelationMode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCancelationMode: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "force", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setForce: *((BOOL*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantSubscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantSubscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantSubscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantSubscriptionId...");
#endif
    [[self merchantSubscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantSubscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantSubscriptionId."];
    }
  }
  if ([self cancelationMode]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cancelationMode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cancelationMode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cancelationMode...");
#endif
    [[self cancelationMode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cancelationMode...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cancelationMode."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "force", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}force."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}force...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, &_force);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}force...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}force."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}force."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCancelSubscriptionRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest_M

/**
 *  Request for subscription creation.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest

/**
 * Identifying order that subscription related to.
 */
- (NSString *) orderId
{
  return _orderId;
}

/**
 * Identifying order that subscription related to.
 */
- (void) setOrderId: (NSString *) newOrderId
{
  [newOrderId retain];
  [_orderId release];
  _orderId = newOrderId;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

/**
 * (no documentation provided)
 */
- (NSDate *) orderDate
{
  return _orderDate;
}

/**
 * (no documentation provided)
 */
- (void) setOrderDate: (NSDate *) newOrderDate
{
  [newOrderDate retain];
  [_orderDate release];
  _orderDate = newOrderDate;
}

/**
 * Identifying attribute of the buyer.
 */
- (NSString *) merchantAccountId
{
  return _merchantAccountId;
}

/**
 * Identifying attribute of the buyer.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId
{
  [newMerchantAccountId retain];
  [_merchantAccountId release];
  _merchantAccountId = newMerchantAccountId;
}

/**
 * ID of the payment method.
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * ID of the payment method.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

/**
 * (no documentation provided)
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem *) subscriptionItem
{
  return _subscriptionItem;
}

/**
 * (no documentation provided)
 */
- (void) setSubscriptionItem: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem *) newSubscriptionItem
{
  [newSubscriptionItem retain];
  [_subscriptionItem release];
  _subscriptionItem = newSubscriptionItem;
}

- (void) dealloc
{
  [self setOrderId: nil];
  [self setCurrency: nil];
  [self setOrderDate: nil];
  [self setMerchantAccountId: nil];
  [self setMerchantPaymentMethodId: nil];
  [self setSubscriptionItem: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest from an XML reader. The element to be read is
 * "subscriptionCreateRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest *_cisSubscriptionCreateRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionCreateRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionCreateRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionCreateRequest.");
#endif
    _cisSubscriptionCreateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionCreateRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest. Expected element subscriptionCreateRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest. Expected element subscriptionCreateRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionCreateRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest to XML under element name "subscriptionCreateRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionCreateRequest The CisSubscriptionCreateRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionCreateRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionCreateRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionCreateRequest for root element {}subscriptionCreateRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionCreateRequest for root element {}subscriptionCreateRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionCreateRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "orderId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}orderId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}orderId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setOrderId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "orderDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}orderDate of type {http://www.w3.org/2001/XMLSchema}date.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}orderDate of type {http://www.w3.org/2001/XMLSchema}date.");
#endif

    [self setOrderDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantAccountId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantAccountId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionItem", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionItem of type {}cisSubscriptionItem.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionItem readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionItem of type {}cisSubscriptionItem.");
#endif

    [self setSubscriptionItem: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self orderId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "orderId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}orderId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}orderId...");
#endif
    [[self orderId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}orderId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}orderId."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
  if ([self orderDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "orderDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}orderDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}orderDate...");
#endif
    [[self orderDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}orderDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}orderDate."];
    }
  }
  if ([self merchantAccountId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantAccountId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantAccountId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantAccountId...");
#endif
    [[self merchantAccountId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantAccountId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantAccountId."];
    }
  }
  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
  if ([self subscriptionItem]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionItem", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionItem."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionItem...");
#endif
    [[self subscriptionItem] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionItem...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionItem."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionCreateRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest_M

/**
 *  A subscription order request.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest

/**
 * Identifying attribute of the buyer.
 */
- (NSString *) merchantAccountId
{
  return _merchantAccountId;
}

/**
 * Identifying attribute of the buyer.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId
{
  [newMerchantAccountId retain];
  [_merchantAccountId release];
  _merchantAccountId = newMerchantAccountId;
}

/**
 * Identifying attribute of the payment method (if available).
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * Identifying attribute of the payment method (if available).
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

/**
 * The subscription order.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *) subscriptionOrder
{
  return _subscriptionOrder;
}

/**
 * The subscription order.
 */
- (void) setSubscriptionOrder: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder *) newSubscriptionOrder
{
  [newSubscriptionOrder retain];
  [_subscriptionOrder release];
  _subscriptionOrder = newSubscriptionOrder;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

- (void) dealloc
{
  [self setMerchantAccountId: nil];
  [self setMerchantPaymentMethodId: nil];
  [self setSubscriptionOrder: nil];
  [self setCurrency: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest from an XML reader. The element to be read is
 * "subscriptionOrderPostRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest *_cisSubscriptionOrderPostRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionOrderPostRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionOrderPostRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionOrderPostRequest.");
#endif
    _cisSubscriptionOrderPostRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionOrderPostRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest. Expected element subscriptionOrderPostRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest. Expected element subscriptionOrderPostRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionOrderPostRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest to XML under element name "subscriptionOrderPostRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionOrderPostRequest The CisSubscriptionOrderPostRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionOrderPostRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionOrderPostRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionOrderPostRequest for root element {}subscriptionOrderPostRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionOrderPostRequest for root element {}subscriptionOrderPostRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionOrderPostRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantAccountId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantAccountId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionOrder", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionOrder of type {}cisSubscriptionOrder.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrder readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionOrder of type {}cisSubscriptionOrder.");
#endif

    [self setSubscriptionOrder: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantAccountId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantAccountId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantAccountId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantAccountId...");
#endif
    [[self merchantAccountId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantAccountId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantAccountId."];
    }
  }
  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
  if ([self subscriptionOrder]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionOrder", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionOrder."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionOrder...");
#endif
    [[self subscriptionOrder] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionOrder...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionOrder."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionOrderPostRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest_M

/**
 *  A payment request to for example authorize or capture an amount.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest

/**
 * The amount of the transaction.
 */
- (NSDecimalNumber *) amount
{
  return _amount;
}

/**
 * The amount of the transaction.
 */
- (void) setAmount: (NSDecimalNumber *) newAmount
{
  [newAmount retain];
  [_amount release];
  _amount = newAmount;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

/**
 * ID of a payment profile.
 */
- (NSString *) profileId
{
  return _profileId;
}

/**
 * ID of a payment profile.
 */
- (void) setProfileId: (NSString *) newProfileId
{
  [newProfileId retain];
  [_profileId release];
  _profileId = newProfileId;
}

/**
 * ID of the payment method.
 */
- (NSString *) paymentMethodId
{
  return _paymentMethodId;
}

/**
 * ID of the payment method.
 */
- (void) setPaymentMethodId: (NSString *) newPaymentMethodId
{
  [newPaymentMethodId retain];
  [_paymentMethodId release];
  _paymentMethodId = newPaymentMethodId;
}

/**
 * Merchant ID of the transaction.
 */
- (NSString *) merchantTransactionId
{
  return _merchantTransactionId;
}

/**
 * Merchant ID of the transaction.
 */
- (void) setMerchantTransactionId: (NSString *) newMerchantTransactionId
{
  [newMerchantTransactionId retain];
  [_merchantTransactionId release];
  _merchantTransactionId = newMerchantTransactionId;
}

/**
 * Descriptive text for transaction.
 */
- (NSString *) merchantTransactionDescription
{
  return _merchantTransactionDescription;
}

/**
 * Descriptive text for transaction.
 */
- (void) setMerchantTransactionDescription: (NSString *) newMerchantTransactionDescription
{
  [newMerchantTransactionDescription retain];
  [_merchantTransactionDescription release];
  _merchantTransactionDescription = newMerchantTransactionDescription;
}

/**
 * List of line items.
 */
- (NSArray *) lineItems
{
  return _lineItems;
}

/**
 * List of line items.
 */
- (void) setLineItems: (NSArray *) newLineItems
{
  [newLineItems retain];
  [_lineItems release];
  _lineItems = newLineItems;
}

/**
 * Transaction mode (AUTH, CAPTURE or AUTHCAPTURE).
 */
- (NSString *) transactionMode
{
  return _transactionMode;
}

/**
 * Transaction mode (AUTH, CAPTURE or AUTHCAPTURE).
 */
- (void) setTransactionMode: (NSString *) newTransactionMode
{
  [newTransactionMode retain];
  [_transactionMode release];
  _transactionMode = newTransactionMode;
}

- (void) dealloc
{
  [self setAmount: nil];
  [self setCurrency: nil];
  [self setProfileId: nil];
  [self setPaymentMethodId: nil];
  [self setMerchantTransactionId: nil];
  [self setMerchantTransactionDescription: nil];
  [self setLineItems: nil];
  [self setTransactionMode: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest from an XML reader. The element to be read is
 * "subscriptionProcessPayNowRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest *_cisSubscriptionPayNowRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionProcessPayNowRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionProcessPayNowRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionProcessPayNowRequest.");
#endif
    _cisSubscriptionPayNowRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionProcessPayNowRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest. Expected element subscriptionProcessPayNowRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest. Expected element subscriptionProcessPayNowRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionPayNowRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest to XML under element name "subscriptionProcessPayNowRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionPayNowRequest The CisSubscriptionPayNowRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionProcessPayNowRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionProcessPayNowRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionPayNowRequest for root element {}subscriptionProcessPayNowRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionPayNowRequest for root element {}subscriptionProcessPayNowRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionProcessPayNowRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "amount", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}amount of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif
    __child = [NSDecimalNumber readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}amount of type {http://www.w3.org/2001/XMLSchema}decimal.");
#endif

    [self setAmount: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "profileId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}profileId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}profileId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setProfileId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "paymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}paymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}paymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setPaymentMethodId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantTransactionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantTransactionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantTransactionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantTransactionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantTransactionDescription", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantTransactionDescription of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantTransactionDescription of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantTransactionDescription: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "lineItems", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}lineItems...");
#endif
      //start wrapper element "{}lineItems"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "lineItem", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}lineItem of type {}cisLineItem.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisLineItem readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}lineItem of type {}cisLineItem.");
#endif

    if ([self lineItems]) {
      [self setLineItems: [[self lineItems] arrayByAddingObject: __child]];
    }
    else {
      [self setLineItems: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}lineItems...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setLineItems: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "transactionMode", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}transactionMode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}transactionMode of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setTransactionMode: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self amount]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "amount", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}amount."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}amount...");
#endif
    [[self amount] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}amount...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}amount."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
  if ([self profileId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "profileId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}profileId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}profileId...");
#endif
    [[self profileId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}profileId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}profileId."];
    }
  }
  if ([self paymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}paymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}paymentMethodId...");
#endif
    [[self paymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}paymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}paymentMethodId."];
    }
  }
  if ([self merchantTransactionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantTransactionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantTransactionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantTransactionId...");
#endif
    [[self merchantTransactionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantTransactionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantTransactionId."];
    }
  }
  if ([self merchantTransactionDescription]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantTransactionDescription", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantTransactionDescription."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantTransactionDescription...");
#endif
    [[self merchantTransactionDescription] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantTransactionDescription...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantTransactionDescription."];
    }
  }
  if ([self lineItems]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "lineItems", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}lineItems."];
    }
    __enumerator = [[self lineItems] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "lineItem", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}lineItem."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}lineItem...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}lineItem...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}lineItem."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}lineItems."];
    }
  }
  if ([self transactionMode]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "transactionMode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}transactionMode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}transactionMode...");
#endif
    [[self transactionMode] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}transactionMode...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}transactionMode."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionPayNowRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest_M

/**
 *  Contains profile information.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest

/**
 * ID of a customer/account profile.
 */
- (NSString *) profileId
{
  return _profileId;
}

/**
 * ID of a customer/account profile.
 */
- (void) setProfileId: (NSString *) newProfileId
{
  [newProfileId retain];
  [_profileId release];
  _profileId = newProfileId;
}

/**
 * Profile name.
 */
- (NSString *) customerName
{
  return _customerName;
}

/**
 * Profile name.
 */
- (void) setCustomerName: (NSString *) newCustomerName
{
  [newCustomerName retain];
  [_customerName release];
  _customerName = newCustomerName;
}

/**
 * Company.
 */
- (NSString *) company
{
  return _company;
}

/**
 * Company.
 */
- (void) setCompany: (NSString *) newCompany
{
  [newCompany retain];
  [_company release];
  _company = newCompany;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

/**
 * Email preference, either "plaintext", "html" or "multipart".
 */
- (NSString *) emailPreference
{
  return _emailPreference;
}

/**
 * Email preference, either "plaintext", "html" or "multipart".
 */
- (void) setEmailPreference: (NSString *) newEmailPreference
{
  [newEmailPreference retain];
  [_emailPreference release];
  _emailPreference = newEmailPreference;
}

/**
 * Language preference, ISO 639-1 two-letter language code, e.g. de,en,.. .
 */
- (NSString *) languagePreference
{
  return _languagePreference;
}

/**
 * Language preference, ISO 639-1 two-letter language code, e.g. de,en,.. .
 */
- (void) setLanguagePreference: (NSString *) newLanguagePreference
{
  [newLanguagePreference retain];
  [_languagePreference release];
  _languagePreference = newLanguagePreference;
}

/**
 * ID of a payment profile.
 */
- (NSString *) emailAddress
{
  return _emailAddress;
}

/**
 * ID of a payment profile.
 */
- (void) setEmailAddress: (NSString *) newEmailAddress
{
  [newEmailAddress retain];
  [_emailAddress release];
  _emailAddress = newEmailAddress;
}

/**
 * The shipping address.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) shippingAddress
{
  return _shippingAddress;
}

/**
 * The shipping address.
 */
- (void) setShippingAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newShippingAddress
{
  [newShippingAddress retain];
  [_shippingAddress release];
  _shippingAddress = newShippingAddress;
}

- (void) dealloc
{
  [self setProfileId: nil];
  [self setCustomerName: nil];
  [self setCompany: nil];
  [self setCurrency: nil];
  [self setEmailPreference: nil];
  [self setLanguagePreference: nil];
  [self setEmailAddress: nil];
  [self setShippingAddress: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest from an XML reader. The element to be read is
 * "subscriptionProfileRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest *_cisSubscriptionProfileRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionProfileRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionProfileRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionProfileRequest.");
#endif
    _cisSubscriptionProfileRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionProfileRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest. Expected element subscriptionProfileRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest. Expected element subscriptionProfileRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionProfileRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest to XML under element name "subscriptionProfileRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionProfileRequest The CisSubscriptionProfileRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionProfileRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionProfileRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionProfileRequest for root element {}subscriptionProfileRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionProfileRequest for root element {}subscriptionProfileRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionProfileRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "profileId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}profileId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}profileId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setProfileId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "customerName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}customerName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}customerName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCustomerName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "company", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}company of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}company of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCompany: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "emailPreference", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}emailPreference of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}emailPreference of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setEmailPreference: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "languagePreference", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}languagePreference of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}languagePreference of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setLanguagePreference: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "emailAddress", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}emailAddress of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}emailAddress of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setEmailAddress: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "shippingAddress", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}shippingAddress of type {}cisAddress.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}shippingAddress of type {}cisAddress.");
#endif

    [self setShippingAddress: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self profileId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "profileId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}profileId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}profileId...");
#endif
    [[self profileId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}profileId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}profileId."];
    }
  }
  if ([self customerName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "customerName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}customerName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}customerName...");
#endif
    [[self customerName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}customerName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}customerName."];
    }
  }
  if ([self company]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "company", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}company."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}company...");
#endif
    [[self company] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}company...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}company."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
  if ([self emailPreference]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "emailPreference", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}emailPreference."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}emailPreference...");
#endif
    [[self emailPreference] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}emailPreference...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}emailPreference."];
    }
  }
  if ([self languagePreference]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "languagePreference", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}languagePreference."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}languagePreference...");
#endif
    [[self languagePreference] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}languagePreference...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}languagePreference."];
    }
  }
  if ([self emailAddress]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "emailAddress", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}emailAddress."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}emailAddress...");
#endif
    [[self emailAddress] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}emailAddress...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}emailAddress."];
    }
  }
  if ([self shippingAddress]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "shippingAddress", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}shippingAddress."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}shippingAddress...");
#endif
    [[self shippingAddress] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}shippingAddress...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}shippingAddress."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData_M

/**
 *  Retrieves subscription data from a Subscription Billing Provider.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData

/**
 * merchant ID of a customer account.
 */
- (NSString *) merchantAccountId
{
  return _merchantAccountId;
}

/**
 * merchant ID of a customer account.
 */
- (void) setMerchantAccountId: (NSString *) newMerchantAccountId
{
  [newMerchantAccountId retain];
  [_merchantAccountId release];
  _merchantAccountId = newMerchantAccountId;
}

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

/**
 * Merchant ID of a subscription.
 */
- (NSString *) subscriptionId
{
  return _subscriptionId;
}

/**
 * Merchant ID of a subscription.
 */
- (void) setSubscriptionId: (NSString *) newSubscriptionId
{
  [newSubscriptionId retain];
  [_subscriptionId release];
  _subscriptionId = newSubscriptionId;
}

/**
 * Merchant name of a subscription product.
 */
- (NSString *) subscriptionName
{
  return _subscriptionName;
}

/**
 * Merchant name of a subscription product.
 */
- (void) setSubscriptionName: (NSString *) newSubscriptionName
{
  [newSubscriptionName retain];
  [_subscriptionName release];
  _subscriptionName = newSubscriptionName;
}

/**
 * Merchant description of a subscription product.
 */
- (NSString *) subscriptionDescription
{
  return _subscriptionDescription;
}

/**
 * Merchant description of a subscription product.
 */
- (void) setSubscriptionDescription: (NSString *) newSubscriptionDescription
{
  [newSubscriptionDescription retain];
  [_subscriptionDescription release];
  _subscriptionDescription = newSubscriptionDescription;
}

/**
 * Merchant ID of a subscription product.
 */
- (NSString *) subscriptionProductId
{
  return _subscriptionProductId;
}

/**
 * Merchant ID of a subscription product.
 */
- (void) setSubscriptionProductId: (NSString *) newSubscriptionProductId
{
  [newSubscriptionProductId retain];
  [_subscriptionProductId release];
  _subscriptionProductId = newSubscriptionProductId;
}

/**
 * Merchant order number containing this subscription product.
 */
- (NSString *) subscriptionOrderId
{
  return _subscriptionOrderId;
}

/**
 * Merchant order number containing this subscription product.
 */
- (void) setSubscriptionOrderId: (NSString *) newSubscriptionOrderId
{
  [newSubscriptionOrderId retain];
  [_subscriptionOrderId release];
  _subscriptionOrderId = newSubscriptionOrderId;
}

/**
 * Merchant order entry number containing this subscription product.
 */
- (NSString *) subscriptionOrderEntryId
{
  return _subscriptionOrderEntryId;
}

/**
 * Merchant order entry number containing this subscription product.
 */
- (void) setSubscriptionOrderEntryId: (NSString *) newSubscriptionOrderEntryId
{
  [newSubscriptionOrderEntryId retain];
  [_subscriptionOrderEntryId release];
  _subscriptionOrderEntryId = newSubscriptionOrderEntryId;
}

/**
 * Billing system id.
 */
- (NSString *) billingSystemId
{
  return _billingSystemId;
}

/**
 * Billing system id.
 */
- (void) setBillingSystemId: (NSString *) newBillingSystemId
{
  [newBillingSystemId retain];
  [_billingSystemId release];
  _billingSystemId = newBillingSystemId;
}

/**
 * Start date of a subscription.
 */
- (NSDate *) subscriptionStartDate
{
  return _subscriptionStartDate;
}

/**
 * Start date of a subscription.
 */
- (void) setSubscriptionStartDate: (NSDate *) newSubscriptionStartDate
{
  [newSubscriptionStartDate retain];
  [_subscriptionStartDate release];
  _subscriptionStartDate = newSubscriptionStartDate;
}

/**
 * End date of a subscription.
 */
- (NSDate *) subscriptionEndDate
{
  return _subscriptionEndDate;
}

/**
 * End date of a subscription.
 */
- (void) setSubscriptionEndDate: (NSDate *) newSubscriptionEndDate
{
  [newSubscriptionEndDate retain];
  [_subscriptionEndDate release];
  _subscriptionEndDate = newSubscriptionEndDate;
}

/**
 * Status of a subscription.
 */
- (NSString *) subscriptionStatus
{
  return _subscriptionStatus;
}

/**
 * Status of a subscription.
 */
- (void) setSubscriptionStatus: (NSString *) newSubscriptionStatus
{
  [newSubscriptionStatus retain];
  [_subscriptionStatus release];
  _subscriptionStatus = newSubscriptionStatus;
}

/**
 * Determines if a subscription is cancellable.
 */
- (BOOL *) cancellationPossible
{
  return _cancellationPossible;
}

/**
 * Determines if a subscription is cancellable.
 */
- (void) setCancellationPossible: (BOOL *) newCancellationPossible
{
  if (_cancellationPossible != NULL) {
    free(_cancellationPossible);
  }
  _cancellationPossible = newCancellationPossible;
}

/**
 * Billing frequency.
 */
- (NSString *) billingFrequency
{
  return _billingFrequency;
}

/**
 * Billing frequency.
 */
- (void) setBillingFrequency: (NSString *) newBillingFrequency
{
  [newBillingFrequency retain];
  [_billingFrequency release];
  _billingFrequency = newBillingFrequency;
}

/**
 * Contract duration.
 */
- (NSString *) contractDuration
{
  return _contractDuration;
}

/**
 * Contract duration.
 */
- (void) setContractDuration: (NSString *) newContractDuration
{
  [newContractDuration retain];
  [_contractDuration release];
  _contractDuration = newContractDuration;
}

/**
 * When was the subscription order placed originally.
 */
- (NSDate *) orderDate
{
  return _orderDate;
}

/**
 * When was the subscription order placed originally.
 */
- (void) setOrderDate: (NSDate *) newOrderDate
{
  [newOrderDate retain];
  [_orderDate release];
  _orderDate = newOrderDate;
}

/**
 * When was the subscription order cancelled.
 */
- (NSDate *) cancelDate
{
  return _cancelDate;
}

/**
 * When was the subscription order cancelled.
 */
- (void) setCancelDate: (NSDate *) newCancelDate
{
  [newCancelDate retain];
  [_cancelDate release];
  _cancelDate = newCancelDate;
}

/**
 * Comments about the creation.
 */
- (NSString *) comments
{
  return _comments;
}

/**
 * Comments about the creation.
 */
- (void) setComments: (NSString *) newComments
{
  [newComments retain];
  [_comments release];
  _comments = newComments;
}

/**
 * Copy of the payment method of the corresponding account used by this subscription.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) paymentMethod
{
  return _paymentMethod;
}

/**
 * Copy of the payment method of the corresponding account used by this subscription.
 */
- (void) setPaymentMethod: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod *) newPaymentMethod
{
  [newPaymentMethod retain];
  [_paymentMethod release];
  _paymentMethod = newPaymentMethod;
}

/**
 * AutoRenewal flag of a subscription.
 */
- (BOOL *) autoRenewal
{
  return _autoRenewal;
}

/**
 * AutoRenewal flag of a subscription.
 */
- (void) setAutoRenewal: (BOOL *) newAutoRenewal
{
  if (_autoRenewal != NULL) {
    free(_autoRenewal);
  }
  _autoRenewal = newAutoRenewal;
}

- (void) dealloc
{
  [self setMerchantAccountId: nil];
  [self setCurrency: nil];
  [self setSubscriptionId: nil];
  [self setSubscriptionName: nil];
  [self setSubscriptionDescription: nil];
  [self setSubscriptionProductId: nil];
  [self setSubscriptionOrderId: nil];
  [self setSubscriptionOrderEntryId: nil];
  [self setBillingSystemId: nil];
  [self setSubscriptionStartDate: nil];
  [self setSubscriptionEndDate: nil];
  [self setSubscriptionStatus: nil];
  [self setCancellationPossible: NULL];
  [self setBillingFrequency: nil];
  [self setContractDuration: nil];
  [self setOrderDate: nil];
  [self setCancelDate: nil];
  [self setComments: nil];
  [self setPaymentMethod: nil];
  [self setAutoRenewal: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData from an XML reader. The element to be read is
 * "subscriptionData".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData *_cisSubscriptionData = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionData."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionData", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionData.");
#endif
    _cisSubscriptionData = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionData.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData. Expected element subscriptionData. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData. Expected element subscriptionData. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionData;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData to XML under element name "subscriptionData".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionData The CisSubscriptionData to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionData", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionData. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionData for root element {}subscriptionData...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionData for root element {}subscriptionData...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionData. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantAccountId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantAccountId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantAccountId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionName: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionDescription", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionDescription of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionDescription of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionDescription: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionProductId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionProductId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionProductId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionProductId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionOrderId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionOrderId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionOrderId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionOrderId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionOrderEntryId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionOrderEntryId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionOrderEntryId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionOrderEntryId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingSystemId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingSystemId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingSystemId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingSystemId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionStartDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionStartDate of type {http://www.w3.org/2001/XMLSchema}date.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionStartDate of type {http://www.w3.org/2001/XMLSchema}date.");
#endif

    [self setSubscriptionStartDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionEndDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionEndDate of type {http://www.w3.org/2001/XMLSchema}date.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionEndDate of type {http://www.w3.org/2001/XMLSchema}date.");
#endif

    [self setSubscriptionEndDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptionStatus", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptionStatus of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptionStatus of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSubscriptionStatus: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cancellationPossible", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setCancellationPossible: ((BOOL*) _child_accessor)];
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingFrequency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingFrequency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingFrequency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setBillingFrequency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "contractDuration", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}contractDuration of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}contractDuration of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setContractDuration: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "orderDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}orderDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}orderDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setOrderDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "cancelDate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}cancelDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif
    __child = [NSDate readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}cancelDate of type {http://www.w3.org/2001/XMLSchema}dateTime.");
#endif

    [self setCancelDate: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "comments", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}comments of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}comments of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setComments: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "paymentMethod", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}paymentMethod of type {}cisPaymentMethod.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}paymentMethod of type {}cisPaymentMethod.");
#endif

    [self setPaymentMethod: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "autoRenewal", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setAutoRenewal: ((BOOL*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantAccountId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantAccountId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantAccountId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantAccountId...");
#endif
    [[self merchantAccountId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantAccountId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantAccountId."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
  if ([self subscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionId...");
#endif
    [[self subscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionId."];
    }
  }
  if ([self subscriptionName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionName...");
#endif
    [[self subscriptionName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionName."];
    }
  }
  if ([self subscriptionDescription]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionDescription", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionDescription."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionDescription...");
#endif
    [[self subscriptionDescription] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionDescription...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionDescription."];
    }
  }
  if ([self subscriptionProductId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionProductId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionProductId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionProductId...");
#endif
    [[self subscriptionProductId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionProductId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionProductId."];
    }
  }
  if ([self subscriptionOrderId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionOrderId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionOrderId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionOrderId...");
#endif
    [[self subscriptionOrderId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionOrderId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionOrderId."];
    }
  }
  if ([self subscriptionOrderEntryId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionOrderEntryId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionOrderEntryId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionOrderEntryId...");
#endif
    [[self subscriptionOrderEntryId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionOrderEntryId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionOrderEntryId."];
    }
  }
  if ([self billingSystemId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingSystemId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingSystemId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingSystemId...");
#endif
    [[self billingSystemId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingSystemId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingSystemId."];
    }
  }
  if ([self subscriptionStartDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionStartDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionStartDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionStartDate...");
#endif
    [[self subscriptionStartDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionStartDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionStartDate."];
    }
  }
  if ([self subscriptionEndDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionEndDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionEndDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionEndDate...");
#endif
    [[self subscriptionEndDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionEndDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionEndDate."];
    }
  }
  if ([self subscriptionStatus]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionStatus", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}subscriptionStatus."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}subscriptionStatus...");
#endif
    [[self subscriptionStatus] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}subscriptionStatus...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}subscriptionStatus."];
    }
  }
  if ([self cancellationPossible] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cancellationPossible", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cancellationPossible."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cancellationPossible...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self cancellationPossible]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cancellationPossible...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}cancellationPossible."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cancellationPossible."];
    }
  }
  if ([self billingFrequency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingFrequency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingFrequency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingFrequency...");
#endif
    [[self billingFrequency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingFrequency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingFrequency."];
    }
  }
  if ([self contractDuration]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "contractDuration", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}contractDuration."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}contractDuration...");
#endif
    [[self contractDuration] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}contractDuration...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}contractDuration."];
    }
  }
  if ([self orderDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "orderDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}orderDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}orderDate...");
#endif
    [[self orderDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}orderDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}orderDate."];
    }
  }
  if ([self cancelDate]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "cancelDate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}cancelDate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}cancelDate...");
#endif
    [[self cancelDate] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}cancelDate...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}cancelDate."];
    }
  }
  if ([self comments]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "comments", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}comments."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}comments...");
#endif
    [[self comments] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}comments...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}comments."];
    }
  }
  if ([self paymentMethod]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethod", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}paymentMethod."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}paymentMethod...");
#endif
    [[self paymentMethod] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}paymentMethod...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}paymentMethod."];
    }
  }
  if ([self autoRenewal] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "autoRenewal", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}autoRenewal."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}autoRenewal...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self autoRenewal]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}autoRenewal...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}autoRenewal."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}autoRenewal."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest_M

/**
 *  Request for updating an existing payment method.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest

/**
 * The payment method to change.
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * The payment method to change.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

/**
 * Enable or disable the payment method.
 */
- (BOOL *) enabled
{
  return _enabled;
}

/**
 * Enable or disable the payment method.
 */
- (void) setEnabled: (BOOL *) newEnabled
{
  if (_enabled != NULL) {
    free(_enabled);
  }
  _enabled = newEnabled;
}

/**
 * Updated billing address.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) billingAddress
{
  return _billingAddress;
}

/**
 * Updated billing address.
 */
- (void) setBillingAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newBillingAddress
{
  [newBillingAddress retain];
  [_billingAddress release];
  _billingAddress = newBillingAddress;
}

/**
 * Indicates whether the updates should also be applied to subscriptions that use the payment method.
 */
- (BOOL *) propagate
{
  return _propagate;
}

/**
 * Indicates whether the updates should also be applied to subscriptions that use the payment method.
 */
- (void) setPropagate: (BOOL *) newPropagate
{
  if (_propagate != NULL) {
    free(_propagate);
  }
  _propagate = newPropagate;
}

- (void) dealloc
{
  [self setMerchantPaymentMethodId: nil];
  [self setEnabled: NULL];
  [self setBillingAddress: nil];
  [self setPropagate: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest from an XML reader. The element to be read is
 * "paymentMethodUpdateRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest *_cisPaymentMethodUpdateRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element paymentMethodUpdateRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "paymentMethodUpdateRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}paymentMethodUpdateRequest.");
#endif
    _cisPaymentMethodUpdateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}paymentMethodUpdateRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest. Expected element paymentMethodUpdateRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest. Expected element paymentMethodUpdateRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisPaymentMethodUpdateRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest to XML under element name "paymentMethodUpdateRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisPaymentMethodUpdateRequest The CisPaymentMethodUpdateRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethodUpdateRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}paymentMethodUpdateRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisPaymentMethodUpdateRequest for root element {}paymentMethodUpdateRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisPaymentMethodUpdateRequest for root element {}paymentMethodUpdateRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}paymentMethodUpdateRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "enabled", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setEnabled: ((BOOL*) _child_accessor)];
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "billingAddress", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}billingAddress of type {}cisAddress.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}billingAddress of type {}cisAddress.");
#endif

    [self setBillingAddress: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "propagate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setPropagate: ((BOOL*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
  if ([self enabled] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "enabled", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}enabled."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}enabled...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self enabled]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}enabled...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}enabled."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}enabled."];
    }
  }
  if ([self billingAddress]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "billingAddress", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}billingAddress."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}billingAddress...");
#endif
    [[self billingAddress] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}billingAddress...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}billingAddress."];
    }
  }
  if ([self propagate] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "propagate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}propagate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}propagate...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self propagate]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}propagate...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}propagate."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}propagate."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethodUpdateRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult_M

/**
 *  The result of a pass customer usage call.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult

- (void) dealloc
{
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult from an XML reader. The element to be read is
 * "customerUsage".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult *_cisCustomerUsageResult = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element customerUsage."];
    }
  }

  if (xmlStrcmp(BAD_CAST "customerUsage", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}customerUsage.");
#endif
    _cisCustomerUsageResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}customerUsage.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult. Expected element customerUsage. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult. Expected element customerUsage. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisCustomerUsageResult;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult to XML under element name "customerUsage".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisCustomerUsageResult The CisCustomerUsageResult to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "customerUsage", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}customerUsage. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisCustomerUsageResult for root element {}customerUsage...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisCustomerUsageResult for root element {}customerUsage...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}customerUsage. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisCustomerUsageResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult_M

/**
 *  Presents result of billing activity detail request.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult

/**
 * Byte stream for file downloading.
 */
- (NSData *) bytes
{
  return _bytes;
}

/**
 * Byte stream for file downloading.
 */
- (void) setBytes: (NSData *) newBytes
{
  [newBytes retain];
  [_bytes release];
  _bytes = newBytes;
}

/**
 * Describes content type.
 */
- (NSString *) mimeType
{
  return _mimeType;
}

/**
 * Describes content type.
 */
- (void) setMimeType: (NSString *) newMimeType
{
  [newMimeType retain];
  [_mimeType release];
  _mimeType = newMimeType;
}

/**
 * The file name.
 */
- (NSString *) fileName
{
  return _fileName;
}

/**
 * The file name.
 */
- (void) setFileName: (NSString *) newFileName
{
  [newFileName retain];
  [_fileName release];
  _fileName = newFileName;
}

- (void) dealloc
{
  [self setBytes: nil];
  [self setMimeType: nil];
  [self setFileName: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult from an XML reader. The element to be read is
 * "fileStream".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult *_cisFileStreamResult = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element fileStream."];
    }
  }

  if (xmlStrcmp(BAD_CAST "fileStream", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}fileStream.");
#endif
    _cisFileStreamResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}fileStream.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult. Expected element fileStream. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult. Expected element fileStream. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisFileStreamResult;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult to XML under element name "fileStream".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisFileStreamResult The CisFileStreamResult to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "fileStream", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}fileStream. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisFileStreamResult for root element {}fileStream...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisFileStreamResult for root element {}fileStream...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}fileStream. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "bytes", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}bytes of type {http://www.w3.org/2001/XMLSchema}base64Binary.");
#endif
    __child = [NSData readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}bytes of type {http://www.w3.org/2001/XMLSchema}base64Binary.");
#endif

    [self setBytes: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "mimeType", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}mimeType of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}mimeType of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMimeType: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "fileName", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}fileName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}fileName of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setFileName: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self bytes]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "bytes", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}bytes."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}bytes...");
#endif
    [[self bytes] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}bytes...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}bytes."];
    }
  }
  if ([self mimeType]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "mimeType", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}mimeType."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}mimeType...");
#endif
    [[self mimeType] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}mimeType...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}mimeType."];
    }
  }
  if ([self fileName]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "fileName", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}fileName."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}fileName...");
#endif
    [[self fileName] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}fileName...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}fileName."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisFileStreamResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest_M

/**
 *  A request for changing an existing payment method.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest

/**
 * The payment method to change.
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * The payment method to change.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

/**
 * The action to perform.
 */
- (NSString *) action
{
  return _action;
}

/**
 * The action to perform.
 */
- (void) setAction: (NSString *) newAction
{
  [newAction retain];
  [_action release];
  _action = newAction;
}

/**
 * New value to be provided.
 */
- (NSString *) newValue
{
  return _newValue;
}

/**
 * New value to be provided.
 */
- (void) setNewValue: (NSString *) newNewValue
{
  [newNewValue retain];
  [_newValue release];
  _newValue = newNewValue;
}

/**
 * Indicates if the changes should also be applied to subscriptions that use the payment method.
 */
- (BOOL) propagate
{
  return _propagate;
}

/**
 * Indicates if the changes should also be applied to subscriptions that use the payment method.
 */
- (void) setPropagate: (BOOL) newPropagate
{
  _propagate = newPropagate;
}

- (void) dealloc
{
  [self setMerchantPaymentMethodId: nil];
  [self setAction: nil];
  [self setNewValue: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest from an XML reader. The element to be read is
 * "subscriptionChangePaymentMethodRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest *_cisChangePaymentMethodRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionChangePaymentMethodRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionChangePaymentMethodRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionChangePaymentMethodRequest.");
#endif
    _cisChangePaymentMethodRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionChangePaymentMethodRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest. Expected element subscriptionChangePaymentMethodRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest. Expected element subscriptionChangePaymentMethodRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisChangePaymentMethodRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest to XML under element name "subscriptionChangePaymentMethodRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisChangePaymentMethodRequest The CisChangePaymentMethodRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionChangePaymentMethodRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionChangePaymentMethodRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisChangePaymentMethodRequest for root element {}subscriptionChangePaymentMethodRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisChangePaymentMethodRequest for root element {}subscriptionChangePaymentMethodRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionChangePaymentMethodRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "action", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}action of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}action of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setAction: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "newValue", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}newValue of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}newValue of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setNewValue: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "propagate", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setPropagate: *((BOOL*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
  if ([self action]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "action", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}action."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}action...");
#endif
    [[self action] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}action...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}action."];
    }
  }
  if ([self newValue]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "newValue", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}newValue."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}newValue...");
#endif
    [[self newValue] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}newValue...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}newValue."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "propagate", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}propagate."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}propagate...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, &_propagate);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}propagate...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}propagate."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}propagate."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisChangePaymentMethodRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest_M

/**
 * (no documentation provided)
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest

/**
 * (no documentation provided)
 */
- (NSString *) effectiveFrom
{
  return _effectiveFrom;
}

/**
 * (no documentation provided)
 */
- (void) setEffectiveFrom: (NSString *) newEffectiveFrom
{
  [newEffectiveFrom retain];
  [_effectiveFrom release];
  _effectiveFrom = newEffectiveFrom;
}

/**
 * (no documentation provided)
 */
- (NSString *) merchantSubscriptionId
{
  return _merchantSubscriptionId;
}

/**
 * (no documentation provided)
 */
- (void) setMerchantSubscriptionId: (NSString *) newMerchantSubscriptionId
{
  [newMerchantSubscriptionId retain];
  [_merchantSubscriptionId release];
  _merchantSubscriptionId = newMerchantSubscriptionId;
}

- (void) dealloc
{
  [self setEffectiveFrom: nil];
  [self setMerchantSubscriptionId: nil];
  [super dealloc];
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "effectiveFrom", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}effectiveFrom of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}effectiveFrom of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setEffectiveFrom: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantSubscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantSubscriptionId: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self effectiveFrom]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "effectiveFrom", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}effectiveFrom."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}effectiveFrom...");
#endif
    [[self effectiveFrom] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}effectiveFrom...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}effectiveFrom."];
    }
  }
  if ([self merchantSubscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantSubscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantSubscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantSubscriptionId...");
#endif
    [[self merchantSubscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantSubscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantSubscriptionId."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0AbstractCisSubscriptionUpdateRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest_M

/**
 *  Generic request type for subscription upgrades.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest

/**
 * (no documentation provided)
 */
- (NSString *) merchantSourceSubscriptionId
{
  return _merchantSourceSubscriptionId;
}

/**
 * (no documentation provided)
 */
- (void) setMerchantSourceSubscriptionId: (NSString *) newMerchantSourceSubscriptionId
{
  [newMerchantSourceSubscriptionId retain];
  [_merchantSourceSubscriptionId release];
  _merchantSourceSubscriptionId = newMerchantSourceSubscriptionId;
}

/**
 * (no documentation provided)
 */
- (NSString *) settlement
{
  return _settlement;
}

/**
 * (no documentation provided)
 */
- (void) setSettlement: (NSString *) newSettlement
{
  [newSettlement retain];
  [_settlement release];
  _settlement = newSettlement;
}

/**
 * Indicates when the upgrade will be effective.
 */
- (NSString *) effectiveFrom
{
  return _effectiveFrom;
}

/**
 * Indicates when the upgrade will be effective.
 */
- (void) setEffectiveFrom: (NSString *) newEffectiveFrom
{
  [newEffectiveFrom retain];
  [_effectiveFrom release];
  _effectiveFrom = newEffectiveFrom;
}

/**
 * Indicates whether it's preview upgrade call or real upgrade.
 */
- (BOOL) preview
{
  return _preview;
}

/**
 * Indicates whether it's preview upgrade call or real upgrade.
 */
- (void) setPreview: (BOOL) newPreview
{
  _preview = newPreview;
}

- (void) dealloc
{
  [self setMerchantSourceSubscriptionId: nil];
  [self setSettlement: nil];
  [self setEffectiveFrom: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest from an XML reader. The element to be read is
 * "subscriptionUpgradeRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest *_cisSubscriptionUpgradeRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionUpgradeRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionUpgradeRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionUpgradeRequest.");
#endif
    _cisSubscriptionUpgradeRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionUpgradeRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest. Expected element subscriptionUpgradeRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest. Expected element subscriptionUpgradeRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionUpgradeRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest to XML under element name "subscriptionUpgradeRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionUpgradeRequest The CisSubscriptionUpgradeRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionUpgradeRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionUpgradeRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionUpgradeRequest for root element {}subscriptionUpgradeRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionUpgradeRequest for root element {}subscriptionUpgradeRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionUpgradeRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "sourceSubscriptionId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}sourceSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}sourceSubscriptionId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantSourceSubscriptionId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "settlement", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}settlement of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}settlement of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setSettlement: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "effectiveFrom", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}effectiveFrom of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}effectiveFrom of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setEffectiveFrom: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "preview", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setPreview: *((BOOL*) _child_accessor)];
    free(_child_accessor);
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantSourceSubscriptionId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "sourceSubscriptionId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}sourceSubscriptionId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}sourceSubscriptionId...");
#endif
    [[self merchantSourceSubscriptionId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}sourceSubscriptionId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}sourceSubscriptionId."];
    }
  }
  if ([self settlement]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "settlement", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}settlement."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}settlement...");
#endif
    [[self settlement] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}settlement...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}settlement."];
    }
  }
  if ([self effectiveFrom]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "effectiveFrom", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}effectiveFrom."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}effectiveFrom...");
#endif
    [[self effectiveFrom] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}effectiveFrom...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}effectiveFrom."];
    }
  }
  if (YES) { //always write the primitive element...
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "preview", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}preview."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}preview...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, &_preview);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}preview...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}preview."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}preview."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult_M

/**
 *  The result of a subscription upgrade call.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult

/**
 * (no documentation provided)
 */
- (NSArray *) futureBillings
{
  return _futureBillings;
}

/**
 * (no documentation provided)
 */
- (void) setFutureBillings: (NSArray *) newFutureBillings
{
  [newFutureBillings retain];
  [_futureBillings release];
  _futureBillings = newFutureBillings;
}

- (void) dealloc
{
  [self setFutureBillings: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult from an XML reader. The element to be read is
 * "subscriptionUpgradeResult".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult *_cisSubscriptionUpgradeResult = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionUpgradeResult."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionUpgradeResult", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionUpgradeResult.");
#endif
    _cisSubscriptionUpgradeResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionUpgradeResult.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult. Expected element subscriptionUpgradeResult. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult. Expected element subscriptionUpgradeResult. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionUpgradeResult;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult to XML under element name "subscriptionUpgradeResult".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionUpgradeResult The CisSubscriptionUpgradeResult to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionUpgradeResult", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionUpgradeResult. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionUpgradeResult for root element {}subscriptionUpgradeResult...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionUpgradeResult for root element {}subscriptionUpgradeResult...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionUpgradeResult. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "futureBillings", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}futureBillings...");
#endif
      //start wrapper element "{}futureBillings"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "futureBillings", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}futureBillings of type {}cisSubscriptionBillingInfo.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionBillingInfo readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}futureBillings of type {}cisSubscriptionBillingInfo.");
#endif

    if ([self futureBillings]) {
      [self setFutureBillings: [[self futureBillings] arrayByAddingObject: __child]];
    }
    else {
      [self setFutureBillings: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}futureBillings...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setFutureBillings: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self futureBillings]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "futureBillings", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}futureBillings."];
    }
    __enumerator = [[self futureBillings] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "futureBillings", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}futureBillings."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}futureBillings...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}futureBillings...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}futureBillings."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}futureBillings."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpgradeResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest_M

/**
 *  Generic request type for subscription updates.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest

/**
 * The merchantPaymentMethodId.
 */
- (NSString *) merchantPaymentMethodId
{
  return _merchantPaymentMethodId;
}

/**
 * The merchantPaymentMethodId.
 */
- (void) setMerchantPaymentMethodId: (NSString *) newMerchantPaymentMethodId
{
  [newMerchantPaymentMethodId retain];
  [_merchantPaymentMethodId release];
  _merchantPaymentMethodId = newMerchantPaymentMethodId;
}

/**
 * (no documentation provided)
 */
- (BOOL *) autoRenewal
{
  return _autoRenewal;
}

/**
 * (no documentation provided)
 */
- (void) setAutoRenewal: (BOOL *) newAutoRenewal
{
  if (_autoRenewal != NULL) {
    free(_autoRenewal);
  }
  _autoRenewal = newAutoRenewal;
}

/**
 * (no documentation provided)
 */
- (int *) contractDurationExtension
{
  return _contractDurationExtension;
}

/**
 * (no documentation provided)
 */
- (void) setContractDurationExtension: (int *) newContractDurationExtension
{
  if (_contractDurationExtension != NULL) {
    free(_contractDurationExtension);
  }
  _contractDurationExtension = newContractDurationExtension;
}

- (void) dealloc
{
  [self setMerchantPaymentMethodId: nil];
  [self setAutoRenewal: NULL];
  [self setContractDurationExtension: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest from an XML reader. The element to be read is
 * "subscriptionUpdateRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest *_cisSubscriptionUpdateRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionUpdateRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionUpdateRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionUpdateRequest.");
#endif
    _cisSubscriptionUpdateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionUpdateRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest. Expected element subscriptionUpdateRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest. Expected element subscriptionUpdateRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionUpdateRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest to XML under element name "subscriptionUpdateRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionUpdateRequest The CisSubscriptionUpdateRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionUpdateRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionUpdateRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionUpdateRequest for root element {}subscriptionUpdateRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionUpdateRequest for root element {}subscriptionUpdateRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionUpdateRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "merchantPaymentMethodId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}merchantPaymentMethodId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setMerchantPaymentMethodId: __child];
    return YES;
  } //end "if choice"


  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "autoRenewal", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadBooleanType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setAutoRenewal: ((BOOL*) _child_accessor)];
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "contractDurationExtension", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadIntType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setContractDurationExtension: ((int*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self merchantPaymentMethodId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "merchantPaymentMethodId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}merchantPaymentMethodId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}merchantPaymentMethodId...");
#endif
    [[self merchantPaymentMethodId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}merchantPaymentMethodId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}merchantPaymentMethodId."];
    }
  }
  if ([self autoRenewal] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "autoRenewal", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}autoRenewal."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}autoRenewal...");
#endif
    status = xmlTextWriterWriteBooleanType(writer, [self autoRenewal]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}autoRenewal...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}autoRenewal."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}autoRenewal."];
    }
  }
  if ([self contractDurationExtension] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "contractDurationExtension", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}contractDurationExtension."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}contractDurationExtension...");
#endif
    status = xmlTextWriterWriteIntType(writer, [self contractDurationExtension]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}contractDurationExtension...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}contractDurationExtension."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}contractDurationExtension."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionUpdateRequest_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult_M

/**
 *  Retrieves customer profile info from a Subscription Billing Provider.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult

/**
 * ID of a payment profile.
 */
- (NSString *) profileId
{
  return _profileId;
}

/**
 * ID of a payment profile.
 */
- (void) setProfileId: (NSString *) newProfileId
{
  [newProfileId retain];
  [_profileId release];
  _profileId = newProfileId;
}

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (NSString *) currency
{
  return _currency;
}

/**
 * 3 letter ISO 4217 currency code. Default currency for this profile.
 */
- (void) setCurrency: (NSString *) newCurrency
{
  [newCurrency retain];
  [_currency release];
  _currency = newCurrency;
}

/**
 * Result of either a profile check or of a set up fee capture used to validate the credit card.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *) validationResult
{
  return _validationResult;
}

/**
 * Result of either a profile check or of a set up fee capture used to validate the credit card.
 */
- (void) setValidationResult: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult *) newValidationResult
{
  [newValidationResult retain];
  [_validationResult release];
  _validationResult = newValidationResult;
}

/**
 * List of payment methods.
 */
- (NSArray *) paymentMethods
{
  return _paymentMethods;
}

/**
 * List of payment methods.
 */
- (void) setPaymentMethods: (NSArray *) newPaymentMethods
{
  [newPaymentMethods retain];
  [_paymentMethods release];
  _paymentMethods = newPaymentMethods;
}

/**
 * Placeholder to contain list of subscriptions.
 */
- (NSArray *) subscriptions
{
  return _subscriptions;
}

/**
 * Placeholder to contain list of subscriptions.
 */
- (void) setSubscriptions: (NSArray *) newSubscriptions
{
  [newSubscriptions retain];
  [_subscriptions release];
  _subscriptions = newSubscriptions;
}

/**
 * Customer information.
 */
- (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) customerAddress
{
  return _customerAddress;
}

/**
 * Customer information.
 */
- (void) setCustomerAddress: (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress *) newCustomerAddress
{
  [newCustomerAddress retain];
  [_customerAddress release];
  _customerAddress = newCustomerAddress;
}

/**
 * Comments about the creation.
 */
- (NSString *) comments
{
  return _comments;
}

/**
 * Comments about the creation.
 */
- (void) setComments: (NSString *) newComments
{
  [newComments retain];
  [_comments release];
  _comments = newComments;
}

- (void) dealloc
{
  [self setProfileId: nil];
  [self setCurrency: nil];
  [self setValidationResult: nil];
  [self setPaymentMethods: nil];
  [self setSubscriptions: nil];
  [self setCustomerAddress: nil];
  [self setComments: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult from an XML reader. The element to be read is
 * "subscriptionProfileResult".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult *_cisSubscriptionProfileResult = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionProfileResult."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionProfileResult", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionProfileResult.");
#endif
    _cisSubscriptionProfileResult = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionProfileResult.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult. Expected element subscriptionProfileResult. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult. Expected element subscriptionProfileResult. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionProfileResult;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult to XML under element name "subscriptionProfileResult".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionProfileResult The CisSubscriptionProfileResult to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionProfileResult", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionProfileResult. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionProfileResult for root element {}subscriptionProfileResult...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionProfileResult for root element {}subscriptionProfileResult...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionProfileResult. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "profileId", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}profileId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}profileId of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setProfileId: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "currency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}currency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setCurrency: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "validationResult", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}validationResult of type {}cisSubscriptionTransactionResult.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionTransactionResult readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}validationResult of type {}cisSubscriptionTransactionResult.");
#endif

    [self setValidationResult: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "paymentMethods", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}paymentMethods...");
#endif
      //start wrapper element "{}paymentMethods"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "paymentMethod", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}paymentMethod of type {}cisPaymentMethod.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisPaymentMethod readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}paymentMethod of type {}cisPaymentMethod.");
#endif

    if ([self paymentMethods]) {
      [self setPaymentMethods: [[self paymentMethods] arrayByAddingObject: __child]];
    }
    else {
      [self setPaymentMethods: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}paymentMethods...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setPaymentMethods: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptions", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    if (xmlTextReaderIsEmptyElement(reader) == 0) {
#if DEBUG_ENUNCIATE > 1
      NSLog(@"Unwrapping wrapper element {}subscriptions...");
#endif
      //start wrapper element "{}subscriptions"
      depth = xmlTextReaderDepth(reader);
      status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      while (xmlTextReaderDepth(reader) > depth) {
        if (status < 1) {
          //panic: XML read error.
          [NSException raise: @"XMLReadError"
                       format: @"Failure to advance to next wrapped child element."];
        }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "subscriptions", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}subscriptions of type {}cisSubscriptionData.");
#endif

    if(xmlTextReaderIsEmptyElement(reader) != 0){
      __child = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData alloc] init];
      xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    }else{
      __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionData readXMLType: reader];
    }
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}subscriptions of type {}cisSubscriptionData.");
#endif

    if ([self subscriptions]) {
      [self setSubscriptions: [[self subscriptions] arrayByAddingObject: __child]];
    }
    else {
      [self setSubscriptions: [NSArray arrayWithObject: __child]];
    }
    continue; //continue "while in wrapper element" loop
  } //end "if choice"

        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
#if DEBUG_ENUNCIATE > 1
        NSLog(@"successfully unwrapped wrapper element {}subscriptions...");
#endif
      } // end "while in wrapper element" loop

      if (status < 1) {
        //panic: XML read error.
        [NSException raise: @"XMLReadError"
                     format: @"Failure to advance to end wrapper element."];
      }
    } //end "if empty element" clause
    else {
      __child = [NSArray array];
      [self setSubscriptions: (NSArray*) __child];
    }

    return YES;
  } // end "if wrapper element" clause
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "customerAddress", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}customerAddress of type {}cisAddress.");
#endif
    __child = [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisAddress readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}customerAddress of type {}cisAddress.");
#endif

    [self setCustomerAddress: __child];
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "comments", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}comments of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}comments of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setComments: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self profileId]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "profileId", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}profileId."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}profileId...");
#endif
    [[self profileId] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}profileId...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}profileId."];
    }
  }
  if ([self currency]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "currency", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}currency."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}currency...");
#endif
    [[self currency] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}currency...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}currency."];
    }
  }
  if ([self validationResult]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "validationResult", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}validationResult."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}validationResult...");
#endif
    [[self validationResult] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}validationResult...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}validationResult."];
    }
  }
  if ([self paymentMethods]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethods", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}paymentMethods."];
    }
    __enumerator = [[self paymentMethods] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "paymentMethod", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}paymentMethod."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}paymentMethod...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}paymentMethod...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}paymentMethod."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}paymentMethods."];
    }
  }
  if ([self subscriptions]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptions", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start wrapper element {}subscriptions."];
    }
    __enumerator = [[self subscriptions] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptions", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}subscriptions."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}subscriptions...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}subscriptions...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}subscriptions."];
      }
    } //end item iterator.

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end wrapper element {}subscriptions."];
    }
  }
  if ([self customerAddress]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "customerAddress", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}customerAddress."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}customerAddress...");
#endif
    [[self customerAddress] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}customerAddress...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}customerAddress."];
    }
  }
  if ([self comments]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "comments", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}comments."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}comments...");
#endif
    [[self comments] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}comments...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}comments."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionProfileResult_M */
#ifndef DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest_M
#define DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest_M

/**
 *  Generic request type for subscription state changes.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest

/**
 * (no documentation provided)
 */
- (NSString *) newState
{
  return _newState;
}

/**
 * (no documentation provided)
 */
- (void) setNewState: (NSString *) newNewState
{
  [newNewState retain];
  [_newState release];
  _newState = newNewState;
}

- (void) dealloc
{
  [self setNewState: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest *) [HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest (JAXB)

/**
 * Read an instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest *_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest = [[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest alloc] init];
  NS_DURING
  {
    [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest autorelease];
  return _hYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest;
}

/**
 * Initialize this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest from an XML reader. The element to be read is
 * "subscriptionChangeStateRequest".
 *
 * @param reader The XML reader.
 * @return The HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest *_cisSubscriptionChangeStateRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element subscriptionChangeStateRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "subscriptionChangeStateRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}subscriptionChangeStateRequest.");
#endif
    _cisSubscriptionChangeStateRequest = (HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest *)[HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}subscriptionChangeStateRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest. Expected element subscriptionChangeStateRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest. Expected element subscriptionChangeStateRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _cisSubscriptionChangeStateRequest;
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest to XML under element name "subscriptionChangeStateRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _cisSubscriptionChangeStateRequest The CisSubscriptionChangeStateRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "subscriptionChangeStateRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}subscriptionChangeStateRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}cisSubscriptionChangeStateRequest for root element {}subscriptionChangeStateRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}cisSubscriptionChangeStateRequest for root element {}subscriptionChangeStateRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}subscriptionChangeStateRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "newState", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}newState of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}newState of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setNewState: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self newState]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "newState", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}newState."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}newState...");
#endif
    [[self newState] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}newState...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}newState."];
    }
  }
}
@end /* implementation HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest (JAXB) */

#endif /* DEF_HYBRIS_CIS_MOCK_SUBSCRIPTION_WEBNS0CisSubscriptionChangeStateRequest_M */
