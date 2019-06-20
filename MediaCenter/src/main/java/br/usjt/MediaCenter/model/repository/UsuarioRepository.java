package br.usjt.MediaCenter.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.MediaCenter.model.bean.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByLoginAndSenha(String login, String senha);
	
	public List<Usuario> findAll();
	
	public void deleteById(Long id);
	
	@Query("SELECT u FROM Usuario u WHERE u.id_usuario = ?1")
	public Usuario findByUsuarioId(Long id);	
	
	/*@Query("UPDATE Usuario u SET u.nome = ?2, u.sobrenome = ?3, u.sexo = ?4, u.login = ?5, u.senha = ?6, u.data_nascimento = ?7, u.tipo = ?8 where u.id_usuario = ?1")*/
	@Query("UPDATE Usuario SET nome = ?2, sobrenome = ?3, sexo = ?4, login = ?5, senha = ?6, data_nascimento = ?7, tipo = ?8 where id_usuario = ?1")
	public void setUsuarioById(Long id, String nome, String sobrenome, char c, String login, String senha, String data_nascimento, String tipo);
}
