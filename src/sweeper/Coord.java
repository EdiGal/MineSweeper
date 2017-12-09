package sweeper;

public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Coord){
            Coord coord = (Coord)object;
            return coord.x == this.x && coord.y == this.y;
        }
        return super.equals(object);
    }
}
