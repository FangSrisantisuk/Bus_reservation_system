
import java.util.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static int userChoice = 0;
	static boolean isRunning = true;
	static LinkedList<Bus> buses = new LinkedList<>();

	public static void main(String [] args) {
		
		do {

			mainMenu();
			if (userInputIsValid()) {

				performChoice(userChoice);
			}
			else {

				System.out.println("Please enter a valid choice");
			}
			
			if (isRunning) {
				
				System.out.println("Please enter anything to go back to main menu");
				scanner.next();
			}
		}
		while (isRunning);
	}

	// Print out the main menu for the user.
	// The user can use this system by entering some number. 
	public static void mainMenu() {

		System.out.println();
		System.out.println("Welcome to bus reservation system");
		System.out.println("1. Add a bus");
		System.out.println("2. Reservation");
		System.out.println("3. Show buses information");
		System.out.println("4. Exit");
		System.out.println("Enter your choice (a number):");
	}

	public static void addABus(int busId, int capacity, int numberOfSeatsAvaliable, boolean busIsAvailable) {

		Bus tmpBus = new Bus(busId, capacity, numberOfSeatsAvaliable, busIsAvailable);
		buses.add(tmpBus);
	}

	public static void reservation(String passengerName, int busId, int seatId) {

		Iterator<Bus> bus = buses.iterator();
		Bus tmpBus;
		boolean validBusId = false;

		while (bus.hasNext()) {

			tmpBus = bus.next();

			// The bus has been added to the linked list.
			if (tmpBus.getBusId() == busId) {

				// Check if this bus is available.
				if (!tmpBus.getBusIsAvailable()) {

					System.out.println("Bus " + busId + " is not available");
					validBusId = true;
					break;
				}

				// Calculate how many seats in the bus have been reserved.
				int reservedSeats = 0;
				for (int i = 0; i < tmpBus.getCapacity(); i++) {

					if (tmpBus.getSeats(i + 1).getIsReserved()) {

						reservedSeats++;
					}
				}

				// Check if more seats can be reserved.
				if (reservedSeats == tmpBus.getNumberOfSeatsAvailable()) {

					System.out.println("You cannot reserve any more seats in the bus " + busId);
					validBusId = true;
					break;
				}

				// Reserve the seat in the bus.
				tmpBus.make_reservation(passengerName, seatId);
				validBusId = true;
				break;
			}
		}

		if (!validBusId) {

			System.out.println("Please enter a valid bus ID");
		}
	}

	public static void showBusesInfo() {

		Iterator<Bus> bus = buses.iterator();
		Bus tmpBus;

		while (bus.hasNext()) {

			tmpBus = bus.next();

			if (!tmpBus.getBusIsAvailable()) {

				System.out.println("This bus is currently not availble");
				System.out.println("Bus capacity: " + tmpBus.getCapacity());
				System.out.println("Number of seats available: " + tmpBus.getNumberOfSeatsAvailable());
				System.out.println("Bus id: " + tmpBus.getBusId());
				System.out.println();
			}
			else {

				System.out.println("This bus is currently availble");
				System.out.println("Bus capacity: " + tmpBus.getCapacity());
				System.out.println("Number of seats available: " + tmpBus.getNumberOfSeatsAvailable());
				tmpBus.bus_information();
			}
		}
	}

	public static boolean userInputIsValid() {

		try {

			userChoice = scanner.nextInt();
		}
		catch (Exception e) {

			return false;
		}

		return true;
	}

	public static void performChoice(int choice) {

		int busId;

		switch (choice) {

		case 1:
			System.out.println("Enter Bus ID: ");
			busId = scanner.nextInt();
			System.out.println("Enter Number of available seats: ");
		    int numberOfSeatsAvaliable = scanner.nextInt();
			System.out.println("Enter Bus Capacity: ");
		    int capacity = scanner.nextInt();
			System.out.println("Is bus Available? (True/False): ");
		    boolean busIsAvailable = scanner.nextBoolean();
		    addABus(busId, capacity, numberOfSeatsAvaliable, busIsAvailable);
		    break;
		case 2:
			System.out.println("Enter Passenger Name: ");
			String passengerName = scanner.next();
			System.out.println("Enter Bus ID: ");
		    busId = scanner.nextInt();
			System.out.println("Enter Seat ID: ");
		    int seatId = scanner.nextInt();
		    reservation(passengerName, busId, seatId);
		    break;
		case 3:
			showBusesInfo();
		    break;
		case 4:
			isRunning = false;
		    break;
		default:
			System.out.println("Please enter a valid choice");
		}
	}
}