package es.uji.geotech.javap.placesStore.data;


public class Point extends Artifact {

	private Coordinates coordinates;
	
	public Point(double latitude, double longitude, Boolean lextrude, String laltitudeMode){
		super(lextrude,laltitudeMode);
		this.setCoordinates(new Coordinates(latitude,longitude));		
	}
	
	public String getAsKML(){
		return "<Point>\n<extrude>"+this.extrude+"</extrude>\n<altitudeMode>"+this.altitudeMode+"</altitudeMode>\n"+coordinates.getAsKML()+"\n</Point>";
	}


	/**
	 * @return the coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}


	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
}
