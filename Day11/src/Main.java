import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("Day11/src/example.txt");
        //Path filePath = Paths.get("Day11/src/input.txt");
        //Path filePath = Paths.get("Day11/src/test.txt");
        List<String> lines = Utils.readFile(filePath);

        List<String> newStones = blink(new ArrayList<>(Arrays.asList(lines.get(0).split(" "))));

        for (int i = 0; i < 24; i++) {
            newStones = blink(newStones);
            //System.out.println(newStones);
        }

        System.out.println(newStones.size());
    }

    private static List<String> blink(List<String> stones) {
        return readStones(stones, new ArrayList<>());
    }

    private static List<String> readStones(List<String> stones, List<String> newStones) {
        for(String stone : stones) {

            if (stone.equals("0")) {
                newStones.add("1");
            }
            else if (stone.length() % 2 == 0) {
                changeEvenStone(stone, newStones);
            }
            else {
                //Integer newStone = Integer.parseInt(stone) * 2024;
                Long newStone = Long.parseLong(stone) * 2024;
                newStones.add(newStone.toString());
            }
        }

        return newStones;
    }

    private static void changeEvenStone(String stone, List<String> newStones) {
        char[] digits = stone.toCharArray();

        String firstHalf = new String(digits, 0, digits.length / 2);
        newStones.add(firstHalf);

        String secondHalf = new String(digits, digits.length / 2, digits.length - digits.length / 2);
        newStones.add(normalizeString(secondHalf));
    }

    public static String normalizeString(String input) {
        if (input == null || input.isEmpty()) {
            return ""; // Handle null or empty input
        }
        // Remove leading zeros and default to "0" if the result is empty
        String result = input.replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }
}