package br.com.projectoACAP.domain;

public class Clientes {
	private Long idClientes;
	private String Cliente;
	private Integer ContaCorrente;
	private Utilizadores utilizador;
	public Long getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(Long idClientes) {
		this.idClientes = idClientes;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public Integer getContaCorrente() {
		return ContaCorrente;
	}
	public void setContaCorrente(Integer contaCorrente) {
		ContaCorrente = contaCorrente;
	}
	public Utilizadores getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizadores utilizador) {
		this.utilizador = utilizador;
	}

}
