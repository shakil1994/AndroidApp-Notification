package com.example.shakil.androidsendmessageclient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.shakil.androidsendmessageclient.Common.Common;
import com.google.firebase.messaging.FirebaseMessaging;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView txt_get_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_get_message = findViewById(R.id.txt_get_message);

        txt_get_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingDialog();
            }
        });
    }

    private void showSettingDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("SETTINGS");

        LayoutInflater inflater = LayoutInflater.from(this);
        View layout_setting = inflater.inflate(R.layout.setting_layout, null);

        final CheckBox ckb_subcribe_new = layout_setting.findViewById(R.id.ckb_sub_new);
        //Add code remember state of checkbox
        Paper.init(this);
        String isSubscribe = Paper.book().read("sub_new");
        if (isSubscribe == null || TextUtils.isEmpty(isSubscribe) || isSubscribe.equals("false")) {
            ckb_subcribe_new.setChecked(false);
        } else {
            ckb_subcribe_new.setChecked(true);
        }

        alertDialog.setView(layout_setting);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                if (ckb_subcribe_new.isChecked()) {
                    FirebaseMessaging.getInstance().subscribeToTopic(Common.topicName);

                    //Write value
                    Paper.book().write("sub_new", "true");
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic(Common.topicName);

                    //Write value
                    Paper.book().write("sub_new", "false");
                }
            }
        });
        alertDialog.show();
    }
}
