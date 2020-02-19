package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Categoria;
import br.com.projectoACAP.domain.Clientes;
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

public class ProdutosDao {
	public void salvar(Produtos p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(produto, codbarra, quantidade, idcategoria,) ");
		sql.append("idmontra, idcliente, preco, idformasPagamento, ");
		sql.append("idfabricante, data_expiracao, imagem, valor_final");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, p.getProduto());
		pst.setString(2, p.getCodBarra());
		pst.setInt(3, p.getQuantidade());
		pst.setLong(4, p.getCategoria().getIdcategoria());
		pst.setLong(5, p.getMontra().getIdmontra());
		pst.setLong(6, p.getCliente().getIdClientes());
		pst.setDouble(7, p.getPreco());
		pst.setLong(8, p.getFormasPagamentos().getIdformasPagamento());
		pst.setLong(9, p.getFabricante().getIdfabricante());
		pst.setInt(10, p.getData_expiracao());
		pst.setString(11, p.getFoto());
		pst.setDouble(12, p.getValorFinal());

		pst.executeUpdate();

		System.out.println("O produto foi Registado com sucesso.");
	}

	public void editar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET idproduto = ?, quantidade = ?, idvenda = ?, moeda = ?, desconto = ? ");
		sql.append(" WHERE idItem_venda = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, p.getProduto());
		pst.setString(2, p.getCodBarra());
		pst.setInt(3, p.getQuantidade());
		pst.setLong(4, p.getCategoria().getIdcategoria());
		pst.setLong(5, p.getMontra().getIdmontra());
		pst.setLong(6, p.getCliente().getIdClientes());
		pst.setDouble(7, p.getPreco());
		pst.setLong(8, p.getFormasPagamentos().getIdformasPagamento());
		pst.setLong(9, p.getFabricante().getIdfabricante());
		pst.setInt(10, p.getData_expiracao());
		pst.setString(11, p.getFoto());
		pst.setDouble(12, p.getValorFinal());

		pst.executeUpdate();
		System.out.println("O produto foi actualizado com sucesso.");
	}

	public void excluir(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append(" WHERE idproduto = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, p.getIdproduto());
		pst.executeUpdate();
		System.out.println("O produto foi eliminado com sucesso.");
	}

	public Produtos buscar_por_id(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT produtos.produto, categorias.categoria, ");
		sql.append("montras.data_actualizacao, formaspagamentos.formasPagamento, ");
		sql.append("fabricantes.fabricante, fabricantes.idpais, fabricantes.telefone, ");
		sql.append("clientes.Cliente FROM produtos INNER JOIN montras INNER JOIN ");
		sql.append("formaspagamentos INNER JOIN fabricantes INNER JOIN categorias INNER ");
		sql.append("JOIN clientes ON (produtos.idcategoria = categorias.idcategoria AND ");
		sql.append("produtos.idmontra = montras.idmontra AND produtos.idcliente = clientes.idClientes ");
		sql.append("AND produtos.idformaPagamento = formaspagamentos.idformasPagamento AND ");
		sql.append("produtos.idfabricante = fabricantes.idfabricante)");
		sql.append("WHERE idproduto = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, p.getIdproduto());

		ResultSet resultado = pst.executeQuery();
		
		Produtos retorno = null;

		if (resultado.next()) {

			Categoria cat = new Categoria();
			cat.setIdcategoria(resultado.getLong("idcategoria"));
			cat.setCategoria(resultado.getString("categoria"));

			retorno = new Produtos();
			retorno.setIdproduto(resultado.getLong("idproduto"));
			retorno.setProduto(resultado.getString("produto"));
			retorno.setCodBarra(resultado.getString("codbarra"));
			retorno.setQuantidade(resultado.getInt("quantidade"));
			retorno.setCategoria(cat);
			
		}
		return retorno;
	}

	public ArrayList<Produtos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT produtos.produto, categorias.categoria, ");
		sql.append("montras.data_actualizacao, formaspagamentos.formasPagamento, ");
		sql.append("fabricantes.fabricante, fabricantes.idpais, fabricantes.telefone, ");
		sql.append("clientes.Cliente FROM produtos INNER JOIN montras INNER JOIN ");
		sql.append("formaspagamentos INNER JOIN fabricantes INNER JOIN categorias INNER ");
		sql.append("JOIN clientes ON (produtos.idcategoria = categorias.idcategoria AND ");
		sql.append("produtos.idmontra = montras.idmontra AND produtos.idcliente = clientes.idClientes ");
		sql.append("AND produtos.idformaPagamento = formaspagamentos.idformasPagamento AND ");
		sql.append("produtos.idfabricante = fabricantes.idfabricante)");
		sql.append("WHERE idproduto = ? ");
		sql.append("ORDER BY produtos ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

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

			Produtos retorno = new Produtos();
			retorno.setIdproduto(resultado.getLong("idproduto"));
			retorno.setProduto(resultado.getString("produto"));
			retorno.setCodBarra(resultado.getString("codbarra"));
			retorno.setQuantidade(resultado.getInt("quantidade"));
			retorno.setMontra(mo);
			retorno.setCliente(c);
			retorno.setPreco(resultado.getDouble("preco"));
			retorno.setFormasPagamentos(formaspag);
			retorno.setFabricante(fabricante);
			retorno.setData_expiracao(resultado.getInt("data_expiracao"));
			retorno.setFoto(resultado.getString("foto"));
			retorno.setValorFinal(resultado.getDouble("valorFinal"));
			retorno.setCategoria(cat);

			lista.add(retorno);
		}

		return listar();
	}
	public ArrayList<Produtos> buscar_produtos(Produtos p)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT produtos.produto, categorias.categoria, ");
		sql.append("montras.data_actualizacao, formaspagamentos.formasPagamento, ");
		sql.append("fabricantes.fabricante, fabricantes.idpais, fabricantes.telefone, ");
		sql.append("clientes.Cliente FROM produtos INNER JOIN montras INNER JOIN ");
		sql.append("formaspagamentos INNER JOIN fabricantes INNER JOIN categorias INNER ");
		sql.append("JOIN clientes ON (produtos.idcategoria = categorias.idcategoria AND ");
		sql.append("produtos.idmontra = montras.idmontra AND produtos.idcliente = clientes.idClientes ");
		sql.append("AND produtos.idformaPagamento = formaspagamentos.idformasPagamento AND ");
		sql.append("produtos.idfabricante = fabricantes.idfabricante)");
		sql.append("WHERE idproduto like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + p.getProduto()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Produtos> listar = new ArrayList<Produtos>();

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

			Produtos retorno = new Produtos();
			retorno.setIdproduto(resultado.getLong("idproduto"));
			retorno.setProduto(resultado.getString("produto"));
			retorno.setCodBarra(resultado.getString("codbarra"));
			retorno.setQuantidade(resultado.getInt("quantidade"));
			retorno.setMontra(mo);
			retorno.setCliente(c);
			retorno.setPreco(resultado.getDouble("preco"));
			retorno.setFormasPagamentos(formaspag);
			retorno.setFabricante(fabricante);
			retorno.setData_expiracao(resultado.getInt("data_expiracao"));
			retorno.setFoto(resultado.getString("foto"));
			retorno.setValorFinal(resultado.getDouble("valorFinal"));
			retorno.setCategoria(cat);

			listar.add(retorno);
		}
		return listar;

	}
}
