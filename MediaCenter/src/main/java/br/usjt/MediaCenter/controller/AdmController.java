package br.usjt.MediaCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Figura;
import br.usjt.MediaCenter.model.bean.Material;
import br.usjt.MediaCenter.model.bean.Tag;
import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.model.bean.Video;
import br.usjt.MediaCenter.service.LoginService;
import br.usjt.MediaCenter.service.UsuarioService;

@Controller
public class AdmController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping ("/adm/inicial")
	public ModelAndView admInicial() {
		ModelAndView mv = new ModelAndView("/adm/inicial");
		//para modelar o formulário
		mv.addObject(new Usuario());
		
		System.out.println("\n-- ADM entrou: " + LoginService.user);
		
		Usuario usuario = LoginService.user;
		mv.addObject("usuario", usuario);
		mv.addObject(new Figura());
		mv.addObject(new Video());
		mv.addObject("tag", new Tag());
		return mv;
	}
	
	@GetMapping ("/adm/upload")
	public ModelAndView upload() {
		ModelAndView mv = new ModelAndView("/adm/upload");
		mv.addObject("usuario", LoginService.user);
		mv.addObject(new Figura());
		mv.addObject(new Video());
		mv.addObject("material", new Material());
		mv.addObject("tag", new Tag());
		return mv;
	}
	
	@GetMapping ("/adm/confeccao")
	public ModelAndView confeccao() {
		ModelAndView mv = new ModelAndView("/adm/confeccao");
		Usuario usuario = LoginService.user;		
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@GetMapping ("/adm/opcoes")
	public ModelAndView opcoes() {
		ModelAndView mv = new ModelAndView ("/adm/opcoes");
		Usuario usuario = LoginService.user;		
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@GetMapping ("/adm/usuarios")
	public ModelAndView usuarios(){
		ModelAndView mv = new ModelAndView ("/adm/usuarios");
		List<Usuario> usuarios = usuarioService.getUsuarios();
		mv.addObject("usuario", LoginService.user);
		mv.addObject("usuarios", usuarios);
		for(Usuario u: usuarios) {
			System.out.println("usuarios carregados: "+u);
		}
		return mv;
	}
	
	@GetMapping ("/adm/estagiario")
	public ModelAndView assineJa() {
		ModelAndView mv = new ModelAndView ("/adm/estagiario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	//------------------------------------- POSTs
	@PostMapping("/usuario/cadastrado")
	public ModelAndView salvar(Usuario usuario) {
		ModelAndView mv = new ModelAndView ("redirect:/adm/inicial");
		usuarioService.salvar(usuario);
		return mv;
	}
	
	@PostMapping ("/adm/userslistados")
	public ModelAndView alteraUser(@RequestParam String opcao){
		System.out.println(opcao);
		ModelAndView mv = null;
		if(opcao.split(":")[0].equals("deletar")) {
			mv = new ModelAndView ("/adm/usuarios");
			usuarioService.deletar(Long.parseLong(opcao.split(":")[1]));
			List<Usuario> usuarios = usuarioService.getUsuarios();
			mv.addObject("usuario", LoginService.user);
			mv.addObject("usuarios", usuarios);
			return mv;
		}else if(opcao.split(":")[0].equals("alterar")){
			mv = new ModelAndView ("/adm/alterausuario");
			Long id = Long.parseLong(opcao.replace("alterar:",""));
			Usuario usuario = new Usuario(); 
			usuario = usuarioService.getUsuarioById(id);
			mv.addObject("usuario", usuario);
			return mv;
		}
		else {
			mv = new ModelAndView ("/adm/usuarios");
			List<Usuario> usuarios = usuarioService.getUsuarios();
			mv.addObject("usuario", LoginService.user);
			mv.addObject("usuarios", usuarios);
			return mv;
		}
	}
	
	@PostMapping ("/adm/usuarioalterado")
	public ModelAndView alteraUser(Usuario usuario){
		usuarioService.salvar(usuario);
		ModelAndView mv = new ModelAndView ("redirect:/adm/usuarios");
		List<Usuario> usuarios = usuarioService.getUsuarios();
		mv.addObject("usuario", LoginService.user);
		mv.addObject("usuarios", usuarios);
		return mv;
	}
}
