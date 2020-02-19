package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Categoria;
import br.com.projectoACAP.domain.Fabricantes;
import br.com.projectoACAP.domain.FormasPagamentos;
import br.com.projectoACAP.domain.Fornecedores;
import br.com.projectoACAP.domain.Montras;
import br.com.projectoACAP.domain.Municipios;
import br.com.projectoACAP.domain.Paises;
import br.com.projectoACAP.domain.Produtos;
import br.com.projectoACAP.domain.Provincias;
import br.com.projectoACAP.domain.Utilizadores;
import br.com.projectoACAP.domain.Vendas;
import br.com.projectoACAP.domain.Clientes;

public class vendaDao {
	public void salvar(Vendas v) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO vendas ");
		sql.append("(idvenda, idcliente, idutilizador, valor_entregue,) ");
		sql.append("valor_venda, idproduto, troco, data_venda, ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, v.getIdvenda());
		pst.setLong(2, v.getCliente().getIdClientes());
		pst.setLong(3, v.getUtilizadores().getIdutilizador());
		pst.setDouble(4, v.getValor_entregue());
		pst.setDouble(5, v.getValor_venda());
		pst.setDouble(6, v.getTotal_valor());
		pst.setDouble(7, v.getTotal_venda());
		pst.setDouble(8, v.getTroco());
		pst.setFloat(9, v.getData_venda());
		
		

		pst.executeUpdate();

		System.out.println("A venda foi Registado com sucesso.");
	}

	public void editar(Vendas v) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE venda ");
		sql.append("SET idcliente = ?, idutilizador = ?, valor_entregue = ?, ");
		sql.append("total_venda = ?, valor_venda = ?, idproduto = ?, troco = ?, data_venda = ? ");
		sql.append(" WHERE idvenda = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, v.getIdvenda());
		pst.setLong(2, v.getCliente().getIdClientes());
		pst.setLong(3, v.getUtilizadores().getIdutilizador());
		pst.setDouble(4, v.getValor_entregue());
		pst.setDouble(5, v.getValor_venda());
		pst.setDouble(6, v.getTotal_valor());
		pst.setDouble(7, v.getTotal_venda());
		pst.setDouble(8, v.getTroco());
		pst.setFloat(9, v.getData_venda());

		pst.executeUpdate();
		System.out.println("A venda foi actualizado com sucesso.");
	}

	public void excluir(Vendas v) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM vendas ");
		sql.append(" WHERE idvenda = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, v.getIdvenda());
		pst.executeUpdate();
		System.out.println("A venda foi eliminado com sucesso.");
	}

	public Vendas buscar_por_id(Vendas v) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT clientes.Cliente, produtos.produto, utilizadores.utilizador, ");
		sql.append("vendas.valor_entregue, vendas.total_venda, vendas.valor_venda, ");
		sql.append("vendas.troco, vendas.data_venda FROM vendas INNER JOIN clientes INNER ");
		sql.append("JOIN utilizadores INNER JOIN produtos");
		sql.append("ON vendas.idcliente = vendas.idvenda AND ");
		sql.append("vendas.idutilizador = utilizadores.idutilizador AND ");
		sql.append("vendas.idproduto = produtos.idproduto ");
		sql.append("WHERE idpvenda = ? ");
		   
		 
		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, v.getIdvenda());

		ResultSet resultado = pst.executeQuery();
		
		Vendas retorno = null;

		if (resultado.next()) {

			Produtos produto = new Produtos();
			
			
			Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setUtilizador(resultado.getString("utilizador"));

			Clientes c = new Clientes();
			c.setIdClientes(resultado.getLong("idClientes"));
			c.setCliente(resultado.getString("cliente"));
			c.setContaCorrente(resultado.getInt("contaCorrente"));
			c.setUtilizador(ut);

			retorno = new Vendas();
			retorno.setCliente(c);
			retorno.setUtilizadores(ut);
			retorno.setValor_entregue(resultado.getDouble("valor_entregue"));
			retorno.setTotal_venda(resultado.getDouble("total_venda"));
			retorno.setValor_venda(resultado.getDouble("valor_venda"));
			retorno.setProduto(produto);
			retorno.setTroco(resultado.getDouble("troco"));
			retorno.setData_venda(resultado.getInt("data_venda"));
			
			
		}
		return retorno;
	}

	public ArrayList<Produtos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT clientes.Cliente, produtos.produto, utilizadores.utilizador, ");
		sql.append("vendas.valor_entregue, vendas.total_venda, vendas.valor_venda, ");
		sql.append("vendas.troco, vendas.data_venda FROM vendas INNER JOIN clientes INNER ");
		sql.append("JOIN utilizadores INNER JOIN produtos");
		sql.append("ON vendas.idcliente = vendas.idvenda AND ");
		sql.append("vendas.idutilizador = utilizadores.idutilizador AND ");
		sql.append("vendas.idproduto = produtos.idproduto ");
		sql.append("WHERE idpvenda = ? ");
	
		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Vendas> lista = new ArrayList<Vendas>();

		while (resultado.next()) {
			
			Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setUtilizador(resultado.getString("utilizador"));

			Clientes c = new Clientes();
			c.setIdClientes(resultado.getLong("idClientes"));
			c.setCliente(resultado.getString("cliente"));
			c.setContaCorrente(resultado.getInt("contaCorrente"));
			c.setUtilizador(ut);

			
			Montras mo = new Montras();
			mo.setData_actualizacao(resultado.getInt("data_actulizacao"));
			mo.setIdmontra(resultado.getLong("idmontra"));
			mo.setUtilizadores(ut);
			
			Vendas v = new Vendas();
			v.setCliente(c);
			v.setData_venda(resultado.getInt("data_venda"));
			v.setIdvenda(resultado.getLong("idvenda"));
			v.setTotal_valor(resultado.getDouble("total_valor"));
			v.setTroco(resultado.getDouble("troco"));
			v.setUtilizadores(ut);
			v.setValor_entregue(resultado.getDouble("valor_entregue"));
			v.setValor_venda(resultado.getDouble("valor_venda"));
			
			Categoria cat = new Categoria();
			cat.setIdcategoria(resultado.getLong("idcategoria"));
			cat.setCategoria(resultado.getString("categoria"));
			
			FormasPagamentos formaspag = new FormasPagamentos();
			formaspag.setIdformasPagamento(resultado.getLong("idformasPagamento"));
			formaspag.setFormasPagamento(resultado.getString("formaspagamento"));
			formaspag.setVenda(v);
            
			Fornecedores fornecedor =  new Fornecedores();
			fornecedor.setFornecedor(resultado.getString("fornecedor"));
			fornecedor.setIdfornecedor(resultado.getLong("idfornecedor"));
			
			Municipios municipio = new Municipios();
			municipio.setIdmunicipio(resultado.getLong("idmunicipio"));
			municipio.setMunicipio(resultado.getString("municipio"));
			
			Paises pais  =  new Paises();
			pais.setIdpais(resultado.getLong("idpais"));
			pais.setPais(resultado.getString("pais"));
			pais.setSigla(resultado.getString("sigle"));
			
			Provincias provincia = new Provincias();
			provincia.setIdprovincia(resultado.getLong("idprovincia"));
			provincia.setProvincia(resultado.getString("provincia"));
			provincia.setPais(pais);
			
			Fabricantes fabricante = new Fabricantes();
			fabricante.setIdfabricante(resultado.getLong("idfabricante"));
			fabricante.setFabricante(resultado.getString("fabricante"));
			fabricante.setFornecedores(fornecedor);
			fabricante.setMovel(resultado.getInt("movel"));
			fabricante.setMunicipios(municipio);
			fabricante.setPaises(pais);
			fabricante.setProvincias(provincia);
			fabricante.setSite(resultado.getString("site"));
			fabricante.setTelefone(resultado.getInt("telefone"));

			Produtos prod = new Produtos();
			prod.setIdproduto(resultado.getLong("idproduto"));
			prod.setProduto(resultado.getString("produto"));
			prod.setCodBarra(resultado.getString("codbarra"));
			prod.setQuantidade(resultado.getInt("quantidade"));
			prod.setMontra(mo);
			prod.setCliente(c);
			prod.setPreco(resultado.getDouble("preco"));
			prod.setFormasPagamentos(formaspag);
			prod.setFabricante(fabricante);
			prod.setData_expiracao(resultado.getInt("data_expiracao"));
			prod.setFoto(resultado.getString("foto"));
			prod.setValorFinal(resultado.getDouble("valorFinal"));
			prod.setCategoria(cat);
			
			lista.add(v);
		}

		return listar();
	}
	public ArrayList<Vendas> buscar_utilizadores(Vendas v)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT clientes.Cliente, produtos.produto, utilizadores.utilizador, ");
		sql.append("vendas.valor_entregue, vendas.total_venda, vendas.valor_venda, ");
		sql.append("vendas.troco, vendas.data_venda FROM vendas INNER JOIN clientes INNER ");
		sql.append("JOIN utilizadores INNER JOIN produtos");
		sql.append("ON vendas.idcliente = vendas.idvenda AND ");
		sql.append("vendas.idutilizador = utilizadores.idutilizador AND ");
		sql.append("vendas.idproduto = produtos.idproduto ");
		
		sql.append("WHERE idvenda like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + v.getUtilizadores().getLogin()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Vendas> listar = new ArrayList<Vendas>();

		while (resultado.next()) {
			
			Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setUtilizador(resultado.getString("utilizador"));

			Clientes c = new Clientes();
			c.setIdClientes(resultado.getLong("idClientes"));
			c.setCliente(resultado.getString("cliente"));
			c.setContaCorrente(resultado.getInt("contaCorrente"));
			c.setUtilizador(ut);

			
			Montras mo = new Montras();
			mo.setData_actualizacao(resultado.getInt("data_actulizacao"));
			mo.setIdmontra(resultado.getLong("idmontra"));
			mo.setUtilizadores(ut);
			
			Vendas vend = new Vendas();
			v.setCliente(c);
			v.setData_venda(resultado.getInt("data_venda"));
			v.setIdvenda(resultado.getLong("idvenda"));
			v.setTotal_valor(resultado.getDouble("total_valor"));
			v.setTroco(resultado.getDouble("troco"));
			v.setUtilizadores(ut);
			v.setValor_entregue(resultado.getDouble("valor_entregue"));
			v.setValor_venda(resultado.getDouble("valor_venda"));
			
			Categoria cat = new Categoria();
			cat.setIdcategoria(resultado.getLong("idcategoria"));
			cat.setCategoria(resultado.getString("categoria"));
			
			FormasPagamentos formaspag = new FormasPagamentos();
			formaspag.setIdformasPagamento(resultado.getLong("idformasPagamento"));
			formaspag.setFormasPagamento(resultado.getString("formaspagamento"));
			formaspag.setVenda(v);
            
			Fornecedores fornecedor =  new Fornecedores();
			fornecedor.setFornecedor(resultado.getString("fornecedor"));
			fornecedor.setIdfornecedor(resultado.getLong("idfornecedor"));
			
			Municipios municipio = new Municipios();
			municipio.setIdmunicipio(resultado.getLong("idmunicipio"));
			municipio.setMunicipio(resultado.getString("municipio"));
			
			Paises pais  =  new Paises();
			pais.setIdpais(resultado.getLong("idpais"));
			pais.setPais(resultado.getString("pais"));
			pais.setSigla(resultado.getString("sigle"));
			
			Provincias provincia = new Provincias();
			provincia.setIdprovincia(resultado.getLong("idprovincia"));
			provincia.setProvincia(resultado.getString("provincia"));
			provincia.setPais(pais);
			
			Fabricantes fabricante = new Fabricantes();
			fabricante.setIdfabricante(resultado.getLong("idfabricante"));
			fabricante.setFabricante(resultado.getString("fabricante"));
			fabricante.setFornecedores(fornecedor);
			fabricante.setMovel(resultado.getInt("movel"));
			fabricante.setMunicipios(municipio);
			fabricante.setPaises(pais);
			fabricante.setProvincias(provincia);
			fabricante.setSite(resultado.getString("site"));
			fabricante.setTelefone(resultado.getInt("telefone"));

			Produtos prod = new Produtos();
			prod.setIdproduto(resultado.getLong("idproduto"));
			prod.setProduto(resultado.getString("produto"));
			prod.setCodBarra(resultado.getString("codbarra"));
			prod.setQuantidade(resultado.getInt("quantidade"));
			prod.setMontra(mo);
			prod.setCliente(c);
			prod.setPreco(resultado.getDouble("preco"));
			prod.setFormasPagamentos(formaspag);
			prod.setFabricante(fabricante);
			prod.setData_expiracao(resultado.getInt("data_expiracao"));
			prod.setFoto(resultado.getString("foto"));
			prod.setValorFinal(resultado.getDouble("valorFinal"));
			prod.setCategoria(cat);

			listar.add(vend);
		}
		return listar;

	}

}
