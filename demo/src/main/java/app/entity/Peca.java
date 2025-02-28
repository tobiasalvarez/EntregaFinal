package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "pecas")
	@JsonIgnoreProperties("pecas")
	private List<Carro> Carros;
	
	@ManyToMany(mappedBy = "pecas")
	@NotNull(message = "O Fornecedor obligatorio")
	@JsonIgnoreProperties("pecas")
	private List<Fornecedor> fornecedores;
}
