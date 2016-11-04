/**
 * Event
 * Author: Feng Zhang
 * 10/14/2016
 * window 10 64bit, eclipse
 * A class that implements DeepCloneable class has references of airportsimulator. 
 */
package HW2;

class Event implements DeepCloneable<Event>{
	protected int id;
	protected double startTime;
	protected double duration;

	public Event(){ id = 0; startTime = 0; duration = 0; }
	
	public Event(int id, double t, double d)
	{
		this.id = id;
		/**id = 0;
		startTime = 0;
		duration = 0;
		setId(i);
		setStartTime(t);
		setDuration(d);*/
	}
	

	public void setId(int i){ id = i; }
	
	public boolean setStartTime(double t)
	{
		if (t >= 0)
		{
			startTime = t;
			return true;
		}
		return false;
	}
	
	public boolean setDuration(double d)
	{
		if (d >= 0)
		{
			duration = d;
			return true;
		}
		return false;
	}
	
	public int getId() { return id;  }
	
	public double getStartTime()  { return startTime; }
	
	public double getDuration()  { return duration;  }
	
	public String toString()
	{
		return "Event: "+id +", "+startTime + ", "+duration;
	}
	@Override
	public Event deepClone() {
		Event cloneEvent;
		
		cloneEvent = new Event(id, startTime, duration);
		
		return cloneEvent;
	}

}
