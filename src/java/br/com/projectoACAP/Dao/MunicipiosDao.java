package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Municipios;


public class MunicipiosDao {
public void salvar(Municipios m)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO municipios ");
		sql.append("(municipio) ");
		sql.append("VALUES(?)");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, m.getMunicipio());
		pst.executeUpdate();
		
		System.out.println("O municipio foi Registado com sucesso.");
	}
	
	public void editar(Municipios m) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE municipios ");
		sql.append("SET municipio = ? ");
		sql.append(" WHERE idmunicipio = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, m.getMunicipio());
		pst.setLong(2, m.getIdmunicipio());
		
		pst.executeUpdate();
		System.out.println("O municipio foi actualizado com sucesso.");
	}
	
	public void excluir(Municipios m) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM municipios ");
		sql.append(" WHERE idmunicipio = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, m.getIdmunicipio());
		pst.executeUpdate();
		System.out.println("O municipio foi eliminado com sucesso.");
	}
	
	public Municipios buscar_por_id(Municipios m) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idmunicipio, municipio ");
		sql.append("FROM municipios ");
		sql.append("WHERE idmunicipio = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, m.getIdmunicipio());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Municipios retorno = null;
		
		
		if(resultado.next()){
			
		    retorno = new Municipios();
			retorno.setIdmunicipio(resultado.getLong("idmunicipio"));
			retorno.setMunicipio(resultado.getString("municipio"));
			
		}
	return retorno;
		
	}
	
	public ArrayList<Municipios> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idmunicipio, municipio FROM municipios ");
		sql.append("order by municipio desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Municipios> retorno = new ArrayList<Municipios>();
		
		while (resultado.next()) {
			Municipios m = new Municipios();
			m.setIdmunicipio(resultado.getLong("idmunicipio"));
			m.setMunicipio(resultado.getString("municipio"));
			
			retorno.add(m);
		}
		
	return retorno;
	}
	
	public ArrayList<Municipios> buscar_municipio(Municipios m)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM municipios ");
		sql.append("WHERE municipio like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+m.getMunicipio()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Municipios> listar = new ArrayList<Municipios>();
		
		while (resultado.next()) {
			Municipios item = new Municipios();
			item.setIdmunicipio(resultado.getLong("idmunicipio"));	
			item.setMunicipio(resultado.getString("municipio"));
			listar.add(item);
		}
		return listar;
		
	}
	

}
