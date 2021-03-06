package week5;
import java.util.*;

public class City {

	private String cityName;
	
	private ArrayList<String> connectedCities = new ArrayList<String>();
		
	City(String cityName){
		this.cityName = cityName;
	}
	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public ArrayList<String> getConnectedCities() {
		return connectedCities;
	}

	public void setConnectedCities(String city) {
		this.connectedCities.add(city);
	}
	
	
	
}
