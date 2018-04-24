package configuracion;

public class Configuracion {
	
	//Minimo indica la cota mas baja
	//private double minimo;
	//Maximo indica la cota mas alta
	//private double maximo;
	//maximimar indica si la funcion es de maximizar o minimizar
	//true -> maximizar
	//false -> minimizar
	private boolean maximizar;
	//precision guarda el error (ej 0.0001)
	//private double precision;
	//numParametros indica el numero de parametros de la funcion
	//private int numParametros;
	//Guarda el numero maximo de generaciones que introduce el usario
	private int num_generaciones;
	//Probabilidad de mutación (introducida por el usuario)
	private double prob_mutacion;
	private double cruceporcentaje;
	private int tamano_poblacion;
	private Reproduccion_enum reproduccion_seleccionada;
	private Mutacion_enum mutacion_seleccionada;
	private Seleccion_enum seleccion_seleccionada;
	private int elite;
	private String mensaje;


	public Configuracion(boolean maximizar, int num_generaciones, double prob_mutacion,
			Reproduccion_enum r, Mutacion_enum m, Seleccion_enum s, Genotipo_enum g, double probcruce,
			int tamano_poblacion, int el, String mensajeE)
	{
		this.maximizar = maximizar;
		this.num_generaciones = num_generaciones;
		this.prob_mutacion = prob_mutacion / 100;
		this.reproduccion_seleccionada = r;
		this.mutacion_seleccionada = m;
		this.seleccion_seleccionada = s;
		this.cruceporcentaje = probcruce/100;
		this.tamano_poblacion = tamano_poblacion;
		this.elite = el;
		this.mensaje = mensajeE;

	}

	public boolean isMaximizar() {
		return maximizar;
	}
	
	public void setMaximizar(boolean maximizar) {
		this.maximizar = maximizar;
	}

	public Reproduccion_enum getReproduccion_seleccionada() {
		return reproduccion_seleccionada;
	}
	
	public void setReproduccion_seleccionada(Reproduccion_enum reproduccion_seleccionada) {
		this.reproduccion_seleccionada = reproduccion_seleccionada;
	}
	
	public Mutacion_enum getMutacion_seleccionada() {
		return mutacion_seleccionada;
	}
	
	public void setMutacion_seleccionada(Mutacion_enum mutacion_seleccionada) {
		this.mutacion_seleccionada = mutacion_seleccionada;
	}
	
	public Seleccion_enum getSeleccion_seleccionada() {
		return seleccion_seleccionada;
	}
	
	public void setSeleccion_seleccionada(Seleccion_enum seleccion_seleccionada) {
		this.seleccion_seleccionada = seleccion_seleccionada;
	}
	
	public int getNum_generaciones() {
		return num_generaciones;
	}
	
	public void setNum_generaciones(int num_generaciones) {
		this.num_generaciones = num_generaciones;
	}
	
	public double getProb_mutacion() {
		return prob_mutacion;
	}
	
	public void setProb_mutacion(double prob_mutacion) {
		this.prob_mutacion = prob_mutacion;
	}
	
	public double getCruceporcentaje() {
		return cruceporcentaje;
	}
	
	public void setCruceporcentaje(double cruceporcentaje) {
		this.cruceporcentaje = cruceporcentaje;
	}
	
	public int getTamano_poblacion() {
		return tamano_poblacion;
	}
	
	public void setTamano_poblacion(int tamano_poblacion) {
		this.tamano_poblacion = tamano_poblacion;
	}
	
	public int getElite()
	{
		return elite;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}
	
}
