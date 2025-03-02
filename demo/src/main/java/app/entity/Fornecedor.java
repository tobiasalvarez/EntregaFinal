package app.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
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
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "O nome e obrigatorio")
	private String nome;
	@Email(message = "Email nao valido")
	private String email;
	@CNPJ
	@NotBlank(message = "CNPJ e obrigatorio")
	private String cnpj;
	
	private String cidade;
	
	@ManyToMany
	@JoinTable(name = "pecasFornecedor")
	@JsonIgnoreProperties("fornecedores")
	private List<Peca> pecas;
	
	private String statusCadastro;
	
}
