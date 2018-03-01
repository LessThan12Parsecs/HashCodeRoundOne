public class Ride {

    int id = 0;
    Coordinates start = null;
    Coordinates finish = null;
    int earliestStart = 0;
    int latestFinish = 0;
    int length = 0;

    Ride (int id, Coordinates start, Coordinates finish, int earliestStart, int latestFinish) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        this.length = start.distanceFrom(finish);
    }

    public Coordinates getStart() {
        return start;
    }

    public void setStart(Coordinates start) {
        this.start = start;
    }

    public Coordinates getFinish() {
        return finish;
    }

    public void setFinish(Coordinates finish) {
        this.finish = finish;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
