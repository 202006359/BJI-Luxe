/*package edu.comillas.icai.pat.ejemplopat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import edu.comillas.icai.pat.ejemplopat.controller.PedidoController;
import edu.comillas.icai.pat.ejemplopat.dao.Pedido;
import edu.comillas.icai.pat.ejemplopat.service.PedidoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TestPedido 
{
    public static String asJsonString(Object object) {
    try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private PedidoService pedidoService;

    @MockBean
    private MockMvc mockMvc; 
    
    Pedido pedido = new Pedido(Long.valueOf(100), "VESTIDO ROJO", 50.0f);
    List<Pedido> pedidos; 


    @BeforeEach
    public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(new PedidoController()).build();
    }

    @Test
    public void add_shouldAdd() throws Exception {
        given(pedidoService.anadirCarrito(pedido)).willReturn(pedido);

        mockMvc.perform(post("http://localhost:8080/api/carrito")
                .contentType("application/json")
                .content("{\"id_producto\":\"101\",\"nombre\":\"VESTIDO ROJO\",\"precio\":\"50.0f\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAnadirCarrito() throws Exception {
        Pedido pedido = new Pedido(Long.valueOf(100), "VESTIDO ROJO", 50.0f);
       
        // Realiza la solicitud POST con el objeto Pedido en el cuerpo
        mockMvc.perform(post("http://localhost:8080/api/carrito")
                .contentType("application/json")
                .content(asJsonString(pedido)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_producto").value(Long.valueOf(100)))
                .andExpect(jsonPath("$.nombre").value("VESTIDO ROJO"))
                .andExpect(jsonPath("$.precio").value(50.0f));
    }


    @Test
    public void getUserInfoPedido_shouldReturnInfoPedido() throws Exception {
        given(pedidoService.getAllCarrito()).willReturn(pedidos);

        mockMvc.perform(get("http://localhost:8080/api/getCarrito"))
                .andExpect(status().isOk());
    }




    
}
*/