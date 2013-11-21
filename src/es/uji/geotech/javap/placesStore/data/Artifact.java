package es.uji.geotech.javap.placesStore.data;

import es.uji.geotech.javap.placesStore.GetAsKML;

public abstract class Artifact implements GetAsKML {

	protected Boolean extrude;
	protected AltitudeMode altitudeMode;

	public Artifact(Boolean lextrude, String laltitudeMode){
		this.extrude=lextrude;
		this.altitudeMode = AltitudeMode.stringToEnum(laltitudeMode);
	}	
	
	@Override
	public String getAsKML() {
		// TODO Auto-generated method stub
		return null;
	}

}
