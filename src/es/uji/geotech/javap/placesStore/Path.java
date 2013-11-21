package es.uji.geotech.javap.placesStore;

public abstract class Path implements GetAsKML {

	private boolean tesselate;
	private Coordinates[] coords = new Coordinates[100];
	
	//getters and setters
	private void setTessalate(boolean bool){
		this.tesselate = bool;
	}
	
	private boolean getTessalate(){
		return this.tesselate;
	}
	
	private void setCoordinates(Coordinates[] coords){
		this.coords = coords;
	}
	
	private Coordinates[] getCoordinates(){
		return this.coords;
	}
	
	private void addCoordinate(Coordinates coord){
		for(int i=0; i<this.coords.length; i++){
			if(this.coords[i] != null){
				this.coords[i] = coord;
				break;
			}
		}
	}
	
	private int getNumOfCoords(){
		int j = 0;
		for(int i=0; i<this.coords.length; i++){
			if(this.coords[i] == null){
				j++;
			}
		}
		return j;
	}
	
	
	@Override
	public String getAsKML() {
		// TODO Auto-generated method stub
		return null;
	}

}
