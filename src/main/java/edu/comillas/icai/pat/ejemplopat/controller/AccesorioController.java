package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.icai.pat.ejemplopat.dao.AccesorioModel;
import edu.comillas.icai.pat.ejemplopat.service.AccesorioService;

@RestController
public class AccesorioController {

    @Autowired
    private AccesorioService accesorio_service;

    @GetMapping("/accesorios")
    public ResponseEntity<ArrayList<AccesorioModel>> getAllAccesorios()
    {
        //Si respondemos como un objeto, al hacer el json podremos acceder a sus propiedades sin tener que parsear manualmente
        //No hace falta metodo toJson
        return new ResponseEntity<ArrayList<AccesorioModel>>( accesorio_service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/accesorio/{id}")
    public ResponseEntity<AccesorioModel> getAccesorioById(@PathVariable Long id)
    {
        if (id<300 || id>400)
        {
            return new ResponseEntity<AccesorioModel>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<AccesorioModel>(accesorio_service.getById(id), HttpStatus.OK);
        }
    }

    
}
