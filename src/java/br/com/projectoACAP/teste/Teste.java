/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projectoACAP.teste;

import br.com.projectoACAP.Dao.UtilizadorDao;
import br.com.projectoACAP.Dao.estadoDao;
import br.com.projectoACAP.Dao.perfilDao;
import br.com.projectoACAP.domain.Estado;
import br.com.projectoACAP.domain.Perfil;
import br.com.projectoACAP.domain.Utilizadores;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Julio Andre
 */
public class Teste {
    public static void main(String[] args){
       
       
        try {
            Estado es = new Estado();
            es.setEstado("estadoTeste");
            estadoDao esdao = new estadoDao();
            esdao.salvar(es);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
