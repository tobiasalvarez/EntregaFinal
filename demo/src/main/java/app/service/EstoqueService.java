package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Estoque;
import app.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	public String save(Estoque estoque) {
		this.estoqueRepository.save(estoque);
		return "Estoque salvo!";
	}
	
	public String delete(long id) {
		this.estoqueRepository.deleteById(id);
		return "Estoque deletado!";
	}
	
	public Estoque findById(long id) {
		Estoque estoque = this.estoqueRepository.findById(id).get();
		return estoque;
	}
	
	public List<Estoque> findAll(){
		List<Estoque> list = this.estoqueRepository.findAll();
		return list;
	}
	
	public String update(Estoque estoque, long id) {
		estoque.setId(id);
		this.estoqueRepository.save(estoque);
		return "Estoque atualizado!";
	}
	
}
