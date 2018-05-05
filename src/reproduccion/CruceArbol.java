package reproduccion;

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
import utils.Operacion;

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
				cruza(individuo1, individuo2, poblacionFinal, random);
			}
		}
		
		return numCruces;
	}

	private void cruza(Individuo<GenotipoArbol, FenotipoCA, FitnessCA> individuo1,
			Individuo<GenotipoArbol, FenotipoCA, FitnessCA> individuo2,
			ArrayList<Individuo<GenotipoArbol, FenotipoCA, FitnessCA>> poblacionFinal, Random random)
	{
		ArbolOperaciones arbol1 = (ArbolOperaciones) individuo1.getGenotipo().getArbol().clone(),
				arbol2 = (ArbolOperaciones) individuo2.getGenotipo().getArbol().clone();
		int indice1 = random.nextInt(arbol1.getNumNodos()), indice2 = random.nextInt(arbol2.getNumNodos());
		ArbolOperaciones nodo1 = arbol1.buscaNodoK(indice1), nodo2 = arbol2.buscaNodoK(indice2);
		
		try
		{
			arbol1.reemplazaNodoK(indice1, nodo2);
		}
		catch(Exception e)
		{
			arbol1 = nodo2;
		}
		
		try
		{
			arbol2.reemplazaNodoK(indice2, nodo1);
		}
		catch(Exception e)
		{
			arbol2 = nodo1;
		}
		
		GenotipoArbol genotipo1 = new GenotipoArbol(arbol1), genotipo2 = new GenotipoArbol(arbol2);
		Individuo<GenotipoArbol, FenotipoCA, FitnessCA> nuevoIndividuo1 = individuo1.cloneIndividuo(),
				nuevoIndividuo2 = individuo2.cloneIndividuo();
		
		individuo1.setGenotipo(genotipo1);
		individuo2.setGenotipo(genotipo2);

		poblacionFinal.add(individuo1);
		poblacionFinal.add(individuo2);
	}
	
	public static void main(String args[])
	{
		FenotipoArbol fenotipo1 = new FenotipoArbol(), fenotipo2 = new FenotipoArbol();
		FitnessReal fitness1 = new FitnessReal(0.0), fitness2 = new FitnessReal(0.0);
		Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> ind1 = new Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>(null, fenotipo1, fitness1),
		ind2 = new Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>(null, fenotipo2, fitness2);
		
		ArbolOperaciones
		t1 = new ArbolOperaciones(Operacion.A),
		t2 = new ArbolOperaciones(Operacion.A),
		t3 = new ArbolOperaciones(Operacion.A),
		t4 = new ArbolOperaciones(Operacion.A),
		t5 = new ArbolOperaciones(Operacion.A),
		mul1 = new ArbolOperaciones(t1, Operacion.MUL, t2),
		mul2 = new ArbolOperaciones(t3, Operacion.MUL, mul1),
		sqrt = new ArbolOperaciones(Operacion.SQRT, mul2);
		
		ArbolOperaciones t6 = new ArbolOperaciones(Operacion.A),
		t7 = new ArbolOperaciones(Operacion.A),
		t8 = new ArbolOperaciones(Operacion.A),
		t9 = new ArbolOperaciones(Operacion.A),
		t10 = new ArbolOperaciones(Operacion.A),
		mul3 = new ArbolOperaciones(t6, Operacion.MUL, t7),
		mul4 = new ArbolOperaciones(t8, Operacion.MUL, mul3),
		sqrt2 = new ArbolOperaciones(Operacion.SQRT, mul4);
		
		GenotipoArbol genotipo1 = new GenotipoArbol(sqrt), genotipo2 = new GenotipoArbol(sqrt2);
		ind1.setGenotipo(genotipo1);
		ind2.setGenotipo(genotipo2);
		
		ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> poblacionFinal = new ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>();
		Random rand = new Random();
		
		CruceArbol<FenotipoArbol, FitnessReal> cruce = new CruceArbol<FenotipoArbol, FitnessReal>();
		
		cruce.cruza(ind1, ind2, poblacionFinal, rand);
		
		System.out.println(poblacionFinal.get(0).getGenotipo().getArbol());
		System.out.println(poblacionFinal.get(1).getGenotipo().getArbol());
	}
	
	

}
