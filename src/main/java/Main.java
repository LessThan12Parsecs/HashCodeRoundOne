
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/ema/IdeaProjects/myapp/src/main/java/example.in";
        String line = null;

        Configuration conf = null;
        List<Ride> rides = new ArrayList<>();
        LinkedHashMap<Integer, List<Ride>> earliestStartsPositions = new LinkedHashMap<>();
        Coordinates emptyCoordinates = new Coordinates(0,0);

        try {
            FileReader fr = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fr);

            int lineNumber = 0;
            List<Ride> ridesForMap = new ArrayList<>();

            while((line = bufferedReader.readLine()) != null) {
                List<Integer> elements = new ArrayList<>();
                //System.out.println(line + "   " + lineNumber);
                String[] splitFirstLine = line.split(" ");
                Arrays.stream(splitFirstLine).forEach(string -> elements.add(Integer.valueOf(string)));

                // First row configuration
                if (lineNumber == 0) {
                    conf = new Configuration(elements.get(0), elements.get(1), elements.get(2), elements.get(3), elements.get(4), elements.get(4));
                } else {

                    Coordinates start = new Coordinates(elements.get(0), elements.get(1));
                    Coordinates finish = new Coordinates(elements.get(2), elements.get(3));
                    Ride ride = new Ride(lineNumber - 1, start, finish, elements.get(4), elements.get(5));
                    rides.add(ride);

                    if (earliestStartsPositions.containsKey(ride.earliestStart)) {
                        ridesForMap = earliestStartsPositions.get(ride.getEarliestStart());
                        ridesForMap.add(ride);
                        earliestStartsPositions.put(ride.getEarliestStart(), ridesForMap);
                    } else {
                        ridesForMap = new ArrayList<>();
                        ridesForMap.add(ride);
                        earliestStartsPositions.put(ride.getEarliestStart(), ridesForMap);
                    }

                }

                lineNumber++;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        Car cars[] = new Car[conf.getVehicles()];


        for (int i = 0; i < conf.getVehicles(); i++) {
            Car initCar = new Car(emptyCoordinates, 0);
            cars[i] = initCar;
        }


        Map<Integer, List<Ride>> sortedMap = new LinkedHashMap<Integer, List<Ride>>();

        for (Map.Entry<Integer, List<Ride>> entry : earliestStartsPositions.entrySet()) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        Iterator<Map.Entry<Integer, List<Ride>>> entries = sortedMap.entrySet().iterator();
        while (entries.hasNext()) {
            //Integer key = entry.getKey();
            Map.Entry<Integer, List<Ride>> entry = entries.next();
            List<Ride> ridesList = entry.getValue();

            for (Ride ride : ridesList) {
                int start = ride.getEarliestStart();


                for (int i = 0; i < conf.getVehicles(); i++) {
                    if (cars[i].getTimeStep() <= start) {
                        //System.out.println(cars[i] + " " + i);
                        cars[i].setPosition(ride.getFinish());
                        cars[i].setTimeStep(ride.getLength() + ride.getEarliestStart());
                        cars[i].addSolution(ride.getId());



                    }
                }
            }
        }

/*        //rides.forEach(ride->System.out.println(ride.getEarliestStart()));
        for (Map.Entry<Integer, List<Ride>> entry : sortedMap.entrySet()) {
            //Integer key = entry.getKey();
            List<Ride> ridesList = entry.getValue();

            for (Ride ride : ridesList) {
                int start = ride.getEarliestStart();
                for (int i = 0; i < conf.getVehicles(); i++) {
                    if (cars[i].getTimeStep() <= start) {
                        System.out.println(cars[i] + " " + i);
                        *//*cars[i].setPosition(ride.getFinish());
                        cars[i].setTimeStep(ride.getLength() + ride.getEarliestStart());
                        cars[i].addSolution(ride.getId());*//*

                        Car car = new Car(ride.getFinish(), ride.getLength() + ride.getEarliestStart());
                        car.addSolution(ride.getId());

                        cars[i] = car;

                    }
                }
            }
        }*/

        for (int i = 0; i < conf.getVehicles(); i++) {


            System.out.println("Car " + i + " ");

            for (int n:a) {
                System.out.println(n + " ");
            }

            System.out.println();
        }


        Writer writer = null;

        for (int i = 0; i < conf.getVehicles(); i++) {
            List<Integer> a = cars[i].getSolution();
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("result.out"), "utf-8"));
                for (int n : a) {
                    writer.write(cars[i].getSolution().size() + " " + n + " ");
                }
            }
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}
