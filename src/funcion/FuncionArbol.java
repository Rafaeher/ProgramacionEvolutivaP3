package funcion;

import java.util.ArrayList;
import java.util.HashMap;

import bloating.FactoriaBloating;
import configuracion.Configuracion;
import dao.DAOEjemplos;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;

public class FuncionArbol extends Funcion<GenotipoArbol, FenotipoArbol, FitnessReal> {

	private Configuracion configuracion;
	private static HashMap<Double, Double> ejemplos;

	public FuncionArbol(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion,
			Configuracion configuracion) {

		super(poblacion, configuracion);
		this.configuracion = configuracion;
		
		if (ejemplos == null)
			ejemplos = DAOEjemplos.leerEjemplos();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void algEvalua(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion) {

		for (int i = 0; i < poblacion.size(); i++)
		{
			GenotipoArbol genotipo = (GenotipoArbol) poblacion.get(i).getGenotipo();
			
			if (genotipo.getNumNodos() > Math.pow(2, configuracion.getProfundidadMaxima()))
				genotipo.recorta(configuracion.getProfundidadMaxima());
			
			double fitness = evalua(genotipo.getArbol());
			poblacion.get(i).setFitness(new FitnessReal(fitness));
		}

		FactoriaBloating factoria = new FactoriaBloating();
		factoria.getBloating(this.configuracion.getBloating_seleccionado()).setFitnessConBloating(poblacion, configuracion);
	}

	private double evalua(ArbolOperaciones arbol)
	{
		double fitness = 0.0;
		
		for(Double entrada : ejemplos.keySet())
		{
			if (Math.abs(arbol.operar(entrada) - ejemplos.get(entrada)) < 0.1) // Si el error es inferior a una décima
			{
				fitness += 1.0;
			}
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
