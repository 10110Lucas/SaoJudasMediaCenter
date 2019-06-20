package br.usjt.MediaCenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Figura;
import br.usjt.MediaCenter.model.bean.Tag;
import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.model.bean.Video;
import br.usjt.MediaCenter.service.LoginService;

@Controller
public class MediaCenterController {
		
	@GetMapping ("/inicial")
	public ModelAndView inicial() {
		ModelAndView mv = new ModelAndView ("inicial");
		//para modelar o formulário
		mv.addObject(new Usuario());
		System.out.println("\n entrou? " + LoginService.user);
		
		Usuario usuario = LoginService.user;		
		mv.addObject("usuario", usuario);
		mv.addObject(new Figura());
		mv.addObject(new Video());
		mv.addObject("tag", new Tag());
		
		return mv;
	}
	
	@GetMapping ("/noticia")
	public ModelAndView noticia() {
		ModelAndView mv = new ModelAndView ("noticia");
		Usuario usuario = LoginService.user;		
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@GetMapping ("/opcoes")
	public ModelAndView opcoes() {
		ModelAndView mv = new ModelAndView ("opcoes");
		Usuario usuario = LoginService.user;		
		mv.addObject("usuario", usuario);
		return mv;
	}
}