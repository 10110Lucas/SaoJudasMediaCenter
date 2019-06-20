package br.usjt.MediaCenter.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.MediaCenter.model.bean.Material;

public interface MaterialRepository extends JpaRepository<Material, Long>{
	
	@Query("SELECT m FROM Material m WHERE m.id_material = ?1")
	public Material findMaterialById(Long id);
	
	public void deleteById(Long id);
}
