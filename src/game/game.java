package game;

import java.util.LinkedList;

public class game {
    public static void main(String[] args) {
        LinkedList<trap> traps = new LinkedList<trap>();
        LinkedList<item> stuff = new LinkedList<item>();
        LinkedList<enemy> enemies = new LinkedList<enemy>();
        String[] meta = {"it is an old library with many dusty shelves" ,"there is a single lit lantern"};
        String[] meta2 = {"the locked door leads to a library" ,"it is dark and damp"};
        String[] meta3 = {"the locked door leads to a library" ,"it is well lit"};

        node library = new node(0 ,"room" ,enemies ,stuff ,traps ,"a library filled with books" ,meta);
        node emptyRoom = new node(1 ,"room" ,enemies ,stuff ,traps ,"just an empty room" ,meta2);
        node treasureRoom = new node(2 ,"room" ,enemies ,stuff ,traps ,"a room with treasure in" ,meta3);
        emptyRoom.addConnection(new door("library door" ,0 ,library ,0));
        library.addConnection(new door("entrance door" ,-1 ,emptyRoom ,4));
        library.addConnection(new door("exit door" ,1 ,emptyRoom ,2));
        treasureRoom.addConnection(new door("library door" ,0 ,emptyRoom ,6));
        key libraryKey = new key(0 ,true ,"an old cast iron key");
        key treasureKey = new key(1 ,true ,"an old cast iron key");


        System.out.println(emptyRoom.Description());
        System.out.println(library.Description());
        System.out.println(treasureRoom.Description());
        System.out.println();
    }
}
