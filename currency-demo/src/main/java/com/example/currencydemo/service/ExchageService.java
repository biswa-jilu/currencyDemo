package com.example.currencydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.currencydemo.gateway.ExchangeGateway;
import com.example.currencydemo.model.BaseDto;
import com.example.currencydemo.model.CurrencyConversionDTO;
import com.example.currencydemo.model.ExchangeRateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ExchageService {
	
	@Autowired
	ExchangeGateway gateway;

	
	/**
	 * 
	 * @param rates
	 * @param base
	 */
	public ExchangeRateDTO getExchangeRatesResponse(String rates, String base) {
		
		  ResponseEntity<String> response = gateway.getExchangeApiResponse(rates, base);
		  
		  // Convert the response body (JSON) to your DTO
		  if(response.getStatusCode().is2xxSuccessful()) {
			  ExchangeRateDTO exchangeRateDTO = convertJsonToDto(response.getBody(),ExchangeRateDTO.class);
			  return exchangeRateDTO; 
		  }
          
		return (ExchangeRateDTO) getDefaultErrDto();
	}
	


	/**
	 * 
	 * @param amount
	 * @param from
	 * @param to
	 * @return
	 */
	public CurrencyConversionDTO getConvertedRateResponseDto(String amount, String from, String to) {
		
		  ResponseEntity<String> response = gateway.getConvertedRateResponse(amount, from,to);
		  
		  // Convert the response body (JSON) to your DTO
		  if(response.getStatusCode().is2xxSuccessful()) {
			  CurrencyConversionDTO exchangeRateDTO = convertJsonToDto(response.getBody(),CurrencyConversionDTO.class);
			  return exchangeRateDTO; 
		  }
        
		  return (CurrencyConversionDTO) getDefaultErrDto();
	

	}
	
	
	
	/**
	 * 
	 * @param jsonResponse
	 * @return
	 */
	private <T> T convertJsonToDto(String jsonResponse, Class<T> targetType) {
	     
        // Use Jackson ObjectMapper to convert JSON to your DTO
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonResponse, targetType);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            e.printStackTrace();
            return null;
        }
    }
	
	/**
	 * 
	 * @return
	 */
	private BaseDto getDefaultErrDto() {
		// TODO Auto-generated method stub
		BaseDto errDto = new BaseDto();
		errDto.setErrrorCode("ERR_TECH");
		return errDto;
	}


}
