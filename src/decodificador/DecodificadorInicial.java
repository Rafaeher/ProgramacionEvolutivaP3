package decodificador;

public class DecodificadorInicial extends DecodificadorEslabon
{
    @Override
    protected void decodifica(Object genotipo, Object fenotipo)
    {
        new DecodificadorAlfabetoMensaje().decodifica(genotipo, fenotipo);
    }
}
