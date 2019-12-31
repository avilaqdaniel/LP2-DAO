package service;

import java.util.List;

import dao.DAOFactory;
import entidad.Distrito;
import entidad.Docente;
import entidad.Menu;
import entidad.Usuario;
import interfaces.DistritoDAO;
import interfaces.DocenteDAO;
import interfaces.UsuarioDAO;
import utils.Constantes;

public class UsuarioService {
	//PASO 1: Define origen de datos
	DAOFactory fabrica=DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	//PASO 2: Define el DAO a utilizar
	UsuarioDAO objUsuario=fabrica.getUsuarioDAO();

	
	public Usuario iniciaSesion(String log,String pass) {
		return objUsuario.iniciarSesion(log, pass);
	}
	public List<Menu> listarMenu(int cod) {
		return objUsuario.listaMenu(cod);
	}
	
}





