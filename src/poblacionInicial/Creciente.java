package poblacionInicial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import utils.ArbolOperaciones;
import utils.Operacion;
import utils.OperacionesSeleccionadas;

public class Creciente extends InicializacionArbol{

	@Override
	public ArbolOperaciones inicializacionAleatoria(int max) {
		Random r = new Random();
		ArrayList<Operacion> operandos = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesTodasSeleccionadas();
		
		ArbolOperaciones arbol = new ArbolOperaciones(operandos.get(r.nextInt(operandos.size())));

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
						arbolAux.generarHijosAleatorios(operandos);
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
