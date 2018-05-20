package bloating;

import configuracion.Bloating_enum;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;

public class FactoriaBloating<GenotipoALF extends Genotipo, FenotipoALF extends Fenotipo, FitnessALF extends Fitness>
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Bloating<GenotipoALF,FenotipoALF, FitnessALF> getBloating(Bloating_enum bloating){
		
		switch(bloating){
		case TARPEIAN: return new Tarpeian();
		case PENALIZACION_BIEN_FUNDAMENTADA: return new PenalizacionBienFundamentada();
		default: return null;
		}
		
	}

}
