package com.stock_Analysis.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IexStockQuoteResponse {

    private double latestPrice;
    private int iexVolume;

    public double getLatestPrice() {
        return latestPrice;
    }
    public int getIexVolume(){
        return iexVolume;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
        this.iexVolume=iexVolume;
    }
}

