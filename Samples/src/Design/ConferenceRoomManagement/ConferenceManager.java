package Design.ConferenceRoomManagement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class ConferenceManager {

    public static void main(String[] args) {
        Bookings bookings = new Bookings();
        DB db = new DB();
        db.buildings.put(BuildingNames.alpha, new Building(BuildingNames.alpha));

        db.buildings.get(BuildingNames.alpha).floors.put(FloorNames.first, new Floor(FloorNames.first, BuildingNames.alpha));
        db.buildings.get(BuildingNames.alpha).floors.put(FloorNames.second, new Floor(FloorNames.second, BuildingNames.alpha));

        db.buildings.get(BuildingNames.alpha).floors.get(FloorNames.first).rooms.put(RoomNames.mars, new Room(RoomNames.mars , FloorNames.first, BuildingNames.alpha));
        db.buildings.get(BuildingNames.alpha).floors.get(FloorNames.second).rooms.put(RoomNames.saturn, new Room(RoomNames.saturn , FloorNames.second, BuildingNames.alpha));
        db.buildings.get(BuildingNames.alpha).floors.get(FloorNames.second).rooms.put(RoomNames.jupiter, new Room(RoomNames.jupiter , FloorNames.second, BuildingNames.alpha));


        /*LocalDate date1 = LocalDate.of(2017, 1, 13);
        LocalDateTime datetime1 = date1.atTime(1,50,0);

        LocalDate date2 = LocalDate.of(2017, 1, 13);
        LocalDateTime datetime2 = date2.atTime(5,50,0);

        System.out.println(datetime2.isAfter(datetime1));
        System.out.println(date1.isAfter(date2));*/

        createBooking(bookings, db, "123", BuildingNames.alpha, FloorNames.second, RoomNames.jupiter, (float)2.30, (float)4.30);
        createBooking(bookings, db, "324", BuildingNames.alpha, FloorNames.second, RoomNames.jupiter, (float)3.30, (float)4.30);
        createBooking(bookings, db, "324", BuildingNames.alpha, FloorNames.second, RoomNames.saturn, (float)3.30, (float)4.30);
        for(Booking booking: bookings.bookings){
            System.out.println("in "+booking.room.roomname+" "+booking.from +" "+ booking.to);
        }

    }

    static void createBooking(Bookings bookings, DB db, String empId, BuildingNames buildingName, FloorNames floorName, RoomNames roomNames, Float from, Float to){
        if(db.buildings.containsKey(buildingName) && db.buildings.get(buildingName).floors.containsKey(floorName) && db.buildings.get(buildingName).floors.get(floorName).rooms.containsKey(roomNames)){
            for(Booking booking: bookings.bookings){
                System.out.println(booking.room.roomname.equals(roomNames)+" "+booking.room.roomname +" "+roomNames);


                if(booking.room.roomname.equals(roomNames) && ((from > booking.from && to < booking.to) || (from < booking.from && to > booking.to) || (from > booking.from && from < booking.to) || (to > booking.from && to < booking.to))){
                    System.out.println("clashing");
                    return;
                }
            }

            bookings.bookings.add(new Booking(db.buildings.get(buildingName).floors.get(floorName).rooms.get(roomNames), from, to, empId));
        }
    }
}
