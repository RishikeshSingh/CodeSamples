package Design.ParkingLot;

import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Level> levels;

    public ParkingLot(int noOfLevels, int[] arrayOfBigSpots, int[] arrayOfSmallSpots){
        levels = new ArrayList<>();
        for(int i=0;i<noOfLevels;i++){
            levels.add(new Level(i, arrayOfBigSpots[i], arrayOfSmallSpots[i]));
        }
    }

    public ArrayList<Level> getLevels(){
        return levels;
    }



}