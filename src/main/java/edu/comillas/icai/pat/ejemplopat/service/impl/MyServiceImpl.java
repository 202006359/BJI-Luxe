/*******************************************************************************
 * Copyright (c) 2023 Universidad de Comillas ICAI.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the company
 * which accompanies this distribution
 *
 * Contributors:
 *     Universidad de Comillas - ICAI
 *******************************************************************************/


package edu.comillas.icai.pat.ejemplopat.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.service.MyService;
import edu.comillas.icai.pat.ejemplopat.dto.Contact;
import edu.comillas.icai.pat.ejemplopat.repository.DemoRepository;
import edu.comillas.icai.pat.ejemplopat.dao.Demo;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	DemoRepository demoRepository;

	@Override
	public String getHealthCheck(String name) {
		
		String responseHealthCheck="Servicio OK! - "+name;
		return responseHealthCheck;
	}

	@Override
	public Contact getDemoUser(Integer id) {
		
		Optional<Demo> data=demoRepository.findById(id);
		Contact contact;

		if (data.isPresent())
			contact = new Contact(data.get().getName(), data.get().getSurmame(),data.get().getEmail());	
		else
			contact= new Contact("","","");
		

		return contact;
	}




	
}
