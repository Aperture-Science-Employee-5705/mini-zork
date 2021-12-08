package game;

import java.util.LinkedList;
import java.util.Random;

public class enemy {
    public String name;
    public String description;
    private int damage;
    public int health;
    private String bribe;
    private LinkedList<item> inventory = new LinkedList<item>();

    public enemy(String name ,String description ,int dmg ,int hp ,String bribe) {
        this.name = name;
        this.description = description;
        this.damage = dmg;
        this.bribe = bribe;
    }
    public String Description() {
        return this.description;
    }
    public void addToInventory(item item) {
        this.inventory.add(item);
    }
    public void addToInventory(key key) {
        this.inventory.add(key);
    }
    public LinkedList<item> dropItems() {
        return this.inventory;
    }
    public String getName() {
        return this.name;
    }
}
