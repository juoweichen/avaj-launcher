package avajlaunch;

public class AircraftFactory
{
	public static boolean checkAircraft(String[] lineSplit)
	{
		int lo, la, he;

		if (lineSplit.length != 5)
		{
			System.out.println("Incorrect line numbers");
			return false;
		}
		else if (	!lineSplit[0].equalsIgnoreCase("JetPlane") &&
					!lineSplit[0].equalsIgnoreCase("Helicopter") &&
					!lineSplit[0].equalsIgnoreCase("Baloon"))
		{
			System.out.println("Not such kinds of aircraft");
			return false;
		}
		else
		{
			try 
			{
				lo = Integer.parseInt(lineSplit[2]);
				la = Integer.parseInt(lineSplit[3]);
				he = Integer.parseInt(lineSplit[4]);
			} 
			catch (NumberFormatException e) 
			{
				System.err.println("Number format incorrect");
				return false;
			}
		}
		return true;
	}

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		if ("JetPlane".equalsIgnoreCase(type))
			return new JetPlane(name, new Coordinates(longitude, latitude, height));
		else if ("Helicopter".equalsIgnoreCase(type))
			return new Helicopter(name, new Coordinates(longitude, latitude, height));
		else if ("Baloon".equalsIgnoreCase(type))
			return new Baloon(name, new Coordinates(longitude, latitude, height));
		return null;
	}
}