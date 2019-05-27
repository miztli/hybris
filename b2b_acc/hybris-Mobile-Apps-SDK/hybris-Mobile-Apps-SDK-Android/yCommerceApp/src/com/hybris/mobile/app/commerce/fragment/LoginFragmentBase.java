package com.hybris.mobile.app.commerce.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.UrlSettingsActivity;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.query.QueryLogin;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.listener.SubmitListener;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public abstract class LoginFragmentBase extends Fragment implements ResponseReceiverEmpty, TextWatcher,
        Animation.AnimationListener {
    /**
     * Define Action when authenticate button is clicked
     */
    public View.OnClickListener loginButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            signIn(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        }

    };
    protected String mLoginRequestId = RequestUtils.generateUniqueRequestId();
    protected EditText mEmailEditText;
    protected EditText mPasswordEditText;
    protected Button mLoginButton;
    protected ImageView mHybrisLoginImg;
    protected Button mClearEmailButton;
    protected Button mClearPasswordButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initialize Components
        mLoginButton = (Button) getView().findViewById(R.id.login_button);
        mEmailEditText = (EditText) getView().findViewById(R.id.email_edit_text);
        mPasswordEditText = (EditText) getView().findViewById(R.id.password_edit_text);
        mHybrisLoginImg = (ImageView) getView().findViewById(R.id.hybris_login_img);
        mClearEmailButton = (Button) getView().findViewById(R.id.clear_email_button);
        mClearEmailButton.setVisibility(View.INVISIBLE);
        mClearPasswordButton = (Button) getView().findViewById(R.id.clear_password_button);
        mClearPasswordButton.setVisibility(View.INVISIBLE);

        mEmailEditText.setText(SessionHelper.getLastLoggedEmail());

        mEmailEditText.addTextChangedListener(this);
        mPasswordEditText.addTextChangedListener(this);

        setAnimation();

        // Add ClickListeners to the buttons
        mLoginButton.setOnClickListener(loginButtonListener);
        mPasswordEditText.setOnEditorActionListener(new SubmitListener() {

            @Override
            public void onSubmitAction() {
                signIn(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
            }
        });

        // Long press on hybris icon will launch the backend url configuration page
        final GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public void onLongPress(MotionEvent e) {
                startActivity(new Intent(getActivity(), UrlSettingsActivity.class));
                super.onLongPress(e);
            }

        });

        mHybrisLoginImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

    }

    /**
     * Define animations for the page
     */
    protected void setAnimation() {
        if (getResources().getBoolean(R.bool.animationOnLoginPage)) {
            Animation animHybrisLoginImg = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
            animHybrisLoginImg.setAnimationListener(this);
            mHybrisLoginImg.setVisibility(View.VISIBLE);
            mHybrisLoginImg.startAnimation(animHybrisLoginImg);

            Animation animClearCrossButton = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            animClearCrossButton.setAnimationListener(this);
            if (StringUtils.isNotBlank(mEmailEditText.getText())) {
                mClearEmailButton.setVisibility(View.VISIBLE);
                mClearEmailButton.startAnimation(animClearCrossButton);
            }

            if (StringUtils.isNotBlank(mPasswordEditText.getText())) {
                mClearPasswordButton.setVisibility(View.VISIBLE);
                mClearPasswordButton.startAnimation(animClearCrossButton);
            }

            Animation animEmailEditText = AnimationUtils.loadAnimation(getActivity(), R.anim.move_right);
            animHybrisLoginImg.setAnimationListener(this);
            mEmailEditText.setVisibility(View.VISIBLE);
            mEmailEditText.startAnimation(animEmailEditText);

            Animation animPasswordEditText = AnimationUtils.loadAnimation(getActivity(), R.anim.move_left);
            animPasswordEditText.setAnimationListener(this);
            mPasswordEditText.setVisibility(View.VISIBLE);
            mPasswordEditText.startAnimation(animPasswordEditText);

            Animation animLoginButton = AnimationUtils.loadAnimation(getActivity(), R.anim.move_up);
            animLoginButton.setAnimationListener(this);
            mLoginButton.setVisibility(View.VISIBLE);
            mLoginButton.startAnimation(animLoginButton);
        }
    }

    @Override
    public void onResponse(Response<EmptyResponse> response) {
        SessionHelper.afterLogin(getActivity(), mLoginRequestId, mEmailEditText.getText().toString());

        afterLogin();
    }


    @Override
    public void onError(Response<ErrorList> response) {
        UIUtils.showAlertMessage(getActivity(), getString(R.string.error_title), ErrorUtils.getFirstErrorMessage(response.getData()));

        // Clearing the field
        mPasswordEditText.setText("");
    }

    @Override
    public void afterTextChanged(Editable s) {
        clearAllEditText();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        setClickableLoginButton();
    }

    /**
     * Blank Text Field when call
     *
     * @param editText : Field to clear
     * @param button   : Action button to clear
     */
    protected void clearEditText(final EditText editText, final Button button) {

        if (StringUtils.isNotBlank(editText.getText())) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText.setText("");
                }
            });

        }

        button.setVisibility(View.INVISIBLE);
    }

    /**
     * Enable Login Button when all fields are correct
     */
    protected void setClickableLoginButton() {

        boolean editable = StringUtils.isNotBlank(mEmailEditText.getText()) && StringUtils.isNotBlank(mPasswordEditText.getText());

        mLoginButton.setEnabled(editable);
        mLoginButton.setClickable(editable);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onResume() {
        super.onResume();

        // Clear the fields and disable authenticate button
        clearAllEditText();
        setClickableLoginButton();

    }

    /**
     * Clear the different EditText
     */
    protected void clearAllEditText() {
        clearEditText(mEmailEditText, mClearEmailButton);
        clearEditText(mPasswordEditText, mClearPasswordButton);

        if (StringUtils.isNotBlank(mEmailEditText.getText())) {
            mClearEmailButton.setVisibility(View.VISIBLE);
        } else {
            mClearEmailButton.setVisibility(View.INVISIBLE);
        }

        if (StringUtils.isNotBlank(mPasswordEditText.getText())) {
            mClearPasswordButton.setVisibility(View.VISIBLE);
        } else {
            mClearPasswordButton.setVisibility(View.INVISIBLE);
        }

    }

    public void signIn(final String email, final String password) {
        beforeLogin(new BeforeLoginCallback() {
            @Override
            public void success() {
                QueryLogin queryLogin = new QueryLogin();
                queryLogin.setUsername(email);
                queryLogin.setPassword(password);

                CommerceApplication.getContentServiceHelper().authenticate(LoginFragmentBase.this, mLoginRequestId, queryLogin, true,
                        Arrays.asList((View) mLoginButton, mEmailEditText, mPasswordEditText), new OnRequestListener() {

                            @Override
                            public void beforeRequest() {
                                getView().findViewById(R.id.sign_in_loading_spinner).setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void afterRequestBeforeResponse() {

                            }

                            @Override
                            public void afterRequest(boolean isDataSynced) {
                                getView().findViewById(R.id.sign_in_loading_spinner).setVisibility(View.GONE);
                            }
                        });
            }

            @Override
            public void error(Response<ErrorList> response) {
                onError(response);
            }
        });


    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mLoginRequestId);
    }

    protected abstract void beforeLogin(BeforeLoginCallback beforeLoginCallback);

    protected abstract void afterLogin();

    public interface BeforeLoginCallback {
        void success();

        void error(Response<ErrorList> response);
    }
}
