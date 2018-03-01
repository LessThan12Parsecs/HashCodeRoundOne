class Coordinates {
    int x;
    int y;

    public boolean equals(Object o) {
        Coordinates c = (Coordinates) o;
        return c.x == x && c.y == y;
    }

    public Coordinates(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return new Integer(x + "0" + y);
    }

    public int distanceFrom(Coordinates finish) {
        return (finish.x - x) + (finish.y - y);
    }
}