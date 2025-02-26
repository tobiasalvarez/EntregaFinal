package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Carro;
import app.Repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired 
	private CarroRepository carroRepository;
	
	public String save(Carro carro) {
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso!";
	}
	
	public Carro findById(long id) {
		Carro carro = this.carroRepository.findById(id).get();
		return carro;
	}
	
	public List<Carro> findAll(){
		List<Carro> list = this.carroRepository.findAll();
		return list;
	}
	
	public String update(Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro alterado com sucesso!";
	}

}
