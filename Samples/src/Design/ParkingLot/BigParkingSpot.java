package Design.ParkingLot;

public class BigParkingSpot extends ParkingSpot {

    private VehicleType vehicleType = VehicleType.Big;

    @Override
    public void otherDetails() {

    }

    public BigParkingSpot(int levelId, int slotId){
        super(levelId, slotId);
    }


}
