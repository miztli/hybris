/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.app.commerce.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.PaymentListFragment;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.query.QueryPayment;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Adapter for the products of the order
 */
public class AccountPaymentAdapter extends ArrayAdapter<PaymentDetails> {

    protected static final String TAG = AccountPaymentAdapter.class.getCanonicalName();

    protected List<PaymentDetails> mPaymentList;
    protected String mRequestId = RequestUtils.generateUniqueRequestId();
    protected PaymentListFragment.OnPaymentSelectedListener mOnPaymentSelectedListener;

    public AccountPaymentAdapter(Activity context, List<PaymentDetails> values, String requestId, PaymentListFragment.OnPaymentSelectedListener onPaymentSelectedListener) {
        super(context, R.layout.item_payment_details, values);
        this.mPaymentList = values;
        this.mRequestId = requestId;
        this.mOnPaymentSelectedListener = onPaymentSelectedListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_payment_details, parent, false);
            rowView.setTag(new PaymentViewHolder(rowView, position));
        } else {
            rowView = convertView;
        }

        PaymentViewHolder mPaymentViewHolder = (PaymentViewHolder) rowView.getTag();


        final PaymentDetails paymentDetails = getItem(position);

        if (paymentDetails != null) {

            mPaymentViewHolder.paymentCardholderName.setText(paymentDetails.getAccountHolderName());
            mPaymentViewHolder.cardDetails.setText(paymentDetails.getCardType().getName() + "\n"+ paymentDetails.getCardNumber()+ "\n"+ paymentDetails.getExpiryMonth() +"/"+ paymentDetails.getExpiryYear());

            if(paymentDetails.getBillingAddress() != null) {

                mPaymentViewHolder.billingAddress.setText(StringUtils.isNotBlank(paymentDetails.getBillingAddress().getFormattedAddress())?paymentDetails.getBillingAddress().getFormattedAddress(): paymentDetails.getBillingAddress().getLine1() + " " + paymentDetails.getBillingAddress().getLine2() + ",\n " + paymentDetails.getBillingAddress().getTown() + " " + paymentDetails.getBillingAddress().getPostalCode());
            }


            mPaymentViewHolder.paymentDefaultImageView.setVisibility(View.GONE);
            mPaymentViewHolder.paymentSetDefaultButton.setVisibility(View.INVISIBLE);


            mPaymentViewHolder.paymentDefaultImageView.setVisibility(position == 0 ? View.VISIBLE : View.INVISIBLE);
            //mPaymentViewHolder.paymentSetDefaultButton.setVisibility(position == 0 ? View.INVISIBLE : View.VISIBLE);
            mPaymentViewHolder.paymentDeleteButton.setVisibility(View.VISIBLE);


            mPaymentViewHolder.paymentSetDefaultButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    setDefaultPayment(paymentDetails);
                    Alert.showSuccess(getContext(), getContext().getString(R.string.payment_default_updated_message));


                }
            });

            mPaymentViewHolder.paymentDetailsLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnPaymentSelectedListener.onPaymentSelected(paymentDetails);
                }
            });
        }

          mPaymentViewHolder.paymentDeleteButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  AlertDialog dialog;
                  AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                  builder.setMessage(R.string.payment_delete_message)
                          .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                              public void onClick(DialogInterface dialog, int id) {

                                  QueryPayment queryPayment = new QueryPayment();
                                  queryPayment.setPaymentDetailsId(paymentDetails.getId());

                                  CommerceApplication.getContentServiceHelper().deleteUserPaymentDetails(new ResponseReceiverEmpty() {
                                      @Override
                                      public void onResponse(Response<EmptyResponse> response) {

                                          Alert.showSuccess(getContext(), getContext().getString(R.string.payment_delete_success_message));

                                          if (position < mPaymentList.size()) {
                                              mPaymentList.remove(position);
                                          }
                                          mOnPaymentSelectedListener.onPaymentListRefreshed();

                                          //Default is the first but if deleted select the next one as default
                                          if (mPaymentList != null && !mPaymentList.isEmpty() && position == 0) {
                                              setDefaultPayment(mPaymentList.get(0));
                                          }
                                      }

                                      @Override
                                      public void onError(Response<ErrorList> response) {

                                      }
                                  }, null, queryPayment, null, false, null, null);

                                  dialog.dismiss();

                              }
                          })
                          .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                              public void onClick(DialogInterface dialog, int id) {
                                  dialog.cancel();
                              }
                          });

                  dialog = builder.create();
                  dialog.show();
              }
          });


        return rowView;
    }

    private void setDefaultPayment(PaymentDetails payment) {
        QueryPayment queryPayment = new QueryPayment();
        queryPayment.setPaymentDetailsId(payment.getId());

        queryPayment.setDefaultPaymentInfo(true);


        queryPayment.setAccountHolderName(payment.getAccountHolderName());
        queryPayment.setCardNumber(payment.getCardNumber());
        queryPayment.setCardType(payment.getCardType().getCode());
        queryPayment.setExpiryMonth(payment.getExpiryMonth());
        queryPayment.setExpiryYear(payment.getExpiryYear());
        queryPayment.setBillingAddress(payment.getBillingAddress());

        CommerceApplication.getContentServiceHelper().replaceUserPaymentDetails(new ResponseReceiverEmpty() {
            @Override
            public void onResponse(Response<EmptyResponse> response) {
                Alert.showSuccess(getContext(), getContext().getString(R.string.payment_default_updated_message));
                mOnPaymentSelectedListener.onPaymentListRefreshed();

            }

            @Override
            public void onError(Response<ErrorList> response) {

            }
        }, null, queryPayment, null, false, null, null);

    }


    @Override
    public int getCount() {
        return mPaymentList.size();
    }

    @Override
    public Activity getContext() {
        return (Activity) super.getContext();
    }

    /**
     * Contains all UI elements for Order to improve view display while scrolling
     */
    static class PaymentViewHolder {

        LinearLayout paymentDetailsLayout;
        Button paymentDeleteButton;
        TextView paymentCardholderName;
        TextView billingAddress;
        TextView cardDetails;
        Button paymentSetDefaultButton;
        ImageView paymentDefaultImageView;

        public PaymentViewHolder(View view, int position) {

            paymentDetailsLayout = (LinearLayout) view.findViewById(R.id.payment_details_layout);
            paymentCardholderName = (TextView) view.findViewById(R.id.payment_cardholder_name);
            cardDetails = (TextView) view.findViewById(R.id.card_details);
            billingAddress = (TextView) view.findViewById(R.id.billing_address);

            paymentDefaultImageView = (ImageView) view.findViewById(R.id.default_payment_details_checked_image);
            paymentSetDefaultButton = (Button) view.findViewById(R.id.payment_details_set_default_button);
            paymentDeleteButton = (Button) view.findViewById(R.id.payment_delete_button);

            paymentDetailsLayout.setContentDescription("payment_details_layout" + position);
            paymentCardholderName.setContentDescription("payment_cardholder_name" + position);
            cardDetails.setContentDescription("card_details" + position);
            billingAddress.setContentDescription("billing_address" + position);
            paymentDefaultImageView.setContentDescription("default_payment_details_checked_image" + position);
            paymentSetDefaultButton.setContentDescription("payment_details_set_default_button" + position);
            paymentDeleteButton.setContentDescription("payment_delete_button" + position);


        }
    }
}
