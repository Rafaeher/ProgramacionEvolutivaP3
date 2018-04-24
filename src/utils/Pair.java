package utils;

public class Pair<First, Second>
{
	public First first;
	public Second second;
	
	/**
	 * Constructora por defecto
	 */
	public Pair()
	{
		first = null;
		second = null;
	}
	
	/**
	 * Constructora a partir de los dos elementos
	 * 
	 * @param firstE
	 * @param secondE
	 */
	public Pair(First firstE, Second secondE)
	{
		first = firstE;
		second = secondE;
	}
	
	public boolean equals(Pair<First, Second> otro)
	{
		return first.equals(first) && second.equals(second);
	}
	
	public String toString()
	{
		return "<" + first.toString() + ", " + second.toString() + ">";
	}
}
