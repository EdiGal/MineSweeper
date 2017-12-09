package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords;
     private static Random random = new Random();

    public static Coord getSize() {
        return size;
    }

    public static void setSize(Coord _size) {
        size = _size;
        allCoords = new ArrayList<Coord>();
        for(int y = 0; y< _size.x ; y++){
            for(int x = 0; x<_size.y; x++){
                allCoords.add(new Coord(x,y));
            }
        }
    }

    public static ArrayList<Coord> getAllCoords(){
        return allCoords;
    }

    public static boolean inRange(Coord coord){
        return coord.x >= 0 && coord.x < size.x &&
               coord.y >= 0 && coord.y < size.y;
    }

    public static Coord getRandomCoord(){
        return new Coord(random.nextInt(size.x),
                         random.nextInt(size.y));
    }

}