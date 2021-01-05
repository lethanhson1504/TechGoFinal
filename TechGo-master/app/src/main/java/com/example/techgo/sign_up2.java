package com.example.techgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class sign_up2 extends AppCompatActivity implements Serializable {


    private EditText displayname_text;
    private EditText address_text;
    private EditText birthday_text;
    private Button bt_finish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        Intent i =  getIntent();
        final sign_up data_sign_up = (sign_up)i.getSerializableExtra("data_sign_up");

        displayname_text = findViewById(R.id.display_name_register_text);
        address_text = findViewById(R.id.address_register_text);

        birthday_text = findViewById(R.id.birth_register_text);

        bt_finish = findViewById(R.id.finish_register_bt);

        bt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birthday = birthday_text.getText().toString();
                String address = address_text.getText().toString();

                String display_name = displayname_text.getText().toString();

                //password
                String password = getIntent().getStringExtra("PW");

                //email and phone number
                String email = getIntent().getStringExtra("EMAIL");
                String phone = getIntent().getStringExtra("PHONE");

                String is_customer = getIntent().getStringExtra("IS_CUS");

                //boolean to store customer or driver
                boolean is_cus = false;
                if(is_customer.equals("true"))
                    is_cus = true;

            }
        }) ;

        Button bt_pre = findViewById(R.id.previous_register_bt);
        bt_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }) ;

    }

}