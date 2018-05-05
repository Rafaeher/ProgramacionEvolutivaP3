package presentacion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import funcion.FactoriaFunciones;
import funcion.Funcion;
import genotipo.GenotipoArbol;
import individuo.Individuo;
import poblacionInicial.FactoriaPoblacionInicial;

public class Controlador {
	
	
	public void execute(Configuracion c)
	{
		FactoriaPoblacionInicial factoriaPrimeraPoblacion = new FactoriaPoblacionInicial();
		ArrayList<?> poblacion = factoriaPrimeraPoblacion.getPrimeraPoblacion(c);
		@SuppressWarnings("unchecked")
		ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> pob = (ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>) poblacion;
		FactoriaFunciones<GenotipoArbol, FenotipoArbol, FitnessReal> factoriaFunciones = new FactoriaFunciones<GenotipoArbol, FenotipoArbol, FitnessReal>();
		Funcion<GenotipoArbol, FenotipoArbol, FitnessReal> funcion = factoriaFunciones.getSeleccion(1, pob, c);
		funcion.algoritmoGenetico();
		Vista.getVista().repintaGrafica(funcion.getGeneraciones(), funcion.getmejoriteracion(), funcion.gety_mejor_total(),
				funcion.getMedia(), "", funcion.getMejorAbsoluto(),
				funcion.getPeorAbsoluto(), funcion.getTotalCruces(), funcion.getTotalMutaciones());
	}
	
	
	
}
