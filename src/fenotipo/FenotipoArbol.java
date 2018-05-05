package fenotipo;

public class FenotipoArbol implements Fenotipo{

	@Override
	public Fenotipo cloneFenotipo()
	{
		return new FenotipoArbol();
	}

}
