package com.karyakita.karyakita_android_new.base;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base_customview.BaseToaster;

import butterknife.Unbinder;

public abstract class BaseFragment<T1 extends FragmentActivity, T2 extends IBasePresenter> extends Fragment{
    protected String    title;
    protected T1        activity;
    protected T2        mPresenter;
    protected View      fragmentView;

    protected IBaseFragmentListener fragmentListener;

    protected Unbinder      unbinder;
    protected AlertDialog   alertDialog;

    protected Boolean   loading;

    protected abstract void setTitle();

    protected String getTitle() {
        return this.title;
    }

    protected Boolean isLoading() {
        return this.loading;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        title = getResources().getString(R.string.app_name);
        setTitle();
        fragmentListener.setTitle(title);

        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (T1) context;
        this.fragmentListener = (IBaseFragmentListener) context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @SuppressLint("RestrictedApi")
    protected void setLoadingDialog(boolean isLoading, @Nullable String message) {
        loading = isLoading;
        if (isLoading) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
            LayoutInflater inflater = this.getLayoutInflater(null);
            View dialogView = inflater.inflate(R.layout.dialog_loading, null);
            TextView tvMessage = (TextView) dialogView.findViewById(R.id.tvMessage);
            tvMessage.setText(message);
            dialogBuilder.setView(dialogView);
            alertDialog = dialogBuilder.create();
            alertDialog.setCancelable(false);
            alertDialog.show();
        } else {
            if (alertDialog != null && alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        }
    }

    protected void showStatus(int type, String message) {
        showToast(type, message);
    }

    protected void showToast(int type, String message) {
        new BaseToaster().builder(this.activity)
                .setType(type)
                .setMessage(message)
                .show();
    }

    protected AlertDialog.Builder createAlert(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.activity);
        alertDialogBuilder
                .setTitle(title)
                .setMessage(message);
        return alertDialogBuilder;
    }
}
