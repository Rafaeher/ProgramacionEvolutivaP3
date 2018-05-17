package poblacionInicial;

import configuracion.IniArbol_enum;

public class FactoriaMetodoInicializacion {

	public InicializacionArbol getIniArbol(IniArbol_enum tipo){
		switch(tipo){
		case COMPLETA: return new Completa();
		case CRECIENTE: return new Creciente();
		case RAMPED_AND_HALF: return new RampedANDHalf();
		default: return null;
		}
	}
	
	
}
