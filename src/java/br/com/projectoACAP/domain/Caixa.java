package br.com.projectoACAP.domain;

import java.util.Date;

public class Caixa {
	private Long idcaixa;
	private Date datafeixo;
	private Vendas venda;
	private Double valor;
	private Utilizadores utilizadores;
	
	public Long getIdcaixa() {
		return idcaixa;
	}
	public void setIdcaixa(Long idcaixa) {
		this.idcaixa = idcaixa;
	}
	public Date getDatafeixo() {
		return datafeixo;
	}
	public void setDatafeixo(Date datafeixo) {
		this.datafeixo = datafeixo;
	}
	public Vendas getVenda() {
		return venda;
	}
	public void setVenda(Vendas venda) {
		this.venda = venda;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(double d) {
		this.valor = d;
	}
	public Utilizadores getUtilizadores() {
		return utilizadores;
	}
	public void setUtilizadores(Utilizadores utilizadores) {
		this.utilizadores = utilizadores;
	}
	

}
