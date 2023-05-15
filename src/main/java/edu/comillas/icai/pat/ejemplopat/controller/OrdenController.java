package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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

            ResponseEntity<List<Carrito>> response2 = restTemplate.exchange(url, HttpMethod.GET, entity_empty,new ParameterizedTypeReference<List<Carrito>>(){});
            List<Carrito> carrito_all = response2.getBody();
            HashMap<Long, Integer> orden_items = new HashMap<>();   //long para el id, int para la cantidad de ese objeto
            for(Carrito c: carrito_all){
            if (orden_items.get(c.getId())==null)  //aun no existe dentro
                    orden_items.put(c.getId(),1);

            else //ya esta dentro
                orden_items.put(c.getId(), orden_items.get(c.getId())+1);
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
