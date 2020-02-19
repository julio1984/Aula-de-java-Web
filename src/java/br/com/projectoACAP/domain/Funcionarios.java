package br.com.projectoACAP.domain;


public class Funcionarios {
	private Long idfuncinario;
	private String funcionario;
	private Utilizadores utilizador;
	public Utilizadores getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizadores utilizador) {
		this.utilizador = utilizador;
	}
	public Integer getData_registo() {
		return data_registo;
	}
	public void setData_registo(Integer data_registo) {
		this.data_registo = data_registo;
	}
	private Integer data_registo;
	private String foto;
	public Long getIdfuncinario() {
		return idfuncinario;
	}
	public void setIdfuncinario(Long idfuncinario) {
		this.idfuncinario = idfuncinario;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
