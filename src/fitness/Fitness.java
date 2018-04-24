package fitness;

public interface Fitness extends Comparable<Fitness>
{
	public Fitness cloneFitness();
	
	public double getValorReal();
}
