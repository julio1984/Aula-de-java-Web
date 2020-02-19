package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Estado;


public class estadoDao {
public void salvar(Estado es)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO estados ");
		sql.append("(estado) ");
		sql.append("VALUES(?) ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,es.getEstado());
	
		pst.executeUpdate();
		
		System.out.println("O estado foi Registado com sucesso.");
	}
	
	public void editar(Estado es) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE estados ");
		
		sql.append(" WHERE idestado = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, es.getEstado());
		
		
		pst.executeUpdate();
		System.out.println("O estado foi actualizado com sucesso.");
	}
	
	public void excluir(Estado es) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM estados ");
		sql.append(" WHERE idestado = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, es.getIdestado());
		pst.executeUpdate();
		System.out.println("O estado foi eliminado com sucesso.");
	}
	
	public Estado buscar_por_id(Estado es) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idestado, estado ");
		sql.append("FROM estados ");
		sql.append("WHERE idestado = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, es.getIdestado());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Estado retorno = null;
		
		
		if(resultado.next()){
			
		 retorno = new Estado();
			retorno.setIdestado(resultado.getLong("idestado"));
			retorno.setEstado(resultado.getString("estado"));
			
			
		}
	return retorno;
		
	}
	
	public ArrayList<Estado> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM estados ");
		sql.append("order by estado desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Estado> lista = new ArrayList<Estado>();
		
		while (resultado.next()) {
			Estado es = new Estado();
			es.setIdestado(resultado.getLong("idestado"));
			es.setEstado(resultado.getString("estado"));
			
			lista.add(es);
		}
		
	return lista;
	}
	
	public ArrayList<Estado> buscar_pais(Estado es)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM estados ");
		sql.append("WHERE estado like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+es.getEstado()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Estado> listar = new ArrayList<Estado>();
		
		while (resultado.next()) {
			Estado item = new Estado();
			item.setIdestado(resultado.getLong("estado"));	
			item.setEstado(resultado.getString("estado"));
			listar.add(item);
		}
		return listar;
		
	}

}
