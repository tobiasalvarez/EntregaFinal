package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	

}
