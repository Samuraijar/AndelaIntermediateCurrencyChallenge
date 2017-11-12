package com.example.android.andelaintermediatecurrencychallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NORMAL on 11/12/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<CurrencyDetails> currencyDetails;
    private Context context;

    public RecyclerViewAdapter(List<CurrencyDetails> currencyDetails, Context context) {
        this.currencyDetails = currencyDetails;
        this.context = context;
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        CurrencyDetails cDetails = currencyDetails.get(position);
        holder.countryText.setText(cDetails.getCountry());
        holder.currencyText.setText(cDetails.getCurrency());
        holder.countryCodeText.setText(cDetails.getCountryCode());

    }

    @Override
    public int getItemCount() {
        return currencyDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView currencyText;
        public TextView countryText,countryCodeText;

        public ViewHolder(View itemView) {
            super(itemView);

            currencyText = (TextView) itemView.findViewById(R.id.currency_txt);
            countryText = (TextView) itemView.findViewById(R.id.country_txt);
            countryCodeText = (TextView) itemView.findViewById(R.id.currencyCode_txt);
        }

    }
}
