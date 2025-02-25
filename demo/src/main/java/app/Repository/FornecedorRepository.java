package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Fornecedor;
@Repository

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
