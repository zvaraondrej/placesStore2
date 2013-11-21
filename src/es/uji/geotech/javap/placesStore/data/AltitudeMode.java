package es.uji.geotech.javap.placesStore.data;

public enum AltitudeMode {
	CLAMP_TO_GROUND("clampToGround"),
	RELATIVE_TO_GROUND("relativeToGround"),
	ABSOLUTE("absolute"),RELATIVE_TO_SEAFLOOR("relativeToSeaFloor"),
	CLAMP_TO_SEAFLOOR("clampToSeaFloor");

	private String altitudeMode;
	
	private AltitudeMode(String altitudeMode) {
		this.altitudeMode=altitudeMode;
	}
	
	public static AltitudeMode stringToEnum(String altitudeMode) {
        for (AltitudeMode enumValue : values() ){
            if (enumValue.altitudeMode.equals(altitudeMode)){
            	return enumValue;
            }
        }
        return null;
    }
}
