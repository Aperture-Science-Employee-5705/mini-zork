package game;

import java.util.LinkedList;

public class player {
    private String name;
    private int hp;
    private int maxHealth;
    private int baseDmg;
    public LinkedList<item> inventory = new LinkedList<item>();
    private node location;

    public player(String name ,int maxhp ,int baseDmg ,node location){
        this.name = name;
        this.maxHealth = maxhp;
        this.hp = maxhp;
        this.baseDmg = baseDmg;
        this.location = location;
    }
    public void addToInventory(item item) {
        this.inventory.add(item);
    }
    public node getLocation() {
        return this.location;
    }
    public void setLocation(node Node) {
        this.location = Node;
    }
    public String name() {
        return this.name;
    }
    public item getItemByName(String name) {
        item out = new item("placeholder" ,"" ,"" ,0 ,0);
        for (item i : this.inventory) {
            if (i.name().equals(name)) {
                out = i;
                break;
            }
        }
        return out;
    }
    public void removeItemByName(String name) {
        int counter = 0;
        for (item i : this.inventory) {
            if (i.name().equals(name)) {
                this.inventory.remove(counter);
                return;
            }
            counter ++;
        }
    }
    public void setHp(int val) {
        this.hp = val;
        if (this.hp > this.maxHealth) {
            this.hp = this.maxHealth;
        }
    }
    public int getHp() {
        return this.hp;
    }
    public void incHp(int val) {
        this.hp += val;
        if (this.hp > this.maxHealth) {
            this.hp = this.maxHealth;
        }
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
    public void incMaxHealth(int val) {
        this.maxHealth += val;
    }
}
