package mutacion;

import java.util.ArrayList;
import java.util.Random;

import configuracion.Configuracion;
import decodificador.Decodificador;
import fenotipo.FenotipoMensaje;
import fitness.FitnessReal;
import funcion.FactoriaFunciones;
import funcion.Funcion;
import genotipo.GenotipoAlfabeto;
import individuo.Individuo;
import utils.Constantes;

public class Heuristica  implements Mutacion<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>
{

	@Override
	public void muta(GenotipoAlfabeto genotipo, FenotipoMensaje fenotipo, double prob_mutacion)
	{
		Random random = new Random();
		
		if (random.nextDouble() <= prob_mutacion)
		{
			ArrayList<Integer> posiciones = new ArrayList<Integer>();
			
			while(posiciones.size() < 3)
			{
				int proxima = random.nextInt(Constantes.ALFABETO.length());
				
				if(!posiciones.contains(proxima))
				{
					posiciones.add(proxima);
				}
			}
			
			ArrayList<ArrayList<Integer>> permutaciones = obtenerPermutaciones(posiciones);
			
			ArrayList<GenotipoAlfabeto> genotipos = new ArrayList<GenotipoAlfabeto>();
			for(int i = 0; i < 6; i++)
			{	
				ArrayList<Character> codigo = genotipo.getCodigo();
				for(int j = 0; j < 3; j++)
				{
					codigo.set(posiciones.get(j), Constantes.ALFABETO.charAt(permutaciones.get(i).get(j)));
				}
				
				GenotipoAlfabeto newGenotipo = new GenotipoAlfabeto();
				newGenotipo.setCodigo(codigo);
				genotipos.add(newGenotipo);
			}
			
			ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>> individuos = new ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>>();
			for(int i = 0; i < 6; i++)
			{
				FenotipoMensaje newFenotipo = new FenotipoMensaje(fenotipo.getMensajeCodificado());
				Decodificador.decodifica(genotipos.get(i), newFenotipo);
				Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal> individuo = new Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>(genotipos.get(i));
				individuo.setFenotipo(newFenotipo);
				individuos.add(individuo);
			}
			
			FactoriaFunciones<GenotipoAlfabeto, FenotipoMensaje, FitnessReal> factoria = new FactoriaFunciones<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>();
			Configuracion config = new Configuracion(false, 0, 0.0, null,
					null, null, null, 0.0, 6, 0, fenotipo.getMensajeCodificado());
			Funcion<GenotipoAlfabeto, FenotipoMensaje, FitnessReal> funcion = factoria.getSeleccion(0, individuos, config);
			funcion.algEvalua(individuos);
			Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal> mejor = funcion.mejor(individuos);
			genotipo = mejor.getGenotipo();
			fenotipo = mejor.getFenotipo();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> obtenerPermutaciones(ArrayList<Integer> posiciones)
	{
		if (posiciones.size() != 3)
		{
			throw new IllegalArgumentException("No puede haber más de 3 posiciones");
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> permutacion0 = new ArrayList<Integer>();
		permutacion0.addAll(posiciones);
		result.add(permutacion0);
		
		for(int i = 1; i < 6; i++)
		{
			ArrayList<Integer> permutacion = new ArrayList<Integer>();
			int aux = posiciones.get(2);
			posiciones.set(2, posiciones.get(i % 2));
			posiciones.set(i % 2, aux);
			permutacion.addAll(posiciones);
			result.add(permutacion);
		}

		return result;
	}
}
