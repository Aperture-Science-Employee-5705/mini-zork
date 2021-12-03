package game;

import java.util.LinkedList;
import java.util.Random;

public class enemy {
    private String name;
    private String description;
    private int damage;
    private int health;
    private String bribe;
    private LinkedList<item> inventory = new LinkedList<item>();

    public enemy(String name ,String description ,int dmg ,int hp ,String bribe) {

    }
    public String Description() {
        return this.description;
    }
    public void addToInventory(item item) {
        this.inventory.add(item);
    }
    public void addToInventory(key key) {
        this.inventory.add(key);//TODO make this work
    }
    public LinkedList<item> dropItems() {
        return this.inventory;
    }
    public String getName() {
        return this.name;
    }
}
