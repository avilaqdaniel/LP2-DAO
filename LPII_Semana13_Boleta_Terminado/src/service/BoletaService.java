package service;
import java.util.List;
import dao.DAOFactory;
import entidad.Alumno;
import entidad.Boleta;
import entidad.Concepto;
import entidad.DetalleBoleta;
import interfaces.AlumnoDAO;
import interfaces.BoletaDAO;
import interfaces.ConceptoDAO;
import utils.Constantes;
public class BoletaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	AlumnoDAO objAlumno=fabrica.getAlumnoDAO();
	ConceptoDAO objConcepto=fabrica.getConceptoDAO();
	BoletaDAO objBoleta=fabrica.getBoletaDAO();
	public List<Concepto> listaConceptoXNombre(String nombre) {
		return objConcepto.listaConceptoXNombre(nombre);
	}
	public List<Alumno> listaAlumnoxApellido(String apellido) {
		return objAlumno.listaAlumnoxApellido(apellido);
	}
	public void registrarBoleta(Boleta boleta, List<DetalleBoleta> detalle) {
		objBoleta.registraBoleta(boleta, detalle);
	}
}
