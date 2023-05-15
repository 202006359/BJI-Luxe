package edu.comillas.icai.pat.ejemplopat.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.BDDAssertions.then;
import edu.comillas.icai.pat.ejemplopat.dao.Carrito;
import edu.comillas.icai.pat.ejemplopat.service.CarritoService;

///esto es un test 'RestTemplate'
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //se genera un servidor de prueba donde hare las llamadas, en un puerto aleatorio
public class CarritoControllerE2ETest {

    @LocalServerPort
    private int port; //pido el puerto en que esta el server

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private TestRestTemplate restTemplate; //te permite hacer llamadas al server de pruebas y recoge la respuesta


    @Test
    void createfilaCarrito()
    {
        //Buena busqueda

        Carrito newCarrito = new Carrito(101L, "Vestido Negro", 50f);
        String mapping="/api/carrito";

        Carrito expected = carritoService.anadirCarrito(newCarrito);

        //WHEN
        String url="http://localhost:"+ Integer.toString(port)+mapping;
        HttpHeaders header= new HttpHeaders();
        //Añadiria header si tengo que meter cosas como Authorizaation
        HttpEntity<Carrito> requestEntity = new HttpEntity<>(newCarrito, header);

        //GIVEN
        ResponseEntity<Carrito> resul= restTemplate.exchange(
            url,
            HttpMethod.POST,
            requestEntity,
            Carrito.class
            );

        //CHECK
        then(resul.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(resul.getBody()).isEqualTo(expected);
    }

}