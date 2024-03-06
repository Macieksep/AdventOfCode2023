import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge3_1 {

    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/ChallengeResources/Challenge3Text");

        Scanner scan = new Scanner(textFile);

        int lines = 140;
        int lineLength = 140;

        char[][] text = new char[lines+2][lineLength+2];

        for (int i = 0; i < lines+2; i++) {

            String currentLine = "";

            if (i != 0 && i != lines+1){

                currentLine = scan.nextLine();

            }

            for (int j = 0; j < lineLength+2; j++) {

                if (i == 0 || i == lines+1){

                    text[i][j] = '.';

                } else if (j == 0 || j == lineLength+1){

                    text[i][j] = '.';

                }else {

                    text[i][j] = currentLine.charAt(j-1);

                }

            }

        }

        int sum = 0;

        List<String> indexNum;

        for (int i = 1; i <= lines+1; i++) {

            indexNum = new ArrayList<>();

            String temp = "";

            for (int j = 1; j <= lineLength+1; j++) {

                if (temp.isEmpty() && text[i][j] >= '0' && text[i][j] <= '9'){

                    temp = j + " ";

                } else if (!temp.isEmpty() && !(text[i][j] >= '0' && text[i][j] <= '9')){

                    temp += (j-1);

                    indexNum.add(temp);

                    temp = "";

                }

            }

            System.out.println(indexNum);

            for (int j = 0; j < indexNum.size(); j++) {

                if (doesTouch(text, Integer.parseInt(indexNum.get(j).substring(0, indexNum.get(j).indexOf(' '))), Integer.parseInt(indexNum.get(j).substring(indexNum.get(j).indexOf(' ')+ 1)), i)){

                    String number = "";

                    for (int k = Integer.parseInt(indexNum.get(j).substring(0, indexNum.get(j).indexOf(' '))); k <= Integer.parseInt(indexNum.get(j).substring(indexNum.get(j).indexOf(' ')+ 1)); k++) {

                        number += text[i][k];

                    }

                    sum += Integer.parseInt(number);

                }

            }

        }


        System.out.println(sum);

    }

    static boolean doesTouch(char[][] text, int start, int end, int row){

        for (int i = row-1; i <= row+1; i++) {
            for (int j = start-1; j <= end+1; j++) {

                //System.out.println(text[i][j] + " " + i + " " + j );

                if (text[i][j] != '.' && !(text[i][j] >= '0' && text[i][j] <= '9')){
                    return true;
                }

            }
        }

        return false;

    }

}
