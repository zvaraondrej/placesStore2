package placesStore;

public class Placemark implements GetAsKML {
	
	private String name;
	private String desc;
	private Artifact artifact;

	public Placesmark(){
		this.name = "Not provided";
		this.desc = "Not provided";
		this.artifact = null;
	}
	
	public Placemark(String name, String desc){
		this.name = name;
		this.desc = desc;
		this.artifact = new Artifact();
	}
	
	
	
	public void getName(){
		
	}
	
	public void getDesc(){
		
	}
	
	
	
	private void 
	@Override
	public String getAsKML() {
		// TODO Auto-generated method stub
		return null;
	}

}
