package br.usjt.MediaCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Conteudo;
import br.usjt.MediaCenter.model.repository.ConteudoRepository;

@Service
public class ConteudoService {
	
	@Autowired
	private ConteudoRepository conteudoRepo;
	
	public void salvar(Conteudo conteudo) {
		conteudoRepo.save(conteudo);
	}
}