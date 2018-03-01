import java.util.List;

public class Car {

    Coordinates position = null;
    int timeStep = 0;
    List<Integer> solution;

    Car (Coordinates position, int timeStep, List<Integer> solution) {
        this.position = position;
        this.timeStep = timeStep;
        this.solution = solution;
    }

}
