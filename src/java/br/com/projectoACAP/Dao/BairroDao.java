package br.com.projectoACAP.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projectoACAP.domain.Bairros;
import br.com.projectoACAP.domain.Municipios;
import br.com.projectoACAP.factory.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BairroDao {

    public void salvar(Bairros b) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO bairros ");
        sql.append("(bairro, idmunicipio) ");
        sql.append("VALUES(?,?) ");

        Connection conexao = Factory.conectar();

        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.setString(1, b.getBairro());
        pst.setLong(2, b.getMunicipios().getIdmunicipio());

        pst.executeUpdate();

        System.out.println("O bairro foi Registado com sucesso.");
    }

    public void editar(Bairros b) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE bairros ");

        sql.append(" WHERE idbairro = ? ");

        Connection conexao = Factory.conectar();
        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.setString(1, b.getBairro());
        pst.setLong(2, b.getMunicipios().getIdmunicipio());

        pst.executeUpdate();
        System.out.println("O bairro foi actualizado com sucesso.");
    }

    public void excluir(Bairros b) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM bairros ");
        sql.append(" WHERE idbairro = ? ");

        Connection conexao = Factory.conectar();
        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.setLong(1, b.getIdbairro());
        pst.executeUpdate();
        System.out.println("O bairro foi eliminado com sucesso.");
    }

    public Bairros buscar_por_id(Bairros b) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" ");
        sql.append(" ");
        sql.append("WHERE idbairro = ? ");

        Connection conexao = Factory.conectar();

        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.setLong(1, b.getIdbairro());

        ResultSet resultado = pst.executeQuery();

        Bairros retorno = null;

        if (resultado.next()) {

            retorno = new Bairros();
            retorno.setIdbairro(resultado.getLong("idbairro"));
            retorno.setBairro(resultado.getString("bairro"));

        }
        return retorno;

    }

    public ArrayList<Bairros> listar() throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT bairros.idbairro, bairros.bairro, municipios.idmunicipio ");
        sql.append("FROM bairros INNER JOIN municipios ");
        sql.append(" on municipios.idmunicipio = bairros.idmunicipio ");

        Connection conexao = Factory.conectar();

        PreparedStatement pst = conexao.prepareStatement(sql.toString());

        ResultSet resultado = pst.executeQuery();

        ArrayList<Bairros> itens = new ArrayList<Bairros>();

        while (resultado.next()) {

            Municipios m = new Municipios();
            m.setIdmunicipio(resultado.getLong("mu.idmunicipio"));
            m.setMunicipio(resultado.getString("municipio"));

            Bairros ba = new Bairros();
            ba.setIdbairro(resultado.getLong("ba.idbairro"));
            ba.setBairro(resultado.getString("ba.bairro"));
            ba.setMunicipios(m);

            itens.add(ba);
        }

        return itens;
    }

    
}
