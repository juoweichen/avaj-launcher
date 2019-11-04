package avajlaunch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NumberFormatException;

public class AvajLaunch
{
	public static BufferedWriter writer;
	
	public static void main(String arg[])
	{
		BufferedReader reader;
		String line = "";
		int totalCycleTimes = 0;
		String[] lineSplit;
		WeatherTower wt = new WeatherTower();

		try
		{
			writer = new BufferedWriter(
				new FileWriter(System.getProperty("user.dir") + "/" + "simulation.txt"));
			// read file
			reader = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "/" + arg[0]));
			// read first line
			if ((line = reader.readLine()) != null)
				totalCycleTimes = Integer.parseInt(line);
			// read reset of line
			line = reader.readLine();
			while (line != null)
			{
				lineSplit = line.split(" ", 0);
				if (AircraftFactory.checkAircraft(lineSplit))
				{
					// create aircraft
					Flyable f = AircraftFactory.newAircraft(
						lineSplit[0],
						lineSplit[1],
						Integer.parseInt(lineSplit[2]),
						Integer.parseInt(lineSplit[3]),
						Integer.parseInt(lineSplit[4])
					);
					wt.register(f);
					f.registerTower(wt);
				}
				line = reader.readLine();
			}

			// changing weather
			for (int i = 0; i < totalCycleTimes; i++)
			{
				AvajLaunch.writer.append("Day " + (i + 1) + "\n");
				wt.changeWeather();
			}

			reader.close();
			writer.close();
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("No arg");
		}
		catch (IOException e)
		{
			System.err.println("File error");
		}
		catch (NumberFormatException e) 
		{
			System.err.println("Number format incorrect");
		}
	}
}
