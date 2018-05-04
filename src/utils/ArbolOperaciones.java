package utils;

import java.util.Random;

public class ArbolOperaciones 
{

	private ArbolOperaciones arbolPadre;
	private Operacion raiz;
	private ArbolOperaciones izq;
	private ArbolOperaciones der;
	private int num_0;
	private int num_1;
	private int num_2;
	private int profundidad;
	
	
	private void inicializar(ArbolOperaciones izq, Operacion raiz, ArbolOperaciones der)
	{	
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
		resta = new ArbolOperaciones(t1, Operacion.RESTA, t2),
		division = new ArbolOperaciones(Operacion.DIV),
		opuesto = new ArbolOperaciones(Operacion.OPUESTO, t5),
		suma = new ArbolOperaciones(resta, Operacion.SUMA, opuesto),
		sqrt = new ArbolOperaciones(Operacion.SQRT),
		log = new ArbolOperaciones(Operacion.LOG, sqrt),
		mult = new ArbolOperaciones(Operacion.MUL);
		
		try
		{	
			division.insertarDer(t4);
			division.insertarIzq(t3);
			mult.insertarIzq(suma);			
			mult.insertarDer(log);
			sqrt.insertarDer(division);
			
			ArbolOperaciones aux2 = mult;
			System.out.println("Num 0: " + aux2.num_0);
			System.out.println("Num 1: " + aux2.num_1);
			System.out.println("Num 2: " + aux2.num_2);
			System.out.println("Profundidad: " + aux2.profundidad);
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
}
