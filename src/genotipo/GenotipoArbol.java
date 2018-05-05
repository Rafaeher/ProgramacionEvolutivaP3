package genotipo;

import utils.ArbolOperaciones;

public class GenotipoArbol implements Genotipo {

	private ArbolOperaciones arbol;
	private int profundidadMaxima;

	public GenotipoArbol(ArbolOperaciones arbol)
	{
		this.arbol = arbol;
	}
	
	public ArbolOperaciones getArbol()
	{
		return arbol;
	}
	
	public ArbolOperaciones buscaNodoK(int k)
	{
		return arbol.buscaNodoK(k);
	}
	
	public void setArbol(ArbolOperaciones nuevoArbol)
	{
		arbol = nuevoArbol;
	}

	public int getProfundidadMaxima() {
		return profundidadMaxima;
	}

	public void setProfundidadMaxima(int profundidadMaxima) {
		this.profundidadMaxima = profundidadMaxima;
	}

	@Override
	public Genotipo cloneGenotipo()
	{
		GenotipoArbol clon = new GenotipoArbol((ArbolOperaciones) arbol.clone());
		clon.profundidadMaxima = profundidadMaxima;
		
		return clon;
	}

}
