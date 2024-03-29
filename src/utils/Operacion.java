package utils;

public enum Operacion
{	
	SUMA(2, "+"),
	RESTA(2, "-"),
	MUL(2, "*"),
	DIV(2, "/"),
	LOG(1, "log"),
	SQRT(1, "sqrt"),
	OPUESTO(1, "-"),
	A(0, "A"),
	B(0, "B");

	private int numOperandos;
	private String mensaje;
	
	Operacion(int numOperandos, String mensaje)
	{
		this.numOperandos = numOperandos;
		this.mensaje = mensaje;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}
	
	public int getNumOperandos()
	{
		return numOperandos;
	}
}
