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
		return null;
	}
	
	public String delete(long id) {
		return null;
	}
	
	public Marca findById(long id) {
		return null;
	}
	
	public List<Marca> findAll(){
		return null;
	}
	
	public String update(Marca marca, long id) {
		return null;
	}
}
