package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.icai.pat.ejemplopat.dao.Pedido;
import edu.comillas.icai.pat.ejemplopat.service.PedidoService;
//import edu.comillas.icai.pat.ejemplopat.dao;

@RestController
public class PedidoController
{
    @Autowired
    private PedidoService pedidoService; 

    @PostMapping(path = "api/carrito")
    public ResponseEntity<Pedido> anadirCarrito(@RequestBody Pedido pedido)
    {
        Pedido newPedido = pedidoService.anadirCarrito(pedido); 
        return ResponseEntity.ok().body(newPedido);
    }

    @GetMapping(path="api/getCarrito")
    public ResponseEntity<List<Pedido>> getAllCarrito()
    {
        return ResponseEntity.ok().body(pedidoService.getAllCarrito()); 
    }





    
}
