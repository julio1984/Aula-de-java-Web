package br.com.projectoACAP.domain;

public class ItenVenda {
	private Long idItem_venda;
	private Produtos produto;
	private Integer quantidade;
	private Vendas venda;
	private String moeda;
	private Double desconto;
	public Long getIdItem_venda() {
		return idItem_venda;
	}
	public void setIdItem_venda(Long idItem_venda) {
		this.idItem_venda = idItem_venda;
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Vendas getVenda() {
		return venda;
	}
	public void setVenda(Vendas venda) {
		this.venda = venda;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	

}
