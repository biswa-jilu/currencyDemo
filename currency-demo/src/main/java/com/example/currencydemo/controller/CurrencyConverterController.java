package com.example.currencydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencydemo.model.CurrencyConversionDTO;
import com.example.currencydemo.model.ExchangeRateDTO;
import com.example.currencydemo.service.ExchageService;

@RestController

public class CurrencyConverterController {

	@Autowired
	ExchageService exchageService;
	String BASE_URL = "https://api.apilayer.com/exchangerates_data/latest"; 
	//?symbols=GBP%2CAFN%2CBAM&base=EUR"


	@GetMapping(value = "/exchange-rates")
	public ExchangeRateDTO getLatestRate(@RequestParam String base,@RequestParam String rates){
		//basic validation of base and rates..

		ExchangeRateDTO resposeDto = exchageService.getExchangeRatesResponse(rates, base);
		return resposeDto; // handle err respone if null , also we can do 
	}


	@GetMapping(value="/convert-rates")
	public CurrencyConversionDTO convertRate(@RequestParam String amount,@RequestParam String from,@RequestParam String to){

		CurrencyConversionDTO resposeDto = exchageService.getConvertedRateResponseDto(amount, from,to);
		return resposeDto;
	}


}
