package game;

import java.util.LinkedList;

public class player {
    private String name;
    private int hp;
    private int baseDmg;
    private LinkedList<item> inventory = new LinkedList<item>();

    public player(String name ,int hp ,int baseDmg){
        this.name = name;
        this.hp = hp;
        this.baseDmg = baseDmg;
    }
    public void addToInventory(item item) {
        this.inventory.add(item);
    }
}
