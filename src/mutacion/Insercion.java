package mutacion;

import java.util.ArrayList;
import java.util.Random;

import fenotipo.Fenotipo;
import fenotipo.FenotipoMensaje;
import fitness.Fitness;
import genotipo.GenotipoAlfabeto;

public class Insercion<FenotipoUPB extends Fenotipo, FitnessUPB extends Fitness>
		implements Mutacion<GenotipoAlfabeto, FenotipoMensaje, FitnessUPB> {

	@Override
	public void muta(GenotipoAlfabeto genotipo, FenotipoMensaje fenotipo, double prob_mutacion) {
		int b;
		Random r = new Random();
		int pos = r.nextInt(genotipo.getSize());
	//	if (r.nextDouble() < prob_mutacion) {
			if(pos == 0) b = 0;
			else
				b = r.nextInt(pos);
				ArrayList<Character> codigo = alg_mutacion(genotipo.getCodigo(), pos,b);
				genotipo.setCodigo(codigo);
	//	}

	}

	private ArrayList<Character> alg_mutacion(ArrayList<Character> codigo, int posOrigen, int posDestino) {
		Character aux = codigo.get(posOrigen);

		for (int i = posDestino; i <= posOrigen; i++) {
			codigo.set(i, aux);
			aux = codigo.get(i);
		}

		return codigo;
	}
}
