package edu.comillas.icai.pat.ejemplopat.repository;

import java.util.ArrayList;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.comillas.icai.pat.ejemplopat.model.AccesorioModel;

public interface AccesorioRepository extends CrudRepository<Integer, AccesorioModel>
{

    @Query
    ("SELECT * FROM ACCESORIOS")
    public ArrayList<AccesorioModel> getAll();


    @Query
    ("SELECT * FROM ACCESORIOS WHERE ID= :searched_id")
    public AccesorioModel getById(@Param ("searched_id") int id);

    @Modifying
    @Query
    ("INSERT INTO ACCESORIOS (ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(:id, :nombre, :dir_image, :precio)")
    public void createAccesorio(
        @Param("id") int id,
        @Param("nombre") String nombre,
        @Param("dir_image") String dir_image,
        @Param("Precio") float precio
    );


    @Modifying
    @Query
    ("UPDATE ACCESORIOS SET PRECIO=:precio WHERE ID=:id")
    public void updatePrecio(
        @Param("precio") float precio,
        @Param("id") int id
    );


}