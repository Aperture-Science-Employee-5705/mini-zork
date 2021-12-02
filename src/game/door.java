package game;

import java.util.Random;

public class door {
    private int lock;
    private String name;
    private boolean locked;
    private node destination;
    private int direction;

    public door(String name ,int lockID ,node destination ,int direction) {
        this.name = name;
        this.lock = lockID;
        this.locked = !(lockID == -1);
        this.destination = destination;
        this.direction = direction;
    }
    public String unlock(key key) {
        if (!this.locked) {
            return "this action is pointless ,the door is already unlocked!";
        }
        if (key.id() == this.lock) {
            this.locked = false;
            return "click!\nThe " + this.name + " unlocked!";
        } else {
            String[] failResponses = {"try as you might ,the key doesnt turn" ,"this key does not unlock this door!" ,"you try to unlock it ,but unfortunately this is not the right key for this lock!"};
            Random rand = new Random();
            int i = rand.nextInt(failResponses.length);
            return failResponses[i];
        }
    }
}
