package reproduccion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;
import individuo.Individuo;

public interface Reproduccion<GenotipoR extends Genotipo, FenotipoR extends Fenotipo, FitnessR extends Fitness>
{
	int
	reproduce(ArrayList<Individuo<GenotipoR, FenotipoR, FitnessR>> poblacionInicial, Configuracion c, ArrayList<Individuo<GenotipoR, FenotipoR, FitnessR>> poblacionFinal);
}
