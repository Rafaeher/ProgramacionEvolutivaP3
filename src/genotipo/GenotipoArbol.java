package genotipo;

import utils.ArbolOperaciones;

public class GenotipoArbol implements Genotipo {

	private ArbolOperaciones arbol;
	private int profundidadMaxima;

	public GenotipoArbol(ArbolOperaciones arbol, int profunidadMaxima)
	{
		this.arbol = arbol;
		this.profundidadMaxima = profunidadMaxima;
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
	
	public String toString()
	{
		return arbol.toString();
	}
	
	public int getNumNodos()
	{
		return arbol.getNumNodos();
	}
	
	public void recorta(int maxProfundidad)
	{
		arbol.recorta(maxProfundidad);
	}

	public int getProfundidad()
	{
		return arbol.getProfundidad();
	}
	
	@Override
	public Genotipo cloneGenotipo()
	{
		GenotipoArbol clon = new GenotipoArbol((ArbolOperaciones) arbol.clone(), profundidadMaxima);
		clon.profundidadMaxima = profundidadMaxima;
		
		return clon;
	}

}
