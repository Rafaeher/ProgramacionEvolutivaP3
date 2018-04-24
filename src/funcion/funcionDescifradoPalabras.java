package funcion;

import java.util.ArrayList;
import java.util.HashMap;

import configuracion.Configuracion;
import dao.DAO_Ngramas;
import decodificador.Decodificador;
import fenotipo.FenotipoMensaje;
import fitness.FitnessReal;
import genotipo.Genotipo;
import individuo.Individuo;

public class funcionDescifradoPalabras<GenotipoFD extends Genotipo>
		extends Funcion<GenotipoFD, FenotipoMensaje, FitnessReal> {
	private int numNGrama;
	private String mensaje;
	private static HashMap<String, Double> frecuenciasEsperadas;

	public funcionDescifradoPalabras(ArrayList<Individuo<GenotipoFD, FenotipoMensaje, FitnessReal>> poblacion,
			Configuracion configuracion) {
		super(poblacion, configuracion);
		mensaje = configuracion.getMensaje();
		frecuenciasEsperadas = DAO_Ngramas.lectura(0);
	}

	@Override
	public void algEvalua(ArrayList<Individuo<GenotipoFD, FenotipoMensaje, FitnessReal>> poblacion) {
		for (Individuo<GenotipoFD, FenotipoMensaje, FitnessReal> individuo : poblacion) {
			FenotipoMensaje fenotipo = new FenotipoMensaje(mensaje);
			Decodificador.decodifica(individuo.getGenotipo(), fenotipo);
			individuo.setFenotipo(fenotipo);

			String mensajeDecodificado = fenotipo.getMensajeDecodificadoLowerCase();

			HashMap<String, Double> frecuenciasRelativas = calcularFrecuencias(numNGrama, mensajeDecodificado);

			double fitness = 0.0;

			for (String ngrama : frecuenciasRelativas.keySet()) {
				double frecuencia = 0.0;
				try {
					if (frecuenciasEsperadas.containsKey(ngrama))
						frecuencia = frecuenciasEsperadas.get(ngrama);
					else
						frecuencia = 0.0;
				} catch (Exception e) {
					System.out.println("");
				}
				double diferencia = frecuencia - frecuenciasRelativas.get(ngrama);
				fitness += diferencia * diferencia;
			}			
			
			individuo.setFitness(new FitnessReal(fitness));
		}
	}

	/**
	 * Calcula las frecuencias de aparición de los ngramas del mensaje
	 * decodificado
	 * 
	 * @param n:
	 *            el número del ngrama
	 * @return
	 */
	private HashMap<String, Double> calcularFrecuencias(int n, String mensajeDecodificado) {
		Double ngramasTotales = 0.0;
		HashMap<String, Double> resultado = new HashMap<String, Double>();

		String[] palabras = mensajeDecodificado.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			String ngrama = palabras[i];
			if (!ngrama.equals("")) {
				ngramasTotales++;
				if (!resultado.containsKey(ngrama)) {
					resultado.put(ngrama, 1.0);
				} else {
					resultado.put(ngrama, (resultado.get(ngrama) + 1));
				}
			}
		}

		for (String ngrama : resultado.keySet()) {
			resultado.replace(ngrama, resultado.get(ngrama) / ngramasTotales);
		}

		return resultado;
	}

	@Override
	public boolean getMaximizar() {
		return false;
	}

	public Individuo<GenotipoFD, FenotipoMensaje, FitnessReal> mejor(
			ArrayList<Individuo<GenotipoFD, FenotipoMensaje, FitnessReal>> poblacion) {
		Individuo<GenotipoFD, FenotipoMensaje, FitnessReal> mejor = poblacion.get(0);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getFitness().getValor() < mejor.getFitness().getValor())
				mejor = poblacion.get(i);
		}
		return mejor.cloneIndividuo();
	}
	
	public Individuo<GenotipoFD, FenotipoMensaje, FitnessReal> peor(
			ArrayList<Individuo<GenotipoFD, FenotipoMensaje, FitnessReal>> poblacion) {
		Individuo<GenotipoFD, FenotipoMensaje, FitnessReal> peor = poblacion.get(0);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getFitness().getValor() > peor.getFitness().getValor())
				peor = poblacion.get(i);
		}
		return peor.cloneIndividuo();
	}

}