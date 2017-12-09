package sweeper;

public class Flag {

    private Matrix flagMap;

    void start(){
        flagMap = new Matrix(Box.CLOSED);
        openCell(new Coord(2,3));
        openCell(new Coord(3,3));
        openCell(new Coord(4,3));
        openCell(new Coord(5,3));
        openCell(new Coord(6,3));
    }

    public void openCell(Coord coord){
        if(flagMap.getBox(coord) != Box.FLAGED){
            flagMap.setBox(coord ,Box.OPENED);
        }
    }

    public void closeCell(Coord coord){
        if(flagMap.getBox(coord) == Box.CLOSED){
            flagMap.setBox(coord ,Box.FLAGED);
        }
        else if(flagMap.getBox(coord) == Box.FLAGED){
            flagMap.setBox(coord ,Box.CLOSED);
        }
    }

    Box getBox(Coord coord){
        return flagMap.getBox(coord);
    }
}
