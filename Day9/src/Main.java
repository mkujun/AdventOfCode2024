import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Path filePath = Paths.get("Day9/src/example.txt");
        Path filePath = Paths.get("Day9/src/input.txt");
        String line = Utils.readFile(filePath).get(0);

        int idNumber = 0;
        LinkedList<String> blocks = new LinkedList<>();
        String[] digits = line.split("");

        readBlocks(digits, blocks, idNumber);
        moveBlocks(blocks);
        calculateChecksum(blocks);
    }

    private static void calculateChecksum(LinkedList<String> blocks) {
        long sum = 0;

        for (int i = 0; i < blocks.size(); i++) {
            if (!Objects.equals(blocks.get(i), ".")) {
                sum = sum + Long.parseLong(blocks.get(i)) * i;
            }
        }

        System.out.println(sum);
    }

    private static void moveBlocks(LinkedList<String> blocks) {
        int left = 0;
        int right = blocks.size() - 1;

        while (left < right) {
            // Move left pointer to next dot
            while (left < right && !blocks.get(left).equals(".")) {
                left++;
            }

            // Move right pointer to next non-dot
            while (left < right && blocks.get(right).equals(".")) {
                right--;
            }

            // Swap if valid positions found
            if (left < right) {
                Collections.swap(blocks, left, right);
                left++;
                right--;
            }
        }
    }
    private static void readBlocks(String[] digits, LinkedList<String> blocks, int idNumber) {
        int freeSpace;
        int fileLength;
        for (int i = 0; i < digits.length; i++) {

            if (i % 2 == 0) {
                fileLength = Integer.parseInt(digits[i]);
                for (int j = 0; j < fileLength; j++) {
                    blocks.add(String.valueOf(idNumber));
                }
                idNumber++;
            }
            else {
                freeSpace = Integer.parseInt(digits[i]);
                for (int j = 0; j < freeSpace; j++) {
                    blocks.add(".");
                }
            }

        }
    }
}