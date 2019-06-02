package Design.ConferenceRoomManagement;

import java.util.Date;

public class Booking {
    Room room;
    Float from;
    Float to;
    String EmployeeId;

    public Booking(Room room, Float from, Float to, String employeeId) {
        this.room = room;
        this.from = from;
        this.to = to;
        EmployeeId = employeeId;
    }
}
