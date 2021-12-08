package game;

import java.util.LinkedList;
import java.util.Random;

public class enemy {
    public String name;
    public String[] descriptions;//description of enemy ,enemy attack line
    public int damage;
    public int health;
    private String bribe;
    private LinkedList<item> inventory = new LinkedList<item>();

    public enemy(String name ,String[] descriptions ,int dmg ,int hp ,String bribe) {
        this.name = name;
        this.health = hp;
        this.descriptions = new String[] {descriptions[0] ,descriptions[1] + " dealing " + dmg + " damage."};
        this.damage = dmg;
        this.bribe = bribe;
    }
    public String[] Description() {
        return this.descriptions;
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
