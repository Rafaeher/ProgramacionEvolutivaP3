package mutacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import dao.DAO_Ngramas;
import fenotipo.Fenotipo;
import fenotipo.FenotipoMensaje;
import fitness.Fitness;
import genotipo.GenotipoAlfabeto;

public class MutacionG10<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> {

	@Override
	public void muta(GenotipoAlfabeto genotipo, FenotipoMensaje fenotipo, double prob_mutacion) {
		HashMap<String, Double> ngramas = DAO_Ngramas.lectura(1);
		HashMap<Character, Double> frecuenciaText = new HashMap<Character, Double>();
		String mensaje = fenotipo.getMensajeDecodificadoLowerCase();
		
		for(int i = 0; i < mensaje.length(); ++i){
			if(mensaje.charAt(i) != ' ' && esLetra(mensaje.charAt(i))){
				if(!frecuenciaText.containsKey(mensaje.charAt(i))){
					frecuenciaText.put(mensaje.charAt(i), 1.0 / mensaje.length());
				}
				else{
					double veces = (frecuenciaText.get(mensaje.charAt(i)) * 
							mensaje.length()) + 1.0;
					double frecuencia = veces / mensaje.length();
					frecuenciaText.put(mensaje.charAt(i), frecuencia);
				}
			}
		}
		//YA HEMOS CALCULADO LA FRECUENCIA DE LOS MONOGRAMAS
		//AHORA INTERCAMBIAREMOS LOS DOS CON MAYOR ERROR
		double errorMasAlto1 = 0.0;
		Character errorMasAlto1Character = null;
		double errorMasAlto2 = 0.0;
		Character errorMasAlto2Character = null;
		for (Character ch : frecuenciaText.keySet()) {
			double error = Math.abs(ngramas.get(ch.toString()) - frecuenciaText.get(ch));

			
			
			if(error > errorMasAlto2 && error <= errorMasAlto1){
				errorMasAlto2 = error;
				errorMasAlto2Character = ch;
			}
			if(error > errorMasAlto2 && error > errorMasAlto1){
				Character characterAux = errorMasAlto1Character;
				double errorAux = errorMasAlto1;
				errorMasAlto1Character = ch;
				errorMasAlto1 = error;
				errorMasAlto2 = errorAux;
				errorMasAlto2Character = characterAux;
			}
		}
		
		ArrayList<Character> array = genotipo.getCodigo();
		for(int j = 0; j < array.size(); j++){
			if(array.get(j) == errorMasAlto1Character){
				array.set(j, errorMasAlto2Character);
			}
			if(array.get(j) == errorMasAlto2Character){
				array.set(j, errorMasAlto1Character);
			}
		}
		genotipo.setCodigo(array);
			
	}
	
	
	
	private boolean esLetra(char c)
	{
		return c == 'a' ||
				c == 'b' ||
				c == 'c' ||
				c == 'd' ||
				c == 'e' ||
				c == 'f' ||
				c == 'g' ||
				c == 'h' ||
				c == 'i' ||
				c == 'j' ||
				c == 'k' ||
				c == 'l' ||
				c == 'm' ||
				c == 'n' ||
				c == 'o' ||
				c == 'p' ||
				c == 'q' ||
				c == 'r' ||
				c == 's' ||
				c == 't' ||
				c == 'u' ||
				c == 'v' ||
				c == 'w' ||
				c == 'x' ||
				c == 'y' ||
				c == 'z';
	}
}
