package edu.comillas.icai.pat.ejemplopat.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import edu.comillas.icai.pat.ejemplopat.dao.Orden;

public interface OrdenService 
{
   @Transactional
    void insertOrden(Orden pedidos);

    @Transactional
    Orden anadirPedido(Orden pedido);

    void deletePedido();
    ArrayList<Orden> getByUserId(long id);

}
