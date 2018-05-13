package funcion;

import java.util.ArrayList;

import bloating.FactoriaBloating;
import configuracion.Configuracion;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;
import utils.OperacionesSeleccionadas;

public class FuncionArbolAntigua extends Funcion<GenotipoArbol, FenotipoArbol, FitnessReal> {

	private Configuracion configuracion;

	public FuncionArbolAntigua(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion,
			Configuracion configuracion) {

		super(poblacion, configuracion);
		this.configuracion = configuracion;

	}

	@Override
	public void algEvalua(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion) {

		for (int i = 0; i < poblacion.size(); i++) {
			GenotipoArbol genotipo = (GenotipoArbol) poblacion.get(i).getGenotipo();
			double fitness = evalua(genotipo.getArbol());
			poblacion.get(i).setFitness(new FitnessReal(fitness));
		}

		FactoriaBloating factoria = new FactoriaBloating();
		factoria.getBloating(this.configuracion.getBloating_seleccionado()).setFitnessConBloating(poblacion,
				configuracion);
	}

	private double evalua(ArbolOperaciones arbol) {
	//	System.out.println("TODAS " + OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesTodasSeleccionadas().toString());
	//	System.out.println("BINARIAS " + OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesBinariosSeleccionados().toString());
	//	System.out.println("unarias " + OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesUnariasSeleccionadas().toString());
	//	System.out.println("0 " + OperacionesSeleccionadas.getOperacionesSeleccionadas().getOperacionesCeroariosSeleccionados().toString());

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
	public Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> mejor(
			ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion) {

		Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> mejor = poblacion.get(0);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getFitness().getValor() > mejor.getFitness().getValor())
				mejor = poblacion.get(i);
		}
		return mejor.cloneIndividuo();

	}

	@Override
	public Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> peor(
			ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion) {

		Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> peor = poblacion.get(0);
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
