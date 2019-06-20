package br.usjt.MediaCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	public void salvar(Usuario usuario){
		usuarioRepo.save(usuario);
	}
	
	public void deletar(Long id) {
		usuarioRepo.deleteById(id);
	}
	
	public Usuario getUsuarioById(Long id){
		return usuarioRepo.findByUsuarioId(id);
	}
	
	/*public void alterar(Usuario u) {
		usuarioRepo.setUsuarioById(u.getId_Usuario(), u.getNome(), u.getSobrenome(), u.getSexo(), u.getLogin(), u.getSenha(), u.getData_nascimento(), u.getTipo());
	}*/
	
	public List<Usuario> getUsuarios(){
		return usuarioRepo.findAll();
	}
}