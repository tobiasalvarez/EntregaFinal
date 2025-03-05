package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Usuario;
import app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public String save(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return "Usuario salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.usuarioRepository.deleteById(id);
		return "Deletado com sucesso!";
	}
	
	public Usuario findById(long id) {
		Usuario usuario = this.usuarioRepository.findById(id).get();
		return usuario;
	}
	
	public List<Usuario> findAll(){
		List<Usuario> list = this.usuarioRepository.findAll();
		return list;
	}
	
	public String update(Usuario usuario, long id) {
		usuario.setId(id);
		this.usuarioRepository.save(usuario);
		return "Usuario atualizado com sucesso!";
	}
	
	public Usuario findByNomeIgnoreCase(String nome) {
		Usuario usuario = this.usuarioRepository.findByNomeIgnoreCase(nome);
		return usuario;
	}
	
	public List<Usuario> findByTipoUser(String user){
		List<Usuario> list = this.usuarioRepository.findByTipoUser(user);
		return list;
	}

	//Query
	  public List<Usuario> buscarPorNome(String nome) {
		  List<Usuario> lista = this.usuarioRepository.buscarPorNome(nome);
	        return lista;
	    }
	
}
