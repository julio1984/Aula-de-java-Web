package br.com.projectoACAP.domain;


public class Montras {
	private Long idmontra;
	private Integer Data_actualizacao;
	private Utilizadores utilizadores;
	
	public Long getIdmontra() {
		return idmontra;
	}
	public void setIdmontra(Long idmontra) {
		this.idmontra = idmontra;
	}
	
	public Integer getData_actualizacao() {
		return Data_actualizacao;
	}
	public void setData_actualizacao(Integer data_actualizacao) {
		Data_actualizacao = data_actualizacao;
	}
	public Utilizadores getUtilizadores() {
		return utilizadores;
	}
	public void setUtilizadores(Utilizadores utilizadores) {
		this.utilizadores = utilizadores;
	}

}
