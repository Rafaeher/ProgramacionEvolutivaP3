package bloating;

import java.util.ArrayList;
import java.util.Random;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;

public class Tarpeian<FenotipoCA extends Fenotipo, FitnessCA extends Fitness>
implements Bloating<GenotipoArbol, FenotipoArbol, FitnessReal>  {

	private double fitnessPoblacion;
	
	@Override
	public void setFitnessConBloating(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion, Configuracion c) {
		
		fitnessPoblacion = calculaMediaTamPoblacion(poblacion);
		
		for(int i = 0; i < poblacion.size(); i++){
			
			Individuo individuo = poblacion.get(i);
			
			GenotipoArbol genotipo = (GenotipoArbol) individuo.getGenotipo();
			
			ArbolOperaciones arbol = genotipo.getArbol();
			
			if(arbol.getProfundidad() > fitnessPoblacion){
				Random r = new Random();
				if(r.nextDouble() > 0.5){
					individuo.setFitness(new FitnessReal(individuo.getFitness().getValorReal() / 10 ));
				}
			}
		}
	}
	private double calculaMediaTamPoblacion(ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacion){
		double media = 0.0;
		for(int i = 0; i < poblacion.size(); i++){
			media += poblacion.get(i).getGenotipo().getArbol().getProfundidad();
		}
		media /= poblacion.size();
		return media;
	}

}
