package avajlaunch;

public class Helicopter extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	public Helicopter(String n, Coordinates co)
	{
		super(n, co);
		// AvajLaunch.writer.append("Helicopter created");
	}

	public void updateConditions()
	{
		String weather = "";
		String message = "";

		weather = weatherTower.getWeather(coordinates);
		if (weather.equals("SUN"))
		{
			message = tag + ": It's hot in heli!\n";
			coordinates.changeCoordinates(10, 0, 4);
		}
		else if (weather.equals("RAIN"))
		{
			message = tag + ": I need a window brush!\n";
			coordinates.changeCoordinates(5, 0, 0);
		}
		else if (weather.equals("FOG"))
		{
			message = tag + ": We lost in the fog...\n";
			coordinates.changeCoordinates(1, 0, 0);
		}
		else if (weather.equals("SNOW"))
		{
			message = tag + ": My rotor freezen!\n";
			coordinates.changeCoordinates(0, 0, -12);
		}

		try
		{
			AvajLaunch.writer.append(message);
			if (coordinates.getHeight() <= 0)
			{
				AvajLaunch.writer.append(tag + ": Landing, OMGGGGGGGGG, we're crashing, WAAAAAAAA\n");
				weatherTower.unregister(this);
			}
		}
		catch (Exception e) {
			System.err.println("File error");
		}
	}

	public void registerTower(WeatherTower wt)
	{
		weatherTower = wt;
	}
}