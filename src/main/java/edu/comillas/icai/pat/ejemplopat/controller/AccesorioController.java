package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.icai.pat.ejemplopat.model.AccesorioModel;
import edu.comillas.icai.pat.ejemplopat.service.impl.AccesorioServiceImpl;

@RestController
public class AccesorioController {

    @Autowired
    private AccesorioServiceImpl accesorio_service;

    @GetMapping("/accesorios")
    public ResponseEntity<ArrayList<AccesorioModel>> cargarPagina()
    {
        //Si respondemos como un objeto, al hacer el json podremos acceder a sus propiedades sin tener que parsear manualmente
        //No hace falta metodo toJson
        return new ResponseEntity<ArrayList<AccesorioModel>>( accesorio_service.getAll(), HttpStatus.OK);
    }

    
}
