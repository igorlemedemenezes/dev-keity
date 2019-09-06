package br.usjt.arqsw.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.usjt.arqsw.entity.Usuario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws IOException {
		String uri = request.getRequestURI();
		
		if(uri.endsWith("Login") || uri.endsWith("loginForm")|| uri.endsWith("projeto")|| uri.contains("css") 
				|| uri.contains("js") || uri.contains("fonts")) {
			return true;
		}
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		else {
			response.sendRedirect("loginForm");
			return false;
		}
	}
}