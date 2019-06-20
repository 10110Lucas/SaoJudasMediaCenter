package br.usjt.MediaCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.MediaCenter.model.bean.Material;
import br.usjt.MediaCenter.model.repository.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepo;
	
	public void save(Material material) {
		materialRepo.save(material);
	}
	
	public void deletar(Long id) {
		materialRepo.deleteById(id);
	}
	
	public Material getIdMaterial(Long id) {
		return materialRepo.findMaterialById(id);
	}
}
