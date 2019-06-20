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
@Table (name="figura")
public class Figura implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_figura;
	
	@Column (nullable = true, length = 120)
	@NotNull
	private String nome;
	
	@Column (nullable = true, length = 200000000)
	@NotNull
	private byte[] imagem;
	
	private String caminho;
	
	@OneToOne
	@JoinColumn (name="id_material")
	private Material material;

	public Long getId_figura() {
		return id_figura;
	}

	public void setId_figura(Long id_figura) {
		this.id_figura = id_figura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] arquivo) {
		this.imagem = arquivo;
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
		result = prime * result + ((id_figura == null) ? 0 : id_figura.hashCode());
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
		Figura other = (Figura) obj;
		if (id_figura == null) {
			if (other.id_figura != null)
				return false;
		} else if (!id_figura.equals(other.id_figura))
			return false;
		return true;
	}
}