package app.Entity;

import jakarta.persistence.Entity;
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
	
	private long id;
	
	private String nome;
	
	@Email
	private String email;
	
	private String cnpj;
	
	private String cidade;
	
}
