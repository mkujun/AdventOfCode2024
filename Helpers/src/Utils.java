import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static List<String> readFile(Path filePath) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static String[][] readFileAndConvertToMatrix(Path filePath) {
        // Read all lines from the file
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<String>> matrix = new ArrayList<>();
        for (String line : lines) {
            List<String> chars = List.of(line.split(""));
            matrix.add(chars);
        }

        // Convert List<List<String>> to String[][]
        String[][] result = new String[matrix.size()][]; // Initialize 2D array with row count
        for (int i = 0; i < matrix.size(); i++) {
            List<String> row = matrix.get(i);
            result[i] = row.toArray(new String[0]); // Convert each row to String[]
        }

        return result;
    }

    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
