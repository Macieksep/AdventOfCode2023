import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge6_1 {

    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge6Text");

        Scanner scan = new Scanner(textFile);

        int races = 4;

        List<Integer> time = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();

        for (int i = 0; i < 2; i++) {

            String currentLine = scan.nextLine();
            currentLine = currentLine.substring(currentLine.indexOf(':')+1).trim();

            for (int j = 0; j < races; j++) {

                if (i==0) {
                    time.add(Integer.parseInt(currentLine.substring(0, currentLine.indexOf(' '))));
                } else {
                    distance.add(Integer.parseInt(currentLine.substring(0, currentLine.indexOf(' '))));
                }

                currentLine = currentLine.substring(currentLine.indexOf(' ')).trim() + ' ';

            }

        }

        int result = 1;

        for (int i = 0; i < time.size(); i++) {

            result *= winOptionsCounter(time.get(i), distance.get(i));

        }

        System.out.println(result);

    }

    private static int winOptionsCounter(int time, int distance) {

        int winOptions = 0;

        for (int clickTime = 1; clickTime < time; clickTime++) {

            int timeLeft = time-clickTime;

            if (distance - (timeLeft*clickTime) < 0){

                winOptions++;

            }

        }

        return winOptions;
    }

}
