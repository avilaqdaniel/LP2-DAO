package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Distrito;
import service.DocenteService;

/**
 * Servlet implementation class ServletListaDistritoJSON
 */
@WebServlet("/DistritoJSON")
public class ServletListaDistritoJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaDistritoJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar el arreglo de objeto que retorna en mètodo listaDistrito
		List<Distrito> lista=new DocenteService().listaDistrito();
		//crear un objeto "array" de clase JsonArrayBuilder, dicho objeto es
		//el contenedor donde se encuentran los distritos
    	JsonArrayBuilder array=Json.createArrayBuilder();
    	for(Distrito d:lista){
    		JsonObject obj=Json.createObjectBuilder().add("codigo", d.getCodigo()).
    												  add("nombre", d.getNombre()).build();
    		array.add(obj);
    	}
    	response.setContentType("application/json;charset=UTF-8");
    	PrintWriter salida=response.getWriter();
    	salida.println(array.build());
		
		
		
	}

}








