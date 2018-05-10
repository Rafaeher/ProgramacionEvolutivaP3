package mutacion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import utils.ArbolOperaciones;
import utils.Operacion;
import utils.OperacionesSeleccionadas;

public class MutacionDeArbol<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	@Override
	public void muta(GenotipoArbol genotipo, FenotipoArbol fenotipo, double prob_mutacion) {
		Random r = new Random();
		ArrayList<ArbolOperaciones> array = new ArrayList<ArbolOperaciones>();
		inorden(genotipo.getArbol(), array);
		ArbolOperaciones arbolMutar = array.get(r.nextInt(array.size()));
		//Pone un arbol de tamaño máximo el tamaño del arbol permitido
		mutacion(arbolMutar, genotipo.getArbol().getProfundidad() + r.nextInt(genotipo.getProfundidadMaxima()));
		
	}

	private void inorden(ArbolOperaciones a, ArrayList<ArbolOperaciones> array) {
		if (a != null) {
			array.add(a);
			inorden(a.obtenerIzq(), array);
			inorden(a.obtenerDer(), array);
		}
	}

	private void mutacion(ArbolOperaciones arbol, int profundidadMaxima) {
		if (arbol.getNivel() < profundidadMaxima) {
			Random r = new Random();
			
			ArrayList<Operacion> operaciones = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesTodasSeleccionadas();
		//	Operacion[] operaciones = Operacion.values();
		//	arbol.setRaiz(operaciones[r.nextInt(operaciones.length)]);
			arbol.setRaiz(operaciones.get(r.nextInt(operaciones.size())));
			Queue<ArbolOperaciones> nodos = new LinkedList<>();

			nodos.add(arbol);

			while (!nodos.isEmpty()) {
				ArbolOperaciones arbolAux = nodos.remove();
				if (arbolAux != null) {
					if (arbolAux.getNivel() == profundidadMaxima - 1) {
						try {
							arbolAux.forzarTamano();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						try {
							arbolAux.generarHijosAleatorios();
						} catch (Exception e) {
							e.printStackTrace();
						}
						nodos.add(arbolAux.obtenerDer());
						nodos.add(arbolAux.obtenerIzq());
					}

				}
			}

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
			GenotipoArbol genotipo = new GenotipoArbol(arbol,5);
			genotipo.setProfundidadMaxima(5);
			MutacionDeArbol mutacion = new MutacionDeArbol();
			mutacion.muta(genotipo, null, 0.0);
			// genotipo.setArbol(arbol);
			// MutacionFuncionalSimple m = new MutacionFuncionalSimple();
			// m.muta(genotipo,null,0);
			// System.out.println(arbol.operar(1.52));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
