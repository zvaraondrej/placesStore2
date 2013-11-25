package es.uji.geotech.javap.placesStore.main;

import java.util.Scanner;

import es.uji.geotech.javap.placesStore.data.*;


public class InitializePlacesStore {

	public static Document doc = new Document();
	
	public static void main(String[] args) {
		
		InitializePlacesStore myNewApplication = new InitializePlacesStore();
			myNewApplication.go();
		}

		public void go() {
			int userOption;
			do {
				printOutMenu();
				userOption = askForOption();
				performTask(userOption);
			} while (userOption != 0); // != not equal.
		}
		
		public void printOutMenu() {
			System.out.println("1.- Add new a Point.");
			System.out.println("2.- Add new a LineString.");
			System.out.println("3.- Add new a LineRing.");
			System.out.println("4.- Generate XML.");
			System.out.println("5.- Search for a Place by its name.");
			System.out.println("0.- Exit");
		}

		public int askForOption() {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Please, select an option: ");
			int option = scanner.nextInt();
			scanner.close();
			return option;
		}

		/********/
		
		public void showPointMenu(){
			int dim = this.chooseDimensions();
			String name = this.askForPlaceNameOrDesc("Name");
			String desc = this.askForPlaceNameOrDesc("Desc");
			if (dim == 2){
				double x = this.askForPlaceCoord("X");
				double y = this.askForPlaceCoord("Y");
				doc.addPoint(name, desc, x, y);
			}
			else if (dim == 3){
				double x = this.askForPlaceCoord("X");
				double y = this.askForPlaceCoord("Y");
				double z = this.askForPlaceCoord("Z");
				doc.addPoint(name, desc, x, y, z);
			}
			else{
				System.out.println("Error as hell!");
			}
		}
		
		private int chooseDimensions(){
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Choose number of dimensions (2 or 3): ");
			int dim = scanner.nextInt();
			scanner.close();
			return dim;
		}
		
		public String askForPlaceNameOrDesc(String str) {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print(str + ": ");
			String txt = scanner.nextLine();
			scanner.close();
			return txt;
		}
		
		private double askForPlaceCoord(String c) {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print(c + "coordinate: ");
			double coord = scanner.nextDouble();
			scanner.close();
			return coord;
		}
	
		public void showLineMenu(String type){
			String name = this.askForPlaceNameOrDesc("Name");
			String desc = this.askForPlaceNameOrDesc("Desc");
			Coordinates[] coords = this.askForCoords();
			
			// methods to get extrude, tess, altMode ...
			boolean tessalate = getBoolParam("tessalate");
			boolean extrude = getBoolParam("extrude");
			AltitudeMode altitudeMode = getAltitudeMode();
			
			
			
			
			if(type == "LineString"){
				doc.addLineString(name, desc, coords, extrude, tessalate, altitudeMode);
			}
			else if(type == "LinearRing"){
				doc.addLinearRing(name, desc, coords, extrude, tessalate, altitudeMode);
			}
		}
		
		private Coordinates[] askForCoords(){
			int i = 0;
			Coordinates coords[] = new Coordinates[100]; 
			System.out.println("Enter coordinates: ");
			int userOption;
			do{
				System.out.println("1.- Add coords.");
				System.out.println("2.- Exit.");
				userOption = askForOption();
				if(userOption == 1){
					double x = this.askForPlaceCoord("X");
					double y = this.askForPlaceCoord("Y");
					double z = this.askForPlaceCoord("Z");
					coords[i] = new CoordinatesWithAltitude(x, y, z);
					i++;
				} else if (userOption == 2) {
					System.out.println("Bbye");
				}
			}while(userOption != 2);
			return coords;
		}
		
		
		
		private boolean getBoolParam(String type){
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Choose parameter " + type + " value: ");
			int intChoice;
			do{
				System.out.print("Type 1 for true");
				System.out.print("Type 0 for false");
				intChoice = scanner.nextInt();
			} while(intChoice == 1 || intChoice == 0);
			
			boolean boolChoice;
			if (intChoice == 1){
				boolChoice = true;
			}
			else{
				boolChoice = false;
			}
			scanner.close();
			
			return boolChoice;
		}
		
		private AltitudeMode getAltitudeMode(){
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Choose Altitude Mode: ");
			int test = 0;
			String str;
			AltitudeMode altStr = null;
			do{
				str = scanner.nextLine();
				if(AltitudeMode.stringToEnum(str) != null){
					altStr = AltitudeMode.stringToEnum(str);
				}
			}
			while(altStr != null);
			return altStr;
		}
		


		public void performTask(int theOption) {
			switch (theOption) {
				case 1:
					this.showPointMenu();
					break;
				case 2:
					this.showLineMenu("LineString");
					break;
				case 3:
					this.showLineMenu("LinearRing");
					break;
				case 4:
					doc.getAsKML();
					break;
				case 5:
					String nameofSearched = askForPlaceNameOrDesc("Name");
					doc.searchPlacemark(nameofSearched);
					break;
				case 0:
					sayGoodBye();
					break;
				default:
					System.out.println("Please select a valid option.");
					break;
				}
			}
					
			public void sayGoodBye() {
				System.out.println("Thanks for using my app.");
			}
		}