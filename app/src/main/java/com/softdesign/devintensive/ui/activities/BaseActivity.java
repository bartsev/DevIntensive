package com.softdesign.devintensive.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

public class BaseActivity extends AppCompatActivity {
    static final String TAG = ConstantManager.TAG_PREFIX + "BaseActivity";
//    protected progressDialog mProgressDialog;
/*
    public void showProgress(){
        if (mProgressDialog == null) {
            mProgressDialog = new progressDialog(this.R.style.custom_dialog);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().
        }
    }
*/
    public void hideProgress() {

    }

    public void showError(String message, Exception error) {
        showToast(message);
        Log.e(TAG, String.valueOf(error));
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}