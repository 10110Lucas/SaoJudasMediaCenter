package br.usjt.MediaCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.service.UsuarioService;

@Controller
public class UsuarioController {
	
	public static Usuario usuario;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping ("/assineJa")
	public ModelAndView assineJa() {
		ModelAndView mv = new ModelAndView ("assineJa");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@PostMapping("/assineJa/cadastroComum")
	public ModelAndView salvar(Usuario usuario) {
		ModelAndView mv = new ModelAndView ("redirect:/login");
		usuario.setTipo("comum");
		usuarioService.salvar(usuario);
		return mv;
	}
}