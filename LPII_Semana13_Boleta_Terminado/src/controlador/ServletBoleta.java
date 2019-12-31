package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Boleta;
import entidad.Concepto;
import entidad.DetalleBoleta;
import service.BoletaService;

/**
 * Servlet implementation class ServletBoleta
 */
@WebServlet("/ServletBoleta")
public class ServletBoleta extends HttpServlet {
	
	private BoletaService bs=new BoletaService();
	
	private static final long serialVersionUID = 1L;
		
    public ServletBoleta() {
        super();
    
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("tipo");
		if(tipo.equals("buscarApellido"))
			buscarAlumnoXApellido(request,response);
		else if(tipo.equals("buscarConcepto"))
			buscaConceptoXNombre(request,response);
		else if(tipo.equals("adicionar"))
			adicionar(request, response);
		else if(tipo.equals("grabar"))
			grabar(request, response);
	}

	private void grabar(HttpServletRequest request, HttpServletResponse response) {
		
		String cod;
		cod=request.getParameter("codigoAlumno");
		List<DetalleBoleta> bol=(List<DetalleBoleta>) 
					request.getSession().getAttribute("boleta");
		Boleta b=new Boleta();
		b.setCodCliente(Integer.parseInt(cod));
		b.setCodEmpleado(1);
		b.setMonto(4646);
		bs.registrarBoleta(b, bol);
	}

	private void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Declarar arreglo de objeto 
		List<DetalleBoleta> bol;
		//Condicion para verificar si existe 
		//dentro de la sesion un atributo con el nombre Boleta
		if(request.getSession().getAttribute("boleta")==null) //no existe
			bol=new ArrayList<DetalleBoleta>();
		else
			bol=(List<DetalleBoleta>) request.getSession().getAttribute("boleta");
		
		//recuperar los valores del concepto actual
		String cod,nom,pre,can;
		cod=request.getParameter("codigo");
		nom=request.getParameter("nombre");
		pre=request.getParameter("precio");
		can=request.getParameter("cantidad");
		
		//objeto de la clase DetalleBoleta
		DetalleBoleta deta=new DetalleBoleta();
		//setear
		deta.setCodProducto(Integer.parseInt(cod));
		deta.setNomProducto(nom);
		deta.setPrecio(Double.parseDouble(pre));
		deta.setCantidad(Integer.parseInt(can));
		//Enviar al objeto deta al arreglo "bol"
		bol.add(deta);
		//Crear o actualizar el atributo "boleta"
		request.getSession().setAttribute("boleta", bol);
		request.getRequestDispatcher("/listaDetalle.jsp").forward(request, response);
	}

	private void buscaConceptoXNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nombre");
		List<Concepto> data=bs.listaConceptoXNombre(nom);
		
		request.setAttribute("conceptos", data);
		request.getRequestDispatcher("/listaConcepto.jsp").forward(request, response);
		
	}


	private void buscarAlumnoXApellido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ape=request.getParameter("apellido");
		List<Alumno> data=bs.listaAlumnoxApellido(ape);
		
		request.setAttribute("alumnos", data);
		request.getRequestDispatcher("/listaAlumno.jsp").forward(request, response);
		
	}

}
