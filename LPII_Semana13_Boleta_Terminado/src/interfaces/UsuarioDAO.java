package interfaces;
import java.util.List;
import entidad.Menu;
import entidad.Usuario;
public interface UsuarioDAO {
	public Usuario iniciarSesion(String login,String clave);
	public List<Menu> listaMenu(int codUsuario);
}
