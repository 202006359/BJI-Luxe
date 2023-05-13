package edu.comillas.icai.pat.ejemplopat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("ACCESORIOS")
public class AccesorioModel{

    @Id
    @Column("ID")
    private int id;

    @Column("NOMBRE")
    private String nombre;

    @Column("DIR_IMAGE")
    private String dir_image;

    @Column("PRECIO")
    private float precio;






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir_image() {
        return dir_image;
    }

    public void setDir_image(String dir_image) {
        this.dir_image = dir_image;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccesorioModel other = (AccesorioModel) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return nombre + ", por tan solo " + precio + "€";
    }
    



}