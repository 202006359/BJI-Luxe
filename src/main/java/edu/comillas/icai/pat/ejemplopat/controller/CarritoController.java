package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.icai.pat.ejemplopat.dao.Carrito;
import edu.comillas.icai.pat.ejemplopat.service.CarritoService;

@RestController
public class CarritoController
{
    @Autowired
    private CarritoService carritoService; 

    @PostMapping(path = "api/carrito")
    public ResponseEntity<Carrito> anadirCarrito(@RequestBody Carrito carrito)
    {
        Carrito newCarrito = carritoService.anadirCarrito(carrito); 
        return ResponseEntity.ok().body(newCarrito);
    }

    @GetMapping(path="api/getCarrito")
    public ResponseEntity<List<Carrito>> getAllCarrito()
    {
        return ResponseEntity.ok().body(carritoService.getAllCarrito()); 
    }
}
