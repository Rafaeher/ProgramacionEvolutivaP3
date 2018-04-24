package presentacion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.FenotipoMensaje;
import fitness.FitnessReal;
import funcion.FactoriaFunciones;
import funcion.Funcion;
import genotipo.GenotipoAlfabeto;
import individuo.Individuo;
import poblacionInicial.FactoriaPoblacionInicial;

public class Controlador {
	
	
	public void execute(Configuracion c)
	{
		FactoriaPoblacionInicial factoriaPrimeraPoblacion = new FactoriaPoblacionInicial();
		ArrayList<?> poblacion = factoriaPrimeraPoblacion.getPrimeraPoblacion(c);
		@SuppressWarnings("unchecked")
		ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>> pob = (ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessReal>>) poblacion;
		FactoriaFunciones<GenotipoAlfabeto,FenotipoMensaje, FitnessReal> factoriaFunciones = new FactoriaFunciones<GenotipoAlfabeto,FenotipoMensaje, FitnessReal>();
		Funcion<GenotipoAlfabeto, FenotipoMensaje, FitnessReal> funcion = factoriaFunciones.getSeleccion(1, pob, c);
		funcion.algoritmoGenetico();
		Vista.getVista().repintaGrafica(funcion.getGeneraciones(), funcion.getmejoriteracion(), funcion.gety_mejor_total(),
				funcion.getMedia(), funcion.getMejor().getFenotipo().getMensajeDecodificado(), funcion.getMejorAbsoluto(),
				funcion.getPeorAbsoluto(), funcion.getTotalCruces(), funcion.getTotalMutaciones());
	}
	
	
	
}
