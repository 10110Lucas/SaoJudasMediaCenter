package br.usjt.MediaCenter.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.MediaCenter.model.bean.Conteudo;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long>{
	
}
