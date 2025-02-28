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
}
