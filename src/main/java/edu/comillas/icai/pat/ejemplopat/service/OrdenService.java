package edu.comillas.icai.pat.ejemplopat.service;

import java.util.ArrayList;

import edu.comillas.icai.pat.ejemplopat.dao.Orden;

public interface OrdenService 
{
    void insertOrden(Orden pedidos);
    Orden anadirPedido(Orden pedido);
    void deletePedido();
    ArrayList<Orden> getByUserId(long id);

}
