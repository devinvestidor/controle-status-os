package br.com.altasoft.controle.status.os.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.altasoft.controle.status.os.dao.UsuarioDAO;
import br.com.altasoft.controle.status.os.model.Usuario;
import br.com.altasoft.controle.status.os.util.FacesUtil;

@Named
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private UsuarioDAO usuarioDao;

	public LoginMB() {
		usuario = new Usuario();
		usuarioDao = new UsuarioDAO();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/login?faces-redirect=true";
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String validaUsuario() {
		Usuario usuarioLogin = usuarioDao.carregaUsuario(usuario.getCnpj(), usuario.getSenha());
		if (usuarioLogin != null) {
			usuario = usuarioLogin;
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("usuarioLogado", usuario);
			return "/consultas/controleStatusOs?faces-redirect=true";
		}

		FacesUtil.addErrorMessage("Usuário ou senha inválidos");
		return "";
	}

}
