package reproduccion;

import configuracion.Reproduccion_enum;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;

public class FactoriaReproduccion<GenotipoALF extends Genotipo, FenotipoALF extends Fenotipo, FitnessALF extends Fitness>
{
	
	@SuppressWarnings("unchecked")
	public Reproduccion<GenotipoALF,FenotipoALF,FitnessALF> getReproduccion(Reproduccion_enum reproduccion)
	{
		switch(reproduccion)
		{
		case CRUCE_ARBOL: return (Reproduccion<GenotipoALF, FenotipoALF, FitnessALF>) new CruceArbol<FenotipoALF, FitnessALF>();
		
		default: return null;
		}
	}
	
}
