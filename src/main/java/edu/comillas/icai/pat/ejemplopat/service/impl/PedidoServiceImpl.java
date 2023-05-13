package edu.comillas.icai.pat.ejemplopat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.Pedido;
import edu.comillas.icai.pat.ejemplopat.repository.PedidoRepository;
import edu.comillas.icai.pat.ejemplopat.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
    

    @Autowired
    private PedidoRepository pedidoRepository; 
    
    @Override
    public Pedido anadirCarrito(Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }


}
