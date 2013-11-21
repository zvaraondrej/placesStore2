package es.uji.geotech.javap.placesStore;

import placesStore.GetAsKML;
import placesStore.Placemark;

public class Document implements GetAsKML {
	
	private int curPlcsNum = 0;
	private final int  MAX_PLC_NUM = 100;
	private Placemark placemarks[] = new Placemark[MAX_PLC_NUM];
	

	public Document(){
		
	}
	
	public int getMAX_PLC_NUM(){
		return this.MAX_PLC_NUM;
	}
	
	public void addPlacemark(String name, String desc){
		placemarks[this.curPlcsNum] = new Placemark(name, desc);
		this.curPlcsNum++;
	}
	
	public void searchPlacemark(){
		
	}
	
	@Override
	public String getAsKML() {
		String xmlStr = ""; 
		xmlStr += "<?xml version='1.0' encoding='UTF-8'?>";
		xmlStr += "<kml xmlns='http://www.opengis.net/kml/2.2'>";
		xmlStr += "<Document>";
		for(int i = 0; i < this.curPlcsNum; i++){
			xmlStr += placemarks[i].getAsKML();
		}
		xmlStr += "</Document>\n</kml>";
		return xmlStr;
	}

}





