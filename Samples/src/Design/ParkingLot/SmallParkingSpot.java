package Design.ParkingLot;

public class SmallParkingSpot extends ParkingSpot{
    private VehicleType vehicleType = VehicleType.Small;

    @Override
    public void otherDetails() {

    }

    public SmallParkingSpot(int levelId, int slotId){
        super(levelId, slotId);
    }
}
