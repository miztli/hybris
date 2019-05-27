package com.hybris.mobile.lib.commerce.tests;

import android.content.res.AssetManager;
import android.test.AndroidTestCase;
import android.util.Log;

import com.hybris.mobile.lib.commerce.BuildConfig;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.CardType;
import com.hybris.mobile.lib.commerce.data.order.CardTypeList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.order.DeliveryModeList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.data.product.PromotionList;
import com.hybris.mobile.lib.commerce.data.product.PromotionResultList;
import com.hybris.mobile.lib.commerce.data.storesession.Currency;
import com.hybris.mobile.lib.commerce.data.storesession.CurrencyList;
import com.hybris.mobile.lib.commerce.data.storesession.Language;
import com.hybris.mobile.lib.commerce.data.storesession.LanguageList;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.Country;
import com.hybris.mobile.lib.commerce.data.user.CountryList;
import com.hybris.mobile.lib.commerce.data.user.Title;
import com.hybris.mobile.lib.commerce.data.user.TitleList;
import com.hybris.mobile.lib.commerce.data.voucher.VoucherList;
import com.hybris.mobile.lib.commerce.query.QueryAddress;
import com.hybris.mobile.lib.commerce.query.QueryCustomerGroup;
import com.hybris.mobile.lib.commerce.query.QueryDeliveryMode;
import com.hybris.mobile.lib.commerce.query.QueryLogin;
import com.hybris.mobile.lib.commerce.query.QueryPayment;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * This class is base for all the test classes for this library and its descendants
 */
public abstract class ContentServiceHelperTests extends AndroidTestCase {

    protected static final String TAG = ContentServiceHelperTests.class.getCanonicalName();
    protected static SSLContext SSLCONTEXT;
    protected static final String PASSWORD = "12341234";
    protected static final int NB_SECONDS_TO_WAIT_ASYNC_FINISH = 120;
    protected static final String EMAIL = "@unittest.com";
    protected static final String GROUP_NAME = "UnitTestGroup";
    protected final CountDownLatch mLock = new CountDownLatch(1);
    protected ContentServiceHelper mContentServiceHelper;
    protected String mUserName;
    protected String mProductCode;

    static {
        TrustManager[] trustManager = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };

        try {
            SSLCONTEXT = SSLContext.getInstance("SSL");
            SSLCONTEXT.init(null, trustManager, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            Log.e(TAG, "Error with SSL. Details: " + e.getLocalizedMessage());
        }

        if (SSLCONTEXT == null) {
            throw new IllegalStateException("Unable to get an instance of SSLContext");
        }

    }

    protected static String generateUserEmail() {
        return (RandomStringUtils.randomAlphabetic(10) + "." + RandomStringUtils.randomAlphabetic(10) + EMAIL).toLowerCase();
    }

    protected static String generateCustomerGroupName() {
        return (RandomStringUtils.randomAlphabetic(10) + GROUP_NAME).toLowerCase();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Getting the username associated to the host machine in the property file
        try {
            AssetManager assetManager = getContext().getAssets();
            InputStream ims = assetManager.open("unittests-superusers.properties");

            Properties properties = new Properties();
            properties.load(ims);

            // TODO: Eclipse support, BuildConfig is not generated with the ADT plugin
            Field field = BuildConfig.class.getField("HOSTNAME");
            mUserName = properties.getProperty((String) field.get(BuildConfig.class));

            if (StringUtils.isBlank(mUserName)) {
                mUserName = properties.getProperty("defaultTestUser");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Content service helper
        mContentServiceHelper = buildContentServiceHelper(SSLCONTEXT.getSocketFactory(), new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        final CountDownLatch lockGetProduct = new CountDownLatch(1);

        final QueryProducts queryProducts = new QueryProducts();
        queryProducts.setCurrentPage(0);
        queryProducts.setPageSize(100);

        // Getting the product code to use for tests
        getProductCodeForTests(new CallbackGetProduct() {
            @Override
            public void onProductLoaded(String productCode) {
                mProductCode = productCode;

                if (StringUtils.isBlank(mProductCode)) {
                    fail("No valid product found for unit tests");
                }

                lockGetProduct.countDown();
            }

            @Override
            public void onProductsLoaded(List<ProductBase> productBases) {

                if (productBases == null || productBases.isEmpty()) {
                    this.onProductLoaded(null);
                } else {
                    final Boolean[] productFound = {Boolean.FALSE};
                    final String[] productCode = {""};

                    Iterator<ProductBase> iterator = productBases.iterator();
                    while (!productFound[0] && iterator.hasNext()) {
                        ProductBase product = iterator.next();

                        QueryProduct queryProduct = new QueryProduct();
                        queryProduct.setCode(product.getCode());

                        final CountDownLatch lockGetProductDetails = new CountDownLatch(1);

                        // We get the details for the stocks
                        mContentServiceHelper.getProduct(new ResponseReceiver<Product>() {
                            @Override
                            public void onResponse(Response<Product> response) {
                                if (response.getData().isInStock()) {
                                    productCode[0] = response.getData().getCode();
                                    productFound[0] = Boolean.TRUE;
                                }

                                lockGetProductDetails.countDown();
                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                                lockGetProductDetails.countDown();
                            }
                        }, null, queryProduct, true, null, null);

                        try {
                            lockGetProductDetails.await(NB_SECONDS_TO_WAIT_ASYNC_FINISH, TimeUnit.SECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

//                        if (product.isInStock()) {
//                            productCode = product.getCode();
//                            productFound = true;
//                        }
                    }

                    if (!productFound[0]) {
                        queryProducts.setCurrentPage(queryProducts.getCurrentPage() + 1);
                        getProductCodeForTests(this, queryProducts);
                    } else {
                        this.onProductLoaded(productCode[0]);
                    }
                }
            }
        }, queryProducts);

        lockGetProduct.await(NB_SECONDS_TO_WAIT_ASYNC_FINISH, TimeUnit.SECONDS);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mContentServiceHelper = null;
        mProductCode = null;
        mUserName = null;
    }

    protected void authenticate(final CallbackLogin callbackLogin) {

        QueryLogin queryLogin = new QueryLogin();
        queryLogin.setUsername(mUserName);
        queryLogin.setPassword(PASSWORD);

        mContentServiceHelper.authenticate(new ResponseReceiverEmpty() {

            @Override
            public void onResponse(Response<EmptyResponse> response) {
                callbackLogin.onLogin();
            }

            @Override
            public void onError(Response<ErrorList> response) {
                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
            }

        }, null, queryLogin, false, null, null);

    }

    protected void createUserAddress(final CallbackCreateUserAddress callbackCreateUserAddress) {
        authenticate(new CallbackLogin() {

            @Override
            public void onLogin() {
                getStaticAttributes(new CallbackStaticAttributes() {
                    @Override
                    public void onAttributesLoaded(List<CardType> cardTypeList, List<Currency> currencyList,
                                                   List<Country> countryList,
                                                   List<Language> languageList, List<Title> titleList) {

                        QueryAddress queryAddress = new QueryAddress();
                        queryAddress.setLastName("TestLastName");
                        queryAddress.setCountry(countryList.get(0));
                        queryAddress.setTown("TestTown");
                        queryAddress.setPostalCode("CODETEST");
                        queryAddress.setTitleCode(titleList.get(0).getCode());
                        queryAddress.setFirstName("TestFirstName");
                        queryAddress.setLine2("123 Test Line2");
                        queryAddress.setLine1("123 Test Line1");
                        queryAddress.setBillingAddress(true);
                        queryAddress.setVisibleInAddressBook(true);
                        queryAddress.setShippingAddress(true);

                        mContentServiceHelper.createUserAddress(new ResponseReceiver<Address>() {
                            @Override
                            public void onResponse(Response<Address> response) {
                                callbackCreateUserAddress.onUserAddressCreated(response.getData().getId());
                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                                fail(ErrorUtils.getFirstErrorMessage(response.getData()));

                            }
                        }, null, queryAddress, null, false, null, null);
                    }
                });


            }
        });

    }

    protected void createCustomerGroup(final CallbackCreateCustomerGroup callbackCreateCustomerGroups) {

        authenticate(new CallbackLogin() {
            @Override
            public void onLogin() {
                final QueryCustomerGroup queryCustomerGroup = new QueryCustomerGroup();
                queryCustomerGroup.setGroupId(generateCustomerGroupName());
                queryCustomerGroup.setLocalizedName("testLocalized");

                mContentServiceHelper.createCustomerGroup(new ResponseReceiverEmpty() {

                    @Override
                    public void onResponse(Response<EmptyResponse> response) {
                        callbackCreateCustomerGroups.onCustomerGroupCreated(queryCustomerGroup.getGroupId());
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, queryCustomerGroup, false, null, null);

            }
        });

    }

//    protected void getPromotions(final CallbackGetPromotions callbackGetPromotions) {
//
//        authenticateAsTrustedClient(new CallbackLogin() {
//            @Override
//            public void onLogin() {
//
//                QueryPromotions queryPromotions = new QueryPromotions();
//                queryPromotions.setType("all");
//
//                mContentServiceHelper.getPromotions(new ResponseReceiver<PromotionList>() {
//
//                    @Override
//                    public void onResponse(Response<PromotionList> response) {
//                        callbackGetPromotions.onGetPromotions(response.getData());
//                    }
//
//                    @Override
//                    public void onError(Response<ErrorList> response) {
//                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
//                    }
//                }, null, queryPromotions, false, null, null);
//            }
//        });
//
//    }

    protected void getCart(final CallbackCart callbackCart) {

        authenticate(new CallbackLogin() {
            @Override
            public void onLogin() {
                mContentServiceHelper.getCart(new ResponseReceiver<Cart>() {
                    @Override
                    public void onResponse(Response<Cart> response) {
                        callbackCart.onCartLoaded();
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, null, false, null, null);

            }
        });

    }

    protected void getCartDeliveryModes(final CallbackGetDeliveryModeForCart callbackGetDeliveryModeForCart) {

        getCart(new CallbackCart() {
            @Override
            public void onCartLoaded() {

                mContentServiceHelper.getCartDeliveryModes(new ResponseReceiver<DeliveryModeList>() {
                    @Override
                    public void onResponse(Response<DeliveryModeList> response) {
                        callbackGetDeliveryModeForCart.onDeliveryModesLoaded(response.getData());
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, null, false, null, null);

            }
        });

    }

    protected void updateCartDeliveryMode(final CallbackSetDeliveryModeForCart callbackSetDeliveryModeForCart) {

        getCartDeliveryModes(new CallbackGetDeliveryModeForCart() {
            @Override
            public void onDeliveryModesLoaded(DeliveryModeList data) {

                QueryDeliveryMode queryDeliveryMode = new QueryDeliveryMode();
                queryDeliveryMode.setDeliveryModeId(data.getDeliveryModes().get(0).getCode());

                mContentServiceHelper.updateCartDeliveryMode(new ResponseReceiverEmpty() {
                    @Override
                    public void onResponse(Response<EmptyResponse> response) {
                        callbackSetDeliveryModeForCart.onDeliveryModeSet();
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, queryDeliveryMode, null, false, null, null);

            }
        });

    }

    protected void createCartDeliveryAddress(final CallbackCreateDeliveryAddressForCart callbackCreateDeliveryAddressForCart) {

        getCart(new CallbackCart() {
            @Override
            public void onCartLoaded() {

                getStaticAttributes(new CallbackStaticAttributes() {

                    @Override
                    public void onAttributesLoaded(List<CardType> cardTypeList, List<Currency> currencyList,
                                                   List<Country> countryList,
                                                   List<Language> languageList, List<Title> titleList) {
                        QueryAddress queryAddress = new QueryAddress();

                        queryAddress.setTitleCode(titleList.get(0).getCode());
                        queryAddress.setFirstName("Test firstName");
                        queryAddress.setLastName("Test lastName");
                        queryAddress.setCountry(countryList.get(0));
                        queryAddress.setLine1("Test line 1");
                        queryAddress.setTown("Test Town");
                        queryAddress.setPostalCode("Test Code");

                        mContentServiceHelper.createCartDeliveryAddress(new ResponseReceiver<Address>() {
                            @Override
                            public void onResponse(Response<Address> response) {
                                callbackCreateDeliveryAddressForCart.onDeliveryAddressCreated(response.getData().getId());
                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                            }
                        }, null, queryAddress, null, false, null, null);
                    }
                });

            }
        });

    }

    protected void updateCartDeliveryAddress(final CallbackSetDeliveryAddressForCart callbackSetDeliveryAddressForCart) {

        createCartDeliveryAddress(new CallbackCreateDeliveryAddressForCart() {
            @Override
            public void onDeliveryAddressCreated(String deliveryAddressId) {

                QueryAddress queryAddress1 = new QueryAddress();
                queryAddress1.setAddressId(deliveryAddressId);

                mContentServiceHelper.updateCartDeliveryAddress(new ResponseReceiverEmpty() {
                    @Override
                    public void onResponse(Response<EmptyResponse> response) {
                        callbackSetDeliveryAddressForCart.onDeliveryAddressSet();
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, queryAddress1, null, false, null, null);

            }
        });

    }

    protected void createCartPayment(final CallbackCreatePaymentForCart callbackCreatePaymentForCart) {

        getCart(new CallbackCart() {
            @Override
            public void onCartLoaded() {

                getStaticAttributes(new CallbackStaticAttributes() {
                    @Override
                    public void onAttributesLoaded(List<CardType> cardTypeList, List<Currency> currencyList, List<Country> countryList,
                                                   List<Language> languageList, List<Title> titleList) {
                        Address billingAddress = new Address();
                        billingAddress.setTitleCode(titleList.get(0).getCode());
                        billingAddress.setFirstName("Test firstName");
                        billingAddress.setLastName("Test lastName");
                        billingAddress.setCountry(countryList.get(0));
                        billingAddress.setLine1("Test line 1");
                        billingAddress.setTown("Test Town");
                        billingAddress.setPostalCode("Test Code");

                        final QueryPayment queryPayment = new QueryPayment();
                        queryPayment.setAccountHolderName("Test Account name");
                        queryPayment.setCardNumber("0000000000000000");
                        queryPayment.setCardType(cardTypeList.get(0).getCode());
                        queryPayment.setExpiryMonth("03");
                        queryPayment.setExpiryYear("2017");
                        queryPayment.setBillingAddress(billingAddress);

                        mContentServiceHelper.createCartPayment(new ResponseReceiver<PaymentDetails>() {
                            @Override
                            public void onResponse(Response<PaymentDetails> response) {
                                callbackCreatePaymentForCart.onPaymentCreated(response.getData().getId());
                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                            }
                        }, null, queryPayment, null, false, null, null);
                    }
                });
            }
        });
    }

    protected void updateCartPayment(final CallbackSetPaymentForCart callbackSetPaymentForCart) {

        createCartPayment(new CallbackCreatePaymentForCart() {
            @Override
            public void onPaymentCreated(String paymentId) {
                QueryPayment queryPayment = new QueryPayment();
                queryPayment.setPaymentDetailsId(paymentId);

                mContentServiceHelper.updateCartPayment(new ResponseReceiverEmpty() {
                    @Override
                    public void onResponse(Response<EmptyResponse> response) {
                        callbackSetPaymentForCart.onPaymentSet();
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, queryPayment, null, false, null, null);

            }
        });

    }

    protected void getCartPromotions(final CallbackGetPromotionsForCart callbackGetPromotionsForCart) {

        addCartEntry(new CallbackAddToCart() {
            @Override
            public void onAddToCart(String entryNumber) {
                mContentServiceHelper.getCartPromotions(new ResponseReceiver<PromotionResultList>() {
                    @Override
                    public void onResponse(Response<PromotionResultList> response) {
                        callbackGetPromotionsForCart.onGetPromotions(response.getData());
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, null, false, null, null);

            }
        });

    }

    protected void getCartVouchers(final CallbackGetVouchersForCart callbackGetVouchersForCart) {

        addCartEntry(new CallbackAddToCart() {
            @Override
            public void onAddToCart(String entryNumber) {
                mContentServiceHelper.getCartVouchers(new ResponseReceiver<VoucherList>() {
                    @Override
                    public void onResponse(Response<VoucherList> response) {
                        callbackGetVouchersForCart.onGetVouchers(response.getData());
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, null, false, null, null);
            }
        });

    }

    protected void getStaticAttributes(final CallbackStaticAttributes CallbackStaticAttributes) {

        final List<List<?>> typeList = new ArrayList<>();

        mContentServiceHelper.getCardTypes(new ResponseReceiver<CardTypeList>() {
            @Override
            public void onResponse(Response<CardTypeList> response) {
                typeList.add(response.getData().getCardTypes());

                mContentServiceHelper.getCurrencies(new ResponseReceiver<CurrencyList>() {
                    @Override
                    public void onResponse(Response<CurrencyList> response) {
                        typeList.add(response.getData().getCurrencies());

                        mContentServiceHelper.getDeliveryCountries(new ResponseReceiver<CountryList>() {
                            @Override
                            public void onResponse(Response<CountryList> response) {
                                typeList.add(response.getData().getCountries());

                                mContentServiceHelper.getLanguages(new ResponseReceiver<LanguageList>() {
                                    @Override
                                    public void onResponse(Response<LanguageList> response) {
                                        typeList.add(response.getData().getLanguages());

                                        mContentServiceHelper.getTitles(new ResponseReceiver<TitleList>() {
                                            @Override
                                            public void onResponse(Response<TitleList> response) {
                                                typeList.add(response.getData().getTitles());

                                                CallbackStaticAttributes
                                                        .onAttributesLoaded((List<CardType>) typeList.get(0), (List<Currency>) typeList.get(1),
                                                                (List<Country>) typeList.get(2), (List<Language>) typeList.get(3),
                                                                (List<Title>) typeList.get(4));
                                            }

                                            @Override
                                            public void onError(Response<ErrorList> response) {
                                                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                                            }
                                        }, null, false, null, null);
                                    }

                                    @Override
                                    public void onError(Response<ErrorList> response) {
                                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                                    }
                                }, null, false, null, null);
                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                            }
                        }, null, false, null, null);
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        fail(ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, null, false, null, null);

            }

            @Override
            public void onError(Response<ErrorList> response) {
                fail(ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, null, false, null, null);

    }

    public abstract ContentServiceHelper buildContentServiceHelper(SSLSocketFactory socketFactory, HostnameVerifier hostnameVerifier);

    public abstract void getProductCodeForTests(CallbackGetProduct callbackGetProduct, QueryProducts queryProducts);

    protected abstract void addCartEntry(final CallbackAddToCart callbackAddToCart);

    public interface CallbackGetProduct {
        void onProductLoaded(String productCode);

        void onProductsLoaded(List<ProductBase> productBases);
    }

    public interface CallbackLogin {
        void onLogin();
    }

    public interface CallbackCreateUserAddress {
        void onUserAddressCreated(String id);
    }

    public interface CallbackCreateCustomerGroup {
        void onCustomerGroupCreated(String groupId);
    }

    public interface CallbackGetPromotions {
        void onGetPromotions(PromotionList promotionList);
    }

    public interface CallbackCart {
        void onCartLoaded();
    }

    public interface CallbackAddToCart {
        void onAddToCart(String entryNumber);
    }

    public interface CallbackGetDeliveryModeForCart {
        void onDeliveryModesLoaded(DeliveryModeList data);
    }

    public interface CallbackSetDeliveryModeForCart {
        void onDeliveryModeSet();
    }

    public interface CallbackCreateDeliveryAddressForCart {
        void onDeliveryAddressCreated(String deliveryAddressId);
    }

    public interface CallbackSetDeliveryAddressForCart {
        void onDeliveryAddressSet();
    }

    public interface CallbackCreatePaymentForCart {
        void onPaymentCreated(String paymentId);
    }

    public interface CallbackSetPaymentForCart {
        void onPaymentSet();
    }

    public interface CallbackGetPromotionsForCart {
        void onGetPromotions(PromotionResultList promotionResultList);
    }

    public interface CallbackGetVouchersForCart {
        void onGetVouchers(VoucherList voucherList);
    }

    public interface CallbackSetOrder {
        void onOrderSet(String code);
    }

    public interface CallbackStaticAttributes {
        void onAttributesLoaded(List<CardType> cardTypeList, List<Currency> currencyList, List<Country> countryList,
                                List<Language> languageList, List<Title> titleList);
    }

}
