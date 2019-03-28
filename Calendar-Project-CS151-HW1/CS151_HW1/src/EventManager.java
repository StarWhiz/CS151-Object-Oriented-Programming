import java.util.ArrayList;

public class EventManager {
    
    public static ArrayList<Event> events;
    
    public EventManager(){
        ArrayList<Event> theEvents = new ArrayList<>();
        events = theEvents;
    }

    /**
     *This function adds events to the ArrayList
     * @param e the Event to be added
     */
    public static void addNewEvent(String eventName, String strDate, int timeStart, int timeEnd){

        Event newEvent = new Event(eventName, strDate, timeStart, timeEnd);
        events.add(newEvent);
    }
}
