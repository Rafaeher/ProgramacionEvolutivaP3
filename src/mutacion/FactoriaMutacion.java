package mutacion;

import configuracion.Mutacion_enum;
import fenotipo.Fenotipo;
import fitness.Fitness;
import genotipo.Genotipo;

public class
FactoriaMutacion<GenotipoALF extends Genotipo, FenotipoALF extends Fenotipo, FitnessALF extends Fitness>
{

    @SuppressWarnings("unchecked")
    public Mutacion<GenotipoALF, FenotipoALF, FitnessALF> getMutacion(Mutacion_enum tipo)
    {
        switch(tipo)
        {
        case MUTACION_DE_ARBOL: return (Mutacion<GenotipoALF, FenotipoALF, FitnessALF>) new MutacionDeArbol<FenotipoALF, FitnessALF>();
        case MUTACION_FUNCIONAL_SIMPLE: return (Mutacion<GenotipoALF, FenotipoALF, FitnessALF>) new MutacionFuncionalSimple<FenotipoALF,FitnessALF>();
        case MUTACION_TERMINAL_SIMPLE: return (Mutacion<GenotipoALF, FenotipoALF, FitnessALF>) new MutacionTerminalSimple<FenotipoALF, FitnessALF>();
      
            default: return null;
        }
    }
}

