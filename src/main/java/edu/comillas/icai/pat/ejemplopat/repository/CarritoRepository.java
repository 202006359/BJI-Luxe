package edu.comillas.icai.pat.ejemplopat.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import edu.comillas.icai.pat.ejemplopat.dao.Carrito;

public interface CarritoRepository extends CrudRepository <Carrito, Long>
{
    @Query("SELECT * FROM CARRITO")
    List<Carrito> getAllCarrito();
}



