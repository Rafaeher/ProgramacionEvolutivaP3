package utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ArbolOperaciones 
{

	private ArbolOperaciones arbolPadre;
	private int nivel;
	private Operacion raiz;
	private ArbolOperaciones izq;
	private ArbolOperaciones der;
	private int num_0;
	private int num_1;
	private int num_2;
	private int profundidad;
	
	
	private void inicializar(ArbolOperaciones izq, Operacion raiz, ArbolOperaciones der)
	{	
		this.nivel = 1;
		this.izq = izq;
		this.raiz = raiz;
		this.der = der;
		this.num_0 = 0;
		this.num_1 = 0;
		this.num_2 = 0;
		this.profundidad = 1;
		this.arbolPadre = null;
		
		actualizarContadores(raiz);
		
		if(izq != null)
		{
			this.num_0 += izq.num_0;
			this.num_1 += izq.num_1;
			this.num_2 += izq.num_2;
			this.profundidad = Math.max(this.profundidad, izq.profundidad + 1);
			izq.arbolPadre = this;
		}
		
		if (der != null)
		{
			this.num_0 += der.num_0;
			this.num_1 += der.num_1;
			this.num_2 += der.num_2;
			this.profundidad = Math.max(this.profundidad, der.profundidad + 1);
			der.arbolPadre = this;
		}
	}
	
	private void actualizarContadores(Operacion op)
	{
		switch(op.getNumOperandos())
		{
		case 0: this.num_0++; break;
		case 1: this.num_1++; break;
		case 2: this.num_2++; break;
		default: break;
		}
	}
	
	public ArbolOperaciones(ArbolOperaciones izq, Operacion raiz, ArbolOperaciones der)
	{
		if(raiz.getNumOperandos() != 2)
		{
			throw new IllegalArgumentException("Esta constructora solo se puede emplear para árboles con raíces binarias");
		}
		
		inicializar(izq, raiz, der);
	}
	
	public ArbolOperaciones(Operacion raiz, ArbolOperaciones der)
	{
		if(raiz.getNumOperandos() != 1)
		{
			throw new IllegalArgumentException("Esta constructora solo se puede emplear para árboles con raíces 1 - arias");
		}
		
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
	
	private void insertar(ArbolOperaciones nuevo, boolean insertarIzq)
	{
		if (insertarIzq)
		{
			this.izq = nuevo;
		}
		else
		{
			this.der = nuevo;
		}
		
		nuevo.arbolPadre = this;
		
		//Ponemos la profundidad 
		int sizeIzq, sizeDer;
		if(this.izq == null)
			sizeIzq = 0;
		else
			sizeIzq = this.izq.profundidad;
		
		if(this.der == null)
			sizeDer = 0;
		else
			sizeDer = this.der.profundidad;
		
		if(this.profundidad <= Math.max(sizeIzq, sizeDer))
		{
			this.profundidad = Math.max(sizeIzq, sizeDer) + 1;
		}
		
		this.num_0 += nuevo.num_0;
		this.num_1 += nuevo.num_1;
		this.num_2 += nuevo.num_2;
		
		//actualizamos el valor de los que están por arriba
		ArbolOperaciones padre = this.arbolPadre;
		
		nuevo.setNivel(this.nivel + 1);
		while(padre != null)
		{
			padre.num_0 += nuevo.num_0;
			padre.num_1 += nuevo.num_1;
			padre.num_2 += nuevo.num_2;
			
			if(padre.izq == null)
				sizeIzq = 0;
			else
				sizeIzq = padre.izq.profundidad;
			
			if(padre.der == null)
				sizeDer = 0;
			else
				sizeDer = padre.der.profundidad;

			padre.profundidad = Math.max(sizeIzq, sizeDer) + 1;
			padre = padre.arbolPadre;
		}
	}
	
	public void insertarIzq(ArbolOperaciones nuevo) throws Exception
	{
		if(this.raiz.getNumOperandos() == 0)
		{
			//Error porque no se puede añadir nada a un nodo que sea 0 (A)
			throw new Exception("No se puede añadir nada a la izquierda de un nodo terminal");
		}
		else if (this.raiz.getNumOperandos() == 1)
		{
			//Error porque no se puede añadir un hijo izquierdo de un nodo con operación 1 - aria
			throw new Exception("No se puede añadir un hijo izquierdo de un nodo con operación 1 - aria");
		}
		
		insertar(nuevo, true);
	}
	
	public void insertarDer(ArbolOperaciones nuevo) throws Exception
	{
		if(this.raiz.getNumOperandos() == 0)
		{
			throw new Exception("No se puede añadir nada a la derecha de un nodo terminal");
		}
		
		insertar(nuevo, false);
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
	
	public void setRaiz(Operacion operacion)
	{
		raiz = operacion;
	}
	
	/**
	 * Clona el árbol en tiempo lineal en el número de nodos
	 * 
	 * @return clon del árbol
	 */
	public Object clone()
	{
		switch(raiz.getNumOperandos())
		{
		case 0: return new ArbolOperaciones(raiz);
		case 1: return new ArbolOperaciones(raiz, (ArbolOperaciones) der.clone());
		default: return new ArbolOperaciones((ArbolOperaciones) izq.clone(), raiz, (ArbolOperaciones) der.clone());
		}
	}
	

	public ArbolOperaciones getArbolPadre()
	{
		return arbolPadre;
	}

	public void setArbolPadre(ArbolOperaciones arbolPadre)
	{
		this.arbolPadre = arbolPadre;
	}

	public int getNum_0()
	{
		return num_0;
	}

	public void setNum_0(int num_0)
	{
		this.num_0 = num_0;
	}

	public int getNum_1() {
		return num_1;
	}

	public void setNum_1(int num_1)
	{
		this.num_1 = num_1;
	}

	public int getNum_2() 
	{
		return num_2;
	}
	
	public int getNumNodos()
	{
		return num_0 + num_1 + num_2;
	}
	
	public int getNumOperandos()
	{
		return raiz.getNumOperandos();
	}

	public void setNum_2(int num_2)
	{
		this.num_2 = num_2;
	}

	public int getProfundidad()
	{
		return profundidad;
	}

	public void setProfundidad(int profundidad)
	{
		this.profundidad = profundidad;
	}

	public static void main(String args[])
	{
		ArbolOperaciones
		t1 = new ArbolOperaciones(Operacion.A),
		t2 = new ArbolOperaciones(Operacion.A),
		t3 = new ArbolOperaciones(Operacion.A),
		t4 = new ArbolOperaciones(Operacion.A),
		t5 = new ArbolOperaciones(Operacion.A),
		mul1 = new ArbolOperaciones(t1, Operacion.MUL, t2),
		mul2 = new ArbolOperaciones(t3, Operacion.MUL, mul1),
		sqrt = new ArbolOperaciones(Operacion.SQRT, mul2);
		
		try
		{	
			System.out.println(sqrt.operar(0.72));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}
	
	public void generarHijosAleatorios() throws Exception{
		Random r = new Random();
		Operacion[] operandos = {Operacion.SUMA,Operacion.RESTA,Operacion.MUL,Operacion.DIV,
				Operacion.SUMA,Operacion.RESTA,Operacion.MUL,Operacion.DIV, Operacion.A};
		//Primero generamos la raiz
		if(raiz.getNumOperandos() == 2){
			//Hijo izquierdo
			ArbolOperaciones arbolIzq = new ArbolOperaciones(operandos[r.nextInt(operandos.length)]);
			ArbolOperaciones arbolDer = new ArbolOperaciones(operandos[r.nextInt(operandos.length)]);
			this.insertarIzq(arbolIzq);
			this.insertarDer(arbolDer);
		}
		else if(raiz.getNumOperandos() == 1){
			ArbolOperaciones arbolDer = new ArbolOperaciones(operandos[r.nextInt(operandos.length)]);
			this.insertarDer(arbolDer);
		}	
	}
	
	
	public void forzarTamano() throws Exception{
		if(raiz.getNumOperandos() == 2){
			//Hijo izquierdo
			this.insertarIzq(new ArbolOperaciones(Operacion.A));
			this.insertarDer(new ArbolOperaciones(Operacion.A));
			
		}
		else if(raiz.getNumOperandos() == 1){
			this.insertarDer(new ArbolOperaciones(Operacion.A));
		}	
	}
	
	public double operar(double valor)
	{
		if (raiz.getNumOperandos() == 0)
		{
			return valor;
		}
		else
		{
			double resultIzq = 0;
			double resultDer = der.operar(valor);
			if (raiz.getNumOperandos() == 2)
			{
				resultIzq = izq.operar(valor);
			}		

			return opera(resultIzq, raiz, resultDer);
		}
	}
	
	public ArbolOperaciones buscaNodoK(int k)
	{
		Queue<ArbolOperaciones> cola = new LinkedList<ArbolOperaciones>();
		ArbolOperaciones result = null;
		cola.add(this);
		
		while(k != 0)
		{
			result = cola.poll();		
			k--;
			
			if (result.izq != null)
			{
				cola.add(result.izq);
			}
			
			if (result.der != null)
			{
				cola.add(result.der);
			}
		}
		
		return result;
	}
	
	private static double opera(double valorIzq, Operacion operacion, double valorDer)
	{
		switch(operacion)
		{
		case SUMA: return valorIzq + valorDer;
		case RESTA: return valorIzq - valorDer;
		case MUL: return valorIzq * valorDer;
		case DIV: return valorIzq / valorDer;
		case LOG: return Math.log10(valorDer);
		case SQRT: return Math.sqrt(valorDer);
		case OPUESTO: return -valorDer;
		case A: throw new IllegalArgumentException("A es terminal, no una operación");
		default: throw new IllegalArgumentException("La operación no está definida para operarse en " + ArbolOperaciones.class.getName());
		}
	}
	
	public void reemplazaNodoK(int k, ArbolOperaciones nodo)
	{
		Queue<ArbolOperaciones> cola = new LinkedList<ArbolOperaciones>();
		ArbolOperaciones result = null;
		cola.add(this);
		
		while(k != 0)
		{
			result = cola.poll();
			k--;
			
			if (result.izq != null)
			{
				cola.add(result.izq);
			}
			
			if (result.der != null)
			{
				cola.add(result.der);
			}
		}
		
		if(result.arbolPadre.der == result)
		{
			result.arbolPadre.der = nodo;
		}
		else
		{
			result.arbolPadre.izq = nodo;
		}
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
