package br.usjt.MediaCenter.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="video")
public class Video implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_video;
	
	@Column (nullable = true, length = 120)
	@NotNull
	private String nome;
	
	@Column (nullable = true, length = 200000000)
	@NotNull
	private byte[] video;
	
	private String caminho;
	
	@OneToOne
	@JoinColumn (name="id_material")
	private Material material;

	public Long getId_video() {
		return id_video;
	}

	public void setId_video(Long id_video) {
		this.id_video = id_video;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_video == null) ? 0 : id_video.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (id_video == null) {
			if (other.id_video != null)
				return false;
		} else if (!id_video.equals(other.id_video))
			return false;
		return true;
	}
}