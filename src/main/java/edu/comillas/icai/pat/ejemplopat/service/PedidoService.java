package edu.comillas.icai.pat.ejemplopat.service;

import java.util.List;

import edu.comillas.icai.pat.ejemplopat.dao.Pedido;

public interface PedidoService {

    Pedido anadirCarrito(Pedido pedido);
    List<Pedido> getAllCarrito();
}
