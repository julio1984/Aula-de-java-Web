package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Fornecedores;
import br.com.projectoACAP.domain.Paises;

public class FornecedoresDao {
public void salvar(Fornecedores f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(fornecedores) ");
		sql.append("VALUES(?) ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,f.getFornecedor());
		
		
		pst.executeUpdate();
		
		System.out.println("O fornecedor foi Registado com sucesso.");
	}
	
	public void editar(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET fornecedor = ? ");
		sql.append(" WHERE idfornecedor = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, f.getFornecedor());
		
		
		pst.executeUpdate();
		System.out.println("O Fornecedor foi actualizado com sucesso.");
	}
	
	public void excluir(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append(" WHERE idfornecedor = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, f.getIdfornecedor());
		pst.executeUpdate();
		System.out.println("O fornecedor foi eliminado com sucesso.");
	}
	
	public Fornecedores buscar_por_id(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedor, fornecedor ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE idfornecedor = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, f.getIdfornecedor());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Fornecedores retorno = null;
		
		
		if(resultado.next()){
			
		 retorno = new Fornecedores();
			retorno.setIdfornecedor(resultado.getLong("idfornecedor"));
			retorno.setFornecedor(resultado.getString("fornecedor"));
			
			
		}
	return retorno;
		
	}
	
	public ArrayList<Paises> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM fornecedores ");
		sql.append("order by fornecedor desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();
		
		while (resultado.next()) {
			Fornecedores p = new Fornecedores();
			p.setIdfornecedor(resultado.getLong("idfornecedor"));
			p.setFornecedor(resultado.getString("fornecedor"));
			
			lista.add(p);
		}
		
	return listar();
	}
	
	public ArrayList<Fornecedores> buscar_pais(Fornecedores f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM fornecedores ");
		sql.append("WHERE fornecedor like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+f.getFornecedor()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Fornecedores> listar = new ArrayList<Fornecedores>();
		
		while (resultado.next()) {
			Fornecedores item = new Fornecedores();
			item.setIdfornecedor(resultado.getLong("idfornecedor"));	
			item.setFornecedor(resultado.getString("fornecedor"));
			listar.add(item);
		}
		return listar;
		
	}
	

}
