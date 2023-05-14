package edu.comillas.icai.pat.ejemplopat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.comillas.icai.pat.ejemplopat.dao.Orden;
import edu.comillas.icai.pat.ejemplopat.service.OrdenService;

@RestController
public class OrdenController {

    @Autowired
    private OrdenService pedidosService;

    @PostMapping(path = "api/pedido")
    public ResponseEntity<Orden> anadirPedido(@RequestBody Orden pedidos)
    {
        return ResponseEntity.ok().body(pedidosService.anadirPedido(pedidos));
    }

    @DeleteMapping("api/delete/pedido")
    public void eliminartodo() {
        pedidosService.deletePedido();
    }





    
}
