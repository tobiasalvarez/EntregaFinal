package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Marca;
import app.Repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;
	
	public String save(Marca marca) {
		this.marcaRepository.save(marca);
		return "Marca salva com sucesso!";
	}
	
	public String delete(long id) {
		this.marcaRepository.deleteById(id);
		return "Marca deletada com sucesso!";
	}
	
	public Marca findById(long id) {
		Marca marca = this.marcaRepository.findById(id).get();
		return marca;
	}
	
	public List<Marca> findAll(){
		List<Marca> list = this.marcaRepository.findAll();
		return list;
	}
	
	public String update(Marca marca, long id) {
		marca.setId(id);
		this.marcaRepository.save(marca);
		return "Marca atualizada com sucesso!";
	}
}
