package mutacion;

import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import utils.ArbolOperaciones;
import utils.Operacion;

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
		int funcion = r.nextInt(1);
		//Obtiene el numero de nodos con esa funcion
		int numFuncion = numFuncion(genotipo.getArbol(), funcion);
		//Calcula cual de esos nodos va a mutar
		int mutar = r.nextInt(numFuncion);
		
		int numAux = 0;
		boolean mutado = false;
		while(!mutado){
			genotipo.getArbol().
		}
		
	}
	
	private void aux(ArbolOperaciones arbol, int funcion, int numFuncion, int numAux){
		if(arbol.obtenerDer() != null || arbol.obtenerIzq() != null){
			if(arbol.obtenerRaiz().getNumOperandos() == funcion){
				if(numAux + 1 == numFuncion){
					numAux = numAux+1;
					
				}
				else{
					if(arbol.obtenerIzq() != null){
						aux(arbol.obtenerIzq(), funcion, numFuncion, numAux+1);
					}
					if(arbol.obtenerDer() != null){
						aux(arbol.obtenerDer(), funcion, numFuncion, numAux+1);
					}
				}
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

}
