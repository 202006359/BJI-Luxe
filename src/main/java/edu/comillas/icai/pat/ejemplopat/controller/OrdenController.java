package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.comillas.icai.pat.ejemplopat.dao.Carrito;
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




/*
    @PostMapping("api/add/pedido")
    public ResponseEntity<String> addPedido(@RequestBody String body) //el body es solo el usuario, el carrito lo pido por aqui
    {
        RestTemplate restTemplate = new RestTemplate();
        String usuariosUrl = "http://localhost:8080/verify_user";
        //String body_html="username="+username+"&password="+password+"&password_repeat="+password_repeat;
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(usuariosUrl, HttpMethod.PUT, entity, Boolean.class);

        boolean usuarioCorrecto = response.getBody();
        if(usuarioCorrecto)
        {
            String url="api/getCarrito";
            HttpEntity<String> entity_empty = new HttpEntity<String>(headers);

            ResponseEntity<List<Carrito>> response2 = restTemplate.exchange(url, HttpMethod.GET, entity_empty, ResponseEntity<List<Carrito>>);
            List<Carrito> carrito_all = response2.getBody();
            for(Carrito c : carrito_all)
            {
                //aqui chequeamos los repes para meterlo en el pedido
            }
            //finalmente guardamos el pedido llamando a su service y tal
            return new ResponseEntity<String>("Pedido realizado con exito",HttpStatus.CREATED);


        }
        else{
            return new ResponseEntity<String>("Error, credenciales del usuario erroneas",HttpStatus.BAD_REQUEST);
        }
    }
*/

    
}
