package br.usjt.MediaCenter.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "feedback")
public class Feedback implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_feedback;
	
	@Column (nullable = true, length = 10)
	@NotNull
	private String gostou;
	
	@Column (nullable = true, length = 10)
	@NotNull
	private String naogostou;
	
	@ManyToOne
	@JoinColumn (name="id_conteudo")
	private Conteudo conteudo;

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	
	@OneToOne (mappedBy="feedback", targetEntity=Usuario.class, cascade=CascadeType.ALL)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId_feedback() {
		return id_feedback;
	}

	public void setId_feedback(Long id_feedback) {
		this.id_feedback = id_feedback;
	}

	public String getGostou() {
		return gostou;
	}

	public void setGostou(String gostou) {
		this.gostou = gostou;
	}

	public String getNaogostou() {
		return naogostou;
	}

	public void setNaogostou(String naogostou) {
		this.naogostou = naogostou;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_feedback == null) ? 0 : id_feedback.hashCode());
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
		Feedback other = (Feedback) obj;
		if (id_feedback == null) {
			if (other.id_feedback != null)
				return false;
		} else if (!id_feedback.equals(other.id_feedback))
			return false;
		return true;
	}
}
