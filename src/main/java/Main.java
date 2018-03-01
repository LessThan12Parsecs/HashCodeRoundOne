import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import java.io.*;


public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/ema/IdeaProjects/myapp/src/main/java/example.in";
        String line = null;

        try{
            FileReader fr = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fr);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
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


        // 1. Create a Model
        Model model = new Model("practice problem");
        // 2. Create variables
        IntVar r = model.intVar("R", 1, 1000);                 // Rows in [1,1000]
        IntVar c = model.intVar("C", 1,1000);   // Column in [1,1000]
        IntVar l = model.intVar("L", 1,1000);   //  Minimum Ingredients in [1,1000]
        IntVar h = model.intVar("H", 1,1000);   // Maximumn total number of cells in a slice in [1,1000]
        // 3. Post constraints
        model.arithm(r, "+", c, "<", 5).post(); // x + y < 5
        model.times(r,c,4).post();              // x * y = 4
        // 4. Solve the problem
        model.getSolver().solve();
        // 5. Print the solution
        System.out.println(r); // Prints X = 2
        System.out.println(c); // Prints Y = 2
    }
}
