package mutacion;

import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;

public class MutacionTerminalSimple<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	/**
	 *  Se selecciona al azar un s�mbolo
		terminal dentro del individuo, y se sustituye por otro diferente
		del conjunto de s�mbolos terminales posibles
	 */
	
	
	
	@Override
	public void muta(GenotipoArbol genotipo, FenotipoArbol fenotipo, double prob_mutacion) {
		// TODO Auto-generated method stub
		
	}

}
