package app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Carro {
	
	private long id;
	
	private String modelo;
	
	private int ano;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	

}
