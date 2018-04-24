package mutacion;

import java.util.ArrayList;
import java.util.Random;

import fenotipo.FenotipoMensaje;
import fitness.Fitness;
import genotipo.GenotipoAlfabeto;

public class Inversion<FitnessUPB extends Fitness>
implements Mutacion<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> {

	@Override
	public void muta(GenotipoAlfabeto genotipo, FenotipoMensaje fenotipo, double prob_mutacion) {
		//Dado que está mutación cambia gran cantidad del genotipo del individuo
		//La probabilidad es para el individuo entero y no para cada gen
		Random r = new Random();
		int posA = r.nextInt();
	//	if(r.nextDouble() <= prob_mutacion){
			ArrayList<Character> codigo = alg_mutacion(genotipo.getCodigo(), r.nextInt(posA) ,posA);
			genotipo.setCodigo(codigo);
	//	}
	}
	
	private ArrayList<Character> alg_mutacion(ArrayList<Character> codigo, int posA, int posB){
		int pososicionesACambiar = posB - posA;
		
		Character aux;
		for(int i = 0; i <= pososicionesACambiar; i++){
			aux = codigo.get(posA);
			codigo.set(posA, codigo.get(posB));
			codigo.set(posB, aux);
			posA += 1;
			posB -= 1;
		}
		return codigo;
	}
}
