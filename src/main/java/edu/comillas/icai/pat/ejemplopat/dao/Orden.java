package edu.comillas.icai.pat.ejemplopat.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("PEDIDOS")
@Data
public class Orden 
{
    @Id
	@Column("ID")
	private Long id;

    @Column("ID_USER")
	private Long id_user;

    @Column("ID_PROD")
	private Long id_producto;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("CANTIDAD")
	private Integer cantidad;

	public Orden(Long id_user, Long id_producto, String nombre, Integer cantidad) {
		this.id_user = id_user;
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

    
}
