package edu.comillas.icai.pat.ejemplopat.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.comillas.icai.pat.ejemplopat.dao.Carrito;

public interface CarritoService {

    @Transactional
    Carrito anadirCarrito(Carrito carrito);

    List<Carrito> getAllCarrito();
}
