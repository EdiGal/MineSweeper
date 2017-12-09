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
        for(Coord around : Ranges.getCoordsAround(coord)){
            bombMap.setBox(around, Box.NUM1);
        }
    }

    private Boolean canPlace(Coord _coord){
        if(placedBombs.size() == 0){
            return true;
        }
        for(Coord coord: placedBombs) {
            if(coord.equals(_coord)){
                return false;
            }
        }
        return true;
    }
}
