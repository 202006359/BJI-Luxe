package edu.comillas.icai.pat.ejemplopat.Controller;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.BDDAssertions.then;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.service.MujerService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //se genera un servidor de prueba donde hare las llamadas, en un puerto aleatorio
public class MujeresStockControllerE2ETest {
    @LocalServerPort
    private int port; //pido el puerto en que esta el server

    @Autowired
    private MujerService mujerService;

    @Autowired
    private TestRestTemplate restTemplate; //te permite hacer llamadas al server de pruebas y recoge la respuesta


    @Test
    void getAllPrendas()
    {
        //Buena busqueda
        String mapping="/api/ropaMujer";

        List<Prenda> expected= mujerService.getPrendas();

        //WHEN
        String url="http://localhost:"+ Integer.toString(port)+mapping;
        HttpHeaders header= new HttpHeaders();
        //Añadiria header si tengo que meter cosas como Authorizaation
        HttpEntity<String> entity = new HttpEntity<>(header); //si tuviera body, (String body, header)


        //GIVEN
        ResponseEntity<List<Prenda>> resul= restTemplate.exchange(
            url, 
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<List<Prenda>>(){});

        //CHECK
        then(resul.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(resul.getBody()).isEqualTo(expected);

    }

}