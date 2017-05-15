package br.com.altasoft.controle.status.os.util;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.altasoft.controle.status.os.controller.LoginMB;
import br.com.altasoft.controle.status.os.model.Usuario;

public class FacesUtil {

	public static boolean isPostback() {
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static boolean isNotPostback() {
		return !isPostback();
	}
	
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	public static Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getApplication().getELResolver();
		LoginMB loginMB = (LoginMB) resolver.getValue(context.getELContext(), null, "loginMB");		
		return loginMB.getUsuario();
	}	
}