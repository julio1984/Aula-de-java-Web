package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Clientes;
import br.com.projectoACAP.domain.Estado;
import br.com.projectoACAP.domain.Perfil;
import br.com.projectoACAP.domain.Utilizadores;

public class ClientesDao {
	public void salvar(Clientes c) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO clientes ");
		sql.append("(cliente, contaCorrente, idutilizador) ");
		sql.append("VALUES(?, ?, ?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, c.getIdClientes());
		pst.setString(2, c.getCliente());
		pst.setInt(3, c.getContaCorrente());
		pst.setLong(4, c.getUtilizador().getIdutilizador());
		
		pst.executeUpdate();

		System.out.println("O cliente foi Registado com sucesso.");
	}

	public void editar(Clientes c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE clientes ");
		sql.append("SET cliente = ?, contaCorrente = ?, idutilizador = ? ");
		sql.append(" WHERE idcliente = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, c.getIdClientes());
		pst.setString(2, c.getCliente());
		pst.setInt(3, c.getContaCorrente());
		pst.setLong(4, c.getUtilizador().getIdutilizador());

		pst.executeUpdate();
		System.out.println("O cliente foi actualizado com sucesso.");
	}

	public void excluir(Clientes c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM clientes ");
		sql.append(" WHERE idcliente = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, c.getIdClientes());
		pst.executeUpdate();
		System.out.println("O cliente foi eliminado com sucesso.");
	}

	public Clientes buscar_por_id(Clientes c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM clientes INNER JOIN utilizadores ");
		sql.append("ON clientes.idutilizador = utilizadores.idutilizador ");
		sql.append("WHERE idcliente = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, c.getIdClientes());

		ResultSet resultado = pst.executeQuery();

		 Clientes retorno = null;

		if (resultado.next()) {
			 
			retorno = new Clientes();
			
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
			
			
			retorno.setIdClientes(resultado.getLong("idcliente"));
			retorno.setCliente(resultado.getString("cliente"));
			retorno.setContaCorrente(resultado.getInt("contaCorrente"));
			retorno.setUtilizador(ut);

		}
		return retorno;

	}

	public ArrayList<Clientes> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM clientes INNER JOIN utilizadores ");
		
		sql.append("ON clientes.idutilizador = utilizadores.idutilizador ");
		sql.append("ORDER BY cliente ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Clientes> lista = new ArrayList<Clientes>();

		while (resultado.next()) {
			
			 Utilizadores ut =  new Utilizadores();
			 ut.setIdutilizador(resultado.getLong("idutilizador"));
			 ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes c = new Clientes();
			 c.setIdClientes(resultado.getLong("idClientes"));
			 c.setCliente(resultado.getString("cliente"));
			 c.setContaCorrente(resultado.getInt("contaCorrente"));
			 c.setUtilizador(ut);
			
			 
			 lista.add(c);
		}

		return lista;
	}

	public ArrayList<Clientes> buscar_cliente(Clientes c)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM clientes INNER JOIN utilizadores ");
		sql.append("ON clientes.idutilizador = utilizadores.idutilizador ");
		sql.append("WHERE idcliente like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + c.getCliente()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Clientes> listar = new ArrayList<Clientes>();

		while (resultado.next()) {
			
			Utilizadores ut =  new Utilizadores();
			 ut.setIdutilizador(resultado.getLong("idutilizador"));
			 ut.setUtilizador(resultado.getString("utilizador"));
			 
			 Clientes cl1 = new Clientes();
			 cl1.setIdClientes(resultado.getLong("idClientes"));
			 cl1.setCliente(resultado.getString("cliente"));
			 cl1.setContaCorrente(resultado.getInt("contaCorrente"));
			 cl1.setUtilizador(ut);
			
			 
			 listar.add(cl1);
		}
		return listar;

	}


}
