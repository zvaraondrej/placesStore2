package placesStore;

public class Placemark implements GetAsKML {
	
	private String name;
	private String desc;
	private Artifact artifact;

	public Placemark(){
		this.name = "Not provided";
		this.desc = "Not provided";
		this.artifact = new Artifact();
	}
	
	public Placemark(String name, String desc){
		this.name = name;
		this.desc = desc;
		this.artifact = new Artifact();
	}
	
	public void getName(){
		return this.name;
	}
	
	public void getDesc(){
		return this.desc;
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
