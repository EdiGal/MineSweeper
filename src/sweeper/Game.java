package sweeper;

public class Game {

    private Bomb bomb;

    public Game(int cols, int rows, int totalBombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(totalBombs);
    }

    public void start(){
        bomb.start();
    }

    public Box getBox(Coord coord){
        return bomb.getBox(coord);
    }
}
