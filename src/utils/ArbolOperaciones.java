package utils;

public class ArbolOperaciones 
{

	private ArbolOperaciones arbolPadre;
	private Operacion raiz;
	private ArbolOperaciones izq;
	private ArbolOperaciones der;
	private int num_0;
	private int num_1;
	private int num_2;
	
	private void inicializar(ArbolOperaciones izq, Operacion raiz, ArbolOperaciones der)
	{
		this.izq = izq;
		this.raiz = raiz;
		this.der = der;
		this.setNum_0(0);
		this.setNum_1(0);
		this.setNum_2(0);
		this.setArbolPadre(null);
	}
	
	public ArbolOperaciones(ArbolOperaciones izq, Operacion raiz, ArbolOperaciones der)
	{
		inicializar(izq, raiz, der);
	}
	
	public ArbolOperaciones(Operacion raiz, ArbolOperaciones der)
	{
		inicializar(null, raiz, der);
	}
	
	public ArbolOperaciones(Operacion raiz)
	{
		inicializar(null, raiz, null);
	}
	
	public ArbolOperaciones()
	{
		inicializar(null, null, null);
	}
	
	public void insertarIzq(ArbolOperaciones izq) throws Exception
	{
		if(this.raiz.getNumOperandos() == 0){
			//Error porque no se puede añadir nada a un nodo que sea 0 (A)
			throw new Exception("No se puede añadir nada a la izquierda de un operando 0");
		}
		else{
			if(izq.obtenerRaiz().getNumOperandos() != 0){
				throw new Exception("No se puede añadir a la izquierda"
						+ "de un operando > 0 nada que no sea un operando 0");
			}
			this.setNum_0(this.getNum_0() +1);
			this.izq = izq;
			izq.setArbolPadre(this);
			//actualizamos el valor de los que están por arriba
			ArbolOperaciones padre = this.arbolPadre;
			while(padre != null){
				padre.setNum_0(padre.getNum_0() + 1);
				padre = padre.getArbolPadre();
			}
			
		}
		
	}
	
	public void insertarDer(ArbolOperaciones der) throws Exception
	{
		if(this.raiz.getNumOperandos() == 0){
			throw new Exception("No se puede añadir un operando "
					+ "a la derecha de un operando 0");
		}
		if(der.obtenerRaiz().getNumOperandos() == 0) this.setNum_0(this.getNum_0() + 1);
		else if(der.obtenerRaiz().getNumOperandos() == 1) this.setNum_1(this.getNum_1() + 1);
		else if(der.obtenerRaiz().getNumOperandos() == 2) this.setNum_2(this.getNum_2() + 1);
		this.der = der;
		der.setArbolPadre(this);
		ArbolOperaciones padre = this.arbolPadre;
		while(padre != null){
			if(der.obtenerRaiz().getNumOperandos() == 0) padre.setNum_1(padre.getNum_0() + 1);
			else if(der.obtenerRaiz().getNumOperandos() == 1) padre.setNum_1(padre.getNum_1() + 1);
			else if(der.obtenerRaiz().getNumOperandos() == 2) padre.setNum_2(padre.getNum_2() + 1);
			padre = padre.getArbolPadre();
		}
		
	}
	
	public ArbolOperaciones obtenerIzq()
	{
		return izq;
	}
	
	public ArbolOperaciones obtenerDer()
	{
		return der;
	}
	
	public Operacion obtenerRaiz()
	{
		return raiz;
	}
	
	/**
	 * Clona el árbol en tiempo lineal en el número de nodos
	 * 
	 * @return clon del árbol
	 */
	public Object clone()
	{
		return new ArbolOperaciones((ArbolOperaciones) izq.clone(), raiz, (ArbolOperaciones) der.clone());
	}
	

	public ArbolOperaciones getArbolPadre() {
		return arbolPadre;
	}

	public void setArbolPadre(ArbolOperaciones arbolPadre) {
		this.arbolPadre = arbolPadre;
	}

	public int getNum_0() {
		return num_0;
	}

	public void setNum_0(int num_0) {
		this.num_0 = num_0;
	}

	public int getNum_1() {
		return num_1;
	}

	public void setNum_1(int num_1) {
		this.num_1 = num_1;
	}

	public int getNum_2() {
		return num_2;
	}

	public void setNum_2(int num_2) {
		this.num_2 = num_2;
	}
	
}
