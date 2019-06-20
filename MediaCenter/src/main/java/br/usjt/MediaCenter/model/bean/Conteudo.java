package br.usjt.MediaCenter.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="conteudo")
public class Conteudo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_conteudo;
	
//	@Column (nullable = true, length = 120)
//	@NotNull
//	private String nome;
//	
//	@Column (nullable = true, length = 200000000)
//	@NotNull
//	private byte[] arquivo;
//	
//	@Column (nullable = true, length = 7)
//	@NotNull
//	private String tipo;
	
	@ManyToOne
	@JoinColumn (name="id_usuario")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@OneToMany (mappedBy="conteudo", targetEntity=Material.class, cascade=CascadeType.ALL)
	private List<Material> material;

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}
	
	@OneToMany (mappedBy="conteudo", targetEntity=Feedback.class, cascade=CascadeType.ALL)
	private List<Feedback> feedback;
	
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public long getId_conteudo() {
		return id_conteudo;
	}

	public void setId_conteudo(long id_conteudo) {
		this.id_conteudo = id_conteudo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_conteudo ^ (id_conteudo >>> 32));
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
		Conteudo other = (Conteudo) obj;
		if (id_conteudo != other.id_conteudo)
			return false;
		return true;
	}
}