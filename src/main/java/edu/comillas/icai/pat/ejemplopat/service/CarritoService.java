package edu.comillas.icai.pat.ejemplopat.service;

import java.util.List;

import edu.comillas.icai.pat.ejemplopat.dao.Carrito;

public interface CarritoService {

    Carrito anadirCarrito(Carrito carrito);
    List<Carrito> getAllCarrito();
}
