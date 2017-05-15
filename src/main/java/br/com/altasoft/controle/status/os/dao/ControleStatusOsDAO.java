package br.com.altasoft.controle.status.os.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.altasoft.controle.status.os.model.ControleStatusOsPrincipal;
import br.com.altasoft.controle.status.os.model.ControleStatusOsResumo;
import br.com.altasoft.controle.status.os.util.FacesUtil;


public class ControleStatusOsDAO {
	
	public List<ControleStatusOsResumo> pesquisarResumo(Long id){
        Connection conn = null;
        PreparedStatement prepStmt = null;        
        ResultSet rs = null;
        ControleStatusOsResumo controleStatusOsResumo = null;
        List<ControleStatusOsResumo> list = new ArrayList<ControleStatusOsResumo>();
        try {
            conn = ConnectionManager.getConexao();
            String query = "SELECT distinct B.s_descricao as descricao, "+   
                           "COUNT(*) as total "+
                    	   "FROM m_ordem_atend_veiculo_c M "+                                                                         
             	           "     INNER JOIN b_status_os_c B  "+                                                                      
      	           		   "       ON ( M.i_cod_b_status_ordem_veiculo_c = B.i_cod_b_status_os_c ) "+
             	           "    INNER JOIN m_veiculo_c MV "+
             	           "	   ON (M.i_cod_m_veiculo_c = MV.i_cod_m_veiculo_c) "+	
         		   		   "WHERE ( (B.ib_finalizada in(0,2)) OR ((B.ib_finalizada = 1) AND M.dt_saida_veiculo = current_date )  ) ";
            
            if (!FacesUtil.getUsuarioLogado().isUsuarioMaster()) {
            	query += "AND MV.i_cod_m_pessoa_proprietario = ? ";
            }
            
            query +=	   "GROUP BY B.s_descricao "+                                                                                 
      	                   "ORDER BY B.s_descricao ";
            
            prepStmt = conn.prepareStatement(query);
            
            
            if (!FacesUtil.getUsuarioLogado().isUsuarioMaster()) {
            	prepStmt.setLong(1, id);	
            }            
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
            	String descricao = rs.getString("descricao");
            	Integer total = rs.getInt("total");
                controleStatusOsResumo = new ControleStatusOsResumo(descricao, total);
                list.add(controleStatusOsResumo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
		
		
		return list;
	}
	
	public List<ControleStatusOsPrincipal> pesquisarPrincipal(Long id){
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        ControleStatusOsPrincipal controleStatusOsPrincipal = null;
        List<ControleStatusOsPrincipal> list = new ArrayList<ControleStatusOsPrincipal>();
        try {
            conn = ConnectionManager.getConexao();
            String query = "SELECT M.i_cod_m_ordem_atend_veiculo_c as ordem, "+
            			   "       MV.s_placa as placa, "+
     			   		   "       MV.s_renavam as renavam, "+
            		   	   "       BS.s_descricao as descricao, "+
			   		       "       BTO.s_descricao as tipoOrdem, "+
			   		       "       MPV.s_nome_pessoa as pessoa, "+
			   		       "       BCD.s_descricao_cidade as cidade "+
			   		       "FROM m_ordem_atend_veiculo_c M "+                                                                              
			   		       "     INNER JOIN m_veiculo_c MV "+                                                                              
			   		       "       on ( M.i_cod_m_veiculo_c = MV.i_cod_m_veiculo_c ) "+                                                    
			   		       "     INNER JOIN b_status_os_c BS "+                                                                            
			   		       "           on ( M.i_cod_b_status_ordem_veiculo_c = BS.i_cod_b_status_os_c ) "+                                 
			   		       "     INNER JOIN b_tipo_ordem_atend_veic_c BTO "+                                                               
			   		       "       on ( M.i_cod_tipo_ordem_atend_veic_c = BTO.i_cod_tipo_ordem_atend_veic_c ) "+                           
			   		       "     INNER JOIN m_pessoa_c MPV "+                                                                              
			   		       "       on ( MV.i_cod_m_pessoa_proprietario = MPV.i_cod_m_pessoa_c ) "+                                         
			   		       "       INNER JOIN b_cidade_c BCD "+                                                                            
			   		       "       on ( MPV.i_cod_b_cidade_c = BCD.i_cod_b_cidade_c ) "+                                                   
			   		       "WHERE ( (BS.ib_finalizada = 0) OR ((BS.ib_finalizada = 1) AND M.dt_saida_veiculo = current_date ) OR ((BS.ib_finalizada = 2) AND M.dt_saida_veiculo = current_date )  ) ";
            
            if (!FacesUtil.getUsuarioLogado().isUsuarioMaster()) {
            	query += "AND MPV.i_cod_m_pessoa_c = ? " ;
            }
            
            query += "ORDER BY M.i_cod_m_ordem_atend_veiculo_c, M.hr_entrada_veiculo ";                                              
           		
            
            prepStmt = conn.prepareStatement(query);
            
            if (!FacesUtil.getUsuarioLogado().isUsuarioMaster()) {
            	prepStmt.setLong(1, id);	
            }
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
            	Integer ordem = rs.getInt("ordem");
            	String placa = rs.getString("placa");
            	String renavam = rs.getString("renavam");
            	String descricao = rs.getString("descricao");
            	String tipoOrdem = rs.getString("tipoOrdem");
            	String pessoa = rs.getString("pessoa");
            	String cidade = rs.getString("cidade");
            	
            	controleStatusOsPrincipal = new ControleStatusOsPrincipal(ordem, placa, renavam, descricao, tipoOrdem, pessoa, cidade);
                list.add(controleStatusOsPrincipal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
		
		
		return list;
	}
	
	
	


}
