package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
import br.usjt.arqsw.service.UsuarioService;
/**
 * 
 * @author asbonato
 *
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;
	private UsuarioService usuarioService;
	
	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService, UsuarioService usuarioService) {
		this.chamadoService = chamadoService;
		this.filaService = filaService;
		this.usuarioService = usuarioService;		
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	/**
	 * 
	 * @param model Acesso Ã  request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				//return "redirect:listar_filas_exibir";
			}
			//fila = filaService.carregar(fila.getId());
			//model.addAttribute("filas", fila);
			model.addAttribute("chamados", chamadoService.listar(fila));
			return "ChamadoListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "Login";
	}
	
	@RequestMapping("/efetuarLogin")
	public String fazerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user, password);
		if(usuarioService.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			System.out.println("Logou" + usuario);
		}else {
			System.out.println("Não logou " + usuario);
			throw new ServletException("Usuario ou senha inválidos");
		}
		
		return "index";
	}
}
