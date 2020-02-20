
package br.com.projectoACAP.Dao;

import br.com.projectoACAP.domain.Contato;
import br.com.projectoACAP.factory.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class contatoDao {
    public void salvar(Contato contato)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO contato ");
		sql.append("(nome, email, idprovincia, informacao) ");
		sql.append("VALUES(?, ?, ?, ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,contato.getNome());
		pst.setString(2, contato.getEmail());
		pst.setLong(3, contato.getProvincia().getIdprovincia());
		pst.setString(4, contato.getInformcao());
		
		pst.executeUpdate();
		
		System.out.println("O contacto foi mantido com sucesso. Aguarda o Administrador");
	}
	
	public void editar(Contato contato) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE contatos ");
		sql.append("SET nome = ?, email = ?, idprovincia = ?, informacao = ? ");
		sql.append(" WHERE idcontato = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setString(1,contato.getNome());
		pst.setString(2, contato.getEmail());
		pst.setLong(3, contato.getProvincia().getIdprovincia());
		pst.setString(4, contato.getInformcao());
		
		pst.executeUpdate();
		System.out.println("O contacto foi editado com sucesso.");
	}
	
	public void excluir(Contato contato) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM contato ");
		sql.append(" WHERE idcontato = ? ");
		
		Connection conexao = Factory.conectar();
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, contato.getIdcontato);
		pst.executeUpdate();
		System.out.println("O contacto foi eliminado com sucesso..");
	}
	
	public Contato buscar_por_id((Contato contato) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idcontato, nome, email, idprovincia, informacao ");
		sql.append("FROM contatos ");
		sql.append("WHERE idcontato = ? ");
		
		Connection conexao = Factory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setLong(1, contato.getIdcontato());
		
		
		
		ResultSet resultado = pst.executeQuery();
		
		Contato retorno = null;

		if(resultado.next()){
			
		retorno = new Contato();
                retorno.setIdcontato(resultado.getLong("idcaixa"));
	        retorno.setName(resultado.getDouble("valores"));
	        retorno.setEmail(resultado.getDate("datafeixo"));
                retorno.setProvincia(res);
	      
			
			
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
