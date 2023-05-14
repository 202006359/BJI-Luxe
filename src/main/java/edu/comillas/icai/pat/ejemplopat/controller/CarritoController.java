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
//import edu.comillas.icai.pat.ejemplopat.dao;

@RestController
public class CarritoController
{
    @Autowired
    private CarritoService pedidoService; 

    @PostMapping(path = "api/carrito")
    public ResponseEntity<Carrito> anadirCarrito(@RequestBody Carrito pedido)
    {
        Carrito newPedido = pedidoService.anadirCarrito(pedido); 
        return ResponseEntity.ok().body(newPedido);
    }

    @GetMapping(path="api/getCarrito")
    public ResponseEntity<List<Carrito>> getAllCarrito()
    {
        return ResponseEntity.ok().body(pedidoService.getAllCarrito()); 
    }





    
}
