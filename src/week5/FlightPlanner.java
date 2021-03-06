package week5;

import java.util.*;
import java.io.*;
import acm.program.*;
import acm.util.*;


public class FlightPlanner extends ConsoleProgram {
	
	private String file = "src\\week5\\flights.txt";
	private Road road;
	private ArrayList<Road> roadMap = new ArrayList<Road>();
	private Map <String, City> cityMap = new HashMap<String, City>();
	private ArrayList<String> route = new ArrayList<String>();

	private String startingCity;
	private String city;
	
	public void run() {
		
		println("Welcome to Anton's Flight planner!");
		
		loadDatabase(file);
		createCitiesMap();
		showCityDatabase();
		route.clear();
		println("Let's plan your round trip!");
		
		startingCity = readLine("Enter starting city: ");
		route.add(startingCity);
		
		showOptions(startingCity);
		pickDest();
		
		while(!startingCity.equals(city)) {
		showOptions(city);
		pickDest();
		}
		
		printRoute();
		
	}//run()
	

//-------------------------------------------------------------------------	
	private void loadDatabase(String file) {
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader(file));
			
			while(true) {
				String line = rd.readLine();				
				if(line == null) break;
				Road road = parseLine(line);
				roadMap.add(road);
				

			}
		
			rd.close();
		
		}catch (IOException ex){
			println("file not found. input path/flights.txt");
			file = readLine();
			loadDatabase(file);
		}//catch
		
	}//loadDatabase()


	private Road parseLine(String line) {
		String startStr = "";
		String destStr = "";
		int firstCh = 0;
		int lastCh = line.indexOf("->")-1;
		
		startStr = line.substring(firstCh, lastCh);
		
		firstCh = line.indexOf(">") + 2;
		
		destStr = line.substring(firstCh);
		
//		println(startStr);/////////////////////////////////////////////
//		println(destStr);/////////////////////////////////////////////
//		Road testRoad =  new Road(startStr, destStr);
//		println(testRoad.toString());
		
		return new Road(startStr, destStr);
	}
	
//--------------------------------------------------	
	
	private void createCitiesMap() {
		for (int i = 0; i < roadMap.size(); i++) {
			String start = roadMap.get(i).getStart();
			if (cityMap.get(start) == null) {
				cityMap.put(start, new City(start));
				for (int j = 0; j < roadMap.size(); j++) {
					if(roadMap.get(j).getStart().equals(start)) {
						cityMap.get(start).setConnectedCities(roadMap.get(j).getDest());
					}
				}
			}
		}
		
		
	}//createCitiesMap()
	
	
	private void showCityDatabase() {
		
		println("List of cities in database:");
		
		Iterator <String> iter = cityMap.keySet().iterator();
		while (iter.hasNext()) {
			String k = iter.next();
			println(k);			
			
		}
		
		
	}

	private void showOptions(String c) {
		
		 for (int i = 0; i < cityMap.get(c).getConnectedCities().size(); i++){
             println(cityMap.get(c).getConnectedCities().get(i));
		 }
		 
	}

	private void pickDest() {
		city = readLine("Enter destination: ");
		route.add(city);
	}
	
	private void printRoute() {
		println("your route: ");
		for (int i = 0; i < route.size(); i++){
			println(route.get(i));

	}
        	 }
	
}//class
