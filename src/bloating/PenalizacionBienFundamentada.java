package bloating;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;

public class PenalizacionBienFundamentada<FenotipoPBF extends Fenotipo>
implements Bloating<GenotipoArbol, FenotipoPBF, FitnessReal>  {

	@Override
	public void setFitnessConBloating(ArrayList<Individuo<GenotipoArbol, FenotipoPBF, FitnessReal>> individuos, Configuracion c)
	{
		Double mediaProfundidad = calcularMediaProfundidad(individuos);
		Double mediaFitness = calcularMediaFitness(individuos);
		
		Double covarianza = calcularCovarianza(individuos, mediaProfundidad, mediaFitness);
		Double varianza = calcularVarianza(individuos, mediaFitness);
		
		Double coeficiente = covarianza / varianza;
		
		for(Individuo<GenotipoArbol, FenotipoPBF, FitnessReal> individuo : individuos)
		{
			individuo.setFitness(new FitnessReal(individuo.getFitness().getValor() - coeficiente * individuo.getGenotipo().getArbol().getProfundidad()));
			System.out.println("PROFUNDIDAD " + individuo.getGenotipo().getArbol().getProfundidad());
		}
	}

	private Double calcularVarianza(ArrayList<Individuo<GenotipoArbol, FenotipoPBF, FitnessReal>> individuos,
			Double mediaFitness)
	{
		Double varianza = 0.0;
		
		for(Individuo<GenotipoArbol, FenotipoPBF, FitnessReal> individuo : individuos)
		{
			varianza += Math.pow(individuo.getFitness().getValor() - mediaFitness, 2);
		}
		
		varianza /= individuos.size();
		
		return varianza;
	}

	private Double calcularCovarianza(ArrayList<Individuo<GenotipoArbol, FenotipoPBF, FitnessReal>> individuos,
			Double mediaProfundidad, Double mediaFitness)
	{
		Double covarianza = 0.0;
		Double productoMedias = mediaProfundidad * mediaFitness;
		
		for(Individuo<GenotipoArbol, FenotipoPBF, FitnessReal> individuo : individuos)
		{
			covarianza += individuo.getFitness().getValor() * individuo.getGenotipo().getArbol().getProfundidad() - productoMedias;
		}
		
		covarianza /= individuos.size();
		
		return covarianza;
	}

	private Double calcularMediaFitness(ArrayList<Individuo<GenotipoArbol, FenotipoPBF, FitnessReal>> individuos)
	{
		Double mediaFitness = 0.0;
		
		for(Individuo<GenotipoArbol, FenotipoPBF, FitnessReal> individuo : individuos)
		{
			mediaFitness += individuo.getFitness().getValor();
		}
		
		mediaFitness /= individuos.size();
		
		return mediaFitness;
	}

	private Double calcularMediaProfundidad(ArrayList<Individuo<GenotipoArbol, FenotipoPBF, FitnessReal>> individuos)
	{
		Double mediaProfundidad = 0.0;
		
		for(Individuo<GenotipoArbol, FenotipoPBF, FitnessReal> individuo : individuos)
		{
			mediaProfundidad += individuo.getGenotipo().getArbol().getProfundidad();
		}
		
		mediaProfundidad /= individuos.size();
		
		return mediaProfundidad;
	}



}
