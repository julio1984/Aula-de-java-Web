package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.*;


public class PaisesDao {

public void salvar(Paises pa)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO paises ");
		sql.append("(pais, sigla) ");
		sql.append("VALUES(?, ?) ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,pa.getPais());
		pst.setString(2, pa.getSigla());
		pst.executeUpdate();
		
		System.out.println("O pais foi Registado com sucesso.");
	}
	
	public void editar(Paises pa) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE paises ");
		sql.append("SET pais = ?, sigla = ? ");
		sql.append(" WHERE idpais = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, pa.getPais());
		pst.setString(2, pa.getSigla());
		pst.setLong(3, pa.getIdpais());
		
		pst.executeUpdate();
		System.out.println("O pais foi actualizado com sucesso.");
	}
	
	public void excluir(Paises pa) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM paiese ");
		sql.append(" WHERE idpais = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, pa.getIdpais());
		pst.executeUpdate();
		System.out.println("O pais foi eliminado com sucesso.");
	}
	
	public Paises buscar_por_id(Paises pa) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idpais, pais ");
		sql.append("FROM paises ");
		sql.append("WHERE idpais = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, pa.getIdpais());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Paises retorno = null;
		
		
		if(resultado.next()){
			
		 retorno = new Paises();
			retorno.setIdpais(resultado.getLong("idpais"));
			retorno.setPais(resultado.getString("pais"));
			retorno.setSigla(resultado.getString("sigla"));
			
		}
	return retorno;
		
	}
	
	public ArrayList<Paises> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM paises ");
		sql.append("order by pais desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Paises> lista = new ArrayList<Paises>();
		
		while (resultado.next()) {
			Paises p = new Paises();
			p.setIdpais(resultado.getLong("idpais"));
			p.setPais(resultado.getString("pais"));
			
			lista.add(p);
		}
		
	return lista;
	}
	
	public ArrayList<Paises> buscar_pais(Paises p)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM paises ");
		sql.append("WHERE pais like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+p.getPais()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Paises> listar = new ArrayList<Paises>();
		
		while (resultado.next()) {
			Paises item = new Paises();
			item.setIdpais(resultado.getLong("idpais"));	
			item.setPais(resultado.getString("pais"));
			listar.add(item);
		}
		return listar;
		
	}
	
}
