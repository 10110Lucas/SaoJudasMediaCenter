package br.usjt.MediaCenter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Material;
import br.usjt.MediaCenter.model.bean.Usuario;
import br.usjt.MediaCenter.model.repository.MaterialRepository;
import br.usjt.MediaCenter.service.LoginService;

@Controller
public class ConfeccaoController {
	
	@Autowired
	private MaterialRepository materialRepo;
	
	@GetMapping ("/confeccao")
	public ModelAndView confeccao() throws IOException {
		ModelAndView mv = new ModelAndView("confeccao");
		Usuario usuario = LoginService.user;
		mv.addObject("usuario", usuario);		
		List<Material> conteudos = materialRepo.findAll();
		File file;
		FileOutputStream arq = null;
		FileInputStream arq2 = null;
		String local = "C:\\Users\\lucas\\Documents\\Universidade_Sao_Judas_Tadeu\\Eclipse-workspace\\MediaCenter\\src\\main\\resources\\static\\Downloads\\";
		String name;
		byte[] bytes;
		for(Material c : conteudos) {
			if(c.getTipo().split("/")[0].equals("image")) {
				name = c.getFigura().getNome();
				bytes = c.getFigura().getImagem();
			}else if(c.getTipo().split("/")[0].equals("audio")) {
				name = c.getAudio().getNome();
				bytes = c.getAudio().getAudio();
			}else{
				name = c.getVideo().getNome();				
				bytes = c.getVideo().getVideo();
			}
			
			System.out.print("\n --> "+ c.getDescricao());
			
			file = new File(local + name);
			arq = new FileOutputStream(file);
			arq.write(bytes);
			arq.close();
			arq2 = new FileInputStream(file);
			arq2.read(bytes);
			name = name.substring(0, name.length()-4);
					
			if(c.getTipo().split("/")[0].equals("image")) {
				c.getFigura().setCaminho("Downloads"+File.separator+file.getName());
				c.getFigura().setNome(name);
			}else if(c.getTipo().split("/")[0].equals("audio")) {
				c.getAudio().setCaminho("Downloads"+File.separator+file.getName());
				c.getAudio().setNome(name);
			}else{
				c.getVideo().setCaminho("Downloads"+File.separator+file.getName());
				c.getVideo().setNome(name);
			}
			arq2.close();
		}
		Collections.reverse(conteudos);
		mv.addObject("conteudos", conteudos);
		return mv;
	}
}
