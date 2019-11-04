package avajlaunch;

public class Aircraft
{
	protected long id = 0;
	protected String name = "";
	protected Coordinates coordinates;
	protected String tag;

	private static long idCounter = 0;

	protected Aircraft(String n, Coordinates co)
	{
		name = n;
		coordinates = co;
		id = nextID();
		tag = this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
	}

	private long nextID()
	{
		idCounter += 1;
		return idCounter;
	}

	public long getID()
	{
		return id;
	}

	public String getTag()
	{
		return tag;
	}

	public String toString()
	{
		return ("type: " + this.getClass().getSimpleName() + 
			", Name: " + name + 
			", id: " + id + 
			", lo: " + coordinates.getLongitude() + 
			", la: " + coordinates.getLatitude() + 
			", he: " + coordinates.getHeight());
	}
}