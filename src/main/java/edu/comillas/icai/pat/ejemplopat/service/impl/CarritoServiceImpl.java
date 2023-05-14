package edu.comillas.icai.pat.ejemplopat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.Carrito;
import edu.comillas.icai.pat.ejemplopat.repository.CarritoRepository;
import edu.comillas.icai.pat.ejemplopat.service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService{
    

    @Autowired
    private CarritoRepository pedidoRepository; 
    
    @Override
    public Carrito anadirCarrito(Carrito pedido)
    {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Carrito> getAllCarrito(){
        return pedidoRepository.getAllCarrito();
    }


}
