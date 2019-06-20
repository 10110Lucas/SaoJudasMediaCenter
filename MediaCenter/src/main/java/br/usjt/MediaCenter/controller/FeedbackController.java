package br.usjt.MediaCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Material;
import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.service.LoginService;
import br.usjt.MediaCenter.service.MaterialService;

@Controller
public class FeedbackController {
		
	@Autowired
	private MaterialService materialService;
	
	@PostMapping("curtidas")
	public String curtidas(@RequestParam("curtidas")String curtida) {
		Material mat = null;
		System.out.println("---> curtiu: " + curtida);
		if(curtida.contains("like")) {
			mat = materialService.getIdMaterial(Long.parseLong(curtida.replace("like:","")));
			System.out.println(mat);
			int x = mat.getCurtidas() + 1;
			mat.setCurtidas(x);
			materialService.save(mat);
		}else if(curtida.contains("naocurtida")) {
			mat = materialService.getIdMaterial(Long.parseLong(curtida.replace("naocurtida:","")));
			System.out.println(mat);
			int x = mat.getNaocurtidas() + 1;
			mat.setNaocurtidas(x);
			materialService.save(mat);
		}else if(curtida.split(":")[0].equals("deletar")) {
			materialService.deletar(Long.parseLong(curtida.split(":")[1]));
			return "redirect:/confeccao";
		}else if(curtida.split(":")[0].equals("alterar")){
			/*mv = new ModelAndView ("/adm/alterausuario");
			Long id = Long.parseLong(opcao.replace("alterar:",""));
			Usuario usuario = new Usuario(); 
			usuario = usuarioService.getUsuarioById(id);
			mv.addObject("usuario", usuario);
			return mv;*/
		}
		return "redirect:/index";
	}
}
