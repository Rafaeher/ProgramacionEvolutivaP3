package funcion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.*;
import fitness.*;
import genotipo.Genotipo;
import individuo.Individuo;

public class FactoriaFunciones<GenotipoALF extends Genotipo, FenotipoALF extends Fenotipo, FitnessALF extends Fitness>{

	public Funcion<GenotipoALF,FenotipoALF,FitnessALF> getSeleccion(int f,
			ArrayList<Individuo<GenotipoALF,FenotipoALF, FitnessALF>> poblacion,
			Configuracion config)
    {
		
    	switch(f)
		{
    	default: return new funcionDescifradoPalabras(poblacion,config);
		}
    }
}