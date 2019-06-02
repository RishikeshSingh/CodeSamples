package Design.ParkingLot;

public abstract class Vehicle {

    protected String numberPlate;
    protected VehicleType type;

    public VehicleType getVehicleType(){
        return type;
    }

    public String getNumberPlate(){
        return numberPlate;
    }

    public Vehicle(String numberPlate, VehicleType vehicleType){
        this.numberPlate = numberPlate;
        this.type = vehicleType;
    }

}
