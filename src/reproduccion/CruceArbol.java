package reproduccion;

import java.util.ArrayList;
import java.util.Random;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;

public class CruceArbol<FenotipoCA extends Fenotipo, FitnessCA extends Fitness>
implements Reproduccion<GenotipoArbol, FenotipoCA, FitnessCA> {

	@Override
	public int reproduce(ArrayList<Individuo<GenotipoArbol, FenotipoCA, FitnessCA>> poblacionInicial,
			Configuracion c, ArrayList<Individuo<GenotipoArbol, FenotipoCA, FitnessCA>> poblacionFinal)
	{
		int numCruces = 0;
		Random random = new Random();
		poblacionFinal = new ArrayList<Individuo<GenotipoArbol, FenotipoCA, FitnessCA>>();
		
		for(int i = 0; i < poblacionInicial.size(); i++)
		{
			if (random.nextDouble() < c.getCruceporcentaje())
			{
				numCruces++;
				
				int index1 = random.nextInt(poblacionInicial.size()), index2 = random.nextInt(poblacionInicial.size());
				Individuo<GenotipoArbol, FenotipoCA, FitnessCA> individuo1 = poblacionInicial.get(index1),
						individuo2 = poblacionInicial.get(index2);
				cruza(individuo1, individuo2, poblacionFinal, random, c.getProfundidadMaxima());
			}
		}
		
		return numCruces;
	}

	
	private void cruza(Individuo<GenotipoArbol, FenotipoCA, FitnessCA> individuo1,
			Individuo<GenotipoArbol, FenotipoCA, FitnessCA> individuo2,
			ArrayList<Individuo<GenotipoArbol, FenotipoCA, FitnessCA>> poblacionFinal, Random random, int profundidadMax)
	{
		ArbolOperaciones arbol1 = (ArbolOperaciones) individuo1.getGenotipo().getArbol().clone(),
				arbol2 = (ArbolOperaciones) individuo2.getGenotipo().getArbol().clone();
		int indice1 = random.nextInt(arbol1.getNumNodos()), indice2 = random.nextInt(arbol2.getNumNodos());
		ArbolOperaciones nodo1 = arbol1.buscaNodoK(indice1), nodo2 = arbol2.buscaNodoK(indice2);
		
		try
		{
			arbol1.reemplazaNodoK(indice1, nodo2, profundidadMax);
		}
		catch(Exception e)
		{
			arbol1 = nodo2;
		}
		
		try
		{
			arbol2.reemplazaNodoK(indice2, nodo1, profundidadMax);
		}
		catch(Exception e)
		{
			arbol2 = nodo1;
		}
		
		GenotipoArbol genotipo1 = new GenotipoArbol(arbol1,individuo1.getGenotipo().getProfundidadMaxima()), 
				genotipo2 = new GenotipoArbol(arbol2,individuo2.getGenotipo().getProfundidadMaxima());
		
		individuo1.setGenotipo(genotipo1);
		individuo2.setGenotipo(genotipo2);

		poblacionFinal.add(individuo1);
		poblacionFinal.add(individuo2);
	}
	
	
	
	


}
