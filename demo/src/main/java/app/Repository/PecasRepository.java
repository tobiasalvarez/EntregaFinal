package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Pecas;
@Repository
public interface PecasRepository extends JpaRepository<Pecas, Long>{

}
