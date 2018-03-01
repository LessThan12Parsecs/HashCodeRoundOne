public class Configuration {

    int rows = 0;
    int columns = 0;
    int vehicles = 0;
    int rides = 0;
    int bonus = 0;
    int steps = 0;

    Configuration (int rows, int columns, int vehicles, int rides, int bonus, int steps) {
        this.rows = rows;
        this.columns = columns;
        this.vehicles = vehicles;
        this.rides = rides;
        this.bonus = bonus;
        this.steps = steps;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    public int getRides() {
        return rides;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
