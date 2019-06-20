package br.usjt.MediaCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Video;
import br.usjt.MediaCenter.model.repository.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepo;
	
	public void save(Video video) {
		videoRepo.save(video);
	}
}
