package game;

public class trap {
    private String name;
    private String[] descriptions;//4 descriptions : upon activation (1st chance) ,during active (2nd chance --> nth chance with n being the number of turns allowed to deactivate it) ,upon death ,upon disarm
    private int damage;
    public int turns;
    private String activationM;
    private item deactivationM;
    public boolean lockD;
    public int active;
    
    public trap(String name ,String[] descriptions ,String activation ,int dmg ,int turns ,item deactivation ,boolean lockD) {
        this.name = name;
        this.descriptions = descriptions;
        this.activationM = activation;
        this.damage = dmg;
        this.turns = turns;
        this.deactivationM = deactivation;
        this.lockD = lockD;
        this.active = 0;//0 - not yet activated ,1 - active ,2 - deactivated
    }
    public String deactivate(item i) {
        if (i.name.equals(this.deactivationM.name)) {
            return this.descriptions[3];
        }
        return "that didnt work!\n" + this.descriptions[1];
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
    public String[] getData() {
        String[] dat = {this.name ,String.valueOf(this.turns) ,(this.lockD ? "lock" : "dont lock")};
        return dat;
    }
}
