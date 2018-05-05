package funcion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.Genotipo;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;

public class FuncionArbol<GenotipoFD extends Genotipo> extends Funcion<GenotipoFD, FenotipoArbol, FitnessReal> {

	public FuncionArbol(ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion,
			Configuracion configuracion) {

		super(poblacion, configuracion);

	}

	@Override
	public void algEvalua(ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion) {
		for (int i = 0; i < poblacion.size(); i++) {
			GenotipoArbol genotipo = (GenotipoArbol) poblacion.get(i).getGenotipo();
			double fitness = evalua(genotipo.getArbol());
			poblacion.get(i).setFitness(new FitnessReal(fitness));
		}

	}

	private double evalua(ArbolOperaciones arbol) {
		double fitness = 0.0;
		// Venus
		if (arbol.operar(0.72) >= 0.61 && arbol.operar(0.72) < 0.62) {
			fitness += 1.0;
		}
		// Tierra
		if (arbol.operar(1.00) >= 0.61 && arbol.operar(1.00) < 1.01) {
			fitness += 1.0;
		}
		// Marte
		if (arbol.operar(1.52) >= 1.84 && arbol.operar(1.52) < 1.88) {
			fitness += 1.0;
		}
		// Jupiter
		if (arbol.operar(5.20) >= 11.85 && arbol.operar(5.20) < 12.0) {
			fitness += 1.0;
		}
		// Saturno
		if (arbol.operar(9.53) >= 29.4 && arbol.operar(9.53) < 29.5) {
			fitness += 1.0;
		}
		// Urano
		if (arbol.operar(19.1) >= 83.4 && arbol.operar(19.1) < 83.6) {
			fitness += 1.0;
		}
		return fitness;
	}

	@Override
	public Individuo<GenotipoFD, FenotipoArbol, FitnessReal> mejor(
			ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion) {


			Individuo<GenotipoFD, FenotipoArbol, FitnessReal> mejor = poblacion.get(0);
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getFitness().getValor() > mejor.getFitness().getValor())
					mejor = poblacion.get(i);
			}
			return mejor.cloneIndividuo();
		
	}

	@Override
	public Individuo<GenotipoFD, FenotipoArbol, FitnessReal> peor(
			ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion) {



		Individuo<GenotipoFD, FenotipoArbol, FitnessReal> peor = poblacion.get(0);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getFitness().getValor() < peor.getFitness().getValor())
				peor = poblacion.get(i);
		}
		return peor.cloneIndividuo();
		
	}

	@Override
	public boolean getMaximizar() {
		return true;
	}

}
