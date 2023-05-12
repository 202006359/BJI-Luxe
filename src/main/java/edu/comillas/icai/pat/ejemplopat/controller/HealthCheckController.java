/*******************************************************************************
 * Copyright (c) 2023 Universidad de Comillas ICAI.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the company
 * which accompanies this distribution
 *
 * Contributors:
 *     Universidad de Comillas - ICAI
 *******************************************************************************/

package edu.comillas.icai.pat.ejemplopat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.icai.pat.ejemplopat.dto.Contact;
import edu.comillas.icai.pat.ejemplopat.service.MyService;


@RestController
@RequestMapping("/api")
public class HealthCheckController {

	@Autowired
	MyService myService;
	
	
	@GetMapping("/health")
	public ResponseEntity<Object> health(@RequestParam(required = false) String name) {
		
		if (name == null) {
			name ="Default User";
		}
		
		return new ResponseEntity<>(myService.getHealthCheck(name),HttpStatus.OK);
	}

	@PostMapping(path = "/contact", 
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> contact(@RequestBody Contact contact) {
				
		return new ResponseEntity<>(contact.toString(),HttpStatus.OK);
	}
}
