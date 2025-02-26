package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Peca;
@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{

}
