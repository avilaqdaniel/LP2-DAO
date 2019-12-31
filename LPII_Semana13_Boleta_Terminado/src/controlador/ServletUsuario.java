package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Menu;
import entidad.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("tipo");
		if(tipo.equals("sesion"))
			sesion(request,response);
		

	}
	private void sesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login,clave;
		login=request.getParameter("login");
		clave=request.getParameter("clave");
		Usuario usu=new UsuarioService().iniciaSesion(login, clave);
		if(usu==null){
			request.setAttribute("msg", "Usuario y/o clave incorrecto...");
			request.getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
		}
		else{
			List<Menu> lista=new UsuarioService().listarMenu(usu.getCodigo());
			//crear una sesiòn
			HttpSession session=request.getSession();
			//atributo dentro de la sesiòn
			session.setAttribute("permisos", lista);
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}
		
	}

}








