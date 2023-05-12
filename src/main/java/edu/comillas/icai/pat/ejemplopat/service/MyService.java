/*******************************************************************************
 * Copyright (c) 2023 Universidad de Comillas ICAI.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the company
 * which accompanies this distribution
 *
 * Contributors:
 *     Universidad de Comillas - ICAI
 *******************************************************************************/


package edu.comillas.icai.pat.ejemplopat.service;

import edu.comillas.icai.pat.ejemplopat.dto.Contact;

public interface MyService {

    String getHealthCheck(String name);
    Contact getDemoUser(Integer id);


}
