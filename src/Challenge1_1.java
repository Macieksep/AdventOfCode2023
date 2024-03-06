import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge1_1 {
    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge1Text");

        int lines = linesCounter(new Scanner(textFile));

        int[] num = numFinder(new Scanner(textFile), lines);

        int result = 0;

        for (int number : num) {

            result += number;

        }

        System.out.println(result);

    }

    static int linesCounter(Scanner scan){

        int lines = 0;

        while (scan.hasNextLine()) {
            lines++;
            scan.nextLine();
        }

        return lines;

    }

    static int[] numFinder(Scanner scan, int lines){

        int[] num = new int[lines];

        for (int i = 0; i < lines; i++) {

            String currentLine = scan.nextLine();

            for (int j = 0; j < currentLine.length(); j++) {

                if (currentLine.charAt(j) >= '0' && currentLine.charAt(j) <= '9'){

                    num[i] = Integer.parseInt(String.valueOf(currentLine.charAt(j)))*10;
                    break;

                }

            }

            for (int j = currentLine.length()-1; j >= 0; j--) {

                if (currentLine.charAt(j) >= '0' && currentLine.charAt(j) <= '9'){

                    num[i] += Integer.parseInt(String.valueOf(currentLine.charAt(j)));
                    break;

                }

            }

        }

        return num;

    }

}
