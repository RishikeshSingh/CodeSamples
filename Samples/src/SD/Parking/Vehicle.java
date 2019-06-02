package SD.Parking;

public class Vehicle {
    private String license;
    private VehicleSize size;
    private int spotsNeeded;

    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    public VehicleSize getSize(){
        return size;
    }
    public String getLicense(){
        return license;
    }

}
