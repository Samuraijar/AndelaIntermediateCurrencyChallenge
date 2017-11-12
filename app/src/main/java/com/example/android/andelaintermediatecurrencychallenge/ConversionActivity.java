package com.example.android.andelaintermediatecurrencychallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by NORMAL on 11/12/2017.
 */

public class ConversionActivity extends AppCompatActivity {
    private TextView txt1, txt2, txt3, txt4, txt5, result;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_activity);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        result = (TextView) findViewById(R.id.result);
        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.convert);

        Intent intent = this.getIntent();

        if (intent != null) {
            String data = intent.getExtras().getString("bitcoins");
            if (data.equals("bitcoins")) {
                Bundle bundle = getIntent().getBundleExtra("bit");
                if (bundle == null) {
                    finish();
                } else {
                    final String page = bundle.getString("BitIntent");
                    final String currency = bundle.getString("currency");
                    String country = bundle.getString("country");
                    String countryCode = bundle.getString("countryCode");

                    txt1.setText(page);
                    txt2.setText(country + ":");
                    txt3.setText(currency);
                    txt5.setText(countryCode);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            float btcRate = Float.parseFloat(currency);
                            int btc = 1;
                            double total;

                            String btcEdit = editText.getText().toString();
                            double inputAmount = Float.parseFloat(btcEdit);
                            total = inputAmount / btcRate;
                            if (total <= 1) {
                                txt4.setText("BITCOIN");
                            } else {
                                txt4.setText("BITCOINS");
                            }

                            result.setText(String.format(Locale.getDefault(), "%.2f", total));
                        }

                    });
                }
            }
            if (data.equals("ethereum")) {
                Bundle bundle = getIntent().getBundleExtra("bit");
                if (bundle == null) {
                    finish();
                } else {
                    final String page = bundle.getString("EthIntent");
                    final String currency = bundle.getString("currency");
                    String country = bundle.getString("country");
                    String countryCode = bundle.getString("countryCode");

                    txt1.setText(page);
                    txt2.setText(country + ":");
                    txt3.setText(currency);
                    txt5.setText(countryCode);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            float btcRate = Float.parseFloat(currency);
                            int btc = 1;
                            double total;

                            String btcEdit = editText.getText().toString();
                            double inputAmount = Float.parseFloat(btcEdit);
                            total = inputAmount / btcRate;
                            if (total <= 1) {
                                txt4.setText("ETHERIUM");
                            } else {
                                txt4.setText("ETHERIUMS");
                            }

                            result.setText(String.format(Locale.getDefault(), "%.2f", total));
                        }

                    });
                }
            }
        }
    }
}