package Design.ConferenceRoomManagement;

public class Room {
    RoomNames roomname;
    FloorNames floorNames;
    BuildingNames buildingName;

    public Room(RoomNames roomname, FloorNames floorNames, BuildingNames buildingName) {
        this.roomname = roomname;
        this.floorNames = floorNames;
        this.buildingName = buildingName;
    }
}
