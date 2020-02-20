import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class GoogleHashCode {

    static int MAX;
    static List<Integer> Input, Output;
    static int Num;

    public static void main(String args[]) {
        String folderName = "C:\\Users\\Saurabh Sharma\\Documents\\personal\\GoogleHashCode\\PracticeProblem\\";
        String[] fileNames = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };
        for (int i = 0; i < fileNames.length; i++) {
            getInputFromFile(folderName, fileNames[i]);
            //call your solve method
            writeIntoFile(folderName, fileNames[i]);
        }

    }

    static void getInputFromFile(String folderName, String fileName) {
        try {
            Input = new ArrayList<Integer>();

            BufferedReader br = new BufferedReader(new FileReader(folderName + fileName + ".in"));
            String line, firstLine;
            firstLine = br.readLine();
            String[] vars;
            vars = firstLine.split(" ");

            MAX = Integer.valueOf(vars[0]); // Maximum Pizza slices requires
            Num = Integer.valueOf(vars[1]); // Number of Pizzas available
            // Create the pizza list by reading the file
            System.out.println("-------input of " + fileName);
            System.out.println(MAX + " " + Num);
            while ((line = br.readLine()) != null) {
                String letters[] = line.split(" ");
                for (int i = 0; i < letters.length; i++) {
                    Input.add(Integer.valueOf(letters[i]));
                    System.out.print(letters[i] + " ");
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(GoogleHashCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void writeIntoFile(String folderName, String fileName) {
        try {
            System.out.println("\n------- output " + fileName);
            PrintWriter outputFile = new PrintWriter(folderName + fileName + ".out", "UTF-8");
            outputFile.println(Output.size());
            System.out.println(Output.size());
            for (int i = 0; i < Output.size(); i++) {
                outputFile.print(Output.get(i) + " ");
                System.out.print(Output.get(i) + " ");
            }
            outputFile.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }
}