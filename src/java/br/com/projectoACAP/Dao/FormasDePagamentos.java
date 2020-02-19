package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Clientes;
import br.com.projectoACAP.domain.FormasPagamentos;
import br.com.projectoACAP.domain.Utilizadores;
import br.com.projectoACAP.domain.Vendas;


public class FormasDePagamentos {
	public void salvar(FormasPagamentos fp) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO formasPagamentos ");
		sql.append("(idformasPagamento, formasPagamento, idvenda) ");
		sql.append("VALUES(?, ?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, fp.getIdformasPagamento());
		pst.setString(2, fp.getFormasPagamento());
		pst.setLong(3, fp.getVenda().getIdvenda());
		pst.executeUpdate();

		System.out.println("A Formas de Pagamentos foi Registado com sucesso.");
	}

	public void editar(FormasPagamentos fp) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE formaspagamentos ");
		sql.append("SET formaspagamento = ?, idvenda = ? ");
		sql.append(" WHERE idformaspagamento = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, fp.getIdformasPagamento());
		pst.setString(2, fp.getFormasPagamento());
		pst.setLong(3, fp.getVenda().getIdvenda());

		pst.executeUpdate();
		System.out.println("O montra foi actualizado com sucesso.");
	}

	public void excluir(FormasPagamentos fp) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM formaspagamentos ");
		sql.append(" WHERE idformaspagamento = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, fp.getIdformasPagamento());
		pst.executeUpdate();
		System.out.println("A forma de pagamento foi eliminado com sucesso.");
	}

	public FormasPagamentos buscar_por_id(FormasPagamentos fp) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idformaspagamento ");
		sql.append("FROM formasdepagamento ");
		sql.append("WHERE idformasdepagamento = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, fp.getIdformasPagamento());

		ResultSet resultado = pst.executeQuery();

		FormasPagamentos retorno = null;

		if (resultado.next()) {
			 Vendas v = new Vendas();
			 v.setData_venda(resultado.getInt("data_venda"));
			 v.setIdvenda(resultado.getLong("idvenda"));
			 v.setValor_venda(resultado.getDouble("valor_venda"));
			 v.setTotal_valor(resultado.getDouble("total_valor"));
			 v.setTroco(resultado.getDouble("troco"));
			 v.setValor_entregue(resultado.getDouble("valor_entregue"));
			 
			 Utilizadores ut =  new Utilizadores();
			 ut.setIdutilizador(resultado.getLong("idutilizador"));
			 ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes c = new Clientes();
			 c.setIdClientes(resultado.getLong("idClientes"));
			 c.setCliente(resultado.getString("cliente"));
			 c.setContaCorrente(resultado.getInt("contaCorrente"));
			 c.setUtilizador(ut);
			 
			retorno = new FormasPagamentos();
			retorno.setIdformasPagamento(resultado.getLong("idformasdepagamento"));
			retorno.setFormasPagamento(resultado.getString("formasdepagamento"));
			retorno.setVenda(v);
			

		}
		return retorno;

	}

	public ArrayList<FormasPagamentos> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM formaspagamentos INNER JOIN ");
		sql.append("vendas ON "); 
		sql.append("formaspagamentos.idvenda = vendas.idvenda ");
		sql.append("ORDER BY formaspagamento ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<FormasPagamentos> lista = new ArrayList<FormasPagamentos>();

		while (resultado.next()) {
			
			
			 Vendas v = new Vendas();
			 v.setData_venda(resultado.getInt("data_venda"));
			 v.setIdvenda(resultado.getLong("idvenda"));
			 v.setValor_venda(resultado.getDouble("valor_venda"));
			 v.setTotal_valor(resultado.getDouble("total_valor"));
			 v.setTroco(resultado.getDouble("troco"));
			 v.setValor_entregue(resultado.getDouble("valor_entregue"));
			 
			 Utilizadores ut =  new Utilizadores();
			 ut.setIdutilizador(resultado.getLong("idutilizador"));
			 ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes c = new Clientes();
			 c.setIdClientes(resultado.getLong("idClientes"));
			 c.setCliente(resultado.getString("cliente"));
			 c.setContaCorrente(resultado.getInt("contaCorrente"));
			 c.setUtilizador(ut);
			 
			 FormasPagamentos form = new FormasPagamentos();
			 form.setIdformasPagamento(resultado.getLong("idformasPagamento"));
			 form.setFormasPagamento(resultado.getString("formasPagamentos"));
			 form.setVenda(v);
			 
			 lista.add(form);
		}

		return lista;
	}

	public ArrayList<FormasPagamentos> buscar_pagamentos(FormasPagamentos form)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM formaspagamentos INNER ");
		sql.append("JOIN vendas ON formaspagamentos.idvenda = vendas.idvenda");
		sql.append("WHERE idformaPagamento like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + form.getFormasPagamento()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<FormasPagamentos> listar = new ArrayList<FormasPagamentos>();

		while (resultado.next()) {
			
			 Vendas v = new Vendas();
			 v.setData_venda(resultado.getInt("data_venda"));
			 v.setIdvenda(resultado.getLong("idvenda"));
			 v.setValor_venda(resultado.getDouble("valor_venda"));
			 v.setTotal_valor(resultado.getDouble("total_valor"));
			 v.setTroco(resultado.getDouble("troco"));
			 v.setValor_entregue(resultado.getDouble("valor_entregue"));
			 
			 Utilizadores ut =  new Utilizadores();
			 ut.setIdutilizador(resultado.getLong("idutilizador"));
			 ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes c = new Clientes();
			 c.setIdClientes(resultado.getLong("idClientes"));
			 c.setCliente(resultado.getString("cliente"));
			 c.setContaCorrente(resultado.getInt("contaCorrente"));
			 c.setUtilizador(ut);
			 
			 FormasPagamentos item = new FormasPagamentos();
			 form.setIdformasPagamento(resultado.getLong("idformasPagamento"));
			 form.setFormasPagamento(resultado.getString("formasPagamentos"));
			 form.setVenda(v);
			 
			 listar.add(item);
		}
		return listar;

	}

}
