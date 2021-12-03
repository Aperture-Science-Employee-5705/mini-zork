package game;

public class item {
    private String type;
    private String name;
    private String description;
    private int id;

    public item(String type ,String name ,String description ,int id) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.id = id;
    }
    public String Description() {
        return this.description;
    }
}
