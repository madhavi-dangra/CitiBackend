package com.citi.trade.controller;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.trade.TradeRecommendationApplicatiom;
import com.citi.trade.model.User;
import com.citi.trade.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	UserService service;
	private static final Logger logger = (Logger) LogManager.getLogger(TradeRecommendationApplicatiom.class);
	
	
	@PostMapping("/login")
	public boolean UserLogin(@RequestBody User userObject ) {
		
		logger.info("Validating login for User ",userObject.getUserId());
		return service.checkLogin(userObject);
		
		
	}

}
