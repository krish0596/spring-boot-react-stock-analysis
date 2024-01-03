package com.stock_Analysis.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock_Analysis.demo.StockRestService.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockRestController {
    private final StockService stockService;

    @Autowired
    public StockRestController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}/price")
    public ResponseEntity<Double> getStockPrice(@PathVariable String symbol) {
        double price = stockService.getCurrentStockPrice(symbol);
        return ResponseEntity.ok(price);
    }
}
