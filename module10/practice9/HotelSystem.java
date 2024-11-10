package Modules.module10.practice9;

class RoomBookingSystem {
    public void bookRoom(String roomType) {
        System.out.println(roomType + " room booked.");
    }

    public void checkAvailability(String roomType) {
        System.out.println("Checking availability for " + roomType + " room.");
    }

    public void cancelBooking(String roomType) {
        System.out.println(roomType + " room booking cancelled.");
    }
}

class RestaurantSystem {
    public void bookTable(int numberOfPeople) {
        System.out.println("Table booked for " + numberOfPeople + " people.");
    }

    public void orderFood(String dish) {
        System.out.println("Ordered food: " + dish);
    }
}

class EventManagementSystem {
    public void bookConferenceRoom(String room, int attendees) {
        System.out.println("Conference room " + room + " booked for " + attendees + " attendees.");
    }

    public void orderEquipment(String equipment) {
        System.out.println("Ordered equipment: " + equipment);
    }
}

class CleaningService {
    public void scheduleCleaning(String roomType) {
        System.out.println("Scheduled cleaning for " + roomType + " room.");
    }

    public void cleanRoom(String roomType) {
        System.out.println(roomType + " room cleaned.");
    }
}

class HotelFacade {
    private RoomBookingSystem roomBookingSystem;
    private RestaurantSystem restaurantSystem;
    private EventManagementSystem eventManagementSystem;
    private CleaningService cleaningService;

    public HotelFacade(RoomBookingSystem roomBookingSystem, RestaurantSystem restaurantSystem,
                       EventManagementSystem eventManagementSystem, CleaningService cleaningService) {
        this.roomBookingSystem = roomBookingSystem;
        this.restaurantSystem = restaurantSystem;
        this.eventManagementSystem = eventManagementSystem;
        this.cleaningService = cleaningService;
    }

    public void bookRoomWithService(String roomType) {
        roomBookingSystem.bookRoom(roomType);
        restaurantSystem.orderFood("Welcome meal");
        cleaningService.scheduleCleaning(roomType);
    }

    public void organizeEventWithAccommodation(String conferenceRoom, String roomType, int attendees) {
        eventManagementSystem.bookConferenceRoom(conferenceRoom, attendees);
        eventManagementSystem.orderEquipment("Projector");
        roomBookingSystem.bookRoom(roomType);
    }

    public void bookTableWithTaxi(int numberOfPeople) {
        restaurantSystem.bookTable(numberOfPeople);
        System.out.println("Taxi ordered for restaurant visit.");
    }

    public void cancelRoomBooking(String roomType) {
        roomBookingSystem.cancelBooking(roomType);
    }
}


public class HotelSystem {
    public static void main(String[] args) {
        RoomBookingSystem roomBooking = new RoomBookingSystem();
        RestaurantSystem restaurant = new RestaurantSystem();
        EventManagementSystem eventManagement = new EventManagementSystem();
        CleaningService cleaning = new CleaningService();

        HotelFacade hotelFacade = new HotelFacade(roomBooking, restaurant, eventManagement, cleaning);

        hotelFacade.bookRoomWithService("Lux");
        System.out.println();

        hotelFacade.organizeEventWithAccommodation("Grand Hall", "Suite", 50);
        System.out.println();

        hotelFacade.bookTableWithTaxi(4);
    }
}
