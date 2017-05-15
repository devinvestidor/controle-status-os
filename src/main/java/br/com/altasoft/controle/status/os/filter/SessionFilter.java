package br.com.altasoft.controle.status.os.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.altasoft.controle.status.os.model.Usuario;
import br.com.altasoft.controle.status.os.util.FacesUtil;

@WebFilter("/*.xhtml")
public class SessionFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;		
		StringBuffer url = httpRequest.getRequestURL();
		HttpSession session = (HttpSession) httpRequest.getSession();		
		
		if (!url.toString().contains("login.xhtml")) {
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			if (usuario == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml");
			}
		}		
		chain.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
	
	@Override
	public void destroy() {		
	}	

}
