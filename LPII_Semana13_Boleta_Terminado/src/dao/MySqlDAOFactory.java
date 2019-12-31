package dao;

import interfaces.AlumnoDAO;
import interfaces.BoletaDAO;
import interfaces.ConceptoDAO;
import interfaces.DistritoDAO;
import interfaces.DocenteDAO;
import interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public DocenteDAO getDocenteDAO() {
		
		return new MySqlDocenteDAO();
	}

	@Override
	public DistritoDAO getDistritoDAO() {
		// TODO Auto-generated method stub
		return new MySqlDistritoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new MySqlAlumnoDAO();
	}

	@Override
	public BoletaDAO getBoletaDAO() {
		// TODO Auto-generated method stub
		return new MySqlBoletaDAO();
	}

	@Override
	public ConceptoDAO getConceptoDAO() {
		// TODO Auto-generated method stub
		return new MySqlConceptoDAO();
	}
	
	
	
}

