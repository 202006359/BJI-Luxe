/*package edu.comillas.icai.pat.ejemplopat;
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
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.repository.MujerRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStockMujeres {

    @Autowired
    private MujerRepository mujerRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @LocalServerPort
    private int port;

    @Autowired  
    private JdbcTemplate jdbcTemplate; 

    @Test
    public void getPrendas() {
        String query = """
                SELECT MUJERES.ID, MUJERES.NOMBRE_P, MUJERES.URL, MUJERES.PRECIO FROM MUJERES
                    """;
                    
        List<Prenda> prenda = jdbcTemplate.query(
                query,
                (data, rowNum) -> {
                    return new Prenda(
                            data.getLong("MUJERES.ID"),
                            data.getString("MUJERES.NOMBRE_P"),
                            data.getString("MUJERES.URL"),
                            data.getFloat("MUJERES.PRECIO"));
                });

        String url = "http://localhost:8080/api/ropaMujer";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Prenda>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Prenda>>() {
                });

        //then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        //then(result.getBody()).isEqualTo(prenda);
    }


}
*/