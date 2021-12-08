package game;

import java.util.LinkedList;

public class player {
    private String name;
    private int hp;
    private int maxHealth;
    private int baseDmg;
    private LinkedList<item> inventory = new LinkedList<item>();
    private node location;

    public player(String name ,int maxhp ,int baseDmg ,node location){
        this.name = name;
        this.maxHealth = maxhp;
        this.hp = maxhp;
        this.baseDmg = baseDmg;
        this.location = location;
    }
    /*public void removeDuplicates() {
        int counter = 0;
        int counter2;
        System.out.println("removing dupes...");
        for (item i : this.inventory) {
            System.out.print(i.name + " ");
            counter2 = 0;
            for (item i2 : this.inventory) {
                System.out.println(i2.name);
                if (counter2 == counter) {
                    counter++;
                    continue;
                }
                if (i2.name.equals(i.name)) {
                    System.out.println(counter + " " + this.inventory.size() + " " + counter2);
                    this.inventory.get(counter).amnt += i2.amnt;
                    this.inventory.remove(counter2);
                    counter2 -= 1;
                }
                counter++;
            }
            counter++;
        }
    }*/
    public LinkedList<item> getInventory() {
        return this.inventory;
    }
    public void addToInventory(item item) {
        //this.removeDuplicates();
        this.inventory.add(item);
    }
    public void removeFromInventory(int index) {
        this.inventory.remove(index);
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
        //this.removeDuplicates();
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
        //this.removeDuplicates();
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
