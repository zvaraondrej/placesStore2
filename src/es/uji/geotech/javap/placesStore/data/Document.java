package es.uji.geotech.javap.placesStore.data;
import es.uji.geotech.javap.placesStore.GetAsKML;

public class Document implements GetAsKML {
	
	private int curPlcsNum = 0;
	private final int  MAX_PLC_NUM = 100;
	private Placemark placemarks[] = new Placemark[MAX_PLC_NUM];
	

	public Document(){
		
	}
	
	public int getMAX_PLC_NUM(){
		return this.MAX_PLC_NUM;
	}
	
	public void addPoint(String name, String desc, double x, double y){
		Point p = new Point(x,y);
		placemarks[this.curPlcsNum] = new Placemark(p, name, desc);
		this.curPlcsNum++;
	}
	
	public void addPoint(String name, String desc, double x, double y, double z){
		Point p = new Point(x,y,z);
		placemarks[this.curPlcsNum] = new Placemark(p, name, desc);
		this.curPlcsNum++;
	}
	
	
	public void addLineString(String name, String desc, Coordinates[] coords, Boolean extrude, Boolean tessalate, AltitudeMode altitudeMode){
		LineString ls = new LinearRing(extrude, altitudeMode, tessalate, coords);
		placemarks[this.curPlcsNum] = new Placemark(ls, name, desc);
		this.curPlcsNum++;
	}
	
	public void addLinearRing(String name, String desc, Coordinates[] coords, Boolean extrude, Boolean tessalate, AltitudeMode altitudeMode){
		LinearRing lr = new LinearRing(extrude, altitudeMode, tessalate, coords);
		placemarks[this.curPlcsNum] = new Placemark(lr, name, desc);
		this.curPlcsNum++;
	}
	
	
	public void searchPlacemark(String pattern){
		pattern = pattern.toUpperCase();
		for(int i=0; i<this.curPlcsNum; i++){
			String compared = placemarks[i].getName().toUpperCase();
			if(pattern.equals(compared)){
				placemarks[i].print();
				break;
			}
		}
	}
	
	public void listAllPlaces(){
		for(int i=0; i<this.curPlcsNum; i++){
			placemarks[i].print();
		}
	}
	
	@Override
	public String getAsKML() {
		String xmlStr = ""; 
		xmlStr += "<?xml version='1.0' encoding='UTF-8'?>\n";
		xmlStr += "<kml xmlns='http://www.opengis.net/kml/2.2'>\n";
		xmlStr += "<Document>\n";
		for(int i = 0; i < this.curPlcsNum; i++){
			xmlStr += placemarks[i].getAsKML();
		}
		xmlStr += "</Document>\n</kml>";
		return xmlStr;
	}

}





