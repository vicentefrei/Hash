import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "src/female_names.txt";
        List<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int tableSize = 5000;

        HashTable table1 = new HashTableSumAscii(tableSize);
        HashTable table2 = new HashTableDJB2(tableSize);


        long startTime1 = System.nanoTime();
        for (String name : names) {
            table1.insert(name);
        }
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        for (String name : names) {
            table2.insert(name);
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        System.out.println("Tabela Hash 1 (Soma ASCII):");
        System.out.println("Colisões: " + table1.getCollisions());
        System.out.println("Tempo de inserção: " + duration1 + " ns");
        table1.printCollisions();
        
        System.out.println("\nTabela Hash 2 (DJB2):");
        System.out.println("Colisões: " + table2.getCollisions());
        System.out.println("Tempo de inserção: " + duration2 + " ns");
        table2.printCollisions();
    }
}
