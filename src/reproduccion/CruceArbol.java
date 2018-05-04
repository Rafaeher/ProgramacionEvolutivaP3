package reproduccion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import individuo.Individuo;

public class CruceArbol<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
implements Reproduccion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	@Override
	public int reproduce(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessUPB>> poblacionInicial,
			Configuracion c, ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessUPB>> poblacionFinal) {
		// TODO Auto-generated method stub
		return 0;
	}

}
