package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Fabricantes;
import br.com.projectoACAP.domain.Fornecedores;
import br.com.projectoACAP.domain.Municipios;
import br.com.projectoACAP.domain.Paises;
import br.com.projectoACAP.domain.Provincias;


public class fabricanteDao {
public void salvar(Fabricantes fa)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(fabricantes, idpais, idprovincia, idbairro, idmunicipio, telefone, movel, site, idfornecedor) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,fa.getFabricante());
		pst.setLong(1,fa.getPaises().getIdpais());
		pst.setLong(1,fa.getProvincias().getIdprovincia());
		pst.setLong(1,fa.getMunicipios().getIdmunicipio());
		pst.setLong(4, fa.getTelefone());
		pst.setInt(5,fa.getMovel());
		
		pst.setLong(6, fa.getFornecedores().getIdfornecedor());
		
		pst.executeUpdate();
		
		System.out.println("O fabricante foi Registado com sucesso.");
	}
	
	public void editar(Fabricantes fa) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricantes ");
		sql.append("SET fabricante = ?, idpais = ?, idprovincia = ?, idmunicipio = ?, telefone = ?, movel = ?, site = ?, idfornecedor = ? ");
		sql.append(" WHERE idfabricante = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,fa.getFabricante());
		pst.setLong(1,fa.getPaises().getIdpais());
		pst.setLong(1,fa.getProvincias().getIdprovincia());
		pst.setLong(1,fa.getMunicipios().getIdmunicipio());
		pst.setLong(4, fa.getTelefone());
		pst.setInt(5,fa.getMovel());
		
		pst.executeUpdate();
		System.out.println("O Fabricante foi actualizado com sucesso.");
	}
	
	public void excluir(Fabricantes fa) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricantes ");
		sql.append(" WHERE idfabricante = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, fa.getIdfabricante());
		pst.executeUpdate();
		System.out.println("O fabricante foi eliminado com sucesso.");
	}
	
	public Fabricantes buscar_por_id(Fabricantes fa) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfabricante, idpais, idprovincia, idmunicipio, telefone, movel,site, idfornecedor ");
		sql.append("FROM fabricantes ");
		sql.append("WHERE idfabricantes = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, fa.getIdfabricante());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Fabricantes retorno = null;
		
		
		if(resultado.next()){
			
		 retorno = new Fabricantes();
			retorno.setIdfabricante(resultado.getLong("idfabricante"));
			retorno.setFabricante(resultado.getString(""));
			
			
			
		}
	return retorno;
		
	}
	
	public ArrayList<Fabricantes> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM fabricantes ");
		sql.append("order by fabricantes desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Fabricantes> lista = new ArrayList<Fabricantes>();
		
		while (resultado.next()) {
			Fabricantes fa = new Fabricantes();
			fa.setIdfabricante(resultado.getLong("idfabricante"));
			
			
			lista.add(fa);
		}
		
	return listar();
	}
	
	public ArrayList<Fabricantes> buscar_fabricante(Fabricantes f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM fabricantes ");
		sql.append("WHERE fabricantes like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+f.getIdfabricante()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Fabricantes> listar = new ArrayList<Fabricantes>();
		
		while (resultado.next()) {
			
			Municipios mu = new Municipios();
			mu.setIdmunicipio(resultado.getLong("idmunicipio"));
			mu.setMunicipio(resultado.getString("municipio"));
			
			Provincias p = new Provincias();
			p.setIdprovincia(resultado.getLong("idprovincia"));
			p.setProvincia(resultado.getString("provincia"));
			
			Fornecedores fo = new Fornecedores();
			fo.setIdfornecedor(resultado.getLong("idfornecedor"));
			fo.setFornecedor(resultado.getString("fornecedor"));
			
			Paises pa = new Paises();
			pa.setIdpais(resultado.getLong("idpais"));
			pa.setPais(resultado.getString("pais"));
			pa.setSigla(resultado.getString("sigle"));
			
			Fabricantes fa = new Fabricantes();
			fa.setMovel(resultado.getInt(0));
			fa.setIdfabricante(resultado.getLong("idfabricante"));
			fa.setFabricante(resultado.getString("fabricante"));
			fa.setSite(resultado.getString("site"));
			fa.setMunicipios(mu);
			fa.setProvincias(p);
			fa.setTelefone(resultado.getInt("telefone"));
			fa.setFornecedores(fo);
			fa.setPaises(pa);
			
			
			listar.add(fa);
		}
		return listar;
		
	}

}
