package game;

import java.util.Random;

public class key{
    private int id;
    private boolean active;
    private String description;

    public key(int id ,boolean active ,String description) {
        this.id = id;
        this.active = active;
        this.description = description;
    }
    public boolean isActive() {
        return this.active;
    }
    public String Description() {
        return this.description;
    }
    public int id(){
        return this.id;
    }
}
