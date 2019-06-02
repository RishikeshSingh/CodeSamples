package Design.ParkingLot;


public class ParkingLotManager {

    static class ParkingCharge{
        int small = 20;
        int medium = 50;
        int large = 80;
    }

    void buildParkingLot(){}

    static SlotInfo findSlot(ParkingLot parkingLot, VehicleType vehicleType){
        for(int i=0;i<parkingLot.levels.size();i++){
            for(int j=1;j<parkingLot.levels.get(i).bigParkingSpots.size();j++){
                if(parkingLot.levels.get(i).bigParkingSpots.get(j).isFilled() == false){
                    System.out.println("available: "+parkingLot.levels.get(i).getLevelId()+" "+ parkingLot.levels.get(i).bigParkingSpots.get(j).getSlotId());
                    //return new SlotInfo(parkingLot.levels.get(i).getLevelId(), parkingLot.levels.get(i).bigParkingSpots.get(j).getSlotId());
                }
            }
        }

        for(Level level : parkingLot.getLevels()){
            System.out.println("diferent method "+level.getLevelId());
            for(BigParkingSpot bigParkingSpot: level.getBigParkingSpots()){
                if(bigParkingSpot.isFilled() == false){
                    System.out.println("different method of looping -  available:"+" - level: "+ bigParkingSpot.getLevelId()+" slot: "+ bigParkingSpot.getSlotId());

                }else{
                    System.out.println("Hey I found a filled one");
                }
            }
        }
        return new SlotInfo(-1,-1);
    }

    /*SlotInfo park(){
        //findSlot and park
        //fill that slot with object
    }

    int checkout(SlotInfo){
        //free the space
    }*/

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //int noOfLevels = scan.nextInt();
        int noOfLevels = 2;
        int[] noOfBigSpots = {3, 6};//new int[noOfLevels];
        int[] noOfSmallSpots = {2,4};//new int[noOfLevels];
//        for(int i=0;i<noOfLevels;i++){
//            noOfBigSpots[i] = scan.nextInt();
//            noOfSmallSpots[i] = scan.nextInt();
//        }
        ParkingLot parkingLot = new ParkingLot(noOfLevels, noOfBigSpots, noOfSmallSpots);
        for(Level level: parkingLot.levels){
            for(ParkingSpot parkingSpot: level.bigParkingSpots){
                System.out.print(parkingSpot.getSlotId()+" ");
            }
            System.out.println();
            for(ParkingSpot parkingSpot: level.smallParkingSpots){
                System.out.print(parkingSpot.getSlotId());
            }
            System.out.println();
        }

        Vehicle vehicle = new Car("KA 01 2345", VehicleType.Medium);
        System.out.println("fist time findSlot called");
        findSlot(parkingLot, VehicleType.Big);
        parkingLot.levels.get(0).bigParkingSpots.get(1).park(vehicle);
        System.out.println(parkingLot.levels.get(0).bigParkingSpots.get(1).getVehicle().numberPlate);
        System.out.println(parkingLot.levels.get(0).bigParkingSpots.get(1).isFilled());

        System.out.println("finding slot after addition");
        findSlot(parkingLot, VehicleType.Big);
        parkingLot.levels.get(0).bigParkingSpots.get(1).free();
        System.out.println("finding slot after freeing");
        findSlot(parkingLot, VehicleType.Big);
        System.out.println(parkingLot.levels.get(0).bigParkingSpots.get(1).isFilled());

    }
}

