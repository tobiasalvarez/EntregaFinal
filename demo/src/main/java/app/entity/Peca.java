package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
	@NotBlank(message = "O nome e obrigatorio!")
	private String nome;
	
	
	@ManyToMany(mappedBy = "pecas")
	@JsonIgnoreProperties("pecas")
	private List<Carro> carros;
	
	@ManyToMany(mappedBy = "pecas")
	@NotEmpty(message = "O Fornecedor obligatorio")
	@JsonIgnoreProperties("pecas")
	private List<Fornecedor> fornecedores;
}
