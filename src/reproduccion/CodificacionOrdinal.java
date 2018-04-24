package reproduccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.GenotipoAlfabeto;
import individuo.Individuo;
import utils.AlfabetoHashMap;
import utils.Constantes;

public class CodificacionOrdinal<FenotipoCO extends Fenotipo, FitnessUPB extends Fitness>
implements Reproduccion<GenotipoAlfabeto, FenotipoCO, FitnessUPB> {

	@Override
	public int reproduce(
			ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>> poblacionInicial, Configuracion c, ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>> poblacion) {
		
		ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>> poblacionFinal = new ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>>();

		int totalCruces = 0;
		Random r = new Random();
		for (int i = 0; i < poblacionInicial.size(); i = i + 2) {

			// Obtenemos dos individuos aleatorios
			Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB> i1 = 
					poblacionInicial.get(r.nextInt(poblacionInicial.size())).cloneIndividuo();
			Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB> i2 = 
					poblacionInicial.get(r.nextInt(poblacionInicial.size())).cloneIndividuo();

			if (r.nextDouble() <= c.getCruceporcentaje()) {
				// Cruzamos los dos individuos
				ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>> individuosReproducidos = alg_reproduccion(
						i1, i2);
				poblacionFinal.add(individuosReproducidos.get(0));
				poblacionFinal.add(individuosReproducidos.get(1));
			} else {
				// No cruzamos los dos individuos y por tanto los metemos en la
				// población final
				poblacionFinal.add(i1);
				poblacionFinal.add(i2);
				totalCruces++;
			}
		
		}

		poblacion = poblacionFinal;
		
		return totalCruces;
	}

	private ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>>
	alg_reproduccion(
			Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB> i1,
			Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB> i2)
	{
		ArrayList<Integer> listaDinamica1 = new ArrayList<Integer>();
		ArrayList<Integer> listaDinamica2 = new ArrayList<Integer>();
		ArrayList<Integer> codInt1 = new ArrayList<Integer>();
		ArrayList<Integer> codInt2 = new ArrayList<Integer>();
		ArrayList<Character> codigo1 = i1.getGenotipo().getCodigo();
		ArrayList<Character> codigo2 = i2.getGenotipo().getCodigo();
		ArrayList<Integer> codOrdinal1 = new ArrayList<Integer>();
		ArrayList<Integer> codOrdinal2 = new ArrayList<Integer>();
		ArrayList<Character> resultado1 = new ArrayList<Character>();
		ArrayList<Character> resultado2 = new ArrayList<Character>();
		HashMap<Character, Integer> alfabetoHM = AlfabetoHashMap.getAlfabetoHashMap();
		Random random = new Random();
		int corte = random.nextInt(Constantes.ALFABETO.length() - 2) + 1;
		
		// Convierte el array de chars en un array de ints e inicializa las listas dinámicas
		for(int i = 0; i < Constantes.ALFABETO.length(); i++)
		{
			codInt1.add(alfabetoHM.get(codigo1.get(i)));
			codInt2.add(alfabetoHM.get(codigo2.get(i)));
			
			listaDinamica1.add(i);
			listaDinamica2.add(i);
		}
		
		// Realiza la codificación ordinal y añade los números necesarios en las listas dinámicas para la decodificación
		for(int i = 0; i < Constantes.ALFABETO.length(); i++)
		{
			int index1 = listaDinamica1.indexOf(codInt1.get(i));
			int index2 = listaDinamica2.indexOf(codInt2.get(i));

			codOrdinal1.add(index1);
			codOrdinal2.add(index2);
			
			listaDinamica1.remove(index1);
			listaDinamica2.remove(index2);
			
			listaDinamica1.add(i);
			listaDinamica2.add(i);
		}
		
		// Cruce
		for(int i = corte; i < Constantes.ALFABETO.length(); i++)
		{
			Integer aux = codOrdinal1.get(i);
			codOrdinal1.set(i, codOrdinal2.get(i));
			codOrdinal2.set(i, aux);
		}
		
		ArrayList<Integer> prueba = new ArrayList<Integer>();
		
		// Realiza la decodificación
		for(int i = 0; i < Constantes.ALFABETO.length(); i++)
		{
			int index1 = codOrdinal1.get(i);
			int index2 = codOrdinal2.get(i);
			
			resultado1.add(Constantes.ALFABETO.charAt(listaDinamica1.get(index1)));
			resultado2.add(Constantes.ALFABETO.charAt(listaDinamica2.get(index2)));
			
			
			listaDinamica1.remove(index1);
			listaDinamica2.remove(index2);
		}
		
		GenotipoAlfabeto g1 = new GenotipoAlfabeto();
		GenotipoAlfabeto g2 = new GenotipoAlfabeto();
		
		g1.setCodigo(resultado1);
		g2.setCodigo(resultado2);
		
		Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB> i1Clon = i1.cloneIndividuo();
		Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB> i2Clon = i2.cloneIndividuo();
		
		i1Clon.setGenotipo(g1);
		i2Clon.setGenotipo(g2);

		ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>> arrayResultado = new ArrayList<Individuo<GenotipoAlfabeto, FenotipoCO, FitnessUPB>>();
		arrayResultado.add(i1Clon);
		arrayResultado.add(i2Clon);
		
		return arrayResultado;
	}
}
