package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
