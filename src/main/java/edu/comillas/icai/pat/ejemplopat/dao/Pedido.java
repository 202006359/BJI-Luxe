package edu.comillas.icai.pat.ejemplopat.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Table("CARRITO")
@Data
public class Pedido 
{
    @Id
	@Column("ID")
	private Long id;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("PRECIO")
	private Integer precio;
}
