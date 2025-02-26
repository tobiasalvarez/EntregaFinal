package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Carro;
import app.Entity.Peca;
import app.Repository.PecaRepository;

@Service
public class PecaService {

	@Autowired
	private PecaRepository pecaRepository;
	
	public String save(Peca peca) {
		return null;
	}
	
	public String delete(long id) {
		return null;
	}
	
	public Peca findById(long id) {
		return null;
	}
	
	public List<Peca> findAll(){
		return null;
	}
	
	public String update(Peca peca, long id) {
		return null;
	}
}
