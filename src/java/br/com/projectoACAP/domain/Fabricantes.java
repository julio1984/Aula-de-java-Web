package br.com.projectoACAP.domain;

public class Fabricantes {
	private Long idfabricante;
	private String fabricante;
	private Fornecedores fornecedores;
	private Municipios municipios;
	private Paises paises;
	private Provincias provincias;
	private Integer telefone;
	private Integer movel;
	private String site;
	
	public Long getIdfabricante() {
		return idfabricante;
	}
	public void setIdfabricante(Long idfabricante) {
		this.idfabricante = idfabricante;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	public Municipios getMunicipios() {
		return municipios;
	}
	public void setMunicipios(Municipios municipios) {
		this.municipios = municipios;
	}
	public Paises getPaises() {
		return paises;
	}
	public void setPaises(Paises paises) {
		this.paises = paises;
	}
	public Provincias getProvincias() {
		return provincias;
	}
	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Integer getMovel() {
		return movel;
	}
	public void setMovel(Integer movel) {
		this.movel = movel;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	

}
