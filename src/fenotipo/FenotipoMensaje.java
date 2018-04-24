package fenotipo;

import java.util.ArrayList;
import java.util.HashMap;

public class FenotipoMensaje implements Fenotipo
{
	private String mensajeCodificado;
	private String mensajeDecodificado;
	
	/**
	 * Constructora a partir del mensaje codificado
	 * 
	 * @param mensajeCodificadoE: mensaje codificado de entrada
	 */
	public FenotipoMensaje(String mensajeCodificadoE)
	{
		mensajeCodificado = mensajeCodificadoE;
		mensajeDecodificado = "";
	}
	public FenotipoMensaje(String mensajeCodificadoE,String mensajeDeCodificadoE )
	{
		mensajeCodificado = mensajeCodificadoE;
		mensajeDecodificado = mensajeDeCodificadoE;
	}
	
	/**
	 * Decodifica el mensaje a partir del código
	 * 
	 * @param codigo: el código utilizado para encriptar el mensaje
	 */
	public void decodifica(final ArrayList<Character> codigo)
	{
		final String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		mensajeDecodificado = new String(mensajeCodificado);
		
		String decodificado = new String(mensajeCodificado);
		for(int i = 0; i < alfabeto.length(); i++)
		{
			String aux = decodificado.replace(alfabeto.charAt(i), Character.toUpperCase(codigo.get(i)));
			decodificado = new String(aux);
		}
		
		mensajeDecodificado = decodificado;
		
	}
	
	/**
	 * Obtiene el mensaje decodificado
	 * @return
	 */
	public String getMensajeDecodificadoLowerCase()
	{
		return new String(mensajeDecodificado).toLowerCase();
	}
	
	public String getMensajeDecodificado()
	{
		return new String(mensajeDecodificado);
	}
	
	public String getMensajeCodificado()
	{
		return new String(mensajeCodificado);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Fenotipo cloneFenotipo()
	{
		FenotipoMensaje clon =  new FenotipoMensaje( new String(mensajeCodificado));
		clon.mensajeDecodificado = new String( mensajeDecodificado);
		return clon;
		
	}
}
