package controlador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Docente;
import service.DocenteService;

@WebServlet("/CrudDocente")
public class ServletCrudDocente extends HttpServlet {
	//Objeto del servicio "DoncenteService"
	DocenteService ds=new DocenteService();
	
	private static final long serialVersionUID = 1L;
    public ServletCrudDocente() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ope=request.getParameter("operador");
		if(ope.equals("listar")){
			listar(request,response);
		}
		else if(ope.equals("registrar")){
			registrar(request,response);
		}
		else if(ope.equals("buscar")){
			buscar(request,response);
		}
		else if(ope.equals("actualizar")){
			actualizar(request,response);
		}
		else if(ope.equals("consulta")){
			consulta(request,response);
		}
	}
	private void consulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sueldo=request.getParameter("sueldo");
		List<Docente> data=ds.listarDocente(Double.parseDouble(sueldo));
		request.setAttribute("docentes", data);		
		request.getRequestDispatcher("/listaDocente2.jsp").
		forward(request, response);
		
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nom,pat,mat,sexo,hijo,sueldo,fecha,distrito,direccion;
		cod=request.getParameter("codigo");
		nom=request.getParameter("nombre");
		pat=request.getParameter("paterno");
		mat=request.getParameter("materno");
		sexo=request.getParameter("sexo");
		hijo=request.getParameter("hijos");
		sueldo=request.getParameter("sueldo");
		fecha=request.getParameter("fecha");
		distrito=request.getParameter("distrito");
		direccion=request.getParameter("direccion");		
		Docente d=new Docente();
		d.setCodigo(Integer.parseInt(cod));
		d.setNombre(nom);
		d.setPaterno(pat);
		d.setMaterno(mat);
		d.setSexo(sexo);
		d.setNumHijos(Integer.parseInt(hijo));
		d.setSueldo(Double.parseDouble(sueldo));
		d.setFecNacimiento(fecha);
		d.setCodDistrito(Integer.parseInt(distrito));
		d.setDireccion(direccion);
		ds.actualizaDocente(d);
		listar(request, response);
		
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar el valor del parametor Codigo
		String  codigo=request.getParameter("codigo");
		//Objeto de la clase Docente
		Docente doc=ds.buscaDocente(Integer.parseInt(codigo));
		//Atributo para almacenar el objeto "doc"
		request.setAttribute("docente", doc);
		//Enviar el atributo Docente a la pagina "actualizaDocente.jsp"
		request.getRequestDispatcher("/actualizaDocente.jsp").forward(request, response);
	}
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Docente> data=ds.listaDocente();
		request.setAttribute("docentes", data);		
		request.getRequestDispatcher("/listaDocente.jsp").
		forward(request, response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom,pat,mat,sexo,hijo,sueldo,fecha,distrito,direccion;
		nom=request.getParameter("nombre");
		pat=request.getParameter("paterno");
		mat=request.getParameter("materno");
		sexo=request.getParameter("sexo");
		hijo=request.getParameter("hijos");
		sueldo=request.getParameter("sueldo");
		fecha=request.getParameter("fecha");
		distrito=request.getParameter("distrito");
		direccion=request.getParameter("direccion");
		Docente d=new Docente();
		d.setNombre(nom);
		d.setPaterno(pat);
		d.setMaterno(mat);
		d.setSexo(sexo);
		d.setNumHijos(Integer.parseInt(hijo));
		d.setSueldo(Double.parseDouble(sueldo));
		d.setFecNacimiento(fecha);
		d.setCodDistrito(Integer.parseInt(distrito));
		d.setDireccion(direccion);
		ds.registraDocente(d);
		listar(request, response);
	}
}

