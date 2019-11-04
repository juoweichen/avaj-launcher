package avajlaunch;

public interface Flyable
{
	public long getID();
	public String getTag();
	public void updateConditions();
	public void registerTower(WeatherTower wt);
	public String toString();
}