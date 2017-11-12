package com.example.android.andelaintermediatecurrencychallenge;

/**
 * Created by NORMAL on 11/12/2017.
 */

public class CurrencyDetails {
    private String Country, Currency, countryCode;

    public CurrencyDetails(String country, String countryCode,String currency) {
        Country = country;
        Currency = currency;
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return Country;
    }

    public String getCurrency() {
        return Currency;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
