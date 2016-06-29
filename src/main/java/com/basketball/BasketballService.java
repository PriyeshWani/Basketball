package com.basketball;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.undertow.attribute.RequestMethodAttribute;

@RestController
public class BasketballService {
	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public ResponseEntity<String> score(@RequestParam("yards") String yards) {
		int yards_int = Integer.parseInt(yards);
		Random rand = new Random();
		int no = rand.nextInt(10);
		String response = "";
		if(no == yards_int) {
			response = "Basket!!!!!! You scored";
			System.out.println("Basket!!!!!! You scored");
		}
		else {
			response = "You missed it by"+Math.abs(yards_int - no)+" yards";
			System.out.println("You missed it by"+Math.abs(yards_int - no)+" yards");
		}
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
