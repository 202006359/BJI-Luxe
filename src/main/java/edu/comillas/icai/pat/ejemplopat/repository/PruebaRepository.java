package edu.comillas.icai.pat.ejemplopat.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.comillas.icai.pat.ejemplopat.dao.Prueba;


public interface PruebaRepository extends CrudRepository<Prueba,Long>
{
    
    @Query("SELECT  * FROM PRUEBAS")
    List<Prueba> getPrendasHombres();

    @Query
    ("SELECT * FROM PRUEBAS WHERE ID= :searched_id")
    public Prueba getPrendaHombreById(@Param ("searched_id") Long id);

    
}