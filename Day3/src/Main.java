import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        long part1 = 0;

        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        String outString = "";
        try {
            Scanner in = new Scanner(new FileReader("Day3/src/input.txt"));
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            outString = sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Matcher matcher = pattern.matcher(outString);

        ArrayList<String> results = new ArrayList<>();

        while (matcher.find()) {
            results.add(matcher.group());
        }

        // Print all matched results
        for (String result : results) {
            String numbers = result.split("mul")[1];

            numbers = numbers.substring(1, numbers.length() - 1);

            int num1 = Integer.parseInt(numbers.split(",")[0]);
            int num2 = Integer.parseInt(numbers.split(",")[1]);

            part1 = part1 + (num1*num2);
        }
        System.out.println(part1);
    }
}