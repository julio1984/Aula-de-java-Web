package br.com.projectoACAP.domain;

public class Provincias {
	private Long idprovincia;
	private String provincia;
	private Paises pais;
	public Long getIdprovincia() {
		return idprovincia;
	}
	public void setIdprovincia(Long idprovincia) {
		this.idprovincia = idprovincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Paises getPais() {
		return pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}

}
