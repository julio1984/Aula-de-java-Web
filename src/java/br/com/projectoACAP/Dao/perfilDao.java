package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Perfil;

public class perfilDao {
	
	public void salvar(Perfil perfil)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO perfil ");
		sql.append("(perfil) ");
		sql.append("VALUES(?)");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, perfil.getPerfil());
		pst.executeUpdate();
		
		System.out.println("O perfil foi Registado com sucesso.");
	}
	
	public void editar(Perfil p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE perfil ");
		sql.append("SET perfil = ? ");
		sql.append(" WHERE idperfil = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, p.getPerfil());
		pst.setLong(2, p.getIdperfil());
		
		pst.executeUpdate();
		System.out.println("O perfil foi actualizado com sucesso.");
	}
	
	public void excluir(Perfil perfil) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM perfil ");
		sql.append(" WHERE idperfil = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, perfil.getIdperfil());
		pst.executeUpdate();
		System.out.println("O perfil foi eliminado com sucesso.");
	}
	
	public Perfil buscar_por_id(Perfil p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idperfil, perfil ");
		sql.append("FROM perfil ");
		sql.append("WHERE idperfil = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, p.getIdperfil());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Perfil retorno = null;
		
		
		if(resultado.next()){
			
		 retorno = new Perfil();
			retorno.setIdperfil(resultado.getLong("idperfil"));
			retorno.setPerfil(resultado.getString("perfil"));
			
		}
	return retorno;
		
	}
	
	public ArrayList<Perfil> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM perfil ");
		sql.append("order by perfil desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Perfil> lista = new ArrayList<Perfil>();
		
		while (resultado.next()) {
			Perfil p = new Perfil();
			p.setIdperfil(resultado.getLong("idperfil"));
			p.setPerfil(resultado.getString("perfil"));
			
			lista.add(p);
		}
		
	return lista;
	}
	
	public ArrayList<Perfil> buscar_perfil(Perfil p)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM perfil ");
		sql.append("WHERE perfil like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+p.getPerfil()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Perfil> listar = new ArrayList<Perfil>();
		
		while (resultado.next()) {
			Perfil item = new Perfil();
			item.setIdperfil(resultado.getLong("idperfil"));	
			item.setPerfil(resultado.getString("perfil"));
			listar.add(item);
		}
		return listar;
		
	}
	

}
