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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column (nullable = false, length = 15)
	@NotNull
	private String nome;

	@Column (nullable = false, length = 25)
	@NotNull
	private String sobrenome;

	@Column (nullable = false, length = 10)
	private String data_nascimento;

	@Column (nullable = false, length = 1)
	private char sexo;

//	@Column (nullable = false, length = 2500)
//	private String conteudo;

	@Column (nullable = false, length = 50)
	@NotNull
	private String login;

	@Column (nullable = false, length = 20)
	@NotNull
	private String senha;

	@Column (nullable = false, length = 15)
	@NotNull
	private String tipo;

	/*********************************
		IDUSUARIO INT PRIMARY KEY,
	    Nome VARCHAR(15),
	    Sobrenome VARCHAR(25),
	    DataDeNascimento DATE,
	    Sexo CHAR(1), 
	    Conteudo VARCHAR(2500),
	    Email VARCHAR(50) ,
	    Senha VARCHAR(20),
	    Tipo VARCHAR(15)
	***********************************/
	@OneToMany (mappedBy="usuario", targetEntity=Material.class, cascade=CascadeType.ALL)
	private List<Material> material;
	
	public List<Material> getMaterial() {
		return material;
	}
	public void setMaterial(List<Material> material) {
		this.material = material;
	}

	@OneToMany (mappedBy="usuario", targetEntity=Conteudo.class, cascade=CascadeType.ALL)
	private List<Conteudo> conteudo;
	
	public List<Conteudo> getConteudo() {
		return conteudo;
	}
	public void setConteudo(List<Conteudo> conteudo) {
		this.conteudo = conteudo;
	}
	
	@OneToOne
	@JoinColumn (name="id_feedback")
	private Feedback feedback;
	
	public Long getId_Usuario() {
		return id_usuario;
	}
	public void setId_Usuario(Long id_Usuario) {
		this.id_usuario = id_Usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	

	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id_usuario
				          + ", nome=" + nome
				     + ", sobrenome=" + sobrenome 
				+ ", data_nascimento=" + data_nascimento
				          + ", Sexo=" + sexo
				         + ", login=" + login
				         + ", senha=" + senha
				          + ", tipo=" + tipo + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		return true;
	}
}