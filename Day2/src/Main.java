import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static int part1 = 0;

    public static void main(String[] args) {
        //Path filePath = Paths.get("Day2/src/example.txt");
        Path filePath = Paths.get("Day2/src/input.txt");
        List<String> lines = Utils.readFile(filePath);

        readReportLineFrom(lines);

        System.out.println(part1);
    }

    private static void readReportLineFrom(List<String> lines) {
        for (String line: lines) {
            if(isReportLineSafe(line)) {
                part1++;
            }
        }
    }

    private static boolean isReportLineSafe(String levelString) {
        boolean isAscending = true;
        boolean isDescending = true;

        String[] levels = levelString.split(" ");

        for (int i = 0; i < levels.length - 1; i++) {
            int current = Integer.parseInt(levels[i]);
            int next = Integer.parseInt(levels[i + 1]);

            if (Math.abs(current - next) > 3 || current == next) {
                isAscending = false;
                isDescending = false;
            }
            if (current > next) {
                isAscending = false;
            } else if (current < next) {
                isDescending = false;
            }
        }

        return isAscending || isDescending;
    }
}