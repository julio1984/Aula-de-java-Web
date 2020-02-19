package br.com.projectoACAP.domain;

public class Perfil {
	private Long idperfil;
	private String perfil;
	
	public Long getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(Long idperfil) {
		this.idperfil = idperfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
	String saida ="COD : "+ idperfil + " - " + "Perfil : " + perfil; 
		return saida;
	}

}
