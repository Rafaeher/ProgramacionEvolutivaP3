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
		case PMX:return (Reproduccion<GenotipoALF, FenotipoALF, FitnessALF>) new PMX<FenotipoALF, FitnessALF>();
		case CODIFICACION_ORDINAL:return (Reproduccion<GenotipoALF, FenotipoALF, FitnessALF>) new CodificacionOrdinal<FenotipoALF, FitnessALF>();
		case ReproduccionG10:return (Reproduccion<GenotipoALF, FenotipoALF, FitnessALF>) new ReproduccionG10<FenotipoALF, FitnessALF>();
		default: return null;
		}
	}
	
}
