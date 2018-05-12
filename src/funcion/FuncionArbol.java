package funcion;

import java.util.ArrayList;
import java.util.HashMap;

import bloating.FactoriaBloating;
import configuracion.Configuracion;
import dao.DAOPeriodos;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;
import utils.OperacionesSeleccionadas;

public class FuncionArbol extends Funcion<GenotipoArbol, FenotipoArbol, FitnessReal>
{

	private static HashMap<Double, Double> periodos;
	
	public FuncionArbol(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion, Configuracion configuracion)
	{
		super(poblacion, configuracion);
		
		if (periodos == null)
			periodos = DAOPeriodos.leerPeriodos();
	}

	@Override
	public void algEvalua(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion)
	{

		for (int i = 0; i < poblacion.size(); i++)
		{
			GenotipoArbol genotipo = (GenotipoArbol) poblacion.get(i).getGenotipo();
			double fitness = evalua(genotipo.getArbol());
			poblacion.get(i).setFitness(new FitnessReal(fitness));
		}

		FactoriaBloating factoria = new FactoriaBloating();
		factoria.getBloating(this.configuracion.getBloating_seleccionado()).setFitnessConBloating(poblacion,
				configuracion);
	}

	private double evalua(ArbolOperaciones arbol)
	{
		Double fitness = 0.0;

		Double media = calcularMediaError(arbol);
		
		for(Double periodo : periodos.keySet())
		{
			fitness += Math.abs(periodo - arbol.operar(periodos.get(periodo)));
		}
		
		fitness /= periodos.keySet().size();
		
		if (arbol.getProfundidad() > configuracion.getProfundidadMaxima())
			fitness += arbol.getNumNodos() * arbol.getProfundidad();
		
		return fitness;
	}

	
	
	private Double calcularMediaError(ArbolOperaciones arbol)
	{
		Double media = 0.0;
		
		for(Double periodo : periodos.keySet())
		{
			media += Math.abs(periodo - arbol.operar(periodos.get(periodo)));
		}
		
		media /= periodos.keySet().size();
		
		return media;
	}

	@Override
	public Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> mejor(
			ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion) {

		Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> mejor = poblacion.get(0);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getFitness().getValor() < mejor.getFitness().getValor())
				mejor = poblacion.get(i);
		}
		return mejor.cloneIndividuo();

	}

	@Override
	public Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> peor(
			ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion) {

		Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> peor = poblacion.get(0);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getFitness().getValor() > peor.getFitness().getValor())
				peor = poblacion.get(i);
		}
		return peor.cloneIndividuo();

	}

	@Override
	public boolean getMaximizar() {
		return false;
	}

}
