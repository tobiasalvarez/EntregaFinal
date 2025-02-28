package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Peca;
import app.repository.PecaRepository;

@Service
public class PecaService {

	@Autowired
	private PecaRepository pecaRepository;
	
	public String save(Peca peca) {
		this.pecaRepository.save(peca);
		return "Peca salva com sucesso!";
	}
	
	public String delete(long id) {
		this.pecaRepository.deleteById(id);
		return "Deletado com sucesso!";
	}
	
	public Peca findById(long id) {
		Peca peca = this.pecaRepository.findById(id).get();
		return peca;
	}
	
	public List<Peca> findAll(){
		List<Peca> list = this.pecaRepository.findAll();
		return list;
	}
	
	public String update(Peca peca, long id) {
		peca.setId(id);
		this.pecaRepository.save(peca);
		return "Peca atualizada com sucesso!";
	}
}
