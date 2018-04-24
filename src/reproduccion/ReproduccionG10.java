package reproduccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import configuracion.Configuracion;
import fenotipo.Fenotipo;
import fenotipo.FenotipoMensaje;
import fitness.Fitness;
import genotipo.GenotipoAlfabeto;
import individuo.Individuo;
import utils.AlfabetoHashMap;

public class ReproduccionG10<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
implements Reproduccion<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> {

	private int TAM = 13;
	
	@Override
	public int reproduce(
			ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>> poblacionInicial, Configuracion c, ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>> poblacion) {


		ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>> poblacionFinal = new ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>>();

		int totalCruces = 0;
		Random r = new Random();
		for (int i = 0; i < poblacionInicial.size(); i = i + 2) {

			// Obtenemos dos individuos aleatorios
			Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> i1 = poblacionInicial.get(r.nextInt(poblacionInicial.size()))
					.cloneIndividuo();
			Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> i2 = poblacionInicial.get(r.nextInt(poblacionInicial.size()))
					.cloneIndividuo();

			if (r.nextDouble() <= c.getCruceporcentaje()) {
				// Cruzamos los dos individuos
				ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>> individuosReproducidos = alg_reproduccion(
						i1, i2);
				poblacionFinal.add(individuosReproducidos.get(0));
				poblacionFinal.add(individuosReproducidos.get(1));
				totalCruces++;
				
			} else {
				// No cruzamos los dos individuos y por tanto los metemos en la
				// población final
				poblacionFinal.add(i1);
				poblacionFinal.add(i2);
			}
		}

		poblacion = poblacionFinal;
		
		return totalCruces;
		
	}

	private ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>> alg_reproduccion(
			Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> i1,
			Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> i2) {
		
		HashMap<Character,Integer> yaEstanInd1 = new HashMap<Character,Integer>();
		HashMap<Character,Integer> yaEstanInd2 = new HashMap<Character,Integer>();
		
		String alfabetoString =  "abcdefghijklmnopqrstuvwxyz";
		
		ArrayList<Character> genotipoInd1 = i1.getGenotipo().getCodigo();
		ArrayList<Character> genotipoInd2 = i2.getGenotipo().getCodigo();
		
		ArrayList<Character> genotipoInd1Final = new ArrayList<Character>(genotipoInd2);
		ArrayList<Character> genotipoInd2Final = new ArrayList<Character>(genotipoInd1);
		
		HashMap<Character,Integer> alfabeto = AlfabetoHashMap.getAlfabetoHashMap();
		
		//colocamos las dos partes de los individuos contrarios
		for(int i = TAM; i < genotipoInd1Final.size(); i++){
			yaEstanInd1.put(genotipoInd1Final.get(i), 0);
		}
		for(int i = 0; i < TAM; i++){
			yaEstanInd2.put(genotipoInd2Final.get(i), 0);
		}
		//recorremos la otra mitad de cada individuo e intentamos poner
		//lo que no provoque conflicto
		for(int i = 0; i < TAM; i++){
			if(!yaEstanInd1.containsKey(genotipoInd1.get(i))){
				genotipoInd1Final.set(i, genotipoInd1.get(i));
				yaEstanInd1.put(genotipoInd1.get(i), 1);
			}
			else{
				genotipoInd1Final.set(i, '?');
			}
		}
		for(int i = TAM; i < genotipoInd2Final.size(); i++){
			if(!yaEstanInd2.containsKey(genotipoInd2.get(i))){
				genotipoInd2Final.set(i, genotipoInd2.get(i));
				yaEstanInd2.put(genotipoInd2.get(i), 1);
			}
			else{
				genotipoInd2Final.set(i, '?');
			}
		}
		//Comprobamos lo que falta
		String faltanInd1 = "";
		for(int i = 0; i < alfabetoString.length(); i++){
			if(!yaEstanInd1.containsKey(alfabetoString.charAt(i))){
				faltanInd1 += alfabetoString.charAt(i);
			}
		}
		String faltanInd2 = "";
		for(int i = 0; i < alfabetoString.length(); i++){
			if(!yaEstanInd2.containsKey(alfabetoString.charAt(i))){
				faltanInd2 += alfabetoString.charAt(i);
			}
		}
		//Rellenamos las interrogantes con lo que falta
		for(int i = 0; i < genotipoInd1Final.size(); i++){
			if(genotipoInd1Final.get(i) == '?'){
				genotipoInd1Final.set(i, faltanInd1.charAt(0));
				faltanInd1 = faltanInd1.substring(1);
				
			}
		}
		for(int i = 0; i < genotipoInd2Final.size(); i++){
			if(genotipoInd2Final.get(i) == '?'){
				genotipoInd2Final.set(i, faltanInd2.charAt(0));
				faltanInd2 = faltanInd2.substring(1);
				
			}
		}
		GenotipoAlfabeto genotipoFinalInd1 = new GenotipoAlfabeto();
		GenotipoAlfabeto genotipoFinalInd2 = new GenotipoAlfabeto();

		genotipoFinalInd1.setCodigo(genotipoInd1Final);
		genotipoFinalInd2.setCodigo(genotipoInd2Final);
		
		i1.setGenotipo(genotipoFinalInd1);
		i2.setGenotipo(genotipoFinalInd2);

		ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>> poblacionFinal = new ArrayList<Individuo<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB>>();
		poblacionFinal.add(i1.cloneIndividuo());
		poblacionFinal.add(i2.cloneIndividuo());
		
		return poblacionFinal;
	}

	private boolean tieneElementosRepetidos(ArrayList<Character> array){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < array.size(); i++){
			if(map.containsKey(array.get(i)))return true;
			else map.put(array.get(i), null);
		}
		return false;
	}
	
}
