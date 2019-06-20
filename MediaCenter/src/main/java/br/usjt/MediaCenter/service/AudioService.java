package br.usjt.MediaCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Audio;
import br.usjt.MediaCenter.model.repository.AudioRepository;

@Service
public class AudioService {
	
	@Autowired
	private AudioRepository audioRepo;
	
	public void save(Audio audio) {
		audioRepo.save(audio);
	}
}
