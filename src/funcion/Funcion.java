package funcion;

import java.util.ArrayList;
import java.util.Random;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;
import individuo.ComparadorIndividuo;
import individuo.Individuo;
import reproduccion.FactoriaReproduccion;
import reproduccion.Reproduccion;
import seleccion.FactoriaSeleccion;
import seleccion.Seleccion;

public abstract class Funcion<GenotipoF extends Genotipo, FenotipoF extends Fenotipo, FitnessF extends Fitness>
{
	private ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> poblacion;
	private Configuracion configuracion;
	protected Individuo<GenotipoF, FenotipoF, FitnessF> mejorIndividuo;

	private double[] x_generaciones;
	private double[] y_mejor_iteracion;
	private double[] y_mejor_total;
	private double[] y_media;
	private double mejorAbsoluto;
	private double peorAbsoluto;
	private Integer totalCruces;
	private Integer totalMutaciones;
	private double media;
	

	public Funcion(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> poblacion, Configuracion configuracion)
	{
		this.poblacion = poblacion;
		this.configuracion = configuracion;
		this.x_generaciones = new double[configuracion.getNum_generaciones()];
		this.y_mejor_iteracion = new double[configuracion.getNum_generaciones()];
		this.y_mejor_total = new double[configuracion.getNum_generaciones()];
		this.y_media = new double[configuracion.getNum_generaciones()];
		this.totalCruces = 0;
		this.totalMutaciones = 0;
		this.media = 0;
		
	}
	
	public void algoritmoGenetico()
	{
		ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> elite = new ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>>();
		int it = 0;
		
		// Evaluación inicial
		algEvalua(poblacion);
		mejorAbsoluto = mejor(poblacion).getFitness().getValorReal();
		peorAbsoluto = peor(poblacion).getFitness().getValorReal();
		
		while (it < configuracion.getNum_generaciones() - 1)
        {		
			it++;
			
			elite = (ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>>)calculaLosMejoresDeLaPoblacion(poblacion, configuracion.getElite());
			
			//seleccion
			algSeleccion(poblacion);
			
			//reproduccion
			if(configuracion.getCruceporcentaje() > 0)
			{
				algReproduccion(poblacion);
			}
			
			//Mutacion
			if(configuracion.getProb_mutacion() > 0)
			{
				algMutacion(poblacion);
			}
			
			algEvalua(poblacion);
			
			colocaLaelite(elite);
			
			obtenerEstadisticas(it);
			
			System.out.println("Iteracion " + it);
			
		}
	}

	private void algSeleccion(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> individuos_iniciales)
    {
		FactoriaSeleccion<GenotipoF, FenotipoF, FitnessF> factoriaSeleccion = new FactoriaSeleccion<GenotipoF, FenotipoF, FitnessF>();

		//Obtenemos el mecanismo de seleccion
		Seleccion<GenotipoF, FenotipoF, FitnessF> seleccion = factoriaSeleccion.getSeleccion(this.configuracion.getSeleccion_seleccionada());

		//Seleccionamos los individuos por el mecanismo adecuado
		this.poblacion = seleccion.selecciona(individuos_iniciales, configuracion, getMaximizar());
	}

	private void algReproduccion(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> seleccionados){
		FactoriaReproduccion<GenotipoF, FenotipoF, FitnessF> factoriaReproduccion = new FactoriaReproduccion<GenotipoF, FenotipoF, FitnessF>();
		//Obtenemos el mecanismo de reproduccion
		Reproduccion<GenotipoF, FenotipoF, FitnessF> reproduccion = factoriaReproduccion.getReproduccion(this.configuracion.getReproduccion_seleccionada());
		//Reproducimos los individuos y devolvemos la poblacion con los individuos nuevos en ella
			this.totalCruces += reproduccion.reproduce(seleccionados, configuracion, poblacion);
	}

	private void algMutacion(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> reproducidos)
	{
		Random r = new Random();
		for(int i = 0; i < reproducidos.size(); i++)
		{
			if(r.nextDouble() < configuracion.getProb_mutacion())
			{
				totalMutaciones++;
				reproducidos.get(i).muta(configuracion.getMutacion_seleccionada(), configuracion.getProb_mutacion());
			}
		}
	}
	
	private void obtenerEstadisticas(int it)
	{
		//Para pintar
		x_generaciones[it] = it;
		Individuo<GenotipoF, FenotipoF, FitnessF> mejor = poblacion.get(0);
		Individuo<GenotipoF, FenotipoF, FitnessF> peor = poblacion.get(0);
		y_media[it] = poblacion.get(0).getFitness().getValorReal();
		
		ComparadorIndividuo<GenotipoF, FenotipoF, FitnessF> comparador = new ComparadorIndividuo<GenotipoF, FenotipoF, FitnessF>(getMaximizar());
		
		for(int i = 1; i < poblacion.size(); i++)
		{
			if(comparador.compare(mejor, poblacion.get(i)) > 0)
			{
				mejor = poblacion.get(i);
			}
			
			if (comparador.compare(peor, poblacion.get(i)) < 0)
			{
				peor = poblacion.get(i);
			}
			
			y_media[it] += poblacion.get(i).getFitness().getValorReal();
		}
		
		y_media[it] = y_media[it] / poblacion.size();
		
		FitnessF mejorFitness = mejor.getFitness();
		FitnessF peorFitness = peor.getFitness();
		
		try
		{
			y_mejor_iteracion[it] = mejorFitness.getValorReal();
		}
		catch(Exception e){
			System.err.println("Error en pintar(int) de Funcion");
		}
		
		if(getMaximizar())
		{
			if(mejorFitness.getValorReal() > mejorAbsoluto)
			{
				mejorAbsoluto = mejorFitness.getValorReal();
			}
			
			if(peorFitness.getValorReal() < peorAbsoluto)
			{
				peorAbsoluto = peorFitness.getValorReal();
			}
		}
		else
		{
			if(mejorFitness.getValorReal() < mejorAbsoluto)
			{
				mejorAbsoluto = mejorFitness.getValorReal();
			}
			
			if(peorFitness.getValorReal() > peorAbsoluto)
			{
				peorAbsoluto = peorFitness.getValorReal();
			}
		}
		
		y_mejor_total[it] = mejorAbsoluto;
	}

	public double[] getGeneraciones()
	{
		return x_generaciones;
	}
	public double[] getmejoriteracion()
	{
		return y_mejor_iteracion;
	}
	public double[] gety_mejor_total()
	{
		return y_mejor_total;
	}
	public double[] getMedia()
	{
		return y_media;
	}
	
	public double getMejorAbsoluto()
	{
		return this.mejorAbsoluto;
	}
	
	public double getPeorAbsoluto()
	{
		return this.peorAbsoluto;
	}
	
	public Integer getTotalCruces()
	{
		return totalCruces;
	}
	
	public Integer getTotalMutaciones()
	{
		return totalMutaciones;
	}
	
	public abstract void algEvalua(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> poblacion);
	
	public void colocaLaelite(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> elite)
	{
		poblacion.sort(new ComparadorIndividuo<GenotipoF, FenotipoF, FitnessF>(getMaximizar()));
		
		for(int i = 0; i < elite.size(); i++)
		{
			poblacion.set(poblacion.size() - 1 - i, elite.get(i).cloneIndividuo());
		}
		
	}
	public abstract Individuo<GenotipoF, FenotipoF, FitnessF> mejor(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> poblacion);
	
	public abstract Individuo<GenotipoF, FenotipoF, FitnessF> peor(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> poblacion);
	
	public ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> calculaLosMejoresDeLaPoblacion(ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> poblacion, int tam)
	{
		poblacion.sort(new ComparadorIndividuo<GenotipoF, FenotipoF, FitnessF>(getMaximizar()));
		ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>> mejores = new ArrayList<Individuo<GenotipoF, FenotipoF, FitnessF>>();
		for(int i = 0; i < tam && i < poblacion.size(); i++)
			mejores.add(poblacion.get(i).cloneIndividuo());
		
		return mejores;
		
	}
	
	public abstract boolean getMaximizar();
	
	public Individuo<GenotipoF, FenotipoF, FitnessF> getMejor()
	{
		poblacion.sort(new ComparadorIndividuo(getMaximizar()));
		return poblacion.get(0);
	}
}
