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

public class MutacionTerminalSimple<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	/**
	 *  Se selecciona al azar un s�mbolo
		terminal dentro del individuo, y se sustituye por otro diferente
		del conjunto de s�mbolos terminales posibles
	 */
	
	@Override
	public void muta(GenotipoArbol genotipo, FenotipoArbol fenotipo, double prob_mutacion) {
		Random r = new Random();
		//Obtiene el numero de nodos con esa funcion
		int numFunciones = genotipo.getArbol().getNum_0();
		//Calcula cual de esos nodos va a mutar
		if(numFunciones > 0){
			int mutar = r.nextInt(numFunciones) + 1;
			
			int numFuncion = 0;
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

	private Operacion mutacion(int tipo){
		Random r = new Random();
		ArrayList<Operacion> cero = OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesCeroariosSeleccionados();

		return cero.get(r.nextInt(cero.size()));
	}
}
