package mutacion;

import java.util.ArrayList;
import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoMensaje;
import fitness.Fitness;
import genotipo.GenotipoAlfabeto;

public class Intercambio<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
implements Mutacion<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> {

	@Override
	public void muta(GenotipoAlfabeto genotipo, FenotipoMensaje fenotipo, double prob_mutacion) {
		//for(int i = 0; i < genotipo.getCodigo().size(); i++){
			Random r = new Random();
		//	if (r.nextDouble() < prob_mutacion) {
				ArrayList<Character> codigo = alg_mutacion(genotipo.getCodigo(), r.nextInt(genotipo.getSize()), r.nextInt(genotipo.getSize()));
				genotipo.setCodigo(codigo);
		//	}

		//}
	}

	private ArrayList<Character> alg_mutacion(ArrayList<Character> codigo, int a, int b) {
		Character aux = codigo.get(a);
		
		codigo.set(a, codigo.get(b));
		codigo.set(b, aux);
		
		return codigo;
	}

}
