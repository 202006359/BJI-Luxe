package edu.comillas.icai.pat.ejemplopat.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import edu.comillas.icai.pat.ejemplopat.controller.OrdenController;
import edu.comillas.icai.pat.ejemplopat.dao.Carrito;
import edu.comillas.icai.pat.ejemplopat.dao.Orden;
import edu.comillas.icai.pat.ejemplopat.service.CarritoService;
import edu.comillas.icai.pat.ejemplopat.service.OrdenService;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;


@SpringBootTest
@AutoConfigureMockMvc
public class OrdenControllerE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarritoService carritoService;

    @MockBean
    private OrdenService ordenService;

    @MockBean
    private TestRestTemplate restTemplate;

    @Test
    public void testAddPedido() throws Exception {
        // Mock carritoService.getAllCarrito()
        List<Carrito> carritoList = new ArrayList<>();
        Carrito carrito1 = new Carrito(1L, "Product1", 10.0f);
        Carrito carrito2 = new Carrito(2L, "Product2", 15.0f);
        carritoList.add(carrito1);
        carritoList.add(carrito2);
        when(carritoService.getAllCarrito()).thenReturn(carritoList);

        // Mock verify_user endpoint response
        String body = "username=user0&password=user0&password_repeat=user0";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        when(restTemplate.exchange("http://localhost:8080/verify_user", HttpMethod.PUT, entity, Boolean.class))
            .thenReturn(ResponseEntity.ok(true));

        // Mock get_user_id endpoint response
        HttpEntity<String> entity_empty = new HttpEntity<String>(body, headers);
        String username = "user0";
        when(restTemplate.exchange("http://localhost:8080/get_user_id/" + username, HttpMethod.GET, entity_empty, Long.class))
            .thenReturn(ResponseEntity.ok(402L));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/add/pedido")
                .contentType(MediaType.APPLICATION_JSON)
                .content("username=user0&password=user0&password_repeat=user0"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Pedido realizado con exito"));

        // Verify the pedidosService.insertOrden() method is called with the expected Orden objects
        verify(ordenService, times(1)).insertOrden(new Orden(402L, 1L, "Product1", 1,10.0f));
        verify(ordenService, times(1)).insertOrden(new Orden(402L, 2L, "Product2", 1,15.0f));
    }

    @Test
    public void testGetPedido() {
        // Mock input body
        String body = "username=user0";

        // Mock verify_user endpoint response
        String usuariosUrl = "http://localhost:8080/verify_user";
        when(restTemplate.exchange(usuariosUrl, HttpMethod.PUT, new HttpEntity<>(body), Boolean.class))
                .thenReturn(ResponseEntity.ok(true));

        // Mock get_user_id endpoint response
        String username = "user0";
        String usuarioUrl = "http://localhost:8080/get_user_id/" + username;
        when(restTemplate.exchange(usuarioUrl, HttpMethod.GET, new HttpEntity<>(null), Long.class))
                .thenReturn(ResponseEntity.ok(402L));

        // Mock pedidosService.getByUserId(id_user) response
        ArrayList<Orden> mockOrdenList = new ArrayList<>();
        mockOrdenList.add(new Orden(402L, 1L, "Product1", 1, 10.0f));
        mockOrdenList.add(new Orden(402L, 2L, "Product2", 1, 15.0f));
        when(ordenService.getByUserId(402L)).thenReturn(mockOrdenList);

        // Call the method under test
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/pedido")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id_user").value(402L))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].product").value("Product1"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(10.0f))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].id_user").value(402L))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].product").value("Product2"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(15.0f));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Assert the response
        verify(ordenService, times(1)).getByUserId(402L);
    }
}
