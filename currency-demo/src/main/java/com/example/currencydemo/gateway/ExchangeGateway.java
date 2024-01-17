package com.example.currencydemo.gateway;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ExchangeGateway {

	public static final String BASE_URL_LATEST = "https://api.apilayer.com/exchangerates_data/latest"; // can be dervied as per config server 
	public static final String BASE_URL_CONVERT = "https://api.apilayer.com/exchangerates_data/convert"; 
	public static final  String API_KEY = "nTeXDQumqerSTLZbbok1EvW7AzNtAalE";
	
	 @Autowired
	    private RestTemplate restTemplate;
	
	public ResponseEntity<String> getExchangeApiResponse(String rates, String base) {

		URI targetUrl= UriComponentsBuilder.fromUriString(BASE_URL_LATEST)
				
			    .queryParam("symbols", rates)
			     .queryParam("base", base)
			     .queryParam("apikey", API_KEY)
			    .build()                                                 
			    .encode()                                                
			    .toUri(); 
          ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.GET, null, String.class);
          
       // Check if the request was successful (HTTP status code 2xx)
          if (response.getStatusCode().is2xxSuccessful()) {
        	  return response;
          }
          else
          {
        	  //logs
        	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);// can be handled more betterway based on diff type of response
          }
		
	}

	/**
	 * 
	 * @param amount
	 * @param from
	 * @param to
	 * @return
	 */
	public ResponseEntity<String> getConvertedRateResponse(String amount, String from, String to) {

		URI targetUrl= UriComponentsBuilder.fromUriString(BASE_URL_CONVERT)
				
			    .queryParam("amount", amount)
			     .queryParam("from", from)
			     .queryParam("to", to)
			     .queryParam("apikey", API_KEY)
			    .build()                                                 
			    .encode()                                                
			    .toUri(); 
          ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.GET, null, String.class);
          
       // Check if the request was successful (HTTP status code 2xx)
          if (response.getStatusCode().is2xxSuccessful()) {
        	  return response;
          }
          else
          {
        	  //logs
        	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);// can be handled more betterway based on diff type of response
          }
		
	}
}
