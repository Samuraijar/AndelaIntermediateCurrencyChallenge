package com.example.android.andelaintermediatecurrencychallenge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NORMAL on 11/12/2017.
 */

public class BitcoinActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressDialog pDialog;
    private RecyclerView.Adapter recyclerAdapter;
    private String URL = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,JPY,CHF,CAD,AUD,HKD,NGN,CNY,NZD,BRL,KRW,NOK,GBP,SEK,MXN,SGD,INR,ZAR,INS";
    String USD, EUR,JPY,CHF,CAD,AUD,HKD,NGN,CNY,NZD,BRL,KRW,NOK,GBP,SEK,MXN,SDG,INR,ZAR,INS;
    private List<CurrencyDetails> currencyDetails;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btc_activity);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        currencyDetails = new ArrayList<>();
        new LoadData().execute();
        recyclerView.addOnItemTouchListener(new RecyclerViewAdapterClickListener(this, recyclerView, new RecyclerViewAdapterClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CurrencyDetails cDetails = currencyDetails.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("currency", cDetails.getCurrency());
                bundle.putString("country", cDetails.getCountry());
                bundle.putString("countryCode", cDetails.getCountryCode());
                bundle.putString("BitIntent", "BITCOINS");

                Intent intent = new Intent();
                intent.setClass(BitcoinActivity.this, ConversionActivity.class);
                intent.putExtra("bit", bundle);
                intent.putExtra("bitcoins", "bitcoins");
                BitcoinActivity.this.startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }

        }));

    }
    private class LoadData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(BitcoinActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            HttpHandler sh = new HttpHandler();
            String json = sh.makeServiceCall(URL);

            if (json != null) {
                try {
                    JSONObject object = new JSONObject(json);

                    String btc = object.getString("BTC");
                    JSONObject c = new JSONObject(btc);
                    USD = c.getString("USD");
                    EUR = c.getString("EUR");
                    JPY = c.getString("JPY");
                    CHF = c.getString("CHF");
                    CAD = c.getString("CAD");
                    AUD = c.getString("AUD");
                    HKD = c.getString("HKD");
                    NGN = c.getString("NGN");
                    CNY = c.getString("CNY");
                    NZD = c.getString("NZD");
                    BRL = c.getString("BRL");
                    KRW = c.getString("KRW");
                    NOK = c.getString("NOK");
                    GBP = c.getString("GBP");
                    SEK = c.getString("SEK");
                    MXN = c.getString("MXN");
                    SDG = c.getString("SDG");
                    INR = c.getString("INR");
                    ZAR = c.getString("ZAR");
                    INS = c.getString("INS");

                    CurrencyDetails currency = new CurrencyDetails("USA", "USD", USD);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("EUR", "EUR", EUR);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("JPY", "JPY", JPY);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("CHF", "CHF", CHF);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("CAD", "CAD", CAD);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("AUD", "AUD", AUD);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("HKD", "HKD", HKD);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("NGN", "NGN", NGN);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("CNY", "CNY", CNY);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("NZD", "NZD", NZD);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("BRL", "BRL", BRL);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("KRW", "KRW", KRW);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("NOK", "NOK", NOK);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("GBP", "GBP", GBP);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("SEK", "SEK", SEK);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("MXN", "MXN", MXN);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("SDG", "SDG", SDG);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("INR", "INR", INR);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("ZAR", "ZAR", ZAR);
                    currencyDetails.add(currency);

                    currency = new CurrencyDetails("INS", "INS", INS);
                    currencyDetails.add(currency);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return  null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);

            if (pDialog.isShowing())
                pDialog.dismiss();
            
            recyclerAdapter = new RecyclerViewAdapter(currencyDetails, getApplicationContext());
            recyclerView.setAdapter(recyclerAdapter);
        }


    }
}
