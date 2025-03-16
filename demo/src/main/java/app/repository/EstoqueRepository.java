package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
