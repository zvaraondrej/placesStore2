package es.uji.geotech.javap.placesStore;

public class Coordinates {
	private double x;
	private double y;
		
	public Coordinates(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Coordinates() {
		// TODO Auto-generated constructor stub
	}

	public double getX(){
		return this.x;
	}
		
	public double getY(){
		return this.y;
	}
	
	public String getAsKML(){
		return "blabla";
	}
}
