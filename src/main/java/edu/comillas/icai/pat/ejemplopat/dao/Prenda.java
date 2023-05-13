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
	private Integer precio;
    
}
