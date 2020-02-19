package br.com.projectoACAP.domain;

public class Municipios {
	private Long idmunicipio;
	private String municipio;
	
	public Long getIdmunicipio() {
		return idmunicipio;
	}
	public void setIdmunicipio(Long idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

@Override
public String toString() {
String saida ="COD : "+ idmunicipio + " - " + "Perfil : " + municipio; 
	return saida;
}
}

