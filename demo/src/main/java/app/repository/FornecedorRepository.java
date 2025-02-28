package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Fornecedor;
@Repository

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
