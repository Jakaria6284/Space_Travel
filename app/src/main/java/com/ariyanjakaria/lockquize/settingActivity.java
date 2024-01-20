package com.ariyanjakaria.lockquize;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class settingActivity extends AppCompatActivity {
    ImageView cancel;
    LinearLayout setting, getSchedule, sendSchedule, Support, Appearance, Pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.bblack));
        }
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(settingActivity.this, homeeActivity.class));

                finish();
            }
        });

        setting = findViewById(R.id.settin);
        getSchedule = findViewById(R.id.getschedule);
        sendSchedule = findViewById(R.id.sendschedule);
        Support = findViewById(R.id.support);
        Appearance = findViewById(R.id.appearance);
        Pro = findViewById(R.id.pro);

        getSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(settingActivity.this);
                dialog.setContentView(R.layout.apptiledialog);
                dialog.setCancelable(true);
                EditText editText=dialog.findViewById(R.id.Apptitelupload);
                TextView textView=dialog.findViewById(R.id.appsubmit);


                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String AppName=editText.getText().toString().toString();

                        if (AppName.isEmpty()) {

                            Toast.makeText(settingActivity.this, "Please fill in the fields", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Intent intent=new Intent(settingActivity.this,CalenderActivity.class);
                        intent.putExtra("userID",AppName);
                        startActivity(intent);
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });

          sendSchedule.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {


              }
          });



        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(settingActivity.this, editnameChangeActivity.class));
            }
        });

        Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsApp();
                Toast.makeText(settingActivity.this, "Support will be available only Gmail", Toast.LENGTH_SHORT).show();

            }
        });
    }


        private void openWhatsApp() {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@gmail.com "}); // Set the recipient
            intent.putExtra(Intent.EXTRA_SUBJECT, "Support"); // Set the subject
            intent.putExtra(Intent.EXTRA_TEXT, "whats type of support do you need type here"); // Set the email body
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        }



}





