import java.util.ArrayList;
import java.util.List;

public class Car {

    Coordinates position = null;
    int timeStep = 0;
    List<Integer> solution;

    Car (Coordinates position, int timeStep) {
        this.position = position;
        this.timeStep = timeStep;
        this.solution = new ArrayList<>();
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public int getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public List<Integer> getSolution() {
        return solution;
    }

    public void setSolution(List<Integer> solution) {
        this.solution = solution;
    }

    public void addSolution(int sol) {
        this.solution.add(sol);
    }
}
