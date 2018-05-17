package poblacionInicial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import utils.ArbolOperaciones;
import utils.Operacion;
import utils.OperacionesSeleccionadas;

public class RampedANDHalf extends InicializacionArbol{

	@Override
	public ArbolOperaciones inicializacionAleatoria(int max) {
		Random r = new Random();
		ArrayList<Operacion> operandosCreciente = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesTodasSeleccionadas();
		
		ArrayList<Operacion> operandosCompleta = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesBinariosSeleccionados();
		operandosCompleta.addAll(OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesUnariasSeleccionadas());
		
		ArbolOperaciones arbol = new ArbolOperaciones(operandosCreciente.get(r.nextInt(operandosCreciente.size())));

		Queue<ArbolOperaciones> nodos = new LinkedList<>();
		
		nodos.add(arbol);
		
		while(!nodos.isEmpty()){
			ArbolOperaciones arbolAux = nodos.remove();
			if(arbolAux != null){
				if(arbolAux.getNivel() >= max-1){
					try {
						arbolAux.forzarTamano();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					try {
						//Combinamos entre completa y creciente
						if(arbolAux.getNivel()%2 == 0) arbolAux.generarHijosAleatorios(operandosCreciente);
						else arbolAux.generarHijosAleatorios(operandosCompleta);
					} catch (Exception e) {
						e.printStackTrace();
					}
					nodos.add(arbolAux.obtenerDer());
					nodos.add(arbolAux.obtenerIzq());
				}
			}
		}
		return arbol;
	}
	

}
