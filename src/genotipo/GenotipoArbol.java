package genotipo;

import utils.ArbolOperaciones;

public class GenotipoArbol implements Genotipo {

	private ArbolOperaciones arbol;
	

	public GenotipoArbol(ArbolOperaciones arbol)
	{
		this.arbol = arbol;
	}
	
	@Override
	public Genotipo cloneGenotipo()
	{
		// TODO Auto-generated method stub
		return null;
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

}
