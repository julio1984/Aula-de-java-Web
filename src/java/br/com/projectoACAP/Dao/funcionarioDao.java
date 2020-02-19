package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Funcionarios;


public class funcionarioDao {
	public void salvar(Funcionarios f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionarios ");
		sql.append("(funcionario, data_registo) ");
		sql.append("(idutilizador, foto) ");
		sql.append("VALUES(?, ?, ?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, f.getFuncionario());
		pst.setInt(2, f.getData_registo());
		pst.setString(3, f.getFoto());
		pst.setLong(4, f.getUtilizador().getIdutilizador());
		
		
		pst.executeUpdate();

		System.out.println("O funcionario foi Registado com sucesso.");
	}

	public void editar(Funcionarios f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE funcionarios ");
		sql.append("SET funcionario = ?, data_registo = ?, idutilizador = ?, foto = ? ");
		sql.append(" WHERE idfuncionario = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, f.getFuncionario());
		pst.setInt(2, f.getData_registo());
		pst.setString(3, f.getFoto());
		pst.setLong(4, f.getUtilizador().getIdutilizador());
		
		pst.executeUpdate();
		System.out.println("O funcionario foi actualizado com sucesso.");
	}

	public void excluir(Funcionarios f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM funcionarios ");
		sql.append(" WHERE idfuncionario = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, f.getIdfuncinario());
		pst.executeUpdate();
		System.out.println("O funcionario foi eliminado com sucesso.");
	}

	public ArrayList<Funcionarios> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("select funcionarios.funcionario, funcionarios.data_registo ");
		sql.append("utilizadores.idutilizador FROM ");
		sql.append("funcionarios INNER JOIN utilizadores ON ");
		sql.append("(funcionarios.idutilizador = utilizadores.idutilizador)");
		sql.append("order by funcionario desc ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Funcionarios> lista = new ArrayList<Funcionarios>();

		while (resultado.next()) {
			Funcionarios f = new Funcionarios();
			f.setFuncionario(resultado.getString("funcionario"));
			f.setData_registo(resultado.getInt("data_registo"));
			//f.setUtilizador(resultado.getLong());
			f.setFoto(resultado.getString("foto"));
			

			lista.add(f);
		}

		return lista;
	}

}
