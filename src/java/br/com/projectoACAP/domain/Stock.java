package br.com.projectoACAP.domain;

import java.sql.Date;

public class Stock {
private Long idstock;
private Integer quantidadeMaxima;
private Integer quantidadeCritica;
private Integer quantidadeMinima;
private Date data_actualizao;
private Utilizadores utilizador;

public Long getIdstock() {
	return idstock;
}
public void setIdstock(Long idstock) {
	this.idstock = idstock;
}
public Integer getQuantidadeMaxima() {
	return quantidadeMaxima;
}
public void setQuantidadeMaxima(Integer quantidadeMaxima) {
	this.quantidadeMaxima = quantidadeMaxima;
}
public Integer getQuantidadeCritica() {
	return quantidadeCritica;
}
public void setQuantidadeCritica(Integer quantidadeCritica) {
	this.quantidadeCritica = quantidadeCritica;
}
public Integer getQuantidadeMinima() {
	return quantidadeMinima;
}
public void setQuantidadeMinima(Integer quantidadeMinima) {
	this.quantidadeMinima = quantidadeMinima;
}
public Date getData_actualizao() {
	return data_actualizao;
}
public void setData_actualizao(Date data_actualizao) {
	this.data_actualizao = data_actualizao;
}
public Utilizadores getUtilizador() {
	return utilizador;
}
public void setUtilizador(Utilizadores utilizador) {
	this.utilizador = utilizador;
}

}
