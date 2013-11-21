package es.uji.geotech.javap.placesStore.data;

public class CoordinatesWithAltitude extends Coordinates {
	private double altitude;
	
	public CoordinatesWithAltitude(double latitude, double longitude, double altitude){
		super(latitude,longitude);
		this.altitude=altitude;
	}
	
	
	public String getAsKML(){
		return "Hola!!";
	}


	/**
	 * @return the altitude
	 */
	public double getAltitude() {
		return altitude;
	}


	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	


	
	
	
}
