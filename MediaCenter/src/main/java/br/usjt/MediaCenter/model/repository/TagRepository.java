package br.usjt.MediaCenter.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.MediaCenter.model.bean.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
	
	@Query("SELECT t FROM Tag t WHERE t.nome like %?1%")
	List<Tag> findTagByNome(String tag);
}
