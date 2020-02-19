package br.com.projectoACAP.domain;

public class Bairros {
	private Long idbairro;
	private String bairro;
	private Municipios municipios;
	public Long getIdbairro() {
		return idbairro;
	}
	public void setIdbairro(Long idbairro) {
		this.idbairro = idbairro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Municipios getMunicipios() {
		return municipios;
	}
	public void setMunicipios(Municipios municipios) {
		this.municipios = municipios;
	}

}
