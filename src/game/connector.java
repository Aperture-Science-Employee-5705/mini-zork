package game;

import java.util.Random;

public class connector {
    private int lock;
    private String name;
    private boolean locked;
    private node destination;
    private int direction;
    private String type;

    public connector(String name , int lockID , node destination , int direction ,String type) {
        this.name = name;
        this.lock = lockID;
        this.locked = !(lockID == -1);
        this.destination = destination;
        this.direction = direction;
        this.type = type;
    }
    public String unlock(key key) {
        if (this.type == "junction") {
            return "there is no door to unlock!";
        }
        if (!this.locked) {
            return "this action is pointless ,the door is already unlocked!";
        }
        if (key.id() == this.lock) {
            this.locked = false;
            return "click!\nThe " + this.name + " door unlocked!";
        } else {
            String[] failResponses = {"this is not the right key!" ,"try as you might ,the key doesnt turn" ,"this key does not unlock this door!" ,"you try to unlock it ,but unfortunately this is not the right key for this lock!" ,"this key is for another lock!" ,"it seems that its the wrong key!" ,"thats not the right key!" ,"this key doesnt work!" ,"the lock refuses to turn. try a different key!"};
            Random rand = new Random();
            int i = rand.nextInt(failResponses.length);
            return failResponses[i];
        }
    }
    public String[] getData() {
        String[] directions = {"north" ,"north-east" ,"east" ,"south-east" ,"south" ,"south-west" ,"west" ,"north-west"};
        String Locked = "";
        if (this.locked) {
            Locked = "locked";
        } else {
            Locked = "unlocked";
        }
        String[] dat = {this.name ,Locked ,directions[this.direction]};
        return dat;
    }
    public String type() {
        return this.type;
    }
    public node destination() {
        return this.destination;
    }
}
