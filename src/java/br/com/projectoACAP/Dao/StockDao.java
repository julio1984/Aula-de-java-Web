package br.com.projectoACAP.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.factory.Factory;
import br.com.projectoACAP.domain.Stock;


public class StockDao {
	
public void salvar(Stock st)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO stocks ");
		sql.append("(qtdMaxima, qtdMini) ");
		sql.append("(qtdCritica, Data_actualizada) ");
		sql.append("(idutilizador) ");
		sql.append("VALUES(?, ?, ?, ?) ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setInt(1,st.getQuantidadeMaxima());
		pst.setInt(2,st.getQuantidadeCritica());
		pst.setInt(3,st.getQuantidadeCritica());
		pst.setInt(4,st.getQuantidadeMinima());
		pst.setDate(2, st.getData_actualizao());
		pst.executeUpdate();
		
		System.out.println("O Stock foi Registado com sucesso.");
	}
	
	public void editar(Stock st) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE stocks ");
		sql.append("SET qtdMaximo = ?, qtdMini = ?, qtdCritica = ?, Data_actualizado = ?, idutilizador = ? ");
		sql.append(" WHERE idstok = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setInt(1, st.getQuantidadeMaxima());
		pst.setInt(1, st.getQuantidadeCritica());
		pst.setInt(1, st.getQuantidadeMinima());
		pst.setDate(2, st.getData_actualizao());
		//pst.setUtilizador(3, st.getUtilizador());
		pst.setLong(3, st.getIdstock());
		
		pst.executeUpdate();
		System.out.println("O sotck foi actualizado com sucesso.");
	}
	
	public void excluir(Stock st) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM stocks ");
		sql.append(" WHERE idstock = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, st.getIdstock());
		pst.executeUpdate();
		System.out.println("O Stock foi eliminado com sucesso.");
	}
	
	
	public ArrayList<Stock> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM stocks ");
		sql.append("order by qtdMaxima desc ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = pst.executeQuery();
		
		ArrayList<Stock> lista = new ArrayList<Stock>();
		
		while (resultado.next()) {
			Stock st = new Stock();
			
			st.setIdstock(resultado.getLong("idstock"));
			st.setQuantidadeMinima(resultado.getInt("qtdMini"));
			st.setQuantidadeMaxima(resultado.getInt("qtdMaxima"));
			st.setQuantidadeCritica(resultado.getInt("qtdCritica"));
			st.setData_actualizao(resultado.getDate("Date data_actualizao"));
			
			
			lista.add(st);
		}
		
	return lista;
	}
	
	

}
