package game;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class game {
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
        node battleHall = new node(11 ,"final boss room" ,"room" ,"" ,meta);
        node jackpotRoom = new node(12 ,"treasure room 2" ,"room" ,"" ,meta);
        node finalRoom = new node(13 ,"The final room in the game and the exit to the dungeon." ,"room" ,"" ,meta);

        node junction0 = new node(14 ,"" ,"junction" ,"" ,meta);
        node junction1 = new node(15 ,"" ,"junction" ,"" ,meta);
        node junction2 = new node(16 ,"" ,"junction" ,"" ,meta);
        node junction3 = new node(17 ,"" ,"junction" ,"" ,meta);
        node junction4 = new node(18 ,"" ,"junction" ,"" ,meta);
        
        //connect up the rooms

        //starting room
        connector start_J0 = new connector("" ,-1 ,junction0 ,7 ,"junction");
        startingRoom.addConnection(start_J0);
        connector start_R1 = new connector("" ,-1 ,room1 ,1 ,"room");
        startingRoom.addConnection(start_R1);

        //junction 0
        connector J0_start = new connector("" ,-1 ,startingRoom ,3 ,"room");
        junction0.addConnection(J0_start);
        connector J0_R2 = new connector("" ,-1 ,room2 ,2 ,"room");
        junction0.addConnection(J0_R2);
        connector J0_R3 = new connector("" ,-1 ,room3 ,0 ,"room");
        junction0.addConnection(J0_R3);

        //room 1

    }
}
