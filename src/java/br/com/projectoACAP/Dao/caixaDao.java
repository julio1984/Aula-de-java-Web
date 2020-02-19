package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Caixa;
import br.com.projectoACAP.domain.Estado;
import br.com.projectoACAP.domain.Perfil;
import br.com.projectoACAP.domain.Utilizadores;
import br.com.projectoACAP.domain.Vendas;

public class caixaDao {
	
public void salvar(Caixa cai)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO caixas ");
		sql.append("(valores, idvenda, datafeixo, idutilizador) ");
		sql.append("VALUES(?, ?, ?, ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setDouble(1,cai.getValor());
		pst.setLong(2,cai.getVenda().getIdvenda());
		pst.setDate(3, (Date) cai.getDatafeixo());
		pst.setLong(4, cai.getUtilizadores().getIdutilizador());
		
		pst.executeUpdate();
		
		System.out.println("O valor do caixa foi Registado com sucesso.");
	}
	
	public void editar(Caixa cai) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE caixas ");
		sql.append("SET valore = ?, idvenda = ?, datafeixo = ?, idutilizador = ? ");
		sql.append(" WHERE idcaixa = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setDouble(1,cai.getValor());
		pst.setLong(2,cai.getVenda().getIdvenda());
		pst.setDate(3, (Date) cai.getDatafeixo());
		pst.setLong(4, cai.getUtilizadores().getIdutilizador());
		pst.setLong(4, cai.getIdcaixa());
		
		pst.executeUpdate();
		System.out.println("O caixa foi actualizado com sucesso.");
	}
	
	public void excluir(Caixa cai) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM caixas ");
		sql.append(" WHERE idcaixa = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, cai.getIdcaixa());
		pst.executeUpdate();
		System.out.println("O valor do caixa foi eliminado com sucesso.");
	}
	
	public Caixa buscar_por_id(Caixa cai) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idcaixa, valores, idvenda, datafeixo, idutilizador ");
		sql.append("FROM caixa ");
		sql.append("WHERE idcaixa = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, cai.getIdcaixa());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Caixa retorno = null;

		if(resultado.next()){
			
		 retorno = new Caixa();
		
		 
		    Perfil p = new Perfil();
			p.setIdperfil(resultado.getLong("idperfil"));
			p.setPerfil(resultado.getString("perfil"));
		
			Estado es = new Estado();
			es.setIdestado(resultado.getLong("idestado"));
			es.setEstado(resultado.getString("estado"));
			
		 
		    Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setLogin(resultado.getString("login"));
			ut.setSenha(resultado.getString("senha"));
			ut.setPerfil(p);
			ut.setEstado(es);
			
			Vendas v = new Vendas();
			v.setData_venda(resultado.getInt("data_venda"));
			v.setIdvenda(resultado.getLong("idvenda"));
			v.setValor_venda(resultado.getDouble("valor_venda"));
			v.setTotal_valor(resultado.getDouble("total_valor"));
			v.setTroco(resultado.getDouble("troco"));
			v.setValor_entregue(resultado.getDouble("valor_entregue"));
			
			retorno.setIdcaixa(resultado.getLong("idcaixa"));
	        retorno.setValor(resultado.getDouble("valores"));
	        retorno.setDatafeixo(resultado.getDate("datafeixo"));
	        retorno.setVenda(v);
	        retorno.setUtilizadores(ut);
			
			
			
		}
	return retorno;
		
	}
	
	public ArrayList<Caixa> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT utilizadores.utilizador, caixa.valores, ");
		sql.append("WHERE caixa.idvenda=vendas.idvenda AND caixa.idutilizador=utilizadores.idutilizador ");
		sql.append("vendas.valor_venda FROM caixa, vendas, utilizadores ");
		sql.append("order by valor desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Caixa> lista = new ArrayList<Caixa>();
		
		while (resultado.next()) {
			    Perfil p = new Perfil();
				p.setIdperfil(resultado.getLong("idperfil"));
				p.setPerfil(resultado.getString("perfil"));
			
				Estado es = new Estado();
				es.setIdestado(resultado.getLong("idestado"));
				es.setEstado(resultado.getString("estado"));
				
			 
			    Utilizadores ut = new Utilizadores();
				ut.setIdutilizador(resultado.getLong("idutilizador"));
				ut.setLogin(resultado.getString("login"));
				ut.setSenha(resultado.getString("senha"));
				ut.setPerfil(p);
				ut.setEstado(es);
				
				Vendas v = new Vendas();
				v.setData_venda(resultado.getInt("data_venda"));
				v.setIdvenda(resultado.getLong("idvenda"));
				v.setValor_venda(resultado.getDouble("valor_venda"));
				v.setTotal_valor(resultado.getDouble("total_valor"));
				v.setTroco(resultado.getDouble("troco"));
				v.setValor_entregue(resultado.getDouble("valor_entregue"));
				
				Caixa retorno = new Caixa();
				retorno.setIdcaixa(resultado.getLong("idcaixa"));
		        retorno.setValor(resultado.getDouble("valores"));
		        retorno.setDatafeixo(resultado.getDate("datafeixo"));
		        retorno.setVenda(v);
		        retorno.setUtilizadores(ut);
			
			lista.add(retorno);
		}
		
	return listar();
	}
	
	public ArrayList<Caixa> buscar_valor(Caixa cai)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM caixas ");
		sql.append("WHERE valor like ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%"+cai.getValor()+"%");
		
		ResultSet resultado = pst.executeQuery();
		ArrayList<Caixa> listar = new ArrayList<Caixa>();
		
		while (resultado.next()) {
			
			Perfil p = new Perfil();
			p.setIdperfil(resultado.getLong("idperfil"));
			p.setPerfil(resultado.getString("perfil"));
		
			Estado es = new Estado();
			es.setIdestado(resultado.getLong("idestado"));
			es.setEstado(resultado.getString("estado"));
			
		 
		    Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setLogin(resultado.getString("login"));
			ut.setSenha(resultado.getString("senha"));
			ut.setPerfil(p);
			ut.setEstado(es);
			
			Vendas v = new Vendas();
			v.setData_venda(resultado.getInt("data_venda"));
			v.setIdvenda(resultado.getLong("idvenda"));
			v.setValor_venda(resultado.getDouble("valor_venda"));
			v.setTotal_valor(resultado.getDouble("total_valor"));
			v.setTroco(resultado.getDouble("troco"));
			v.setValor_entregue(resultado.getDouble("valor_entregue"));
			
			Caixa retorno = new Caixa();
			retorno.setIdcaixa(resultado.getLong("idcaixa"));
	        retorno.setValor(resultado.getDouble("valores"));
	        retorno.setDatafeixo(resultado.getDate("datafeixo"));
	        retorno.setVenda(v);
	        retorno.setUtilizadores(ut);
			
			listar.add(retorno);
		}
		return listar;
		
	}


}
