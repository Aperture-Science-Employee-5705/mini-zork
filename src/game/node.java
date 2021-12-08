package game;

import sun.awt.image.ImageWatched;

import java.util.*;

public class node {
    public LinkedList<connector> connections = new LinkedList<connector>();
    public LinkedList<enemy> enemies;
    public LinkedList<item> items;
    public LinkedList<item> originalItems;
    public LinkedList<trap> traps;
    public String description;
    public String[] metadata;
    public int id;
    public String name;
    public String type;

    public node(int id ,String name ,String type ,String description ,String[] metadata) {
        this.enemies = new LinkedList<enemy>();
        this.items = new LinkedList<item>();
        this.originalItems = new LinkedList<item>();
        this.traps = new LinkedList<trap>();
        this.description = description;
        this.metadata = metadata;
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public String name() {
        return this.name;
    }
    public void addConnection(connector connection) {
        this.connections.add(connection);
    }
    public void addEnemy(enemy enemy) {
        this.enemies.add(enemy);
    }
    public void giveEnemyItem(String name ,item item) {
        for (enemy e : this.enemies) {
            if (e.getName() == name) {
                e.addToInventory(item);
            }
        }
    }
    public void giveEnemyItem(String name ,key key) {
        for (enemy e : this.enemies) {
            if (e.getName() == name) {
                e.addToInventory(key);
            }
        }
    }
    public void addItem(item item) {
        this.items.add(item);
        this.originalItems.add(item);
        //this.combineDuplicates();
    }
    public float removedAmount() {
        int Ctalley = 0;
        int Otalley = 0;
        for (item i : this.items) {
            Ctalley += i.amnt;
        }
        for (item i : this.originalItems) {
            Otalley += i.amnt;
        }
        return (Ctalley/Otalley)*100;
    }
    public void addTrap(trap trap) {
        this.traps.add(trap);
    }
    public int id() {
        return this.id;
    }
    public String Description() {
        String enemydat = "enemies in the room : \n";
        if (this.enemies.size() > 0) {
            for (enemy e : this.enemies) {
                enemydat += e.getName() + "\n" + e.Description()[0] + "\n";
            }
        } else {
            enemydat = "there are no enemies in the room!";
        }
        if (this.metadata.length > 0) {
            Random rand = new Random();
            int i = rand.nextInt(this.metadata.length);
            return this.description + "\n" + this.metadata[i] + "\n" + this.getConnectors() + "\n" + enemydat;
        } else {
            return this.description + "\n" + this.getConnectors() + "\n" + enemydat;
        }
    }
    public String getConnectors() {
        String str = "";
        if (this.connections.size() == 1) {
            str = "there is 1 door attached to " + this.name + " : \n";
        } else {
            str = "there are " + String.valueOf(this.connections.size()) + " doors attached to " + this.name + " : \n";
        }
        for (connector d : this.connections) {
            str += d.getData()[0] + " (" + d.getData()[1] + ")\n";
        }
        return str;
    }
    public LinkedList<connector> getConnections() {
        return this.connections;
    }
    public LinkedList<trap> getTraps() {
        return this.traps;
    }
    public String unlockConnector(int num ,key Key) {
        return this.connections.get(num).unlock(Key);
    }
    public LinkedList<enemy> getEnemies() {
        return this.enemies;
    }
    public String[] getItems() {
        LinkedList<String> out = new LinkedList<String>();
        for (item i : this.items) {
            out.add(i.name());
        }
        String os = out.toString();
        return os.substring(1 ,(os.length()-1)).split(", ");
    }
    public item getItemByName(String name) {
        //this.combineDuplicates();
        item out = new item("placeholder" ,"" ,"" ,0 ,0);
        for (item i : this.items) {
            if (i.name().equals(name)) {
                out = i;
                break;
            }
        }
        return out;
    }
    public container getContainerByName(String name) {
        //this.combineDuplicates();
        container out = new container("placeholder" ,"" ,new LinkedList<item>() ,false);
        for (item i : this.items) {
            if (i.name().equals(name) && i.type.equals("container")) {
                out = (container) i;
                break;
            }
        }
        return out;
    }
    /*
    public void combineDuplicates() {
        int count;
        for (item i : this.items) {
            count = -1;
            for (item i2 : this.items) {
                if (i2.name().equals(i.name())) {
                    count++;
                }
                if (count > 0) {
                    //code
                }
            }
        }
    }
     */
    public int getItemCount() {
        int count = 0;
        for (item i : this.items) {
            count += i.amnt;
        }
        return count;
    }
}
