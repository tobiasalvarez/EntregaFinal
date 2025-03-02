package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByNomeIgnoreCase(String nome);
	
	public List<Usuario> findByTipoUser(String user);
}
