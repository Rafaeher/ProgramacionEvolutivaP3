package decodificador;

import fenotipo.FenotipoMensaje;
import genotipo.GenotipoAlfabeto;

public class DecodificadorAlfabetoMensaje extends DecodificadorEslabon {

	@Override
	protected void decodifica(Object genotipo, Object fenotipo)
	{
		if (genotipo instanceof GenotipoAlfabeto && fenotipo instanceof FenotipoMensaje)
		{
			GenotipoAlfabeto genotipoA = (GenotipoAlfabeto) genotipo;
			FenotipoMensaje fenotipoM = (FenotipoMensaje) fenotipo;
			
			fenotipoM.decodifica(genotipoA.getCodigo());
		}
		else
		{
			new DecodificadorFinal().decodifica(genotipo, fenotipo);
		}
	}

}
