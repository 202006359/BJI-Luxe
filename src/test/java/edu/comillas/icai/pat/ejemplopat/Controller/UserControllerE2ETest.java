package edu.comillas.icai.pat.ejemplopat.Controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;


import edu.comillas.icai.pat.ejemplopat.service.UserService;
import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //se genera un servidor de prueba donde hare las llamadas, en un puerto aleatorio
public class UserControllerE2ETest {
    @LocalServerPort
    private int port; //pido el puerto en que esta el server

    @Autowired
    private UserService userService;

    @Autowired
    private TestRestTemplate restTemplate; //te permite hacer llamadas al server de pruebas y recoge la respuesta

    @Test
    void getUserIdByUserName()
    {
        //Buena busqueda
        String endpoint="/get_user_id/";
        String username = "user0"; 
        String mapping = endpoint + username;

        Long expected= userService.getUserByUsername(username).getUserId();

        //WHEN
        String url="http://localhost:"+ Integer.toString(port)+ mapping;
        HttpHeaders header= new HttpHeaders();
        //Añadiria header si tengo que meter cosas como Authorizaation
        HttpEntity<String> entity = new HttpEntity<>(header); //si tuviera body, (String body, header)


        //GIVEN
        ResponseEntity<Long> resul= restTemplate.exchange(
            url, 
            HttpMethod.GET,
            entity,
            Long.class);

        //CHECK
        then(resul.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(resul.getBody()).isEqualTo(expected);

    }

}
