package interfaces;
import java.util.List;
import entidad.Concepto;
public interface ConceptoDAO {
	public List<Concepto> listaConceptoXNombre(String nombre);
}
