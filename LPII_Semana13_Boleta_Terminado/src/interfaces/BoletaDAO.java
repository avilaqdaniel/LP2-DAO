package interfaces;

import java.util.List;

import entidad.Boleta;
import entidad.DetalleBoleta;

public interface BoletaDAO {
	public void registraBoleta(Boleta boleta,
			List<DetalleBoleta> detalle);
}
