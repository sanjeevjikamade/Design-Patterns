package com.sanjeev.androidtest;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sanjeev.androidtest.Interface.LoginResultCallbacks;
import com.sanjeev.androidtest.ViewModel.LoginViewModel;
import com.sanjeev.androidtest.ViewModel.LoginViewModelFactory;
import com.sanjeev.androidtest.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String result) {
        Toasty.success(this, "Login Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String result) {
        Toasty.error(this, "Login Error!!!", Toast.LENGTH_LONG).show();
    }
}
