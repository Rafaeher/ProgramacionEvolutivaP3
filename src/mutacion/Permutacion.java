package mutacion;

import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import utils.ArbolOperaciones;

public class Permutacion<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	/**
	 * Se selecciona al azar una funci�n dentro del individuo, y se sustituye
	 * por otra diferente del conjunto de funciones posibles con el mismo n�mero
	 * de operandos
	 */
	@Override
	public void muta(GenotipoArbol genotipo, FenotipoArbol fenotipo, double prob_mutacion)
	{
		Random r = new Random();
		
		// Obtiene el numero de nodos con esa funcion
		int numFunciones = genotipo.getArbol().getNum_2();
		
		// Calcula cual de esos nodos va a mutar
		if (numFunciones > 0)
		{
			int numNodo = r.nextInt(numFunciones);
			buscaNodoYPermuta(genotipo.getArbol(), numNodo, 0);
		}

	}

	private void buscaNodoYPermuta(ArbolOperaciones arbol, int numNodoFin, int numNodoActual)
	{
		if (arbol != null)
		{		
			if (numNodoActual == numNodoFin && arbol.obtenerRaiz().getNumOperandos() == 2)
			{
				permuta(arbol);
			}
			else
			{
				buscaNodoYPermuta(arbol.obtenerIzq(), numNodoFin, numNodoActual);
				buscaNodoYPermuta(arbol.obtenerDer(), numNodoFin, numNodoActual);
			}
			
			if (arbol.obtenerRaiz().getNumOperandos() == 2)
			{
				numNodoActual++;
			}
		}
	}

	private void permuta(ArbolOperaciones arbol)
	{	
		ArbolOperaciones izquierda = arbol.obtenerIzq();
		ArbolOperaciones derecha = arbol.obtenerDer();
		
		try
		{
			arbol.insertarDer(izquierda);
			arbol.insertarIzq(derecha);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
