package game;

import java.util.LinkedList;

public class container extends item{
    private LinkedList<item> items;
    private String name;
    private String description;
    private boolean heavy;

    public container(String name , String description , LinkedList<item> items ,boolean heavy) {
        super("container" ,name ,description ,(heavy ? 25 : 2) ,1);
        this.items = items;
    }
    public String Description() {
        return this.description;
    }
    public LinkedList<item> getItems(){
        return this.items;
    }
}
