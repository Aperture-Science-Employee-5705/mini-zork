package game;

import javax.swing.*;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        //build map (i know its tedious doing the game this way ,but it'd be way more hellish if it was all if statements)
        //make the rooms and junctions first
        node startingRoom = new node(0 ,"starting room" ,"room" ,"This room is the start of the game!" ,new String[] {});

        node room1 = new node(1 ,"room 1" ,"room" ,"" ,new String[] {});
        node room2 = new node(2 ,"room 2" ,"room" ,"" ,new String[] {});
        node room3 = new node(3 ,"room 3" ,"room" ,"" ,new String[] {});
        node room4 = new node(4 ,"room 4" ,"room" ,"" ,new String[] {});
        node room5 = new node(5 ,"room 5" ,"room" ,"" ,new String[] {});
        node room6 = new node(6 ,"room 6" ,"room" ,"" ,new String[] {});
        node room7 = new node(7 ,"room 7" ,"room" ,"" ,new String[] {});
        node room8 = new node(8 ,"room 8" ,"room" ,"" ,new String[] {});
        node library = new node(9 ,"library" ,"room" ,"" ,new String[] {});
        node treasureRoom = new node(10 ,"treasure room" ,"room" ,"" ,new String[] {});
        node trapRoom = new node(11 ,"trap room" ,"room" ,"" ,new String[] {});
        node battleHall = new node(12 ,"final boss room" ,"room" ,"A large ,rectangular stone hall with pillars running down the length of it on both sides.\nAt the end of the room sits the final boss on his throne with a door either side of him ,one is marked \"TREASURE\" ,the other \"EXIT\"\n\nsuddenly you hear a \"click!\" as the door you just came through locks behind you." ,new String[] {});
        node jackpotRoom = new node(13 ,"treasure room 2" ,"room" ,"" ,new String[] {});

        node finalRoom = new node(14 ,"The final room in the game and the exit to the dungeon." ,"room" ,"" ,new String[] {});

        node junction0 = new node(15 ,"junction" ,"junction" ,"" ,new String[] {});
        node junction1 = new node(16 ,"junction" ,"junction" ,"" ,new String[] {});
        node junction2 = new node(17 ,"junction" ,"junction" ,"" ,new String[] {});
        node junction3 = new node(18 ,"junction" ,"junction" ,"" ,new String[] {});
        node junction4 = new node(19 ,"junction" ,"junction" ,"" ,new String[] {});



        //connect up the rooms

        //starting room
        //temporary note : http://www.castlewales.com/casterms.html
        startingRoom.addConnection(new connector("junction 0" ,-1 ,junction0 ,7 ,"junction"));
        startingRoom.addConnection(new connector("room 1" ,-1 ,room1 ,1 ,"room"));

        //room 1
        room1.addConnection(new connector("room 2" ,-1 ,room2 ,7 ,"room"));
        room1.addConnection(new connector("room 4" ,-1 ,room4 ,0 ,"room"));
        room1.addConnection(new connector("starting room" ,-1 ,startingRoom ,4 ,"room"));
        room1.addConnection(new connector("junction 1" ,0 ,junction1 ,1 ,"junction"));

        //room2
        room2.addConnection(new connector("junction 0",-1 , junction0,6 ,"junction"));
        room2.addConnection(new connector("room 1",-1 , room1,3 ,"room"));
        room2.addConnection(new connector("room 5",-1 , room5,7 ,"room"));

        //room 3
        room3.addConnection(new connector("room 5" ,-1 , room5,3 ,"room"));
        room3.addConnection(new connector("room 6" ,-1 , room6, 1,"room"));

        //room 4
        room4.addConnection(new connector("junction 2" ,-1 ,junction2 ,7 ,"junction"));
        room4.addConnection(new connector("room 1" ,-1 ,room1 ,4 ,"room"));
        room4.addConnection(new connector("library corridoor A" ,-1 ,junction3 ,1 ,"junction"));

        //room 5
        room5.addConnection(new connector("room 2" ,-1 ,room2 ,4 ,"room"));
        room5.addConnection(new connector("room 3" ,-1 ,room3 ,7 ,"room"));
        room5.addConnection(new connector("junction 2" ,-1 ,junction2 ,2 ,"junction"));

        //room 6
        room6.addConnection(new connector("room 3" ,-1 ,room3 ,5 ,"room"));
        room6.addConnection(new connector("library corridoor B" ,-1 ,junction4 ,3 ,"junction"));

        //room 7
        room7.addConnection(new connector("junction 1" ,-1 ,junction1 ,4 ,"junction"));
        room7.addConnection(new connector("library corridoor A" ,-1 ,junction3 ,7 ,"junction"));
        room7.addConnection(new connector("library" ,-1 ,library ,1 ,"room"));
        room7.addConnection(new connector("treasure room A" ,-1 ,treasureRoom ,3 ,"room"));

        //room 8
        room8.addConnection(new connector("library corridoor B" ,-1 ,junction4 ,7 ,"junction"));
        room8.addConnection(new connector("junction 2" ,-1 ,junction2 ,5 ,"junction"));
        room8.addConnection(new connector("library cooridoor A" ,-1 ,junction3 ,3 ,"junction"));


        //library
        library.addConnection(new connector("library cooridoor A" ,-1 ,junction3 ,4 ,"junction"));
        library.addConnection(new connector("room 7" ,0 ,room7 ,3 ,"room"));
        library.addConnection(new connector("library cooridoor B" ,-1 ,junction4 ,6 ,"junction"));

        //treasure room (connected to room 7)
        treasureRoom.addConnection(new connector("room 7" ,-1 ,room7 ,7 ,"room"));

        //trap room
        trapRoom.addConnection(new connector("regal hall" ,1 ,battleHall ,2 ,"room"));
        trapRoom.addConnection(new connector("dungeon" ,-1 ,junction1 ,6 ,"room"));

        //battle hall (site of final boss battle ,accessable via boss key ,door locks behind you)
        battleHall.addConnection(new connector("Battle hall entrance/exit" ,1650551649 ,trapRoom ,7 ,"room"));
        battleHall.addConnection(new connector("Treasure room door" ,-1 ,jackpotRoom ,1 ,"room"));
        battleHall.addConnection(new connector("Dungeon exit door" ,4542020 ,finalRoom ,5 ,"room"));

        //jackpot room
        jackpotRoom.addConnection(new connector("treasure room B" ,-1 ,battleHall ,5 ,"room"));

        //final room
        finalRoom.addConnection(new connector("Dungeon exit staircase" ,1234567890 ,battleHall ,1 ,"room"));

        //junction 0
        junction0.addConnection(new connector("Starting room" ,-1 ,startingRoom ,3 ,"room"));
        junction0.addConnection(new connector("room 2" ,-1 ,room2 ,2 ,"room"));
        junction0.addConnection(new connector("room 3" ,-1 ,room3 ,0 ,"room"));

        //junction 1
        junction1.addConnection(new connector("room 1" ,-1 ,room1 ,5 ,"room"));
        junction1.addConnection(new connector("regal hall" ,1 ,trapRoom ,3 ,"room"));
        junction1.addConnection(new connector("room 7" ,-1 ,room7 ,1 ,"room"));

        //junction 2
        junction2.addConnection(new connector("room 5" ,-1 ,room5 ,6 ,"room"));
        junction2.addConnection(new connector("room 8" ,-1 ,room8 ,2 ,"room"));
        junction2.addConnection(new connector("room 4" ,-1 ,room4 ,3 ,"room"));

        //junction 3
        junction3.addConnection(new connector("room 8" ,-1 ,room8 ,7 ,"room"));
        junction3.addConnection(new connector("room 4" ,-1 ,room4 ,5 ,"room"));
        junction3.addConnection(new connector("room 7" ,0 ,room7 ,3 ,"room"));
        junction3.addConnection(new connector("library" ,-1 ,library ,1 ,"room"));

        //junction 4
        junction4.addConnection(new connector("room 6" ,-1 ,room6 ,6 ,"room"));
        junction4.addConnection(new connector("room 8" ,-1 ,room8 ,4 ,"room"));
        junction4.addConnection(new connector("library door" ,-1 ,library ,2 ,"room"));



        //now its time to populate the map with monsters

        room1.addEnemy(new enemy("Zombie" ,"" ,1 ,10 ,""));
        room2.addEnemy(new enemy("Skeleton" ,"" ,3 ,7 ,""));
        room5.addEnemy(new enemy("Orc" ,"" ,4 ,11 ,""));
        junction3.addEnemy(new enemy("Gruu" ,"" ,10 ,15 ,""));
        library.addEnemy(new enemy("Phantom librarian" ,"" ,15 ,16 ,""));

        room4.addEnemy(new enemy("Soldat" ,"" ,20 ,30 ,"metal part"));
        room4.giveEnemyItem("Soldat" ,new key(8 , "trap key","An old ,grey ,chipped metal key. It is a little heavy and has the word \"TRAP\" engraved on it." ,1));
        //an important enemy ^

        room7.addEnemy(new enemy("Moulded" ,"" ,11 ,25 ,""));
        room8.addEnemy(new enemy("Lycan" ,"" ,12 ,27 ,""));
        treasureRoom.addEnemy(new enemy("The grey guardian" ,"" ,18 ,42 ,""));

        battleHall.addEnemy(new enemy("Visrex the Indestructible" ,"" ,25 ,75 ,"Your soul"));



        //now to add a few traps
        junction2.addTrap(new trap("moving sawblade trap" ,new String[] {"As you walk into the corridoor ,you nearly trip over something. Suddenly a loud whirring nois starts up and you hear multiple clicks as all the doors attached to the corridoor lock.\nIn the dim light you can just about make out several spinning ,razor-sharp sawblades pop out of the wall and begin racing down the corridoor on a loop that will eventually catch you!\nFrantically looking around in terror ,you spot a hole in the wall ,behind which an active mechanism can be seen." ,"The sawblades make it to the other end of the corridoor and loop around ,now coming in your direction." ,"Its too late ,you barely turn all the way around before the blades catch up with and kill you." ,"You ram the metal part into the mechanism as hard as you can. Suddenly ,the gears make a loud crunching sound and the blades come to an abrupt stop."} ,"enter_room" ,30 ,2 ,new item("item" ,"metal part" ,"a shiny metal part from something mechanical" ,6 ,1) ,false));
        jackpotRoom.addTrap(new trap("poison gas trap" ,new String[] {""} ,"took_too_much;dosh" ,-1 ,0 ,new item("placeholder" ,"" ,"" ,0 ,0) ,true));//activation method : take too much treasure ,trap type : poison gas & room lock (lethal) ,disarm method : none
        //^ if you are too greedy
        trapRoom.addTrap(new trap("crushing ceiling trap" ,new String[] {""} ,"enter_room" ,100 ,3 ,new key(8 , "trap key","An old ,grey ,chipped metal key. It is a little heavy and has the word \"TRAP\" engraved on it." ,1) ,true));//activation method : enter room ,trap type : crushing ceiling ,disarm method : trap key (obtainable by giving the soldat the metal part)



        //now to add the items
        junction0.addItem(new item("item" ,"small dagger" ,"" ,5 ,1));
        room1.addItem(new item("item" ,"" ,"" ,0 ,1));
        room1.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,10));
        room1.addItem(new item("dosh" ,"fabrige egg" ,"" ,1 ,2));
        room2.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,10));
        room3.addItem(new item("Hitem" ,"old bandage" ,"" ,-10 ,1));
        room5.addItem(new item("Hitem" ,"bandage" ,"" ,-15 ,2));
        room6.addItem(new item("item" ,"metal part" ,"A shiny metal part from something mechanical" ,6 ,2));
        room7.addItem(new item("item" ,"baseball bat" ,"" ,12 ,1));
        junction2.addItem(new item("item" ,"glass bottle" ,"" ,8 ,2));
        junction4.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,12));
        junction1.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,21));
        junction3.addItem(new item("dosh" ,"silver candle stick" ,"" ,0 ,2));
        junction3.addItem(new item("dosh" ,"antique gold pocketwatch" ,"" ,0 ,5));
        room3.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,2));
        room5.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,30));
        room8.addItem(new item("item" ,"kitchen knife" ,"" ,18 ,1));

        //basically the library has three bookshelves ,each with 35 books
        //and a book on bookshelf 3 has the green key inside it
        //the library also has alot of other stuff
        item book = new item("item" ,"book" ,"" ,2 ,35);
        LinkedList<item> items = new LinkedList<item>();
        items.add(book);

        library.addItem(new container("bookshelf 1" ,"" ,items ,true));
        library.addItem(new container("bookshelf 2" ,"" ,items , true));//adding two bookshelves
        book = new item("item" ,"book" ,"" ,2 ,34);
        items = new LinkedList<item>();
        items.add(book);
        LinkedList<item> bookKey = new LinkedList<item>();
        bookKey.add(new key(0 ,"green key" ,"A small ,rusty cast iron key with a green tag attached" ,3));
        item smallBook = new container("small black book" ,"" ,bookKey ,false);
        items.add(smallBook);//adding special bookshelf with a book with a key in it

        library.addItem(new container("bookshelf 3" ,"" ,items ,true));
        library.addItem(new item("item" ,"book" ,"" ,2 ,5));
        library.addItem(new item("dosh" ,"golden candlestick" ,"" ,2 ,5));
        library.addItem(new item("dosh" ,"tome of knowledge" ,"" ,5 ,1));



        treasureRoom.addItem(new key(1 ,"regal hall key" ,"A solid gold key covered in scratches with a crown emblem etched on it." ,-1));
        treasureRoom.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,250));
        treasureRoom.addItem(new item("dosh" ,"jewel encrusted chalice" ,"" ,3 ,2));
        treasureRoom.addItem(new item("dosh" ,"jeweled necklace" ,"" ,0 ,5));
        treasureRoom.addItem(new item("dosh" ,"gemstone" ,"" ,0 ,10));
        treasureRoom.addItem(new item("dosh" ,"golden sacrificial dagger" ,"" ,17 ,1));
        treasureRoom.addItem(new item("Hitem" ,"magic potion" ,"" ,-10000000 ,1));

        jackpotRoom.addItem(new item("dosh" ,"gold coin" ,"" ,0 ,250));
        jackpotRoom.addItem(new item("dosh" ,"jewel encrusted chalice" ,"" ,3 ,2));
        jackpotRoom.addItem(new item("dosh" ,"jeweled necklace" ,"" ,0 ,5));
        jackpotRoom.addItem(new item("dosh" ,"gemstone" ,"" ,0 ,10));
        jackpotRoom.addItem(new item("dosh" ,"golden sacrificial dagger" ,"" ,17 ,1));
        jackpotRoom.addItem(new item("dosh" ,"silver plate" ,"" ,0 ,4));
        jackpotRoom.addItem(new item("dosh" ,"golden ring" ,"" ,0 ,15));
        jackpotRoom.addItem(new item("dosh" ,"gold bar" ,"" ,0 ,10));
        jackpotRoom.addItem(new item("dosh" ,"platinum teapot" ,"" ,0 ,3));
        jackpotRoom.addItem(new item("dosh" ,"gandalf's flip flop" ,"" ,9 ,1));
        jackpotRoom.addItem(new item("dosh" ,"doge coin" ,"" ,0 ,10));
        jackpotRoom.addItem(new item("dosh" ,"TeM aRmuR" ,"" ,0 ,1));
        //jackpotRoom.addItem(new item("dosh" ,"big red jewel" ,"" ,0) ,1);// <- but you dont get to have that because the annoying dog took it...
        jackpotRoom.addItem(new item("dosh" ,"solid gold statue" ,"" ,25 ,1));
        jackpotRoom.addItem(new item("dosh" ,"pearl necklace" ,"" ,0 ,1));
        jackpotRoom.addItem(new item("dosh" ,"golden shield" ,"" ,1 ,1));
        jackpotRoom.addItem(new item("dosh" ,"treasure chest" ,"" ,3 ,1));
        jackpotRoom.addItem(new item("dosh" ,"silver candle stick" ,"" ,4 ,1));
        jackpotRoom.addItem(new item("dosh" ,"silver trophy" ,"" ,1 ,1));
        jackpotRoom.addItem(new item("dosh" ,"jade statuette" ,"" ,1 ,2));

        map game = new map();
        game.addNode(startingRoom);
        game.addNode(room1);
        game.addNode(room2);
        game.addNode(room3);
        game.addNode(room4);
        game.addNode(room5);
        game.addNode(room6);
        game.addNode(room7);
        game.addNode(room8);
        game.addNode(library);
        game.addNode(treasureRoom);
        game.addNode(trapRoom);
        game.addNode(battleHall);
        game.addNode(jackpotRoom);
        game.addNode(finalRoom);
        game.addNode(junction0);
        game.addNode(junction1);
        game.addNode(junction2);
        game.addNode(junction3);
        game.addNode(junction4);









        //now that we have constructed the dungeon and everything in it ,its time to start the gameplay! (finally)

        Scanner scan = new Scanner(System.in);
        System.out.print("what will your name be?\n\nname : \t");
        String name = scan.nextLine();
        player player1 = new player(name ,20 ,1 ,startingRoom);
        game.addPlayer(player1);
        System.out.println("welcome " + name + "!");
        System.out.println("\nThis game is a turn based dungeon crawler game where everthing is described with text and all actions are performed by typing in commands");
        System.out.println("Almost every action you perform takes up a turn\n\t(unless you are checking your inventory ,checking an item in your inventory ,picking up an item ,checking the items in the room or asking for help\n\tas these five commands do not take up a turn)");
        System.out.println("\nhere are the actions you can perform : \n\n\tuse <item> <thing>         : uses an item on a thing ,for instance using a key on a lock or a weapon on an enemy (if its a health item ,you dont have to specify the <thing>)\n\t\t\t                    (for items with a space in their name ,replace the spaces with an _ (\"test item\" -> \"test_item\"))\n\tmove to <room or junction> : moves the player around the map (obviously you cannot move through locked doors though)\n\tpick up <item>             : picks up an item from the room\n\tcheck <item>               : analyses an item in your inventory\n\thelp                       : asks for this menu and a help page\n\tinv                        : checks the contents of your inventory\n\tcheck items               : displays the items in the room");
        System.out.println();

        player1.addToInventory(new key(0 ,"green key" ,"A small ,chipped cast iron key with a green tag attached" ,3));


        String action;
        int counter;
        boolean printData = true;
        boolean turnTaken = false;
        boolean done = false;
        while (!done) {//game loop
            turnTaken = false;

            if (printData) {
                System.out.println("current location : [" + game.player.getLocation().name + "]\n" + game.player.getLocation().Description());
                printData = false;
            }

            System.out.print("what will you do " + game.player.name() + "? : ");
            action = scan.nextLine();
            switch (action.split(" ")[0]) {
                case "move":
                    game = moveTo(action ,game);
                    turnTaken = true;
                    printData = true;
                    break;
                case "use":
                    for (item i : game.player.inventory) {
                        if (i.name.equals(action.split(" ")[1].replace("_" ," "))) {
                            switch (i.type) {
                                case "key":
                                    game = useKey(action ,game);
                                    turnTaken = true;
                                    break;
                                case "Hitem":
                                    game = heal(action ,game);
                                    turnTaken = true;
                                    break;
                                case "dosh":
                                    System.out.println("There is no use for this item!");
                                    break;
                                default://regular item ,assume you are attacking an enemy or deactivating a trap
                                    boolean Trap = false;
                                    counter = 0;
                                    for (trap t : game.player.getLocation().traps) {
                                        if (t.getName().equals(action.split(" ")[2].replace("_" ," "))) {
                                            Trap = true;
                                            break;
                                        }
                                        counter++;
                                    }
                                    if (!Trap) {//its not a trap as no trap was found with that name ,therefore it must be an enemy
                                        counter = 0;
                                        for (enemy e : game.player.getLocation().enemies) {
                                            if (e.name.equals(action.split(" ")[2].replace("_" ," "))) {
                                                break;
                                            }
                                            counter++;
                                        }
                                        //handle enemies ,use counter as index
                                        game = attack(counter ,game ,i);
                                    } else {
                                        //handle trap deactivation attempt ,use counter as index
                                        game = deactivate(counter ,game);
                                    }
                            }
                            break;
                        }
                    }
                    break;
                case "check":
                    if (action.split(" ")[1].equals("items")) {//display the items in the room
                        for (item i : game.nodes.get(game.getPlayerNodeIndex()).items) {
                            System.out.println(i.name());
                        }
                    } else {
                        for (item i : game.player.inventory) {
                            if (i.name.equals(action.substring(6 ,action.length()))) {
                                System.out.println(i.description);


                                if (i.type == "container") {//if the item has items inside it
                                    System.out.println("it seems to have something inside it... would you like to have a look? (y/n)");
                                    if (scan.nextLine().equals("y")) {
                                        counter = 0;
                                        for (item I : ((container) i).getItems()) {
                                            game.player.inventory.add(I);
                                            ((container) i).removeItem(counter);
                                            System.out.println("inside the " + i.name + " you found a " + I.name);
                                            counter++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "inv":
                    System.out.println("inventory : \n--------------------\n");
                    for (item i : game.player.inventory){
                        System.out.println(i.name + ((i.amnt > 1) ? (" (x" + String.valueOf(i.amnt) + ")") : ""));
                    }
                    System.out.println("--------------------");
                    break;
                case "pick":
                    game = pickUp(action ,game);
                    turnTaken = false;
                    break;
                default:
                    System.out.println("unknown command!");
                    help();
            }
        }
    }/*
    TODO allow the player to engage in combat
    TODO get trap activation / deactivation working
    TODO write descriptions
    TODO flowchart
    TODO write cheatsheet
    TODO submit
    */
    public static map moveTo (String action ,map game) {
        String room = action.substring(8 ,action.length());
        for (connector c : game.player.getLocation().getConnections()) {//find connector so we can move the player
            if (c.getData()[0].equals(room)) {
                if (c.getData()[1].equals("locked")) {
                    String[] failResponses = {"the door doesnt budge ,it seems that its locked!\nperhaps you should unlock it first." ,"the door refuses to open.\nperhaps you should unlock it first." ,"the door wont open ,it seems its locked.\nmaybe it might be worth it if you found a key." ,"the door is locked.\nit might be a good idea to find a key and unlock it." ,"its locked."};
                    Random rand = new Random();
                    int i = rand.nextInt(failResponses.length);
                    System.out.println(failResponses[i]);
                } else {
                    game.player.setLocation(c.destination());
                }
            }
        }
        return game;
    }
    public static map useKey (String action ,map game) {
        String[] data = action.substring(4 ,action.length()).split(" ");//key ,room
        int counter = 0;
        int itemIndex = -1;//if this index or the other index is -1 by the end of the two loops below ,we abort the process to avoid a crash
        int connectorIndex = -1;
        key Key = new key(-1 ,"placeholder" ,"" ,0);

        for (item i : game.player.inventory) {//first we find the index of the key referenced in the command so that we can directly modify it later
            if (i.name.equals(data[0].replace("_" ," "))) {
                itemIndex = counter;
                Key = (key) i;
                break;
            }
            counter++;
        }
        counter = 0;
        for (connector c : game.nodes.get(game.getPlayerNodeIndex()).getConnections()) {//next we do the same thing to find the index of the connector
            //System.out.println(game.nodes.get(game.getPlayerNodeIndex()).name + " ; " + c.getData()[0] + " " + data[1].replace("_" ," "));
            if (c.getData()[0].equals(data[1].replace("_" ," "))) {
                connectorIndex = counter;
                break;
            }
            counter++;
        }
        if ((itemIndex == -1) || (connectorIndex == -1)) {
            System.out.println(itemIndex + " " + connectorIndex);
            return game;//abort to avoid errors
        }
        //now if both searches havent failed ,we can move on to attempting to unlock the door
        //also i never expected the line below to be so long lol
        String out = game.nodes.get(game.getPlayerNodeIndex()).getConnections().get(connectorIndex).unlock(Key);
        System.out.println(out);
        ((key) game.player.inventory.get(itemIndex)).uses -= 1;
        if (((key) game.player.inventory.get(itemIndex)).uses == 0) {
            System.out.println("Snap! The key breaks in your hand as it unlocks the door!");
            game.player.inventory.remove(itemIndex);//if the key runs out of uses ,delete it
        }
        return game;
    }
    public static map heal (String action ,map game) {
        int counter = 0;
        for (item i : game.player.inventory) {
            if (i.name.equals(action.split(" ")[1])) {
                game.player.incHp(-i.dmg);
                game.player.inventory.get(counter).amnt -= 1;
                if (game.player.inventory.get(counter).amnt == 0) {
                    game.player.inventory.remove(counter);
                }
                System.out.println("Your health increased by " + String.valueOf(-i.dmg) + "!");
                return game;
            }
            counter++;
        }
        return game;
    }
    public static map attack (int index ,map game ,item weapon) {
        game.nodes.get(game.getPlayerNodeIndex()).enemies.get(index).health -= weapon.dmg;
        System.out.println("You dealt " + weapon.dmg + " to " + game.player.getLocation().enemies.get(index).name + " using " + weapon.name + "!");
        return game;
    }
    public static map pickUp (String action ,map game) {
        Scanner scan = new Scanner(System.in);
        String item = action.substring(8 ,action.length());
        int counter = 0;
        for (item i : game.nodes.get(game.getPlayerNodeIndex()).items) {
            if (i.name.equals(item)) {

                if (i.type == "container") {//if its a heavy container such as a bookshelf ,chest or wardrobe for instance
                    if (((container) i).dmg == 25) {
                        System.out.println("It's too heavy to pick up ,however it has items inside that you may be able to pick up ,would you like to take a look? (y/n)");
                        if (scan.nextLine().equals("y")) {
                            System.out.println("inside there are : ");
                            for (item i2 : ((container) i).getItems()) {
                                System.out.println(i2.name);
                            }
                            System.out.print("please type what you would like to pick up ,else type none : ");
                            String name = scan.nextLine();
                            int counter2 = 0;
                            for (item i2 : ((container) i).getItems()) {
                                if (i2.name == name) {
                                    game.player.inventory.add(i2);
                                    ((container) i).getItems().remove(counter2);
                                }
                                counter2++;
                            }
                        }
                    } else {
                        game.player.inventory.add(i);
                        game.nodes.get(game.getPlayerNodeIndex()).items.remove(counter);
                        System.out.println("You picked up " + i.name() + "!");
                    }
                } else {
                    game.player.inventory.add(i);
                    game.nodes.get(game.getPlayerNodeIndex()).items.remove(counter);
                    System.out.println("You picked up " + i.name() + "!");
                }
                return game;
            }
            counter++;
        }
        return game;
    }
    public static map deactivate (int index ,map game) {
        return game;
    }
    public static void help () {
        System.out.println("Almost every action you perform takes up a turn\n\t(unless you are checking your inventory ,checking an item in your inventory ,picking up an item ,checking the items in the room or asking for help\n\tas these five commands do not take up a turn)");
        System.out.println("\nhere are the actions you can perform : \n\n\tuse <item> <thing>         : uses an item on a thing ,for instance using a key on a lock or a weapon on an enemy (if its a health item ,you dont have to specify the <thing>)\n\t\t\t                    (for items with a space in their name ,replace the spaces with an _ (\"test item\" -> \"test_item\"))\n\tmove to <room or junction> : moves the player around the map (obviously you cannot move through locked doors though)\n\tpick up <item>             : picks up an item from the room\n\tcheck <item>               : analyses an item in your inventory\n\thelp                       : asks for this menu and a help page\n\tinv                        : checks the contents of your inventory\n\tcheck items               : displays the items in the room");
        System.out.println("\n\nuseful info : if an item contains other items (like a bookshelf) ,pick it up ,if its too heavy the game will still let you take items from inside it");
    }
}
