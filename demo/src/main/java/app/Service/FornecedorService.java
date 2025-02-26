package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Fornecedor;
import app.Repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public String save(Fornecedor fornecedor) {
		this.fornecedorRepository.save(fornecedor);
		return "Carro salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.fornecedorRepository.deleteById(id);
		return "Carro deletado com sucesso!";
	}
	
	public Carro findById(long id) {
		Carro carro = this.fornecedorRepository.findById(id).get();
		return carro;
	}
	
	public List<Carro> findAll(){
		List<Carro> list = this.fornecedorRepository.findAll();
		return list;
	}
	
	public String update(Carro carro, long id) {
		carro.setId(id);
		this.fornecedorRepository.save(carro);
		return "Carro alterado com sucesso!";
	}
}
