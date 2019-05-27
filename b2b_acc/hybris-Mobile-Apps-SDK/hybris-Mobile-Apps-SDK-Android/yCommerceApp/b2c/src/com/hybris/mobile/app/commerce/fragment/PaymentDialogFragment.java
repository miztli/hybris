package com.hybris.mobile.app.commerce.fragment;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.CardType;
import com.hybris.mobile.lib.commerce.data.order.CardTypeList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.AddressList;
import com.hybris.mobile.lib.commerce.query.QueryPayment;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PaymentDialogFragment extends Fragment {

    private String mCreatePaymentRequestId = RequestUtils.generateUniqueRequestId();

    private CreatePaymentListener mListener;

    private EditText mCardNumber;
    private EditText mExpiryMonth;
    private EditText mExpiryYear;
    private EditText mIssueNumber;
    private EditText mHolderName;
    private CheckBox mSavePayment;
    private CheckBox mDefaultPayment;
    private Spinner mCardType;
    private Spinner mAddress;
    private View mAddNewAddress;
    private View mAddressBlock;
    private View mNewAddressBlock;
    private Button mSubmitButton;

    private TextView mPaymentTitle;

    private List<CardType> mCardTypes;
    private ArrayAdapter<String> mCardTypeAdapter;
    private List<Address> mAddresses;
    private ArrayAdapter<String> mAddressAdapter;

    private Address mSelectedAddress;
    private AddressDialogFragment mAddressDialogFragment;

    private PaymentDetails mPaymentDetails = null;

    private TextWatcher mEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkFormAndActivateSubmitButton();
        }

    };
    private PaymentListFragment.OnPaymentSelectedListener mPaymentSelectedListener;

    public static PaymentDialogFragment newInstance() {
        return new PaymentDialogFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (CreatePaymentListener) activity;
            mPaymentSelectedListener = (PaymentListFragment.OnPaymentSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement CreatePaymentListener and PaymentListFragment.OnPaymentSelectedListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_payment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);

        mCardNumber = (EditText) getView().findViewById(R.id.payment_credit_card_number);
        mExpiryMonth = (EditText) getView().findViewById(R.id.payment_expiry_date_month);
        mExpiryYear = (EditText) getView().findViewById(R.id.payment_expiry_date_year);
        mIssueNumber = (EditText) getView().findViewById(R.id.payment_issue_number);
        mHolderName = (EditText) getView().findViewById(R.id.payment_holder_name);
        mSavePayment = (CheckBox) getView().findViewById(R.id.payment_save);
        mDefaultPayment = (CheckBox) getView().findViewById(R.id.payment_default);
        mCardType = (Spinner) getView().findViewById(R.id.payment_credit_card_type);
        mAddress = (Spinner) getView().findViewById(R.id.payment_address);
        mAddNewAddress = getView().findViewById(R.id.payment_add_new_address);
        mAddressBlock = getView().findViewById(R.id.payment_address_block);
        mNewAddressBlock = getView().findViewById(R.id.payment_new_address_block);
        mSubmitButton = (Button) getView().findViewById(R.id.payment_submit);
        mPaymentTitle = (TextView) getView().findViewById(R.id.payment_title);

        // Text listeners
        mCardNumber.addTextChangedListener(mEditTextWatcher);
        mHolderName.addTextChangedListener(mEditTextWatcher);
        mExpiryMonth.addTextChangedListener(mEditTextWatcher);
        mExpiryYear.addTextChangedListener(mEditTextWatcher);
        mIssueNumber.addTextChangedListener(mEditTextWatcher);

        // Spinner adapters
        mAddressAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());
        mAddress.setAdapter(mAddressAdapter);
        mCardTypeAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());
        mCardType.setAdapter(mCardTypeAdapter);

        mCardType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkFormAndActivateSubmitButton();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //If no payment set, we create new one else we load the data from existing one
        if (mPaymentDetails == null) {
            setCreateMode();
        } else {
            setEditMode();
        }
    }

    /**
     * Add a new payment
     */
    private void setCreateMode() {

        mPaymentTitle.setText(R.string.create_payment_title);

        // Filling card types
        CommerceApplication.getContentServiceHelper().getCardTypes(new ResponseReceiver<CardTypeList>() {
            @Override
            public void onResponse(Response<CardTypeList> response) {
                if (response.getData() != null && response.getData().getCardTypes() != null) {
                    mCardTypes = response.getData().getCardTypes();

                    mCardTypeAdapter.clear();

                    for (CardType cardType : mCardTypes) {
                        mCardTypeAdapter.add(cardType.getName());
                    }

                    mCardTypeAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, mCreatePaymentRequestId, false, null, mOnRequestListener);


        // On select an existing address
        mAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedAddress = mAddresses.get(position);
                checkFormAndActivateSubmitButton();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mAddNewAddress.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
                @Override
                public void onClick(View v) {
                    // Clear the address list
                    mAddressAdapter.clear();
                    mAddressAdapter.notifyDataSetChanged();
                    mSelectedAddress = null;

                    // Hide the address block
                    mAddressBlock.setVisibility(View.GONE);

                    // Add the create address fragment to the view
                    showCreateAddressView();
                }
            });
        }
        // Add new address not available < Jelly bean
        else {
            mAddNewAddress.setVisibility(View.GONE);
        }

        // Filling existing user addresses
        CommerceApplication.getContentServiceHelper().getUserAddresses(new ResponseReceiver<AddressList>() {
            @Override
            public void onResponse(Response<AddressList> response) {
                if (response.getData() != null && response.getData().getAddresses() != null && !response.getData().getAddresses().isEmpty()) {
                    mAddresses = response.getData().getAddresses();

                    mAddressAdapter.clear();

                    for (Address address : mAddresses) {
                        mAddressAdapter.add(address.getFormattedAddress());
                    }

                    mAddressAdapter.notifyDataSetChanged();

                    // Select the first item in the list
                    mAddress.setSelection(0);

                    // Set the address block visible
                    mAddressBlock.setVisibility(View.VISIBLE);
                } else {
                    // Hide the address block
                    mAddressBlock.setVisibility(View.GONE);

                    // Add new address fragment
                    showCreateAddressView();
                }
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, mCreatePaymentRequestId, null, false, null, null);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {

                if (checkFormAndActivateSubmitButton()) {
                    // Only for api > jelly bean
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        // Try to get the address from the address fragment
                        AddressDialogFragment addressDialogFragment = (AddressDialogFragment) getChildFragmentManager().findFragmentById(mNewAddressBlock.getId());

                        if (addressDialogFragment != null) {
                            mSelectedAddress = mAddressDialogFragment.getAddress();
                        }

                    }

                    QueryPayment queryPayment = new QueryPayment();
                    queryPayment.setCardType(mCardTypes.get(mCardType.getSelectedItemPosition()).getCode());
                    queryPayment.setCardNumber(mCardNumber.getText().toString());
                    queryPayment.setAccountHolderName(mHolderName.getText().toString());
                    queryPayment.setExpiryMonth(mExpiryMonth.getText().toString());
                    queryPayment.setExpiryYear(mExpiryYear.getText().toString());
                    queryPayment.setIssueNumber(mIssueNumber.getText().toString());
                    queryPayment.setSaved(mSavePayment.isChecked());
                    queryPayment.setDefaultPaymentInfo(mDefaultPayment.isChecked());
                    queryPayment.setBillingAddress(mSelectedAddress);

                    CommerceApplication.getContentServiceHelper().createCartPayment(new ResponseReceiver<PaymentDetails>() {
                        @Override
                        public void onResponse(Response<PaymentDetails> response) {
                            mListener.onPaymentCreated(response.getData());
                            if (getFragmentManager().getBackStackEntryCount() > 0) {
                                getFragmentManager().popBackStack();
                            }
                        }

                        @Override
                        public void onError(Response<ErrorList> response) {
                            UIUtils.showError(response, getActivity());
                        }
                    }, mCreatePaymentRequestId, queryPayment, null, false, Arrays.asList((View) mSubmitButton), null);

                }

            }
        });
    }

    /**
     * Modify an existing payment
     */
    private void setEditMode() {
        mPaymentTitle.setText(R.string.payment_edit_title);

        if (mPaymentDetails != null) {

            // Show the new address block
            mNewAddressBlock.setVisibility(View.VISIBLE);

            // Filling card types
            CommerceApplication.getContentServiceHelper().getCardTypes(new ResponseReceiver<CardTypeList>() {
                @Override
                public void onResponse(Response<CardTypeList> response) {
                    if (response.getData() != null && response.getData().getCardTypes() != null) {
                        mCardTypes = response.getData().getCardTypes();

                        mCardTypeAdapter.clear();

                        for (CardType cardType : mCardTypes) {
                            mCardTypeAdapter.add(cardType.getName());
                        }

                        mCardTypeAdapter.notifyDataSetChanged();

                        if (mCardTypes != null) {
                            int i = 0;
                            for (CardType cardType : mCardTypes) {

                                if (mPaymentDetails.getCardType() != null && StringUtils.equals(cardType.getCode(), mPaymentDetails.getCardType().getCode())) {

                                    mCardType.setSelection(i);
                                }
                                i++;

                            }
                        }
                    }
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mCreatePaymentRequestId, false, null, mOnRequestListener);

            mCardNumber.setText(mPaymentDetails.getCardNumber());
            mExpiryMonth.setText(mPaymentDetails.getExpiryMonth());
            mExpiryYear.setText(mPaymentDetails.getExpiryYear());
            mIssueNumber.setText(mPaymentDetails.getIssueNumber());
            mHolderName.setText(mPaymentDetails.getAccountHolderName());
            mDefaultPayment.setChecked(mPaymentDetails.getDefaultPayment());


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                // Add the create address fragment to the view
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                mAddressDialogFragment = AddressDialogFragment.newInstance(true, mEditTextWatcher);

                if (mPaymentDetails.getBillingAddress() != null) {
                    mAddressDialogFragment.setAddress(mPaymentDetails.getBillingAddress());
                }
                fragmentTransaction.add(mNewAddressBlock.getId(), mAddressDialogFragment);
                fragmentTransaction.commit();

            }

            mSubmitButton.setText(R.string.address_dialog_done);

            mSubmitButton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NewApi")
                @Override
                public void onClick(View v) {

                    if (checkFormAndActivateSubmitButton()) {
                        // Only for api > jelly bean
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            // Try to get the address from the address fragment
                            AddressDialogFragment addressDialogFragment = (AddressDialogFragment) getChildFragmentManager().findFragmentById(mNewAddressBlock.getId());

                            if (addressDialogFragment != null) {
                                mSelectedAddress = mAddressDialogFragment.getAddress();
                                mSelectedAddress.setVisibleInAddressBook(true);
                            }
                        }

                        QueryPayment queryPayment = new QueryPayment();
                        queryPayment.setPaymentDetailsId(mPaymentDetails.getId());
                        queryPayment.setCardType(mCardTypes.get(mCardType.getSelectedItemPosition()).getCode());
                        queryPayment.setCardNumber(mCardNumber.getText().toString());
                        queryPayment.setAccountHolderName(mHolderName.getText().toString());
                        queryPayment.setExpiryMonth(mExpiryMonth.getText().toString());
                        queryPayment.setExpiryYear(mExpiryYear.getText().toString());
                        queryPayment.setIssueNumber(mIssueNumber.getText().toString());
                        queryPayment.setDefaultPaymentInfo(mDefaultPayment.isChecked());
                        queryPayment.setBillingAddress(mSelectedAddress);


                        CommerceApplication.getContentServiceHelper().replaceUserPaymentDetails(new ResponseReceiverEmpty() {
                            @Override
                            public void onResponse(Response<EmptyResponse> response) {
                                Alert.showSuccess(getActivity(), getActivity().getString(R.string.payment_updated_message));
                                mPaymentSelectedListener.onPaymentListRefreshed();

                                if (getFragmentManager().getBackStackEntryCount() > 0) {
                                    getFragmentManager().popBackStack();
                                }

                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                            }
                        }, mCreatePaymentRequestId, queryPayment, null, false, Arrays.asList((View) mSubmitButton), null);
                    }
                }
            });
        }
    }

    private void showCreateAddressView() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            // Add the create address fragment to the view
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mAddressDialogFragment = AddressDialogFragment.newInstance(true, mEditTextWatcher);
            fragmentTransaction.add(mNewAddressBlock.getId(), mAddressDialogFragment);
            fragmentTransaction.commit();

            // Show the new address block
            mNewAddressBlock.setVisibility(View.VISIBLE);
        }

    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        mPaymentDetails = paymentDetails;
    }

    /**
     * Activate/deactivate the create payment button
     */
    private boolean checkFormAndActivateSubmitButton() {
        boolean isValid = StringUtils.isNotBlank((String) mCardType.getSelectedItem()) && StringUtils.isNotBlank(mCardNumber.getText()) && StringUtils.isNotBlank(mExpiryMonth.getText()) && StringUtils.isNotBlank(mExpiryYear.getText()) && StringUtils.isNotBlank(mIssueNumber.getText()) && StringUtils.isNotBlank(mHolderName.getText())
                && StringUtils.isNotBlank((String) mCardType.getSelectedItem()) && (mSelectedAddress != null || (mAddressDialogFragment != null && mAddressDialogFragment.isAddressValid()));
        mSubmitButton.setEnabled(isValid);
        return isValid;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mPaymentSelectedListener = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mCreatePaymentRequestId);
    }

    public interface CreatePaymentListener {
        /**
         * Method for callback
         *
         * @param paymentDetails
         */
        void onPaymentCreated(PaymentDetails paymentDetails);

        /**
         * Show the create payment page
         */
        void showCreatePayment();
    }

    /**
     * Show ProgressBar when Request is send and Hide ProgressBar when Response is received
     */
    private OnRequestListener mOnRequestListener = new OnRequestListener() {
        @Override
        public void beforeRequest() {
            getView().findViewById(R.id.payment_loading).setVisibility(View.VISIBLE);
        }

        @Override
        public void afterRequestBeforeResponse() {

        }

        @Override
        public void afterRequest(boolean isDataSynced) {
            getView().findViewById(R.id.payment_loading).setVisibility(View.GONE);
            getView().findViewById(R.id.payment_main_layout).setVisibility(View.VISIBLE);
        }
    };
}
