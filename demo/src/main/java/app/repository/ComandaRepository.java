package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}
