package br.com.projectoACAP.domain;

public class FormasPagamentos {
	private Long idformasPagamento;
	private String formasPagamento;
	private Vendas venda;
	
	public Long getIdformasPagamento() {
		return idformasPagamento;
	}
	public void setIdformasPagamento(Long idformasPagamento) {
		this.idformasPagamento = idformasPagamento;
	}
	public String getFormasPagamento() {
		return formasPagamento;
	}
	public void setFormasPagamento(String formasPagamento) {
		this.formasPagamento = formasPagamento;
	}
	public Vendas getVenda() {
		return venda;
	}
	public void setVenda(Vendas venda) {
		this.venda = venda;
	}

}
