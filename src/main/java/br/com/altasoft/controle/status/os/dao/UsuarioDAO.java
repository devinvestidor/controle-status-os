package br.com.altasoft.controle.status.os.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.altasoft.controle.status.os.model.ControleStatusOsResumo;
import br.com.altasoft.controle.status.os.model.Usuario;

public class UsuarioDAO {
	
	public Usuario carregaUsuario(String cnpj, String senha){
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;    
        Usuario usuario = null;
        try {
            conn = ConnectionManager.getConexao();            
            String query = "SELECT MP.i_cod_m_pessoa_c as id, 		  "+
            		       "       MP.s_cpf_cnpj as cnpj, 	  		  "+
            			   "       MP.s_senha as senha, 	  		  "+
            			   "       MP.s_nome_pessoa as nome,  		  "+
            			   "       MP.i_cod_bs_tipo_pessoa_c as tipo  "+
            			   "FROM m_pessoa_c MP  			  		  "+
            			   "WHERE MP.s_cpf_cnpj = ?			  		  "+
            			   "AND MP.s_senha = ? 				  		  ";
            			   
            prepStmt = conn.prepareStatement(query);            
            prepStmt.setString(1, cnpj);
            prepStmt.setString(2, senha);
            
            rs = prepStmt.executeQuery();
            	
            if (rs.next()) {
            	Long rId = rs.getLong("id");
            	String rCnpj = rs.getString("cnpj");
            	String rsenha = rs.getString("senha");
            	String rnome = rs.getString("nome");
            	Integer rTipo = rs.getInt("tipo");            	
            	usuario = new Usuario(rId, rCnpj, rsenha, rnome, rTipo);
            	return usuario;
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
		
		return null;
	}

}
