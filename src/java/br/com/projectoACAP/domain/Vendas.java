package br.com.projectoACAP.domain;


public class Vendas {
	private Long idvenda;
	private Clientes cliente;
	private Utilizadores utilizadores;
	private Double valor_venda;
	private Double valor_entregue;
	private Double total_valor;
	public Double getTotal_venda() {
		return total_venda;
	}
	public void setTotal_venda(Double total_venda) {
		this.total_venda = total_venda;
	}
	public void setData_venda(int data_venda) {
		this.data_venda = data_venda;
	}
	private Produtos produto;
	private Double troco;
	public int getData_venda() {
		return data_venda;
	}
	private int data_venda;
	private Double total_venda;
	public Long getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(Long idvenda) {
		this.idvenda = idvenda;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Utilizadores getUtilizadores() {
		return utilizadores;
	}
	public void setUtilizadores(Utilizadores utilizadores) {
		this.utilizadores = utilizadores;
	}
	public Double getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(Double valor_venda) {
		this.valor_venda = valor_venda;
	}
	public Double getValor_entregue() {
		return valor_entregue;
	}
	public void setValor_entregue(Double valor_entregue) {
		this.valor_entregue = valor_entregue;
	}
	public Double getTotal_valor() {
		return total_valor;
	}
	public void setTotal_valor(Double total_valor) {
		this.total_valor = total_valor;
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public Double getTroco() {
		return troco;
	}
	public void setTroco(Double troco) {
		this.troco = troco;
	}


}
