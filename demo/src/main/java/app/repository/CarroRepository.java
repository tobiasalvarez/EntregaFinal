package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	
	public List<Carro> findByMarcaNome(String marca);
	
	public List<Carro> findByModeloIgnoreCase(String modelo);
	
}
