package game;

public class item {
    private String type;
    private String description;

    public item(String type ,String description) {
        this.type = type;
        this.description = description;
    }
    public String Description() {
        return this.description;
    }
}
