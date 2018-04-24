package genotipo;

import java.util.ArrayList;
import java.util.Random;

import utils.Constantes;

public class GenotipoAlfabeto implements Genotipo
{
	private static final int NUMLETRAS = 26;
	private ArrayList<Character> codigo;

	/**
	 * Constructora por defecto
	 */
	public GenotipoAlfabeto() {
		codigo = new ArrayList<Character>();
	}

	/**
	 * Inicializa aleatoriamente el gen
	 */
	public void inicializacionAleatoria() {
		Random random = new Random();

		ArrayList<Character> alfabeto = new ArrayList<Character>();
		for (int i = 0; i < Constantes.ALFABETO.length(); i++) {
			alfabeto.add(new Character(Constantes.ALFABETO.charAt(i)));
		}

		for (int i = 0; i < Constantes.ALFABETO.length(); i++) {
			int posRandom = random.nextInt(alfabeto.size());
			codigo.add(new Character(alfabeto.get(posRandom)));
			alfabeto.remove(posRandom);
		}
	}

	/**
	 * Obtiene el código del gen
	 * 
	 * @return copia del código
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Character> getCodigo()
	{
		return (ArrayList<Character>) codigo.clone();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Genotipo cloneGenotipo() {
		
		GenotipoAlfabeto clon = new GenotipoAlfabeto();

		clon.codigo = (ArrayList<Character>) codigo.clone();

		return clon;
		
	}

	public int getSize() {
		return NUMLETRAS;
	}

	public void setCodigo(ArrayList<Character> c)
	{
		codigo = c;
	}

}
