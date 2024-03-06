import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge4_1 {

    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge4Text");

        Scanner scan = new Scanner(textFile);

        int lines = 203;
        int winNumCount = 10;
        int handCount = 25;

        List<String> winNum;
        List<String> num;

        int sum = 0;

        for (int i = 0; i < lines; i++) {

            winNum = new ArrayList<>();
            num = new ArrayList<>();

            String currentWinLine = scan.nextLine();
            String currentCardLine = currentWinLine.substring(currentWinLine.indexOf("|")+1).trim() + " ";
            currentWinLine = currentWinLine.substring(currentWinLine.indexOf(":")+1, currentWinLine.indexOf("|")).trim() + " ";

            for (int j = 0; j < winNumCount; j++) {

                winNum.add(currentWinLine.substring(0, currentWinLine.indexOf(" ")));

                currentWinLine = currentWinLine.substring(currentWinLine.indexOf(" ")).trim() + " ";

            }

            for (int j = 0; j < handCount; j++) {

                num.add(currentCardLine.substring(0, currentCardLine.indexOf(" ")));

                currentCardLine = currentCardLine.substring(currentCardLine.indexOf(" ")).trim() + " ";

            }

//                System.out.println(winNum);
//                System.out.println(num);

            int multiplier = -1;

            for (int j = 0; j < handCount; j++) {

                if (winNum.contains(num.get(j))){

                    multiplier++;

                }

            }

            if (Math.pow(2, multiplier) >= 1){
                sum += (int)Math.pow(2, multiplier);
            }

        }

        System.out.println(sum);

    }

}
