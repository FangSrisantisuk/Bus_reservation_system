
import java.util.*;

public class Bus{

    private int busId;
    private final int capacity; // the maximum number of seats for a bus
    private int numberOfSeatsAvaliable;
    private Seat [] seats;
    private boolean busIsAvailable;

    // Constructor with parameters
    public Bus(int busId, int capacity, int numberOfSeatsAvaliable, boolean busIsAvailable) {

        this.busId = busId;
        this.capacity = capacity;
        this.numberOfSeatsAvaliable = numberOfSeatsAvaliable;
        this.seats = new Seat[this.capacity];
        this.busIsAvailable = busIsAvailable;

        int seatId = 1;
        for (int i = 0; i < this.capacity; i++) {

            this.seats[i] = new Seat(seatId);
            seatId++;
        }
    }

    // Mutators & Accessors
    public void setBusId(int busId) {

        this.busId = busId;
    }

    public void setNumberOfSeatsAvaliable(int numberOfSeatsAvaliable) {

        this.numberOfSeatsAvaliable = numberOfSeatsAvaliable;
    }

    public void setBusIsAvailable(boolean busIsAvailable) {

        this.busIsAvailable = busIsAvailable;
    }

    public int getBusId() {

        return this.busId;
    }

    public int getCapacity() {
    	
    	return this.capacity;
    }
    
    public int getNumberOfSeatsAvailable() {

        return this.numberOfSeatsAvaliable;
    }

    public Seat getSeats(int seatId) {
    	
    	return this.seats[seatId - 1];
    }
    
    public boolean getBusIsAvailable() {

        return this.busIsAvailable;
    }

    // Make a reservation for one seat on the bus.
    public void make_reservation(String passengerName, int seatId) {

    	if (0 < seatId && seatId < this.capacity) {
    		
    		this.seats[seatId - 1].make_reservation(passengerName);
    	}
    	else {
    		
    		System.out.println("Please enter a valid seat ID");
    	}
    }

    // Cancel a reservation for one seat on the bus.
    public void cancel_reservation(int seatId) {

    	if (0 < seatId && seatId < this.capacity) {

    		this.seats[seatId - 1].cancel_reservation();
    	}
    	else {

    		System.out.println("Please enter a valid seat ID");
    	}
    }

    // Print out the information of the bus.
    public void bus_information() {

        System.out.println("Bus id: " + this.busId);

        Seat tmpSeat;
        for (int i = 0; i < this.capacity; i++) {

            tmpSeat = this.seats[i];
            
            if (!tmpSeat.getIsReserved()) {

                System.out.printf("%10s", "Empty");
            }
            else {

                System.out.printf("%10s", tmpSeat.getPassengerName());
            }

            if ((i + 1)%4 == 0) {

                System.out.print("\n");
            }
        }
    }
}