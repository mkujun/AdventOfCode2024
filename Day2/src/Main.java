import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("Day2/src/example.txt");
        List<String> lines = Utils.readFile(filePath);
        for (String line: lines) {
            System.out.println(line);
        }
    }
}