package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Marca;
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
