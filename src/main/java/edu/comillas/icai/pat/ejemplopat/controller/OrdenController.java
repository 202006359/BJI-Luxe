package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.comillas.icai.pat.ejemplopat.dao.Carrito;
import edu.comillas.icai.pat.ejemplopat.dao.Orden;
import edu.comillas.icai.pat.ejemplopat.service.CarritoService;
import edu.comillas.icai.pat.ejemplopat.service.OrdenService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    @Autowired
    CarritoService carritoService;


    @PutMapping("api/add/pedido")
    public ResponseEntity<String> addPedido(@RequestBody String body) //el body es solo el usuario, el carrito lo pido por aqui
    {
        RestTemplate restTemplate = new RestTemplate();
        String usuariosUrl = "http://localhost:8080/verify_user";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        ResponseEntity<Boolean> response;
        try{
            response = restTemplate.exchange(usuariosUrl, HttpMethod.PUT, entity, Boolean.class);
        }catch(Exception e){
            return new ResponseEntity<String>("Las credenciales no son correctas",HttpStatus.BAD_REQUEST);
        }
        boolean usuarioCorrecto = response.getBody();
        if(usuarioCorrecto)
        {
            String pattern = "username=([^&]+)";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(body);

            String username = null;
            if (matcher.find()) {
                username = matcher.group(1);
            }else{
                return new ResponseEntity<String>("Error, credenciales del usuario erroneas",HttpStatus.BAD_REQUEST);
            }
            
            String usuarioUrl = "http://localhost:8080/get_user_id/" + username;
            HttpEntity<String> entity_empty = new HttpEntity<String>(headers);
            ResponseEntity<Long> responseUser = restTemplate.exchange(usuarioUrl, HttpMethod.GET, entity_empty, Long.class);

            Long id_user = responseUser.getBody();


            List<Carrito> carrito_all = carritoService.getAllCarrito();
            HashMap<Long, Integer> carritoQuantities = new HashMap<>();
            HashSet<Long> processedIds = new HashSet<>();


            // Calculate the quantity for each Carrito item
            for (Carrito carrito : carrito_all) {
                Long id_prod = carrito.getId_producto();
                int currentQuantity = carritoQuantities.getOrDefault(id_prod, 0);
                carritoQuantities.put(id_prod, currentQuantity + 1);
            }

            // Create an Order for each Carrito item
            for (Carrito carrito : carrito_all) {
                Long id_prod = carrito.getId_producto();
                String nombre = carrito.getNombre();
                Float precio = carrito.getPrecio();
                      
                int quantity = carritoQuantities.get(id_prod);

                if (!processedIds.contains(id_prod)){
                    // Create an Order object
                    Orden orden = new Orden(id_user,id_prod, nombre, quantity, precio*quantity);

                    // Save the Order using the pedidosService
                    pedidosService.insertOrden(orden);

                    processedIds.add(id_prod);
                }
            }

            
            return new ResponseEntity<String>("Pedido realizado con exito",HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<String>("Error, credenciales del usuario erroneas",HttpStatus.BAD_REQUEST);
        }
    }
 


    @PostMapping("pedido")
    public ResponseEntity<ArrayList<Orden>> getPedido(@RequestBody String body) //el body es solo el usuario, el carrito lo pido por aqui
    {
        RestTemplate restTemplate = new RestTemplate();
        String usuariosUrl = "http://localhost:8080/verify_user";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        ResponseEntity<Boolean> response;
        try{
            response = restTemplate.exchange(usuariosUrl, HttpMethod.PUT, entity, Boolean.class);
        }catch(Exception e){
            return new ResponseEntity<ArrayList<Orden>>(HttpStatus.BAD_REQUEST);
        }
        boolean usuarioCorrecto = response.getBody();
        if(usuarioCorrecto)
        {
            String pattern = "username=([^&]+)";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(body);

            String username = null;
            if (matcher.find()) {
                username = matcher.group(1);
            }else{
                return new ResponseEntity<ArrayList<Orden>>(HttpStatus.BAD_REQUEST);
            }
            
            String usuarioUrl = "http://localhost:8080/get_user_id/" + username;
            HttpEntity<String> entity_empty = new HttpEntity<String>(headers);
            ResponseEntity<Long> responseUser = restTemplate.exchange(usuarioUrl, HttpMethod.GET, entity_empty, Long.class);

            Long id_user = responseUser.getBody();

            ArrayList<Orden> orden_all= pedidosService.getByUserId(id_user);

            return new ResponseEntity<ArrayList<Orden>>(orden_all,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ArrayList<Orden>>(HttpStatus.BAD_REQUEST);
        }
    }
     
}
