package game;

public class item {
    private String type;
    private String name;
    private String description;
    private int dmg;
    private int amnt;

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
    public int amnt() {
        return this.amnt;
    }
}
