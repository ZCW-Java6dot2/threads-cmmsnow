public class EventListener extends Thread {

    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = EventTracker.getInstance();
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    public void run() {
        while (!readyToQuit()) {
            if (shouldReply()){
                eventTracker.handle(messageToReplyWith, );  //pass in instance of event handler
                //the Handler should print out the reply
            }
        }
    }

    public Boolean readyToQuit() { // return true if there is a "quit" event in the event tracker
        if (eventTracker.)
        return false;
    }

    public Boolean shouldReply() { // return true if the event tracker has a message the listener is listening for
        if (messageToListenFor == "test"){
            return true;
        }
        return false;
    }

    public void reply() {
        System.out.println(messageToReplyWith);
    }
}