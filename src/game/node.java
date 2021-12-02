package game;

import java.io.*;
import java.util.*;

public class node {
    private LinkedList<door> connections = new LinkedList<door>();
    private LinkedList<enemy> enemies;
    private LinkedList<item> items;
    private LinkedList<trap> traps;
    private String description;
    private String[] metadata;
    private int id;
    private String type;

    public node(int id ,String type ,LinkedList<enemy> enemies ,LinkedList<item> stuff ,LinkedList<trap> traps ,String description ,String[] metadata) {

        this.enemies = enemies;
        this.items = stuff;
        this.traps = traps;
        this.description = description;
        this.metadata = metadata;
        this.id = id;
        this.type = type;
    }
    public void addConnection(door connection) {
        this.connections.add(connection);
    }
    public int id() {
        return this.id;
    }
    public String Description() {
        Random rand = new Random();
        int i = rand.nextInt(this.metadata.length);
        String doorM = "";
        if (this.connections.size() == 1) {
            doorM = "there is 1 door attached.";
        } else {
            doorM = "there are " + String.valueOf(this.connections.size()) + " doors attached.";
        }
        return this.description + "\n" + doorM + "\n" + this.metadata[i] + "\n\n";
    }
}
