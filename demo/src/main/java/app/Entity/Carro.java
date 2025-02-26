package app.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "O modelo e obrigatorio")
	private String modelo;
	
	private int ano;
	
	@ManyToOne
	@JoinTable(name = "marca_id")
	@JsonIgnoreProperties("carros")
	private Marca marca;
	
	@ManyToMany
	@JoinTable(name = "pecas_id")
	@JsonIgnoreProperties("carros")
	private List<Peca> pecas;
	

}
