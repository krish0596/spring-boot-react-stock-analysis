package com.stock_Analysis.demo.StockRestService;

import com.stock_Analysis.demo.model.IexStockQuoteResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Value("${iexcloud.token}")
    private String iexCloudToken;

    public double getCurrentStockPrice(String symbol) {
        String url = "https://cloud.iexapis.com/stable/stock/{symbol}/quote?token=" + iexCloudToken;

        RestTemplate restTemplate = new RestTemplate();
        IexStockQuoteResponse response = restTemplate.getForObject(url, IexStockQuoteResponse.class, symbol);

        if (response != null) {
            return response.getLatestPrice();
        } else {
            return 0.0; // Return 0 if symbol not found or no response
        }
    }
}
