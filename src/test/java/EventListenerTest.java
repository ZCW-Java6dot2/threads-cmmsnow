import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class EventListenerTest extends Thread {

    @Test
    public void readToQuit() {
        TrackerMock tracker = new TrackerMock();
        EventListener el = new EventListener("test", "reply", tracker);

        Assert.assertTrue(el.readyToQuit());
    }

    @Test
    public void shouldReply() {
        TrackerMock tracker = new TrackerMock();
        EventListener el = new EventListener("test", "reply", tracker);

        Assert.assertTrue(el.shouldReply());
    }

    @Test
    public void reply() {
        TrackerMock tracker = new TrackerMock();
        EventListener el = new EventListener("test", "reply", tracker);

        el.reply();

        Assert.assertTrue(tracker.eventWasHandled);
    }

    class TrackerMock implements Tracker {

        public boolean itemWasPushed;
        public boolean eventWasHandled;

        public Map<String, Integer> tracker() {
            //return EvenTracker HashMap?
            return null;
        }

        @Override
        public void push(String message) {
            //add message to EventTracker Hashmap as key, return true;
            //(if already in hashmap, increment counter value)
            itemWasPushed = true;
        }

        @Override
        public Boolean has(String message) {
            //if message is a Key in hashmap, return true;
            return true;
        }

        @Override
        public void handle(String message, EventHandler e) {
            eventWasHandled = true;
        }
    }
}