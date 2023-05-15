package edu.comillas.icai.pat.ejemplopat.repository;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.comillas.icai.pat.ejemplopat.dao.Prenda;

public interface MujerRepository extends CrudRepository<Prenda,Long>
{
    @Query("SELECT  * FROM MUJERES")
    List<Prenda> getPrendas();

    @Query("SELECT  * FROM HOMBRES")
    List<Prenda> getPrendasHombres();

    @Query
    ("SELECT * FROM MUJERES WHERE ID= :searched_id")
    public Prenda getById(@Param ("searched_id") Long id);
}
