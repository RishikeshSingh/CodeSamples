package Design.ConferenceRoomManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class Floor {
    FloorNames floorName;
    BuildingNames buildingName;
    HashMap<RoomNames, Room> rooms = new HashMap<>();

    public Floor(FloorNames floorName, BuildingNames buildingName) {
        this.floorName = floorName;
        this.buildingName = buildingName;
    }
}
