package mutacion;

import java.util.ArrayList;
import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoArbol;
import fitness.Fitness;
import genotipo.GenotipoArbol;
import utils.ArbolOperaciones;
import utils.Operacion;
import utils.OperacionesSeleccionadas;

public class Permutacion<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoArbol, FenotipoArbol, FitnessUPB> {

	/**
	 * Se selecciona al azar una función dentro del individuo, y se sustituye
	 * por otra diferente del conjunto de funciones posibles con el mismo número
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

	public static void main(String args[])
	{

		try
		{
			ArbolOperaciones a1 = new ArbolOperaciones(Operacion.A);
			ArbolOperaciones sqrt = new ArbolOperaciones(Operacion.SQRT, a1);
			
			ArbolOperaciones a2 = new ArbolOperaciones(Operacion.A);
			ArbolOperaciones log = new ArbolOperaciones(Operacion.LOG, a2);
			
			ArbolOperaciones suma = new ArbolOperaciones(sqrt, Operacion.RESTA, log);
			
			Permutacion permutacion = new Permutacion();
			
			GenotipoArbol genotipo = new GenotipoArbol(suma, 5);
			FenotipoArbol fenotipo = new FenotipoArbol();
			
			permutacion.muta(genotipo, fenotipo, 100);
			
			System.out.println(suma.operar(100));
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

	}

	

}
