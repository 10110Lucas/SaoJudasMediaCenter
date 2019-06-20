package br.usjt.MediaCenter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.MediaCenter.model.bean.Audio;
import br.usjt.MediaCenter.model.bean.Figura;
import br.usjt.MediaCenter.model.bean.Material;
import br.usjt.MediaCenter.model.bean.Tag;
import br.usjt.MediaCenter.model.bean.Video;
import br.usjt.MediaCenter.service.LoginService;
import br.usjt.MediaCenter.service.MaterialService;
import br.usjt.MediaCenter.test.exemplos.RedimencionaImagem;

@Controller
public class UploadContoller {
	
	@Autowired
	private MaterialService materialService;
	private Material material;
	private Figura figura;
	private Audio audio;
	private Video video;
	private Tag tag;

	@GetMapping ("/upload")
	public ModelAndView upload() {
		ModelAndView mv = new ModelAndView("upload");
		mv.addObject("usuario", LoginService.user);
		mv.addObject(new Figura());
		mv.addObject(new Video());
		mv.addObject("material", new Material());
		mv.addObject("tag", new Tag());
		return mv;
	}
	
	@PostMapping ("/upload")
	public String arquivo(@RequestParam("file") MultipartFile file, Tag etiqueta, Material m) throws IOException {
		material = new Material();
		figura = new Figura();
		audio = new Audio();
		video = new Video();
		tag = new Tag();
		System.out.println("\n--Tipo Arquivo---> "+file.getContentType() +" ---> "+file.getOriginalFilename() + "- etiqueta: "+ etiqueta.getNome());
		tag.setNome(etiqueta.getNome());
		material.setTipo(file.getContentType());
		material.setUsuario(LoginService.user);
		material.setDescricao(m.getDescricao());
		
		if(file.getContentType().split("/")[0].equals("image")) {
			RedimencionaImagem.setDimensao(file.getBytes(), 900, 500);
			figura.setNome(file.getOriginalFilename());
			figura.setImagem(file.getBytes());
			figura.setCaminho("");
			figura.setMaterial(material);
			material.setFigura(figura);
			tag.setMaterial(material);
			material.setTag(tag);
			materialService.save(material);
			System.out.println("\n--> " + "id " + material.getId_material() + " name " + figura.getNome() + " tipo " + material.getTipo());
			return "redirect:inicial";
		} else if(file.getContentType().split("/")[0].equals("audio")) {
			audio.setNome(file.getOriginalFilename());
			audio.setAudio(file.getBytes());
			audio.setCaminho("");
			audio.setMaterial(material);
			material.setAudio(audio);
			tag.setMaterial(material);
			material.setTag(tag);
			materialService.save(material);
			System.out.println("\n--> " + "id " + material.getId_material() + " name " + audio.getNome() + " tipo " + material.getTipo());
			return "redirect:inicial";
		} else if(file.getContentType().split("/")[0].equals("video")) {
			video.setNome(file.getOriginalFilename());
			video.setVideo(file.getBytes());
			video.setCaminho("");
			video.setMaterial(material);
			material.setVideo(video);
			tag.setMaterial(material);
			material.setTag(tag);
			materialService.save(material);
			System.out.println("\n--> " + "id " + material.getId_material() + " name " + video.getNome() + " tipo " + material.getTipo());
			return "redirect:inicial";
		} else {
			System.out.println("\n-->Não deu certo! " + "id: " + material.getId_material() + " name " + figura.getNome() + video.getNome() + " tipo " + material.getTipo());
			return "redirect:upload";
		}
	}
}