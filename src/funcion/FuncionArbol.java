package funcion;

import java.util.ArrayList;

import configuracion.Configuracion;
import fenotipo.FenotipoArbol;
import fitness.FitnessReal;
import genotipo.Genotipo;
import individuo.Individuo;

public class FuncionArbol<GenotipoFD extends Genotipo>
extends Funcion<GenotipoFD, FenotipoArbol, FitnessReal>{

	public FuncionArbol(ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion,
			Configuracion configuracion) {
		super(poblacion, configuracion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void algEvalua(ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Individuo<GenotipoFD, FenotipoArbol, FitnessReal> mejor(
			ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Individuo<GenotipoFD, FenotipoArbol, FitnessReal> peor(
			ArrayList<Individuo<GenotipoFD, FenotipoArbol, FitnessReal>> poblacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getMaximizar() {
		// TODO Auto-generated method stub
		return false;
	}

}
