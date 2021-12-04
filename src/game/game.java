package game;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Game {
    public static void main(String[] args) {
        //build map (i know its tedious doing the game this way ,but it'd be way more hellish if it was all if statements)
        String[] meta = {};
        //make the rooms and junctions first
        node startingRoom = new node(0 ,"starting room" ,"room" ,"This room is the start of the game!" ,meta);

        node room1 = new node(1 ,"room 1" ,"room" ,"" ,meta);
        node room2 = new node(2 ,"room 2" ,"room" ,"" ,meta);
        node room3 = new node(3 ,"room 3" ,"room" ,"" ,meta);
        node room4 = new node(4 ,"room 4" ,"room" ,"" ,meta);
        node room5 = new node(5 ,"room 5" ,"room" ,"" ,meta);
        node room6 = new node(6 ,"room 6" ,"room" ,"" ,meta);
        node room7 = new node(7 ,"room 7" ,"room" ,"" ,meta);
        node room8 = new node(8 ,"room 8" ,"room" ,"" ,meta);
        node library = new node(9 ,"library" ,"room" ,"" ,meta);
        node treasureRoom = new node(10 ,"treasure room" ,"room" ,"" ,meta);
        node trapRoom = new node(11 ,"trap room" ,"room" ,"" ,meta);
        node battleHall = new node(12 ,"final boss room" ,"room" ,"A large ,rectangular stone hall with pillars running down the length of it on both sides.\nAt the end of the room sits the final boss on his throne with a door either side of him ,one is marked \"TREASURE\" ,the other \"EXIT\"\n\nsuddenly you hear a \"click!\" as the door you just came through locks behind you." ,meta);
        node jackpotRoom = new node(13 ,"treasure room 2" ,"room" ,"" ,meta);
        node finalRoom = new node(14 ,"The final room in the game and the exit to the dungeon." ,"room" ,"" ,meta);

        node junction0 = new node(15 ,"junction" ,"junction" ,"" ,meta);
        node junction1 = new node(16 ,"junction" ,"junction" ,"" ,meta);
        node junction2 = new node(17 ,"junction" ,"junction" ,"" ,meta);
        node junction3 = new node(18 ,"junction" ,"junction" ,"" ,meta);
        node junction4 = new node(19 ,"junction" ,"junction" ,"" ,meta);



        //connect up the rooms

        //starting room
        startingRoom.addConnection(new connector("" ,-1 ,junction0 ,7 ,"junction"));
        startingRoom.addConnection(new connector("" ,-1 ,room1 ,1 ,"room"));

        //room 1
        room1.addConnection(new connector("" ,-1 ,room2 ,7 ,"room"));
        room1.addConnection(new connector("" ,-1 ,room4 ,0 ,"room"));
        room1.addConnection(new connector("" ,0 ,junction1 ,1 ,"junction"));

        //room2
        room2.addConnection(new connector("",-1 , junction0,6 ,"junction"));
        room2.addConnection(new connector("",-1 , room1,3 ,"room"));
        room2.addConnection(new connector("",-1 , room5,7 ,"room"));

        //room 3
        room3.addConnection(new connector("" ,-1 , room5,3 ,"room"));
        room3.addConnection(new connector("" ,-1 , room6, 1,"room"));

        //room 4
        room4.addConnection(new connector("" ,-1 ,junction2 ,7 ,"junction"));
        room4.addConnection(new connector("" ,-1 ,room1 ,4 ,"room"));
        room4.addConnection(new connector("" ,-1 ,junction3 ,1 ,"junction"));

        //room 5
        room5.addConnection(new connector("" ,-1 ,room2 ,4 ,"room"));
        room5.addConnection(new connector("" ,-1 ,room3 ,7 ,"room"));
        room5.addConnection(new connector("" ,-1 ,junction2 ,2 ,"junction"));

        //room 6
        room6.addConnection(new connector("" ,-1 ,room3 ,5 ,"room"));
        room6.addConnection(new connector("" ,-1 ,junction4 ,3 ,"junction"));

        //room 7
        room7.addConnection(new connector("" ,-1 ,junction1 ,4 ,"junction"));
        room7.addConnection(new connector("" ,-1 ,junction3 ,7 ,"junction"));
        room7.addConnection(new connector("library door" ,-1 ,library ,1 ,"room"));
        room7.addConnection(new connector("" ,-1 ,treasureRoom ,3 ,"room"));

        //room 8
        room8.addConnection(new connector("" ,-1 ,junction4 ,7 ,"junction"));
        room8.addConnection(new connector("" ,-1 ,junction2 ,5 ,"junction"));
        room8.addConnection(new connector("" ,-1 ,junction3 ,3 ,"junction"));


        //library
        library.addConnection(new connector("" ,-1 ,junction3 ,4 ,"junction"));
        library.addConnection(new connector("" ,0 ,room7 ,3 ,"room"));
        library.addConnection(new connector("" ,-1 ,junction4 ,6 ,"junction"));

        //treasure room (connected to room 7)
        treasureRoom.addConnection(new connector("" ,-1 ,room7 ,7 ,"room"));

        //trap room
        trapRoom.addConnection(new connector("exit" ,-1 ,battleHall ,2 ,"room"));
        trapRoom.addConnection(new connector("" ,-1 ,junction1 ,6 ,"room"));

        //battle hall (site of final boss battle ,accessable via boss key ,door locks behind you)
        battleHall.addConnection(new connector("Battle hall entrance/exit" ,1650551649 ,trapRoom ,7 ,"room"));
        battleHall.addConnection(new connector("Treasure room door" ,-1 ,jackpotRoom ,1 ,"room"));
        battleHall.addConnection(new connector("Dungeon exit door" ,4542020 ,finalRoom ,5 ,"room"));

        //jackpot room
        jackpotRoom.addConnection(new connector("" ,-1 ,battleHall ,5 ,"room"));

        //final room
        finalRoom.addConnection(new connector("" ,1234567890 ,battleHall ,1 ,"room"));

        //junction 0
        junction0.addConnection(new connector("" ,-1 ,startingRoom ,3 ,"room"));
        junction0.addConnection(new connector("" ,-1 ,room2 ,2 ,"room"));
        junction0.addConnection(new connector("" ,-1 ,room3 ,0 ,"room"));

        //junction 1
        junction1.addConnection(new connector("" ,-1 ,room1 ,5 ,"room"));
        junction1.addConnection(new connector("" ,1 ,trapRoom ,3 ,"room"));
        junction1.addConnection(new connector("" ,-1 ,room7 ,1 ,"room"));

        //junction 2
        junction2.addConnection(new connector("" ,-1 ,room5 ,6 ,"room"));
        junction2.addConnection(new connector("" ,-1 ,room8 ,2 ,"room"));
        junction2.addConnection(new connector("" ,-1 ,room4 ,3 ,"room"));

        //junction 3
        junction3.addConnection(new connector("" ,-1 ,room8 ,7 ,"room"));
        junction3.addConnection(new connector("" ,-1 ,room4 ,5 ,"room"));
        junction3.addConnection(new connector("" ,0 ,room7 ,3 ,"room"));
        junction3.addConnection(new connector("library door" ,-1 ,library ,1 ,"room"));

        //junction 4
        junction4.addConnection(new connector("" ,-1 ,room6 ,6 ,"room"));
        junction4.addConnection(new connector("" ,-1 ,room8 ,4 ,"room"));
        junction4.addConnection(new connector("library door" ,-1 ,library ,2 ,"room"));



        //now its time to populate the map with monsters

        room1.addEnemy(new enemy("Zombie" ,"" ,1 ,10 ,""));
        room2.addEnemy(new enemy("Skeleton" ,"" ,3 ,7 ,""));
        room5.addEnemy(new enemy("Orc" ,"" ,4 ,11 ,""));
        junction3.addEnemy(new enemy("Gruu" ,"" ,10 ,15 ,""));
        library.addEnemy(new enemy("Phantom librarian" ,"" ,15 ,16 ,""));

        room4.addEnemy(new enemy("Soldat" ,"" ,20 ,30 ,"metal part"));
        room4.giveEnemyItem("Soldat" ,new key(8 , "trap key","An old ,grey ,chipped metal key. It is a little heavy and has the word \"TRAP\" engraved on it."));
        //an important enemy ^

        room7.addEnemy(new enemy("Moulded" ,"" ,11 ,25 ,""));
        room8.addEnemy(new enemy("Lycan" ,"" ,12 ,27 ,""));
        treasureRoom.addEnemy(new enemy("The grey guardian" ,"" ,18 ,42 ,""));

        battleHall.addEnemy(new enemy("Visrex the Indestructible" ,"" ,25 ,75 ,"Your soul"));

        //now to add a few traps
        junction2.addTrap(new trap("moving saw trap" ,"" ,"enter_room" ,30 ,2 ,new item("item" ,"metal part" ,"a shiny metal part from something mechanical" ,0) ,false));//activation method : go to/from R8 ,trap type : moving sawblades ,disarm method : jam one of the two the metal parts in the mechanism
        jackpotRoom.addTrap(new trap("poison gas trap" ,"" ,"took_too_much;gold" ,-1 ,1 ,new item("placeholder" ,"" ,"" ,0) ,true));//activation method : take too much treasure ,trap type : poison gas & room lock (lethal) ,disarm method : none
        trapRoom.addTrap(new trap("crushing ceiling trap" ,"" ,"enter_room" ,100 ,3 ,new key(8 , "trap key","An old ,grey ,chipped metal key. It is a little heavy and has the word \"TRAP\" engraved on it.") ,true));//activation method : enter room ,trap type : crushing ceiling ,disarm method : trap key (obtainable by giving the soldat the metal part)
        


        //now to add the items
        room6.addItem(new item("item" ,"metal part" ,"a shiny metal part from something mechanical" ,0) ,2);

    }
}
