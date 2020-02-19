package br.com.projectoACAP.domain;

public class Utilizadores {
	private Long idutilizador;
	private String login;
	private String senha;
	private String utilizador;
	
	private Estado estado;
	private Perfil perfil;
	public Long getIdutilizador() {
		return idutilizador;
	}
	public void setIdutilizador(Long idutilizador) {
		this.idutilizador = idutilizador;
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
	public String getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	

}
