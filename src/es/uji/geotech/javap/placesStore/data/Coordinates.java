package es.uji.geotech.javap.placesStore.data;

public class Coordinates {
	private double latitude;
	private double longitude;
		
	public Coordinates(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAsKML(){
		return "<coordinates>"+this.latitude+","+this.longitude+"</coordinates>";
	}
}
