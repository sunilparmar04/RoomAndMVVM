package dev.sunil.roomandmvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import dev.sunil.roomandmvvm.db.DBHelper;

/**
 * Created by sunilkumar_cont2 on 13/02/18.
 */

public class LoginViewModel extends BaseObservable {


    public String passwordHint;
    private String emailHint;

    //Data of edittexts you require for data saving.
    private String userEmail;
    private String userPassword;


    // Setting texts of forgot password link and
    public String forgotPasswordText;
    public String loginButtonText;

    DBHelper dbHelper;
    public LoginViewModel(String emailHint, String passwordHint, String forgotPasswordText, String loginButtonText) {
        this.emailHint = emailHint;
        this.passwordHint = passwordHint;
        this.forgotPasswordText = forgotPasswordText;
        this.loginButtonText = loginButtonText;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public String getEmailHint() {
        return emailHint;
    }

    public void setEmailHint(String emailHint) {
        this.emailHint = emailHint;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getForgotPasswordText() {
        return forgotPasswordText;
    }

    public void setForgotPasswordText(String forgotPasswordText) {
        this.forgotPasswordText = forgotPasswordText;
    }

    public String getLoginButtonText() {
        return loginButtonText;
    }

    public void setLoginButtonText(String loginButtonText) {
        this.loginButtonText = loginButtonText;
    }


    public void populateData(Context context){

        if(dbHelper==null){
            dbHelper=new DBHelper(context);
        }

        dbHelper.addUser("1","Hey Ola"," Play",24);
    }

    public DBHelper getDbHelper() {
        return dbHelper;
    }
}
