package game;

import java.util.*;

public class node {
    private LinkedList<connector> connections = new LinkedList<connector>();
    private LinkedList<enemy> enemies;
    private LinkedList<item> items;
    private LinkedList<trap> traps;
    private String description;
    private String[] metadata;
    private int id;
    private String name;
    private String type;

    public node(int id ,String name ,String type ,String description ,String[] metadata) {
        this.enemies = new LinkedList<enemy>();
        this.items = new LinkedList<item>();
        this.traps = new LinkedList<trap>();
        this.description = description;
        this.metadata = metadata;
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public void addConnection(connector connection) {
        this.connections.add(connection);
    }
    public void addEnemy(enemy enemy) {
        this.enemies.add(enemy);
    }
    public void addItem(item item) {
        this.items.add(item);
    }
    public void addTrap(trap trap) {
        this.traps.add(trap);
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
        return this.description + "\n" + this.metadata[i] + "\n" + this.getConnectors() + "\n\n";
    }
    public String getConnectors() {
        String str = "";
        if (this.connections.size() == 1) {
            str = "there is 1 door attached to the " + this.name + " : \n\n";
        } else {
            str = "there are " + String.valueOf(this.connections.size()) + " doors attached to the " + this.name + " : \n\n";
        }
        for (connector d : this.connections) {
            str += d.getData()[0] + " (" + d.getData()[1] + ")\n";
        }
        return str;
    }
    public String unlockConnector(int num ,key Key) {
        return this.connections.get(num).unlock(Key);
    }
}
