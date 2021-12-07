package game;

import java.util.Random;

public class key extends item{
    private int id;
    private String name;
    private String description;
    public int uses;

    public key(int id ,String name ,String description ,int uses) {
        super("key" ,name ,description ,1 ,1);
        this.uses = uses;
    }
    public String Description() {
        return this.description;
    }
    public int id(){
        return this.id;
    }
}
