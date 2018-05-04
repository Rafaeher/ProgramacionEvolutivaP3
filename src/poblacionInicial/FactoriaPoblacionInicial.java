package poblacionInicial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import configuracion.Configuracion;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import utils.ArbolOperaciones;
import utils.Operacion;

public class FactoriaPoblacionInicial
{
	@SuppressWarnings("unchecked")
	public ArrayList<?> getPrimeraPoblacion(Configuracion configuracion)
	{
		Random r = new Random();
		ArrayList<?> result = null;
		
		result = new ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>(100);
		
		for(int i = 0; i < 100; i++)
		{
			Individuo<GenotipoArbol, FenotipoArbol, FitnessReal> individuo = new Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>();
			GenotipoArbol genotipo = new GenotipoArbol();
			ArbolOperaciones arbol = inicializacionAleatoria(5);
			genotipo.setArbol(arbol);
			FenotipoArbol fenotipo = new FenotipoArbol();
			//Falta decodificar el arbol
			individuo.setGenotipo(genotipo);
			individuo.setFenotipo(fenotipo);
			
			((ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>) result).add(individuo);
			
			}
		
		return result;
	}
	
	private ArbolOperaciones inicializacionAleatoria(int max)
	{
		Random r = new Random();
		Operacion[] operandos = Operacion.values();
		
		ArbolOperaciones arbol = new ArbolOperaciones(operandos[r.nextInt(operandos.length)]);
		
		Queue<ArbolOperaciones> nodos = new LinkedList<>();
		
		nodos.add(arbol);
		
		while(!nodos.isEmpty() && arbol.getProfundidad() < max-1){
			ArbolOperaciones arbolAux = nodos.remove();
			if(arbolAux != null){
				try {
					arbolAux.generarHijosAleatorios();
				} catch (Exception e) {
					e.printStackTrace();
				}
				nodos.add(arbolAux.obtenerDer());
				nodos.add(arbolAux.obtenerIzq());
			}
		}
		while(!nodos.isEmpty()){
			ArbolOperaciones arbolAux = nodos.remove();
			if(arbolAux != null){
				try {
					arbolAux.forzarTamano();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return arbol;
	}
	public static void main(String args[])
	{
		
		FactoriaPoblacionInicial f = new FactoriaPoblacionInicial();
		
		ArrayList<?> poblacion = f.getPrimeraPoblacion(null);
		@SuppressWarnings("unchecked")
		ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> pob = (ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>) poblacion;
		System.out.println(pob.size());

				
	}
}
