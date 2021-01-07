package com.example.techgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bookScreen extends AppCompatActivity {
    TextView from_textView;
    TextView to_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_screen);


        from_textView = findViewById(R.id.from_booking_text);
        from_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(bookScreen.this, pickingLocationCustomer.class);
                startActivityForResult(intent, 1);

            }

        }) ;

        to_textView = findViewById(R.id.to_booking_text);
        to_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(bookScreen.this, DestinationLocation.class);
                startActivityForResult(intent, 2);

            }

        }) ;

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.payment_method, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode == 1)
        {
            String message=data.getStringExtra("PICK_ADRS");
            from_textView.setText(message);
        }
        if (requestCode == 2)
        {
            String message=data.getStringExtra("DES_ADRS");
            to_textView.setText(message);
        }
    }
}

