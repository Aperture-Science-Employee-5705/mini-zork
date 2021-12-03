package game;

import java.util.Random;

public class key extends item{
    private int id;
    private String name;
    private String description;

    public key(int id ,String name ,String description) {
        super("key" ,name ,description ,id);
    }
    public String Description() {
        return this.description;
    }
    public int id(){
        return this.id;
    }
}
