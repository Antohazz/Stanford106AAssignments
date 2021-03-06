package week5;

public class Road {

	private String start;
	private String dest;
	
	
	public Road (String start, String dest) {
		this.start = start;
		this.dest = dest;
	}
	
	
	
	public String getStart() {
		return start;
	}
	public String getDest() {
		return dest;
	}
	
	
	public String toString() {
		return ("Start " + getStart() + " Dest " + getDest());
	}
	
	
}
