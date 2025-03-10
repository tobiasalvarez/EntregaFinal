package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Fornecedor;
import app.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public String save(Fornecedor fornecedor) {
		Fornecedor fornecedo = this.fornecedorRepository.findByCnpj(fornecedor.getCnpj());
		if(fornecedo != null) {
			 throw new RuntimeException("CNPJ ja cadastrado");
		}else if(fornecedor.getEmail() == null) {
			fornecedor.setStatusCadastro("Incompleto");
		}else{
			fornecedor.setStatusCadastro("Completo");
		}
		
		this.fornecedorRepository.save(fornecedor);
		return "Fornecedor salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.fornecedorRepository.deleteById(id);
		return "Fornecedor deletado com sucesso!";
	}
	
	public Fornecedor findById(long id) {
		Fornecedor fornecedor = this.fornecedorRepository.findById(id).get();
		return fornecedor;
	}
	
	public List<Fornecedor> findAll(){
		List<Fornecedor> list = this.fornecedorRepository.findAll();
		return list;
	}
	
	public String update(Fornecedor fornecedor, long id) {
		fornecedor.setId(id);
		this.fornecedorRepository.save(fornecedor);
		return "Fornecedor alterado com sucesso!";
	}
	
	public Fornecedor findByPecasNome(String nome) {
		Fornecedor fornecedor = this.fornecedorRepository.findByPecasNome(nome);
		return fornecedor;
	}
	
	public Fornecedor findByEmail(String email) {
		Fornecedor fornecedor = this.fornecedorRepository.findByEmail(email);
		return fornecedor;
	}
}
