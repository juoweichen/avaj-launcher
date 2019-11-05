package avajlaunch;

public class JetPlane extends Aircraft implements Flyable
{
	WeatherTower weatherTower;
	

	public JetPlane(String n, Coordinates co)
	{
		super(n, co);
	}

	public void updateConditions()
	{
		String weather = "";
		String message = "";

		weather = weatherTower.getWeather(coordinates);
		if (weather.equals("SUN"))
		{
			message = tag + ": What a bueatiful day!\n";
			coordinates.changeCoordinates(0, 10, 2);
		}
		else if (weather.equals("RAIN"))
		{
			message = tag + ": It's raining. Better watch out for lightings.\n";
			coordinates.changeCoordinates(0, 5, 0);
		}
		else if (weather.equals("FOG"))
		{
			message = tag + ": It's foggy. turn on head light\n";
			coordinates.changeCoordinates(0, 1, 0);
		}
		else if (weather.equals("SNOW"))
		{
			message = tag + ": Oh, Winter is coming.\n";
			coordinates.changeCoordinates(0, 0, -7);
		}

		try
		{
			AvajLaunch.writer.append(message);
			if (coordinates.getHeight() <= 0)
			{
				AvajLaunch.writer.append(tag + ": Landing, thank you to fly with us\n");
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