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

public class Permutacion<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	/**
	 * Se selecciona al azar una función dentro del individuo, y se sustituye
	 * por otra diferente del conjunto de funciones posibles con el mismo número
	 * de operandos
	 */
	@Override
	public void muta(GenotipoArbol genotipo, FenotipoArbol fenotipo, double prob_mutacion) {
		Random r = new Random();
		// Obtiene aleatoriamente una funcion a mutar (funcion de 1 elemento o
		// de 2)
		//int aux = r.nextInt(2);
		// Obtiene el numero de nodos con esa funcion
		int numFunciones = genotipo.getArbol().getNum_2();
		// Calcula cual de esos nodos va a mutar
		if (numFunciones > 0) {
			int mutar = r.nextInt(numFunciones) + 1;

			int numFuncion = 2;
		//	System.out.println("");
			inorden(genotipo.getArbol(), numFuncion, mutar, 0);
		//	System.out.println("");
		}

	}

	private void inorden(ArbolOperaciones a, int funcion, int numFuncion, int numAux) {
		if (a != null && numAux <= numFuncion) {
			if (a.obtenerRaiz().getNumOperandos() == funcion) {
				numAux += 1;
				if (numAux == numFuncion) {
					// Mutacion
					System.out.println("TOCA MUTAR");
					mutacion(a);
				} else {
					inorden(a.obtenerIzq(), funcion, numFuncion, numAux);
					inorden(a.obtenerDer(), funcion, numFuncion, numAux);
				}
			} else {
				inorden(a.obtenerIzq(), funcion, numFuncion, numAux);
				inorden(a.obtenerDer(), funcion, numFuncion, numAux);
			}
		}
	}

		private void mutacion(ArbolOperaciones arbol) {
		
		ArbolOperaciones izquierda = arbol.obtenerIzq();
		ArbolOperaciones derecha = arbol.obtenerDer();
		
		try {
			arbol.insertarDer(izquierda);
			arbol.insertarIzq(derecha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String args[]) {

		try {
			ArbolOperaciones arbol = new ArbolOperaciones(Operacion.SQRT);
			arbol.insertarDer(new ArbolOperaciones(Operacion.MUL));
			arbol.obtenerDer().insertarIzq(new ArbolOperaciones(Operacion.A));
			arbol.obtenerDer().insertarDer(new ArbolOperaciones(Operacion.MUL));
			arbol.obtenerDer().obtenerDer().insertarIzq(new ArbolOperaciones(Operacion.A));
			arbol.obtenerDer().obtenerDer().insertarDer(new ArbolOperaciones(Operacion.A));
			System.out.println("");
			GenotipoArbol genotipo = new GenotipoArbol(arbol, 5);
			// genotipo.setArbol(arbol);
			// MutacionFuncionalSimple m = new MutacionFuncionalSimple();
			// m.muta(genotipo,null,0);
			System.out.println(arbol.operar(1.52));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	

}
