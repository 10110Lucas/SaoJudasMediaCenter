package br.usjt.MediaCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Figura;
import br.usjt.MediaCenter.model.repository.FiguraRepository;

@Service
public class FiguraService {
	
	@Autowired
	private FiguraRepository figuraRepo;
	
	public void save(Figura figura){
		figuraRepo.save(figura);
	}

}
