package game;

public class item {
    public String type;
    public String name;
    public String description;
    public int dmg;
    public int amnt;

    public item(String type ,String name ,String description ,int dmg ,int amnt) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.dmg = dmg;
        this.amnt = amnt;
    }
    public String Description() {
        return this.description;
    }
    public String name() {
        if (this.amnt > 1) {
            return this.name + " (x" + String.valueOf(this.amnt) + ")";
        } else {
            return this.name;
        }
    }
}
