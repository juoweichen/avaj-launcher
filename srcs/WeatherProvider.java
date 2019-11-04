package avajlaunch;
import java.lang.Math;

public class WeatherProvider
{
	private static WeatherProvider weatherprovider;
	String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	public WeatherProvider() {}

	public static WeatherProvider getProvider()
	{
		if (weatherprovider == null)
			weatherprovider = new WeatherProvider();
		return weatherprovider;
	}

	public String getCurrentWeather(Coordinates co)
	{
		double r = Math.random() * (co.getLongitude() + co.getLatitude() + co.getHeight());
		return (weather[(int)(r % 4)]);
	}
}