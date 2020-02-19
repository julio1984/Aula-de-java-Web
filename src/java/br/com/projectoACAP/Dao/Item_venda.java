package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Categoria;
import br.com.projectoACAP.domain.Clientes;
import br.com.projectoACAP.domain.ItenVenda;
import br.com.projectoACAP.domain.Produtos;
import br.com.projectoACAP.domain.Utilizadores;
import br.com.projectoACAP.domain.Vendas;


public class Item_venda {
	
	public void salvar(ItenVenda itemvenda) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO item_venda ");
		sql.append("(idproduto, quantidade, idvenda, moeda, desconto) ");
		sql.append("VALUES(?, ?, ?, ?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, itemvenda.getProduto().getIdproduto());
		pst.setInt(2, itemvenda.getQuantidade());
		pst.setLong(3, itemvenda.getVenda().getIdvenda());
		pst.setString(4, itemvenda.getMoeda());
		pst.setDouble(5, itemvenda.getDesconto());
		
		pst.executeUpdate();

		System.out.println("O item de venda foi Registado com sucesso.");
	}

	public void editar(ItenVenda itemvenda) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE item_venda ");
		sql.append("SET idproduto = ?, quantidade = ?, idvenda = ?, moeda = ?, desconto = ? ");
		sql.append(" WHERE idItem_venda = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, itemvenda.getProduto().getIdproduto());
		pst.setInt(2, itemvenda.getQuantidade());
		pst.setLong(3, itemvenda.getVenda().getIdvenda());
		pst.setString(4, itemvenda.getMoeda());
		pst.setDouble(5, itemvenda.getDesconto());

		pst.executeUpdate();
		System.out.println("O item de venda foi actualizado com sucesso.");
	}

	public void excluir(ItenVenda itemvenda) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ItenVenda ");
		sql.append(" WHERE idItem_venda = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, itemvenda.getIdItem_venda());
		pst.executeUpdate();
		System.out.println("O item de venda foi eliminado com sucesso.");
	}

	public ItenVenda buscar_por_id(ItenVenda itemvenda) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM item_venda INNER JOIN produtos INNER JOIN vendas ");
		sql.append("ON item_venda.idproduto = produtos.idproduto AND item_venda.idvenda = vendas.idvenda ");
		sql.append("WHERE idItem_venda = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, itemvenda.getIdItem_venda());

		ResultSet resultado = pst.executeQuery();

		ItenVenda retorno = null;

		if (resultado.next()) {
		
		Categoria cat = new Categoria();
		cat.setIdcategoria(resultado.getLong("idcategoria"));
		cat.setCategoria(resultado.getString("categoria"));
		
		Produtos p = new Produtos();
		p.setIdproduto(resultado.getLong("idproduto"));
		p.setProduto(resultado.getString("produto"));
		p.setCodBarra(resultado.getString("codbarra"));
		p.setQuantidade(resultado.getInt("quantidade"));
		p.setCategoria(cat);
		
		Utilizadores ut =  new Utilizadores();
		ut.setIdutilizador(resultado.getLong("idutilizador"));
		ut.setUtilizador(resultado.getString("utilizador"));
		 
		 Clientes c = new Clientes();
		 c.setIdClientes(resultado.getLong("idClientes"));
		 c.setCliente(resultado.getString("cliente"));
		 c.setContaCorrente(resultado.getInt("contaCorrente"));
		 c.setUtilizador(ut);
		
		Vendas v = new Vendas ();
		v.setCliente(c);
		v.setData_venda(resultado.getInt("data_venda"));
		v.setIdvenda(resultado.getLong("idvenda"));
		v.setProduto(p);
		v.setTotal_valor(resultado.getDouble("total_valor"));
		v.setTroco(resultado.getDouble("troco"));
		v.setUtilizadores(ut);
		v.setValor_entregue(resultado.getDouble("valor_entregue"));
		v.setValor_venda(resultado.getDouble("valor_venda"));
		
		retorno = new ItenVenda();
		retorno.setDesconto(resultado.getDouble("desconto"));
		retorno.setIdItem_venda(resultado.getLong("idItem_venda"));
		retorno.setMoeda(resultado.getString("moeda"));
		retorno.setVenda(v);
		retorno.setProduto(p);
			
		
		}
		return retorno;

	}

	public ArrayList<Item_venda> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM item_venda INNER JOIN produtos INNER JOIN vendas ");
		sql.append("ON item_venda.idproduto = produtos.idproduto AND item_venda.idvenda = vendas.idvenda ");
		sql.append("WHERE idItem_venda = ? ");
		sql.append("ORDER BY produtos ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<ItenVenda> lista = new ArrayList<ItenVenda>();

		while (resultado.next()) {
			
			Categoria cat = new Categoria();
			cat.setIdcategoria(resultado.getLong("idcategoria"));
			cat.setCategoria(resultado.getString("categoria"));
			
			Produtos p = new Produtos();
			p.setIdproduto(resultado.getLong("idproduto"));
			p.setProduto(resultado.getString("produto"));
			p.setCodBarra(resultado.getString("codbarra"));
			p.setQuantidade(resultado.getInt("quantidade"));
			p.setCategoria(cat);
			
			Utilizadores ut =  new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes c = new Clientes();
			 c.setIdClientes(resultado.getLong("idClientes"));
			 c.setCliente(resultado.getString("cliente"));
			 c.setContaCorrente(resultado.getInt("contaCorrente"));
			 c.setUtilizador(ut);
			
			Vendas v = new Vendas ();
			v.setCliente(c);
			v.setData_venda(resultado.getInt("data_venda"));
			v.setIdvenda(resultado.getLong("idvenda"));
			v.setProduto(p);
			v.setTotal_valor(resultado.getDouble("total_valor"));
			v.setTroco(resultado.getDouble("troco"));
			v.setUtilizadores(ut);
			v.setValor_entregue(resultado.getDouble("valor_entregue"));
			v.setValor_venda(resultado.getDouble("valor_venda"));
			
			ItenVenda retorno = new ItenVenda();
			retorno.setDesconto(resultado.getDouble("desconto"));
			retorno.setIdItem_venda(resultado.getLong("idItem_venda"));
			retorno.setMoeda(resultado.getString("moeda"));
			retorno.setVenda(v);
			retorno.setProduto(p);
			 
			 lista.add(retorno);
		}

		return listar();
	}

	public ArrayList<Clientes> buscar_cliente(Clientes c)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM clientes INNER JOIN utilizadores ");
		sql.append("ON clientes.idutilizador = utilizadores.idutilizador ");
		sql.append("WHERE idcliente like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + c.getCliente()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Clientes> listar = new ArrayList<Clientes>();

		while (resultado.next()) {
			
			Utilizadores ut =  new Utilizadores();
			 ut.setIdutilizador(resultado.getLong("idutilizador"));
			 ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes cl1 = new Clientes();
			 cl1.setIdClientes(resultado.getLong("idClientes"));
			 cl1.setCliente(resultado.getString("cliente"));
			 cl1.setContaCorrente(resultado.getInt("contaCorrente"));
			 cl1.setUtilizador(ut);
			
			 
			 listar.add(cl1);
		}
		return listar;

	}
}
