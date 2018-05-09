package bloating;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;
import individuo.Individuo;

public interface Bloating <GenotipoR extends Genotipo, FenotipoR extends Fenotipo, FitnessR extends Fitness>
{
	void
	setFitnessConBloating(ArrayList<Individuo<GenotipoR, FenotipoR, FitnessR>> poblacion, Configuracion c);

}
