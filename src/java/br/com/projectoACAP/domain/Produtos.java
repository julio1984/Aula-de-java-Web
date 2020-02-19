package br.com.projectoACAP.domain;


public class Produtos {
	private Long idproduto;
	private String produto;
	private String CodBarra;
	private Integer quantidade;
	private Categoria categoria;
	private Montras montra;
	private Clientes cliente;
	private Double preco;
	private FormasPagamentos formasPagamentos;
	private Fabricantes fabricante;
	private Integer data_expiracao;
	private String foto;
	private Double valorFinal;
	public Long getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getCodBarra() {
		return CodBarra;
	}
	public void setCodBarra(String codBarra) {
		CodBarra = codBarra;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Montras getMontra() {
		return montra;
	}
	public void setMontra(Montras montra) {
		this.montra = montra;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public FormasPagamentos getFormasPagamentos() {
		return formasPagamentos;
	}
	public void setFormasPagamentos(FormasPagamentos formasPagamentos) {
		this.formasPagamentos = formasPagamentos;
	}
	public Fabricantes getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricantes fabricante) {
		this.fabricante = fabricante;
	}
	public Integer getData_expiracao() {
		return data_expiracao;
	}
	public void setData_expiracao(Integer data_expiracao) {
		this.data_expiracao = data_expiracao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
	

}
