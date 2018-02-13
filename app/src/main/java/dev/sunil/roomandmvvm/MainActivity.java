package dev.sunil.roomandmvvm;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import dev.sunil.roomandmvvm.ClickEvent.ClickListener;
import dev.sunil.roomandmvvm.databinding.LoginDataBinding;
import dev.sunil.roomandmvvm.db.User;
import dev.sunil.roomandmvvm.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LoginDataBinding loginDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LoginViewModel loginViewModel = new LoginViewModel("Please enter email id", "Please enter password", "Forgot Password?", "Login");

        loginDataBinding.setLogin(loginViewModel);

        loginDataBinding.setModelClickListener(new ClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, loginDataBinding.getLogin().getUserEmail(), Toast.LENGTH_LONG).show();
            }
        });

         //to insert data in Room
        loginDataBinding.getLogin().populateData(MainActivity.this);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                User user = loginDataBinding.getLogin().getDbHelper().getUserInfo(2);

                loginDataBinding.getLogin().setUserEmail("" + user.name+ " "+user.lastName);
            }
        });
    }


}
