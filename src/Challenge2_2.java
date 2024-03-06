import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge2_2 {

    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge2Text");

        Scanner scan = new Scanner(textFile);

        int lines = 100;

        int sum = 0;

        for (int i = 1; i <= lines; i++) {

            String currentLine = scan.nextLine();

            currentLine = (currentLine.substring(currentLine.indexOf(": ")+1).trim() + ";  ");

            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;

            while (!currentLine.trim().isEmpty()) {

                String tempCurrentLine = currentLine.substring(0, currentLine.indexOf(";")) + ", ";

                while (!tempCurrentLine.trim().isEmpty()) {

                    switch (tempCurrentLine.substring(tempCurrentLine.indexOf(' ') + 1, tempCurrentLine.indexOf(','))) {

                        case "red":
                            if (Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' '))) > maxRed)
                                maxRed = Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' ')));
                            break;
                        case "green":
                            if (Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' '))) > maxGreen)
                                maxGreen = Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' ')));
                            break;
                        case "blue":
                            if (Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' '))) > maxBlue)
                                maxBlue = Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' ')));
                            break;
                    }

                    tempCurrentLine = tempCurrentLine.substring(tempCurrentLine.indexOf(',')+2);

                }

                currentLine = currentLine.substring(currentLine.indexOf(';')+2);

            }

            sum += maxRed*maxGreen*maxBlue;

            maxRed = 0;
            maxGreen = 0;
            maxBlue = 0;

        }

        System.out.println(sum);

    }

}
