import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("Day14/src/example.txt");
        List<String> lines = Utils.readFile(filePath);

        //String[][] grid = new String[103][101];
        String[][] grid = new String[7][11];

        fillGrid(grid);

        for(String line: lines) {
            String position = getPositionFromLine(line);
            String velocity = getVelocityFromLine(line);

            addPositionToGrid(position, grid);
        }

        printGrid(grid);

    }

    private static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("\"" + grid[i][j] + "\" ");
            }
            System.out.println();
        }
    }

    private static void fillGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = "";
            }
        }
    }

    private static String getPositionFromLine(String line) {
        return line.split(" ")[0];
    }

    private static String getVelocityFromLine(String line) {
        return line.split(" ")[1];
    }

    private static void addPositionToGrid(String position, String[][] grid) {
        String coordinatesPart = position.split("=")[1];
        String[] parts = coordinatesPart.split(",");

        int x = Integer.parseInt(parts[1].trim());
        int y = Integer.parseInt(parts[0].trim());

        if (grid[x][y].isEmpty()) {
            grid[x][y] = "1";
        }
        else {
            int positionValue = Integer.parseInt(grid[x][y]) + 1;
            grid[x][y] = String.valueOf(positionValue);
        }
    }
}