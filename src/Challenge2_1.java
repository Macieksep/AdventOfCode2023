import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge2_1 {

    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge2Text");

        Scanner scan = new Scanner(textFile);

        int lines = 100;

        int sum = 0;

        for (int i = 1; i <= lines; i++) {

            String currentLine = scan.nextLine();

            currentLine = (currentLine.substring(currentLine.indexOf(": ")+1).trim() + ";  ");

            boolean tempOk = true;

            while (!currentLine.trim().isEmpty()) {

                int red = 0;
                int green = 0;
                int blue = 0;

                String tempCurrentLine = currentLine.substring(0, currentLine.indexOf(";")) + ", ";

                while (!tempCurrentLine.trim().isEmpty()) {

                    switch (tempCurrentLine.substring(tempCurrentLine.indexOf(' ') + 1, tempCurrentLine.indexOf(','))) {

                        case "red":
                            red += Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' ')));
                            break;
                        case "green":
                            green += Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' ')));
                            break;
                        case "blue":
                            blue += Integer.parseInt(tempCurrentLine.substring(0, tempCurrentLine.indexOf(' ')));
                            break;
                    }

                    tempCurrentLine = tempCurrentLine.substring(tempCurrentLine.indexOf(',')+2);

                }

                if (red > 12 || green > 13 || blue > 14){

                    tempOk = false;

                    break;

                }

                currentLine = currentLine.substring(currentLine.indexOf(';')+2);

            }

            if (tempOk){

                sum += i;

            }

        }

        System.out.println(sum);

    }

}
