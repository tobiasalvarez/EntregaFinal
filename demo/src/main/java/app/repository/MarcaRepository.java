package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Marca;
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
