package avajlaunch;

public class Baloon extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	public Baloon(String n, Coordinates co)
	{
		super(n, co);
		// AvajLaunch.writer.append("Baloon created");
	}

	public void updateConditions()
	{
		String weather = "";
		String message = "";

		weather = weatherTower.getWeather(coordinates);
		if (weather.equals("SUN"))
		{
			message = tag + ": Let's enjoy the good weather and take some pics\n";
			coordinates.changeCoordinates(2, 0, 4);
		}
		else if (weather.equals("RAIN"))
		{
			message = tag + ": It's raining. Let cook some soup.\n";
			coordinates.changeCoordinates(0, 0, 5);
		}
		else if (weather.equals("FOG"))
		{
			message = tag + ": It's foggy. where are we?\n";
			coordinates.changeCoordinates(0, 0, -3);
		}
		else if (weather.equals("SNOW"))
		{
			message = tag + ": Want some free ice cream?\n";
			coordinates.changeCoordinates(0, 0, -15);
		}
		
		try
		{
			AvajLaunch.writer.append(message);
			if (coordinates.getHeight() <= 0)
			{
				AvajLaunch.writer.append(tag + ": Hope you enjoy this baloon trip\n");
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