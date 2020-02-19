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
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilizadorDao {
	public void salvar(Utilizadores ut) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO utilizadores");
		sql.append("(utilizador, login, senha, idestado, idperfil) ");
		sql.append("VALUES(?, ?, ?, ?, ?) ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, ut.getIdutilizador());
		pst.setString(2, ut.getUtilizador());
		pst.setString(3, ut.getLogin());
		pst.setString(4, ut.getSenha());
		pst.setLong(5, ut.getEstado().getIdestado());
		pst.setLong(6, ut.getPerfil().getIdperfil());
		
		pst.executeUpdate();

		System.out.println("O utilizador foi Registado com sucesso.");
	}

	public void editar(Utilizadores ut) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE utilizador ");
		sql.append("SET utilizador = ?, login = ?, senha = ?, idestado = ?, idperfil = ? ");
		sql.append(" WHERE idcliente = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, ut.getUtilizador());
		pst.setString(2, ut.getLogin());
		pst.setString(3, ut.getSenha());
		pst.setLong(4, ut.getEstado().getIdestado());
		pst.setLong(5, ut.getPerfil().getIdperfil());

		pst.executeUpdate();
		System.out.println("O utilizador foi actualizado com sucesso.");
	}

	public void excluir(Utilizadores ut) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM utilizadores ");
		sql.append(" WHERE idutilizador = ? ");

		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, ut.getIdutilizador());
		pst.executeUpdate();
		System.out.println("O utilizador foi eliminado com sucesso.");
	}

	public Utilizadores buscar_por_id(Utilizadores ut) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SSELECT utilizadores.utilizador, utilizadores.login, ");
		sql.append("utilizadores.senha, estados.estado, perfil.perfil FROM ");
		sql.append(" utilizadores INNER JOIN estados INNER JOIN perfil ON ");
		sql.append("utilizadores.idestado = estados.idestado AND utilizadores.idperfil = perfil.idperfil");
		sql.append("WHERE idutilizador = ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, ut.getIdutilizador());

		ResultSet resultado = pst.executeQuery();

		Utilizadores retorno = null;

		if (resultado.next()) {
			 
			
			
			Perfil p = new Perfil();
			p.setIdperfil(resultado.getLong("idperfil"));
			p.setPerfil(resultado.getString("perfil"));
		
			Estado es = new Estado();
			es.setIdestado(resultado.getLong("idestado"));
			es.setEstado(resultado.getString("estado"));
			
			
			retorno = new Utilizadores();
			retorno.setIdutilizador(resultado.getLong("idutilizador"));
			retorno.setUtilizador(resultado.getString("utilizador"));
			retorno.setLogin(resultado.getString("login"));
			retorno.setSenha(resultado.getString("senha"));
			retorno.setPerfil(p);
			retorno.setEstado(es);
			
		}
		return retorno;

	}

	public ArrayList<Utilizadores> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SSELECT utilizadores.utilizador, utilizadores.login, ");
		sql.append("utilizadores.senha, estados.estado, perfil.perfil FROM ");
		sql.append(" utilizadores INNER JOIN estados INNER JOIN perfil ON ");
		sql.append("utilizadores.idestado = estados.idestado AND utilizadores.idperfil = perfil.idperfil");
		sql.append("WHERE idutilizador = ? ");
		sql.append("ORDER BY utilizador ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet resultado = pst.executeQuery();

		ArrayList<Utilizadores> lista = new ArrayList<Utilizadores>();

		while (resultado.next()) {
			
			Perfil p = new Perfil();
			p.setIdperfil(resultado.getLong("idperfil"));
			p.setPerfil(resultado.getString("perfil"));
		
			Estado es = new Estado();
			es.setIdestado(resultado.getLong("idestado"));
			es.setEstado(resultado.getString("estado"));
			
			
			Utilizadores util= new Utilizadores();
			util.setIdutilizador(resultado.getLong("idutilizador"));
			util.setUtilizador(resultado.getString("utilizador"));
			util.setLogin(resultado.getString("login"));
			util.setSenha(resultado.getString("senha"));
			util.setPerfil(p);
			util.setEstado(es);
			 
			 lista.add(util);
		}

		return lista;
	}

	public ArrayList<Utilizadores> buscar_cliente(Clientes ut)throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SSELECT utilizadores.utilizador, utilizadores.login, ");
		sql.append("utilizadores.senha, estados.estado, perfil.perfil FROM ");
		sql.append(" utilizadores INNER JOIN estados INNER JOIN perfil ON ");
		sql.append("utilizadores.idestado = estados.idestado AND utilizadores.idperfil = perfil.idperfil");
		sql.append("WHERE idcliente like ? ");

		Connection conexao = Factory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1, "%" + ut.getUtilizador()+ "%");

		ResultSet resultado = pst.executeQuery();
		ArrayList<Utilizadores> listar = new ArrayList<Utilizadores>();

		while (resultado.next()) {
			
			Perfil p = new Perfil();
			p.setIdperfil(resultado.getLong("idperfil"));
			p.setPerfil(resultado.getString("perfil"));
		
			Estado es = new Estado();
			es.setIdestado(resultado.getLong("idestado"));
			es.setEstado(resultado.getString("estado"));
			
			
			Utilizadores util= new Utilizadores();
			util.setIdutilizador(resultado.getLong("idutilizador"));
			util.setUtilizador(resultado.getString("utilizador"));
			util.setLogin(resultado.getString("login"));
			util.setSenha(resultado.getString("senha"));
			util.setPerfil(p);
			util.setEstado(es);

			 
			 listar.add(util);
		}
		return listar;

	}
        
        public boolean vericarLogin(String utilizador, String senha) {

        try {
            String sqlConsulta = "SELECT * from utilizadores where  utilizador = ?  and senha = ?";
            Connection conexao = Factory.conectar();
            PreparedStatement pst = conexao.prepareStatement(sqlConsulta);
            pst.setString(1, utilizador.trim());
            pst.setString(2, senha.trim());
            
            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BairroDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


}
