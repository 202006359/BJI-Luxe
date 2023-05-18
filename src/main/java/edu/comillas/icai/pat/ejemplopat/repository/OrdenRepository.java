package edu.comillas.icai.pat.ejemplopat.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.comillas.icai.pat.ejemplopat.dao.Orden;

public interface OrdenRepository extends CrudRepository<Orden,Long>{

    @Modifying
    @Query("INSERT INTO PEDIDOS (ID_USER, ID_PROD, NOMBRE_P, CANTIDAD) " + 
    "VALUES (:id_user, :id_prod, :nombre, :cantidad)" )
    public void insertOrden(
        @Param("id_user") Long id_user,
        @Param("id_prod") Long id_prod,
        @Param("nombre") String nombre,
        @Param("cantidad") Integer cantidad);


}
