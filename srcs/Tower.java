package avajlaunch;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

public class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
		towerReport(flyable.getTag(), true);
	}

	public void unregister(Flyable flyable)
	{
		observers.remove(flyable);
		towerReport(flyable.getTag(), false);
	}

	protected void conditionsChanged()
	{
		for (int i = 0; i < observers.size() - 1; i++)
		{
			if (observers.get(i) == null)
				break ;
			observers.get(i).updateConditions();
		}
	}

	private void towerReport(String tag, boolean isRegister)
	{
		try
		{
			if (isRegister)
				AvajLaunch.writer.append(
					"Tower says: " + tag + " registered to weather tower.\n");
			else
				AvajLaunch.writer.append(
					"Tower says: " + tag + " unregistered from weather tower.\n");
		}
		catch (IOException e)
		{
			System.err.println("File error");
		}
	}
}