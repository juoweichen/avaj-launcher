package avajlaunch;

public class Coordinates
{
	private int longitude = 0;
	private int latitude = 0;
	private int height = 0;

	package Coordinates(int lo, int la, int he)
	{
		longitude = lo;
		latitude = la;
		height = he;
	}

	public int getLongitude() { return longitude; }
	public int getLatitude() { return latitude; }
	public int getHeight() { return height; }
}