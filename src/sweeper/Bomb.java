package sweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;
    private List<Coord> placedBombs;

    public Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        placedBombs = new ArrayList<>();
    }

    void start(){
        bombMap = new Matrix(Box.ZERO);
        for(int i = 0 ; i < totalBombs ; i++){
            placeBomb();
        }
        placedBombs.clear();
    }

    Box getBox(Coord coord){
        return bombMap.getBox(coord);
    }

    private void placeBomb(){
        Coord coord;
        do{
            coord = Ranges.getRandomCoord();
        }while (!canPlace(coord));
        placedBombs.add(coord);
        bombMap.setBox(coord, Box.BOMB);
    }

    private Boolean canPlace(Coord _coord){
        System.out.println("x: " + _coord.x);
        System.out.println("y: " + _coord.y);
        if(placedBombs.size() == 0){
            return true;
        }
        for(Coord coord: placedBombs) {
            if(coord.x == _coord.x && coord.y == _coord.y){
                return false;
            }
        }
        return true;
    }
}
