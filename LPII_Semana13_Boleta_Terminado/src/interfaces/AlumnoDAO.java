package interfaces;
import java.util.List;
import entidad.Alumno;
public interface AlumnoDAO {
		public List<Alumno> listaAlumnoxApellido(String apellido);
}
