package avajlaunch;

public class Coordinates
{
	private int longitude = 0;
	private int latitude = 0;
	private int height = 0;

	Coordinates(int lo, int la, int he)
	{
		longitude = lo;
		latitude = la;
		height = he;
		lowerBoundCheck();
		upperBoundCheck();
	}

	public int getLongitude() { return longitude; }
	public int getLatitude() { return latitude; }
	public int getHeight() { return height; }

	public void changeCoordinates(int lo, int la, int he)
	{
		longitude += lo;
		latitude += la;
		height += he;
		lowerBoundCheck();
		upperBoundCheck();
	}

	private void lowerBoundCheck()
	{
		if (longitude < 0)
			longitude = 0;
		if (latitude < 0)
			latitude = 0;
		if (height < 0)
			height = 0;
	}

	private void upperBoundCheck()
	{
		if (height > 100)
			height = 100;
	}
}