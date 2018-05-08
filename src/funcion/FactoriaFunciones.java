package funcion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.*;
import fitness.*;
import genotipo.Genotipo;
import genotipo.GenotipoArbol;
import individuo.Individuo;

public class FactoriaFunciones<GenotipoALF extends Genotipo, FenotipoALF extends Fenotipo, FitnessALF extends Fitness>{

	public Funcion<GenotipoALF,FenotipoALF,FitnessALF> getSeleccion(int f,
			ArrayList<Individuo<GenotipoALF,FenotipoALF, FitnessALF>> poblacion,
			Configuracion config)
    {
		
		Funcion<?, ?, ?> funcion = null;
		
		switch(f)
		{
    	default:
    		ArrayList<?> aux = poblacion;
    		ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>> aux2 = (ArrayList<Individuo<GenotipoArbol, FenotipoArbol, FitnessReal>>) aux;
    		funcion = new FuncionArbol(aux2, config); break;
		}
		
		return (Funcion<GenotipoALF, FenotipoALF, FitnessALF>) funcion;
    }
}