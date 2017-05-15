package br.com.altasoft.controle.status.os.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELResolver;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.altasoft.controle.status.os.dao.ControleStatusOsDAO;
import br.com.altasoft.controle.status.os.model.ControleStatusOsPrincipal;
import br.com.altasoft.controle.status.os.model.ControleStatusOsResumo;
import br.com.altasoft.controle.status.os.model.Usuario;
import br.com.altasoft.controle.status.os.util.FacesUtil;



@Named
@RequestScoped
public class ControleStatusOsMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private List<ControleStatusOsResumo> listControleStatusOsResumo;
	private List<ControleStatusOsPrincipal> listControleStatusOsPrincipal;
	private ControleStatusOsDAO controleStatusOsDAO;


	
	public void inicializar(){		
		controleStatusOsDAO = new ControleStatusOsDAO();		
		listControleStatusOsResumo = controleStatusOsDAO.pesquisarResumo(FacesUtil.getUsuarioLogado().getId());	
		listControleStatusOsPrincipal = controleStatusOsDAO.pesquisarPrincipal(FacesUtil.getUsuarioLogado().getId());
	}
	


	public List<ControleStatusOsResumo> getListControleStatusOsResumo() {
		return listControleStatusOsResumo;
	}


	public void setListControleStatusOsResumo(List<ControleStatusOsResumo> listControleStatusOsResumo) {
		this.listControleStatusOsResumo = listControleStatusOsResumo;
	}


	public List<ControleStatusOsPrincipal> getListControleStatusOsPrincipal() {
		return listControleStatusOsPrincipal;
	}


	public void setListControleStatusOsPrincipal(List<ControleStatusOsPrincipal> listControleStatusOsPrincipal) {
		this.listControleStatusOsPrincipal = listControleStatusOsPrincipal;
	}
}
