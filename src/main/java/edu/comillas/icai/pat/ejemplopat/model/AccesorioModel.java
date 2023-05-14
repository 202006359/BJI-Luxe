package edu.comillas.icai.pat.ejemplopat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ACCESORIOS")
public class AccesorioModel{

    @Id
    @Column("ID")
    private Long id;

    @Column("NOMBRE")
    private String nombre;

    @Column("DIR_IMAGE")
    private String dir_image;

    @Column("PRECIO")
    private float precio;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nombre=" + nombre + ", dir_image=" + dir_image + ", precio=" + precio
                + "]";
    }

    public String toJson() {
        String json = "{";
        json += "\"id\":" + id + ",";
        json += "\"nombre\":\"" + nombre + "\",";
        json += "\"dir_image\":\"" + dir_image + "\",";
        json += "\"precio\":" + precio;
        json += "}";
        return json;
    }




}