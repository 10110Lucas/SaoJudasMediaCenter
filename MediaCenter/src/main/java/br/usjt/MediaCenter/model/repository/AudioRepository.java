package br.usjt.MediaCenter.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.MediaCenter.model.bean.Audio;

public interface AudioRepository extends JpaRepository<Audio, Long>{

}
