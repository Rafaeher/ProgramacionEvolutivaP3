package mutacion;

import java.util.ArrayList;
import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import utils.ArbolOperaciones;
import utils.Operacion;
import utils.OperacionesSeleccionadas;

public class MutacionFuncionalSimple<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	/**
	 * Se selecciona al azar una función dentro del individuo, y se sustituye
	 * por otra diferente del conjunto de funciones posibles con el mismo número
	 * de operandos
	 */
	@Override
	public void muta(GenotipoArbol genotipo, FenotipoArbol fenotipo, double prob_mutacion) {
		Random r = new Random();
		//Obtiene aleatoriamente una funcion a mutar (funcion de 1 elemento o de 2)
		int aux = r.nextInt(2);
		//Obtiene el numero de nodos con esa funcion
		int numFunciones = numFuncion(genotipo.getArbol(), aux);
		//Calcula cual de esos nodos va a mutar
		if(numFunciones > 0){
			int mutar = r.nextInt(numFunciones) + 1;
			
			int numFuncion;
			if(aux == 0) numFuncion = 1;
			else numFuncion = 2;
			
			inorden(genotipo.getArbol(),numFuncion,mutar,0);
		}
		
		
	}
	
	
	 private void inorden(ArbolOperaciones a, int funcion, int numFuncion, int numAux) {
	        if (a != null && numAux <= numFuncion) {
	        	if(a.obtenerRaiz().getNumOperandos() == funcion){
	        		numAux += 1;
	        		if(numAux == numFuncion){
	        			//Mutacion
	        			a.setRaiz(mutacion(funcion));
	        		}
	        		else{
	        			inorden(a.obtenerIzq(),funcion, numFuncion, numAux);
	        			inorden(a.obtenerDer(),funcion, numFuncion, numAux);
	        		}
	        	}
	        	else{
	        		inorden(a.obtenerIzq(),funcion, numFuncion, numAux);
        			inorden(a.obtenerDer(),funcion, numFuncion, numAux);
	        	}
	        }
	    }

	private int numFuncion(ArbolOperaciones arbol, int funcion){
		switch(funcion){
		case 0: return arbol.getNum_1();
		case 1: return arbol.getNum_2();
		default: return 0;
		}
	}

	private Operacion mutacion(int tipo){
		Random r = new Random();
		
		ArrayList<Operacion> binarios = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesBinariosSeleccionados();
		ArrayList<Operacion> unarios = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesUnariasSeleccionadas();

		if(tipo == 2){
			return binarios.get(r.nextInt(binarios.size()));
		}
		else if(tipo == 1){
			return unarios.get(r.nextInt(unarios.size()));
		}
		else return null;
	}
}
