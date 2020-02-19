package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Categoria;
public class CategoriaDao {
	public void salvar(Categoria cat) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO categorias ");
		sql.append("(categoria) ");
		sql.append("VALUES(?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, cat.getIdcategoria());
		pst.setString(2, cat.getCategoria());
		
		pst.executeUpdate();

		System.out.println("A categoria foi Registado com sucesso.");
	}

	public void editar(Categoria cat) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE categorias ");
		sql.append("SET categoria = ? ");
		sql.append(" WHERE idcategoria = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, cat.getIdcategoria());
		pst.setString(2, cat.getCategoria());
		
		pst.executeUpdate();
		System.out.println("A categoria foi actualizado com sucesso.");
	}

	public void excluir(Categoria cat) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM categorias ");
		sql.append(" WHERE idcategoria = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, cat.getIdcategoria());
		pst.executeUpdate();
		System.out.println("A categoria foi eliminado com sucesso.");
	}

	public Categoria buscar_por_id(Categoria cat) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM categorias ");
		sql.append("WHERE idcategoria = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, cat.getIdcategoria());
		pst.setString(2, cat.getCategoria());
		
		ResultSet resultado = pst.executeQuery();

		 Categoria retorno = null;

		if (resultado.next()) {
			 
			retorno = new Categoria();
				
			retorno.setIdcategoria(resultado.getLong("idcategoria"));
			retorno.setCategoria(resultado.getString("categoria"));
			

		}
		return retorno;

	}

	public ArrayList<Categoria> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM categorias ");
		sql.append("ORDER BY categorias ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		while (resultado.next()) {

			 Categoria c = new Categoria();
			 c.setIdcategoria(resultado.getLong("idcategoria"));
			 c.setCategoria(resultado.getString("categoria"));
	 
			 lista.add(c);
		}

		return lista;
	}

	public ArrayList<Categoria> buscar_categoria(Categoria cat)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM categorias");
		
		sql.append("WHERE idcategoria like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + cat.getCategoria()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Categoria> listar = new ArrayList<Categoria>();

		while (resultado.next()) {
			
			
			 Categoria c = new Categoria();
			 c.setIdcategoria(resultado.getLong("idcategoria"));
			 c.setCategoria(resultado.getString("categoria"));
	 
			 listar.add(c);
		}
		return listar;

	}

}
