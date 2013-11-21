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
			return option;
		}

		public String askForPlaceName() {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Name: ");
			String name = scanner.nextLine();
			return name;
		}
		
		
		private int chooseDimensions(){
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Choose number of dimensions (2 or 3): ");
			int dim = scanner.nextDouble();
			return dim;
		}
		
		private double askForPlaceX() {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("X coordinate: ");
			double coord = scanner.nextDouble();
			return coord;
		}
					
		private double askForPlaceY() {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Y coordinate: ");
			double coord = scanner.nextDouble();
			return coord;
		}
		
		private double askForPlaceZ() {
			Scanner scanner = new Scanner(System.in); // System.in is the keyboard
			System.out.print("Z coordinate: ");
			double coord = scanner.nextDouble();
			return coord;
		}
		
		private Coordinates[] askForCoords(){
			private int i = 0;
			private Coordinates coords[] = new Coordinates[100]; 
			System.out.println("Enter coordinates: ");
			do{
				System.out.println("1.- Add coords.");
				System.out.println("2.- Exit.");
				int userOption = askForOption();
				if(userOption == 1){
					double x = this.askForPlaceX();
					double y = this.askForPlaceY();
					double z = this.askForPlaceZ();
					coords[i] = new CoordinatesWithAltitude(x, y, z);
					i++;
				} else if (userOption == 2) {
					System.out.println("Bbye");
				}
			}while(userOption != 2);
			return coords;
		}
		
		public void showPointMenu(){
			int dim = this.chooseDimensions();
			String name = this.askForPlaceName();
			if (dim == 2){
				double x = this.askForPlaceX();
				double y = this.askForPlaceY();
				doc.addPoint(name, desc, x, y);
			}
			else if (dim == 3){
				double x = this.askForPlaceX();
				double y = this.askForPlaceY();
				double z = this.askForPlaceZ();
				doc.addPoint(name, desc, x, y, z);
			}
			else{
				System.out.println("Error as hell!");
			}
		}


		public void showLineStringMenu(){
			String name = this.askForPlaceName();
			Coordinates[] coords = this.askForCoords();
			doc.addLineString(name, desc, coords, extrude, tessalate, altitudeMode);
		}
		
		public void showLinearRingMenu(){
			String name = this.askForPlaceName();
			Coordinates[] coords = this.askForCoords();
			doc.addLinearRing(name, desc, coords, extrude, tessalate, altitudeMode);
		}

		public void performTask(int theOption) {
			switch (theOption) {
				case 1:
					this.showPointMenu();
					break;
				case 2:
					this.showPoinshowLineStringMenutMenu();
					break;
				case 3:
					this.showLinearRingMenu();
					break;
				case 4:
					doc.getAsKML();
					break;
				case 5:
					String nameofSearched = askForPlaceName();
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