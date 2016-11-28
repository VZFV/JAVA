package HashTableCodeFiles;

import java.text.*;

public class Location {
	private String name="";
	private String address="";
	private double latitude; // default 0
	private double longitude; // default 0
	
	public Location(String nm, String addr, double lat, double lon)
	{
		setName(nm);
		setAddress(addr);
		setCoordinates(lat, lon);
	}
	
	public Location(String nm)
	{
		setName(nm);
	}
	
	public void setName(String nm)
	{
		if( nm != null )
			name = nm;
	}
	
	public void setAddress(String addr)
	{
		if( addr != null )
			address = addr;
	}
	
	public void setCoordinates(double lat, double lon)
	{
		latitude = lat;
		longitude = lon;
	}
	
	public String getName(){ return name; }
	
	public String getAddress(){ return address; }
	
	public double getLatitude(){ return latitude; }
	
	public double getLongitude(){ return longitude; }
	
	public String toString()
	{
		return "Location: "+ name + ", " + address + 
				", (" + latitude + ", " + longitude + ")";
	}
	
	// YOU WRITE equals: public boolean equals(Object obj)
	public boolean equals(Object obj){
		String compName;
		if (obj instanceof Location){
			compName = ((Location)obj).name;
		}else
			compName = "";
		return name.equalsIgnoreCase(compName);
		
	}
	
	// YOU WRITE hashCode: public int hashCode()
	public int hashCode(){
		
		 String lastString, lonString, resultStr;
		 DecimalFormat decFormat = new DecimalFormat("000.0000");
		 lastString = decFormat.format(latitude + 90);
		 lonString = decFormat.format(longitude + 180);
		 resultStr = lastString.replace(".", "") + lonString.replace(".", "");
		 return resultStr.hashCode();
		 
		/*double lat = latitude + 90;
		double lon = longitude + 180;
		
		DecimalFormat myFormatter = new DecimalFormat("000.0000");
	    String lat1 = myFormatter.format(lat);
	    String lon1 = myFormatter.format(lon);
	    String lat2 = lat1.substring(0, 3) + lat1.substring(4);
	    String lon2 = lon1.substring(0, 3) + lon1.substring(4);
	    
	    return ((lat2 + lon2) != null) ? (lat2 + lon2).hashCode() : 0;
	    */
	}
}
