package game;

import java.util.LinkedList;

public class map {
    public player player;
    public LinkedList<node> nodes = new LinkedList<node>();

    public void addPlayer(player player) {
        this.player = player;
    }
    public void addNode(node node) {
        this.nodes.add(node);
    }
    public int getPlayerNodeIndex() {
        int counter = 0;
        for (node n : this.nodes) {
            if (n.name == this.player.getLocation().name) {
                return counter;
            }
            counter++;
        }
        return counter;
    }
    public int getNodeIndex(node node1) {
        int counter = 0;
        for (node n : this.nodes) {
            if (n.name.equals(node1.name)) {
                break;
            }
        }
        return counter;
    }
}
