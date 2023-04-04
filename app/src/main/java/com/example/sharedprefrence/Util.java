package com.example.sharedprefrence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.hotspot2.pps.Credential;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class Util {

    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;

    public static void storeCred(String id, String pwd, Context context) {

        preferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = preferences.edit();


        editor.putString("userId", id);
        editor.putString("userPassword", pwd);
        editor.commit();
        editor.apply();


        Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();

    }

    public static String[] getCred() {
        String[] cred = new String[2];

        String userId = preferences.getString("userId", "");
        String userPassword = preferences.getString("userPassword", "");

        cred[0] = userId;
        cred[1] = userPassword;

        return cred;

    }

    public class isConnected {


        public static boolean isConnected(Context context) {


            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                if (networkInfo.isConnected())
                    return true;
                else
                    return false;
            } else
                return false;

        }
    }
    public class UtilHelperClass {

        static MaterialAlertDialogBuilder builder;


        public static void ShowDialog(String msg, Context context) {
            builder = new MaterialAlertDialogBuilder(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.alert, null);

            builder.setView(view);

            builder.setCancelable(false);

            AlertDialog dialog = builder.create();

            @SuppressLint({"MissingInflatedId", "LocalSuppress"})
            TextView textAlert = view.findViewById(R.id.textAlert);
            textAlert.setText(msg);

            dialog.show();
        }


    }


}

