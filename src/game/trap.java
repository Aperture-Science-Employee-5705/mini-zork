package game;

public class trap {
    private String name;
    private String[] descriptions;//4 descriptions : upon activation ,during active ,upon disarm ,upon death
    private int damage;
    private int turns;
    private String activationM;
    private item deactivationM;
    private boolean lockD;
    
    public trap(String name ,String descriptions ,String activation ,int dmg ,int turns ,item deactivation ,boolean lockD) {
        this.name = name;
        this.descriptions = descriptions.split(";");
        this.activationM = activation;
        this.damage = dmg;
        this.turns = turns;
        this.deactivationM = deactivation;
        this.lockD = lockD;
    }
    public String getName() {
        return this.name;
    }
    public String[] getDescriptions() {
        return this.descriptions;
    }
    public int getDamage() {
        return this.damage;
    }
    public int getTurns() {
        return this.turns;
    }
    public String getActivationM() {
        return this.activationM;
    }
    public item getDeactivationM() {
        return this.deactivationM;
    }
    public boolean getLockD() {
        return lockD;
    }
}
