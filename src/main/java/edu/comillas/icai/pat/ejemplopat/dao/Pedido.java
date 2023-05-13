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

    @Column("ID_PROD")
	private Long id_producto;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("PRECIO")
	private Integer precio;

    public Pedido(Long id_producto, String nombre, Integer precio) {
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

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}
