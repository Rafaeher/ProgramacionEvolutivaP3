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
		int aux = r.nextInt(2);
		//Obtiene el numero de nodos con esa funcion
		int numFunciones = numFuncion(genotipo.getArbol(), aux);
		//Calcula cual de esos nodos va a mutar
		if(numFunciones > 0){
			int mutar = r.nextInt(numFunciones) + 1;
			
			int numFuncion;
			if(aux == 0) numFuncion = 1;
			else numFuncion = 2;
			
			System.out.println("");
			inorden(genotipo.getArbol(),numFuncion,mutar,0);
			System.out.println("");
		}
		
		
	}
	
	
	 private void inorden(ArbolOperaciones a, int funcion, int numFuncion, int numAux) {
	        if (a != null && numAux <= numFuncion) {
	        	if(a.obtenerRaiz().getNumOperandos() == funcion){
	        		numAux += 1;
	        		if(numAux == numFuncion){
	        			//Mutacion
	        			System.out.println("TOCA MUTAR");
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
		Operacion[] binarios = {Operacion.SUMA,Operacion.RESTA,Operacion.MUL,Operacion.DIV};
		Operacion[] unarios = {Operacion.LOG,Operacion.SQRT,Operacion.OPUESTO};
		if(tipo == 2){
			return binarios[r.nextInt(binarios.length)];
		}
		else if(tipo == 1){
			return unarios[r.nextInt(unarios.length)];
		}
		else return null;
	}

	public static void main(String args[])
	{
		
		try {
			ArbolOperaciones arbol = new ArbolOperaciones(Operacion.SQRT);
			arbol.insertarDer(new ArbolOperaciones(Operacion.MUL));
			arbol.obtenerDer().insertarIzq(new ArbolOperaciones(Operacion.A));
			arbol.obtenerDer().insertarDer(new ArbolOperaciones(Operacion.MUL));
			arbol.obtenerDer().obtenerDer().insertarIzq(new ArbolOperaciones(Operacion.A));
			arbol.obtenerDer().obtenerDer().insertarDer(new ArbolOperaciones(Operacion.A));
			System.out.println("");
			GenotipoArbol genotipo = new GenotipoArbol(arbol);
		//	genotipo.setArbol(arbol);
		//	MutacionFuncionalSimple m = new MutacionFuncionalSimple();
		//	m.muta(genotipo,null,0);
			System.out.println(arbol.operar(1.52));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}
