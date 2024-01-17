package com.example.currencydemo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ExchangeRateDTO extends BaseDto{

    private String base;

    private String date;

    private Map<String, Double> rates;

    private boolean success;

    private long timestamp;

    // Constructors, getters, and setters

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
