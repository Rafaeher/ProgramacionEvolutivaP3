package bloating;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import individuo.Individuo;

public class PenalizacionBienFundamentada<FenotipoCA extends Fenotipo, FitnessCA extends Fitness>
implements Bloating<GenotipoArbol, FenotipoCA, FitnessCA>  {

	@Override
	public void setFitnessConBloating(ArrayList<Individuo<GenotipoArbol, FenotipoCA, FitnessCA>> individuo, Configuracion c) {
		
	}



}
