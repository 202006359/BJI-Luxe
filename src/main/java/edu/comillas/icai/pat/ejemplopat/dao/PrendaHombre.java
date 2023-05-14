package edu.comillas.icai.pat.ejemplopat.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "HOMBRE")
public class PrendaHombre {
    @Id
	@Column("ID")
	private Long id;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("URL")
	private String url;

    @Column("PRECIO")
	private Float precio;

    public PrendaHombre(Long id, String nombre,String url, Float precio) {
        this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.precio = precio;

	}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public Float getPrecio() {
        return precio;
    }

}
