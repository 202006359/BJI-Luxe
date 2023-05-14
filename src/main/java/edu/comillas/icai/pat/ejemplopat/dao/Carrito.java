package edu.comillas.icai.pat.ejemplopat.dao;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Table("CARRITO")
@Data
public class Carrito 
{
    @Id
	@Column("ID")
	private Long id;

    @Column("ID_PROD")
	private Long id_producto;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("PRECIO")
	private Float precio;

    public Carrito(Long id_producto, String nombre, Float precio) {
        this.id_producto= id_producto;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Long getId_prod() {
		return id;
	}

	public void setId_prod(Long id) {
		this.id = id;
	}

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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

}
