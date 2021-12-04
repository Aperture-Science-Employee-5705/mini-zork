package game;

public class trap {
    private String name;
    private String[] descriptions;//4 descriptions : upon activation ,during active ,upon disarm ,upon death
    private int damage;
    private int turns;
    private String activationM;
    private item deactivationM;
    
    public trap(String name ,String descriptions ,String activation ,int dmg ,int turns ,item deactivation) {
        this.name = name;
        this.descriptions = descriptions.split(";");
        this.activationM = activation;
        this.damage = dmg;
        this.turns = turns;
        this.deactivationM = deactivation;
    }
    public getData() {
        return this.name ,this.descriptions ,this.activationM ,this.damage ,this.turns ,this.deactivationM;
}
