package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Peca;
@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{

	public Peca findByCarrosModeloIgnoreCase (String modelo);
	
	public Peca findByFornecedoresNomeIgnoreCase (String nome);
	
}
