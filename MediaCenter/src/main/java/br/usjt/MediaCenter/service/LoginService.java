package br.usjt.MediaCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.model.repository.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public static Usuario user = null;
	
	public boolean logar (Usuario usuario) {
		System.out.println("\n-- Logado! --> " + usuarioRepo.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha())+"\n");
		user = usuarioRepo.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		return user != null;
	}
	
	public Usuario getUser(Usuario usuario) {
		return usuarioRepo.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
	}
}