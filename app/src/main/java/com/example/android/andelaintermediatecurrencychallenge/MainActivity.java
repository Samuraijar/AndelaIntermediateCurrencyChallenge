package com.example.android.andelaintermediatecurrencychallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button goBtc, goEth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBtc = (Button) findViewById(R.id.goBtc);
        goEth = (Button) findViewById(R.id.goEth);
    }
    public void Go (View view) {
        if (view == goBtc) {
            Intent intent = new Intent(MainActivity.this, BitcoinActivity.class);
            startActivity(intent);
        } else if (view == goEth) {
            Intent intent = new Intent(MainActivity.this, EtheriumActivity.class);
            startActivity(intent);
        }
    }
}
