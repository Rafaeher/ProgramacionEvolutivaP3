package poblacionInicial;

import java.util.ArrayList;
import configuracion.Configuracion;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;

public class FactoriaPoblacionInicial
{
	@SuppressWarnings("unchecked")
	public ArrayList<?> getPrimeraPoblacion(Configuracion configuracion)
	{
		ArrayList<?> result = null;
		
		result = new ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>(configuracion.getTamano_poblacion());
		
		for(int i = 0; i < configuracion.getTamano_poblacion(); i++)
		{
			Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> individuo = new Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>();
			
			FactoriaMetodoInicializacion factoria = new FactoriaMetodoInicializacion();
			InicializacionArbol iniArbol = factoria.getIniArbol(configuracion.getIniArbol());
			ArbolOperaciones arbol = iniArbol.inicializacionAleatoria(configuracion.getProfundidadMaxima());
			
			
			GenotipoArbol genotipo = new GenotipoArbol(arbol,configuracion.getProfundidadMaxima());

			FenotipoArbol fenotipo = new FenotipoArbol();
			
			//Falta decodificar el arbol
			individuo.setGenotipo(genotipo);
			individuo.setFenotipo(fenotipo);
			
			System.out.println();
			((ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>) result).add(individuo);
			
			}
		
		return result;
	}

}
