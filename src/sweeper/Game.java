package sweeper;

public class Game {

    private Bomb bomb;
    private Flag flag;

    public Game(int cols, int rows, int totalBombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(totalBombs);
        flag = new Flag();
    }

    public void start(){
        bomb.start();
        flag.start();
    }

    public Box getBox(Coord coord){
        if(flag.getBox(coord) == Box.OPENED){
            return bomb.getBox(coord);
        }
        return flag.getBox(coord);
    }

    public void pressedLeftButton(Coord coord) {
        if(checkBeforePress(coord)) {
            flag.openCell(coord);
        }
    }

    public void pressedRightButton(Coord coord) {
        if(checkBeforePress(coord)){
            flag.closeCell(coord);
        }
    }

    private Boolean checkBeforePress(Coord coord){
        return true;//flag.getBox(coord) == "OPENED";
    }

}
