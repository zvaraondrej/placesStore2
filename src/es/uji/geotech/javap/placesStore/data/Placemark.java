package es.uji.geotech.javap.placesStore.data;
import es.uji.geotech.javap.placesStore.GetAsKML;

public class Placemark implements GetAsKML {
	
	private String name;
	private String desc;
	private Artifact artifact;

	public Placemark(){
		this.name = "Not provided";
		this.desc = "Not provided";
		//this.artifact = new Artifact();
	}
	
	public Placemark(Artifact a, String name, String desc){
		this.name = name;
		this.desc = desc;
		this.artifact = a;
	}
	
	
	
	public String getName(){
		return this.name;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public Artifact getArtifact(){
		return this.artifact;
	}
	
	public void print(){
		
	}
	
	
	
	public String getAsKML() {
		String xmlStr = "\t<Placemark>";
		xmlStr += "\t\t<name>" + this.getName() + "</name>";
		xmlStr += "\t\t<description>" + this.getDesc() + "</description>";
		//xmlStr +=  ...
		xmlStr += "\t</Placemark>";
		return xmlStr;
	}

}
