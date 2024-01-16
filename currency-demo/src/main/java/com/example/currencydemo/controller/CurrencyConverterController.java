package com.example.currencydemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {
	
	
	@GetMapping(value = "/message")
	public ResponseEntity<String> getMessage(){
		
		return new ResponseEntity<String>("hello world", HttpStatus.ACCEPTED);
	}

}
