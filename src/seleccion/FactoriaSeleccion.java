package seleccion;

import configuracion.Seleccion_enum;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;

public class FactoriaSeleccion<GenotipoFS extends Genotipo, FenotipoFS extends Fenotipo, FitnessFS extends Fitness>
{
	
	public Seleccion<GenotipoFS,FenotipoFS,FitnessFS> getSeleccion(Seleccion_enum seleccion)
    {
    	switch(seleccion)
		{
			case Ruleta: return new Ruleta<GenotipoFS,FenotipoFS,FitnessFS>();
			case Estocastica: return new Estocastica<GenotipoFS,FenotipoFS,FitnessFS>(); 
			case Torneo_Deterministico: return new TorneoDeterministico<GenotipoFS,FenotipoFS,FitnessFS>(); 
			case Torneo_Probabilistico: return new TorneoProbabilistico<GenotipoFS,FenotipoFS,FitnessFS>(); 
			case Truncamiento: return new Truncamiento<GenotipoFS,FenotipoFS,FitnessFS>(); 
			default: return null;
		}
    }
}
