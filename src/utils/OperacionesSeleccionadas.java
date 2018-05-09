package utils;

import java.util.ArrayList;

public abstract class OperacionesSeleccionadas {

	private static OperacionesSeleccionadas instance;

	public static void setOperacionesSeleccionadas(ArrayList<Operacion> operacionesSeleccionadas) {
		if (instance == null) {
			instance = new OperacionesSeleccionadasImp(operacionesSeleccionadas);
		}
	}

	public static OperacionesSeleccionadas getOperacionesSeleccionadas() {
		return instance;
	}

	public abstract ArrayList<Operacion> getOperacionesUnariasSeleccionadas();
	public abstract ArrayList<Operacion> getOperacionesBinariosSeleccionados();
	public abstract ArrayList<Operacion> getOperacionesCeroariosSeleccionados();
	public abstract ArrayList<Operacion> getOperacionesTodasSeleccionadas();

}
