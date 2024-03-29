package utils;

import java.util.ArrayList;
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
			izq.actualizarNivel(this.nivel);
		}
		
		if (der != null)
		{
			this.num_0 += der.num_0;
			this.num_1 += der.num_1;
			this.num_2 += der.num_2;
			this.profundidad = Math.max(this.profundidad, der.profundidad + 1);
			der.arbolPadre = this;
			der.actualizarNivel(this.nivel);
		}
	}
	
	private void actualizarNivel(int nivel)
	{
		if (arbolPadre == null)
		{
			this.nivel = 1;
		}
		else
		{
			this.nivel = arbolPadre.nivel + 1;
		}
		
		if(izq != null)
		{
			izq.actualizarNivel(this.nivel);
		}
		
		if(der != null)
		{
			der.actualizarNivel(this.nivel);
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
			throw new IllegalArgumentException("Esta constructora solo se puede emplear para �rboles con ra�ces binarias");
		}
		
		inicializar(izq, raiz, der);
	}
	
	public ArbolOperaciones(Operacion raiz, ArbolOperaciones der)
	{
		if(raiz.getNumOperandos() != 1)
		{
			throw new IllegalArgumentException("Esta constructora solo se puede emplear para �rboles con ra�ces 1 - arias");
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
		nuevo.actualizarNivel(this.nivel);
		
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
		
		//actualizamos el valor de los que est�n por arriba
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
			//Error porque no se puede a�adir nada a un nodo que sea 0 (A)
			throw new Exception("No se puede a�adir nada a la izquierda de un nodo terminal");
		}
		else if (this.raiz.getNumOperandos() == 1)
		{
			//Error porque no se puede a�adir un hijo izquierdo de un nodo con operaci�n 1 - aria
			throw new Exception("No se puede a�adir un hijo izquierdo de un nodo con operaci�n 1 - aria");
		}
		
		insertar(nuevo, true);
	}
	
	public void insertarDer(ArbolOperaciones nuevo) throws Exception
	{
		if(this.raiz.getNumOperandos() == 0)
		{
			throw new Exception("No se puede a�adir nada a la derecha de un nodo terminal");
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
	 * Clona el �rbol en tiempo lineal en el n�mero de nodos
	 * 
	 * @return clon del �rbol
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

	public void generarHijosAleatorios(ArrayList<Operacion> operandos) throws Exception{
		Random r = new Random();
		
		//Primero generamos la raiz
		if(raiz.getNumOperandos() == 2){
			//Hijo izquierdo
			ArbolOperaciones arbolIzq = new ArbolOperaciones(operandos.get(r.nextInt(operandos.size())));
			ArbolOperaciones arbolDer = new ArbolOperaciones(operandos.get(r.nextInt(operandos.size())));
			this.insertarIzq(arbolIzq);
			this.insertarDer(arbolDer);
		}
		else if(raiz.getNumOperandos() == 1){
			ArbolOperaciones arbolDer = new ArbolOperaciones(operandos.get(r.nextInt(operandos.size())));
			this.insertarDer(arbolDer);
		}	
	}
	
	
	public void forzarTamano()
	{
		try
		{
			if(raiz.getNumOperandos() == 2){
				//Hijo izquierdo
				this.insertarIzq(new ArbolOperaciones(Operacion.A));
				this.insertarDer(new ArbolOperaciones(Operacion.A));
			
			}
			else if(raiz.getNumOperandos() == 1){
				this.insertarDer(new ArbolOperaciones(Operacion.A));
			}
		}
		catch(Exception e)
		{
			// Esta excepci�n no puede ser alcanzada.
		}
	}
	
	public double operar(double valor)
	{
		if (raiz.getNumOperandos() == 0)
		{
			if (raiz == Operacion.A)
			{
				return valor;
			}
			else
			{
				return 1.0 / (new Random()).nextInt();
			}
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
		ArbolOperaciones result = this;
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
		case A: throw new IllegalArgumentException("A es terminal, no una operaci�n");
		default: throw new IllegalArgumentException("La operaci�n no est� definida para operarse en " + ArbolOperaciones.class.getName());
		}
	}
	
	private void actualizarPadres()
	{
		ArbolOperaciones padre = arbolPadre;
		
		while(padre != null)
		{
			int num_0I = 0, num_1I = 0, num_2I = 0, profundidadI = 0;
			
			if (padre.izq != null)
			{
				num_0I = padre.izq.num_0;
				num_1I = padre.izq.num_1;
				num_2I = padre.izq.num_2;
				profundidadI = padre.izq.profundidad;
			}
			
			padre.num_0 = Math.max(num_0I, padre.der.num_0);
			padre.num_1 = Math.max(num_1I, padre.der.num_1);
			padre.num_2 = Math.max(num_2I, padre.der.num_2);
			padre.actualizarContadores(raiz);
			padre.profundidad = Math.max(profundidadI, padre.der.profundidad) + 1;
			
			padre = padre.arbolPadre;
		}
	}
	
	public void recorta(int maxProfundidad)
	{
		if (nivel >= maxProfundidad - 2)
		{
			switch(raiz.getNumOperandos())
			{
			case 0: break;
			case 1: der.forzarTamano(); break;
			case 2: izq.forzarTamano(); der.forzarTamano(); break;
			}
		}
		else
		{
			switch(raiz.getNumOperandos())
			{
			case 0: break;
			case 1: der.recorta(maxProfundidad); break;
			case 2: der.recorta(maxProfundidad); izq.recorta(maxProfundidad); break;
			}
		}
	}
	
	/**
	 * Se debe reemplazar uno de los nodos del �rbol que no sea la ra�z
	 * 
	 * @param k un entero mayor a 0
	 * @param nodo
	 * @param maxProfundidad
	 */
	public void reemplazaNodoK(int k, ArbolOperaciones nodo, int maxProfundidad) throws Exception
	{
		if (k == 0)
		{
			throw new Exception("No se puede reemplazar la ra�z");
		}
		
		Queue<ArbolOperaciones> cola = new LinkedList<ArbolOperaciones>();
		ArbolOperaciones result = this;
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
			
			result.arbolPadre.der.actualizarPadres();
		}
		else
		{
			result.arbolPadre.izq = nodo;	
			result.arbolPadre.izq.actualizarPadres();
		}
	}
	
	public String toString()
	{
		switch(raiz.getNumOperandos())
		{
		case 0: return raiz.getMensaje();
		case 1: return raiz.getMensaje() + "(" + der.toString() + ")";
		case 2: return "(" + izq.toString() + " " + raiz.getMensaje() + " " + der.toString() + ")";
		default: return "Operador no definido";
		}
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public ArrayList<ArbolOperaciones> getNodosPorNiveles()
	{
		ArrayList<ArbolOperaciones> nodos = new ArrayList<ArbolOperaciones>();
		
		nodos.add(this);
		
		for(int i = 0; i < nodos.size(); i++)
		{
			ArbolOperaciones nodo = nodos.get(i);
			
			if(nodo.izq != null)
			{
				nodos.add(nodo.izq);
			}
			
			if(nodo.der != null)
			{
				nodos.add(nodo.der);
			}
		}
		
		return nodos;
	}
}
