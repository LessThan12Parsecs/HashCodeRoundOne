
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/ema/IdeaProjects/myapp/src/main/java/example.in";
        String line = null;

        Configuration conf = null;
        List<Ride> rides = new ArrayList<>();

        try {
            FileReader fr = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fr);

            int lineNumber = 0;

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
                }

                //HashMap<Coordinates, String> map = new HashMap<Coordinates, String>();
                //map.put(new Coordinates(65, 72), "Dan");

                System.out.println(rides.toString());

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


        rides.forEach(ride->System.out.println(ride.getEarliestStart()));

    }
}
