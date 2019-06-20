package br.usjt.MediaCenter.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.MediaCenter.model.bean.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

}
