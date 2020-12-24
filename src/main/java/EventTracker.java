import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        return INSTANCE;
    }

    public Map<String, Integer> getTracker() { return tracker; }

    synchronized public void push(String message) {
        Integer value = tracker.get(message);
        value++;
        tracker.put(message, value);
    }

    synchronized public Boolean has(String message) {
        for (String k : tracker.keySet()){
            if (k.equals(message)){
                Integer value = tracker.get(message);
                if (value != null && value > 0) return true;
            }
        }
        return false;
    }

    synchronized public void handle(String message, EventHandler e) {
        // run the event handler's handle function (??)

        Integer value = tracker.get(message);
        value--;    // decrement the integer associated with the message passed in
        tracker.put(message, value);
    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }
}
