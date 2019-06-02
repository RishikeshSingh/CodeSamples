package Design.ParkingLot;

import java.util.ArrayList;

public class Level {
    private int levelId;
    ArrayList<BigParkingSpot> bigParkingSpots;
    ArrayList<SmallParkingSpot> smallParkingSpots;

    public Level(int levelId, int noOfBigSpots, int noOfSmallSpots){
        System.out.println("level creation: "+levelId+" big spots: "+noOfBigSpots+" small spots: "+noOfSmallSpots);
        this.levelId = levelId;
        bigParkingSpots = new ArrayList();
        for(int i=1;i<=noOfBigSpots;i++){
            bigParkingSpots.add(new BigParkingSpot(levelId, i));
        }

        smallParkingSpots = new ArrayList();
        for(int i=1;i<=noOfSmallSpots;i++){
            smallParkingSpots.add(new SmallParkingSpot(levelId, i));
        }
    }

    public int getLevelId(){
        return levelId;
    }

    public ArrayList<BigParkingSpot> getBigParkingSpots(){
        return bigParkingSpots;
    }

    public ArrayList<SmallParkingSpot> getSmallParkingSpots(){
        return smallParkingSpots;
    }
}
