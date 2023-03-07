import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input filename: ");
        String fileName = scanner.nextLine(); 
        scanner.close();

        String line;
        Map<String, Integer> counts = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".txt"))){
            while ((line = bufferedReader.readLine()) != null){
                line = line.toLowerCase();
                if (counts.containsKey(line)){
                counts.put(line, counts.get(line) + 1);
                } else {
                counts.put(line, 1);
                }
            }
        }

        String outputFile = "output.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))){
            for (Entry<String, Integer> entry: counts.entrySet()){
                bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }



    }
}
