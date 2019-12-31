package service;

import java.util.List;

import dao.DAOFactory;
import entidad.Distrito;
import entidad.Docente;
import interfaces.DistritoDAO;
import interfaces.DocenteDAO;
import utils.Constantes;

public class DocenteService {
	//PASO 1: Define origen de datos
	DAOFactory fabrica=DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	//PASO 2: Define el DAO a utilizar
	DocenteDAO objDocente=fabrica.getDocenteDAO();
	DistritoDAO objDistrito=fabrica.getDistritoDAO();
	
	public int registraDocente(Docente doc) {
		return objDocente.addDocente(doc);
	}
	public List<Docente> listaDocente() {
		return objDocente.listDocente();
	}
	public int actualizaDocente(Docente doc) {
		return objDocente.updateDocente(doc);
	}
	public int eliminaDocente(int cod) {
		return objDocente.deleteDocente(cod);
	}
	public Docente buscaDocente(int cod) {
		return objDocente.findDocente(cod);
	}
	public List<Distrito> listaDistrito(){
		return objDistrito.listDistrito(); 
	}
	public List<Docente> listarDocente(double sueldo) {
		return objDocente.listDocente(sueldo);
	}
}





