import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge6_2 {

    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge6Text");

        Scanner scan = new Scanner(textFile);

        int races = 4;

        String timeStr = "";
        String distanceStr = "";

        for (int i = 0; i < 2; i++) {

            String currentLine = scan.nextLine();
            currentLine = currentLine.substring(currentLine.indexOf(':')+1).trim();

            for (int j = 0; j < races; j++) {

                if (i==0) {
                    timeStr += currentLine.substring(0, currentLine.indexOf(' '));
                } else {
                    distanceStr += currentLine.substring(0, currentLine.indexOf(' '));
                }

                currentLine = currentLine.substring(currentLine.indexOf(' ')).trim() + ' ';

            }

        }

        long time = Long.parseLong(timeStr);
        long distance = Long.parseLong(distanceStr);

        System.out.println(winOptionsCounter(time, distance));

    }

    private static int winOptionsCounter(long time, long distance) {

        int winOptions = 0;

        for (int clickTime = 1; clickTime < time; clickTime++) {

            long timeLeft = time-clickTime;

            if (distance - (timeLeft*clickTime) < 0){

                winOptions++;

            }

        }

        return winOptions;
    }

}
