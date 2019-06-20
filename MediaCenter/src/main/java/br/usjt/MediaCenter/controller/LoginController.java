package br.usjt.MediaCenter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping ("/login")
	public ModelAndView login () {
		ModelAndView mv = new ModelAndView ("login");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@PostMapping ("/fazerLogin")
	public String fazerLogin (Usuario usuario, HttpServletRequest request) {
		System.out.println("Sessao Interceptada ---> " + request.getSession().getId() + "\n");
		if (loginService.logar(usuario)) {
			request.getSession().setAttribute("usuarioLogado", loginService.getUser(usuario));
			if(LoginService.user.getTipo().contains("comum")) {
				return "redirect:timeline";
			}else if(LoginService.user.getTipo().contains("administrador")){
				return "redirect:/adm/inicial";
			}else {
				return "redirect:inicial";
			}
		}
		else {
			return "login";
		}
	}
	
	@PostMapping ("/logof")
	public String fazerLogof(){
		LoginService.user = null;
		return "redirect:index";
	}
}
