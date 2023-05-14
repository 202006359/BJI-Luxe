package edu.comillas.icai.pat.ejemplopat.service;

import edu.comillas.icai.pat.ejemplopat.dao.Orden;

public interface OrdenService 
{
    Orden anadirPedido(Orden pedido);
    void deletePedido();

}
