package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;

import br.com.projectoACAP.domain.Provincias;

public class ProvinciasDao {
	public void salvar(Provincias p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO provincias ");
		sql.append("(provincia, idpais) ");
		sql.append("VALUES(?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, p.getProvincia());
		pst.setLong(2, p.getPais().getIdpais());
		pst.executeUpdate();

		System.out.println("O provincia foi Registado com sucesso.");
	}

	public void editar(Provincias p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE provincias ");
		sql.append("SET provincia = ?, idpais = ? ");
		sql.append(" WHERE idprovincia = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, p.getProvincia());
		pst.setLong(2, p.getPais().getIdpais());
		pst.setLong(3, p.getIdprovincia());

		pst.executeUpdate();
		System.out.println("A provincia foi actualizado com sucesso.");
	}

	public void excluir(Provincias p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM provincias ");
		sql.append(" WHERE idprovincia = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, p.getIdprovincia());
		pst.executeUpdate();
		System.out.println("A provincia foi eliminado com sucesso.");
	}

	public Provincias buscar_por_id(Provincias p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idprovincia, provincia, idpais ");
		sql.append("FROM provincias ");
		sql.append("WHERE idprovincia = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, p.getIdprovincia());

		ResultSet resultado = pst.executeQuery();

		Provincias retorno = null;

		if (resultado.next()) {

			retorno = new Provincias();
			retorno.setIdprovincia(resultado.getLong("idprovincia"));
			retorno.setProvincia(resultado.getString("provincia"));

		}
		return retorno;

	}

	public ArrayList<Provincias> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM provincias ");
		sql.append("order by provincia desc ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Provincias> lista = new ArrayList<Provincias>();

		while (resultado.next()) {
			Provincias p = new Provincias();
			p.setIdprovincia(resultado.getLong("idprovincia"));
			p.setProvincia(resultado.getString("provincia"));

			lista.add(p);
		}

		return lista;
	}

	public ArrayList<Provincias> buscar_provincias(Provincias p)
			throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM provincias ");
		sql.append("WHERE provincia like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + p.getProvincia() + "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Provincias> listar = new ArrayList<Provincias>();

		while (resultado.next()) {
			Provincias item = new Provincias();
			item.setIdprovincia(resultado.getLong("idprovincia"));
			item.setProvincia(resultado.getString("provincia"));
			listar.add(item);
		}
		return listar;

	}

}
