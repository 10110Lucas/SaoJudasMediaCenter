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
@Table (name="material")
public class Material implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_material;
	
	@Column (nullable = true, length = 5000)
	@NotNull
	private String descricao;
	
	@Column (nullable = true, length = 30)
	@NotNull
	private int curtidas;
	
	@Column (nullable = true, length = 30)
	@NotNull
	private int naocurtidas;
	
	@Column (nullable = true, length = 30)
	@NotNull
	private String tipo;
	
	@ManyToOne
	@JoinColumn (name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn (name="id_conteudo")
	private Conteudo conteudo;

	@OneToOne (mappedBy="material", targetEntity=Figura.class, cascade=CascadeType.ALL)
	private Figura figura;

	@OneToOne (mappedBy="material", targetEntity=Video.class, cascade=CascadeType.ALL)
	private Video video;
	
	@OneToOne (mappedBy="material", targetEntity=Audio.class, cascade=CascadeType.ALL)
	private Audio audio;
	
	@OneToOne (mappedBy="material", targetEntity=Tag.class, cascade=CascadeType.ALL)
	private Tag tag;
		
	//--------------- getters and setters....
	public long getId_material() {
		return id_material;
	}

	public void setId_material(long id_material) {
		this.id_material = id_material;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public int getNaocurtidas() {
		return naocurtidas;
	}

	public void setNaocurtidas(int naocurtidas) {
		this.naocurtidas = naocurtidas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}
	
	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Material [id_material=" + id_material + ", descricao=" + descricao + ", curtidas=" + curtidas
				+ ", naocurtidas=" + naocurtidas + ", tipo=" + tipo + ", usuario=" + usuario + ", conteudo=" + conteudo
				+ ", figura=" + figura + ", video=" + video + ", audio=" + audio + ", tag=" + tag + "]";
	}

	//-------------- hashcode and equals....
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_material ^ (id_material >>> 32));
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
		Material other = (Material) obj;
		if (id_material != other.id_material)
			return false;
		return true;
	}
}