package br.com.projectoACAP.domain;

import java.util.Date;

public class Pessoas {
	private Long idpessoa;
	private String nome;
	private String sobreNome;
	private Integer NIF;
	private Integer telefone;
	private Integer movel;
	private Paises pais;
	private Municipios municipio;
	private Bairros bairro;
	public Long getIdpessoa() {
		return idpessoa;
	}
	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public Integer getNIF() {
		return NIF;
	}
	public void setNIF(Integer nIF) {
		NIF = nIF;
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
	public Paises getPais() {
		return pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}
	public Municipios getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}
	public Bairros getBairro() {
		return bairro;
	}
	public void setBairro(Bairros bairro) {
		this.bairro = bairro;
	}
	public Provincias getProvincias() {
		return provincias;
	}
	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getData_regito() {
		return data_regito;
	}
	public void setData_regito(Date data_regito) {
		this.data_regito = data_regito;
	}
	public Integer getNumero_BI() {
		return numero_BI;
	}
	public void setNumero_BI(Integer numero_BI) {
		this.numero_BI = numero_BI;
	}
	private Provincias provincias;
	private String endereco;
	private String email;
	private String estado_civil;
	private String sexo;
	private Date data_regito;
	private Integer numero_BI;

}
