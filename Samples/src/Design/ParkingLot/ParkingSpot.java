package Design.ParkingLot;

public abstract class ParkingSpot {
    private int levelId;
    private int slotId;

    private boolean isFilled;
    private Vehicle vehicle;

    ParkingSpot(int levelId, int slotId){
        this.levelId = levelId;
        this.slotId  = slotId;
        isFilled = false;
        vehicle = null;
    }

    public int getSlotId(){
        return slotId;
    }

    public int getLevelId(){
        return levelId;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract void otherDetails();

    public void park(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isFilled = true;
    }

    public void free(){
        isFilled = false;
        vehicle = null;
    }
}
