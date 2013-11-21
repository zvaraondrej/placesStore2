package es.uji.geotech.javap.placesStore;

public abstract class Artifact implements GetAsKML {

	private Boolean extrude;

	public Artifact(){
		
	}
	
	
	
	@Override
	public String getAsKML() {
		String coordsXml = this.coords.getAsKML();
		String artifactXml = this
	}

}
