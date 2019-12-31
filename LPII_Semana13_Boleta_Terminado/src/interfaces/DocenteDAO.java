package interfaces;

import java.util.List;
import entidad.Docente;

public interface DocenteDAO {
	// definir metodos
	public int addDocente(Docente doc);
	public int updateDocente(Docente doc);
	public int deleteDocente(int cod);
	public List<Docente> listDocente();
	public List<Docente> listDocente(double sueldo);
	public Docente findDocente(int cod);
}
