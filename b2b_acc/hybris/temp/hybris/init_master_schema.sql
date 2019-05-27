
CREATE CACHED TABLE abstractcontact26sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_26Sn ON abstractcontact26sn (ITEMPK);


CREATE CACHED TABLE abstractcontactinfo
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_userpos INTEGER,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_phonenumber NVARCHAR(255),
    p_type BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX userRelIDX_26 ON abstractcontactinfo (p_user);

CREATE INDEX userposPosIDX_26 ON abstractcontactinfo (p_userpos);


CREATE CACHED TABLE abstrcfgproduct131sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_131Sn ON abstrcfgproduct131sn (ITEMPK);


CREATE CACHED TABLE abstrcfgproductinfo
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_productinfostatus BIGINT,
    p_configuratortype BIGINT,
    p_orderentrypos INTEGER,
    p_orderentry BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_configurationlabel NVARCHAR(255),
    p_configurationvalue NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX orderentryRelIDX_131 ON abstrcfgproductinfo (p_orderentry);

CREATE INDEX orderentryposPosIDX_131 ON abstrcfgproductinfo (p_orderentrypos);


CREATE CACHED TABLE aclentries
(
    hjmpTS BIGINT,
    PermissionPK BIGINT NOT NULL,
    Negative TINYINT DEFAULT 0,
    PrincipalPK BIGINT NOT NULL,
    ItemPK BIGINT NOT NULL,
    PRIMARY KEY (PermissionPK, PrincipalPK, ItemPK)
);

CREATE INDEX aclupdateindex_aclentries ON aclentries (ItemPK);

CREATE INDEX aclcheckindex_aclentries ON aclentries (ItemPK, PrincipalPK);


CREATE CACHED TABLE actions4comps
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6226 ON actions4comps (SourcePK);

CREATE INDEX qualifier_6226 ON actions4comps (Qualifier);

CREATE INDEX rseqnr_6226 ON actions4comps (RSequenceNumber);

CREATE INDEX linktarget_6226 ON actions4comps (TargetPK);

CREATE INDEX seqnr_6226 ON actions4comps (SequenceNumber);


CREATE CACHED TABLE actions4comps6226sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6226Sn ON actions4comps6226sn (ITEMPK);

CREATE INDEX IdxsourcePK_6226Sn ON actions4comps6226sn (sourcePK);

CREATE INDEX IdxtargetPK_6226Sn ON actions4comps6226sn (targetPK);

CREATE INDEX IdxlanguagePK_6226Sn ON actions4comps6226sn (languagePK);


CREATE CACHED TABLE addresses
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_original BIGINT,
    p_duplicate TINYINT,
    p_appartment NVARCHAR(255),
    p_building NVARCHAR(255),
    p_cellphone NVARCHAR(255),
    p_company NVARCHAR(255),
    p_country BIGINT,
    p_department NVARCHAR(255),
    p_district NVARCHAR(255),
    p_email NVARCHAR(255),
    p_fax NVARCHAR(255),
    p_firstname NVARCHAR(255),
    p_lastname NVARCHAR(255),
    p_middlename NVARCHAR(255),
    p_middlename2 NVARCHAR(255),
    p_phone1 NVARCHAR(255),
    p_phone2 NVARCHAR(255),
    p_pobox NVARCHAR(255),
    p_postalcode NVARCHAR(255),
    p_region BIGINT,
    p_streetname NVARCHAR(255),
    p_streetnumber NVARCHAR(255),
    p_title BIGINT,
    p_town NVARCHAR(255),
    p_gender BIGINT,
    p_dateofbirth TIMESTAMP,
    p_remarks NVARCHAR(255),
    p_url NVARCHAR(255),
    p_shippingaddress TINYINT,
    p_unloadingaddress TINYINT,
    p_billingaddress TINYINT,
    p_contactaddress TINYINT,
    p_visibleinaddressbook TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX testindex_23 ON addresses (p_email);

CREATE INDEX Address_Owner_23 ON addresses (OwnerPkString);


CREATE CACHED TABLE addresses23sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_23Sn ON addresses23sn (ITEMPK);


CREATE CACHED TABLE addressprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX nameidx_addressprops ON addressprops (NAME);

CREATE INDEX realnameidx_addressprops ON addressprops (REALNAME);

CREATE INDEX itempk_addressprops ON addressprops (ITEMPK);


CREATE CACHED TABLE agent2basestore
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_9006 ON agent2basestore (SourcePK);

CREATE INDEX qualifier_9006 ON agent2basestore (Qualifier);

CREATE INDEX rseqnr_9006 ON agent2basestore (RSequenceNumber);

CREATE INDEX linktarget_9006 ON agent2basestore (TargetPK);

CREATE INDEX seqnr_9006 ON agent2basestore (SequenceNumber);


CREATE CACHED TABLE agent2basestore9006sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9006Sn ON agent2basestore9006sn (ITEMPK);

CREATE INDEX IdxsourcePK_9006Sn ON agent2basestore9006sn (sourcePK);

CREATE INDEX IdxtargetPK_9006Sn ON agent2basestore9006sn (targetPK);

CREATE INDEX IdxlanguagePK_9006Sn ON agent2basestore9006sn (languagePK);


CREATE CACHED TABLE agreements
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_catalog BIGINT,
    p_buyer BIGINT,
    p_supplier BIGINT,
    p_buyercontact BIGINT,
    p_suppliercontact BIGINT,
    p_currency BIGINT,
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX catalogversionRelIDX_603 ON agreements (p_catalogversion);


CREATE CACHED TABLE agreements603sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_603Sn ON agreements603sn (ITEMPK);


CREATE CACHED TABLE applactntyp4com6227sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6227Sn ON applactntyp4com6227sn (ITEMPK);

CREATE INDEX IdxsourcePK_6227Sn ON applactntyp4com6227sn (sourcePK);

CREATE INDEX IdxtargetPK_6227Sn ON applactntyp4com6227sn (targetPK);

CREATE INDEX IdxlanguagePK_6227Sn ON applactntyp4com6227sn (languagePK);


CREATE CACHED TABLE applactntyp4comptyp
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6227 ON applactntyp4comptyp (SourcePK);

CREATE INDEX qualifier_6227 ON applactntyp4comptyp (Qualifier);

CREATE INDEX rseqnr_6227 ON applactntyp4comptyp (RSequenceNumber);

CREATE INDEX linktarget_6227 ON applactntyp4comptyp (TargetPK);

CREATE INDEX seqnr_6227 ON applactntyp4comptyp (SequenceNumber);


CREATE CACHED TABLE applrestrtyp4pg1099sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1099Sn ON applrestrtyp4pg1099sn (ITEMPK);

CREATE INDEX IdxsourcePK_1099Sn ON applrestrtyp4pg1099sn (sourcePK);

CREATE INDEX IdxtargetPK_1099Sn ON applrestrtyp4pg1099sn (targetPK);

CREATE INDEX IdxlanguagePK_1099Sn ON applrestrtyp4pg1099sn (languagePK);


CREATE CACHED TABLE applrestrtyp4pgtyp
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1099 ON applrestrtyp4pgtyp (SourcePK);

CREATE INDEX qualifier_1099 ON applrestrtyp4pgtyp (Qualifier);

CREATE INDEX rseqnr_1099 ON applrestrtyp4pgtyp (RSequenceNumber);

CREATE INDEX linktarget_1099 ON applrestrtyp4pgtyp (TargetPK);

CREATE INDEX seqnr_1099 ON applrestrtyp4pgtyp (SequenceNumber);


CREATE CACHED TABLE asboostitemconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    p_item BIGINT,
    p_uniqueidx NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_searchconfigurationpos INTEGER,
    p_searchconfiguration BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2243 ON asboostitemconf (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2243 ON asboostitemconf (p_catalogversion, p_uid);

CREATE UNIQUE INDEX uniqueIdx_2243 ON asboostitemconf (p_catalogversion, p_uniqueidx);

CREATE INDEX searchconfigurationRelIDX_2243 ON asboostitemconf (p_searchconfiguration);

CREATE INDEX searchconfigurationposPosIDX_2243 ON asboostitemconf (p_searchconfigurationpos);


CREATE CACHED TABLE asboostitemconf2243sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2243Sn ON asboostitemconf2243sn (ITEMPK);


CREATE CACHED TABLE asboostruleconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_indexproperty NVARCHAR(255),
    p_operator BIGINT,
    p_value NVARCHAR(255),
    p_boosttype BIGINT,
    p_boost FLOAT,
    p_searchconfigurationpos INTEGER,
    p_searchconfiguration BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2244 ON asboostruleconf (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2244 ON asboostruleconf (p_catalogversion, p_uid);

CREATE INDEX searchconfigurationRelIDX_2244 ON asboostruleconf (p_searchconfiguration);

CREATE INDEX searchconfigurationposPosIDX_2244 ON asboostruleconf (p_searchconfigurationpos);


CREATE CACHED TABLE asboostruleconf2244sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2244Sn ON asboostruleconf2244sn (ITEMPK);


CREATE CACHED TABLE asfacetconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    p_indexproperty NVARCHAR(255),
    p_facettype BIGINT,
    p_priority INTEGER,
    p_valuessortprovider NVARCHAR(255),
    p_valuesdisplaynameprovider NVARCHAR(255),
    p_topvaluesprovider NVARCHAR(255),
    p_uniqueidx NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_searchconfigurationpos INTEGER,
    p_searchconfiguration BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2242 ON asfacetconf (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2242 ON asfacetconf (p_catalogversion, p_uid);

CREATE UNIQUE INDEX uniqueIdx_2242 ON asfacetconf (p_catalogversion, p_uniqueidx);

CREATE INDEX searchconfigurationRelIDX_2242 ON asfacetconf (p_searchconfiguration);

CREATE INDEX searchconfigurationposPosIDX_2242 ON asfacetconf (p_searchconfigurationpos);


CREATE CACHED TABLE asfacetconf2242sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2242Sn ON asfacetconf2242sn (ITEMPK);


CREATE CACHED TABLE asfacetvaluecon2247sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2247Sn ON asfacetvaluecon2247sn (ITEMPK);


CREATE CACHED TABLE asfacetvalueconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    p_value NVARCHAR(255),
    p_uniqueidx NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_facetconfigurationpos INTEGER,
    p_facetconfiguration BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2247 ON asfacetvalueconf (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2247 ON asfacetvalueconf (p_catalogversion, p_uid);

CREATE UNIQUE INDEX uniqueIdx_2247 ON asfacetvalueconf (p_catalogversion, p_uniqueidx);

CREATE INDEX facetconfigurationRelIDX_2247 ON asfacetvalueconf (p_facetconfiguration);

CREATE INDEX facetconfigurationposPosIDX_2247 ON asfacetvalueconf (p_facetconfigurationpos);


CREATE CACHED TABLE assearchconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    p_uniqueidx NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_facetsmergemode BIGINT,
    p_boostitemsmergemode BIGINT,
    p_boostrulesmergemode BIGINT,
    p_sortsmergemode BIGINT,
    p_searchprofile BIGINT,
    p_category BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2241 ON assearchconf (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2241 ON assearchconf (p_catalogversion, p_uid);

CREATE UNIQUE INDEX uniqueIdx_2241 ON assearchconf (p_catalogversion, p_uniqueidx);

CREATE INDEX searchprofileRelIDX_2241 ON assearchconf (p_searchprofile);


CREATE CACHED TABLE assearchconf2241sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2241Sn ON assearchconf2241sn (ITEMPK);


CREATE CACHED TABLE assearchprof
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_code NVARCHAR(255),
    p_indextype NVARCHAR(255),
    p_activationsetpos INTEGER,
    p_activationset BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2240 ON assearchprof (p_catalogversion);

CREATE UNIQUE INDEX codeIdx_2240 ON assearchprof (p_catalogversion, p_code);

CREATE INDEX activationsetRelIDX_2240 ON assearchprof (p_activationset);

CREATE INDEX activationsetposPosIDX_2240 ON assearchprof (p_activationsetpos);


CREATE CACHED TABLE assearchprof2240sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2240Sn ON assearchprof2240sn (ITEMPK);


CREATE CACHED TABLE assearchprofact2246sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2246Sn ON assearchprofact2246sn (ITEMPK);


CREATE CACHED TABLE assearchprofactivset
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_indextype NVARCHAR(255),
    p_priority INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2246 ON assearchprofactivset (p_catalogversion);

CREATE UNIQUE INDEX uniqueIdx_2246 ON assearchprofactivset (p_catalogversion, p_indextype);


CREATE CACHED TABLE assearchproflp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE assortconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    p_code NVARCHAR(255),
    p_priority INTEGER,
    p_applypromoteditems TINYINT,
    p_highlightpromoteditems TINYINT,
    p_uniqueidx NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_searchconfigurationpos INTEGER,
    p_searchconfiguration BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2248 ON assortconf (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2248 ON assortconf (p_catalogversion, p_uid);

CREATE UNIQUE INDEX uniqueIdx_2248 ON assortconf (p_catalogversion, p_uniqueidx);

CREATE INDEX searchconfigurationRelIDX_2248 ON assortconf (p_searchconfiguration);

CREATE INDEX searchconfigurationposPosIDX_2248 ON assortconf (p_searchconfigurationpos);


CREATE CACHED TABLE assortconf2248sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2248Sn ON assortconf2248sn (ITEMPK);


CREATE CACHED TABLE assortconflp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE assortexpr
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_uid NVARCHAR(255),
    p_expression NVARCHAR(255),
    p_order BIGINT,
    p_uniqueidx NVARCHAR(255),
    p_sortconfigurationpos INTEGER,
    p_sortconfiguration BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_2249 ON assortexpr (p_catalogversion);

CREATE UNIQUE INDEX uidIdx_2249 ON assortexpr (p_catalogversion, p_uid);

CREATE UNIQUE INDEX uniqueIdx_2249 ON assortexpr (p_catalogversion, p_uniqueidx);

CREATE INDEX sortconfigurationRelIDX_2249 ON assortexpr (p_sortconfiguration);

CREATE INDEX sortconfigurationposPosIDX_2249 ON assortexpr (p_sortconfigurationpos);


CREATE CACHED TABLE assortexpr2249sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2249Sn ON assortexpr2249sn (ITEMPK);


CREATE CACHED TABLE atomictypes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_extensionname NVARCHAR(255),
    p_autocreate TINYINT,
    p_generate TINYINT,
    InternalCode NVARCHAR(255),
    p_defaultvalue LONGVARBINARY,
    InheritancePathString LONGVARCHAR,
    JavaClassName NVARCHAR(255),
    SuperTypePK BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    InternalCodeLowerCase NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX inheritpsi_81 ON atomictypes (InheritancePathString);

CREATE INDEX typecode_81 ON atomictypes (InternalCode);

CREATE INDEX typecodelowercase_81 ON atomictypes (InternalCodeLowerCase);


CREATE CACHED TABLE atomictypes81sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_81Sn ON atomictypes81sn (ITEMPK);


CREATE CACHED TABLE atomictypeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE attr2valuerel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_value BIGINT,
    p_attributeassignment BIGINT,
    p_attribute BIGINT,
    p_systemversion BIGINT,
    p_position INTEGER,
    p_externalid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX sysVer_609 ON attr2valuerel (p_systemversion);

CREATE INDEX catRelIDX_609 ON attr2valuerel (p_attributeassignment);

CREATE INDEX idIDX_609 ON attr2valuerel (p_externalid);

CREATE INDEX valIDX_609 ON attr2valuerel (p_value);

CREATE INDEX attrIDX_609 ON attr2valuerel (p_attribute);


CREATE CACHED TABLE attr2valuerel609sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_609Sn ON attr2valuerel609sn (ITEMPK);


CREATE CACHED TABLE attributedescri87sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_87Sn ON attributedescri87sn (ITEMPK);


CREATE CACHED TABLE attributedescriptors
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_extensionname NVARCHAR(255),
    p_autocreate TINYINT,
    p_generate TINYINT,
    QualifierInternal NVARCHAR(255),
    AttributeTypePK BIGINT,
    columnName NVARCHAR(255),
    p_defaultvalue LONGVARBINARY,
    p_defaultvaluedefinitionstring NVARCHAR(255),
    EnclosingTypePK BIGINT,
    PersistenceQualifierInternal NVARCHAR(255),
    PersistenceTypePK BIGINT,
    p_attributehandler NVARCHAR(255),
    SelectionDescriptorPK BIGINT,
    modifiers INTEGER DEFAULT 0,
    p_unique TINYINT,
    p_hiddenforui TINYINT,
    p_readonlyforui TINYINT,
    p_dontcopy TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    QualifierLowerCaseInternal NVARCHAR(255),
    isHidden TINYINT DEFAULT 0,
    isProperty TINYINT DEFAULT 0,
    SuperAttributeDescriptorPK BIGINT,
    InheritancePathString LONGVARCHAR,
    p_externalqualifier NVARCHAR(255),
    p_storeindatabase TINYINT,
    p_needrestart TINYINT,
    p_param TINYINT,
    p_position INTEGER,
    p_defaultvalueexpression NVARCHAR(255),
    p_issource TINYINT,
    p_ordered TINYINT,
    p_relationname NVARCHAR(255),
    p_relationtype BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX inheritps_87 ON attributedescriptors (InheritancePathString);

CREATE INDEX enclosing_87 ON attributedescriptors (EnclosingTypePK);

CREATE INDEX lcqualifier_87 ON attributedescriptors (QualifierLowerCaseInternal);

CREATE UNIQUE INDEX qualifier_87 ON attributedescriptors (QualifierInternal, EnclosingTypePK);


CREATE CACHED TABLE attributedescriptorslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bbookinglinee10005sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10005Sn ON b2bbookinglinee10005sn (ITEMPK);


CREATE CACHED TABLE b2bbookinglineentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_bookingstatus BIGINT,
    p_costcenter BIGINT,
    p_amount DECIMAL(30,8),
    p_currency BIGINT,
    p_product NVARCHAR(255),
    p_quantity BIGINT,
    p_orderid NVARCHAR(255),
    p_orderentrynr INTEGER,
    p_orderentry BIGINT,
    p_bookingdate TIMESTAMP,
    p_bookingtype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX bookingDateIdx_10005 ON b2bbookinglineentry (p_bookingdate);

CREATE INDEX bookingStatusIdx_10005 ON b2bbookinglineentry (p_bookingstatus);

CREATE INDEX costCtrIdx_10005 ON b2bbookinglineentry (p_costcenter);

CREATE INDEX currencyIdx_10005 ON b2bbookinglineentry (p_currency);


CREATE CACHED TABLE b2bbudgets
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_budget DECIMAL(30,8),
    p_currency BIGINT,
    p_daterange LONGVARBINARY,
    p_active TINYINT,
    p_unit BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX unitRelIDX_10001 ON b2bbudgets (p_unit);


CREATE CACHED TABLE b2bbudgets10001sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10001Sn ON b2bbudgets10001sn (ITEMPK);


CREATE CACHED TABLE b2bbudgetslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bcomment
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_comment NVARCHAR(255),
    p_modifieddate TIMESTAMP,
    p_order BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderRelIDX_10035 ON b2bcomment (p_order);


CREATE CACHED TABLE b2bcomment10035sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10035Sn ON b2bcomment10035sn (ITEMPK);


CREATE CACHED TABLE b2bcostcenters
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_currency BIGINT,
    p_active TINYINT,
    p_unit BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX unitRelIDX_10002 ON b2bcostcenters (p_unit);


CREATE CACHED TABLE b2bcostcenters10002sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10002Sn ON b2bcostcenters10002sn (ITEMPK);


CREATE CACHED TABLE b2bcostcenterslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bcreditcheckr10030sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10030Sn ON b2bcreditcheckr10030sn (ITEMPK);


CREATE CACHED TABLE b2bcreditcheckresult
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_merchantcheck BIGINT,
    p_merchantchecktypecode NVARCHAR(255),
    p_status BIGINT,
    p_statusemail BIGINT,
    p_currency BIGINT,
    p_creditlimit DECIMAL(30,8),
    p_amountutilised DECIMAL(30,8),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE b2bcreditcheckresultlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_note LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bcreditlimit
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_active TINYINT,
    p_currency BIGINT,
    p_amount DECIMAL(30,8),
    p_dateperiod LONGVARBINARY,
    p_daterange BIGINT,
    p_alertthreshold DECIMAL(30,8),
    p_alertratetype BIGINT,
    p_alertsentdate TIMESTAMP,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE b2bcreditlimit10028sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10028Sn ON b2bcreditlimit10028sn (ITEMPK);


CREATE CACHED TABLE b2bgroups2permi10008sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10008Sn ON b2bgroups2permi10008sn (ITEMPK);

CREATE INDEX IdxsourcePK_10008Sn ON b2bgroups2permi10008sn (sourcePK);

CREATE INDEX IdxtargetPK_10008Sn ON b2bgroups2permi10008sn (targetPK);

CREATE INDEX IdxlanguagePK_10008Sn ON b2bgroups2permi10008sn (languagePK);


CREATE CACHED TABLE b2bgroups2permissionsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10008 ON b2bgroups2permissionsrel (SourcePK);

CREATE INDEX qualifier_10008 ON b2bgroups2permissionsrel (Qualifier);

CREATE INDEX rseqnr_10008 ON b2bgroups2permissionsrel (RSequenceNumber);

CREATE INDEX linktarget_10008 ON b2bgroups2permissionsrel (TargetPK);

CREATE INDEX seqnr_10008 ON b2bgroups2permissionsrel (SequenceNumber);


CREATE CACHED TABLE b2bmerchantchec10031sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10031Sn ON b2bmerchantchec10031sn (ITEMPK);


CREATE CACHED TABLE b2bmerchantchec10032sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10032Sn ON b2bmerchantchec10032sn (ITEMPK);


CREATE CACHED TABLE b2bmerchantcheck
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_active TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE b2bmerchantcheckresult
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_merchantcheck BIGINT,
    p_merchantchecktypecode NVARCHAR(255),
    p_status BIGINT,
    p_statusemail BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE b2bmerchantcheckresultlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_note LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bpermissionre10004sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10004Sn ON b2bpermissionre10004sn (ITEMPK);


CREATE CACHED TABLE b2bpermissionresults
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_permission BIGINT,
    p_permissiontypecode NVARCHAR(255),
    p_status BIGINT,
    p_approver BIGINT,
    p_orderpos INTEGER,
    p_order BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderRelIDX_10004 ON b2bpermissionresults (p_order);

CREATE INDEX orderposPosIDX_10004 ON b2bpermissionresults (p_orderpos);


CREATE CACHED TABLE b2bpermissionresultslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_note LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bpermissions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_active TINYINT,
    p_unitpos INTEGER,
    p_unit BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_threshold DOUBLE,
    p_currency BIGINT,
    p_range BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX unitRelIDX_10007 ON b2bpermissions (p_unit);

CREATE INDEX unitposPosIDX_10007 ON b2bpermissions (p_unitpos);


CREATE CACHED TABLE b2bpermissions10007sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10007Sn ON b2bpermissions10007sn (ITEMPK);


CREATE CACHED TABLE b2bpermissionslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_message NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE b2bquotelimit
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_amount DECIMAL(30,8),
    p_currency BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE b2bquotelimit10037sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10037Sn ON b2bquotelimit10037sn (ITEMPK);


CREATE CACHED TABLE b2breportingent10018sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10018Sn ON b2breportingent10018sn (ITEMPK);

CREATE INDEX IdxsourcePK_10018Sn ON b2breportingent10018sn (sourcePK);

CREATE INDEX IdxtargetPK_10018Sn ON b2breportingent10018sn (targetPK);

CREATE INDEX IdxlanguagePK_10018Sn ON b2breportingent10018sn (languagePK);


CREATE CACHED TABLE b2breportingentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10018 ON b2breportingentries (SourcePK);

CREATE INDEX qualifier_10018 ON b2breportingentries (Qualifier);

CREATE INDEX rseqnr_10018 ON b2breportingentries (RSequenceNumber);

CREATE INDEX linktarget_10018 ON b2breportingentries (TargetPK);

CREATE INDEX seqnr_10018 ON b2breportingentries (SequenceNumber);


CREATE CACHED TABLE b2breportingset
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX b2bReportingSetIdx_10017 ON b2breportingset (p_code);


CREATE CACHED TABLE b2breportingset10017sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10017Sn ON b2breportingset10017sn (ITEMPK);


CREATE CACHED TABLE backofficeconfi6403sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6403Sn ON backofficeconfi6403sn (ITEMPK);


CREATE CACHED TABLE backofficeconfigmedias
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_mime NVARCHAR(255),
    p_size BIGINT,
    p_datapk BIGINT,
    p_location LONGVARCHAR,
    p_locationhash NVARCHAR(255),
    p_realfilename NVARCHAR(255),
    p_code NVARCHAR(255),
    p_internalurl LONGVARCHAR,
    p_description NVARCHAR(255),
    p_alttext NVARCHAR(255),
    p_removable TINYINT,
    p_mediaformat BIGINT,
    p_folder BIGINT,
    p_subfolderpath NVARCHAR(255),
    p_mediacontainer BIGINT,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX dataPK_idx_6403 ON backofficeconfigmedias (p_datapk);

CREATE INDEX versionIDX_6403 ON backofficeconfigmedias (p_catalogversion);

CREATE UNIQUE INDEX codeVersionIDX_6403 ON backofficeconfigmedias (p_code, p_catalogversion);

CREATE UNIQUE INDEX Media_Code_6403 ON backofficeconfigmedias (p_code);

CREATE INDEX mediacontainerRelIDX_6403 ON backofficeconfigmedias (p_mediacontainer);


CREATE CACHED TABLE backofficesaved6400sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6400Sn ON backofficesaved6400sn (ITEMPK);


CREATE CACHED TABLE backofficesavedquery
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_queryowner BIGINT,
    p_typecode NVARCHAR(255),
    p_includesubtypes TINYINT,
    p_globaloperatorcode NVARCHAR(255),
    p_sortattribute NVARCHAR(255),
    p_sortasc TINYINT,
    p_tokenizable TINYINT,
    p_searchmode NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE backofficesavedquerylp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE backofficesearc6401sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6401Sn ON backofficesearc6401sn (ITEMPK);


CREATE CACHED TABLE backofficesearchcond
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_attribute NVARCHAR(255),
    p_value NVARCHAR(255),
    p_valuereference BIGINT,
    p_languagecode NVARCHAR(255),
    p_operatorcode NVARCHAR(255),
    p_selected TINYINT,
    p_editor NVARCHAR(255),
    p_editorparameters LONGVARBINARY,
    p_sortable TINYINT,
    p_disabled TINYINT,
    p_mandatory TINYINT,
    p_savedquery BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX savedqueryRelIDX_6401 ON backofficesearchcond (p_savedquery);


CREATE CACHED TABLE bannforrotcompr3000sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3000Sn ON bannforrotcompr3000sn (ITEMPK);

CREATE INDEX IdxsourcePK_3000Sn ON bannforrotcompr3000sn (sourcePK);

CREATE INDEX IdxtargetPK_3000Sn ON bannforrotcompr3000sn (targetPK);

CREATE INDEX IdxlanguagePK_3000Sn ON bannforrotcompr3000sn (languagePK);


CREATE CACHED TABLE bannforrotcomprels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3000 ON bannforrotcomprels (SourcePK);

CREATE INDEX qualifier_3000 ON bannforrotcomprels (Qualifier);

CREATE INDEX rseqnr_3000 ON bannforrotcomprels (RSequenceNumber);

CREATE INDEX linktarget_3000 ON bannforrotcomprels (TargetPK);

CREATE INDEX seqnr_3000 ON bannforrotcomprels (SequenceNumber);


CREATE CACHED TABLE basestore
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_storelocatordistanceunit BIGINT,
    p_net TINYINT,
    p_taxgroup BIGINT,
    p_defaultlanguage BIGINT,
    p_defaultcurrency BIGINT,
    p_defaultdeliveryorigin BIGINT,
    p_solrfacetsearchconfiguration BIGINT,
    p_submitorderprocesscode NVARCHAR(255),
    p_createreturnprocesscode NVARCHAR(255),
    p_externaltaxenabled TINYINT,
    p_pickupinstoremode BIGINT,
    p_maxradiusforpossearch DOUBLE,
    p_customerallowedtoignoresugge TINYINT,
    p_paymentprovider NVARCHAR(255),
    p_expresscheckoutenabled TINYINT,
    p_taxestimationenabled TINYINT,
    p_checkoutflowgroup NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE basestore2013sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2013Sn ON basestore2013sn (ITEMPK);


CREATE CACHED TABLE basestore2billi6235sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6235Sn ON basestore2billi6235sn (ITEMPK);

CREATE INDEX IdxsourcePK_6235Sn ON basestore2billi6235sn (sourcePK);

CREATE INDEX IdxtargetPK_6235Sn ON basestore2billi6235sn (targetPK);

CREATE INDEX IdxlanguagePK_6235Sn ON basestore2billi6235sn (languagePK);


CREATE CACHED TABLE basestore2billingcounrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6235 ON basestore2billingcounrel (SourcePK);

CREATE INDEX qualifier_6235 ON basestore2billingcounrel (Qualifier);

CREATE INDEX rseqnr_6235 ON basestore2billingcounrel (RSequenceNumber);

CREATE INDEX linktarget_6235 ON basestore2billingcounrel (TargetPK);

CREATE INDEX seqnr_6235 ON basestore2billingcounrel (SequenceNumber);


CREATE CACHED TABLE basestore2count6213sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6213Sn ON basestore2count6213sn (ITEMPK);

CREATE INDEX IdxsourcePK_6213Sn ON basestore2count6213sn (sourcePK);

CREATE INDEX IdxtargetPK_6213Sn ON basestore2count6213sn (targetPK);

CREATE INDEX IdxlanguagePK_6213Sn ON basestore2count6213sn (languagePK);


CREATE CACHED TABLE basestore2countryrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6213 ON basestore2countryrel (SourcePK);

CREATE INDEX qualifier_6213 ON basestore2countryrel (Qualifier);

CREATE INDEX rseqnr_6213 ON basestore2countryrel (RSequenceNumber);

CREATE INDEX linktarget_6213 ON basestore2countryrel (TargetPK);

CREATE INDEX seqnr_6213 ON basestore2countryrel (SequenceNumber);


CREATE CACHED TABLE basestore2curre6201sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6201Sn ON basestore2curre6201sn (ITEMPK);

CREATE INDEX IdxsourcePK_6201Sn ON basestore2curre6201sn (sourcePK);

CREATE INDEX IdxtargetPK_6201Sn ON basestore2curre6201sn (targetPK);

CREATE INDEX IdxlanguagePK_6201Sn ON basestore2curre6201sn (languagePK);


CREATE CACHED TABLE basestore2currencyrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6201 ON basestore2currencyrel (SourcePK);

CREATE INDEX qualifier_6201 ON basestore2currencyrel (Qualifier);

CREATE INDEX rseqnr_6201 ON basestore2currencyrel (RSequenceNumber);

CREATE INDEX linktarget_6201 ON basestore2currencyrel (TargetPK);

CREATE INDEX seqnr_6201 ON basestore2currencyrel (SequenceNumber);


CREATE CACHED TABLE basestore2delmo6220sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6220Sn ON basestore2delmo6220sn (ITEMPK);

CREATE INDEX IdxsourcePK_6220Sn ON basestore2delmo6220sn (sourcePK);

CREATE INDEX IdxtargetPK_6220Sn ON basestore2delmo6220sn (targetPK);

CREATE INDEX IdxlanguagePK_6220Sn ON basestore2delmo6220sn (languagePK);


CREATE CACHED TABLE basestore2delmoderel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6220 ON basestore2delmoderel (SourcePK);

CREATE INDEX qualifier_6220 ON basestore2delmoderel (Qualifier);

CREATE INDEX rseqnr_6220 ON basestore2delmoderel (RSequenceNumber);

CREATE INDEX linktarget_6220 ON basestore2delmoderel (TargetPK);

CREATE INDEX seqnr_6220 ON basestore2delmoderel (SequenceNumber);


CREATE CACHED TABLE basestore2langu6212sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6212Sn ON basestore2langu6212sn (ITEMPK);

CREATE INDEX IdxsourcePK_6212Sn ON basestore2langu6212sn (sourcePK);

CREATE INDEX IdxtargetPK_6212Sn ON basestore2langu6212sn (targetPK);

CREATE INDEX IdxlanguagePK_6212Sn ON basestore2langu6212sn (languagePK);


CREATE CACHED TABLE basestore2languagerel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6212 ON basestore2languagerel (SourcePK);

CREATE INDEX qualifier_6212 ON basestore2languagerel (Qualifier);

CREATE INDEX rseqnr_6212 ON basestore2languagerel (RSequenceNumber);

CREATE INDEX linktarget_6212 ON basestore2languagerel (TargetPK);

CREATE INDEX seqnr_6212 ON basestore2languagerel (SequenceNumber);


CREATE CACHED TABLE basestore2wareh6215sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6215Sn ON basestore2wareh6215sn (ITEMPK);

CREATE INDEX IdxsourcePK_6215Sn ON basestore2wareh6215sn (sourcePK);

CREATE INDEX IdxtargetPK_6215Sn ON basestore2wareh6215sn (targetPK);

CREATE INDEX IdxlanguagePK_6215Sn ON basestore2wareh6215sn (languagePK);


CREATE CACHED TABLE basestore2warehouserel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6215 ON basestore2warehouserel (SourcePK);

CREATE INDEX qualifier_6215 ON basestore2warehouserel (Qualifier);

CREATE INDEX rseqnr_6215 ON basestore2warehouserel (RSequenceNumber);

CREATE INDEX linktarget_6215 ON basestore2warehouserel (TargetPK);

CREATE INDEX seqnr_6215 ON basestore2warehouserel (SequenceNumber);


CREATE CACHED TABLE basestorelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE boidxtype2solrf6700sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6700Sn ON boidxtype2solrf6700sn (ITEMPK);


CREATE CACHED TABLE boidxtype2solrfctsrcfg
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_indexedtype BIGINT,
    p_solrfacetsearchconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE bruteforcelogin9450sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9450Sn ON bruteforcelogin9450sn (ITEMPK);


CREATE CACHED TABLE bruteforceloginattempts
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_attempts INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX uidX_9450 ON bruteforceloginattempts (p_uid);


CREATE CACHED TABLE budgets2costcen10010sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10010Sn ON budgets2costcen10010sn (ITEMPK);

CREATE INDEX IdxsourcePK_10010Sn ON budgets2costcen10010sn (sourcePK);

CREATE INDEX IdxtargetPK_10010Sn ON budgets2costcen10010sn (targetPK);

CREATE INDEX IdxlanguagePK_10010Sn ON budgets2costcen10010sn (languagePK);


CREATE CACHED TABLE budgets2costcenter
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10010 ON budgets2costcenter (SourcePK);

CREATE INDEX qualifier_10010 ON budgets2costcenter (Qualifier);

CREATE INDEX rseqnr_10010 ON budgets2costcenter (RSequenceNumber);

CREATE INDEX linktarget_10010 ON budgets2costcenter (TargetPK);

CREATE INDEX seqnr_10010 ON budgets2costcenter (SequenceNumber);


CREATE CACHED TABLE campaign
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_enabled TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE campaign2090sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2090Sn ON campaign2090sn (ITEMPK);


CREATE CACHED TABLE campaign2source5310sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5310Sn ON campaign2source5310sn (ITEMPK);

CREATE INDEX IdxsourcePK_5310Sn ON campaign2source5310sn (sourcePK);

CREATE INDEX IdxtargetPK_5310Sn ON campaign2source5310sn (targetPK);

CREATE INDEX IdxlanguagePK_5310Sn ON campaign2source5310sn (languagePK);


CREATE CACHED TABLE campaign2sourcerulerel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_5310 ON campaign2sourcerulerel (SourcePK);

CREATE INDEX qualifier_5310 ON campaign2sourcerulerel (Qualifier);

CREATE INDEX rseqnr_5310 ON campaign2sourcerulerel (RSequenceNumber);

CREATE INDEX linktarget_5310 ON campaign2sourcerulerel (TargetPK);

CREATE INDEX seqnr_5310 ON campaign2sourcerulerel (SequenceNumber);


CREATE CACHED TABLE campaignlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE campaigns4restr1103sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1103Sn ON campaigns4restr1103sn (ITEMPK);

CREATE INDEX IdxsourcePK_1103Sn ON campaigns4restr1103sn (sourcePK);

CREATE INDEX IdxtargetPK_1103Sn ON campaigns4restr1103sn (targetPK);

CREATE INDEX IdxlanguagePK_1103Sn ON campaigns4restr1103sn (languagePK);


CREATE CACHED TABLE campaigns4restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1103 ON campaigns4restriction (SourcePK);

CREATE INDEX qualifier_1103 ON campaigns4restriction (Qualifier);

CREATE INDEX rseqnr_1103 ON campaigns4restriction (RSequenceNumber);

CREATE INDEX linktarget_1103 ON campaigns4restriction (TargetPK);

CREATE INDEX seqnr_1103 ON campaigns4restriction (SequenceNumber);


CREATE CACHED TABLE cartentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_baseprice DECIMAL(30,8),
    p_calculated TINYINT,
    p_discountvaluesinternal LONGVARCHAR,
    p_entrynumber INTEGER,
    p_info LONGVARCHAR,
    p_product BIGINT,
    p_quantity DECIMAL(30,8),
    p_taxvaluesinternal NVARCHAR(255),
    p_totalprice DECIMAL(30,8),
    p_unit BIGINT,
    p_giveaway TINYINT,
    p_rejected TINYINT,
    p_entrygroupnumbers LONGVARBINARY,
    p_order BIGINT,
    p_europe1pricefactory_ppg BIGINT,
    p_europe1pricefactory_ptg BIGINT,
    p_europe1pricefactory_pdg BIGINT,
    p_chosenvendor BIGINT,
    p_deliveryaddress BIGINT,
    p_deliverymode BIGINT,
    p_nameddeliverydate TIMESTAMP,
    p_quantitystatus BIGINT,
    p_deliverypointofservice BIGINT,
    p_costcenter BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX oeProd_44 ON cartentries (p_product);

CREATE INDEX oeOrd_44 ON cartentries (p_order);


CREATE CACHED TABLE cartentries44sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_44Sn ON cartentries44sn (ITEMPK);


CREATE CACHED TABLE carts
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_calculated TINYINT,
    p_code NVARCHAR(255),
    p_currency BIGINT,
    p_deliveryaddress BIGINT,
    p_deliverycost DECIMAL(30,8),
    p_deliverymode BIGINT,
    p_deliverystatus BIGINT,
    p_description NVARCHAR(255),
    p_expirationtime TIMESTAMP,
    p_globaldiscountvaluesinternal LONGVARCHAR,
    p_name NVARCHAR(255),
    p_net TINYINT,
    p_paymentaddress BIGINT,
    p_paymentcost DECIMAL(30,8),
    p_paymentinfo BIGINT,
    p_paymentmode BIGINT,
    p_paymentstatus BIGINT,
    p_status BIGINT,
    p_exportstatus BIGINT,
    p_statusinfo NVARCHAR(255),
    p_totalprice DECIMAL(30,8),
    p_totaldiscounts DECIMAL(30,8),
    p_totaltax DECIMAL(30,8),
    p_totaltaxvaluesinternal LONGVARCHAR,
    p_user BIGINT,
    p_subtotal DECIMAL(30,8),
    p_discountsincludedeliverycost TINYINT,
    p_discountsincludepaymentcost TINYINT,
    p_entrygroups LONGVARBINARY,
    p_europe1pricefactory_udg BIGINT,
    p_europe1pricefactory_upg BIGINT,
    p_europe1pricefactory_utg BIGINT,
    p_previousdeliverymode BIGINT,
    p_site BIGINT,
    p_store BIGINT,
    p_guid NVARCHAR(255),
    p_quotediscountvaluesinternal LONGVARCHAR,
    p_locale NVARCHAR(255),
    p_workflow BIGINT,
    p_quoteexpirationdate TIMESTAMP,
    p_unit BIGINT,
    p_purchaseordernumber NVARCHAR(255),
    p_paymenttype BIGINT,
    p_appliedcouponcodes LONGVARBINARY,
    p_sessionid NVARCHAR(255),
    p_savetime TIMESTAMP,
    p_savedby BIGINT,
    p_quotereference BIGINT,
    p_importstatus BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX OrderCode_43 ON carts (p_code);

CREATE INDEX OrderUser_43 ON carts (p_user);

CREATE INDEX guidIndex_43 ON carts (p_guid);

CREATE INDEX cartSelectionIndex_43 ON carts (p_user, p_site, p_savetime, modifiedTS);

CREATE INDEX unitRelIDX_43 ON carts (p_unit);


CREATE CACHED TABLE carts43sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_43Sn ON carts43sn (ITEMPK);


CREATE CACHED TABLE cat2attrrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_classificationclass BIGINT,
    p_classificationattribute BIGINT,
    p_systemversion BIGINT,
    p_position INTEGER,
    p_externalid NVARCHAR(255),
    p_unit BIGINT,
    p_mandatory TINYINT,
    p_localized TINYINT,
    p_range TINYINT,
    p_multivalued TINYINT,
    p_searchable TINYINT,
    p_attributetype BIGINT,
    p_referencetype BIGINT,
    p_referenceincludessubtypes TINYINT,
    p_formatdefinition NVARCHAR(255),
    p_listable TINYINT,
    p_comparable TINYINT,
    p_visibility BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX sysVer_610 ON cat2attrrel (p_systemversion);

CREATE INDEX relSrcIDX_610 ON cat2attrrel (p_classificationclass);

CREATE INDEX idIDX_610 ON cat2attrrel (p_externalid);

CREATE INDEX relTgtIDX_610 ON cat2attrrel (p_classificationattribute);

CREATE INDEX posIdx_610 ON cat2attrrel (p_position);


CREATE CACHED TABLE cat2attrrel610sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_610Sn ON cat2attrrel610sn (ITEMPK);


CREATE CACHED TABLE cat2attrrellp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE cat2catrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_144 ON cat2catrel (SourcePK);

CREATE INDEX qualifier_144 ON cat2catrel (Qualifier);

CREATE INDEX rseqnr_144 ON cat2catrel (RSequenceNumber);

CREATE INDEX linktarget_144 ON cat2catrel (TargetPK);

CREATE INDEX seqnr_144 ON cat2catrel (SequenceNumber);


CREATE CACHED TABLE cat2catrel144sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_144Sn ON cat2catrel144sn (ITEMPK);

CREATE INDEX IdxsourcePK_144Sn ON cat2catrel144sn (sourcePK);

CREATE INDEX IdxtargetPK_144Sn ON cat2catrel144sn (targetPK);

CREATE INDEX IdxlanguagePK_144Sn ON cat2catrel144sn (languagePK);


CREATE CACHED TABLE cat2keywordrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_605 ON cat2keywordrel (SourcePK);

CREATE INDEX qualifier_605 ON cat2keywordrel (Qualifier);

CREATE INDEX rseqnr_605 ON cat2keywordrel (RSequenceNumber);

CREATE INDEX linktarget_605 ON cat2keywordrel (TargetPK);

CREATE INDEX seqnr_605 ON cat2keywordrel (SequenceNumber);


CREATE CACHED TABLE cat2keywordrel605sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_605Sn ON cat2keywordrel605sn (ITEMPK);

CREATE INDEX IdxsourcePK_605Sn ON cat2keywordrel605sn (sourcePK);

CREATE INDEX IdxtargetPK_605Sn ON cat2keywordrel605sn (targetPK);

CREATE INDEX IdxlanguagePK_605Sn ON cat2keywordrel605sn (languagePK);


CREATE CACHED TABLE cat2medrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_145 ON cat2medrel (SourcePK);

CREATE INDEX qualifier_145 ON cat2medrel (Qualifier);

CREATE INDEX rseqnr_145 ON cat2medrel (RSequenceNumber);

CREATE INDEX linktarget_145 ON cat2medrel (TargetPK);

CREATE INDEX seqnr_145 ON cat2medrel (SequenceNumber);


CREATE CACHED TABLE cat2medrel145sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_145Sn ON cat2medrel145sn (ITEMPK);

CREATE INDEX IdxsourcePK_145Sn ON cat2medrel145sn (sourcePK);

CREATE INDEX IdxtargetPK_145Sn ON cat2medrel145sn (targetPK);

CREATE INDEX IdxlanguagePK_145Sn ON cat2medrel145sn (languagePK);


CREATE CACHED TABLE cat2princrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_613 ON cat2princrel (SourcePK);

CREATE INDEX qualifier_613 ON cat2princrel (Qualifier);

CREATE INDEX rseqnr_613 ON cat2princrel (RSequenceNumber);

CREATE INDEX linktarget_613 ON cat2princrel (TargetPK);

CREATE INDEX seqnr_613 ON cat2princrel (SequenceNumber);


CREATE CACHED TABLE cat2princrel613sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_613Sn ON cat2princrel613sn (ITEMPK);

CREATE INDEX IdxsourcePK_613Sn ON cat2princrel613sn (sourcePK);

CREATE INDEX IdxtargetPK_613Sn ON cat2princrel613sn (targetPK);

CREATE INDEX IdxlanguagePK_613Sn ON cat2princrel613sn (languagePK);


CREATE CACHED TABLE cat2prodrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_143 ON cat2prodrel (SourcePK);

CREATE INDEX qualifier_143 ON cat2prodrel (Qualifier);

CREATE INDEX rseqnr_143 ON cat2prodrel (RSequenceNumber);

CREATE INDEX linktarget_143 ON cat2prodrel (TargetPK);

CREATE INDEX seqnr_143 ON cat2prodrel (SequenceNumber);


CREATE CACHED TABLE cat2prodrel143sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_143Sn ON cat2prodrel143sn (ITEMPK);

CREATE INDEX IdxsourcePK_143Sn ON cat2prodrel143sn (sourcePK);

CREATE INDEX IdxtargetPK_143Sn ON cat2prodrel143sn (targetPK);

CREATE INDEX IdxlanguagePK_143Sn ON cat2prodrel143sn (languagePK);


CREATE CACHED TABLE catalogs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id varchar(200),
    p_activecatalogversion BIGINT,
    p_defaultcatalog TINYINT,
    p_previewurltemplate NVARCHAR(255),
    p_urlpatterns LONGVARBINARY,
    p_supplier BIGINT,
    p_buyer BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_supercatalog BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX idIdx_600 ON catalogs (p_id);

CREATE INDEX supplierRelIDX_600 ON catalogs (p_supplier);

CREATE INDEX buyerRelIDX_600 ON catalogs (p_buyer);

CREATE INDEX supercatalogRelIDX_600 ON catalogs (p_supercatalog);


CREATE CACHED TABLE catalogs4basest2012sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2012Sn ON catalogs4basest2012sn (ITEMPK);

CREATE INDEX IdxsourcePK_2012Sn ON catalogs4basest2012sn (sourcePK);

CREATE INDEX IdxtargetPK_2012Sn ON catalogs4basest2012sn (targetPK);

CREATE INDEX IdxlanguagePK_2012Sn ON catalogs4basest2012sn (languagePK);


CREATE CACHED TABLE catalogs4basestores
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2012 ON catalogs4basestores (SourcePK);

CREATE INDEX qualifier_2012 ON catalogs4basestores (Qualifier);

CREATE INDEX rseqnr_2012 ON catalogs4basestores (RSequenceNumber);

CREATE INDEX linktarget_2012 ON catalogs4basestores (TargetPK);

CREATE INDEX seqnr_2012 ON catalogs4basestores (SequenceNumber);


CREATE CACHED TABLE catalogs4restri1079sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1079Sn ON catalogs4restri1079sn (ITEMPK);

CREATE INDEX IdxsourcePK_1079Sn ON catalogs4restri1079sn (sourcePK);

CREATE INDEX IdxtargetPK_1079Sn ON catalogs4restri1079sn (targetPK);

CREATE INDEX IdxlanguagePK_1079Sn ON catalogs4restri1079sn (languagePK);


CREATE CACHED TABLE catalogs4restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1079 ON catalogs4restriction (SourcePK);

CREATE INDEX qualifier_1079 ON catalogs4restriction (Qualifier);

CREATE INDEX rseqnr_1079 ON catalogs4restriction (RSequenceNumber);

CREATE INDEX linktarget_1079 ON catalogs4restriction (TargetPK);

CREATE INDEX seqnr_1079 ON catalogs4restriction (SequenceNumber);


CREATE CACHED TABLE catalogs4site
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1063 ON catalogs4site (SourcePK);

CREATE INDEX qualifier_1063 ON catalogs4site (Qualifier);

CREATE INDEX rseqnr_1063 ON catalogs4site (RSequenceNumber);

CREATE INDEX linktarget_1063 ON catalogs4site (TargetPK);

CREATE INDEX seqnr_1063 ON catalogs4site (SequenceNumber);


CREATE CACHED TABLE catalogs4site1063sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1063Sn ON catalogs4site1063sn (ITEMPK);

CREATE INDEX IdxsourcePK_1063Sn ON catalogs4site1063sn (sourcePK);

CREATE INDEX IdxtargetPK_1063Sn ON catalogs4site1063sn (targetPK);

CREATE INDEX IdxlanguagePK_1063Sn ON catalogs4site1063sn (languagePK);


CREATE CACHED TABLE catalogs600sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_600Sn ON catalogs600sn (ITEMPK);


CREATE CACHED TABLE catalogslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_cataloglevelname NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE catalogversions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_version NVARCHAR(255),
    p_mimerootdirectory NVARCHAR(255),
    p_generationdate TIMESTAMP,
    p_defaultcurrency BIGINT,
    p_inclfreight TINYINT,
    p_inclpacking TINYINT,
    p_inclassurance TINYINT,
    p_inclduty TINYINT,
    p_territories LONGVARCHAR,
    p_languages LONGVARCHAR,
    p_generatorinfo NVARCHAR(255),
    p_categorysystemid NVARCHAR(255),
    p_previousupdateversion INTEGER,
    p_catalog BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIDX_601 ON catalogversions (p_version);

CREATE INDEX catalogIDX_601 ON catalogversions (p_catalog);

CREATE INDEX visibleIDX_601 ON catalogversions (p_active);


CREATE CACHED TABLE catalogversions601sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_601Sn ON catalogversions601sn (ITEMPK);


CREATE CACHED TABLE catalogversions624sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_624Sn ON catalogversions624sn (ITEMPK);

CREATE INDEX IdxsourcePK_624Sn ON catalogversions624sn (sourcePK);

CREATE INDEX IdxtargetPK_624Sn ON catalogversions624sn (targetPK);

CREATE INDEX IdxlanguagePK_624Sn ON catalogversions624sn (languagePK);


CREATE CACHED TABLE catalogversionslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_categorysystemname NVARCHAR(255),
    p_categorysystemdescription NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE catalogversionsyncjob
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_624 ON catalogversionsyncjob (SourcePK);

CREATE INDEX qualifier_624 ON catalogversionsyncjob (Qualifier);

CREATE INDEX rseqnr_624 ON catalogversionsyncjob (RSequenceNumber);

CREATE INDEX linktarget_624 ON catalogversionsyncjob (TargetPK);

CREATE INDEX seqnr_624 ON catalogversionsyncjob (SequenceNumber);


CREATE CACHED TABLE categories
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_order INTEGER,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    p_normal LONGVARCHAR,
    p_thumbnails LONGVARCHAR,
    p_detail LONGVARCHAR,
    p_logo LONGVARCHAR,
    p_data_sheet LONGVARCHAR,
    p_others LONGVARCHAR,
    p_thumbnail BIGINT,
    p_picture BIGINT,
    p_code NVARCHAR(255),
    p_stocklevelthreshold INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_externalid NVARCHAR(255),
    p_revision NVARCHAR(255),
    p_showemptyattributes TINYINT,
    p_hasimage TINYINT,
    p_sequence INTEGER,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIDX_142 ON categories (p_code);

CREATE INDEX versionIDX_142 ON categories (p_catalogversion);

CREATE UNIQUE INDEX codeVersionIDX_142 ON categories (p_code, p_catalogversion);

CREATE INDEX extID_142 ON categories (p_externalid);


CREATE CACHED TABLE categories142sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_142Sn ON categories142sn (ITEMPK);


CREATE CACHED TABLE categories4rest1080sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1080Sn ON categories4rest1080sn (ITEMPK);

CREATE INDEX IdxsourcePK_1080Sn ON categories4rest1080sn (sourcePK);

CREATE INDEX IdxtargetPK_1080Sn ON categories4rest1080sn (targetPK);

CREATE INDEX IdxlanguagePK_1080Sn ON categories4rest1080sn (languagePK);


CREATE CACHED TABLE categories4restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1080 ON categories4restriction (SourcePK);

CREATE INDEX qualifier_1080 ON categories4restriction (Qualifier);

CREATE INDEX rseqnr_1080 ON categories4restriction (RSequenceNumber);

CREATE INDEX linktarget_1080 ON categories4restriction (TargetPK);

CREATE INDEX seqnr_1080 ON categories4restriction (SequenceNumber);


CREATE CACHED TABLE categorieslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description LONGVARCHAR,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE catforpromosour5403sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5403Sn ON catforpromosour5403sn (ITEMPK);


CREATE CACHED TABLE catforpromosourcerule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_categorycode NVARCHAR(255),
    p_rule BIGINT,
    p_promotion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX CatForPromoSourceRule_IDX_5403 ON catforpromosourcerule (p_categorycode, p_rule, p_promotion, TypePkString);

CREATE INDEX CatForPromoSourceRuleItemType_IDX_5403 ON catforpromosourcerule (TypePkString);


CREATE CACHED TABLE catpromrelation5019sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5019Sn ON catpromrelation5019sn (ITEMPK);

CREATE INDEX IdxsourcePK_5019Sn ON catpromrelation5019sn (sourcePK);

CREATE INDEX IdxtargetPK_5019Sn ON catpromrelation5019sn (targetPK);

CREATE INDEX IdxlanguagePK_5019Sn ON catpromrelation5019sn (languagePK);


CREATE CACHED TABLE catpromrelations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_5019 ON catpromrelations (SourcePK);

CREATE INDEX qualifier_5019 ON catpromrelations (Qualifier);

CREATE INDEX rseqnr_5019 ON catpromrelations (RSequenceNumber);

CREATE INDEX linktarget_5019 ON catpromrelations (TargetPK);

CREATE INDEX seqnr_5019 ON catpromrelations (SequenceNumber);


CREATE CACHED TABLE catsforprodcarc3003sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3003Sn ON catsforprodcarc3003sn (ITEMPK);

CREATE INDEX IdxsourcePK_3003Sn ON catsforprodcarc3003sn (sourcePK);

CREATE INDEX IdxtargetPK_3003Sn ON catsforprodcarc3003sn (targetPK);

CREATE INDEX IdxlanguagePK_3003Sn ON catsforprodcarc3003sn (languagePK);


CREATE CACHED TABLE catsforprodcarcomprels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3003 ON catsforprodcarcomprels (SourcePK);

CREATE INDEX qualifier_3003 ON catsforprodcarcomprels (Qualifier);

CREATE INDEX rseqnr_3003 ON catsforprodcarcomprels (RSequenceNumber);

CREATE INDEX linktarget_3003 ON catsforprodcarcomprels (TargetPK);

CREATE INDEX seqnr_3003 ON catsforprodcarcomprels (SequenceNumber);


CREATE CACHED TABLE catver2rulescon5202sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5202Sn ON catver2rulescon5202sn (ITEMPK);


CREATE CACHED TABLE catver2rulescontext
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_catalogversion BIGINT,
    p_context BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE catverdiffs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_sourceversion BIGINT,
    p_targetversion BIGINT,
    p_cronjob BIGINT,
    p_differencetext LONGVARCHAR,
    p_differencevalue DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_sourceproduct BIGINT,
    p_targetproduct BIGINT,
    p_mode BIGINT,
    p_sourcecategory BIGINT,
    p_targetcategory BIGINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE catverdiffs615sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_615Sn ON catverdiffs615sn (ITEMPK);


CREATE CACHED TABLE ccpaysubvalidat6216sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6216Sn ON ccpaysubvalidat6216sn (ITEMPK);


CREATE CACHED TABLE ccpaysubvalidation
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_subscriptionid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE changedescripto505sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_505Sn ON changedescripto505sn (ITEMPK);


CREATE CACHED TABLE changedescriptors
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_cronjob BIGINT,
    p_step BIGINT,
    p_changeditem BIGINT,
    p_sequencenumber INTEGER,
    p_savetimestamp TIMESTAMP,
    p_changetype NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_targetitem BIGINT,
    p_done TINYINT,
    p_copiedimplicitely TINYINT,
    PRIMARY KEY (PK)
);

CREATE INDEX cronjobIDX_505 ON changedescriptors (p_cronjob);

CREATE INDEX stepIDX_505 ON changedescriptors (p_step);

CREATE INDEX changedItemIDX_505 ON changedescriptors (p_changeditem);

CREATE INDEX seqNrIDX_505 ON changedescriptors (p_sequencenumber);

CREATE INDEX doneIDX_505 ON changedescriptors (p_done);


CREATE CACHED TABLE classattrvalues
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_externalid NVARCHAR(255),
    p_systemversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX sysVer_608 ON classattrvalues (p_systemversion);

CREATE INDEX code_608 ON classattrvalues (p_code);

CREATE INDEX idIDX_608 ON classattrvalues (p_externalid);


CREATE CACHED TABLE classattrvalues608sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_608Sn ON classattrvalues608sn (ITEMPK);


CREATE CACHED TABLE classattrvalueslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE classificationa607sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_607Sn ON classificationa607sn (ITEMPK);


CREATE CACHED TABLE classificationattrs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_systemversion BIGINT,
    p_code NVARCHAR(255),
    p_externalid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX sysVer_607 ON classificationattrs (p_systemversion);

CREATE INDEX code_607 ON classificationattrs (p_code);

CREATE INDEX idIDX_607 ON classificationattrs (p_externalid);


CREATE CACHED TABLE classificationattrslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE clattrunt
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_systemversion BIGINT,
    p_code NVARCHAR(255),
    p_externalid NVARCHAR(255),
    p_symbol NVARCHAR(255),
    p_unittype NVARCHAR(255),
    p_conversionfactor DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX sysVer_612 ON clattrunt (p_systemversion);

CREATE INDEX codeIdx_612 ON clattrunt (p_code);

CREATE INDEX extID_612 ON clattrunt (p_externalid);


CREATE CACHED TABLE clattrunt612sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_612Sn ON clattrunt612sn (ITEMPK);


CREATE CACHED TABLE clattruntlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE cmptype2covgrpr978sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_978Sn ON cmptype2covgrpr978sn (ITEMPK);

CREATE INDEX IdxsourcePK_978Sn ON cmptype2covgrpr978sn (sourcePK);

CREATE INDEX IdxtargetPK_978Sn ON cmptype2covgrpr978sn (targetPK);

CREATE INDEX IdxlanguagePK_978Sn ON cmptype2covgrpr978sn (languagePK);


CREATE CACHED TABLE cmptype2covgrprels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_978 ON cmptype2covgrprels (SourcePK);

CREATE INDEX qualifier_978 ON cmptype2covgrprels (Qualifier);

CREATE INDEX rseqnr_978 ON cmptype2covgrprels (RSequenceNumber);

CREATE INDEX linktarget_978 ON cmptype2covgrprels (TargetPK);

CREATE INDEX seqnr_978 ON cmptype2covgrprels (SequenceNumber);


CREATE CACHED TABLE cmscomponent
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    p_visible TINYINT,
    p_onlyonerestrictionmustapply TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_scope BIGINT,
    p_defaultcmscomponent BIGINT,
    p_sourceid NVARCHAR(255),
    p_external TINYINT,
    p_url NVARCHAR(255),
    p_target BIGINT,
    p_contentpagepos INTEGER,
    p_contentpage BIGINT,
    p_productpos INTEGER,
    p_product BIGINT,
    p_categorypos INTEGER,
    p_category BIGINT,
    p_styleattributes NVARCHAR(255),
    p_urllink NVARCHAR(255),
    p_page BIGINT,
    p_play TINYINT,
    p_loop TINYINT,
    p_menu TINYINT,
    p_quality BIGINT,
    p_scale BIGINT,
    p_wmode BIGINT,
    p_salign BIGINT,
    p_bgcolor NVARCHAR(255),
    p_width INTEGER,
    p_height INTEGER,
    p_mediacodepattern NVARCHAR(255),
    p_scroll BIGINT,
    p_searchquery NVARCHAR(255),
    p_categorycode NVARCHAR(255),
    p_popup TINYINT,
    p_timeout INTEGER,
    p_effect BIGINT,
    p_productsfromcontext TINYINT,
    p_pagination TINYINT,
    p_layout BIGINT,
    p_productreferencetypes LONGVARCHAR,
    p_maximumnumberproducts INTEGER,
    p_displayproducttitles TINYINT,
    p_displayproductprices TINYINT,
    p_filterpurchased TINYINT,
    p_totaldisplay BIGINT,
    p_shownproductcount INTEGER,
    p_lightboxbannercomponent BIGINT,
    p_dropdownlayout BIGINT,
    p_navigationnode BIGINT,
    p_wrapafter INTEGER,
    p_link BIGINT,
    p_styleclass NVARCHAR(255),
    p_components LONGVARCHAR,
    p_showlanguagecurrency TINYINT,
    p_navigationnodes LONGVARCHAR,
    p_displaysuggestions TINYINT,
    p_displayproducts TINYINT,
    p_displayproductimages TINYINT,
    p_maxsuggestions INTEGER,
    p_maxproducts INTEGER,
    p_mincharactersbeforerequest INTEGER,
    p_waittimebeforerequest INTEGER,
    p_pag0 NVARCHAR(255),
    p_logo BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX componentIDX_1084 ON cmscomponent (p_uid, p_catalogversion);

CREATE INDEX contentpageRelIDX_1084 ON cmscomponent (p_contentpage);

CREATE INDEX contentpageposPosIDX_1084 ON cmscomponent (p_contentpagepos);

CREATE INDEX productRelIDX_1084 ON cmscomponent (p_product);

CREATE INDEX productposPosIDX_1084 ON cmscomponent (p_productpos);

CREATE INDEX categoryRelIDX_1084 ON cmscomponent (p_category);

CREATE INDEX categoryposPosIDX_1084 ON cmscomponent (p_categorypos);

CREATE INDEX pageRelIDX_1084 ON cmscomponent (p_page);


CREATE CACHED TABLE cmscomponent1084sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1084Sn ON cmscomponent1084sn (ITEMPK);


CREATE CACHED TABLE cmscomponentlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_title NVARCHAR(255),
    p_media BIGINT,
    p_linkname NVARCHAR(255),
    p_headline NVARCHAR(255),
    p_content LONGVARCHAR,
    p_imagemaphtml LONGVARCHAR,
    p_searchquery NVARCHAR(255),
    p_notice NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE cmslinksfornavn1089sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1089Sn ON cmslinksfornavn1089sn (ITEMPK);

CREATE INDEX IdxsourcePK_1089Sn ON cmslinksfornavn1089sn (sourcePK);

CREATE INDEX IdxtargetPK_1089Sn ON cmslinksfornavn1089sn (targetPK);

CREATE INDEX IdxlanguagePK_1089Sn ON cmslinksfornavn1089sn (languagePK);


CREATE CACHED TABLE cmslinksfornavnodes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1089 ON cmslinksfornavnodes (SourcePK);

CREATE INDEX qualifier_1089 ON cmslinksfornavnodes (Qualifier);

CREATE INDEX rseqnr_1089 ON cmslinksfornavnodes (RSequenceNumber);

CREATE INDEX linktarget_1089 ON cmslinksfornavnodes (TargetPK);

CREATE INDEX seqnr_1089 ON cmslinksfornavnodes (SequenceNumber);


CREATE CACHED TABLE cmsnavigationen1096sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1096Sn ON cmsnavigationen1096sn (ITEMPK);


CREATE CACHED TABLE cmsnavigationentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    p_item BIGINT,
    p_navigationnodepos INTEGER,
    p_navigationnode BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cmsNavEntryItemIdx_1096 ON cmsnavigationentry (p_item);

CREATE INDEX navigationnodeRelIDX_1096 ON cmsnavigationentry (p_navigationnode);

CREATE INDEX navigationnodeposPosIDX_1096 ON cmsnavigationentry (p_navigationnodepos);


CREATE CACHED TABLE cmsnavigationno1088sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1088Sn ON cmsnavigationno1088sn (ITEMPK);


CREATE CACHED TABLE cmsnavigationnode
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    p_visible TINYINT,
    p_parentpos INTEGER,
    p_parent BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX parentRelIDX_1088 ON cmsnavigationnode (p_parent);

CREATE INDEX parentposPosIDX_1088 ON cmsnavigationnode (p_parentpos);


CREATE CACHED TABLE cmsnavigationnodelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_title NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE cmspage
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    p_approvalstatus BIGINT,
    p_pagestatus BIGINT,
    p_mastertemplate BIGINT,
    p_defaultpage TINYINT,
    p_onlyonerestrictionmustapply TINYINT,
    p_previewimage BIGINT,
    p_copytocatalogsdisabled TINYINT,
    p_lockedby BIGINT,
    p_originalpage BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_label NVARCHAR(255),
    p_homepage TINYINT,
    PRIMARY KEY (PK)
);

CREATE INDEX EmailPageMasterTpl_1072 ON cmspage (p_mastertemplate);

CREATE INDEX lockedbyRelIDX_1072 ON cmspage (p_lockedby);

CREATE INDEX originalpageRelIDX_1072 ON cmspage (p_originalpage);


CREATE CACHED TABLE cmspage1072sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1072Sn ON cmspage1072sn (ITEMPK);


CREATE CACHED TABLE cmspagelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_title NVARCHAR(255),
    p_keywords NVARCHAR(255),
    p_description NVARCHAR(255),
    p_fromemail NVARCHAR(255),
    p_fromname NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE cmspagesfornavn1090sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1090Sn ON cmspagesfornavn1090sn (ITEMPK);

CREATE INDEX IdxsourcePK_1090Sn ON cmspagesfornavn1090sn (sourcePK);

CREATE INDEX IdxtargetPK_1090Sn ON cmspagesfornavn1090sn (targetPK);

CREATE INDEX IdxlanguagePK_1090Sn ON cmspagesfornavn1090sn (languagePK);


CREATE CACHED TABLE cmspagesfornavnodes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1090 ON cmspagesfornavnodes (SourcePK);

CREATE INDEX qualifier_1090 ON cmspagesfornavnodes (Qualifier);

CREATE INDEX rseqnr_1090 ON cmspagesfornavnodes (RSequenceNumber);

CREATE INDEX linktarget_1090 ON cmspagesfornavnodes (TargetPK);

CREATE INDEX seqnr_1090 ON cmspagesfornavnodes (SequenceNumber);


CREATE CACHED TABLE cmspreviewticke1067sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1067Sn ON cmspreviewticke1067sn (ITEMPK);


CREATE CACHED TABLE cmspreviewticket
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_previewdata BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE cmsrelations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE cmsrelations1100sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1100Sn ON cmsrelations1100sn (ITEMPK);


CREATE CACHED TABLE cmssite
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_theme BIGINT,
    p_defaultlanguage BIGINT,
    p_channel BIGINT,
    p_defaultpromotiongroup BIGINT,
    p_solrfacetsearchconfiguration BIGINT,
    p_cxconfig BIGINT,
    p_cartremovalage INTEGER,
    p_anonymouscartremovalage INTEGER,
    p_cartremovalcronjob BIGINT,
    p_uncollectedorderscronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_urlpatterns LONGVARBINARY,
    p_active TINYINT,
    p_activefrom TIMESTAMP,
    p_activeuntil TIMESTAMP,
    p_defaultcatalog BIGINT,
    p_startingpage BIGINT,
    p_redirecturl NVARCHAR(255),
    p_previewurl NVARCHAR(255),
    p_openpreviewinnewtab TINYINT,
    p_defaultpreviewcategory BIGINT,
    p_defaultpreviewproduct BIGINT,
    p_defaultpreviewcatalog BIGINT,
    p_urlencodingattributes LONGVARBINARY,
    p_sitemaps LONGVARCHAR,
    p_sitemapconfig BIGINT,
    p_defaultstocklevelthreshold INTEGER,
    PRIMARY KEY (PK)
);

CREATE INDEX cxconfigRelIDX_1064 ON cmssite (p_cxconfig);

CREATE INDEX cartremovalcronjobRelIDX_1064 ON cmssite (p_cartremovalcronjob);

CREATE INDEX uncollectedorderscronjobRelIDX_1064 ON cmssite (p_uncollectedorderscronjob);


CREATE CACHED TABLE cmssite1064sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1064Sn ON cmssite1064sn (ITEMPK);


CREATE CACHED TABLE cmssitelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_locale NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE cmsversion
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_transactionid NVARCHAR(255),
    p_itemuid NVARCHAR(255),
    p_itemtypecode NVARCHAR(255),
    p_itemcatalogversion BIGINT,
    p_label NVARCHAR(255),
    p_description NVARCHAR(255),
    p_retain TINYINT,
    p_payload LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX cmsVersionUniqueIDX_1104 ON cmsversion (p_uid);

CREATE INDEX cmsVersionsByItemIDX_1104 ON cmsversion (p_itemuid, p_itemcatalogversion);

CREATE INDEX cmsVersionByLabelIDX_1104 ON cmsversion (p_label);

CREATE INDEX cmsVersionByTransactionIDX_1104 ON cmsversion (p_transactionid);


CREATE CACHED TABLE cmsversion1104sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1104Sn ON cmsversion1104sn (ITEMPK);


CREATE CACHED TABLE cmsversion2cmsv1106sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1106Sn ON cmsversion2cmsv1106sn (ITEMPK);

CREATE INDEX IdxsourcePK_1106Sn ON cmsversion2cmsv1106sn (sourcePK);

CREATE INDEX IdxtargetPK_1106Sn ON cmsversion2cmsv1106sn (targetPK);

CREATE INDEX IdxlanguagePK_1106Sn ON cmsversion2cmsv1106sn (languagePK);


CREATE CACHED TABLE cmsversion2cmsversion
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1106 ON cmsversion2cmsversion (SourcePK);

CREATE INDEX qualifier_1106 ON cmsversion2cmsversion (Qualifier);

CREATE INDEX rseqnr_1106 ON cmsversion2cmsversion (RSequenceNumber);

CREATE INDEX linktarget_1106 ON cmsversion2cmsversion (TargetPK);

CREATE INDEX seqnr_1106 ON cmsversion2cmsversion (SequenceNumber);


CREATE CACHED TABLE codegenerationc5405sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5405Sn ON codegenerationc5405sn (ITEMPK);


CREATE CACHED TABLE codegenerationconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_codeseparator NVARCHAR(255),
    p_couponpartcount INTEGER,
    p_couponpartlength INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE collectiontypes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_extensionname NVARCHAR(255),
    p_autocreate TINYINT,
    p_generate TINYINT,
    InternalCode NVARCHAR(255),
    p_defaultvalue LONGVARBINARY,
    ElementTypePK BIGINT,
    typeOfCollection INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    InternalCodeLowerCase NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX typecode_83 ON collectiontypes (InternalCode);

CREATE INDEX typecodelowercase_83 ON collectiontypes (InternalCodeLowerCase);


CREATE CACHED TABLE collectiontypes83sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_83Sn ON collectiontypes83sn (ITEMPK);


CREATE CACHED TABLE collectiontypeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE combinedcatsfor5022sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5022Sn ON combinedcatsfor5022sn (ITEMPK);


CREATE CACHED TABLE combinedcatsforrule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_rule BIGINT,
    p_conditionid INTEGER,
    p_categorycode NVARCHAR(255),
    p_promotion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX CombinedCatsForRule_IDX_5022 ON combinedcatsforrule (p_rule, p_categorycode, p_conditionid, p_promotion, TypePkString);

CREATE INDEX CombinedCatsForRuleItemType_IDX_5022 ON combinedcatsforrule (TypePkString);


CREATE CACHED TABLE commentassignre1148sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1148Sn ON commentassignre1148sn (ITEMPK);

CREATE INDEX IdxsourcePK_1148Sn ON commentassignre1148sn (sourcePK);

CREATE INDEX IdxtargetPK_1148Sn ON commentassignre1148sn (targetPK);

CREATE INDEX IdxlanguagePK_1148Sn ON commentassignre1148sn (languagePK);


CREATE CACHED TABLE commentassignrelations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1148 ON commentassignrelations (SourcePK);

CREATE INDEX qualifier_1148 ON commentassignrelations (Qualifier);

CREATE INDEX rseqnr_1148 ON commentassignrelations (RSequenceNumber);

CREATE INDEX linktarget_1148 ON commentassignrelations (TargetPK);

CREATE INDEX seqnr_1148 ON commentassignrelations (SequenceNumber);


CREATE CACHED TABLE commentattachme1146sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1146Sn ON commentattachme1146sn (ITEMPK);


CREATE CACHED TABLE commentattachments
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_item BIGINT,
    p_abstractcomment BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX comm_att_comment_1146 ON commentattachments (p_abstractcomment);


CREATE CACHED TABLE commentcompcrea1152sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1152Sn ON commentcompcrea1152sn (ITEMPK);

CREATE INDEX IdxsourcePK_1152Sn ON commentcompcrea1152sn (sourcePK);

CREATE INDEX IdxtargetPK_1152Sn ON commentcompcrea1152sn (targetPK);

CREATE INDEX IdxlanguagePK_1152Sn ON commentcompcrea1152sn (languagePK);


CREATE CACHED TABLE commentcompcreaterels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1152 ON commentcompcreaterels (SourcePK);

CREATE INDEX qualifier_1152 ON commentcompcreaterels (Qualifier);

CREATE INDEX rseqnr_1152 ON commentcompcreaterels (RSequenceNumber);

CREATE INDEX linktarget_1152 ON commentcompcreaterels (TargetPK);

CREATE INDEX seqnr_1152 ON commentcompcreaterels (SequenceNumber);


CREATE CACHED TABLE commentcomponen1142sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1142Sn ON commentcomponen1142sn (ITEMPK);


CREATE CACHED TABLE commentcomponents
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_name NVARCHAR(255),
    p_domain BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX commComponent_code_1142 ON commentcomponents (p_code);

CREATE INDEX domainRelIDX_1142 ON commentcomponents (p_domain);


CREATE CACHED TABLE commentcompread1150sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1150Sn ON commentcompread1150sn (ITEMPK);

CREATE INDEX IdxsourcePK_1150Sn ON commentcompread1150sn (sourcePK);

CREATE INDEX IdxtargetPK_1150Sn ON commentcompread1150sn (targetPK);

CREATE INDEX IdxlanguagePK_1150Sn ON commentcompread1150sn (languagePK);


CREATE CACHED TABLE commentcompreadrels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1150 ON commentcompreadrels (SourcePK);

CREATE INDEX qualifier_1150 ON commentcompreadrels (Qualifier);

CREATE INDEX rseqnr_1150 ON commentcompreadrels (RSequenceNumber);

CREATE INDEX linktarget_1150 ON commentcompreadrels (TargetPK);

CREATE INDEX seqnr_1150 ON commentcompreadrels (SequenceNumber);


CREATE CACHED TABLE commentcompremo1153sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1153Sn ON commentcompremo1153sn (ITEMPK);

CREATE INDEX IdxsourcePK_1153Sn ON commentcompremo1153sn (sourcePK);

CREATE INDEX IdxtargetPK_1153Sn ON commentcompremo1153sn (targetPK);

CREATE INDEX IdxlanguagePK_1153Sn ON commentcompremo1153sn (languagePK);


CREATE CACHED TABLE commentcompremoverels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1153 ON commentcompremoverels (SourcePK);

CREATE INDEX qualifier_1153 ON commentcompremoverels (Qualifier);

CREATE INDEX rseqnr_1153 ON commentcompremoverels (RSequenceNumber);

CREATE INDEX linktarget_1153 ON commentcompremoverels (TargetPK);

CREATE INDEX seqnr_1153 ON commentcompremoverels (SequenceNumber);


CREATE CACHED TABLE commentcompwrit1151sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1151Sn ON commentcompwrit1151sn (ITEMPK);

CREATE INDEX IdxsourcePK_1151Sn ON commentcompwrit1151sn (sourcePK);

CREATE INDEX IdxtargetPK_1151Sn ON commentcompwrit1151sn (targetPK);

CREATE INDEX IdxlanguagePK_1151Sn ON commentcompwrit1151sn (languagePK);


CREATE CACHED TABLE commentcompwriterels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1151 ON commentcompwriterels (SourcePK);

CREATE INDEX qualifier_1151 ON commentcompwriterels (Qualifier);

CREATE INDEX rseqnr_1151 ON commentcompwriterels (RSequenceNumber);

CREATE INDEX linktarget_1151 ON commentcompwriterels (TargetPK);

CREATE INDEX seqnr_1151 ON commentcompwriterels (SequenceNumber);


CREATE CACHED TABLE commentdomains
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_name NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX commDomain_code_1141 ON commentdomains (p_code);


CREATE CACHED TABLE commentdomains1141sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1141Sn ON commentdomains1141sn (ITEMPK);


CREATE CACHED TABLE commentitemrela1147sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1147Sn ON commentitemrela1147sn (ITEMPK);

CREATE INDEX IdxsourcePK_1147Sn ON commentitemrela1147sn (sourcePK);

CREATE INDEX IdxtargetPK_1147Sn ON commentitemrela1147sn (targetPK);

CREATE INDEX IdxlanguagePK_1147Sn ON commentitemrela1147sn (languagePK);


CREATE CACHED TABLE commentitemrelations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1147 ON commentitemrelations (SourcePK);

CREATE INDEX qualifier_1147 ON commentitemrelations (Qualifier);

CREATE INDEX rseqnr_1147 ON commentitemrelations (RSequenceNumber);

CREATE INDEX linktarget_1147 ON commentitemrelations (TargetPK);

CREATE INDEX seqnr_1147 ON commentitemrelations (SequenceNumber);


CREATE CACHED TABLE comments
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_subject NVARCHAR(255),
    p_author BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_code NVARCHAR(255),
    p_priority INTEGER,
    p_component BIGINT,
    p_commenttype BIGINT,
    p_startdatetime TIMESTAMP,
    p_enddatetime TIMESTAMP,
    p_interventiontype BIGINT,
    p_reason BIGINT,
    p_resolutiontype BIGINT,
    p_parentpos INTEGER,
    p_parent BIGINT,
    p_commentpos INTEGER,
    p_comment BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX comment_code_1140 ON comments (p_code);

CREATE INDEX comment_component_1140 ON comments (p_component);

CREATE INDEX reply_parent_1140 ON comments (p_parent);

CREATE INDEX reply_comment_1140 ON comments (p_comment);

CREATE INDEX parentposPosIDX_1140 ON comments (p_parentpos);

CREATE INDEX commentposPosIDX_1140 ON comments (p_commentpos);

CREATE INDEX authorRelIDX_1140 ON comments (p_author);

CREATE INDEX commenttypeRelIDX_1140 ON comments (p_commenttype);


CREATE CACHED TABLE comments1140sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1140Sn ON comments1140sn (ITEMPK);


CREATE CACHED TABLE commenttypes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_name NVARCHAR(255),
    p_metatype BIGINT,
    p_domain BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX comment_type_code_1145 ON commenttypes (p_code, p_domain);

CREATE INDEX domainRelIDX_1145 ON commenttypes (p_domain);


CREATE CACHED TABLE commenttypes1145sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1145Sn ON commenttypes1145sn (ITEMPK);


CREATE CACHED TABLE commentusersett1144sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1144Sn ON commentusersett1144sn (ITEMPK);


CREATE CACHED TABLE commentusersettings
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_read TINYINT,
    p_ignored TINYINT,
    p_priority INTEGER,
    p_comment BIGINT,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX cus_user_comment_1144 ON commentusersettings (p_user, p_comment);

CREATE INDEX commentRelIDX_1144 ON commentusersettings (p_comment);

CREATE INDEX userRelIDX_1144 ON commentusersettings (p_user);


CREATE CACHED TABLE commentwatchrel1149sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1149Sn ON commentwatchrel1149sn (ITEMPK);

CREATE INDEX IdxsourcePK_1149Sn ON commentwatchrel1149sn (sourcePK);

CREATE INDEX IdxtargetPK_1149Sn ON commentwatchrel1149sn (targetPK);

CREATE INDEX IdxlanguagePK_1149Sn ON commentwatchrel1149sn (languagePK);


CREATE CACHED TABLE commentwatchrelations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1149 ON commentwatchrelations (SourcePK);

CREATE INDEX qualifier_1149 ON commentwatchrelations (Qualifier);

CREATE INDEX rseqnr_1149 ON commentwatchrelations (RSequenceNumber);

CREATE INDEX linktarget_1149 ON commentwatchrelations (TargetPK);

CREATE INDEX seqnr_1149 ON commentwatchrelations (SequenceNumber);


CREATE CACHED TABLE componenttypegr1098sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1098Sn ON componenttypegr1098sn (ITEMPK);


CREATE CACHED TABLE componenttypegrp
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE componenttypegrplp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE componenttypesf1093sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1093Sn ON componenttypesf1093sn (ITEMPK);

CREATE INDEX IdxsourcePK_1093Sn ON componenttypesf1093sn (sourcePK);

CREATE INDEX IdxtargetPK_1093Sn ON componenttypesf1093sn (targetPK);

CREATE INDEX IdxlanguagePK_1093Sn ON componenttypesf1093sn (languagePK);


CREATE CACHED TABLE componenttypesf1094sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1094Sn ON componenttypesf1094sn (ITEMPK);

CREATE INDEX IdxsourcePK_1094Sn ON componenttypesf1094sn (sourcePK);

CREATE INDEX IdxtargetPK_1094Sn ON componenttypesf1094sn (targetPK);

CREATE INDEX IdxlanguagePK_1094Sn ON componenttypesf1094sn (languagePK);


CREATE CACHED TABLE componenttypesforsite
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1093 ON componenttypesforsite (SourcePK);

CREATE INDEX qualifier_1093 ON componenttypesforsite (Qualifier);

CREATE INDEX rseqnr_1093 ON componenttypesforsite (RSequenceNumber);

CREATE INDEX linktarget_1093 ON componenttypesforsite (TargetPK);

CREATE INDEX seqnr_1093 ON componenttypesforsite (SequenceNumber);


CREATE CACHED TABLE componenttypesforslots
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1094 ON componenttypesforslots (SourcePK);

CREATE INDEX qualifier_1094 ON componenttypesforslots (Qualifier);

CREATE INDEX rseqnr_1094 ON componenttypesforslots (RSequenceNumber);

CREATE INDEX linktarget_1094 ON componenttypesforslots (TargetPK);

CREATE INDEX seqnr_1094 ON componenttypesforslots (SequenceNumber);


CREATE CACHED TABLE composedindexdt2216sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2216Sn ON composedindexdt2216sn (ITEMPK);


CREATE CACHED TABLE composedindexdtypes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE composedtypes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_extensionname NVARCHAR(255),
    p_autocreate TINYINT,
    p_generate TINYINT,
    InternalCode NVARCHAR(255),
    p_defaultvalue LONGVARBINARY,
    InheritancePathString LONGVARCHAR,
    jaloClassName NVARCHAR(255),
    ItemJNDIName NVARCHAR(255),
    Singleton TINYINT DEFAULT 0,
    p_jaloonly TINYINT,
    p_dynamic TINYINT,
    SuperTypePK BIGINT,
    p_legacypersistence TINYINT,
    p_systemtype TINYINT,
    p_catalogitemtype TINYINT,
    p_catalogversionattributequali NVARCHAR(255),
    p_uniquekeyattributequalifier NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    InternalCodeLowerCase NVARCHAR(255),
    removable TINYINT DEFAULT 0,
    propertyTableStatus TINYINT DEFAULT 0,
    ItemTypeCode INTEGER DEFAULT 0,
    p_comparationattribute BIGINT,
    p_localized TINYINT,
    p_sourceattribute BIGINT,
    p_targetattribute BIGINT,
    p_sourcetype BIGINT,
    p_targettype BIGINT,
    p_sourcenavigable TINYINT,
    p_targetnavigable TINYINT,
    p_orderingattribute BIGINT,
    p_localizationattribute BIGINT,
    p_previewdisabled TINYINT,
    PRIMARY KEY (PK)
);

CREATE INDEX ComposedTypeSuperTypePKIDX_82 ON composedtypes (SuperTypePK);

CREATE INDEX inheritpsi_82 ON composedtypes (InheritancePathString);

CREATE INDEX typecode_82 ON composedtypes (InternalCode);

CREATE INDEX typecodelowercase_82 ON composedtypes (InternalCodeLowerCase);


CREATE CACHED TABLE composedtypes82sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_82Sn ON composedtypes82sn (ITEMPK);


CREATE CACHED TABLE composedtypeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE compositeentrie510sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_510Sn ON compositeentrie510sn (ITEMPK);


CREATE CACHED TABLE compositeentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_executablecronjob BIGINT,
    p_triggerablejob BIGINT,
    p_compositecronjobpos INTEGER,
    p_compositecronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX compositecronjobRelIDX_510 ON compositeentries (p_compositecronjob);

CREATE INDEX compositecronjobposPosIDX_510 ON compositeentries (p_compositecronjobpos);


CREATE CACHED TABLE comptypegrp2com1097sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1097Sn ON comptypegrp2com1097sn (ITEMPK);

CREATE INDEX IdxsourcePK_1097Sn ON comptypegrp2com1097sn (sourcePK);

CREATE INDEX IdxtargetPK_1097Sn ON comptypegrp2com1097sn (targetPK);

CREATE INDEX IdxlanguagePK_1097Sn ON comptypegrp2com1097sn (languagePK);


CREATE CACHED TABLE comptypegrp2comptype
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1097 ON comptypegrp2comptype (SourcePK);

CREATE INDEX qualifier_1097 ON comptypegrp2comptype (Qualifier);

CREATE INDEX rseqnr_1097 ON comptypegrp2comptype (RSequenceNumber);

CREATE INDEX linktarget_1097 ON comptypegrp2comptype (TargetPK);

CREATE INDEX seqnr_1097 ON comptypegrp2comptype (SequenceNumber);


CREATE CACHED TABLE configitems
(
    hjmpTS BIGINT,
    PK BIGINT NOT NULL,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    aCLTS BIGINT DEFAULT 0,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE configuratorset130sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_130Sn ON configuratorset130sn (ITEMPK);


CREATE CACHED TABLE configuratorsettings
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_catalogversion BIGINT,
    p_configuratortype BIGINT,
    p_qualifier NVARCHAR(255),
    p_configurationcategorypos INTEGER,
    p_configurationcategory BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIdx_130 ON configuratorsettings (p_catalogversion);

CREATE UNIQUE INDEX idVersionIdx_130 ON configuratorsettings (p_id, p_catalogversion);

CREATE INDEX configurationcategoryRelIDX_130 ON configuratorsettings (p_configurationcategory);

CREATE INDEX configurationcategoryposPosIDX_130 ON configuratorsettings (p_configurationcategorypos);


CREATE CACHED TABLE configuratorsettingslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_textfieldlabel NVARCHAR(255),
    p_textfielddefaultvalue NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE consents
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_customer BIGINT,
    p_consenttemplate BIGINT,
    p_consentgivendate TIMESTAMP,
    p_consentwithdrawndate TIMESTAMP,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX consentCodeIndex_6234 ON consents (p_code);

CREATE INDEX consentCustomerAndTemplateIndex_6234 ON consents (p_customer, p_consenttemplate);

CREATE INDEX consentGivenDateIndex_6234 ON consents (p_consentgivendate);


CREATE CACHED TABLE consents6234sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6234Sn ON consents6234sn (ITEMPK);


CREATE CACHED TABLE consenttemplate6233sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6233Sn ON consenttemplate6233sn (ITEMPK);


CREATE CACHED TABLE consenttemplates
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_version INTEGER,
    p_basesite BIGINT,
    p_exposed TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX consentTemplateIdBaseSiteAndVersionIndex_6233 ON consenttemplates (p_id, p_basesite, p_version);

CREATE INDEX consentTemplateBaseSiteAndVersionIndex_6233 ON consenttemplates (p_basesite, p_version);

CREATE INDEX consentTemplateVersionIndex_6233 ON consenttemplates (p_version);


CREATE CACHED TABLE consenttemplateslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE consignmententr2004sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2004Sn ON consignmententr2004sn (ITEMPK);


CREATE CACHED TABLE consignmententries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_quantity BIGINT,
    p_shippedquantity BIGINT,
    p_orderentry BIGINT,
    p_consignment BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderentryRelIDX_2004 ON consignmententries (p_orderentry);

CREATE INDEX consignmentRelIDX_2004 ON consignmententries (p_consignment);


CREATE CACHED TABLE consignments
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_shippingaddress BIGINT,
    p_deliverymode BIGINT,
    p_nameddeliverydate TIMESTAMP,
    p_shippingdate TIMESTAMP,
    p_trackingid NVARCHAR(255),
    p_carrier NVARCHAR(255),
    p_status BIGINT,
    p_warehouse BIGINT,
    p_order BIGINT,
    p_deliverypointofservice BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX warehouseRelIDX_2003 ON consignments (p_warehouse);

CREATE INDEX orderRelIDX_2003 ON consignments (p_order);


CREATE CACHED TABLE consignments2003sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2003Sn ON consignments2003sn (ITEMPK);


CREATE CACHED TABLE constraintgroup
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_interfacename NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_coveragedomainid NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX CronstraintGroup_idx_982 ON constraintgroup (p_id);


CREATE CACHED TABLE constraintgroup982sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_982Sn ON constraintgroup982sn (ITEMPK);


CREATE CACHED TABLE contentslot
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    p_active TINYINT,
    p_activefrom TIMESTAMP,
    p_activeuntil TIMESTAMP,
    p_originalslot BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE contentslot1066sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1066Sn ON contentslot1066sn (ITEMPK);


CREATE CACHED TABLE contentslotname
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_comptypegroup BIGINT,
    p_templatepos INTEGER,
    p_template BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX templateRelIDX_1078 ON contentslotname (p_template);

CREATE INDEX templateposPosIDX_1078 ON contentslotname (p_templatepos);


CREATE CACHED TABLE contentslotname1078sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1078Sn ON contentslotname1078sn (ITEMPK);


CREATE CACHED TABLE corsconfigprope800sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_800Sn ON corsconfigprope800sn (ITEMPK);


CREATE CACHED TABLE corsconfigproperty
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_context NVARCHAR(255),
    p_key NVARCHAR(255),
    p_value NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX contextKey_800 ON corsconfigproperty (p_context, p_key);


CREATE CACHED TABLE countries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_isocode NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ISOCode_34 ON countries (p_isocode);


CREATE CACHED TABLE countries34sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_34Sn ON countries34sn (ITEMPK);


CREATE CACHED TABLE countrieslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE coupon
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_couponid NVARCHAR(255),
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_active TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_maxredemptionspercustomer INTEGER,
    p_maxtotalredemptions INTEGER,
    p_codegenerationconfiguration BIGINT,
    p_generatedcodes LONGVARCHAR,
    p_alphabet NVARCHAR(255),
    p_signature NVARCHAR(255),
    p_couponcodenumber BIGINT,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX UC_Coupon_5400 ON coupon (p_couponid);


CREATE CACHED TABLE coupon5400sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5400Sn ON coupon5400sn (ITEMPK);


CREATE CACHED TABLE couponlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE couponredemptio5401sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5401Sn ON couponredemptio5401sn (ITEMPK);


CREATE CACHED TABLE couponredemption
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_couponcode NVARCHAR(255),
    p_coupon BIGINT,
    p_order BIGINT,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX IDX_CouponRedemption_5401 ON couponredemption (p_couponcode);


CREATE CACHED TABLE credentials
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_username NVARCHAR(255),
    p_password NVARCHAR(255),
    p_oauthclientdetails BIGINT,
    p_clientid NVARCHAR(255),
    p_oauthurl NVARCHAR(255),
    p_clientsecret NVARCHAR(255),
    p_certificatedata LONGVARCHAR,
    p_privatekey LONGVARCHAR,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX credUniqueIdx_6612 ON credentials (p_id);


CREATE CACHED TABLE credentials6612sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6612Sn ON credentials6612sn (ITEMPK);


CREATE CACHED TABLE cronjobhistorie522sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_522Sn ON cronjobhistorie522sn (ITEMPK);


CREATE CACHED TABLE cronjobhistories
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_cronjobcode NVARCHAR(255),
    p_jobcode NVARCHAR(255),
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_nodeid INTEGER,
    p_scheduled TINYINT,
    p_useruid NVARCHAR(255),
    p_status BIGINT,
    p_result BIGINT,
    p_failuremessage NVARCHAR(255),
    p_progress DOUBLE,
    p_statusline NVARCHAR(255),
    p_cronjobpos INTEGER,
    p_cronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cronjobRelIDX_522 ON cronjobhistories (p_cronjob);

CREATE INDEX cronjobposPosIDX_522 ON cronjobhistories (p_cronjobpos);


CREATE CACHED TABLE cronjobs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_errormode BIGINT,
    p_logtofile TINYINT,
    p_logtodatabase TINYINT,
    p_loglevelfile BIGINT,
    p_logleveldatabase BIGINT,
    p_sessionuser BIGINT,
    p_sessionlanguage BIGINT,
    p_sessioncurrency BIGINT,
    p_active TINYINT,
    p_retry TINYINT,
    p_singleexecutable TINYINT,
    p_emailaddress NVARCHAR(255),
    p_sendemail TINYINT,
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_status BIGINT,
    p_result BIGINT,
    p_nodeid INTEGER,
    p_nodegroup NVARCHAR(255),
    p_runningonclusternode INTEGER,
    p_currentstep BIGINT,
    p_changerecordingenabled TINYINT,
    p_requestabort TINYINT,
    p_requestabortstep TINYINT,
    p_priority INTEGER,
    p_removeonexit TINYINT,
    p_emailnotificationtemplate BIGINT,
    p_alternativedatasourceid NVARCHAR(255),
    p_logsdaysold INTEGER,
    p_logscount INTEGER,
    p_logsoperator BIGINT,
    p_filesdaysold INTEGER,
    p_filescount INTEGER,
    p_filesoperator BIGINT,
    p_querycount INTEGER,
    p_activecronjobhistory BIGINT,
    p_job BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_jobmedia BIGINT,
    p_currentline INTEGER,
    p_lastsuccessfulline INTEGER,
    p_url NVARCHAR(255),
    p_query NVARCHAR(255),
    p_failonunknown TINYINT,
    p_dontneedtotal TINYINT,
    p_rangestart INTEGER,
    p_count INTEGER,
    p_itempks BIGINT,
    p_itemsfound INTEGER,
    p_itemsdeleted INTEGER,
    p_itemsrefused INTEGER,
    p_createsavedvalues TINYINT,
    p_medias LONGVARCHAR,
    p_targetfolder BIGINT,
    p_movedmediascount INTEGER,
    p_mediafolder BIGINT,
    p_timethreshold INTEGER,
    p_versionthreshold INTEGER,
    p_xdaysold INTEGER,
    p_excludecronjobs LONGVARCHAR,
    p_resultcoll LONGVARCHAR,
    p_statuscoll LONGVARCHAR,
    p_encoding BIGINT,
    p_mode BIGINT,
    p_dataexporttarget BIGINT,
    p_mediasexporttarget BIGINT,
    p_exporttemplate BIGINT,
    p_export BIGINT,
    p_itemsexported INTEGER,
    p_itemsmaxcount INTEGER,
    p_itemsskipped INTEGER,
    p_fieldseparator SMALLINT,
    p_quotecharacter SMALLINT,
    p_commentcharacter SMALLINT,
    p_dataexportmediacode NVARCHAR(255),
    p_mediasexportmediacode NVARCHAR(255),
    p_report BIGINT,
    p_converterclass BIGINT,
    p_singlefile TINYINT,
    p_workmedia BIGINT,
    p_mediasmedia BIGINT,
    p_externaldatacollection LONGVARCHAR,
    p_locale NVARCHAR(255),
    p_dumpfileencoding BIGINT,
    p_enablecodeexecution TINYINT,
    p_enableexternalcodeexecution TINYINT,
    p_enableexternalsyntaxparsing TINYINT,
    p_enablehmcsavedvalues TINYINT,
    p_mediastarget NVARCHAR(255),
    p_valuecount INTEGER,
    p_unresolveddatastore BIGINT,
    p_dumpingallowed TINYINT,
    p_unzipmediasmedia TINYINT,
    p_maxthreads INTEGER,
    p_legacymode TINYINT,
    p_processeditemscount INTEGER,
    p_sourceversion BIGINT,
    p_targetversion BIGINT,
    p_missingproducts INTEGER,
    p_newproducts INTEGER,
    p_maxpricetolerance DOUBLE,
    p_searchmissingproducts TINYINT,
    p_searchmissingcategories TINYINT,
    p_searchnewproducts TINYINT,
    p_searchnewcategories TINYINT,
    p_searchpricedifferences TINYINT,
    p_overwriteproductapprovalstat TINYINT,
    p_pricecomparecustomer BIGINT,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    p_dontremoveobjects TINYINT,
    p_notremoveditems BIGINT,
    p_totaldeleteitemcount INTEGER,
    p_currentprocessingitemcount INTEGER,
    p_forceupdate TINYINT,
    p_fullsync TINYINT,
    p_abortoncollidingsync TINYINT,
    p_statusmessage NVARCHAR(255),
    p_rootitem BIGINT,
    p_configname NVARCHAR(255),
    p_reportid NVARCHAR(255),
    p_audit TINYINT,
    p_includedlanguages LONGVARCHAR,
    p_auditreporttemplate BIGINT,
    p_excelfile BIGINT,
    p_referencedcontent BIGINT,
    p_indexeroperation BIGINT,
    p_indexerhints LONGVARBINARY,
    p_facetsearchconfigpos INTEGER,
    p_facetsearchconfig BIGINT,
    p_indextypename NVARCHAR(255),
    p_items LONGVARCHAR,
    p_indexedtype NVARCHAR(255),
    p_indexedproperties LONGVARBINARY,
    p_queryparameterprovider NVARCHAR(255),
    p_language BIGINT,
    p_solrfacetsearchconfigpos INTEGER,
    p_solrfacetsearchconfig BIGINT,
    p_cart BIGINT,
    p_deliveryaddress BIGINT,
    p_paymentaddress BIGINT,
    p_paymentinfo BIGINT,
    p_ordertemplate BIGINT,
    p_order BIGINT,
    p_batchsize INTEGER,
    p_internaldelay INTEGER,
    p_processstates LONGVARCHAR,
    p_maxprocessage NVARCHAR(255),
    p_basesites LONGVARCHAR,
    p_maxresultsage INTEGER,
    p_anonymous TINYINT,
    p_stagnationperiod INTEGER,
    p_eligiblestates NVARCHAR(255),
    p_basestore BIGINT,
    p_cmssite BIGINT,
    p_currency BIGINT,
    p_user BIGINT,
    p_thirdpartyhost NVARCHAR(255),
    p_thirdpartyusername NVARCHAR(255),
    p_thirdpartypassword NVARCHAR(255),
    p_datagenerationpipeline NVARCHAR(255),
    p_contentsite BIGINT,
    p_sitemapurllimitperfile INTEGER,
    p_sourcerules LONGVARCHAR,
    p_srcmodulename NVARCHAR(255),
    p_targetmodulename NVARCHAR(255),
    p_enableincrementalupdate TINYINT,
    p_lockacquired TINYINT,
    p_age INTEGER,
    p_queuetimelimit INTEGER,
    p_sites LONGVARCHAR,
    p_cartremovalage INTEGER,
    p_anonymouscartremovalage INTEGER,
    PRIMARY KEY (PK)
);

CREATE INDEX IdxJob_501 ON cronjobs (p_job);

CREATE INDEX IdxNode_501 ON cronjobs (p_nodeid);

CREATE INDEX IdxActive_501 ON cronjobs (p_active);

CREATE INDEX facetsearchconfigRelIDX_501 ON cronjobs (p_facetsearchconfig);

CREATE INDEX facetsearchconfigposPosIDX_501 ON cronjobs (p_facetsearchconfigpos);

CREATE INDEX solrfacetsearchconfigRelIDX_501 ON cronjobs (p_solrfacetsearchconfig);

CREATE INDEX solrfacetsearchconfigposPosIDX_501 ON cronjobs (p_solrfacetsearchconfigpos);

CREATE INDEX ordertemplateRelIDX_501 ON cronjobs (p_ordertemplate);

CREATE INDEX cartRelIDX_501 ON cronjobs (p_cart);

CREATE INDEX deliveryaddressRelIDX_501 ON cronjobs (p_deliveryaddress);

CREATE INDEX paymentaddressRelIDX_501 ON cronjobs (p_paymentaddress);

CREATE INDEX paymentinfoRelIDX_501 ON cronjobs (p_paymentinfo);

CREATE INDEX orderRelIDX_501 ON cronjobs (p_order);


CREATE CACHED TABLE cronjobs501sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_501Sn ON cronjobs501sn (ITEMPK);


CREATE CACHED TABLE cronjobslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE csagentgroup2ba9007sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9007Sn ON csagentgroup2ba9007sn (ITEMPK);

CREATE INDEX IdxsourcePK_9007Sn ON csagentgroup2ba9007sn (sourcePK);

CREATE INDEX IdxtargetPK_9007Sn ON csagentgroup2ba9007sn (targetPK);

CREATE INDEX IdxlanguagePK_9007Sn ON csagentgroup2ba9007sn (languagePK);


CREATE CACHED TABLE csagentgroup2basestore
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_9007 ON csagentgroup2basestore (SourcePK);

CREATE INDEX qualifier_9007 ON csagentgroup2basestore (Qualifier);

CREATE INDEX rseqnr_9007 ON csagentgroup2basestore (RSequenceNumber);

CREATE INDEX linktarget_9007 ON csagentgroup2basestore (TargetPK);

CREATE INDEX seqnr_9007 ON csagentgroup2basestore (SequenceNumber);


CREATE CACHED TABLE cschangeeventen9004sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9004Sn ON cschangeeventen9004sn (ITEMPK);


CREATE CACHED TABLE cschangeevententry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_alteredattribute BIGINT,
    p_oldstringvalue NVARCHAR(255),
    p_newstringvalue NVARCHAR(255),
    p_oldbinaryvalue LONGVARBINARY,
    p_newbinaryvalue LONGVARBINARY,
    p_event BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_oldvalue NVARCHAR(255),
    p_newvalue NVARCHAR(255),
    p_oldvalu0 BIGINT,
    p_newvalu0 BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX eventRelIDX_9004 ON cschangeevententry (p_event);


CREATE CACHED TABLE csticketemail
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_messageid NVARCHAR(255),
    p_from NVARCHAR(255),
    p_to NVARCHAR(255),
    p_subject NVARCHAR(255),
    p_body LONGVARCHAR,
    p_ticketpos INTEGER,
    p_ticket BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ticketRelIDX_9003 ON csticketemail (p_ticket);

CREATE INDEX ticketposPosIDX_9003 ON csticketemail (p_ticketpos);


CREATE CACHED TABLE csticketemail9003sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9003Sn ON csticketemail9003sn (ITEMPK);


CREATE CACHED TABLE csticketeventem9005sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9005Sn ON csticketeventem9005sn (ITEMPK);


CREATE CACHED TABLE csticketeventemailconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_plaintexttemplate BIGINT,
    p_htmltemplate BIGINT,
    p_subject NVARCHAR(255),
    p_eventtype BIGINT,
    p_alteredattributes LONGVARCHAR,
    p_recipienttype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE cstickets
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_ticketid NVARCHAR(255),
    p_customer BIGINT,
    p_order BIGINT,
    p_headline NVARCHAR(255),
    p_category BIGINT,
    p_priority BIGINT,
    p_state BIGINT,
    p_assignedagent BIGINT,
    p_assignedgroup BIGINT,
    p_resolution BIGINT,
    p_basesite BIGINT,
    p_retentiondate TIMESTAMP,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ticketIdIdx_9001 ON cstickets (p_ticketid);

CREATE INDEX ticketPoolIdx_9001 ON cstickets (p_assignedagent, p_assignedgroup, p_state);


CREATE CACHED TABLE cstickets9001sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9001Sn ON cstickets9001sn (ITEMPK);


CREATE CACHED TABLE cstrgr2abscstrr979sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_979Sn ON cstrgr2abscstrr979sn (ITEMPK);

CREATE INDEX IdxsourcePK_979Sn ON cstrgr2abscstrr979sn (sourcePK);

CREATE INDEX IdxtargetPK_979Sn ON cstrgr2abscstrr979sn (targetPK);

CREATE INDEX IdxlanguagePK_979Sn ON cstrgr2abscstrr979sn (languagePK);


CREATE CACHED TABLE cstrgr2abscstrrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_979 ON cstrgr2abscstrrel (SourcePK);

CREATE INDEX qualifier_979 ON cstrgr2abscstrrel (Qualifier);

CREATE INDEX rseqnr_979 ON cstrgr2abscstrrel (RSequenceNumber);

CREATE INDEX linktarget_979 ON cstrgr2abscstrrel (TargetPK);

CREATE INDEX seqnr_979 ON cstrgr2abscstrrel (SequenceNumber);


CREATE CACHED TABLE currencies
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_isocode NVARCHAR(255),
    p_base TINYINT,
    p_conversion DOUBLE,
    p_digits INTEGER,
    p_symbol NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ISOCode_33 ON currencies (p_isocode);


CREATE CACHED TABLE currencies33sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_33Sn ON currencies33sn (ITEMPK);


CREATE CACHED TABLE currencieslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE customerreviews
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_headline NVARCHAR(255),
    p_comment LONGVARCHAR,
    p_rating DOUBLE,
    p_blocked TINYINT,
    p_alias NVARCHAR(255),
    p_approvalstatus BIGINT,
    p_language BIGINT,
    p_user BIGINT,
    p_product BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX userRelIDX_49 ON customerreviews (p_user);

CREATE INDEX productRelIDX_49 ON customerreviews (p_product);


CREATE CACHED TABLE customerreviews49sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_49Sn ON customerreviews49sn (ITEMPK);


CREATE CACHED TABLE customers2permi10013sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10013Sn ON customers2permi10013sn (ITEMPK);

CREATE INDEX IdxsourcePK_10013Sn ON customers2permi10013sn (sourcePK);

CREATE INDEX IdxtargetPK_10013Sn ON customers2permi10013sn (targetPK);

CREATE INDEX IdxlanguagePK_10013Sn ON customers2permi10013sn (languagePK);


CREATE CACHED TABLE customers2permissions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10013 ON customers2permissions (SourcePK);

CREATE INDEX qualifier_10013 ON customers2permissions (Qualifier);

CREATE INDEX rseqnr_10013 ON customers2permissions (RSequenceNumber);

CREATE INDEX linktarget_10013 ON customers2permissions (TargetPK);

CREATE INDEX seqnr_10013 ON customers2permissions (SequenceNumber);


CREATE CACHED TABLE cvsynccronjobhi523sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_523Sn ON cvsynccronjobhi523sn (ITEMPK);


CREATE CACHED TABLE cvsynccronjobhistories
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_cronjobcode NVARCHAR(255),
    p_jobcode NVARCHAR(255),
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_nodeid INTEGER,
    p_scheduled TINYINT,
    p_useruid NVARCHAR(255),
    p_status BIGINT,
    p_result BIGINT,
    p_failuremessage NVARCHAR(255),
    p_progress DOUBLE,
    p_statusline NVARCHAR(255),
    p_cronjobpos INTEGER,
    p_cronjob BIGINT,
    p_processeditemscount INTEGER,
    p_scheduleditemscount INTEGER,
    p_dumpeditemscount INTEGER,
    p_fullsync TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cronjobRelIDX_523 ON cvsynccronjobhistories (p_cronjob);

CREATE INDEX cronjobposPosIDX_523 ON cvsynccronjobhistories (p_cronjobpos);


CREATE CACHED TABLE cxabstractactio3604sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3604Sn ON cxabstractactio3604sn (ITEMPK);


CREATE CACHED TABLE cxabstractaction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_type BIGINT,
    p_target NVARCHAR(255),
    p_catalogversion BIGINT,
    p_variationpos INTEGER,
    p_variation BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_searchprofilecode NVARCHAR(255),
    p_searchprofilecatalog NVARCHAR(255),
    p_componentid NVARCHAR(255),
    p_componentcatalog NVARCHAR(255),
    p_containerid NVARCHAR(255),
    p_promotionid NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeVariationCatalogVersionIdx_3604 ON cxabstractaction (p_code, p_variation, p_catalogversion);

CREATE INDEX variationCatalogVersionIdx_3604 ON cxabstractaction (p_variation, p_catalogversion);

CREATE INDEX variationRelIDX_3604 ON cxabstractaction (p_variation);

CREATE INDEX variationposPosIDX_3604 ON cxabstractaction (p_variationpos);


CREATE CACHED TABLE cxabstractcalcc3616sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3616Sn ON cxabstractcalcc3616sn (ITEMPK);


CREATE CACHED TABLE cxabstractcalcconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_actions LONGVARBINARY,
    p_usertype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE cxabstracttrigg3609sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3609Sn ON cxabstracttrigg3609sn (ITEMPK);


CREATE CACHED TABLE cxabstracttrigger
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_catalogversion BIGINT,
    p_variation BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_groupby BIGINT,
    p_expression LONGVARCHAR,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeVariationCatalogVersionIdx_3609 ON cxabstracttrigger (p_code, p_variation, p_catalogversion);

CREATE INDEX variationCatalogVersionIdx_3609 ON cxabstracttrigger (p_variation, p_catalogversion);

CREATE INDEX variationRelIDX_3609 ON cxabstracttrigger (p_variation);


CREATE CACHED TABLE cxconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_minaffinity DECIMAL(30,8),
    p_actionresultmaxrepeat INTEGER,
    p_userchangedactions LONGVARBINARY,
    p_consentgivenactions LONGVARBINARY,
    p_calculationprocess NVARCHAR(255),
    p_ignorerecalcforanonymous TINYINT,
    p_anonymoususerdefaultactions LONGVARBINARY,
    p_anonymoususeractions LONGVARBINARY,
    p_anonymoususerminrequestnumbe INTEGER,
    p_anonymoususermintime BIGINT,
    p_anonymoususerignoreotheracti TINYINT,
    p_cataloglookup BIGINT,
    p_consenttemplates LONGVARCHAR,
    p_usersegmentsstoreinsession TINYINT,
    p_occpersonalizationenabled TINYINT,
    p_occttl BIGINT,
    p_occpersonalizationidcookieen TINYINT,
    p_containercleanupenabled TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE cxconfig3614sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3614Sn ON cxconfig3614sn (ITEMPK);


CREATE CACHED TABLE cxcustomization
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_catalogversion BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    p_longdescription LONGVARCHAR,
    p_status BIGINT,
    p_enabledstartdate TIMESTAMP,
    p_enabledenddate TIMESTAMP,
    p_grouppos INTEGER,
    p_group BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeCatalogVersionIdx_3602 ON cxcustomization (p_code, p_catalogversion);

CREATE INDEX nameCatalogVersionIdx_3602 ON cxcustomization (p_name, p_catalogversion);

CREATE INDEX catalogVersionIdx_3602 ON cxcustomization (p_catalogversion);

CREATE INDEX groupRelIDX_3602 ON cxcustomization (p_group);

CREATE INDEX groupposPosIDX_3602 ON cxcustomization (p_grouppos);


CREATE CACHED TABLE cxcustomization3602sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3602Sn ON cxcustomization3602sn (ITEMPK);


CREATE CACHED TABLE cxcustomization3608sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3608Sn ON cxcustomization3608sn (ITEMPK);


CREATE CACHED TABLE cxcustomizationsgroup
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX catalogVersionIdx_3608 ON cxcustomizationsgroup (p_catalogversion);


CREATE CACHED TABLE cxperiodicvoter3617sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3617Sn ON cxperiodicvoter3617sn (ITEMPK);


CREATE CACHED TABLE cxperiodicvoterconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_actions LONGVARBINARY,
    p_usertype BIGINT,
    p_usermintime BIGINT,
    p_userminrequestnumber INTEGER,
    p_cxconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cxconfigRelIDX_3617 ON cxperiodicvoterconfig (p_cxconfig);


CREATE CACHED TABLE cxpersproctocat3611sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3611Sn ON cxpersproctocat3611sn (ITEMPK);

CREATE INDEX IdxsourcePK_3611Sn ON cxpersproctocat3611sn (sourcePK);

CREATE INDEX IdxtargetPK_3611Sn ON cxpersproctocat3611sn (targetPK);

CREATE INDEX IdxlanguagePK_3611Sn ON cxpersproctocat3611sn (languagePK);


CREATE CACHED TABLE cxpersproctocatver
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3611 ON cxpersproctocatver (SourcePK);

CREATE INDEX qualifier_3611 ON cxpersproctocatver (Qualifier);

CREATE INDEX rseqnr_3611 ON cxpersproctocatver (RSequenceNumber);

CREATE INDEX linktarget_3611 ON cxpersproctocatver (TargetPK);

CREATE INDEX seqnr_3611 ON cxpersproctocatver (SequenceNumber);


CREATE CACHED TABLE cxresults
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_key NVARCHAR(255),
    p_sessionkey NVARCHAR(255),
    p_catalogversion BIGINT,
    p_results LONGVARBINARY,
    p_calculationtime TIMESTAMP,
    p_anonymous TINYINT,
    p_default TINYINT,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cxResultsKeyIdx_3612 ON cxresults (p_key);

CREATE INDEX cxResultsSessionKeyIdx_3612 ON cxresults (p_sessionkey);

CREATE INDEX userRelIDX_3612 ON cxresults (p_user);


CREATE CACHED TABLE cxresults3612sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3612Sn ON cxresults3612sn (ITEMPK);


CREATE CACHED TABLE cxsegment
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_description LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeIdx_3603 ON cxsegment (p_code);


CREATE CACHED TABLE cxsegment2exptr3615sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3615Sn ON cxsegment2exptr3615sn (ITEMPK);

CREATE INDEX IdxsourcePK_3615Sn ON cxsegment2exptr3615sn (sourcePK);

CREATE INDEX IdxtargetPK_3615Sn ON cxsegment2exptr3615sn (targetPK);

CREATE INDEX IdxlanguagePK_3615Sn ON cxsegment2exptr3615sn (languagePK);


CREATE CACHED TABLE cxsegment2exptrigger
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3615 ON cxsegment2exptrigger (SourcePK);

CREATE INDEX qualifier_3615 ON cxsegment2exptrigger (Qualifier);

CREATE INDEX rseqnr_3615 ON cxsegment2exptrigger (RSequenceNumber);

CREATE INDEX linktarget_3615 ON cxsegment2exptrigger (TargetPK);

CREATE INDEX seqnr_3615 ON cxsegment2exptrigger (SequenceNumber);


CREATE CACHED TABLE cxsegment3603sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3603Sn ON cxsegment3603sn (ITEMPK);


CREATE CACHED TABLE cxsegmenttotrig3610sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3610Sn ON cxsegmenttotrig3610sn (ITEMPK);

CREATE INDEX IdxsourcePK_3610Sn ON cxsegmenttotrig3610sn (sourcePK);

CREATE INDEX IdxtargetPK_3610Sn ON cxsegmenttotrig3610sn (targetPK);

CREATE INDEX IdxlanguagePK_3610Sn ON cxsegmenttotrig3610sn (languagePK);


CREATE CACHED TABLE cxsegmenttotrigger
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3610 ON cxsegmenttotrigger (SourcePK);

CREATE INDEX qualifier_3610 ON cxsegmenttotrigger (Qualifier);

CREATE INDEX rseqnr_3610 ON cxsegmenttotrigger (RSequenceNumber);

CREATE INDEX linktarget_3610 ON cxsegmenttotrigger (TargetPK);

CREATE INDEX seqnr_3610 ON cxsegmenttotrigger (SequenceNumber);


CREATE CACHED TABLE cxurlvoterconfi3613sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3613Sn ON cxurlvoterconfi3613sn (ITEMPK);


CREATE CACHED TABLE cxurlvoterconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_actions LONGVARBINARY,
    p_usertype BIGINT,
    p_urlregexp NVARCHAR(255),
    p_cxconfigpos INTEGER,
    p_cxconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cxconfigRelIDX_3613 ON cxurlvoterconfig (p_cxconfig);

CREATE INDEX cxconfigposPosIDX_3613 ON cxurlvoterconfig (p_cxconfigpos);


CREATE CACHED TABLE cxusertosegment
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_provider NVARCHAR(255),
    p_affinity DECIMAL(30,8),
    p_basesite BIGINT,
    p_segment BIGINT,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX segmentRelIDX_3607 ON cxusertosegment (p_segment);

CREATE INDEX userRelIDX_3607 ON cxusertosegment (p_user);


CREATE CACHED TABLE cxusertosegment3607sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3607Sn ON cxusertosegment3607sn (ITEMPK);


CREATE CACHED TABLE cxvariation
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_catalogversion BIGINT,
    p_name NVARCHAR(255),
    p_enabled TINYINT,
    p_status BIGINT,
    p_customizationpos INTEGER,
    p_customization BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeCustomizationCatalogVersionIdx_3601 ON cxvariation (p_code, p_customization, p_catalogversion);

CREATE INDEX nameCustomizationCatalogVersionIdx_3601 ON cxvariation (p_name, p_customization, p_catalogversion);

CREATE INDEX customizationCatalogVersionIdx_3601 ON cxvariation (p_customization, p_catalogversion);

CREATE INDEX customizationRelIDX_3601 ON cxvariation (p_customization);

CREATE INDEX customizationposPosIDX_3601 ON cxvariation (p_customizationpos);


CREATE CACHED TABLE cxvariation3601sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3601Sn ON cxvariation3601sn (ITEMPK);


CREATE CACHED TABLE deeplinkurlrule2081sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2081Sn ON deeplinkurlrule2081sn (ITEMPK);


CREATE CACHED TABLE deeplinkurlrules
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_baseurlpattern NVARCHAR(255),
    p_desturltemplate NVARCHAR(255),
    p_applicabletype BIGINT,
    p_useforward TINYINT,
    p_priority INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE deeplinkurls
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_name NVARCHAR(255),
    p_baseurl NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE deeplinkurls2080sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2080Sn ON deeplinkurls2080sn (ITEMPK);


CREATE CACHED TABLE deliverymodes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_code NVARCHAR(255),
    p_supportedpaymentmodesinterna NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_propertyname NVARCHAR(255),
    p_net TINYINT,
    p_supportedmode BIGINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE deliverymodes40sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_40Sn ON deliverymodes40sn (ITEMPK);


CREATE CACHED TABLE deliverymodeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description LONGVARCHAR,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE derivedmedias
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_mime NVARCHAR(255),
    p_size BIGINT,
    p_datapk BIGINT,
    p_location LONGVARCHAR,
    p_locationhash NVARCHAR(255),
    p_realfilename NVARCHAR(255),
    p_version NVARCHAR(255),
    p_media BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX dataPK_idx_31 ON derivedmedias (p_datapk);

CREATE UNIQUE INDEX version_idx_31 ON derivedmedias (p_media, p_version);

CREATE INDEX mediaRelIDX_31 ON derivedmedias (p_media);


CREATE CACHED TABLE derivedmedias31sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_31Sn ON derivedmedias31sn (ITEMPK);


CREATE CACHED TABLE destinations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_url NVARCHAR(255),
    p_active TINYINT,
    p_additionalproperties LONGVARBINARY,
    p_credential BIGINT,
    p_endpoint BIGINT,
    p_destinationtarget BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_targetid NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX destUniqueIdx_6611 ON destinations (p_id, p_destinationtarget);

CREATE INDEX endpointRelIDX_6611 ON destinations (p_endpoint);

CREATE INDEX destinationtargetRelIDX_6611 ON destinations (p_destinationtarget);


CREATE CACHED TABLE destinations6611sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6611Sn ON destinations6611sn (ITEMPK);


CREATE CACHED TABLE destinationtarg6615sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6615Sn ON destinationtarg6615sn (ITEMPK);


CREATE CACHED TABLE destinationtarget
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_destinationchannel BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE discountrows
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_product BIGINT,
    p_pg BIGINT,
    p_productmatchqualifier BIGINT,
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_user BIGINT,
    p_ug BIGINT,
    p_usermatchqualifier BIGINT,
    p_productid NVARCHAR(255),
    p_currency BIGINT,
    p_discount BIGINT,
    p_value DOUBLE,
    p_catalogversion BIGINT,
    p_astargetprice TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX MatchIndexP_1052 ON discountrows (p_productmatchqualifier);

CREATE INDEX MatchIndexU_1052 ON discountrows (p_usermatchqualifier);

CREATE INDEX PIdx_1052 ON discountrows (p_product);

CREATE INDEX UIdx_1052 ON discountrows (p_user);

CREATE INDEX PGIdx_1052 ON discountrows (p_pg);

CREATE INDEX UGIdx_1052 ON discountrows (p_ug);

CREATE INDEX ProductIdIdx_1052 ON discountrows (p_productid);

CREATE INDEX versionIDX_1052 ON discountrows (p_catalogversion);


CREATE CACHED TABLE discountrows1052sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1052Sn ON discountrows1052sn (ITEMPK);


CREATE CACHED TABLE discounts
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_currency BIGINT,
    p_global TINYINT,
    p_priority INTEGER,
    p_value DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_freeshipping TINYINT,
    p_codes LONGVARCHAR,
    p_vouchercode NVARCHAR(255),
    p_redemptionquantitylimit INTEGER,
    p_redemptionquantitylimitperus INTEGER,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIDX_48 ON discounts (p_code);


CREATE CACHED TABLE discounts48sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_48Sn ON discounts48sn (ITEMPK);


CREATE CACHED TABLE discountslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE distributedbatc112sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_112Sn ON distributedbatc112sn (ITEMPK);


CREATE CACHED TABLE distributedbatches
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_executionid NVARCHAR(255),
    p_type BIGINT,
    p_remainingworkload BIGINT,
    p_process BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_resultbatchid NVARCHAR(255),
    p_retries INTEGER,
    p_scriptcode NVARCHAR(255),
    p_context LONGVARBINARY,
    p_group INTEGER,
    p_metadata NVARCHAR(255),
    p_importcontentcode NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX BatchUnqIdx_112 ON distributedbatches (p_executionid, p_process, p_id, p_type);

CREATE INDEX processRelIDX_112 ON distributedbatches (p_process);


CREATE CACHED TABLE distributedproc111sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_111Sn ON distributedproc111sn (ITEMPK);


CREATE CACHED TABLE distributedprocesses
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_handlerbeanid NVARCHAR(255),
    p_currentexecutionid NVARCHAR(255),
    p_state BIGINT,
    p_stoprequested TINYINT,
    p_nodegroup NVARCHAR(255),
    p_status NVARCHAR(255),
    p_extendedstatus NVARCHAR(255),
    p_progress DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_batchsize INTEGER,
    p_sessionuser NVARCHAR(255),
    p_sessionlanguage NVARCHAR(255),
    p_sessioncurrency NVARCHAR(255),
    p_indexoperationid BIGINT,
    p_indexoperation BIGINT,
    p_externalindexoperation TINYINT,
    p_facetsearchconfig NVARCHAR(255),
    p_indexedtype NVARCHAR(255),
    p_indexedproperties LONGVARBINARY,
    p_index NVARCHAR(255),
    p_indexerhints LONGVARBINARY,
    p_impeximportcronjob BIGINT,
    p_metadata NVARCHAR(255),
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE droolskiebase
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_equalitybehavior BIGINT,
    p_eventprocessingmode BIGINT,
    p_defaultkiesession BIGINT,
    p_kiemodule BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX kiemoduleRelIDX_5200 ON droolskiebase (p_kiemodule);


CREATE CACHED TABLE droolskiebase5200sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5200Sn ON droolskiebase5200sn (ITEMPK);


CREATE CACHED TABLE droolskiemodule5251sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5251Sn ON droolskiemodule5251sn (ITEMPK);


CREATE CACHED TABLE droolskiemodulemedia
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_mime NVARCHAR(255),
    p_size BIGINT,
    p_datapk BIGINT,
    p_location LONGVARCHAR,
    p_locationhash NVARCHAR(255),
    p_realfilename NVARCHAR(255),
    p_code NVARCHAR(255),
    p_internalurl LONGVARCHAR,
    p_description NVARCHAR(255),
    p_alttext NVARCHAR(255),
    p_removable TINYINT,
    p_mediaformat BIGINT,
    p_folder BIGINT,
    p_subfolderpath NVARCHAR(255),
    p_mediacontainer BIGINT,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    p_kiemodulename NVARCHAR(255),
    p_releaseid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX dataPK_idx_5251 ON droolskiemodulemedia (p_datapk);

CREATE INDEX Media_Code_5251 ON droolskiemodulemedia (p_code);

CREATE INDEX versionIDX_5251 ON droolskiemodulemedia (p_catalogversion);

CREATE UNIQUE INDEX codeVersionIDX_5251 ON droolskiemodulemedia (p_code, p_catalogversion);

CREATE UNIQUE INDEX IdxDroolsKIEModuleMediaLookup_5251 ON droolskiemodulemedia (p_kiemodulename, p_releaseid);

CREATE INDEX mediacontainerRelIDX_5251 ON droolskiemodulemedia (p_mediacontainer);


CREATE CACHED TABLE droolskiesessio5201sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5201Sn ON droolskiesessio5201sn (ITEMPK);


CREATE CACHED TABLE droolskiesession
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_sessiontype BIGINT,
    p_kiebase BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX kiebaseRelIDX_5201 ON droolskiesession (p_kiebase);


CREATE CACHED TABLE dynamiccontent
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_active TINYINT,
    p_checksum NVARCHAR(255),
    p_content LONGVARCHAR,
    p_version BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeVersionActiveIDX_101 ON dynamiccontent (p_code, p_version, p_active);


CREATE CACHED TABLE dynamiccontent101sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_101Sn ON dynamiccontent101sn (ITEMPK);


CREATE CACHED TABLE elements4contai1077sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1077Sn ON elements4contai1077sn (ITEMPK);

CREATE INDEX IdxsourcePK_1077Sn ON elements4contai1077sn (sourcePK);

CREATE INDEX IdxtargetPK_1077Sn ON elements4contai1077sn (targetPK);

CREATE INDEX IdxlanguagePK_1077Sn ON elements4contai1077sn (languagePK);


CREATE CACHED TABLE elements4container
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1077 ON elements4container (SourcePK);

CREATE INDEX qualifier_1077 ON elements4container (Qualifier);

CREATE INDEX rseqnr_1077 ON elements4container (RSequenceNumber);

CREATE INDEX linktarget_1077 ON elements4container (TargetPK);

CREATE INDEX seqnr_1077 ON elements4container (SequenceNumber);


CREATE CACHED TABLE elements4slots
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1085 ON elements4slots (SourcePK);

CREATE INDEX qualifier_1085 ON elements4slots (Qualifier);

CREATE INDEX rseqnr_1085 ON elements4slots (RSequenceNumber);

CREATE INDEX linktarget_1085 ON elements4slots (TargetPK);

CREATE INDEX seqnr_1085 ON elements4slots (SequenceNumber);


CREATE CACHED TABLE elements4slots1085sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1085Sn ON elements4slots1085sn (ITEMPK);

CREATE INDEX IdxsourcePK_1085Sn ON elements4slots1085sn (sourcePK);

CREATE INDEX IdxtargetPK_1085Sn ON elements4slots1085sn (targetPK);

CREATE INDEX IdxlanguagePK_1085Sn ON elements4slots1085sn (languagePK);


CREATE CACHED TABLE emailaddress
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_emailaddress NVARCHAR(255),
    p_displayname NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX EmailAddress_6207 ON emailaddress (p_emailaddress, p_displayname);


CREATE CACHED TABLE emailaddress6207sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6207Sn ON emailaddress6207sn (ITEMPK);


CREATE CACHED TABLE emailmessage
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_sent TINYINT,
    p_replytoaddress NVARCHAR(255),
    p_subject LONGVARCHAR,
    p_body LONGVARCHAR,
    p_bodymedia BIGINT,
    p_sentdate TIMESTAMP,
    p_sentmessageid NVARCHAR(255),
    p_fromaddress BIGINT,
    p_process BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX EmailMessageSent_6208 ON emailmessage (p_sent);

CREATE INDEX fromaddressRelIDX_6208 ON emailmessage (p_fromaddress);

CREATE INDEX processRelIDX_6208 ON emailmessage (p_process);


CREATE CACHED TABLE emailmessage6208sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6208Sn ON emailmessage6208sn (ITEMPK);


CREATE CACHED TABLE emailmsg2bccadd6204sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6204Sn ON emailmsg2bccadd6204sn (ITEMPK);

CREATE INDEX IdxsourcePK_6204Sn ON emailmsg2bccadd6204sn (sourcePK);

CREATE INDEX IdxtargetPK_6204Sn ON emailmsg2bccadd6204sn (targetPK);

CREATE INDEX IdxlanguagePK_6204Sn ON emailmsg2bccadd6204sn (languagePK);


CREATE CACHED TABLE emailmsg2bccaddrrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6204 ON emailmsg2bccaddrrel (SourcePK);

CREATE INDEX qualifier_6204 ON emailmsg2bccaddrrel (Qualifier);

CREATE INDEX rseqnr_6204 ON emailmsg2bccaddrrel (RSequenceNumber);

CREATE INDEX linktarget_6204 ON emailmsg2bccaddrrel (TargetPK);

CREATE INDEX seqnr_6204 ON emailmsg2bccaddrrel (SequenceNumber);


CREATE CACHED TABLE emailmsg2ccaddr6203sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6203Sn ON emailmsg2ccaddr6203sn (ITEMPK);

CREATE INDEX IdxsourcePK_6203Sn ON emailmsg2ccaddr6203sn (sourcePK);

CREATE INDEX IdxtargetPK_6203Sn ON emailmsg2ccaddr6203sn (targetPK);

CREATE INDEX IdxlanguagePK_6203Sn ON emailmsg2ccaddr6203sn (languagePK);


CREATE CACHED TABLE emailmsg2ccaddrrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6203 ON emailmsg2ccaddrrel (SourcePK);

CREATE INDEX qualifier_6203 ON emailmsg2ccaddrrel (Qualifier);

CREATE INDEX rseqnr_6203 ON emailmsg2ccaddrrel (RSequenceNumber);

CREATE INDEX linktarget_6203 ON emailmsg2ccaddrrel (TargetPK);

CREATE INDEX seqnr_6203 ON emailmsg2ccaddrrel (SequenceNumber);


CREATE CACHED TABLE emailmsg2toaddr6202sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6202Sn ON emailmsg2toaddr6202sn (ITEMPK);

CREATE INDEX IdxsourcePK_6202Sn ON emailmsg2toaddr6202sn (sourcePK);

CREATE INDEX IdxtargetPK_6202Sn ON emailmsg2toaddr6202sn (targetPK);

CREATE INDEX IdxlanguagePK_6202Sn ON emailmsg2toaddr6202sn (languagePK);


CREATE CACHED TABLE emailmsg2toaddrrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6202 ON emailmsg2toaddrrel (SourcePK);

CREATE INDEX qualifier_6202 ON emailmsg2toaddrrel (Qualifier);

CREATE INDEX rseqnr_6202 ON emailmsg2toaddrrel (RSequenceNumber);

CREATE INDEX linktarget_6202 ON emailmsg2toaddrrel (TargetPK);

CREATE INDEX seqnr_6202 ON emailmsg2toaddrrel (SequenceNumber);


CREATE CACHED TABLE empl2apprgrpsre10009sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10009Sn ON empl2apprgrpsre10009sn (ITEMPK);

CREATE INDEX IdxsourcePK_10009Sn ON empl2apprgrpsre10009sn (sourcePK);

CREATE INDEX IdxtargetPK_10009Sn ON empl2apprgrpsre10009sn (targetPK);

CREATE INDEX IdxlanguagePK_10009Sn ON empl2apprgrpsre10009sn (languagePK);


CREATE CACHED TABLE empl2apprgrpsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10009 ON empl2apprgrpsrel (SourcePK);

CREATE INDEX qualifier_10009 ON empl2apprgrpsrel (Qualifier);

CREATE INDEX rseqnr_10009 ON empl2apprgrpsrel (RSequenceNumber);

CREATE INDEX linktarget_10009 ON empl2apprgrpsrel (TargetPK);

CREATE INDEX seqnr_10009 ON empl2apprgrpsrel (SequenceNumber);


CREATE CACHED TABLE empl2apprsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10023 ON empl2apprsrel (SourcePK);

CREATE INDEX qualifier_10023 ON empl2apprsrel (Qualifier);

CREATE INDEX rseqnr_10023 ON empl2apprsrel (RSequenceNumber);

CREATE INDEX linktarget_10023 ON empl2apprsrel (TargetPK);

CREATE INDEX seqnr_10023 ON empl2apprsrel (SequenceNumber);


CREATE CACHED TABLE empl2apprsrel10023sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10023Sn ON empl2apprsrel10023sn (ITEMPK);

CREATE INDEX IdxsourcePK_10023Sn ON empl2apprsrel10023sn (sourcePK);

CREATE INDEX IdxtargetPK_10023Sn ON empl2apprsrel10023sn (targetPK);

CREATE INDEX IdxlanguagePK_10023Sn ON empl2apprsrel10023sn (languagePK);


CREATE CACHED TABLE empl2permgrpsre10012sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10012Sn ON empl2permgrpsre10012sn (ITEMPK);

CREATE INDEX IdxsourcePK_10012Sn ON empl2permgrpsre10012sn (sourcePK);

CREATE INDEX IdxtargetPK_10012Sn ON empl2permgrpsre10012sn (targetPK);

CREATE INDEX IdxlanguagePK_10012Sn ON empl2permgrpsre10012sn (languagePK);


CREATE CACHED TABLE empl2permgrpsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10012 ON empl2permgrpsrel (SourcePK);

CREATE INDEX qualifier_10012 ON empl2permgrpsrel (Qualifier);

CREATE INDEX rseqnr_10012 ON empl2permgrpsrel (RSequenceNumber);

CREATE INDEX linktarget_10012 ON empl2permgrpsrel (TargetPK);

CREATE INDEX seqnr_10012 ON empl2permgrpsrel (SequenceNumber);


CREATE CACHED TABLE endpoints
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_version NVARCHAR(255),
    p_description NVARCHAR(255),
    p_specurl NVARCHAR(255),
    p_specdata LONGVARCHAR,
    p_extensionname NVARCHAR(255),
    p_name NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX endpointUniqueIdx_6610 ON endpoints (p_id, p_version);


CREATE CACHED TABLE endpoints6610sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6610Sn ON endpoints6610sn (ITEMPK);


CREATE CACHED TABLE enginerules
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uuid NVARCHAR(255),
    p_code NVARCHAR(255),
    p_active TINYINT,
    p_rulecontent LONGVARCHAR,
    p_ruletype BIGINT,
    p_checksum NVARCHAR(255),
    p_currentversion TINYINT,
    p_version BIGINT,
    p_ruleparameters LONGVARCHAR,
    p_maxallowedruns INTEGER,
    p_rulegroupcode NVARCHAR(255),
    p_sourcerule BIGINT,
    p_promotion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_rulepackage NVARCHAR(255),
    p_globals LONGVARBINARY,
    p_kiebase BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX IdxEngineRuleActive_5100 ON enginerules (p_active);

CREATE INDEX IdxEngineRulePkg_5100 ON enginerules (p_rulepackage);

CREATE INDEX kiebaseRelIDX_5100 ON enginerules (p_kiebase);

CREATE INDEX sourceruleRelIDX_5100 ON enginerules (p_sourcerule);


CREATE CACHED TABLE enginerules5100sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5100Sn ON enginerules5100sn (ITEMPK);


CREATE CACHED TABLE engineruleslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_messagefired LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE enumerationvalu91sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_91Sn ON enumerationvalu91sn (ITEMPK);


CREATE CACHED TABLE enumerationvalues
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    Code NVARCHAR(255),
    codeLowerCase NVARCHAR(255),
    SequenceNumber INTEGER DEFAULT 0,
    p_extensionname NVARCHAR(255),
    p_icon BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    Editable TINYINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX uniqueCodeIdx_91 ON enumerationvalues (TypePkString, codeLowerCase);

CREATE INDEX seqnridx_91 ON enumerationvalues (SequenceNumber);

CREATE INDEX codeidx_91 ON enumerationvalues (Code);

CREATE INDEX code2idx_91 ON enumerationvalues (codeLowerCase);


CREATE CACHED TABLE enumerationvalueslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE eventconfigurat6613sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6613Sn ON eventconfigurat6613sn (ITEMPK);


CREATE CACHED TABLE eventconfigurations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_eventclass NVARCHAR(255),
    p_version INTEGER,
    p_exportflag TINYINT,
    p_priority BIGINT,
    p_exportname NVARCHAR(255),
    p_mappingtype BIGINT,
    p_converterbean NVARCHAR(255),
    p_description NVARCHAR(255),
    p_extensionname NVARCHAR(255),
    p_destinationtarget BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_process NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX eventConfIdx_6613 ON eventconfigurations (p_eventclass, p_destinationtarget, p_version);

CREATE INDEX destinationtargetRelIDX_6613 ON eventconfigurations (p_destinationtarget);


CREATE CACHED TABLE eventexportdead6616sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6616Sn ON eventexportdead6616sn (ITEMPK);


CREATE CACHED TABLE eventexportdeadletter
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_eventtype NVARCHAR(255),
    p_destinationtarget BIGINT,
    p_destinationchannel BIGINT,
    p_timestamp TIMESTAMP,
    p_payload LONGVARCHAR,
    p_error LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE eventpropertyco6614sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6614Sn ON eventpropertyco6614sn (ITEMPK);


CREATE CACHED TABLE eventpropertyconfigs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_propertyname NVARCHAR(255),
    p_propertymapping NVARCHAR(255),
    p_type NVARCHAR(255),
    p_title NVARCHAR(255),
    p_required TINYINT,
    p_description NVARCHAR(255),
    p_examples LONGVARBINARY,
    p_eventconfigurationpos INTEGER,
    p_eventconfiguration BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX eventPropertyUniqueIdx_6614 ON eventpropertyconfigs (p_propertyname, p_eventconfiguration);

CREATE INDEX eventconfigurationRelIDX_6614 ON eventpropertyconfigs (p_eventconfiguration);

CREATE INDEX eventconfigurationposPosIDX_6614 ON eventpropertyconfigs (p_eventconfigurationpos);


CREATE CACHED TABLE excludedcatforr5020sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5020Sn ON excludedcatforr5020sn (ITEMPK);


CREATE CACHED TABLE excludedcatforrule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_categorycode NVARCHAR(255),
    p_rule BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ExcludedCatForRule_IDX_5020 ON excludedcatforrule (p_rule, p_categorycode);


CREATE CACHED TABLE excludedproduct5021sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5021Sn ON excludedproduct5021sn (ITEMPK);


CREATE CACHED TABLE excludedproductforrule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_productcode NVARCHAR(255),
    p_rule BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ExcludedProductForRule_IDX_5021 ON excludedproductforrule (p_rule, p_productcode);


CREATE CACHED TABLE exportdatahisto6211sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6211Sn ON exportdatahisto6211sn (ITEMPK);


CREATE CACHED TABLE exportdatahistoryentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_status BIGINT,
    p_starttime TIMESTAMP,
    p_finishtime TIMESTAMP,
    p_processedresultcount INTEGER,
    p_failuremessage NVARCHAR(255),
    p_exportdatacronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX exportdatacronjobRelIDX_6211 ON exportdatahistoryentry (p_exportdatacronjob);


CREATE CACHED TABLE exports
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_exportedmedias BIGINT,
    p_exporteddata BIGINT,
    p_exportscript BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE exports151sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_151Sn ON exports151sn (ITEMPK);


CREATE CACHED TABLE exportslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE externalimportk110sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_110Sn ON externalimportk110sn (ITEMPK);


CREATE CACHED TABLE externalimportkey
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_sourcesystemid NVARCHAR(255),
    p_sourcekey NVARCHAR(255),
    p_targetpk BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX sourceSystemIDSourceKeyIDX_110 ON externalimportkey (p_sourcesystemid, p_sourcekey);


CREATE CACHED TABLE facetsearchconf
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    p_document BIGINT,
    p_solrsearchconfig BIGINT,
    p_solrindexconfig BIGINT,
    p_solrserverconfig BIGINT,
    p_indexnameprefix NVARCHAR(255),
    p_enabledlanguagefallbackmecha TINYINT,
    p_listeners LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE facetsearchconf2200sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2200Sn ON facetsearchconf2200sn (ITEMPK);


CREATE CACHED TABLE facsearchconfca2201sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2201Sn ON facsearchconfca2201sn (ITEMPK);

CREATE INDEX IdxsourcePK_2201Sn ON facsearchconfca2201sn (sourcePK);

CREATE INDEX IdxtargetPK_2201Sn ON facsearchconfca2201sn (targetPK);

CREATE INDEX IdxlanguagePK_2201Sn ON facsearchconfca2201sn (languagePK);


CREATE CACHED TABLE facsearchconfcatverrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2201 ON facsearchconfcatverrel (SourcePK);

CREATE INDEX qualifier_2201 ON facsearchconfcatverrel (Qualifier);

CREATE INDEX rseqnr_2201 ON facsearchconfcatverrel (RSequenceNumber);

CREATE INDEX linktarget_2201 ON facsearchconfcatverrel (TargetPK);

CREATE INDEX seqnr_2201 ON facsearchconfcatverrel (SequenceNumber);


CREATE CACHED TABLE facsearchconfcu2202sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2202Sn ON facsearchconfcu2202sn (ITEMPK);

CREATE INDEX IdxsourcePK_2202Sn ON facsearchconfcu2202sn (sourcePK);

CREATE INDEX IdxtargetPK_2202Sn ON facsearchconfcu2202sn (targetPK);

CREATE INDEX IdxlanguagePK_2202Sn ON facsearchconfcu2202sn (languagePK);


CREATE CACHED TABLE facsearchconfcurrrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2202 ON facsearchconfcurrrel (SourcePK);

CREATE INDEX qualifier_2202 ON facsearchconfcurrrel (Qualifier);

CREATE INDEX rseqnr_2202 ON facsearchconfcurrrel (RSequenceNumber);

CREATE INDEX linktarget_2202 ON facsearchconfcurrrel (TargetPK);

CREATE INDEX seqnr_2202 ON facsearchconfcurrrel (SequenceNumber);


CREATE CACHED TABLE facsearchconfla2203sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2203Sn ON facsearchconfla2203sn (ITEMPK);

CREATE INDEX IdxsourcePK_2203Sn ON facsearchconfla2203sn (sourcePK);

CREATE INDEX IdxtargetPK_2203Sn ON facsearchconfla2203sn (targetPK);

CREATE INDEX IdxlanguagePK_2203Sn ON facsearchconfla2203sn (languagePK);


CREATE CACHED TABLE facsearchconflangrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2203 ON facsearchconflangrel (SourcePK);

CREATE INDEX qualifier_2203 ON facsearchconflangrel (Qualifier);

CREATE INDEX rseqnr_2203 ON facsearchconflangrel (RSequenceNumber);

CREATE INDEX linktarget_2203 ON facsearchconflangrel (TargetPK);

CREATE INDEX seqnr_2203 ON facsearchconflangrel (SequenceNumber);


CREATE CACHED TABLE format
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_initial BIGINT,
    p_documenttype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE format13113sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13113Sn ON format13113sn (ITEMPK);


CREATE CACHED TABLE format2comtypre13102sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13102Sn ON format2comtypre13102sn (ITEMPK);

CREATE INDEX IdxsourcePK_13102Sn ON format2comtypre13102sn (sourcePK);

CREATE INDEX IdxtargetPK_13102Sn ON format2comtypre13102sn (targetPK);

CREATE INDEX IdxlanguagePK_13102Sn ON format2comtypre13102sn (languagePK);


CREATE CACHED TABLE format2comtyprel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_13102 ON format2comtyprel (SourcePK);

CREATE INDEX qualifier_13102 ON format2comtyprel (Qualifier);

CREATE INDEX rseqnr_13102 ON format2comtyprel (RSequenceNumber);

CREATE INDEX linktarget_13102 ON format2comtyprel (TargetPK);

CREATE INDEX seqnr_13102 ON format2comtyprel (SequenceNumber);


CREATE CACHED TABLE format2medforre13101sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13101Sn ON format2medforre13101sn (ITEMPK);

CREATE INDEX IdxsourcePK_13101Sn ON format2medforre13101sn (sourcePK);

CREATE INDEX IdxtargetPK_13101Sn ON format2medforre13101sn (targetPK);

CREATE INDEX IdxlanguagePK_13101Sn ON format2medforre13101sn (languagePK);


CREATE CACHED TABLE format2medforrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_13101 ON format2medforrel (SourcePK);

CREATE INDEX qualifier_13101 ON format2medforrel (Qualifier);

CREATE INDEX rseqnr_13101 ON format2medforrel (RSequenceNumber);

CREATE INDEX linktarget_13101 ON format2medforrel (TargetPK);

CREATE INDEX seqnr_13101 ON format2medforrel (SequenceNumber);


CREATE CACHED TABLE formatlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE fraudreports
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_provider NVARCHAR(255),
    p_timestamp TIMESTAMP,
    p_status BIGINT,
    p_explanation NVARCHAR(255),
    p_order BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderRelIDX_2001 ON fraudreports (p_order);


CREATE CACHED TABLE fraudreports2001sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2001Sn ON fraudreports2001sn (ITEMPK);


CREATE CACHED TABLE fraudsymptomsco2014sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2014Sn ON fraudsymptomsco2014sn (ITEMPK);


CREATE CACHED TABLE fraudsymptomscoring
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_score DOUBLE,
    p_explanation NVARCHAR(255),
    p_fraudreport BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX fraudreportRelIDX_2014 ON fraudsymptomscoring (p_fraudreport);


CREATE CACHED TABLE futurestock
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_productcode NVARCHAR(255),
    p_quantity INTEGER,
    p_date TIMESTAMP,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX productCodeIdx_10042 ON futurestock (p_productcode);


CREATE CACHED TABLE futurestock10042sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10042Sn ON futurestock10042sn (ITEMPK);


CREATE CACHED TABLE futurestockprod10041sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10041Sn ON futurestockprod10041sn (ITEMPK);

CREATE INDEX IdxsourcePK_10041Sn ON futurestockprod10041sn (sourcePK);

CREATE INDEX IdxtargetPK_10041Sn ON futurestockprod10041sn (targetPK);

CREATE INDEX IdxlanguagePK_10041Sn ON futurestockprod10041sn (languagePK);


CREATE CACHED TABLE futurestockproductrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10041 ON futurestockproductrel (SourcePK);

CREATE INDEX qualifier_10041 ON futurestockproductrel (Qualifier);

CREATE INDEX rseqnr_10041 ON futurestockproductrel (RSequenceNumber);

CREATE INDEX linktarget_10041 ON futurestockproductrel (TargetPK);

CREATE INDEX seqnr_10041 ON futurestockproductrel (SequenceNumber);


CREATE CACHED TABLE genericitems
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_comparator BIGINT,
    p_emptyhandling BIGINT,
    p_valuetype BIGINT,
    p_searchparametername NVARCHAR(255),
    p_joinalias NVARCHAR(255),
    p_lower TINYINT,
    p_wherepart BIGINT,
    p_typedsearchparameter BIGINT,
    p_enclosingtype BIGINT,
    p_code NVARCHAR(255),
    p_qualifier NVARCHAR(255),
    p_actiontemplate BIGINT,
    p_action BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX qualifierIdx_99 ON genericitems (p_qualifier);

CREATE INDEX wherepartRelIDX_99 ON genericitems (p_wherepart);

CREATE INDEX actiontemplateRelIDX_99 ON genericitems (p_actiontemplate);

CREATE INDEX actionRelIDX_99 ON genericitems (p_action);


CREATE CACHED TABLE genericitems99sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_99Sn ON genericitems99sn (ITEMPK);


CREATE CACHED TABLE genericitemslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE gentestitems
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE gentestitems98sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_98Sn ON gentestitems98sn (ITEMPK);


CREATE CACHED TABLE globaldiscountr1053sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1053Sn ON globaldiscountr1053sn (ITEMPK);


CREATE CACHED TABLE globaldiscountrows
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_product BIGINT,
    p_pg BIGINT,
    p_productmatchqualifier BIGINT,
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_user BIGINT,
    p_ug BIGINT,
    p_usermatchqualifier BIGINT,
    p_productid NVARCHAR(255),
    p_currency BIGINT,
    p_discount BIGINT,
    p_value DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX MatchIndexP_1053 ON globaldiscountrows (p_productmatchqualifier);

CREATE INDEX MatchIndexU_1053 ON globaldiscountrows (p_usermatchqualifier);

CREATE INDEX PIdx_1053 ON globaldiscountrows (p_product);

CREATE INDEX UIdx_1053 ON globaldiscountrows (p_user);

CREATE INDEX PGIdx_1053 ON globaldiscountrows (p_pg);

CREATE INDEX UGIdx_1053 ON globaldiscountrows (p_ug);

CREATE INDEX ProductIdIdx_1053 ON globaldiscountrows (p_productid);


CREATE CACHED TABLE groups4restrict1083sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1083Sn ON groups4restrict1083sn (ITEMPK);

CREATE INDEX IdxsourcePK_1083Sn ON groups4restrict1083sn (sourcePK);

CREATE INDEX IdxtargetPK_1083Sn ON groups4restrict1083sn (targetPK);

CREATE INDEX IdxlanguagePK_1083Sn ON groups4restrict1083sn (languagePK);


CREATE CACHED TABLE groups4restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1083 ON groups4restriction (SourcePK);

CREATE INDEX qualifier_1083 ON groups4restriction (Qualifier);

CREATE INDEX rseqnr_1083 ON groups4restriction (RSequenceNumber);

CREATE INDEX linktarget_1083 ON groups4restriction (TargetPK);

CREATE INDEX seqnr_1083 ON groups4restriction (SequenceNumber);


CREATE CACHED TABLE historydocrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2009 ON historydocrel (SourcePK);

CREATE INDEX qualifier_2009 ON historydocrel (Qualifier);

CREATE INDEX rseqnr_2009 ON historydocrel (RSequenceNumber);

CREATE INDEX linktarget_2009 ON historydocrel (TargetPK);

CREATE INDEX seqnr_2009 ON historydocrel (SequenceNumber);


CREATE CACHED TABLE historydocrel2009sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2009Sn ON historydocrel2009sn (ITEMPK);

CREATE INDEX IdxsourcePK_2009Sn ON historydocrel2009sn (sourcePK);

CREATE INDEX IdxtargetPK_2009Sn ON historydocrel2009sn (targetPK);

CREATE INDEX IdxlanguagePK_2009Sn ON historydocrel2009sn (languagePK);


CREATE CACHED TABLE impbatchcontent
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_content LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_processcode NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeIDX_113 ON impbatchcontent (p_code);


CREATE CACHED TABLE impbatchcontent113sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_113Sn ON impbatchcontent113sn (ITEMPK);


CREATE CACHED TABLE impexdocumentid114sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_114Sn ON impexdocumentid114sn (ITEMPK);


CREATE CACHED TABLE impexdocumentids
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_processcode NVARCHAR(255),
    p_docid NVARCHAR(255),
    p_itemqualifier NVARCHAR(255),
    p_itempk BIGINT,
    p_resolved TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX ImpexDocumentIdsIdx_114 ON impexdocumentids (p_processcode, p_docid, p_itemqualifier, p_itempk, p_resolved);


CREATE CACHED TABLE inboundrequeste8405sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_8405Sn ON inboundrequeste8405sn (ITEMPK);


CREATE CACHED TABLE inboundrequesterrors
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_message NVARCHAR(255),
    p_inboundrequest BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX inboundrequestRelIDX_8405 ON inboundrequesterrors (p_inboundrequest);


CREATE CACHED TABLE inboundrequests
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_status BIGINT,
    p_integrationkey NVARCHAR(255),
    p_type NVARCHAR(255),
    p_payload BIGINT,
    p_messageid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX idx_integrationKey_8403 ON inboundrequests (p_integrationkey);

CREATE INDEX idx_messageId_8403 ON inboundrequests (p_messageid);


CREATE CACHED TABLE inboundrequests8403sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_8403Sn ON inboundrequests8403sn (ITEMPK);


CREATE CACHED TABLE indextestitem
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_column1 SMALLINT,
    p_column2 SMALLINT,
    p_column3 SMALLINT,
    p_column4 SMALLINT,
    p_column5 SMALLINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX OrderIndex_7777 ON indextestitem (p_column3, p_column4, p_column1, p_column2, p_column5);


CREATE CACHED TABLE indextestitem7777sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_7777Sn ON indextestitem7777sn (ITEMPK);


CREATE CACHED TABLE integrationobji8401sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_8401Sn ON integrationobji8401sn (ITEMPK);


CREATE CACHED TABLE integrationobji8402sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_8402Sn ON integrationobji8402sn (ITEMPK);


CREATE CACHED TABLE integrationobjitemattrs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_attributedescriptor BIGINT,
    p_attributename NVARCHAR(255),
    p_returnintegrationobjectitem BIGINT,
    p_unique TINYINT,
    p_autocreate TINYINT,
    p_integrationobjectitem BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX integrationobjectitemRelIDX_8402 ON integrationobjitemattrs (p_integrationobjectitem);


CREATE CACHED TABLE integrationobjitems
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_integrationobject BIGINT,
    p_type BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX integrationobjectRelIDX_8401 ON integrationobjitems (p_integrationobject);


CREATE CACHED TABLE integrationobjs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_integrationtype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE integrationobjs8400sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_8400Sn ON integrationobjs8400sn (ITEMPK);


CREATE CACHED TABLE itemsynctimesta619sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_619Sn ON itemsynctimesta619sn (ITEMPK);


CREATE CACHED TABLE itemsynctimestamps
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_syncjob BIGINT,
    p_sourceitem BIGINT,
    p_targetitem BIGINT,
    p_sourceversion BIGINT,
    p_targetversion BIGINT,
    p_lastsyncsourcemodifiedtime TIMESTAMP,
    p_lastsynctime TIMESTAMP,
    p_pendingattributesownerjob BIGINT,
    p_pendingattributesscheduledtu INTEGER,
    p_pendingattributequalifiers LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX syncIDX_619 ON itemsynctimestamps (p_sourceitem, p_targetversion, p_syncjob);

CREATE INDEX srcIDX_619 ON itemsynctimestamps (p_sourceitem);

CREATE INDEX tgtIDX_619 ON itemsynctimestamps (p_targetitem);

CREATE INDEX jobIDX_619 ON itemsynctimestamps (p_syncjob);

CREATE INDEX srcVerIDX_619 ON itemsynctimestamps (p_sourceversion);

CREATE INDEX tgtVerIDX_619 ON itemsynctimestamps (p_targetversion);


CREATE CACHED TABLE jalotranslatorc13214sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13214Sn ON jalotranslatorc13214sn (ITEMPK);


CREATE CACHED TABLE jalotranslatorconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE jalovelocityren13211sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13211Sn ON jalovelocityren13211sn (ITEMPK);


CREATE CACHED TABLE jalovelocityrenderer
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_template LONGVARCHAR,
    p_translatorconfigurationpos INTEGER,
    p_translatorconfiguration BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX translatorconfigurationRelIDX_13211 ON jalovelocityrenderer (p_translatorconfiguration);

CREATE INDEX translatorconfigurationposPosIDX_13211 ON jalovelocityrenderer (p_translatorconfigurationpos);


CREATE CACHED TABLE joblogs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_step BIGINT,
    p_level BIGINT,
    p_cronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX cronjobIDX_504 ON joblogs (p_cronjob);


CREATE CACHED TABLE joblogs504sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_504Sn ON joblogs504sn (ITEMPK);


CREATE CACHED TABLE jobs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_nodeid INTEGER,
    p_nodegroup NVARCHAR(255),
    p_errormode BIGINT,
    p_logtofile TINYINT,
    p_logtodatabase TINYINT,
    p_loglevelfile BIGINT,
    p_logleveldatabase BIGINT,
    p_sessionuser BIGINT,
    p_sessionlanguage BIGINT,
    p_sessioncurrency BIGINT,
    p_active TINYINT,
    p_retry TINYINT,
    p_singleexecutable TINYINT,
    p_emailaddress NVARCHAR(255),
    p_sendemail TINYINT,
    p_changerecordingenabled TINYINT,
    p_requestabort TINYINT,
    p_requestabortstep TINYINT,
    p_priority INTEGER,
    p_removeonexit TINYINT,
    p_emailnotificationtemplate BIGINT,
    p_alternativedatasourceid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_springid NVARCHAR(255),
    p_springidcronjobfactory NVARCHAR(255),
    p_scripturi NVARCHAR(255),
    p_age INTEGER,
    p_numberoflogs INTEGER,
    p_querycount INTEGER,
    p_threshold INTEGER,
    p_searchtype BIGINT,
    p_searchscript NVARCHAR(255),
    p_processscript NVARCHAR(255),
    p_retentionrule BIGINT,
    p_batchsize INTEGER,
    p_maxthreads INTEGER,
    p_exclusivemode TINYINT,
    p_syncprincipalsonly TINYINT,
    p_createnewitems TINYINT,
    p_removemissingitems TINYINT,
    p_syncorder INTEGER,
    p_sourceversion BIGINT,
    p_targetversion BIGINT,
    p_copycachesize INTEGER,
    p_enabletransactions TINYINT,
    p_maxschedulerthreads INTEGER,
    p_activationscript LONGVARCHAR,
    PRIMARY KEY (PK)
);

CREATE INDEX IdxCode_500 ON jobs (p_code);

CREATE INDEX sourceversionRelIDX_500 ON jobs (p_sourceversion);

CREATE INDEX targetversionRelIDX_500 ON jobs (p_targetversion);


CREATE CACHED TABLE jobs500sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_500Sn ON jobs500sn (ITEMPK);


CREATE CACHED TABLE jobsearchrestri508sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_508Sn ON jobsearchrestri508sn (ITEMPK);


CREATE CACHED TABLE jobsearchrestriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_type BIGINT,
    p_jobpos INTEGER,
    p_job BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX jobRelIDX_508 ON jobsearchrestriction (p_job);

CREATE INDEX jobposPosIDX_508 ON jobsearchrestriction (p_jobpos);


CREATE CACHED TABLE jobslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE keywords
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_keyword NVARCHAR(255),
    p_language BIGINT,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_externalid NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX keywordIDX_602 ON keywords (p_keyword);

CREATE INDEX versionIDX_602 ON keywords (p_catalogversion);

CREATE UNIQUE INDEX codeVersionIDX_602 ON keywords (p_keyword, p_catalogversion);

CREATE INDEX extIDX_602 ON keywords (p_externalid);


CREATE CACHED TABLE keywords602sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_602Sn ON keywords602sn (ITEMPK);


CREATE CACHED TABLE languages
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_isocode NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ISOCode_32 ON languages (p_isocode);


CREATE CACHED TABLE languages32sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_32Sn ON languages32sn (ITEMPK);


CREATE CACHED TABLE languageslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE links
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_7 ON links (SourcePK);

CREATE INDEX qualifier_7 ON links (Qualifier);

CREATE INDEX rseqnr_7 ON links (RSequenceNumber);

CREATE INDEX linktarget_7 ON links (TargetPK);

CREATE INDEX seqnr_7 ON links (SequenceNumber);


CREATE CACHED TABLE links7sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_7Sn ON links7sn (ITEMPK);

CREATE INDEX IdxsourcePK_7Sn ON links7sn (sourcePK);

CREATE INDEX IdxtargetPK_7Sn ON links7sn (targetPK);

CREATE INDEX IdxlanguagePK_7Sn ON links7sn (languagePK);


CREATE CACHED TABLE maptypes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_extensionname NVARCHAR(255),
    p_autocreate TINYINT,
    p_generate TINYINT,
    InternalCode NVARCHAR(255),
    p_defaultvalue LONGVARBINARY,
    ArgumentTypePK BIGINT,
    ReturnTypePK BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    InternalCodeLowerCase NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX typecode_84 ON maptypes (InternalCode);

CREATE INDEX typecodelowercase_84 ON maptypes (InternalCodeLowerCase);


CREATE CACHED TABLE maptypes84sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_84Sn ON maptypes84sn (ITEMPK);


CREATE CACHED TABLE maptypeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE mediacontainer
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_qualifier NVARCHAR(255),
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX versionIDX_50 ON mediacontainer (p_catalogversion);

CREATE UNIQUE INDEX codeVersionIDX_50 ON mediacontainer (p_qualifier, p_catalogversion);


CREATE CACHED TABLE mediacontainer50sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_50Sn ON mediacontainer50sn (ITEMPK);


CREATE CACHED TABLE mediacontainerlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE mediacontext
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_qualifier NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX qualifierIDX_52 ON mediacontext (p_qualifier);


CREATE CACHED TABLE mediacontext52sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_52Sn ON mediacontext52sn (ITEMPK);


CREATE CACHED TABLE mediacontextlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE mediafolders
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_qualifier NVARCHAR(255),
    p_path NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX qualifierIdx_54 ON mediafolders (p_qualifier);


CREATE CACHED TABLE mediafolders54sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_54Sn ON mediafolders54sn (ITEMPK);


CREATE CACHED TABLE mediaformat
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_qualifier NVARCHAR(255),
    p_externalid NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX qualifierIDX_51 ON mediaformat (p_qualifier);


CREATE CACHED TABLE mediaformat51sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_51Sn ON mediaformat51sn (ITEMPK);


CREATE CACHED TABLE mediaformatlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE mediaformatmapp53sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_53Sn ON mediaformatmapp53sn (ITEMPK);


CREATE CACHED TABLE mediaformatmapping
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_source BIGINT,
    p_target BIGINT,
    p_mediacontext BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX mediacontextRelIDX_53 ON mediaformatmapping (p_mediacontext);


CREATE CACHED TABLE mediaprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX realnameidx_mediaprops ON mediaprops (REALNAME);

CREATE INDEX itempk_mediaprops ON mediaprops (ITEMPK);

CREATE INDEX nameidx_mediaprops ON mediaprops (NAME);


CREATE CACHED TABLE medias
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_mime NVARCHAR(255),
    p_size BIGINT,
    p_datapk BIGINT,
    p_location LONGVARCHAR,
    p_locationhash NVARCHAR(255),
    p_realfilename NVARCHAR(255),
    p_code NVARCHAR(255),
    p_internalurl LONGVARCHAR,
    p_description NVARCHAR(255),
    p_alttext NVARCHAR(255),
    p_removable TINYINT,
    p_mediaformat BIGINT,
    p_folder BIGINT,
    p_subfolderpath NVARCHAR(255),
    p_mediacontainer BIGINT,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_outputmimetype NVARCHAR(255),
    p_inputmimetype NVARCHAR(255),
    p_itemtimestamp TIMESTAMP,
    p_format BIGINT,
    p_sourceitem BIGINT,
    p_fieldseparator SMALLINT,
    p_quotecharacter SMALLINT,
    p_commentcharacter SMALLINT,
    p_encoding BIGINT,
    p_linestoskip INTEGER,
    p_removeonsuccess TINYINT,
    p_zipentry NVARCHAR(255),
    p_extractionid NVARCHAR(255),
    p_auditrootitem BIGINT,
    p_auditreportconfig BIGINT,
    p_scheduledcount INTEGER,
    p_cronjobpos INTEGER,
    p_cronjob BIGINT,
    p_barcodetext NVARCHAR(255),
    p_barcodetype BIGINT,
    p_contextitem BIGINT,
    p_deeplinkurl BIGINT,
    p_message BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX dataPK_idx_30 ON medias (p_datapk);

CREATE INDEX Media_Code_30 ON medias (p_code);

CREATE INDEX versionIDX_30 ON medias (p_catalogversion);

CREATE UNIQUE INDEX codeVersionIDX_30 ON medias (p_code, p_catalogversion);

CREATE INDEX mediacontainerRelIDX_30 ON medias (p_mediacontainer);

CREATE INDEX sourceitemRelIDX_30 ON medias (p_sourceitem);

CREATE INDEX cronjobRelIDX_30 ON medias (p_cronjob);

CREATE INDEX cronjobposPosIDX_30 ON medias (p_cronjobpos);

CREATE INDEX auditreportconfigRelIDX_30 ON medias (p_auditreportconfig);

CREATE INDEX deeplinkurlRelIDX_30 ON medias (p_deeplinkurl);

CREATE INDEX messageRelIDX_30 ON medias (p_message);


CREATE CACHED TABLE medias30sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_30Sn ON medias30sn (ITEMPK);


CREATE CACHED TABLE metainformations
(
    hjmpTS BIGINT,
    PK BIGINT NOT NULL,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    aCLTS BIGINT DEFAULT 0,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    propTS BIGINT DEFAULT 0,
    SystemPK NVARCHAR(255),
    SystemName NVARCHAR(255),
    isInitialized TINYINT DEFAULT 0,
    LicenceID NVARCHAR(255),
    LicenceName NVARCHAR(255),
    LicenceEdition NVARCHAR(255),
    AdminFactor INTEGER DEFAULT 0,
    LicenceExpirationDate TIMESTAMP,
    LicenceSignature NVARCHAR(255),
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE numberseries
(
    hjmpTS BIGINT,
    serieskey NVARCHAR(255) NOT NULL,
    seriestype INTEGER DEFAULT 0,
    currentValue BIGINT,
    template NVARCHAR(255),
    PRIMARY KEY (serieskey)
);


CREATE CACHED TABLE oauthaccesstoke6228sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6228Sn ON oauthaccesstoke6228sn (ITEMPK);


CREATE CACHED TABLE oauthaccesstoken
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_tokenid NVARCHAR(255),
    p_token LONGVARBINARY,
    p_authenticationid NVARCHAR(255),
    p_client BIGINT,
    p_authentication LONGVARBINARY,
    p_refreshtoken BIGINT,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX tokenIdIdx_6228 ON oauthaccesstoken (p_tokenid);

CREATE UNIQUE INDEX authenticationIdIdx_6228 ON oauthaccesstoken (p_authenticationid);

CREATE INDEX refreshTokenIdx_6228 ON oauthaccesstoken (p_refreshtoken);

CREATE INDEX userRelIDX_6228 ON oauthaccesstoken (p_user);


CREATE CACHED TABLE oauthauthorizat6231sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6231Sn ON oauthauthorizat6231sn (ITEMPK);


CREATE CACHED TABLE oauthauthorizationcode
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_authentication LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeIdx_6231 ON oauthauthorizationcode (p_code);


CREATE CACHED TABLE oauthclientdeta6500sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6500Sn ON oauthclientdeta6500sn (ITEMPK);


CREATE CACHED TABLE oauthclientdetails
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_clientid NVARCHAR(255),
    p_resourceids LONGVARBINARY,
    p_clientsecret NVARCHAR(255),
    p_scope LONGVARBINARY,
    p_authorizedgranttypes LONGVARBINARY,
    p_registeredredirecturi LONGVARBINARY,
    p_authorities LONGVARBINARY,
    p_accesstokenvalidityseconds INTEGER,
    p_refreshtokenvalidityseconds INTEGER,
    p_autoapprove LONGVARBINARY,
    p_disabled TINYINT,
    p_oauthurl NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_externalscopeclaimname NVARCHAR(255),
    p_issuer NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX clientIdIdx_6500 ON oauthclientdetails (p_clientid);


CREATE CACHED TABLE oauthrefreshtok6229sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6229Sn ON oauthrefreshtok6229sn (ITEMPK);


CREATE CACHED TABLE oauthrefreshtoken
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_tokenid NVARCHAR(255),
    p_token LONGVARBINARY,
    p_authentication LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX tokenIdIdx_6229 ON oauthrefreshtoken (p_tokenid);


CREATE CACHED TABLE openidexternals6520sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6520Sn ON openidexternals6520sn (ITEMPK);


CREATE CACHED TABLE openidexternalscopes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_clientdetailsid BIGINT,
    p_permittedprincipals LONGVARCHAR,
    p_scope LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX exScopesClIdIdx_6520 ON openidexternalscopes (p_clientdetailsid);


CREATE CACHED TABLE openingdays
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_openingtime TIMESTAMP,
    p_closingtime TIMESTAMP,
    p_openingschedule BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_date TIMESTAMP,
    p_closed TINYINT,
    p_dayofweek BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX openingscheduleRelIDX_2021 ON openingdays (p_openingschedule);


CREATE CACHED TABLE openingdays2021sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2021Sn ON openingdays2021sn (ITEMPK);


CREATE CACHED TABLE openingdayslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_message NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE openingschedule2022sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2022Sn ON openingschedule2022sn (ITEMPK);


CREATE CACHED TABLE openingschedules
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE openingscheduleslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE order2exhtdappr10025sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10025Sn ON order2exhtdappr10025sn (ITEMPK);

CREATE INDEX IdxsourcePK_10025Sn ON order2exhtdappr10025sn (sourcePK);

CREATE INDEX IdxtargetPK_10025Sn ON order2exhtdappr10025sn (targetPK);

CREATE INDEX IdxlanguagePK_10025Sn ON order2exhtdappr10025sn (languagePK);


CREATE CACHED TABLE order2exhtdapprsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10025 ON order2exhtdapprsrel (SourcePK);

CREATE INDEX qualifier_10025 ON order2exhtdapprsrel (Qualifier);

CREATE INDEX rseqnr_10025 ON order2exhtdapprsrel (RSequenceNumber);

CREATE INDEX linktarget_10025 ON order2exhtdapprsrel (TargetPK);

CREATE INDEX seqnr_10025 ON order2exhtdapprsrel (SequenceNumber);


CREATE CACHED TABLE ordercancelconf2019sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2019Sn ON ordercancelconf2019sn (ITEMPK);


CREATE CACHED TABLE ordercancelconfigs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_ordercancelallowed TINYINT,
    p_cancelafterwarehouseallowed TINYINT,
    p_completecancelaftershippings TINYINT,
    p_partialcancelallowed TINYINT,
    p_partialorderentrycancelallow TINYINT,
    p_queuedorderwaitingtime INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE orderdiscrels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_202 ON orderdiscrels (SourcePK);

CREATE INDEX qualifier_202 ON orderdiscrels (Qualifier);

CREATE INDEX rseqnr_202 ON orderdiscrels (RSequenceNumber);

CREATE INDEX linktarget_202 ON orderdiscrels (TargetPK);

CREATE INDEX seqnr_202 ON orderdiscrels (SequenceNumber);


CREATE CACHED TABLE orderdiscrels202sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_202Sn ON orderdiscrels202sn (ITEMPK);

CREATE INDEX IdxsourcePK_202Sn ON orderdiscrels202sn (sourcePK);

CREATE INDEX IdxtargetPK_202Sn ON orderdiscrels202sn (targetPK);

CREATE INDEX IdxlanguagePK_202Sn ON orderdiscrels202sn (languagePK);


CREATE CACHED TABLE orderentmodrece2018sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2018Sn ON orderentmodrece2018sn (ITEMPK);


CREATE CACHED TABLE orderentmodrecentrs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_notes NVARCHAR(255),
    p_originalorderentry BIGINT,
    p_orderentry BIGINT,
    p_modificationrecordentry BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_cancelrequestquantity INTEGER,
    p_cancelledquantity INTEGER,
    p_cancelreason BIGINT,
    p_expectedquantity BIGINT,
    p_returnedquantity BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX modificationrecordentryRelIDX_2018 ON orderentmodrecentrs (p_modificationrecordentry);


CREATE CACHED TABLE orderentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_baseprice DECIMAL(30,8),
    p_calculated TINYINT,
    p_discountvaluesinternal LONGVARCHAR,
    p_entrynumber INTEGER,
    p_info LONGVARCHAR,
    p_product BIGINT,
    p_quantity DECIMAL(30,8),
    p_taxvaluesinternal NVARCHAR(255),
    p_totalprice DECIMAL(30,8),
    p_unit BIGINT,
    p_giveaway TINYINT,
    p_rejected TINYINT,
    p_entrygroupnumbers LONGVARBINARY,
    p_order BIGINT,
    p_europe1pricefactory_ppg BIGINT,
    p_europe1pricefactory_ptg BIGINT,
    p_europe1pricefactory_pdg BIGINT,
    p_chosenvendor BIGINT,
    p_deliveryaddress BIGINT,
    p_deliverymode BIGINT,
    p_nameddeliverydate TIMESTAMP,
    p_quantitystatus BIGINT,
    p_deliverypointofservice BIGINT,
    p_costcenter BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX oeProd_46 ON orderentries (p_product);

CREATE INDEX oeOrd_46 ON orderentries (p_order);


CREATE CACHED TABLE orderentries46sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_46Sn ON orderentries46sn (ITEMPK);


CREATE CACHED TABLE orderentryconsu5014sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5014Sn ON orderentryconsu5014sn (ITEMPK);


CREATE CACHED TABLE orderentryconsumed
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_promotionresult BIGINT,
    p_quantity BIGINT,
    p_adjustedunitprice DOUBLE,
    p_orderentry BIGINT,
    p_orderentrynumber INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX promotionResultIDX_5014 ON orderentryconsumed (p_promotionresult);


CREATE CACHED TABLE orderentryprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX nameidx_orderentryprops ON orderentryprops (NAME);

CREATE INDEX itempk_orderentryprops ON orderentryprops (ITEMPK);

CREATE INDEX realnameidx_orderentryprops ON orderentryprops (REALNAME);


CREATE CACHED TABLE orderhistoryent2002sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2002Sn ON orderhistoryent2002sn (ITEMPK);


CREATE CACHED TABLE orderhistoryentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_timestamp TIMESTAMP,
    p_employee BIGINT,
    p_description NVARCHAR(255),
    p_previousorderversion BIGINT,
    p_orderpos INTEGER,
    p_order BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderRelIDX_2002 ON orderhistoryentries (p_order);

CREATE INDEX orderposPosIDX_2002 ON orderhistoryentries (p_orderpos);


CREATE CACHED TABLE ordermodifirece2017sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2017Sn ON ordermodifirece2017sn (ITEMPK);


CREATE CACHED TABLE ordermodifirecentrs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_timestamp TIMESTAMP,
    p_status BIGINT,
    p_originalversion BIGINT,
    p_principal BIGINT,
    p_failedmessage NVARCHAR(255),
    p_notes NVARCHAR(255),
    p_modificationrecord BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_refusedmessage NVARCHAR(255),
    p_cancelresult BIGINT,
    p_cancelreason BIGINT,
    p_returnstatus BIGINT,
    p_expectedquantity BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX modificationrecordRelIDX_2017 ON ordermodifirecentrs (p_modificationrecord);


CREATE CACHED TABLE ordermodifireco2016sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2016Sn ON ordermodifireco2016sn (ITEMPK);


CREATE CACHED TABLE ordermodifirecords
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_inprogress TINYINT,
    p_identifier NVARCHAR(255),
    p_order BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderRelIDX_2016 ON ordermodifirecords (p_order);


CREATE CACHED TABLE orderprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX nameidx_orderprops ON orderprops (NAME);

CREATE INDEX realnameidx_orderprops ON orderprops (REALNAME);

CREATE INDEX itempk_orderprops ON orderprops (ITEMPK);


CREATE CACHED TABLE orders
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_calculated TINYINT,
    p_code NVARCHAR(255),
    p_currency BIGINT,
    p_deliveryaddress BIGINT,
    p_deliverycost DECIMAL(30,8),
    p_deliverymode BIGINT,
    p_deliverystatus BIGINT,
    p_description NVARCHAR(255),
    p_expirationtime TIMESTAMP,
    p_globaldiscountvaluesinternal LONGVARCHAR,
    p_name NVARCHAR(255),
    p_net TINYINT,
    p_paymentaddress BIGINT,
    p_paymentcost DECIMAL(30,8),
    p_paymentinfo BIGINT,
    p_paymentmode BIGINT,
    p_paymentstatus BIGINT,
    p_status BIGINT,
    p_exportstatus BIGINT,
    p_statusinfo NVARCHAR(255),
    p_totalprice DECIMAL(30,8),
    p_totaldiscounts DECIMAL(30,8),
    p_totaltax DECIMAL(30,8),
    p_totaltaxvaluesinternal LONGVARCHAR,
    p_user BIGINT,
    p_subtotal DECIMAL(30,8),
    p_discountsincludedeliverycost TINYINT,
    p_discountsincludepaymentcost TINYINT,
    p_entrygroups LONGVARBINARY,
    p_europe1pricefactory_udg BIGINT,
    p_europe1pricefactory_upg BIGINT,
    p_europe1pricefactory_utg BIGINT,
    p_previousdeliverymode BIGINT,
    p_site BIGINT,
    p_store BIGINT,
    p_guid NVARCHAR(255),
    p_quotediscountvaluesinternal LONGVARCHAR,
    p_locale NVARCHAR(255),
    p_workflow BIGINT,
    p_quoteexpirationdate TIMESTAMP,
    p_unit BIGINT,
    p_purchaseordernumber NVARCHAR(255),
    p_paymenttype BIGINT,
    p_appliedcouponcodes LONGVARBINARY,
    p_versionid NVARCHAR(255),
    p_originalversion BIGINT,
    p_fraudulent TINYINT,
    p_potentiallyfraudulent TINYINT,
    p_salesapplication BIGINT,
    p_language BIGINT,
    p_placedby BIGINT,
    p_quotereference BIGINT,
    p_schedulingcronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_fulfilmentstatus BIGINT,
    p_notes NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX OrderCode_45 ON orders (p_code);

CREATE INDEX OrderUser_45 ON orders (p_user);

CREATE INDEX guidIndex_45 ON orders (p_guid);

CREATE INDEX placedByIndex_45 ON orders (p_placedby);

CREATE INDEX dateIdx_45 ON orders (createdTS);

CREATE INDEX statusIdx_45 ON orders (p_status);

CREATE INDEX unitRelIDX_45 ON orders (p_unit);

CREATE INDEX schedulingcronjobRelIDX_45 ON orders (p_schedulingcronjob);


CREATE CACHED TABLE orders45sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_45Sn ON orders45sn (ITEMPK);


CREATE CACHED TABLE outboundrequest8406sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_8406Sn ON outboundrequest8406sn (ITEMPK);


CREATE CACHED TABLE outboundrequests
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_status BIGINT,
    p_integrationkey NVARCHAR(255),
    p_type NVARCHAR(255),
    p_payload BIGINT,
    p_messageid NVARCHAR(255),
    p_destination NVARCHAR(255),
    p_sappassport VARCHAR(1024),
    p_error NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX idx_integrationKey_8406 ON outboundrequests (p_integrationkey);

CREATE INDEX idx_messageId_8406 ON outboundrequests (p_messageid);


CREATE CACHED TABLE pagetemplate
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    p_active TINYINT,
    p_frontendtemplatename NVARCHAR(255),
    p_previewicon BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_htmltemplate BIGINT,
    p_subject BIGINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE pagetemplate1076sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1076Sn ON pagetemplate1076sn (ITEMPK);


CREATE CACHED TABLE pagetypesfortem1095sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1095Sn ON pagetypesfortem1095sn (ITEMPK);

CREATE INDEX IdxsourcePK_1095Sn ON pagetypesfortem1095sn (sourcePK);

CREATE INDEX IdxtargetPK_1095Sn ON pagetypesfortem1095sn (targetPK);

CREATE INDEX IdxlanguagePK_1095Sn ON pagetypesfortem1095sn (languagePK);


CREATE CACHED TABLE pagetypesfortemplates
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1095 ON pagetypesfortemplates (SourcePK);

CREATE INDEX qualifier_1095 ON pagetypesfortemplates (Qualifier);

CREATE INDEX rseqnr_1095 ON pagetypesfortemplates (RSequenceNumber);

CREATE INDEX linktarget_1095 ON pagetypesfortemplates (TargetPK);

CREATE INDEX seqnr_1095 ON pagetypesfortemplates (SequenceNumber);


CREATE CACHED TABLE parserproperty
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_startexp NVARCHAR(255),
    p_endexp NVARCHAR(255),
    p_parserclass NVARCHAR(255),
    p_translatorconfigurationpos INTEGER,
    p_translatorconfiguration BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX translatorconfigurationRelIDX_13213 ON parserproperty (p_translatorconfiguration);

CREATE INDEX translatorconfigurationposPosIDX_13213 ON parserproperty (p_translatorconfigurationpos);


CREATE CACHED TABLE parserproperty13213sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13213Sn ON parserproperty13213sn (ITEMPK);


CREATE CACHED TABLE paymentinfos
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_original BIGINT,
    p_code NVARCHAR(255),
    p_duplicate TINYINT,
    p_user BIGINT,
    p_billingaddress BIGINT,
    p_saved TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_ccowner NVARCHAR(255),
    p_number NVARCHAR(255),
    p_type BIGINT,
    p_validtomonth NVARCHAR(255),
    p_validtoyear NVARCHAR(255),
    p_validfrommonth NVARCHAR(255),
    p_validfromyear NVARCHAR(255),
    p_subscriptionid NVARCHAR(255),
    p_issuenumber INTEGER,
    p_subscriptionvalidated TINYINT,
    p_bankidnumber NVARCHAR(255),
    p_bank NVARCHAR(255),
    p_accountnumber NVARCHAR(255),
    p_baowner NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX PaymentInfo_User_42 ON paymentinfos (p_user);

CREATE INDEX Subscription_42 ON paymentinfos (p_subscriptionid);


CREATE CACHED TABLE paymentinfos42sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_42Sn ON paymentinfos42sn (ITEMPK);


CREATE CACHED TABLE paymentmodes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_code NVARCHAR(255),
    p_paymentinfotype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_net TINYINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE paymentmodes41sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_41Sn ON paymentmodes41sn (ITEMPK);


CREATE CACHED TABLE paymentmodeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description LONGVARCHAR,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE paymentsubscres6230sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6230Sn ON paymentsubscres6230sn (ITEMPK);


CREATE CACHED TABLE paymentsubscresult
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_cartid NVARCHAR(255),
    p_success TINYINT,
    p_result LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX cartIdIdx_6230 ON paymentsubscresult (p_cartid);


CREATE CACHED TABLE paymenttransact2100sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2100Sn ON paymenttransact2100sn (ITEMPK);


CREATE CACHED TABLE paymenttransactions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_requestid NVARCHAR(255),
    p_requesttoken NVARCHAR(255),
    p_paymentprovider NVARCHAR(255),
    p_plannedamount DECIMAL(30,8),
    p_currency BIGINT,
    p_info BIGINT,
    p_versionid NVARCHAR(255),
    p_order BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX transUniqueIdx_2100 ON paymenttransactions (p_code, p_order, p_versionid);

CREATE INDEX orderRelIDX_2100 ON paymenttransactions (p_order);


CREATE CACHED TABLE paymnttrnsctent2101sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2101Sn ON paymnttrnsctent2101sn (ITEMPK);


CREATE CACHED TABLE paymnttrnsctentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_type BIGINT,
    p_amount DECIMAL(30,8),
    p_currency BIGINT,
    p_time TIMESTAMP,
    p_transactionstatus NVARCHAR(255),
    p_transactionstatusdetails NVARCHAR(255),
    p_requesttoken NVARCHAR(255),
    p_requestid NVARCHAR(255),
    p_subscriptionid NVARCHAR(255),
    p_code NVARCHAR(255),
    p_versionid NVARCHAR(255),
    p_paymenttransaction BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX transcodeIdx_2101 ON paymnttrnsctentries (p_code);

CREATE UNIQUE INDEX transEntryUniqueIdx_2101 ON paymnttrnsctentries (p_code, p_paymenttransaction, p_type, p_versionid);

CREATE INDEX paymenttransactionRelIDX_2101 ON paymnttrnsctentries (p_paymenttransaction);


CREATE CACHED TABLE pcp2wrtblecvrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_617 ON pcp2wrtblecvrel (SourcePK);

CREATE INDEX qualifier_617 ON pcp2wrtblecvrel (Qualifier);

CREATE INDEX rseqnr_617 ON pcp2wrtblecvrel (RSequenceNumber);

CREATE INDEX linktarget_617 ON pcp2wrtblecvrel (TargetPK);

CREATE INDEX seqnr_617 ON pcp2wrtblecvrel (SequenceNumber);


CREATE CACHED TABLE pcp2wrtblecvrel617sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_617Sn ON pcp2wrtblecvrel617sn (ITEMPK);

CREATE INDEX IdxsourcePK_617Sn ON pcp2wrtblecvrel617sn (sourcePK);

CREATE INDEX IdxtargetPK_617Sn ON pcp2wrtblecvrel617sn (targetPK);

CREATE INDEX IdxlanguagePK_617Sn ON pcp2wrtblecvrel617sn (languagePK);


CREATE CACHED TABLE pcpl2rdblecvrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_618 ON pcpl2rdblecvrel (SourcePK);

CREATE INDEX qualifier_618 ON pcpl2rdblecvrel (Qualifier);

CREATE INDEX rseqnr_618 ON pcpl2rdblecvrel (RSequenceNumber);

CREATE INDEX linktarget_618 ON pcpl2rdblecvrel (TargetPK);

CREATE INDEX seqnr_618 ON pcpl2rdblecvrel (SequenceNumber);


CREATE CACHED TABLE pcpl2rdblecvrel618sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_618Sn ON pcpl2rdblecvrel618sn (ITEMPK);

CREATE INDEX IdxsourcePK_618Sn ON pcpl2rdblecvrel618sn (sourcePK);

CREATE INDEX IdxtargetPK_618Sn ON pcpl2rdblecvrel618sn (targetPK);

CREATE INDEX IdxlanguagePK_618Sn ON pcpl2rdblecvrel618sn (languagePK);


CREATE CACHED TABLE pendingstepsrel507sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_507Sn ON pendingstepsrel507sn (ITEMPK);

CREATE INDEX IdxsourcePK_507Sn ON pendingstepsrel507sn (sourcePK);

CREATE INDEX IdxtargetPK_507Sn ON pendingstepsrel507sn (targetPK);

CREATE INDEX IdxlanguagePK_507Sn ON pendingstepsrel507sn (languagePK);


CREATE CACHED TABLE pendingstepsrelation
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_507 ON pendingstepsrelation (SourcePK);

CREATE INDEX qualifier_507 ON pendingstepsrelation (Qualifier);

CREATE INDEX rseqnr_507 ON pendingstepsrelation (RSequenceNumber);

CREATE INDEX linktarget_507 ON pendingstepsrelation (TargetPK);

CREATE INDEX seqnr_507 ON pendingstepsrelation (SequenceNumber);


CREATE CACHED TABLE pgrels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_201 ON pgrels (SourcePK);

CREATE INDEX qualifier_201 ON pgrels (Qualifier);

CREATE INDEX rseqnr_201 ON pgrels (RSequenceNumber);

CREATE INDEX linktarget_201 ON pgrels (TargetPK);

CREATE INDEX seqnr_201 ON pgrels (SequenceNumber);


CREATE CACHED TABLE pgrels201sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_201Sn ON pgrels201sn (ITEMPK);

CREATE INDEX IdxsourcePK_201Sn ON pgrels201sn (sourcePK);

CREATE INDEX IdxtargetPK_201Sn ON pgrels201sn (targetPK);

CREATE INDEX IdxlanguagePK_201Sn ON pgrels201sn (languagePK);


CREATE CACHED TABLE pointofservice
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_address BIGINT,
    p_description NVARCHAR(255),
    p_type BIGINT,
    p_mapicon BIGINT,
    p_latitude DOUBLE,
    p_longitude DOUBLE,
    p_geocodetimestamp TIMESTAMP,
    p_openingschedule BIGINT,
    p_storeimage BIGINT,
    p_businesscategory NVARCHAR(255),
    p_basestore BIGINT,
    p_displayname NVARCHAR(255),
    p_nearbystoreradius DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX basestoreRelIDX_2040 ON pointofservice (p_basestore);


CREATE CACHED TABLE pointofservice2040sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2040Sn ON pointofservice2040sn (ITEMPK);


CREATE CACHED TABLE pointofservicelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_storecontent LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE pos2warehousere6217sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6217Sn ON pos2warehousere6217sn (ITEMPK);

CREATE INDEX IdxsourcePK_6217Sn ON pos2warehousere6217sn (sourcePK);

CREATE INDEX IdxtargetPK_6217Sn ON pos2warehousere6217sn (targetPK);

CREATE INDEX IdxlanguagePK_6217Sn ON pos2warehousere6217sn (languagePK);


CREATE CACHED TABLE pos2warehouserel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6217 ON pos2warehouserel (SourcePK);

CREATE INDEX qualifier_6217 ON pos2warehouserel (Qualifier);

CREATE INDEX rseqnr_6217 ON pos2warehouserel (RSequenceNumber);

CREATE INDEX linktarget_6217 ON pos2warehouserel (TargetPK);

CREATE INDEX seqnr_6217 ON pos2warehouserel (SequenceNumber);


CREATE CACHED TABLE previewdata
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_user BIGINT,
    p_usergroup BIGINT,
    p_country BIGINT,
    p_language BIGINT,
    p_time TIMESTAMP,
    p_liveedit TINYINT,
    p_editmode TINYINT,
    p_resourcepath LONGVARCHAR,
    p_page BIGINT,
    p_previewcategory BIGINT,
    p_previewproduct BIGINT,
    p_previewcatalog BIGINT,
    p_activesite BIGINT,
    p_activecatalogversion BIGINT,
    p_version BIGINT,
    p_uiexperience BIGINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE previewdata1068sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1068Sn ON previewdata1068sn (ITEMPK);


CREATE CACHED TABLE previewdatatoca1101sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1101Sn ON previewdatatoca1101sn (ITEMPK);

CREATE INDEX IdxsourcePK_1101Sn ON previewdatatoca1101sn (sourcePK);

CREATE INDEX IdxtargetPK_1101Sn ON previewdatatoca1101sn (targetPK);

CREATE INDEX IdxlanguagePK_1101Sn ON previewdatatoca1101sn (languagePK);


CREATE CACHED TABLE previewdatatocatvers
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1101 ON previewdatatocatvers (SourcePK);

CREATE INDEX qualifier_1101 ON previewdatatocatvers (Qualifier);

CREATE INDEX rseqnr_1101 ON previewdatatocatvers (RSequenceNumber);

CREATE INDEX linktarget_1101 ON previewdatatocatvers (TargetPK);

CREATE INDEX seqnr_1101 ON previewdatatocatvers (SequenceNumber);


CREATE CACHED TABLE previewtickets
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_previewcatalogversion BIGINT,
    p_validto TIMESTAMP,
    p_createdby BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE previewtickets667sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_667Sn ON previewtickets667sn (ITEMPK);


CREATE CACHED TABLE previewtosegmen3701sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3701Sn ON previewtosegmen3701sn (ITEMPK);

CREATE INDEX IdxsourcePK_3701Sn ON previewtosegmen3701sn (sourcePK);

CREATE INDEX IdxtargetPK_3701Sn ON previewtosegmen3701sn (targetPK);

CREATE INDEX IdxlanguagePK_3701Sn ON previewtosegmen3701sn (languagePK);


CREATE CACHED TABLE previewtosegment
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3701 ON previewtosegment (SourcePK);

CREATE INDEX qualifier_3701 ON previewtosegment (Qualifier);

CREATE INDEX rseqnr_3701 ON previewtosegment (RSequenceNumber);

CREATE INDEX linktarget_3701 ON previewtosegment (TargetPK);

CREATE INDEX seqnr_3701 ON previewtosegment (SequenceNumber);


CREATE CACHED TABLE previewtovariat3700sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3700Sn ON previewtovariat3700sn (ITEMPK);

CREATE INDEX IdxsourcePK_3700Sn ON previewtovariat3700sn (sourcePK);

CREATE INDEX IdxtargetPK_3700Sn ON previewtovariat3700sn (targetPK);

CREATE INDEX IdxlanguagePK_3700Sn ON previewtovariat3700sn (languagePK);


CREATE CACHED TABLE previewtovariation
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3700 ON previewtovariation (SourcePK);

CREATE INDEX qualifier_3700 ON previewtovariation (Qualifier);

CREATE INDEX rseqnr_3700 ON previewtovariation (RSequenceNumber);

CREATE INDEX linktarget_3700 ON previewtovariation (TargetPK);

CREATE INDEX seqnr_3700 ON previewtovariation (SequenceNumber);


CREATE CACHED TABLE pricerows
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_product BIGINT,
    p_pg BIGINT,
    p_productmatchqualifier BIGINT,
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_user BIGINT,
    p_ug BIGINT,
    p_usermatchqualifier BIGINT,
    p_productid NVARCHAR(255),
    p_catalogversion BIGINT,
    p_matchvalue INTEGER,
    p_currency BIGINT,
    p_minqtd BIGINT,
    p_net TINYINT,
    p_price DOUBLE,
    p_unit BIGINT,
    p_unitfactor INTEGER,
    p_giveawayprice TINYINT,
    p_channel BIGINT,
    p_sequenceid BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX MatchIndexP_1055 ON pricerows (p_productmatchqualifier);

CREATE INDEX MatchIndexU_1055 ON pricerows (p_usermatchqualifier);

CREATE INDEX PIdx_1055 ON pricerows (p_product);

CREATE INDEX UIdx_1055 ON pricerows (p_user);

CREATE INDEX PGIdx_1055 ON pricerows (p_pg);

CREATE INDEX UGIdx_1055 ON pricerows (p_ug);

CREATE INDEX ProductIdIdx_1055 ON pricerows (p_productid);

CREATE INDEX versionIDX_1055 ON pricerows (p_catalogversion);


CREATE CACHED TABLE pricerows1055sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1055Sn ON pricerows1055sn (ITEMPK);


CREATE CACHED TABLE processedstepsr506sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_506Sn ON processedstepsr506sn (ITEMPK);

CREATE INDEX IdxsourcePK_506Sn ON processedstepsr506sn (sourcePK);

CREATE INDEX IdxtargetPK_506Sn ON processedstepsr506sn (targetPK);

CREATE INDEX IdxlanguagePK_506Sn ON processedstepsr506sn (languagePK);


CREATE CACHED TABLE processedstepsrelation
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_506 ON processedstepsrelation (SourcePK);

CREATE INDEX qualifier_506 ON processedstepsrelation (Qualifier);

CREATE INDEX rseqnr_506 ON processedstepsrelation (RSequenceNumber);

CREATE INDEX linktarget_506 ON processedstepsrelation (TargetPK);

CREATE INDEX seqnr_506 ON processedstepsrelation (SequenceNumber);


CREATE CACHED TABLE processes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_processdefinitionname NVARCHAR(255),
    p_processdefinitionversion NVARCHAR(255),
    p_state BIGINT,
    p_endmessage LONGVARCHAR,
    p_user BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_consignment BIGINT,
    p_parentprocess BIGINT,
    p_done TINYINT,
    p_waitingforconsignment TINYINT,
    p_warehouseconsignmentstate BIGINT,
    p_order BIGINT,
    p_ordermodificationrecordentry BIGINT,
    p_returnrequest BIGINT,
    p_site BIGINT,
    p_store BIGINT,
    p_customer BIGINT,
    p_language BIGINT,
    p_currency BIGINT,
    p_token NVARCHAR(255),
    p_uploadedfile BIGINT,
    p_savedcart BIGINT,
    p_carttoordercronjob BIGINT,
    p_quotecode NVARCHAR(255),
    p_key NVARCHAR(255),
    p_maxagedays INTEGER,
    p_maxnumberversions INTEGER,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX ProcessengineProcess_name_idx_32766 ON processes (p_code);

CREATE INDEX cxPersonalizationProcessKeyIdx_32766 ON processes (p_key);

CREATE INDEX consignmentRelIDX_32766 ON processes (p_consignment);

CREATE INDEX orderRelIDX_32766 ON processes (p_order);

CREATE INDEX parentprocessRelIDX_32766 ON processes (p_parentprocess);

CREATE INDEX returnrequestRelIDX_32766 ON processes (p_returnrequest);


CREATE CACHED TABLE processes32766sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_32766Sn ON processes32766sn (ITEMPK);


CREATE CACHED TABLE processparamete32764sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_32764Sn ON processparamete32764sn (ITEMPK);


CREATE CACHED TABLE processparameters
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_value LONGVARBINARY,
    p_process BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX BusinessProcessParameter_idx_32764 ON processparameters (p_process, p_name);

CREATE INDEX processRelIDX_32764 ON processparameters (p_process);


CREATE CACHED TABLE prod2keywordrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_604 ON prod2keywordrel (SourcePK);

CREATE INDEX qualifier_604 ON prod2keywordrel (Qualifier);

CREATE INDEX rseqnr_604 ON prod2keywordrel (RSequenceNumber);

CREATE INDEX linktarget_604 ON prod2keywordrel (TargetPK);

CREATE INDEX seqnr_604 ON prod2keywordrel (SequenceNumber);


CREATE CACHED TABLE prod2keywordrel604sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_604Sn ON prod2keywordrel604sn (ITEMPK);

CREATE INDEX IdxsourcePK_604Sn ON prod2keywordrel604sn (sourcePK);

CREATE INDEX IdxtargetPK_604Sn ON prod2keywordrel604sn (targetPK);

CREATE INDEX IdxlanguagePK_604Sn ON prod2keywordrel604sn (languagePK);


CREATE CACHED TABLE prodforpromosou5402sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5402Sn ON prodforpromosou5402sn (ITEMPK);


CREATE CACHED TABLE prodforpromosourcerule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_productcode NVARCHAR(255),
    p_rule BIGINT,
    p_promotion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ProdForPromoSourceRule_IDX_5402 ON prodforpromosourcerule (p_productcode, p_rule);


CREATE CACHED TABLE prodpromrelatio5018sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5018Sn ON prodpromrelatio5018sn (ITEMPK);

CREATE INDEX IdxsourcePK_5018Sn ON prodpromrelatio5018sn (sourcePK);

CREATE INDEX IdxtargetPK_5018Sn ON prodpromrelatio5018sn (targetPK);

CREATE INDEX IdxlanguagePK_5018Sn ON prodpromrelatio5018sn (languagePK);


CREATE CACHED TABLE prodpromrelations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_5018 ON prodpromrelations (SourcePK);

CREATE INDEX qualifier_5018 ON prodpromrelations (Qualifier);

CREATE INDEX rseqnr_5018 ON prodpromrelations (RSequenceNumber);

CREATE INDEX linktarget_5018 ON prodpromrelations (TargetPK);

CREATE INDEX seqnr_5018 ON prodpromrelations (SequenceNumber);


CREATE CACHED TABLE prodsforprodcar3002sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3002Sn ON prodsforprodcar3002sn (ITEMPK);

CREATE INDEX IdxsourcePK_3002Sn ON prodsforprodcar3002sn (sourcePK);

CREATE INDEX IdxtargetPK_3002Sn ON prodsforprodcar3002sn (targetPK);

CREATE INDEX IdxlanguagePK_3002Sn ON prodsforprodcar3002sn (languagePK);


CREATE CACHED TABLE prodsforprodcarcomprels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3002 ON prodsforprodcarcomprels (SourcePK);

CREATE INDEX qualifier_3002 ON prodsforprodcarcomprels (Qualifier);

CREATE INDEX rseqnr_3002 ON prodsforprodcarcomprels (RSequenceNumber);

CREATE INDEX linktarget_3002 ON prodsforprodcarcomprels (TargetPK);

CREATE INDEX seqnr_3002 ON prodsforprodcarcomprels (SequenceNumber);


CREATE CACHED TABLE prodsforprodlis3001sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3001Sn ON prodsforprodlis3001sn (ITEMPK);

CREATE INDEX IdxsourcePK_3001Sn ON prodsforprodlis3001sn (sourcePK);

CREATE INDEX IdxtargetPK_3001Sn ON prodsforprodlis3001sn (targetPK);

CREATE INDEX IdxlanguagePK_3001Sn ON prodsforprodlis3001sn (languagePK);


CREATE CACHED TABLE prodsforprodlistcomprels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_3001 ON prodsforprodlistcomprels (SourcePK);

CREATE INDEX qualifier_3001 ON prodsforprodlistcomprels (Qualifier);

CREATE INDEX rseqnr_3001 ON prodsforprodlistcomprels (RSequenceNumber);

CREATE INDEX linktarget_3001 ON prodsforprodlistcomprels (TargetPK);

CREATE INDEX seqnr_3001 ON prodsforprodlistcomprels (SequenceNumber);


CREATE CACHED TABLE productdelimode2011sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2011Sn ON productdelimode2011sn (ITEMPK);

CREATE INDEX IdxsourcePK_2011Sn ON productdelimode2011sn (sourcePK);

CREATE INDEX IdxtargetPK_2011Sn ON productdelimode2011sn (targetPK);

CREATE INDEX IdxlanguagePK_2011Sn ON productdelimode2011sn (languagePK);


CREATE CACHED TABLE productdelimoderel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2011 ON productdelimoderel (SourcePK);

CREATE INDEX qualifier_2011 ON productdelimoderel (Qualifier);

CREATE INDEX rseqnr_2011 ON productdelimoderel (RSequenceNumber);

CREATE INDEX linktarget_2011 ON productdelimoderel (TargetPK);

CREATE INDEX seqnr_2011 ON productdelimoderel (SequenceNumber);


CREATE CACHED TABLE productfeatures
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_qualifier NVARCHAR(255),
    p_classificationattributeassig BIGINT,
    p_language BIGINT,
    p_valueposition INTEGER,
    p_featureposition INTEGER,
    p_valuetype INTEGER,
    p_stringvalue LONGVARCHAR,
    p_booleanvalue TINYINT,
    p_numbervalue DECIMAL(30,8),
    p_rawvalue LONGVARBINARY,
    p_unit BIGINT,
    p_valuedetails NVARCHAR(255),
    p_description NVARCHAR(255),
    p_productpos INTEGER,
    p_product BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX featureIDX_611 ON productfeatures (p_product);

CREATE INDEX featureIDX2_611 ON productfeatures (p_qualifier);

CREATE INDEX featureIDX3_611 ON productfeatures (p_classificationattributeassig);

CREATE INDEX featureIDX4_611 ON productfeatures (p_product, p_classificationattributeassig, p_featureposition, p_language, p_valueposition);

CREATE INDEX productposPosIDX_611 ON productfeatures (p_productpos);


CREATE CACHED TABLE productfeatures611sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_611Sn ON productfeatures611sn (ITEMPK);


CREATE CACHED TABLE productorderlim2000sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2000Sn ON productorderlim2000sn (ITEMPK);


CREATE CACHED TABLE productorderlimits
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_intervalresolution BIGINT,
    p_intervalvalue INTEGER,
    p_intervalmaxordersnumber INTEGER,
    p_maxnumberperorder INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE productprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX itempk_productprops ON productprops (ITEMPK);

CREATE INDEX nameidx_productprops ON productprops (NAME);

CREATE INDEX realnameidx_productprops ON productprops (REALNAME);


CREATE CACHED TABLE productreferenc606sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_606Sn ON productreferenc606sn (ITEMPK);


CREATE CACHED TABLE productreferences
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_qualifier NVARCHAR(255),
    p_target BIGINT,
    p_quantity INTEGER,
    p_referencetype BIGINT,
    p_icon BIGINT,
    p_preselected TINYINT,
    p_active TINYINT,
    p_sourcepos INTEGER,
    p_source BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX targetIDX_606 ON productreferences (p_target);

CREATE INDEX qualifierIDX_606 ON productreferences (p_qualifier);

CREATE INDEX sourceRelIDX_606 ON productreferences (p_source);

CREATE INDEX sourceposPosIDX_606 ON productreferences (p_sourcepos);


CREATE CACHED TABLE productreferenceslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE products
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_unit BIGINT,
    p_thumbnail BIGINT,
    p_picture BIGINT,
    p_catalog BIGINT,
    p_catalogversion BIGINT,
    p_onlinedate TIMESTAMP,
    p_offlinedate TIMESTAMP,
    p_ean NVARCHAR(255),
    p_supplieralternativeaid NVARCHAR(255),
    p_buyerids LONGVARBINARY,
    p_manufactureraid NVARCHAR(255),
    p_manufacturername NVARCHAR(255),
    p_erpgroupbuyer NVARCHAR(255),
    p_erpgroupsupplier NVARCHAR(255),
    p_deliverytime DOUBLE,
    p_specialtreatmentclasses LONGVARBINARY,
    p_order INTEGER,
    p_approvalstatus BIGINT,
    p_contentunit BIGINT,
    p_numbercontentunits DOUBLE,
    p_minorderquantity INTEGER,
    p_maxorderquantity INTEGER,
    p_orderquantityinterval INTEGER,
    p_pricequantity DOUBLE,
    p_normal LONGVARCHAR,
    p_thumbnails LONGVARCHAR,
    p_detail LONGVARCHAR,
    p_logo LONGVARCHAR,
    p_data_sheet LONGVARCHAR,
    p_others LONGVARCHAR,
    p_startlinenumber INTEGER,
    p_endlinenumber INTEGER,
    p_varianttype BIGINT,
    p_europe1pricefactory_ppg BIGINT,
    p_europe1pricefactory_ptg BIGINT,
    p_europe1pricefactory_pdg BIGINT,
    p_productorderlimit BIGINT,
    p_galleryimages LONGVARCHAR,
    p_sequenceid BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_baseproduct BIGINT,
    p_swatchcolors LONGVARCHAR,
    p_genders LONGVARCHAR,
    PRIMARY KEY (PK)
);

CREATE INDEX Product_Code_1 ON products (p_code);

CREATE INDEX catalogIDX_1 ON products (p_catalog);

CREATE INDEX visibilityIDX_1 ON products (p_approvalstatus, p_onlinedate, p_offlinedate);

CREATE UNIQUE INDEX codeVersionIDX_1 ON products (p_code, p_catalogversion);

CREATE INDEX versionIDX_1 ON products (p_catalogversion);

CREATE INDEX baseproductRelIDX_1 ON products (p_baseproduct);

CREATE INDEX productorderlimitRelIDX_1 ON products (p_productorderlimit);


CREATE CACHED TABLE products1sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1Sn ON products1sn (ITEMPK);


CREATE CACHED TABLE products4restri1081sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1081Sn ON products4restri1081sn (ITEMPK);

CREATE INDEX IdxsourcePK_1081Sn ON products4restri1081sn (sourcePK);

CREATE INDEX IdxtargetPK_1081Sn ON products4restri1081sn (targetPK);

CREATE INDEX IdxlanguagePK_1081Sn ON products4restri1081sn (languagePK);


CREATE CACHED TABLE products4restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1081 ON products4restriction (SourcePK);

CREATE INDEX qualifier_1081 ON products4restriction (Qualifier);

CREATE INDEX rseqnr_1081 ON products4restriction (RSequenceNumber);

CREATE INDEX linktarget_1081 ON products4restriction (TargetPK);

CREATE INDEX seqnr_1081 ON products4restriction (SequenceNumber);


CREATE CACHED TABLE productslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    p_manufacturertypedescription NVARCHAR(255),
    p_segment NVARCHAR(255),
    p_articlestatus LONGVARBINARY,
    p_summary LONGVARCHAR,
    p_style NVARCHAR(255),
    p_size NVARCHAR(255),
    p_color NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE producttaxcodes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_productcode NVARCHAR(255),
    p_taxarea NVARCHAR(255),
    p_taxcode NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX taxCodeLookup_2026 ON producttaxcodes (p_productcode, p_taxarea);

CREATE INDEX taxCode4Product_2026 ON producttaxcodes (p_productcode);


CREATE CACHED TABLE producttaxcodes2026sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2026Sn ON producttaxcodes2026sn (ITEMPK);


CREATE CACHED TABLE productvendorre2010sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2010Sn ON productvendorre2010sn (ITEMPK);

CREATE INDEX IdxsourcePK_2010Sn ON productvendorre2010sn (sourcePK);

CREATE INDEX IdxtargetPK_2010Sn ON productvendorre2010sn (targetPK);

CREATE INDEX IdxlanguagePK_2010Sn ON productvendorre2010sn (languagePK);


CREATE CACHED TABLE productvendorrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2010 ON productvendorrel (SourcePK);

CREATE INDEX qualifier_2010 ON productvendorrel (Qualifier);

CREATE INDEX rseqnr_2010 ON productvendorrel (RSequenceNumber);

CREATE INDEX linktarget_2010 ON productvendorrel (TargetPK);

CREATE INDEX seqnr_2010 ON productvendorrel (SequenceNumber);


CREATE CACHED TABLE promotion
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_title NVARCHAR(255),
    p_description LONGVARCHAR,
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_detailsurl NVARCHAR(255),
    p_enabled TINYINT,
    p_priority INTEGER,
    p_immutablekeyhash NVARCHAR(255),
    p_immutablekey LONGVARCHAR,
    p_promotiongroup BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_productbanner BIGINT,
    p_productfixedunitprice LONGVARCHAR,
    p_percentagediscount DOUBLE,
    p_qualifyingcount INTEGER,
    p_freecount INTEGER,
    p_bundleprices LONGVARCHAR,
    p_qualifyingcountsandbundlepri LONGVARCHAR,
    p_partnerproducts LONGVARCHAR,
    p_partnerprices LONGVARCHAR,
    p_partnerproduct BIGINT,
    p_productdiscountprice LONGVARCHAR,
    p_paymenttype BIGINT,
    p_productthresholdprice LONGVARCHAR,
    p_productpricediscount LONGVARCHAR,
    p_thresholdtotals LONGVARCHAR,
    p_discountproduct BIGINT,
    p_productprices LONGVARCHAR,
    p_includediscountedpriceinthre TINYINT,
    p_discountprices LONGVARCHAR,
    p_giftproduct BIGINT,
    p_freevoucher BIGINT,
    p_deliverymode BIGINT,
    p_rule BIGINT,
    p_ruleversion BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIDX_5010 ON promotion (p_code);

CREATE INDEX enabledIDX_5010 ON promotion (p_enabled);

CREATE INDEX immutableKeyHashIDX_5010 ON promotion (p_immutablekeyhash);

CREATE INDEX promotiongroupRelIDX_5010 ON promotion (p_promotiongroup);


CREATE CACHED TABLE promotion5010sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5010Sn ON promotion5010sn (ITEMPK);


CREATE CACHED TABLE promotionaction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_markedapplied TINYINT,
    p_guid NVARCHAR(255),
    p_promotionresult BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_amount DOUBLE,
    p_orderentryproduct BIGINT,
    p_orderentryquantity BIGINT,
    p_orderentrynumber INTEGER,
    p_freeproduct BIGINT,
    p_deliverymode BIGINT,
    p_rule BIGINT,
    p_strategyid NVARCHAR(255),
    p_metadatahandlers LONGVARBINARY,
    p_usedcouponcodes LONGVARBINARY,
    p_amoun0 DECIMAL(30,8),
    p_product BIGINT,
    p_quantity BIGINT,
    p_deliverycost DECIMAL(30,8),
    p_replaceddeliverymode BIGINT,
    p_replaceddeliverycost DECIMAL(30,8),
    p_parameters LONGVARCHAR,
    p_couponid NVARCHAR(255),
    p_couponcode NVARCHAR(255),
    PRIMARY KEY (PK)
);

CREATE INDEX promotionResultIDX_5015 ON promotionaction (p_promotionresult);


CREATE CACHED TABLE promotionaction5015sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5015Sn ON promotionaction5015sn (ITEMPK);


CREATE CACHED TABLE promotionaction5406sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5406Sn ON promotionaction5406sn (ITEMPK);


CREATE CACHED TABLE promotionactionparameter
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uuid NVARCHAR(255),
    p_value LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE promotiongroup
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_identifier NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX PromotionGroup_IdentifierIDX_5017 ON promotiongroup (p_identifier);


CREATE CACHED TABLE promotiongroup5017sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5017Sn ON promotiongroup5017sn (ITEMPK);


CREATE CACHED TABLE promotionlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_messagefired LONGVARCHAR,
    p_messagecouldhavefired LONGVARCHAR,
    p_messageproductnothreshold LONGVARCHAR,
    p_messagethresholdnoproduct LONGVARCHAR,
    p_promotiondescription LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE promotionpricer5012sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5012Sn ON promotionpricer5012sn (ITEMPK);


CREATE CACHED TABLE promotionpricerow
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_currency BIGINT,
    p_price DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE promotionrestri5011sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5011Sn ON promotionrestri5011sn (ITEMPK);


CREATE CACHED TABLE promotionrestriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_promotion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_products LONGVARCHAR,
    p_positive TINYINT,
    p_users LONGVARCHAR,
    PRIMARY KEY (PK)
);

CREATE INDEX promotionIDX_5011 ON promotionrestriction (p_promotion);


CREATE CACHED TABLE promotionrestrictionlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_descriptionpattern LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE promotionresult
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_promotion BIGINT,
    p_certainty FLOAT,
    p_custom NVARCHAR(255),
    p_order BIGINT,
    p_rulesmodulename NVARCHAR(255),
    p_moduleversion BIGINT,
    p_ruleversion BIGINT,
    p_ordercode NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX orderIDX_5013 ON promotionresult (p_order);

CREATE INDEX promotionIDX_5013 ON promotionresult (p_promotion);


CREATE CACHED TABLE promotionresult5013sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5013Sn ON promotionresult5013sn (ITEMPK);


CREATE CACHED TABLE promotionresultlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_messagefired LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE promrestr2order6221sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6221Sn ON promrestr2order6221sn (ITEMPK);

CREATE INDEX IdxsourcePK_6221Sn ON promrestr2order6221sn (sourcePK);

CREATE INDEX IdxtargetPK_6221Sn ON promrestr2order6221sn (targetPK);

CREATE INDEX IdxlanguagePK_6221Sn ON promrestr2order6221sn (languagePK);


CREATE CACHED TABLE promrestr2orderrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6221 ON promrestr2orderrel (SourcePK);

CREATE INDEX qualifier_6221 ON promrestr2orderrel (Qualifier);

CREATE INDEX rseqnr_6221 ON promrestr2orderrel (RSequenceNumber);

CREATE INDEX linktarget_6221 ON promrestr2orderrel (TargetPK);

CREATE INDEX seqnr_6221 ON promrestr2orderrel (SequenceNumber);


CREATE CACHED TABLE props
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX nameidx_props ON props (NAME);

CREATE INDEX realnameidx_props ON props (REALNAME);

CREATE INDEX itempk_props ON props (ITEMPK);


CREATE CACHED TABLE quantityandpric5016sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5016Sn ON quantityandpric5016sn (ITEMPK);


CREATE CACHED TABLE quantityandpricesrow
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_quantity BIGINT,
    p_prices LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE quoteentries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_baseprice DECIMAL(30,8),
    p_calculated TINYINT,
    p_discountvaluesinternal LONGVARCHAR,
    p_entrynumber INTEGER,
    p_info LONGVARCHAR,
    p_product BIGINT,
    p_quantity DECIMAL(30,8),
    p_taxvaluesinternal NVARCHAR(255),
    p_totalprice DECIMAL(30,8),
    p_unit BIGINT,
    p_giveaway TINYINT,
    p_rejected TINYINT,
    p_entrygroupnumbers LONGVARBINARY,
    p_order BIGINT,
    p_europe1pricefactory_ppg BIGINT,
    p_europe1pricefactory_ptg BIGINT,
    p_europe1pricefactory_pdg BIGINT,
    p_chosenvendor BIGINT,
    p_deliveryaddress BIGINT,
    p_deliverymode BIGINT,
    p_nameddeliverydate TIMESTAMP,
    p_quantitystatus BIGINT,
    p_deliverypointofservice BIGINT,
    p_costcenter BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX oeProd_61 ON quoteentries (p_product);

CREATE INDEX oeOrd_61 ON quoteentries (p_order);


CREATE CACHED TABLE quoteentries61sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_61Sn ON quoteentries61sn (ITEMPK);


CREATE CACHED TABLE quoteentryprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX nameidx_quoteentryprops ON quoteentryprops (NAME);

CREATE INDEX realnameidx_quoteentryprops ON quoteentryprops (REALNAME);

CREATE INDEX itempk_quoteentryprops ON quoteentryprops (ITEMPK);


CREATE CACHED TABLE quoteprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX realnameidx_quoteprops ON quoteprops (REALNAME);

CREATE INDEX itempk_quoteprops ON quoteprops (ITEMPK);

CREATE INDEX nameidx_quoteprops ON quoteprops (NAME);


CREATE CACHED TABLE quotes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_calculated TINYINT,
    p_code NVARCHAR(255),
    p_currency BIGINT,
    p_deliveryaddress BIGINT,
    p_deliverycost DECIMAL(30,8),
    p_deliverymode BIGINT,
    p_deliverystatus BIGINT,
    p_description NVARCHAR(255),
    p_expirationtime TIMESTAMP,
    p_globaldiscountvaluesinternal LONGVARCHAR,
    p_name NVARCHAR(255),
    p_net TINYINT,
    p_paymentaddress BIGINT,
    p_paymentcost DECIMAL(30,8),
    p_paymentinfo BIGINT,
    p_paymentmode BIGINT,
    p_paymentstatus BIGINT,
    p_status BIGINT,
    p_exportstatus BIGINT,
    p_statusinfo NVARCHAR(255),
    p_totalprice DECIMAL(30,8),
    p_totaldiscounts DECIMAL(30,8),
    p_totaltax DECIMAL(30,8),
    p_totaltaxvaluesinternal LONGVARCHAR,
    p_user BIGINT,
    p_subtotal DECIMAL(30,8),
    p_discountsincludedeliverycost TINYINT,
    p_discountsincludepaymentcost TINYINT,
    p_entrygroups LONGVARBINARY,
    p_europe1pricefactory_udg BIGINT,
    p_europe1pricefactory_upg BIGINT,
    p_europe1pricefactory_utg BIGINT,
    p_previousdeliverymode BIGINT,
    p_site BIGINT,
    p_store BIGINT,
    p_guid NVARCHAR(255),
    p_quotediscountvaluesinternal LONGVARCHAR,
    p_locale NVARCHAR(255),
    p_workflow BIGINT,
    p_quoteexpirationdate TIMESTAMP,
    p_unit BIGINT,
    p_purchaseordernumber NVARCHAR(255),
    p_paymenttype BIGINT,
    p_appliedcouponcodes LONGVARBINARY,
    p_version INTEGER,
    p_state BIGINT,
    p_cartreference BIGINT,
    p_previousestimatedtotal DOUBLE,
    p_assignee BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX OrderCode_60 ON quotes (p_code);

CREATE INDEX OrderUser_60 ON quotes (p_user);

CREATE INDEX guidIndex_60 ON quotes (p_guid);

CREATE UNIQUE INDEX version_idx_60 ON quotes (p_code, p_version);

CREATE INDEX assigneeRelIDX_60 ON quotes (p_assignee);

CREATE INDEX unitRelIDX_60 ON quotes (p_unit);


CREATE CACHED TABLE quotes60sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_60Sn ON quotes60sn (ITEMPK);


CREATE CACHED TABLE quotetonotifica6232sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6232Sn ON quotetonotifica6232sn (ITEMPK);

CREATE INDEX IdxsourcePK_6232Sn ON quotetonotifica6232sn (sourcePK);

CREATE INDEX IdxtargetPK_6232Sn ON quotetonotifica6232sn (targetPK);

CREATE INDEX IdxlanguagePK_6232Sn ON quotetonotifica6232sn (languagePK);


CREATE CACHED TABLE quotetonotificationrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6232 ON quotetonotificationrel (SourcePK);

CREATE INDEX qualifier_6232 ON quotetonotificationrel (Qualifier);

CREATE INDEX rseqnr_6232 ON quotetonotificationrel (RSequenceNumber);

CREATE INDEX linktarget_6232 ON quotetonotificationrel (TargetPK);

CREATE INDEX seqnr_6232 ON quotetonotificationrel (SequenceNumber);


CREATE CACHED TABLE regions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_isocode NVARCHAR(255),
    p_country BIGINT,
    p_isocodeshort NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX ISOCode_35 ON regions (p_isocode);

CREATE INDEX Region_Country_35 ON regions (p_country);


CREATE CACHED TABLE regions35sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_35Sn ON regions35sn (ITEMPK);


CREATE CACHED TABLE regionslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE renderersproper13212sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13212Sn ON renderersproper13212sn (ITEMPK);


CREATE CACHED TABLE renderersproperty
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_key NVARCHAR(255),
    p_value NVARCHAR(255),
    p_translatorconfigurationpos INTEGER,
    p_translatorconfiguration BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX translatorconfigurationRelIDX_13212 ON renderersproperty (p_translatorconfiguration);

CREATE INDEX translatorconfigurationposPosIDX_13212 ON renderersproperty (p_translatorconfigurationpos);


CREATE CACHED TABLE renderertemplat13215sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_13215Sn ON renderertemplat13215sn (ITEMPK);


CREATE CACHED TABLE renderertemplate
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_defaultcontent BIGINT,
    p_contextclass NVARCHAR(255),
    p_outputmimetype NVARCHAR(255),
    p_renderertype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_includetext TINYINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE renderertemplatelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    p_content BIGINT,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_name NVARCHAR(255),
    p_catalogversion BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_originalrestriction BIGINT,
    p_recursive TINYINT,
    p_activefrom TIMESTAMP,
    p_activeuntil TIMESTAMP,
    p_usestoretimezone TINYINT,
    p_passifstoredoesntmatch TINYINT,
    p_includesubgroups TINYINT,
    p_uiexperience BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX originalrestrictionRelIDX_1074 ON restriction (p_originalrestriction);


CREATE CACHED TABLE restriction1074sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1074Sn ON restriction1074sn (ITEMPK);


CREATE CACHED TABLE restriction4pag1087sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1087Sn ON restriction4pag1087sn (ITEMPK);

CREATE INDEX IdxsourcePK_1087Sn ON restriction4pag1087sn (sourcePK);

CREATE INDEX IdxtargetPK_1087Sn ON restriction4pag1087sn (targetPK);

CREATE INDEX IdxlanguagePK_1087Sn ON restriction4pag1087sn (languagePK);


CREATE CACHED TABLE restriction4pages
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1087 ON restriction4pages (SourcePK);

CREATE INDEX qualifier_1087 ON restriction4pages (Qualifier);

CREATE INDEX rseqnr_1087 ON restriction4pages (RSequenceNumber);

CREATE INDEX linktarget_1087 ON restriction4pages (TargetPK);

CREATE INDEX seqnr_1087 ON restriction4pages (SequenceNumber);


CREATE CACHED TABLE restrictions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_positive TINYINT,
    p_voucherpos INTEGER,
    p_voucher BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_products LONGVARCHAR,
    p_quantity BIGINT,
    p_unit BIGINT,
    p_categories LONGVARCHAR,
    p_total DOUBLE,
    p_currency BIGINT,
    p_net TINYINT,
    p_valueofgoodsonly TINYINT,
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_users LONGVARCHAR,
    p_orderquantity INTEGER,
    p_allorderstotal DOUBLE,
    PRIMARY KEY (PK)
);

CREATE INDEX voucherRelIDX_1601 ON restrictions (p_voucher);

CREATE INDEX voucherposPosIDX_1601 ON restrictions (p_voucherpos);


CREATE CACHED TABLE restrictions1601sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1601Sn ON restrictions1601sn (ITEMPK);


CREATE CACHED TABLE restrictions4co1091sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1091Sn ON restrictions4co1091sn (ITEMPK);

CREATE INDEX IdxsourcePK_1091Sn ON restrictions4co1091sn (sourcePK);

CREATE INDEX IdxtargetPK_1091Sn ON restrictions4co1091sn (targetPK);

CREATE INDEX IdxlanguagePK_1091Sn ON restrictions4co1091sn (languagePK);


CREATE CACHED TABLE restrictions4comps
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1091 ON restrictions4comps (SourcePK);

CREATE INDEX qualifier_1091 ON restrictions4comps (Qualifier);

CREATE INDEX rseqnr_1091 ON restrictions4comps (RSequenceNumber);

CREATE INDEX linktarget_1091 ON restrictions4comps (TargetPK);

CREATE INDEX seqnr_1091 ON restrictions4comps (SequenceNumber);


CREATE CACHED TABLE restrictionslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    p_violationmessage NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE retentionrule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_actionreference NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_retirementitemtype BIGINT,
    p_retirementdateattribute BIGINT,
    p_retentiontimeseconds BIGINT,
    p_itemfilterexpression NVARCHAR(255),
    p_retirementdateexpression NVARCHAR(255),
    p_searchquery LONGVARCHAR,
    p_queryparameters LONGVARBINARY,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE retentionrule983sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_983Sn ON retentionrule983sn (ITEMPK);


CREATE CACHED TABLE returnentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_orderentry BIGINT,
    p_expectedquantity BIGINT,
    p_receivedquantity BIGINT,
    p_reacheddate TIMESTAMP,
    p_status BIGINT,
    p_action BIGINT,
    p_notes NVARCHAR(255),
    p_tax DECIMAL(30,8),
    p_returnrequestpos INTEGER,
    p_returnrequest BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_reason BIGINT,
    p_amount DECIMAL(30,8),
    p_refundeddate TIMESTAMP,
    PRIMARY KEY (PK)
);

CREATE INDEX returnrequestRelIDX_2052 ON returnentry (p_returnrequest);

CREATE INDEX returnrequestposPosIDX_2052 ON returnentry (p_returnrequestpos);


CREATE CACHED TABLE returnentry2052sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2052Sn ON returnentry2052sn (ITEMPK);


CREATE CACHED TABLE returnrequest
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_rma NVARCHAR(255),
    p_replacementorder BIGINT,
    p_currency BIGINT,
    p_status BIGINT,
    p_subtotal DECIMAL(30,8),
    p_totaltax DECIMAL(30,8),
    p_returnlabel BIGINT,
    p_returnform BIGINT,
    p_returnwarehouse BIGINT,
    p_orderpos INTEGER,
    p_order BIGINT,
    p_refunddeliverycost TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX rmaIdx_2051 ON returnrequest (p_rma);

CREATE INDEX orderRelIDX_2051 ON returnrequest (p_order);

CREATE INDEX orderposPosIDX_2051 ON returnrequest (p_orderpos);


CREATE CACHED TABLE returnrequest2051sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2051Sn ON returnrequest2051sn (ITEMPK);


CREATE CACHED TABLE ruleactdefcatre5307sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5307Sn ON ruleactdefcatre5307sn (ITEMPK);

CREATE INDEX IdxsourcePK_5307Sn ON ruleactdefcatre5307sn (sourcePK);

CREATE INDEX IdxtargetPK_5307Sn ON ruleactdefcatre5307sn (targetPK);

CREATE INDEX IdxlanguagePK_5307Sn ON ruleactdefcatre5307sn (languagePK);


CREATE CACHED TABLE ruleactdefcatrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_5307 ON ruleactdefcatrel (SourcePK);

CREATE INDEX qualifier_5307 ON ruleactdefcatrel (Qualifier);

CREATE INDEX rseqnr_5307 ON ruleactdefcatrel (RSequenceNumber);

CREATE INDEX linktarget_5307 ON ruleactdefcatrel (TargetPK);

CREATE INDEX seqnr_5307 ON ruleactdefcatrel (SequenceNumber);


CREATE CACHED TABLE ruleactdefrulet5309sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5309Sn ON ruleactdefrulet5309sn (ITEMPK);


CREATE CACHED TABLE ruleactdefruletypemap
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_ruletype BIGINT,
    p_definition BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX definitionRelIDX_5309 ON ruleactdefruletypemap (p_definition);


CREATE CACHED TABLE ruleactiondef
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_priority INTEGER,
    p_translatorid NVARCHAR(255),
    p_translatorparameters LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE ruleactiondef5303sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5303Sn ON ruleactiondef5303sn (ITEMPK);


CREATE CACHED TABLE ruleactiondefca5305sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5305Sn ON ruleactiondefca5305sn (ITEMPK);


CREATE CACHED TABLE ruleactiondefcat
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_priority INTEGER,
    p_icon BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE ruleactiondefcatlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE ruleactiondeflp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_breadcrumb NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE ruleactiondefpa5304sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5304Sn ON ruleactiondefpa5304sn (ITEMPK);


CREATE CACHED TABLE ruleactiondefparam
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_priority INTEGER,
    p_type NVARCHAR(255),
    p_value NVARCHAR(255),
    p_required TINYINT,
    p_validators LONGVARBINARY,
    p_filters LONGVARBINARY,
    p_defaulteditor NVARCHAR(255),
    p_definitionpos INTEGER,
    p_definition BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX definitionRelIDX_5304 ON ruleactiondefparam (p_definition);

CREATE INDEX definitionposPosIDX_5304 ON ruleactiondefparam (p_definitionpos);


CREATE CACHED TABLE ruleactiondefparamlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE ruleconddef
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_priority INTEGER,
    p_allowschildren TINYINT,
    p_translatorid NVARCHAR(255),
    p_translatorparameters LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE ruleconddef5300sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5300Sn ON ruleconddef5300sn (ITEMPK);


CREATE CACHED TABLE ruleconddefcat
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_priority INTEGER,
    p_icon BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE ruleconddefcat5302sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5302Sn ON ruleconddefcat5302sn (ITEMPK);


CREATE CACHED TABLE ruleconddefcatlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE ruleconddefcatr5306sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5306Sn ON ruleconddefcatr5306sn (ITEMPK);

CREATE INDEX IdxsourcePK_5306Sn ON ruleconddefcatr5306sn (sourcePK);

CREATE INDEX IdxtargetPK_5306Sn ON ruleconddefcatr5306sn (targetPK);

CREATE INDEX IdxlanguagePK_5306Sn ON ruleconddefcatr5306sn (languagePK);


CREATE CACHED TABLE ruleconddefcatrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_5306 ON ruleconddefcatrel (SourcePK);

CREATE INDEX qualifier_5306 ON ruleconddefcatrel (Qualifier);

CREATE INDEX rseqnr_5306 ON ruleconddefcatrel (RSequenceNumber);

CREATE INDEX linktarget_5306 ON ruleconddefcatrel (TargetPK);

CREATE INDEX seqnr_5306 ON ruleconddefcatrel (SequenceNumber);


CREATE CACHED TABLE ruleconddeflp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_breadcrumb NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE ruleconddefpara5301sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5301Sn ON ruleconddefpara5301sn (ITEMPK);


CREATE CACHED TABLE ruleconddefparam
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_priority INTEGER,
    p_type NVARCHAR(255),
    p_value NVARCHAR(255),
    p_required TINYINT,
    p_validators LONGVARBINARY,
    p_filters LONGVARBINARY,
    p_defaulteditor NVARCHAR(255),
    p_definitionpos INTEGER,
    p_definition BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX definitionRelIDX_5301 ON ruleconddefparam (p_definition);

CREATE INDEX definitionposPosIDX_5301 ON ruleconddefparam (p_definitionpos);


CREATE CACHED TABLE ruleconddefparamlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE rulecondefrulet5308sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5308Sn ON rulecondefrulet5308sn (ITEMPK);


CREATE CACHED TABLE rulecondefruletypemap
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_ruletype BIGINT,
    p_definition BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX definitionRelIDX_5308 ON rulecondefruletypemap (p_definition);


CREATE CACHED TABLE ruleengineconte5102sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5102Sn ON ruleengineconte5102sn (ITEMPK);


CREATE CACHED TABLE ruleenginecontext
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_kiesession BIGINT,
    p_rulefiringlimit BIGINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE rulegroup
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_exclusive TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE rulegroup5104sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5104Sn ON rulegroup5104sn (ITEMPK);


CREATE CACHED TABLE rulegrouplp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE rules
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uuid NVARCHAR(255),
    p_code NVARCHAR(255),
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_priority INTEGER,
    p_maxallowedruns INTEGER,
    p_stackable TINYINT,
    p_status BIGINT,
    p_version BIGINT,
    p_rulesmodules LONGVARCHAR,
    p_rulegroup BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_conditions LONGVARCHAR,
    p_actions LONGVARCHAR,
    p_excludefromstorefrontdisplay TINYINT,
    p_website BIGINT,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX UC_Abstract_Rule_5103 ON rules (p_code, p_version);

CREATE INDEX rulegroupRelIDX_5103 ON rules (p_rulegroup);

CREATE INDEX websiteRelIDX_5103 ON rules (p_website);


CREATE CACHED TABLE rules5103sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5103Sn ON rules5103sn (ITEMPK);


CREATE CACHED TABLE ruleslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    p_messagefired LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE rulesmodule
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_ruletype BIGINT,
    p_active TINYINT,
    p_version BIGINT,
    p_allowedtargets LONGVARCHAR,
    p_lockacquired TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_mvngroupid NVARCHAR(255),
    p_mvnartifactid NVARCHAR(255),
    p_mvnversion NVARCHAR(255),
    p_deployedmvnversion NVARCHAR(255),
    p_defaultkiebase BIGINT,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX IdxAbstractRuleModuleUnique_5101 ON rulesmodule (p_name);

CREATE UNIQUE INDEX IdxDroolsKIEModuleUnique_5101 ON rulesmodule (p_mvnartifactid);


CREATE CACHED TABLE rulesmodule5101sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5101Sn ON rulesmodule5101sn (ITEMPK);


CREATE CACHED TABLE ruletemplates
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_maxallowedruns INTEGER,
    p_rulegroup BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_conditions LONGVARCHAR,
    p_actions LONGVARCHAR,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX UC_Abstract_Rule_Template_5106 ON ruletemplates (p_code);

CREATE INDEX rulegroupRelIDX_5106 ON ruletemplates (p_rulegroup);


CREATE CACHED TABLE ruletemplates5106sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5106Sn ON ruletemplates5106sn (ITEMPK);


CREATE CACHED TABLE ruletemplateslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    p_messagefired LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE ruletoenginerul5105sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5105Sn ON ruletoenginerul5105sn (ITEMPK);


CREATE CACHED TABLE ruletoengineruletypemap
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_ruletype BIGINT,
    p_engineruletype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE savedqueries
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_paramtypes LONGVARCHAR,
    p_params LONGVARBINARY,
    p_query LONGVARCHAR,
    p_resulttype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE savedqueries150sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_150Sn ON savedqueries150sn (ITEMPK);


CREATE CACHED TABLE savedquerieslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE savedquery2user6402sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6402Sn ON savedquery2user6402sn (ITEMPK);

CREATE INDEX IdxsourcePK_6402Sn ON savedquery2user6402sn (sourcePK);

CREATE INDEX IdxtargetPK_6402Sn ON savedquery2user6402sn (targetPK);

CREATE INDEX IdxlanguagePK_6402Sn ON savedquery2user6402sn (languagePK);


CREATE CACHED TABLE savedquery2usergrouprel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6402 ON savedquery2usergrouprel (SourcePK);

CREATE INDEX qualifier_6402 ON savedquery2usergrouprel (Qualifier);

CREATE INDEX rseqnr_6402 ON savedquery2usergrouprel (RSequenceNumber);

CREATE INDEX linktarget_6402 ON savedquery2usergrouprel (TargetPK);

CREATE INDEX seqnr_6402 ON savedquery2usergrouprel (SequenceNumber);


CREATE CACHED TABLE savedvalueentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_modifiedattribute NVARCHAR(255),
    p_oldvalueattributedescriptor BIGINT,
    p_parent BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX parentRelIDX_335 ON savedvalueentry (p_parent);


CREATE CACHED TABLE savedvalueentry335sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_335Sn ON savedvalueentry335sn (ITEMPK);


CREATE CACHED TABLE savedvalues
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_modifieditemtype BIGINT,
    p_timestamp TIMESTAMP,
    p_user BIGINT,
    p_modificationtype BIGINT,
    p_modifieditempos INTEGER,
    p_modifieditem BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX savedvalmoditem_334 ON savedvalues (p_modifieditem);

CREATE INDEX modifieditemposPosIDX_334 ON savedvalues (p_modifieditempos);


CREATE CACHED TABLE savedvalues334sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_334Sn ON savedvalues334sn (ITEMPK);


CREATE CACHED TABLE scripts
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_active TINYINT,
    p_checksum NVARCHAR(255),
    p_content LONGVARCHAR,
    p_version BIGINT,
    p_scripttype BIGINT,
    p_autodisabling TINYINT,
    p_disabled TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeVersionActiveIDX_100 ON scripts (p_code, p_version, p_active);


CREATE CACHED TABLE scripts100sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_100Sn ON scripts100sn (ITEMPK);


CREATE CACHED TABLE scriptslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE searchrestricti90sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_90Sn ON searchrestricti90sn (ITEMPK);


CREATE CACHED TABLE searchrestrictions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_extensionname NVARCHAR(255),
    p_autocreate TINYINT,
    p_generate TINYINT,
    p_code NVARCHAR(255),
    p_active TINYINT,
    principal BIGINT,
    query LONGVARCHAR,
    RestrictedType BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX principal_90 ON searchrestrictions (principal);

CREATE INDEX restrtype_90 ON searchrestrictions (RestrictedType);


CREATE CACHED TABLE searchrestrictionslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE sessionevent
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_eventtime TIMESTAMP,
    p_agent BIGINT,
    p_sessionid NVARCHAR(255),
    p_basesite BIGINT,
    p_groups LONGVARCHAR,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_customer BIGINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE sessionevent9008sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_9008Sn ON sessionevent9008sn (ITEMPK);


CREATE CACHED TABLE sitemapconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_configid NVARCHAR(255),
    p_sitemaplanguagecurrencies LONGVARCHAR,
    p_sitemappages LONGVARCHAR,
    p_sitemaptemplate BIGINT,
    p_customurls LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE sitemapconfig6224sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6224Sn ON sitemapconfig6224sn (ITEMPK);


CREATE CACHED TABLE sitemaplanguage6223sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6223Sn ON sitemaplanguage6223sn (ITEMPK);


CREATE CACHED TABLE sitemaplanguagecurrency
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_language BIGINT,
    p_currency BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE sitemappage
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code BIGINT,
    p_frequency BIGINT,
    p_priority DOUBLE,
    p_active TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE sitemappage6225sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6225Sn ON sitemappage6225sn (ITEMPK);


CREATE CACHED TABLE slactions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_type BIGINT,
    p_target NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE slactions1000sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1000Sn ON slactions1000sn (ITEMPK);


CREATE CACHED TABLE slotsforpage
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_catalogversion BIGINT,
    p_position NVARCHAR(255),
    p_page BIGINT,
    p_contentslot BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE slotsforpage1071sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1071Sn ON slotsforpage1071sn (ITEMPK);


CREATE CACHED TABLE slotsfortemplat1069sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1069Sn ON slotsfortemplat1069sn (ITEMPK);


CREATE CACHED TABLE slotsfortemplate
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_catalogversion BIGINT,
    p_allowoverwrite TINYINT,
    p_position NVARCHAR(255),
    p_pagetemplate BIGINT,
    p_contentslot BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE slrcnf2valrngse2214sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2214Sn ON slrcnf2valrngse2214sn (ITEMPK);

CREATE INDEX IdxsourcePK_2214Sn ON slrcnf2valrngse2214sn (sourcePK);

CREATE INDEX IdxtargetPK_2214Sn ON slrcnf2valrngse2214sn (targetPK);

CREATE INDEX IdxlanguagePK_2214Sn ON slrcnf2valrngse2214sn (languagePK);


CREATE CACHED TABLE slrcnf2valrngsetrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2214 ON slrcnf2valrngsetrel (SourcePK);

CREATE INDEX qualifier_2214 ON slrcnf2valrngsetrel (Qualifier);

CREATE INDEX rseqnr_2214 ON slrcnf2valrngsetrel (RSequenceNumber);

CREATE INDEX linktarget_2214 ON slrcnf2valrngsetrel (TargetPK);

CREATE INDEX seqnr_2214 ON slrcnf2valrngsetrel (SequenceNumber);


CREATE CACHED TABLE slridprp2valrns2215sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2215Sn ON slridprp2valrns2215sn (ITEMPK);

CREATE INDEX IdxsourcePK_2215Sn ON slridprp2valrns2215sn (sourcePK);

CREATE INDEX IdxtargetPK_2215Sn ON slridprp2valrns2215sn (targetPK);

CREATE INDEX IdxlanguagePK_2215Sn ON slridprp2valrns2215sn (languagePK);


CREATE CACHED TABLE slridprp2valrnstrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2215 ON slridprp2valrnstrel (SourcePK);

CREATE INDEX qualifier_2215 ON slridprp2valrnstrel (Qualifier);

CREATE INDEX rseqnr_2215 ON slridprp2valrnstrel (RSequenceNumber);

CREATE INDEX linktarget_2215 ON slridprp2valrnstrel (TargetPK);

CREATE INDEX seqnr_2215 ON slridprp2valrnstrel (SequenceNumber);


CREATE CACHED TABLE smarteditconfig3501sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_3501Sn ON smarteditconfig3501sn (ITEMPK);


CREATE CACHED TABLE smarteditconfiguration
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_key NVARCHAR(255),
    p_value NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrabskwrdredi2221sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2221Sn ON solrabskwrdredi2221sn (ITEMPK);


CREATE CACHED TABLE solrabskwrdredir
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_url NVARCHAR(255),
    p_redirectitem BIGINT,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrendpointurl
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_url NVARCHAR(255),
    p_master TINYINT,
    p_solrserverconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX solrserverconfigRelIDX_2213 ON solrendpointurl (p_solrserverconfig);


CREATE CACHED TABLE solrendpointurl2213sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2213Sn ON solrendpointurl2213sn (ITEMPK);


CREATE CACHED TABLE solrindex
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_facetsearchconfig BIGINT,
    p_indexedtype BIGINT,
    p_qualifier NVARCHAR(255),
    p_active TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX SolrIndex_2225 ON solrindex (p_facetsearchconfig, p_indexedtype, p_qualifier);


CREATE CACHED TABLE solrindex2225sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2225Sn ON solrindex2225sn (ITEMPK);


CREATE CACHED TABLE solrindexconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_batchsize INTEGER,
    p_exportpath NVARCHAR(255),
    p_numberofthreads INTEGER,
    p_indexmode BIGINT,
    p_commitmode BIGINT,
    p_optimizemode BIGINT,
    p_ignoreerrors TINYINT,
    p_legacymode TINYINT,
    p_maxretries INTEGER,
    p_maxbatchretries INTEGER,
    p_distributedindexing TINYINT,
    p_nodegroup NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrindexconfig2211sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2211Sn ON solrindexconfig2211sn (ITEMPK);


CREATE CACHED TABLE solrindexedcore2217sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2217Sn ON solrindexedcore2217sn (ITEMPK);


CREATE CACHED TABLE solrindexedcoresrecord
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_corename NVARCHAR(255),
    p_indexname NVARCHAR(255),
    p_indextime TIMESTAMP,
    p_currentindexdatasubdirectory NVARCHAR(255),
    p_servermode BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrindexedprop2208sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2208Sn ON solrindexedprop2208sn (ITEMPK);


CREATE CACHED TABLE solrindexedproperty
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_type BIGINT,
    p_sortabletype BIGINT,
    p_facet TINYINT,
    p_localized TINYINT,
    p_currency TINYINT,
    p_multivalue TINYINT,
    p_rangeset BIGINT,
    p_facetdisplaynameprovider NVARCHAR(255),
    p_facettype BIGINT,
    p_fieldvalueprovider NVARCHAR(255),
    p_valueproviderparameter NVARCHAR(255),
    p_valueproviderparameters LONGVARBINARY,
    p_exportid NVARCHAR(255),
    p_useforspellchecking TINYINT,
    p_useforautocomplete TINYINT,
    p_priority INTEGER,
    p_includeinresponse TINYINT,
    p_useforhighlighting TINYINT,
    p_customfacetsortprovider NVARCHAR(255),
    p_topvaluesprovider NVARCHAR(255),
    p_ftsquery TINYINT,
    p_ftsquerymintermlength INTEGER,
    p_ftsqueryboost FLOAT,
    p_ftsfuzzyquery TINYINT,
    p_ftsfuzzyquerymintermlength INTEGER,
    p_ftsfuzzyqueryfuzziness INTEGER,
    p_ftsfuzzyqueryboost FLOAT,
    p_ftswildcardquery TINYINT,
    p_ftswildcardquerymintermlengt INTEGER,
    p_ftswildcardquerytype BIGINT,
    p_ftswildcardqueryboost FLOAT,
    p_ftsphrasequery TINYINT,
    p_ftsphrasequeryslop FLOAT,
    p_ftsphrasequeryboost FLOAT,
    p_classattributeassignment BIGINT,
    p_categoryfield TINYINT,
    p_visible TINYINT,
    p_solrindexedtypepos INTEGER,
    p_solrindexedtype BIGINT,
    p_facetsort BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX solrindexedtypeRelIDX_2208 ON solrindexedproperty (p_solrindexedtype);

CREATE INDEX solrindexedtypeposPosIDX_2208 ON solrindexedproperty (p_solrindexedtypepos);


CREATE CACHED TABLE solrindexedpropertylp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_displayname NVARCHAR(255),
    p_backofficedisplayname NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE solrindexedtype
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_identifier NVARCHAR(255),
    p_type BIGINT,
    p_variant TINYINT,
    p_identityprovider NVARCHAR(255),
    p_modelloader NVARCHAR(255),
    p_defaultfieldvalueprovider NVARCHAR(255),
    p_valuesprovider NVARCHAR(255),
    p_indexname NVARCHAR(255),
    p_solrresultconverter NVARCHAR(255),
    p_group TINYINT,
    p_groupfieldname NVARCHAR(255),
    p_grouplimit INTEGER,
    p_groupfacets TINYINT,
    p_listeners LONGVARBINARY,
    p_configset NVARCHAR(255),
    p_ftsquerybuilder NVARCHAR(255),
    p_ftsquerybuilderparameters LONGVARBINARY,
    p_additionalparameters LONGVARBINARY,
    p_solrfacetsearchconfigpos INTEGER,
    p_solrfacetsearchconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX solrfacetsearchconfigRelIDX_2207 ON solrindexedtype (p_solrfacetsearchconfig);

CREATE INDEX solrfacetsearchconfigposPosIDX_2207 ON solrindexedtype (p_solrfacetsearchconfigpos);


CREATE CACHED TABLE solrindexedtype2207sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2207Sn ON solrindexedtype2207sn (ITEMPK);


CREATE CACHED TABLE solrindexerquer2209sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2209Sn ON solrindexerquer2209sn (ITEMPK);


CREATE CACHED TABLE solrindexerquer2210sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2210Sn ON solrindexerquer2210sn (ITEMPK);


CREATE CACHED TABLE solrindexerquery
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_identifier NVARCHAR(255),
    p_type BIGINT,
    p_query LONGVARCHAR,
    p_injectlastindextime TINYINT,
    p_injectcurrenttime TINYINT,
    p_injectcurrentdate TINYINT,
    p_user BIGINT,
    p_parameterprovider NVARCHAR(255),
    p_solrindexedtypepos INTEGER,
    p_solrindexedtype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX solrindexedtypeRelIDX_2209 ON solrindexerquery (p_solrindexedtype);

CREATE INDEX solrindexedtypeposPosIDX_2209 ON solrindexerquery (p_solrindexedtypepos);


CREATE CACHED TABLE solrindexerqueryparam
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_value NVARCHAR(255),
    p_solrindexerquerypos INTEGER,
    p_solrindexerquery BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX solrindexerqueryRelIDX_2210 ON solrindexerqueryparam (p_solrindexerquery);

CREATE INDEX solrindexerqueryposPosIDX_2210 ON solrindexerqueryparam (p_solrindexerquerypos);


CREATE CACHED TABLE solrindexoperat2224sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2224Sn ON solrindexoperat2224sn (ITEMPK);


CREATE CACHED TABLE solrindexoperat2226sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2226Sn ON solrindexoperat2226sn (ITEMPK);


CREATE CACHED TABLE solrindexoperation
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id BIGINT,
    p_operation BIGINT,
    p_external TINYINT,
    p_status BIGINT,
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_index BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX SolrIndexOperation_2226 ON solrindexoperation (p_id);

CREATE INDEX indexRelIDX_2226 ON solrindexoperation (p_index);


CREATE CACHED TABLE solrindexoperationrecord
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_starttime TIMESTAMP,
    p_finishtime TIMESTAMP,
    p_mode BIGINT,
    p_status BIGINT,
    p_threadid NVARCHAR(255),
    p_clusterid INTEGER,
    p_failedreason NVARCHAR(255),
    p_solrindexcorerecordpos INTEGER,
    p_solrindexcorerecord BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX SolrIndexOperationRecord_2224 ON solrindexoperationrecord (p_threadid, p_clusterid, p_mode, p_status, p_solrindexcorerecord);

CREATE INDEX solrindexcorerecordRelIDX_2224 ON solrindexoperationrecord (p_solrindexcorerecord);

CREATE INDEX solrindexcorerecordposPosIDX_2224 ON solrindexoperationrecord (p_solrindexcorerecordpos);


CREATE CACHED TABLE solrkeywredirec2223sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2223Sn ON solrkeywredirec2223sn (ITEMPK);


CREATE CACHED TABLE solrkeywredirects
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_language BIGINT,
    p_keyword NVARCHAR(255),
    p_matchtype BIGINT,
    p_ignorecase TINYINT,
    p_redirect BIGINT,
    p_facetsearchconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX facetsearchconfigRelIDX_2223 ON solrkeywredirects (p_facetsearchconfig);


CREATE CACHED TABLE solrmodifiedent6701sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6701Sn ON solrmodifiedent6701sn (ITEMPK);


CREATE CACHED TABLE solrmodifiedentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_modifiedtypecode NVARCHAR(255),
    p_modifiedpk BIGINT,
    p_modificationtype BIGINT,
    p_parent BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX parentRelIDX_6701 ON solrmodifiedentry (p_parent);


CREATE CACHED TABLE solrqueryaggreg2220sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2220Sn ON solrqueryaggreg2220sn (ITEMPK);


CREATE CACHED TABLE solrqueryaggregatedstats
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_time TIMESTAMP,
    p_indexconfig BIGINT,
    p_language BIGINT,
    p_query NVARCHAR(255),
    p_count BIGINT,
    p_avgnumberofresults DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrsearchconfi2206sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2206Sn ON solrsearchconfi2206sn (ITEMPK);


CREATE CACHED TABLE solrsearchconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_pagesize INTEGER,
    p_defaultsortorder LONGVARBINARY,
    p_description NVARCHAR(255),
    p_restrictfieldsinresponse TINYINT,
    p_enablehighlighting TINYINT,
    p_allfacetvaluesinresponse TINYINT,
    p_legacymode TINYINT,
    p_groupingproperty BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrsearchquery2227sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2227Sn ON solrsearchquery2227sn (ITEMPK);


CREATE CACHED TABLE solrsearchquery2228sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2228Sn ON solrsearchquery2228sn (ITEMPK);


CREATE CACHED TABLE solrsearchquery2229sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2229Sn ON solrsearchquery2229sn (ITEMPK);


CREATE CACHED TABLE solrsearchqueryproperty
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_priority INTEGER,
    p_includeinresponse TINYINT,
    p_useforhighlighting TINYINT,
    p_facet TINYINT,
    p_facettype BIGINT,
    p_facetdisplaynameprovider NVARCHAR(255),
    p_facetsortprovider NVARCHAR(255),
    p_facettopvaluesprovider NVARCHAR(255),
    p_ftsquery TINYINT,
    p_ftsquerymintermlength INTEGER,
    p_ftsqueryboost FLOAT,
    p_ftsfuzzyquery TINYINT,
    p_ftsfuzzyquerymintermlength INTEGER,
    p_ftsfuzzyqueryfuzziness INTEGER,
    p_ftsfuzzyqueryboost FLOAT,
    p_ftswildcardquery TINYINT,
    p_ftswildcardquerymintermlengt INTEGER,
    p_ftswildcardquerytype BIGINT,
    p_ftswildcardqueryboost FLOAT,
    p_ftsphrasequery TINYINT,
    p_ftsphrasequeryslop FLOAT,
    p_ftsphrasequeryboost FLOAT,
    p_indexedpropertypos INTEGER,
    p_indexedproperty BIGINT,
    p_searchquerytemplatepos INTEGER,
    p_searchquerytemplate BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX indexedpropertyRelIDX_2228 ON solrsearchqueryproperty (p_indexedproperty);

CREATE INDEX indexedpropertyposPosIDX_2228 ON solrsearchqueryproperty (p_indexedpropertypos);

CREATE INDEX searchquerytemplateRelIDX_2228 ON solrsearchqueryproperty (p_searchquerytemplate);

CREATE INDEX searchquerytemplateposPosIDX_2228 ON solrsearchqueryproperty (p_searchquerytemplatepos);


CREATE CACHED TABLE solrsearchquerysort
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_field NVARCHAR(255),
    p_ascending TINYINT,
    p_searchquerytemplatepos INTEGER,
    p_searchquerytemplate BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX searchquerytemplateRelIDX_2229 ON solrsearchquerysort (p_searchquerytemplate);

CREATE INDEX searchquerytemplateposPosIDX_2229 ON solrsearchquerysort (p_searchquerytemplatepos);


CREATE CACHED TABLE solrsearchquerytemplate
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_showfacets TINYINT,
    p_restrictfieldsinresponse TINYINT,
    p_enablehighlighting TINYINT,
    p_group TINYINT,
    p_groupproperty BIGINT,
    p_grouplimit INTEGER,
    p_groupfacets TINYINT,
    p_pagesize INTEGER,
    p_ftsquerybuilder NVARCHAR(255),
    p_ftsquerybuilderparameters LONGVARBINARY,
    p_indexedtypepos INTEGER,
    p_indexedtype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX uniqueIdx_2227 ON solrsearchquerytemplate (p_name, p_indexedtype);

CREATE INDEX indexedtypeRelIDX_2227 ON solrsearchquerytemplate (p_indexedtype);

CREATE INDEX indexedtypeposPosIDX_2227 ON solrsearchquerytemplate (p_indexedtypepos);


CREATE CACHED TABLE solrserverconfi2212sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2212Sn ON solrserverconfi2212sn (ITEMPK);


CREATE CACHED TABLE solrserverconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_mode BIGINT,
    p_embeddedmaster TINYINT,
    p_alivecheckinterval INTEGER,
    p_connectiontimeout INTEGER,
    p_sockettimeout INTEGER,
    p_tcpnodelay TINYINT,
    p_maxtotalconnections INTEGER,
    p_maxtotalconnectionsperhostco INTEGER,
    p_username NVARCHAR(255),
    p_password NVARCHAR(255),
    p_indexingalivecheckinterval INTEGER,
    p_indexingconnectiontimeout INTEGER,
    p_indexingsockettimeout INTEGER,
    p_indexingtcpnodelay TINYINT,
    p_indexingmaxtotalconnections INTEGER,
    p_indexingmaxtotalconnectionsp INTEGER,
    p_indexingusername NVARCHAR(255),
    p_indexingpassword NVARCHAR(255),
    p_readtimeout INTEGER,
    p_usemasternodeexclusivelyfori TINYINT,
    p_numshards INTEGER,
    p_replicationfactor INTEGER,
    p_solrquerymethod BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE solrsort
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_useboost TINYINT,
    p_indexedtypepos INTEGER,
    p_indexedtype BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX indexedtypeRelIDX_6205 ON solrsort (p_indexedtype);

CREATE INDEX indexedtypeposPosIDX_6205 ON solrsort (p_indexedtypepos);


CREATE CACHED TABLE solrsort6205sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6205Sn ON solrsort6205sn (ITEMPK);


CREATE CACHED TABLE solrsortfield
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_fieldname NVARCHAR(255),
    p_ascending TINYINT,
    p_sortpos INTEGER,
    p_sort BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX sortRelIDX_6206 ON solrsortfield (p_sort);

CREATE INDEX sortposPosIDX_6206 ON solrsortfield (p_sortpos);


CREATE CACHED TABLE solrsortfield6206sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6206Sn ON solrsortfield6206sn (ITEMPK);


CREATE CACHED TABLE solrsortlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE solrstopword
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_stopword NVARCHAR(255),
    p_languagepos INTEGER,
    p_language BIGINT,
    p_facetsearchconfigpos INTEGER,
    p_facetsearchconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX languageRelIDX_2222 ON solrstopword (p_language);

CREATE INDEX languageposPosIDX_2222 ON solrstopword (p_languagepos);

CREATE INDEX facetsearchconfigRelIDX_2222 ON solrstopword (p_facetsearchconfig);

CREATE INDEX facetsearchconfigposPosIDX_2222 ON solrstopword (p_facetsearchconfigpos);


CREATE CACHED TABLE solrstopword2222sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2222Sn ON solrstopword2222sn (ITEMPK);


CREATE CACHED TABLE solrsynonymconf2218sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2218Sn ON solrsynonymconf2218sn (ITEMPK);


CREATE CACHED TABLE solrsynonymconfig
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_synonymfrom NVARCHAR(255),
    p_synonymto NVARCHAR(255),
    p_languagepos INTEGER,
    p_language BIGINT,
    p_facetsearchconfigpos INTEGER,
    p_facetsearchconfig BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX languageRelIDX_2218 ON solrsynonymconfig (p_language);

CREATE INDEX languageposPosIDX_2218 ON solrsynonymconfig (p_languagepos);

CREATE INDEX facetsearchconfigRelIDX_2218 ON solrsynonymconfig (p_facetsearchconfig);

CREATE INDEX facetsearchconfigposPosIDX_2218 ON solrsynonymconfig (p_facetsearchconfigpos);


CREATE CACHED TABLE solrvaluerange
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_from NVARCHAR(255),
    p_to NVARCHAR(255),
    p_solrvaluerangesetpos INTEGER,
    p_solrvaluerangeset BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX solrvaluerangesetRelIDX_2205 ON solrvaluerange (p_solrvaluerangeset);

CREATE INDEX solrvaluerangesetposPosIDX_2205 ON solrvaluerange (p_solrvaluerangesetpos);


CREATE CACHED TABLE solrvaluerange2205sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2205Sn ON solrvaluerange2205sn (ITEMPK);


CREATE CACHED TABLE solrvalueranges2204sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2204Sn ON solrvalueranges2204sn (ITEMPK);


CREATE CACHED TABLE solrvaluerangeset
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_name NVARCHAR(255),
    p_type NVARCHAR(255),
    p_qualifier NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE stdpaymmodevals
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_currency BIGINT,
    p_value DOUBLE,
    p_paymentmode BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX paymentmodeRelIDX_1022 ON stdpaymmodevals (p_paymentmode);


CREATE CACHED TABLE stdpaymmodevals1022sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1022Sn ON stdpaymmodevals1022sn (ITEMPK);


CREATE CACHED TABLE steps
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_batchjob BIGINT,
    p_code NVARCHAR(255),
    p_sequencenumber INTEGER,
    p_synchronous TINYINT,
    p_errormode BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX IdxBatchJob_503 ON steps (p_batchjob);

CREATE INDEX seqNrIDX_503 ON steps (p_sequencenumber);


CREATE CACHED TABLE steps503sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_503Sn ON steps503sn (ITEMPK);


CREATE CACHED TABLE stocklevelhisto2020sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2020Sn ON stocklevelhisto2020sn (ITEMPK);


CREATE CACHED TABLE stocklevelhistoryentry
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_updatedate TIMESTAMP,
    p_actual INTEGER,
    p_reserved INTEGER,
    p_updatetype BIGINT,
    p_comment NVARCHAR(255),
    p_stocklevelpos INTEGER,
    p_stocklevel BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX stocklevelRelIDX_2020 ON stocklevelhistoryentry (p_stocklevel);

CREATE INDEX stocklevelposPosIDX_2020 ON stocklevelhistoryentry (p_stocklevelpos);


CREATE CACHED TABLE stocklevels
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_available INTEGER,
    p_releasedate TIMESTAMP,
    p_nextdeliverytime TIMESTAMP,
    p_productcode NVARCHAR(255),
    p_reserved INTEGER,
    p_overselling INTEGER,
    p_preorder INTEGER,
    p_maxpreorder INTEGER,
    p_treatnegativeaszero TINYINT,
    p_instockstatus BIGINT,
    p_maxstocklevelhistorycount INTEGER,
    p_warehouse BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX productCodeIdx_2007 ON stocklevels (p_productcode);

CREATE INDEX warehouseIndex_2007 ON stocklevels (p_warehouse);

CREATE INDEX productCodeWarehouseIndex_2007 ON stocklevels (p_productcode, p_warehouse);


CREATE CACHED TABLE stocklevels2007sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2007Sn ON stocklevels2007sn (ITEMPK);


CREATE CACHED TABLE stocklevproduct2015sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2015Sn ON stocklevproduct2015sn (ITEMPK);

CREATE INDEX IdxsourcePK_2015Sn ON stocklevproduct2015sn (sourcePK);

CREATE INDEX IdxtargetPK_2015Sn ON stocklevproduct2015sn (targetPK);

CREATE INDEX IdxlanguagePK_2015Sn ON stocklevproduct2015sn (languagePK);


CREATE CACHED TABLE stocklevproductrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_2015 ON stocklevproductrel (SourcePK);

CREATE INDEX qualifier_2015 ON stocklevproductrel (Qualifier);

CREATE INDEX rseqnr_2015 ON stocklevproductrel (RSequenceNumber);

CREATE INDEX linktarget_2015 ON stocklevproductrel (TargetPK);

CREATE INDEX seqnr_2015 ON stocklevproductrel (SequenceNumber);


CREATE CACHED TABLE storedhttpsessi121sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_121Sn ON storedhttpsessi121sn (ITEMPK);


CREATE CACHED TABLE storedhttpsessions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_sessionid NVARCHAR(255),
    p_clusterid INTEGER,
    p_extension NVARCHAR(255),
    p_contextroot NVARCHAR(255),
    p_serializedsession LONGVARBINARY,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX sessionIdIdx_121 ON storedhttpsessions (p_sessionid);


CREATE CACHED TABLE storelocation2l6209sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6209Sn ON storelocation2l6209sn (ITEMPK);

CREATE INDEX IdxsourcePK_6209Sn ON storelocation2l6209sn (sourcePK);

CREATE INDEX IdxtargetPK_6209Sn ON storelocation2l6209sn (targetPK);

CREATE INDEX IdxlanguagePK_6209Sn ON storelocation2l6209sn (languagePK);


CREATE CACHED TABLE storelocation2locator
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_6209 ON storelocation2locator (SourcePK);

CREATE INDEX qualifier_6209 ON storelocation2locator (Qualifier);

CREATE INDEX rseqnr_6209 ON storelocation2locator (RSequenceNumber);

CREATE INDEX linktarget_6209 ON storelocation2locator (TargetPK);

CREATE INDEX seqnr_6209 ON storelocation2locator (SequenceNumber);


CREATE CACHED TABLE storelocatorfea6210sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6210Sn ON storelocatorfea6210sn (ITEMPK);


CREATE CACHED TABLE storelocatorfeature
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_icon BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE storelocatorfeaturelp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE stores4site
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1092 ON stores4site (SourcePK);

CREATE INDEX qualifier_1092 ON stores4site (Qualifier);

CREATE INDEX rseqnr_1092 ON stores4site (RSequenceNumber);

CREATE INDEX linktarget_1092 ON stores4site (TargetPK);

CREATE INDEX seqnr_1092 ON stores4site (SequenceNumber);


CREATE CACHED TABLE stores4site1092sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1092Sn ON stores4site1092sn (ITEMPK);

CREATE INDEX IdxsourcePK_1092Sn ON stores4site1092sn (sourcePK);

CREATE INDEX IdxtargetPK_1092Sn ON stores4site1092sn (targetPK);

CREATE INDEX IdxlanguagePK_1092Sn ON stores4site1092sn (languagePK);


CREATE CACHED TABLE storetimeres2ba1102sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1102Sn ON storetimeres2ba1102sn (ITEMPK);

CREATE INDEX IdxsourcePK_1102Sn ON storetimeres2ba1102sn (sourcePK);

CREATE INDEX IdxtargetPK_1102Sn ON storetimeres2ba1102sn (targetPK);

CREATE INDEX IdxlanguagePK_1102Sn ON storetimeres2ba1102sn (languagePK);


CREATE CACHED TABLE storetimeres2basestore
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1102 ON storetimeres2basestore (SourcePK);

CREATE INDEX qualifier_1102 ON storetimeres2basestore (Qualifier);

CREATE INDEX rseqnr_1102 ON storetimeres2basestore (RSequenceNumber);

CREATE INDEX linktarget_1102 ON storetimeres2basestore (TargetPK);

CREATE INDEX seqnr_1102 ON storetimeres2basestore (SequenceNumber);


CREATE CACHED TABLE synattcfg
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_syncjob BIGINT,
    p_attributedescriptor BIGINT,
    p_includedinsync TINYINT,
    p_copybyvalue TINYINT,
    p_untranslatable TINYINT,
    p_translatevalue TINYINT,
    p_presetvalue LONGVARBINARY,
    p_partiallytranslatable TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX jobIdx_620 ON synattcfg (p_syncjob);

CREATE INDEX attrIdx_620 ON synattcfg (p_attributedescriptor);


CREATE CACHED TABLE synattcfg620sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_620Sn ON synattcfg620sn (ITEMPK);


CREATE CACHED TABLE syncjob2langrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_622 ON syncjob2langrel (SourcePK);

CREATE INDEX qualifier_622 ON syncjob2langrel (Qualifier);

CREATE INDEX rseqnr_622 ON syncjob2langrel (RSequenceNumber);

CREATE INDEX linktarget_622 ON syncjob2langrel (TargetPK);

CREATE INDEX seqnr_622 ON syncjob2langrel (SequenceNumber);


CREATE CACHED TABLE syncjob2langrel622sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_622Sn ON syncjob2langrel622sn (ITEMPK);

CREATE INDEX IdxsourcePK_622Sn ON syncjob2langrel622sn (sourcePK);

CREATE INDEX IdxtargetPK_622Sn ON syncjob2langrel622sn (targetPK);

CREATE INDEX IdxlanguagePK_622Sn ON syncjob2langrel622sn (languagePK);


CREATE CACHED TABLE syncjob2pcplrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_623 ON syncjob2pcplrel (SourcePK);

CREATE INDEX qualifier_623 ON syncjob2pcplrel (Qualifier);

CREATE INDEX rseqnr_623 ON syncjob2pcplrel (RSequenceNumber);

CREATE INDEX linktarget_623 ON syncjob2pcplrel (TargetPK);

CREATE INDEX seqnr_623 ON syncjob2pcplrel (SequenceNumber);


CREATE CACHED TABLE syncjob2pcplrel623sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_623Sn ON syncjob2pcplrel623sn (ITEMPK);

CREATE INDEX IdxsourcePK_623Sn ON syncjob2pcplrel623sn (sourcePK);

CREATE INDEX IdxtargetPK_623Sn ON syncjob2pcplrel623sn (targetPK);

CREATE INDEX IdxlanguagePK_623Sn ON syncjob2pcplrel623sn (languagePK);


CREATE CACHED TABLE syncjob2typerel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_621 ON syncjob2typerel (SourcePK);

CREATE INDEX qualifier_621 ON syncjob2typerel (Qualifier);

CREATE INDEX rseqnr_621 ON syncjob2typerel (RSequenceNumber);

CREATE INDEX linktarget_621 ON syncjob2typerel (TargetPK);

CREATE INDEX seqnr_621 ON syncjob2typerel (SequenceNumber);


CREATE CACHED TABLE syncjob2typerel621sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_621Sn ON syncjob2typerel621sn (ITEMPK);

CREATE INDEX IdxsourcePK_621Sn ON syncjob2typerel621sn (sourcePK);

CREATE INDEX IdxtargetPK_621Sn ON syncjob2typerel621sn (targetPK);

CREATE INDEX IdxlanguagePK_621Sn ON syncjob2typerel621sn (languagePK);


CREATE CACHED TABLE systemsetupaudi120sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_120Sn ON systemsetupaudi120sn (ITEMPK);


CREATE CACHED TABLE systemsetupaudit
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_hash NVARCHAR(255),
    p_extensionname NVARCHAR(255),
    p_required TINYINT,
    p_patch TINYINT,
    p_user BIGINT,
    p_name NVARCHAR(255),
    p_classname NVARCHAR(255),
    p_methodname NVARCHAR(255),
    p_description NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX codeIdx_120 ON systemsetupaudit (p_hash);


CREATE CACHED TABLE taskconditions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uniqueid NVARCHAR(255),
    p_expirationtimemillis BIGINT,
    p_processeddate TIMESTAMP,
    p_fulfilled TINYINT,
    p_consumed TINYINT,
    p_choice NVARCHAR(255),
    p_counter INTEGER,
    p_task BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX Cond_idx_951 ON taskconditions (p_uniqueid, p_consumed);

CREATE INDEX Cond_match_idx_951 ON taskconditions (p_task, p_fulfilled, TypePkString);

CREATE INDEX taskRelIDX_951 ON taskconditions (p_task);


CREATE CACHED TABLE taskconditions951sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_951Sn ON taskconditions951sn (ITEMPK);


CREATE CACHED TABLE tasklogs
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_returncode NVARCHAR(255),
    p_startdate TIMESTAMP,
    p_enddate TIMESTAMP,
    p_actionid NVARCHAR(255),
    p_clusterid INTEGER,
    p_logmessages LONGVARCHAR,
    p_process BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX processRelIDX_32767 ON tasklogs (p_process);


CREATE CACHED TABLE tasklogs32767sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_32767Sn ON tasklogs32767sn (ITEMPK);


CREATE CACHED TABLE tasks
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_runnerbean NVARCHAR(255),
    p_executiontimemillis BIGINT,
    p_executionhourmillis BIGINT,
    p_failed TINYINT,
    p_expirationtimemillis BIGINT,
    p_context LONGVARBINARY,
    p_contextitem BIGINT,
    p_nodeid INTEGER,
    p_nodegroup NVARCHAR(255),
    p_retry INTEGER,
    p_runningonclusternode INTEGER,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_action NVARCHAR(255),
    p_process BIGINT,
    p_scripturi NVARCHAR(255),
    p_trigger BIGINT,
    p_state BIGINT,
    p_conditionid NVARCHAR(255),
    p_order BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX Task_dr_idx_950 ON tasks (p_runningonclusternode, p_expirationtimemillis, p_nodeid);

CREATE INDEX Task_dr2_idx_950 ON tasks (p_failed, p_runningonclusternode, p_executionhourmillis, TypePkString, p_nodeid);

CREATE INDEX processRelIDX_950 ON tasks (p_process);


CREATE CACHED TABLE tasks950sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_950Sn ON tasks950sn (ITEMPK);


CREATE CACHED TABLE taxes
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_value DOUBLE,
    p_currency BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE taxes47sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_47Sn ON taxes47sn (ITEMPK);


CREATE CACHED TABLE taxeslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE taxrows
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_product BIGINT,
    p_pg BIGINT,
    p_productmatchqualifier BIGINT,
    p_starttime TIMESTAMP,
    p_endtime TIMESTAMP,
    p_user BIGINT,
    p_ug BIGINT,
    p_usermatchqualifier BIGINT,
    p_productid NVARCHAR(255),
    p_catalogversion BIGINT,
    p_currency BIGINT,
    p_tax BIGINT,
    p_value DOUBLE,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX MatchIndexP_1054 ON taxrows (p_productmatchqualifier);

CREATE INDEX MatchIndexU_1054 ON taxrows (p_usermatchqualifier);

CREATE INDEX PIdx_1054 ON taxrows (p_product);

CREATE INDEX UIdx_1054 ON taxrows (p_user);

CREATE INDEX PGIdx_1054 ON taxrows (p_pg);

CREATE INDEX UGIdx_1054 ON taxrows (p_ug);

CREATE INDEX ProductIdIdx_1054 ON taxrows (p_productid);

CREATE INDEX versionIDX_1054 ON taxrows (p_catalogversion);


CREATE CACHED TABLE taxrows1054sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1054Sn ON taxrows1054sn (ITEMPK);


CREATE CACHED TABLE testitem
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    fieldA NVARCHAR(255),
    fieldB NVARCHAR(255),
    fieldBoolean TINYINT,
    fieldByte SMALLINT,
    fieldCharacter SMALLINT,
    fieldDate TIMESTAMP,
    fieldDouble DOUBLE,
    fieldFloat FLOAT,
    fieldInteger INTEGER,
    fieldLong BIGINT,
    fieldPrimitiveBoolean TINYINT DEFAULT 0,
    fieldPrimitiveByte SMALLINT DEFAULT 0,
    fieldPrimitiveChar SMALLINT,
    fieldPrimitiveDouble DOUBLE DEFAULT 0,
    fieldPrimitiveFloat FLOAT DEFAULT 0,
    fieldPrimitiveInteger INTEGER DEFAULT 0,
    fieldPrimitiveLong BIGINT DEFAULT 0,
    fieldPrimitiveShort SMALLINT,
    fieldSerializable LONGVARBINARY,
    fieldString NVARCHAR(255),
    fieldLongString LONGVARCHAR,
    p_testproperty0 NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    fieldJson LONGVARCHAR,
    fieldBigDecimal DECIMAL(30,8),
    p_testproperty1 INTEGER,
    p_foo NVARCHAR(255),
    p_bar NVARCHAR(255),
    p_xxx NVARCHAR(255),
    p_itemtypetwo BIGINT,
    p_itemstypetwo LONGVARCHAR,
    p_code NVARCHAR(255),
    p_otheritem BIGINT,
    p_detail BIGINT,
    p_item BIGINT,
    p_master BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX TestIntegrationItem_code_25 ON testitem (p_code);

CREATE INDEX masterRelIDX_25 ON testitem (p_master);


CREATE CACHED TABLE testitem25sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_25Sn ON testitem25sn (ITEMPK);


CREATE CACHED TABLE testitemlp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_testproperty2 NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE titles
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIdx_24 ON titles (p_code);


CREATE CACHED TABLE titles24sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_24Sn ON titles24sn (ITEMPK);


CREATE CACHED TABLE titleslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE triggerscj
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_active TINYINT,
    p_second INTEGER,
    p_minute INTEGER,
    p_hour INTEGER,
    p_day INTEGER,
    p_month INTEGER,
    p_year INTEGER,
    p_relative TINYINT,
    p_daysofweek LONGVARCHAR,
    p_weekinterval INTEGER,
    p_daterange LONGVARBINARY,
    p_activationtime TIMESTAMP,
    p_cronexpression NVARCHAR(255),
    p_maxacceptabledelay INTEGER,
    p_job BIGINT,
    p_cronjob BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX IdxCronJob_502 ON triggerscj (p_cronjob);

CREATE INDEX IdxActive_502 ON triggerscj (p_active);

CREATE INDEX jobRelIDX_502 ON triggerscj (p_job);


CREATE CACHED TABLE triggerscj502sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_502Sn ON triggerscj502sn (ITEMPK);


CREATE CACHED TABLE typesystemprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX itempk_typesystemprops ON typesystemprops (ITEMPK);

CREATE INDEX realnameidx_typesystemprops ON typesystemprops (REALNAME);

CREATE INDEX nameidx_typesystemprops ON typesystemprops (NAME);


CREATE CACHED TABLE unit2acctmgrgrp10036sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10036Sn ON unit2acctmgrgrp10036sn (ITEMPK);

CREATE INDEX IdxsourcePK_10036Sn ON unit2acctmgrgrp10036sn (sourcePK);

CREATE INDEX IdxtargetPK_10036Sn ON unit2acctmgrgrp10036sn (targetPK);

CREATE INDEX IdxlanguagePK_10036Sn ON unit2acctmgrgrp10036sn (languagePK);


CREATE CACHED TABLE unit2acctmgrgrprel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10036 ON unit2acctmgrgrprel (SourcePK);

CREATE INDEX qualifier_10036 ON unit2acctmgrgrprel (Qualifier);

CREATE INDEX rseqnr_10036 ON unit2acctmgrgrprel (RSequenceNumber);

CREATE INDEX linktarget_10036 ON unit2acctmgrgrprel (TargetPK);

CREATE INDEX seqnr_10036 ON unit2acctmgrgrprel (SequenceNumber);


CREATE CACHED TABLE unit2approvergr10021sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10021Sn ON unit2approvergr10021sn (ITEMPK);

CREATE INDEX IdxsourcePK_10021Sn ON unit2approvergr10021sn (sourcePK);

CREATE INDEX IdxtargetPK_10021Sn ON unit2approvergr10021sn (targetPK);

CREATE INDEX IdxlanguagePK_10021Sn ON unit2approvergr10021sn (languagePK);


CREATE CACHED TABLE unit2approvergrprel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10021 ON unit2approvergrprel (SourcePK);

CREATE INDEX qualifier_10021 ON unit2approvergrprel (Qualifier);

CREATE INDEX rseqnr_10021 ON unit2approvergrprel (RSequenceNumber);

CREATE INDEX linktarget_10021 ON unit2approvergrprel (TargetPK);

CREATE INDEX seqnr_10021 ON unit2approvergrprel (SequenceNumber);


CREATE CACHED TABLE unit2approversr10022sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10022Sn ON unit2approversr10022sn (ITEMPK);

CREATE INDEX IdxsourcePK_10022Sn ON unit2approversr10022sn (sourcePK);

CREATE INDEX IdxtargetPK_10022Sn ON unit2approversr10022sn (targetPK);

CREATE INDEX IdxlanguagePK_10022Sn ON unit2approversr10022sn (languagePK);


CREATE CACHED TABLE unit2approversrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_10022 ON unit2approversrel (SourcePK);

CREATE INDEX qualifier_10022 ON unit2approversrel (Qualifier);

CREATE INDEX rseqnr_10022 ON unit2approversrel (RSequenceNumber);

CREATE INDEX linktarget_10022 ON unit2approversrel (TargetPK);

CREATE INDEX seqnr_10022 ON unit2approversrel (SequenceNumber);


CREATE CACHED TABLE units
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_conversion DOUBLE,
    p_unittype NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE units10sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_10Sn ON units10sn (ITEMPK);


CREATE CACHED TABLE unitslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE useraudit
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_uid NVARCHAR(255),
    p_userpk BIGINT,
    p_changinguser NVARCHAR(255),
    p_changingapplication NVARCHAR(255),
    p_ipaddress NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    passwd LONGVARCHAR,
    p_passwordencoding NVARCHAR(255),
    p_failedlogins INTEGER,
    p_failedoauthauthorizations INTEGER,
    PRIMARY KEY (PK)
);

CREATE INDEX UID_6 ON useraudit (p_uid);

CREATE INDEX userPK_6 ON useraudit (p_userpk);


CREATE CACHED TABLE useraudit6sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_6Sn ON useraudit6sn (ITEMPK);


CREATE CACHED TABLE usergroupprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX nameidx_usergroupprops ON usergroupprops (NAME);

CREATE INDEX realnameidx_usergroupprops ON usergroupprops (REALNAME);

CREATE INDEX itempk_usergroupprops ON usergroupprops (ITEMPK);


CREATE CACHED TABLE usergroups
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_description NVARCHAR(255),
    p_name NVARCHAR(255),
    p_uid NVARCHAR(255),
    p_profilepicture BIGINT,
    p_backofficelogindisabled TINYINT,
    p_maxbruteforceloginattempts INTEGER,
    p_writeablelanguages LONGVARCHAR,
    p_readablelanguages LONGVARCHAR,
    p_userdiscountgroup BIGINT,
    p_userpricegroup BIGINT,
    p_usertaxgroup BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_dunsid NVARCHAR(255),
    p_ilnid NVARCHAR(255),
    p_buyerspecificid NVARCHAR(255),
    p_id NVARCHAR(255),
    p_supplierspecificid NVARCHAR(255),
    p_medias LONGVARCHAR,
    p_shippingaddress BIGINT,
    p_unloadingaddress BIGINT,
    p_billingaddress BIGINT,
    p_contactaddress BIGINT,
    p_contact BIGINT,
    p_vatid NVARCHAR(255),
    p_responsiblecompany BIGINT,
    p_country BIGINT,
    p_lineofbuisness BIGINT,
    p_buyer TINYINT,
    p_supplier TINYINT,
    p_manufacturer TINYINT,
    p_carrier TINYINT,
    p_active TINYINT,
    p_path NVARCHAR(255),
    p_reportingorganization BIGINT,
    p_creditlimit BIGINT,
    p_quotelimit BIGINT,
    p_accountmanager BIGINT,
    p_approvalprocesscode NVARCHAR(255),
    p_authorities LONGVARBINARY,
    p_implementationtype NVARCHAR(255),
    p_priority INTEGER,
    p_additionalcolumnskeys LONGVARBINARY,
    p_searchboxenabled TINYINT,
    p_store BIGINT,
    p_emaildistributionlist NVARCHAR(255),
    p_defaultassignee BIGINT,
    p_unit BIGINT,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX UID_5 ON usergroups (p_uid);

CREATE INDEX pathIndex_5 ON usergroups (p_path);

CREATE INDEX storeRelIDX_5 ON usergroups (p_store);

CREATE INDEX unitRelIDX_5 ON usergroups (p_unit);

CREATE INDEX creditlimitRelIDX_5 ON usergroups (p_creditlimit);

CREATE INDEX quotelimitRelIDX_5 ON usergroups (p_quotelimit);

CREATE INDEX accountmanagerRelIDX_5 ON usergroups (p_accountmanager);


CREATE CACHED TABLE usergroups5sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_5Sn ON usergroups5sn (ITEMPK);


CREATE CACHED TABLE usergroupslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_locname NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE userprofiles
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_readablelanguages LONGVARCHAR,
    p_writablelanguages LONGVARCHAR,
    p_expandinitial TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE userprofiles1119sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1119Sn ON userprofiles1119sn (ITEMPK);


CREATE CACHED TABLE userprops
(
    hjmpTS BIGINT,
    ITEMPK BIGINT NOT NULL,
    ITEMTYPEPK BIGINT,
    NAME NVARCHAR(255) NOT NULL,
    LANGPK BIGINT NOT NULL,
    REALNAME NVARCHAR(255),
    TYPE1 INTEGER DEFAULT 0,
    VALUESTRING1 LONGVARCHAR,
    VALUE1 LONGVARBINARY,
    PRIMARY KEY (ITEMPK, NAME, LANGPK)
);

CREATE INDEX itempk_userprops ON userprops (ITEMPK);

CREATE INDEX nameidx_userprops ON userprops (NAME);

CREATE INDEX realnameidx_userprops ON userprops (REALNAME);


CREATE CACHED TABLE userrights
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE userrights29sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_29Sn ON userrights29sn (ITEMPK);


CREATE CACHED TABLE userrightslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE users
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_description NVARCHAR(255),
    p_name NVARCHAR(255),
    p_uid NVARCHAR(255),
    p_profilepicture BIGINT,
    p_backofficelogindisabled TINYINT,
    p_defaultpaymentaddress BIGINT,
    p_defaultshipmentaddress BIGINT,
    p_passwordencoding NVARCHAR(255),
    passwd LONGVARCHAR,
    p_passwordanswer LONGVARCHAR,
    p_passwordquestion LONGVARCHAR,
    p_sessionlanguage BIGINT,
    p_sessioncurrency BIGINT,
    p_logindisabled TINYINT,
    p_lastlogin TIMESTAMP,
    p_hmclogindisabled TINYINT,
    p_retentionstate BIGINT,
    p_userprofile BIGINT,
    p_deactivationdate TIMESTAMP,
    p_europe1pricefactory_udg BIGINT,
    p_europe1pricefactory_upg BIGINT,
    p_europe1pricefactory_utg BIGINT,
    p_authorizedtounlockpages TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_customerid NVARCHAR(255),
    p_previewcatalogversions LONGVARCHAR,
    p_title BIGINT,
    p_defaultpaymentinfo BIGINT,
    p_token LONGVARCHAR,
    p_originaluid NVARCHAR(255),
    p_type BIGINT,
    p_active TINYINT,
    p_email NVARCHAR(255),
    p_defaultb2bunit BIGINT,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX UID_4 ON users (p_uid);


CREATE CACHED TABLE users4restricti1082sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1082Sn ON users4restricti1082sn (ITEMPK);

CREATE INDEX IdxsourcePK_1082Sn ON users4restricti1082sn (sourcePK);

CREATE INDEX IdxtargetPK_1082Sn ON users4restricti1082sn (targetPK);

CREATE INDEX IdxlanguagePK_1082Sn ON users4restricti1082sn (languagePK);


CREATE CACHED TABLE users4restriction
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1082 ON users4restriction (SourcePK);

CREATE INDEX qualifier_1082 ON users4restriction (Qualifier);

CREATE INDEX rseqnr_1082 ON users4restriction (RSequenceNumber);

CREATE INDEX linktarget_1082 ON users4restriction (TargetPK);

CREATE INDEX seqnr_1082 ON users4restriction (SequenceNumber);


CREATE CACHED TABLE users4sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_4Sn ON users4sn (ITEMPK);


CREATE CACHED TABLE validationconst980sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_980Sn ON validationconst980sn (ITEMPK);


CREATE CACHED TABLE validationconstraints
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_id NVARCHAR(255),
    p_active TINYINT,
    p_annotation LONGVARCHAR,
    p_severity BIGINT,
    p_target LONGVARCHAR,
    p_type BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_language BIGINT,
    p_expression LONGVARCHAR,
    p_firstfieldname NVARCHAR(255),
    p_secondfieldname NVARCHAR(255),
    p_keyregexp NVARCHAR(255),
    p_keyflags LONGVARCHAR,
    p_valueregexp NVARCHAR(255),
    p_valueflags LONGVARCHAR,
    p_qualifier NVARCHAR(255),
    p_languages LONGVARCHAR,
    p_descriptor BIGINT,
    p_regexp NVARCHAR(255),
    p_flags LONGVARCHAR,
    p_integer INTEGER,
    p_fraction INTEGER,
    p_value BIGINT,
    p_valu0 DECIMAL(30,8),
    p_inclusive TINYINT,
    p_min BIGINT,
    p_max BIGINT,
    p_code NVARCHAR(255),
    p_valu1 NVARCHAR(255),
    p_notempty TINYINT,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX AbstractConstraint_idx_980 ON validationconstraints (p_id);

CREATE INDEX typeRelIDX_980 ON validationconstraints (p_type);

CREATE INDEX descriptorRelIDX_980 ON validationconstraints (p_descriptor);


CREATE CACHED TABLE validationconstraintslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_message LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE vendors
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);


CREATE CACHED TABLE vendors2006sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2006Sn ON vendors2006sn (ITEMPK);


CREATE CACHED TABLE vendorslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE versiongcproc2v1107sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1107Sn ON versiongcproc2v1107sn (ITEMPK);

CREATE INDEX IdxsourcePK_1107Sn ON versiongcproc2v1107sn (sourcePK);

CREATE INDEX IdxtargetPK_1107Sn ON versiongcproc2v1107sn (targetPK);

CREATE INDEX IdxlanguagePK_1107Sn ON versiongcproc2v1107sn (languagePK);


CREATE CACHED TABLE versiongcproc2version
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1107 ON versiongcproc2version (SourcePK);

CREATE INDEX qualifier_1107 ON versiongcproc2version (Qualifier);

CREATE INDEX rseqnr_1107 ON versiongcproc2version (RSequenceNumber);

CREATE INDEX linktarget_1107 ON versiongcproc2version (TargetPK);

CREATE INDEX seqnr_1107 ON versiongcproc2version (SequenceNumber);


CREATE CACHED TABLE voucherinvalida1600sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1600Sn ON voucherinvalida1600sn (ITEMPK);


CREATE CACHED TABLE voucherinvalidations
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_user BIGINT,
    p_order BIGINT,
    p_status NVARCHAR(255),
    p_voucher BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIdx_1600 ON voucherinvalidations (p_code);

CREATE INDEX codeUserIdx_1600 ON voucherinvalidations (p_code, p_user);

CREATE INDEX codeOrderIdx_1600 ON voucherinvalidations (p_code, p_order);

CREATE INDEX voucherRelIDX_1600 ON voucherinvalidations (p_voucher);


CREATE CACHED TABLE warehouses
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_default TINYINT,
    p_vendorpos INTEGER,
    p_vendor BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX vendorRelIDX_2005 ON warehouses (p_vendor);

CREATE INDEX vendorposPosIDX_2005 ON warehouses (p_vendorpos);


CREATE CACHED TABLE warehouses2005sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_2005Sn ON warehouses2005sn (ITEMPK);


CREATE CACHED TABLE warehouseslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE whereparts
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_and TINYINT,
    p_replacepattern NVARCHAR(255),
    p_savedquery BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX savedqueryRelIDX_1300 ON whereparts (p_savedquery);


CREATE CACHED TABLE whereparts1300sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1300Sn ON whereparts1300sn (ITEMPK);


CREATE CACHED TABLE workflowactionc1118sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1118Sn ON workflowactionc1118sn (ITEMPK);


CREATE CACHED TABLE workflowactioncomments
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_comment NVARCHAR(255),
    p_user BIGINT,
    p_workflowaction BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX workflowactionRelIDX_1118 ON workflowactioncomments (p_workflowaction);


CREATE CACHED TABLE workflowactioni1116sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1116Sn ON workflowactioni1116sn (ITEMPK);

CREATE INDEX IdxsourcePK_1116Sn ON workflowactioni1116sn (sourcePK);

CREATE INDEX IdxtargetPK_1116Sn ON workflowactioni1116sn (targetPK);

CREATE INDEX IdxlanguagePK_1116Sn ON workflowactioni1116sn (languagePK);


CREATE CACHED TABLE workflowactionitemsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1116 ON workflowactionitemsrel (SourcePK);

CREATE INDEX qualifier_1116 ON workflowactionitemsrel (Qualifier);

CREATE INDEX rseqnr_1116 ON workflowactionitemsrel (RSequenceNumber);

CREATE INDEX linktarget_1116 ON workflowactionitemsrel (TargetPK);

CREATE INDEX seqnr_1116 ON workflowactionitemsrel (SequenceNumber);


CREATE CACHED TABLE workflowactionl1124sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1124Sn ON workflowactionl1124sn (ITEMPK);

CREATE INDEX IdxsourcePK_1124Sn ON workflowactionl1124sn (sourcePK);

CREATE INDEX IdxtargetPK_1124Sn ON workflowactionl1124sn (targetPK);

CREATE INDEX IdxlanguagePK_1124Sn ON workflowactionl1124sn (languagePK);


CREATE CACHED TABLE workflowactionlinkrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    p_active TINYINT,
    p_andconnection TINYINT,
    p_template BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1124 ON workflowactionlinkrel (SourcePK);

CREATE INDEX qualifier_1124 ON workflowactionlinkrel (Qualifier);

CREATE INDEX rseqnr_1124 ON workflowactionlinkrel (RSequenceNumber);

CREATE INDEX linktarget_1124 ON workflowactionlinkrel (TargetPK);

CREATE INDEX seqnr_1124 ON workflowactionlinkrel (SequenceNumber);


CREATE CACHED TABLE workflowactions
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_actiontype BIGINT,
    p_code NVARCHAR(255),
    p_principalassigned BIGINT,
    p_sendemail TINYINT,
    p_emailaddress NVARCHAR(255),
    p_renderertemplate BIGINT,
    p_qualifier NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    p_workflowpos INTEGER,
    p_workflow BIGINT,
    p_jobclass LONGVARCHAR,
    p_jobhandler NVARCHAR(255),
    p_selecteddecision BIGINT,
    p_firstactivated TIMESTAMP,
    p_activated TIMESTAMP,
    p_comment NVARCHAR(255),
    p_status BIGINT,
    p_template BIGINT,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIDX_1113 ON workflowactions (p_code);

CREATE INDEX qualifierIdx_1113 ON workflowactions (p_qualifier);

CREATE INDEX workflowRelIDX_1113 ON workflowactions (p_workflow);

CREATE INDEX workflowposPosIDX_1113 ON workflowactions (p_workflowpos);


CREATE CACHED TABLE workflowactions1113sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1113Sn ON workflowactions1113sn (ITEMPK);


CREATE CACHED TABLE workflowactions1115sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1115Sn ON workflowactions1115sn (ITEMPK);

CREATE INDEX IdxsourcePK_1115Sn ON workflowactions1115sn (sourcePK);

CREATE INDEX IdxtargetPK_1115Sn ON workflowactions1115sn (targetPK);

CREATE INDEX IdxlanguagePK_1115Sn ON workflowactions1115sn (languagePK);


CREATE CACHED TABLE workflowactionslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    p_description LONGVARCHAR,
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE workflowactionsrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1115 ON workflowactionsrel (SourcePK);

CREATE INDEX qualifier_1115 ON workflowactionsrel (Qualifier);

CREATE INDEX rseqnr_1115 ON workflowactionsrel (RSequenceNumber);

CREATE INDEX linktarget_1115 ON workflowactionsrel (TargetPK);

CREATE INDEX seqnr_1115 ON workflowactionsrel (SequenceNumber);


CREATE CACHED TABLE workflowitematt1114sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1114Sn ON workflowitematt1114sn (ITEMPK);


CREATE CACHED TABLE workflowitematts
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    p_comment NVARCHAR(255),
    p_item BIGINT,
    p_typeofitem BIGINT,
    p_workflowpos INTEGER,
    p_workflow BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX codeIDX_1114 ON workflowitematts (p_code);

CREATE INDEX workflowRelIDX_1114 ON workflowitematts (p_workflow);

CREATE INDEX workflowposPosIDX_1114 ON workflowitematts (p_workflowpos);


CREATE CACHED TABLE workflowitemattslp
(
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    LANGPK BIGINT,
    p_name NVARCHAR(255),
    PRIMARY KEY (ITEMPK, LANGPK)
);


CREATE CACHED TABLE workflowtemplat1125sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1125Sn ON workflowtemplat1125sn (ITEMPK);

CREATE INDEX IdxsourcePK_1125Sn ON workflowtemplat1125sn (sourcePK);

CREATE INDEX IdxtargetPK_1125Sn ON workflowtemplat1125sn (targetPK);

CREATE INDEX IdxlanguagePK_1125Sn ON workflowtemplat1125sn (languagePK);


CREATE CACHED TABLE workflowtemplatelinkrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    p_andconnectiontemplate TINYINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1125 ON workflowtemplatelinkrel (SourcePK);

CREATE INDEX qualifier_1125 ON workflowtemplatelinkrel (Qualifier);

CREATE INDEX rseqnr_1125 ON workflowtemplatelinkrel (RSequenceNumber);

CREATE INDEX linktarget_1125 ON workflowtemplatelinkrel (TargetPK);

CREATE INDEX seqnr_1125 ON workflowtemplatelinkrel (SequenceNumber);


CREATE CACHED TABLE workflowtemplpr1117sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1117Sn ON workflowtemplpr1117sn (ITEMPK);

CREATE INDEX IdxsourcePK_1117Sn ON workflowtemplpr1117sn (sourcePK);

CREATE INDEX IdxtargetPK_1117Sn ON workflowtemplpr1117sn (targetPK);

CREATE INDEX IdxlanguagePK_1117Sn ON workflowtemplpr1117sn (languagePK);


CREATE CACHED TABLE workflowtemplprincrel
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1117 ON workflowtemplprincrel (SourcePK);

CREATE INDEX qualifier_1117 ON workflowtemplprincrel (Qualifier);

CREATE INDEX rseqnr_1117 ON workflowtemplprincrel (RSequenceNumber);

CREATE INDEX linktarget_1117 ON workflowtemplprincrel (TargetPK);

CREATE INDEX seqnr_1117 ON workflowtemplprincrel (SequenceNumber);


CREATE CACHED TABLE ydeployments
(
    hjmpTS BIGINT,
    Typecode INTEGER DEFAULT 0,
    TableName NVARCHAR(255),
    PropsTableName NVARCHAR(255),
    Name NVARCHAR(255) NOT NULL,
    PackageName NVARCHAR(255),
    SuperName NVARCHAR(255),
    ExtensionName NVARCHAR(255),
    Modifiers INTEGER DEFAULT 0,
    TypeSystemName NVARCHAR(255) NOT NULL,
    AuditTableName NVARCHAR(255),
    PRIMARY KEY (Name, TypeSystemName)
);

CREATE INDEX deplselect2_ydeployments ON ydeployments (Typecode);

CREATE INDEX deplselect_ydeployments ON ydeployments (ExtensionName);

CREATE INDEX tsnameidx_ydeployments ON ydeployments (TypeSystemName);


CREATE CACHED TABLE zone2country
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    languagepk BIGINT,
    Qualifier NVARCHAR(255),
    SourcePK BIGINT,
    TargetPK BIGINT,
    SequenceNumber INTEGER DEFAULT 0,
    RSequenceNumber INTEGER DEFAULT 0,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE INDEX linksource_1204 ON zone2country (SourcePK);

CREATE INDEX qualifier_1204 ON zone2country (Qualifier);

CREATE INDEX rseqnr_1204 ON zone2country (RSequenceNumber);

CREATE INDEX linktarget_1204 ON zone2country (TargetPK);

CREATE INDEX seqnr_1204 ON zone2country (SequenceNumber);


CREATE CACHED TABLE zone2country1204sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    sourcePK BIGINT,
    targetPK BIGINT,
    languagePK BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1204Sn ON zone2country1204sn (ITEMPK);

CREATE INDEX IdxsourcePK_1204Sn ON zone2country1204sn (sourcePK);

CREATE INDEX IdxtargetPK_1204Sn ON zone2country1204sn (targetPK);

CREATE INDEX IdxlanguagePK_1204Sn ON zone2country1204sn (languagePK);


CREATE CACHED TABLE zonedeliverymod1202sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1202Sn ON zonedeliverymod1202sn (ITEMPK);


CREATE CACHED TABLE zonedeliverymodevalues
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_currency BIGINT,
    p_minimum DOUBLE,
    p_value DOUBLE,
    p_zone BIGINT,
    p_deliverymode BIGINT,
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX IdentityIDX_1202 ON zonedeliverymodevalues (p_deliverymode, p_zone, p_currency, p_minimum);

CREATE INDEX ModeIDX_1202 ON zonedeliverymodevalues (p_deliverymode);

CREATE INDEX ZoneIDX_1202 ON zonedeliverymodevalues (p_zone);


CREATE CACHED TABLE zones
(
    hjmpTS BIGINT,
    createdTS TIMESTAMP,
    modifiedTS TIMESTAMP,
    TypePkString BIGINT,
    OwnerPkString BIGINT,
    PK BIGINT NOT NULL,
    sealed TINYINT,
    p_code NVARCHAR(255),
    aCLTS BIGINT DEFAULT 0,
    propTS BIGINT DEFAULT 0,
    PRIMARY KEY (PK)
);

CREATE UNIQUE INDEX IdentityIDX_1203 ON zones (p_code);


CREATE CACHED TABLE zones1203sn
(
    ID BIGINT IDENTITY,
    ITEMPK BIGINT,
    ITEMTYPEPK BIGINT,
    timestamp TIMESTAMP,
    currenttimestamp TIMESTAMP,
    changinguser NVARCHAR(255),
    context LONGVARCHAR,
    payloadbefore LONGVARCHAR,
    payloadafter LONGVARCHAR,
    operationtype BIGINT,
    PRIMARY KEY (ID)
);

CREATE INDEX IdxITEMPK_1203Sn ON zones1203sn (ITEMPK);

