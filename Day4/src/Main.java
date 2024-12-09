import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Path filePath = Paths.get("Day4/src/example.txt");
        Path filePath = Paths.get("Day4/src/input.txt");
        String[][] matrix = Utils.readFileAndConvertToMatrix(filePath);

        int part1 = 0;

        List<List<String>> rows = Grid.extractRows(matrix);
        List<List<String>> cols = Grid.extractColumns(matrix);
        List<List<String>> leftToRightDiagonals = Grid.extractLeftToRightDiagonals(matrix);
        List<List<String>> rightToLeftDiagonals = Grid.extractRightToLeftDiagonals(matrix);

        for (List<String> item : rows) {
            part1 = part1 + countXmas(item);
        }

        for (List<String> item : cols) {
            part1 = part1 + countXmas(item);
        }

        for (List<String> item : leftToRightDiagonals) {
            part1 = part1 + countXmas(item);
        }

        for (List<String> item : rightToLeftDiagonals) {
            part1 = part1 + countXmas(item);
        }

        System.out.println(part1);

    }

    public static int countXmas(List<String> item) {
        String concat = String.join("", item);
        int xmas = concat.split("XMAS", -1).length-1;
        int samx = concat.split("SAMX", -1).length-1;
        return xmas + samx;
    }
}
