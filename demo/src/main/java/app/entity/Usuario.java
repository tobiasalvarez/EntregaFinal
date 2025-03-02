package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)$", message = "Nome deve ter pelo menos duas palavras.")
	@NotBlank(message = "O nome e brigatorio")
	private String nome;
	
	@NotBlank(message = "O tipo de usuario e obrigatorio")
	private String tipoUser;
	
	

}
