package avajlaunch;

public class Aircraft
{
	protected long id = 0;
	protected String name = "";
	protected Coordinates coordinates;

	private long idCounter = 0;

	protected Aircraft(String n, Coordinates co)
	{
		name = n;
		coordinates = co;
	}

	private long nextID()
	{
		return idCounter;
	}
}