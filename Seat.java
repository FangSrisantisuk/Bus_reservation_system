
import java.util.*;

public class Seat {

    private int seatId;
    private boolean isReserved;
    private String passengerName;

    // Constructor with parameter
    public Seat(int seatId) {

        this.seatId = seatId;
        this.isReserved = false;
        this.passengerName = "";
    }

    // Mutators & Accessors
    public void setSeatID(int seatId) {

        this.seatId = seatId;
    }

    public void setIsReserved(boolean isReserved) {

        this.isReserved = isReserved;
    }

    public void setPassengerName(String passengerName) {

        this.passengerName = passengerName;
    }

    public int getSeatID() {

        return this.seatId;
    }

    public boolean getIsReserved() {

        return this.isReserved;
    }

    public String getPassengerName() {

        return this.passengerName;
    }

    // Make a reservation for one seat.
    public void make_reservation(String passengerName) {

        if (this.isReserved) {

            System.out.println("The seat " + this.seatId + " has been reserved by " + this.passengerName);
        }
        else {

            this.isReserved = true;
            this.passengerName = passengerName;
            System.out.println("Successfully reserved");
        }
    }

    // Cancel a reservation for one seat.
    public void cancel_reservation() {

    	if (!this.isReserved) {
    		
    		System.out.println("This seat is not reserved");
    	}
    	else {

    		this.isReserved = false;
    		this.passengerName = "";
    		System.out.println("Successfully cancelled");
    	}
    }
}