import java.util.*;

class KEvent {

    private List<KeyListener> listeners = new ArrayList<KeyListener>();

    public void addListener(KeyListener key) {
        listeners.add(key);
    }

    public void playEvent(String event) {
        System.out.println("Searching for the process with id = " + event);

        // Notify everybody that may be interested.
        for (KeyListener hl : listeners)
        {
            boolean v = hl.keyPressed(event);
            
            if(v)
                return;
            
            
        }

        System.out.println("ID wasn't found");

        
    }
}