package edu.comillas.icai.pat.ejemplopat.dao;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Table("MUJERES")
@Data
public class Prenda 
{
    @Id
	@Column("ID")
	private Long id;

	@Column("NOMBRE_P")
	private String nombre;

    @Column("URL")
	private String url;

    @Column("PRECIO")
	private Float precio;

	public Prenda(Long id, String nombre,String url, Float precio) {
        this.id= id;
		this.nombre = nombre;
		this.url=url;
		this.precio = precio;

	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prenda other = (Prenda) obj;
        if (id== null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
