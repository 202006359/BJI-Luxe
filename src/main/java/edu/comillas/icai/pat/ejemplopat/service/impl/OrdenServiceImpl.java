package edu.comillas.icai.pat.ejemplopat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.Orden;
import edu.comillas.icai.pat.ejemplopat.repository.OrdenRepository;
import edu.comillas.icai.pat.ejemplopat.service.OrdenService;


@Service
public class OrdenServiceImpl implements OrdenService {

    
    @Autowired
    private OrdenRepository pedidosRepository; 
    
    @Override
    public Orden anadirPedido(Orden pedidos)
    {
        return pedidosRepository.save(pedidos);
    }
    
}
