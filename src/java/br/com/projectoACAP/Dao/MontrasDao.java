package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Montras;
import br.com.projectoACAP.domain.Utilizadores;


public class MontrasDao {
	public void salvar(Montras mo) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO montras ");
		sql.append("(data_actualizacao, idutilizador) ");
		sql.append("VALUES(?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, mo.getUtilizadores().getIdutilizador());
		pst.setInt(1, mo.getData_actualizacao());
		pst.executeUpdate();

		System.out.println("A montra foi Registado com sucesso.");
	}

	public void editar(Montras mo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE montra ");
		sql.append("SET montra = ? ");
		sql.append(" WHERE idmontra = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, mo.getIdmontra());
		pst.setInt(2, mo.getData_actualizacao());
		pst.setLong(3, mo.getUtilizadores().getIdutilizador());

		pst.executeUpdate();
		System.out.println("O montra foi actualizado com sucesso.");
	}

	public void excluir(Montras mo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM montra ");
		sql.append(" WHERE idmontra = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, mo.getIdmontra());
		pst.executeUpdate();
		System.out.println("O montra foi eliminado com sucesso.");
	}

	public Montras buscar_por_id(Montras mo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idutilizador ");
		sql.append("FROM montras ");
		sql.append("WHERE idmontra = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, mo.getIdmontra());

		ResultSet resultado = pst.executeQuery();

		Montras retorno = null;

		if (resultado.next()) {

			retorno = new Montras();
			retorno.setIdmontra(resultado.getLong("idmontra"));
			

		}
		return retorno;

	}

	public ArrayList<Montras> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT montras.data_actualizacao, utilizadores.utilizador,");
		sql.append("utilizadores.login FROM montras,utilizadores "); 
		sql.append("WHERE montras.idutilizador = utilizadores.idutilizador");
		sql.append("ORDER BY utilizadores.utilizador ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Montras> lista = new ArrayList<Montras>();

		while (resultado.next()) {
			
			
			Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setUtilizador(resultado.getString("utilizador"));
			ut.setLogin(resultado.getString("login"));
			ut.setSenha(resultado.getString("senha"));
			
			Montras mo = new Montras();
			mo.setIdmontra(resultado.getLong("idmontra"));
			mo.setUtilizadores(ut);
			lista.add(mo);
		}

		return lista;
	}

	public ArrayList<Montras> buscar_utilizador(Montras mo)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT utilizadores.login, montras.data_actualizacao FROM montras ");
		sql.append("INNER JOIN utilizadores ON montras.idutilizador=utilizadores.idutilizador");
		sql.append("WHERE idutlizador like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + mo.getUtilizadores().getIdutilizador() + "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Montras> listar = new ArrayList<Montras>();

		while (resultado.next()) {
			
			Utilizadores ut = new Utilizadores();
			ut.setIdutilizador(resultado.getLong("idutilizador"));
			ut.setLogin(resultado.getString("login"));
			ut.setSenha(resultado.getString("senha"));
			
			Montras m = new Montras();
			m.setIdmontra(resultado.getLong("idmontra"));
			m.setData_actualizacao(resultado.getInt("data_actualizacao"));
			m.setUtilizadores(ut);
			
		
			listar.add(m);
		}
		return listar;

	}

}
