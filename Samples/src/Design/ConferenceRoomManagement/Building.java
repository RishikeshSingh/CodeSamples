package Design.ConferenceRoomManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class Building {
    BuildingNames buildingName;
    HashMap<FloorNames, Floor>  floors = new HashMap<>();

    public Building(BuildingNames buildingName) {
        this.buildingName = buildingName;
    }
}
