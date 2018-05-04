package genotipo;

import utils.ArbolOperaciones;

public class GenotipoArbol implements Genotipo {

	private ArbolOperaciones arbol;
	
	@Override
	public Genotipo cloneGenotipo() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArbolOperaciones getArbol(){
		return arbol;
	}
	public void setArbol(ArbolOperaciones nuevoArbol){
		arbol = nuevoArbol;
	}

}
