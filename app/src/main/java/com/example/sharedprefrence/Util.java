package com.example.sharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.Credential;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class Util {

    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;

    public static void storeCred(String id, String pwd, Context context){

        preferences = context.getSharedPreferences("login",Context.MODE_PRIVATE);
        editor =preferences.edit();



        editor.putString("userId",id);
        editor.putString("userPassword",pwd);
        editor.commit();
        editor.apply();


        Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();

    }

    public static String [] getCred(){
        String[] cred = new String[2];

        String userId = preferences.getString("userId","");
        String userPassword = preferences.getString("userPassword","");

        cred[0]=userId;
        cred[1]=userPassword;

        return cred;

    }


   // public static void ShowAlert(String msg, Context context){

     //   MaterialAlertDialogBuilder

    //}



}
