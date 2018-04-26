package utils;

public class ArbolOperaciones 
{

	private Operacion raiz;
	private ArbolOperaciones izq;
	private ArbolOperaciones der;
	
	private void inicializar(ArbolOperaciones izq, Operacion raiz, ArbolOperaciones der)
	{
		this.izq = izq;
		this.raiz = raiz;
		this.der = der;
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
	
	public void insertarIzq(ArbolOperaciones izq)
	{
		this.izq = izq;
	}
	
	public void insertarDer(ArbolOperaciones der)
	{
		this.der = der;
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
	
}
