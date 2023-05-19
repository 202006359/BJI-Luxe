package edu.comillas.icai.pat.ejemplopat.dao;

import java.sql.Blob;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;


@Table("PRUEBAS")
public class Prueba {
    @Id
	@Column("ID")
	private Long id;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("PHOTO")
	private byte[] photo;


    @Column("PRECIO")
	private Float precio;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Prueba(Long id, String nombre,byte[]photo, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.photo = photo;
        this.precio = precio;
    }

}
