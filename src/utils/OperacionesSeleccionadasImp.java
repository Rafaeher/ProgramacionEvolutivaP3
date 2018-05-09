package utils;

import java.util.ArrayList;

public class OperacionesSeleccionadasImp extends OperacionesSeleccionadas {

	private ArrayList<Operacion> operacionesSeleccionadas;
	private ArrayList<Operacion> operacionesUnariasSeleccionadas;
	private ArrayList<Operacion> operacionesBinariasSeleccionadas;
	private ArrayList<Operacion> operacionesCeroSeleccionadas;

	public OperacionesSeleccionadasImp(ArrayList<Operacion> operacionesSeleccionadas) {
		super();
		this.setOperacionesTodasSeleccionadas(operacionesSeleccionadas);
		CalculaUnarias();
		CalculaBinarias();
		CalculaCero();

	}

	public ArrayList<Operacion> getOperacionesTodasSeleccionadas() {
		return operacionesSeleccionadas;
	}

	public void setOperacionesTodasSeleccionadas(ArrayList<Operacion> operacionesSeleccionadas) {
		this.operacionesSeleccionadas = operacionesSeleccionadas;
	}

	public ArrayList<Operacion> getOperacionesBinariosSeleccionados() {

		return operacionesBinariasSeleccionadas;
	}

	public ArrayList<Operacion> getOperacionesUnariasSeleccionadas() {

		return operacionesUnariasSeleccionadas;
	}

	public ArrayList<Operacion> getOperacionesCeroariosSeleccionados() {

		return operacionesCeroSeleccionadas;
	}

	private void CalculaBinarias() {

		ArrayList<Operacion> array = new ArrayList<Operacion>();

		for (int i = 0; i < operacionesSeleccionadas.size(); i++) {
			if (operacionesSeleccionadas.get(i) == Operacion.SUMA)
				array.add(Operacion.SUMA);
			if (operacionesSeleccionadas.get(i) == Operacion.RESTA)
				array.add(Operacion.RESTA);
			if (operacionesSeleccionadas.get(i) == Operacion.MUL)
				array.add(Operacion.MUL);
			if (operacionesSeleccionadas.get(i) == Operacion.DIV)
				array.add(Operacion.DIV);
		}
		this.operacionesBinariasSeleccionadas = array;
		
	}

	private void CalculaCero() {

		ArrayList<Operacion> array = new ArrayList<Operacion>();

		for (int i = 0; i < operacionesSeleccionadas.size(); i++) {
			if (operacionesSeleccionadas.get(i) == Operacion.A)
				array.add(Operacion.A);
			if (operacionesSeleccionadas.get(i) == Operacion.B)
				array.add(Operacion.B);
		}
		this.operacionesCeroSeleccionadas = array;
		
	}

	private void CalculaUnarias() {

		ArrayList<Operacion> array = new ArrayList<Operacion>();

		for (int i = 0; i < operacionesSeleccionadas.size(); i++) {
			if (operacionesSeleccionadas.get(i) == Operacion.LOG)
				array.add(Operacion.LOG);
			if (operacionesSeleccionadas.get(i) == Operacion.SQRT)
				array.add(Operacion.SQRT);
			if (operacionesSeleccionadas.get(i) == Operacion.OPUESTO)
				array.add(Operacion.OPUESTO);
		}
		this.operacionesUnariasSeleccionadas = array;
		
	}
}
