package com.example.happybrithday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textViewHappyBrithday;
    TextView textViewFromEmma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHappyBrithday=(TextView)findViewById(R.id.txtHappyBrithday);
        textViewHappyBrithday.setText("HAPPY BIRTHDAY SAM!");

        textViewFromEmma=(TextView)findViewById(R.id.txtFromEmma);
        textViewFromEmma.setText("FROM EMMA");

    }
}