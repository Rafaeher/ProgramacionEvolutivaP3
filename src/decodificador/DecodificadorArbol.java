package decodificador;

import fenotipo.FenotipoArbol;
import genotipo.GenotipoArbol;

public class DecodificadorArbol extends DecodificadorEslabon
{

	@Override
	protected void decodifica(Object genotipo, Object fenotipo)
	{
		if (genotipo instanceof GenotipoArbol && fenotipo instanceof FenotipoArbol)
		{
			
		}
		else
		{
	        new DecodificadorFinal().decodifica(genotipo, fenotipo);
		}
	}

}
