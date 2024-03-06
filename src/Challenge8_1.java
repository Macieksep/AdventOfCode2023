import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge8_1 {

    static String stepsInstruction = "LRRLRRLLRRRLRRLRLRRRLRRLRRRLRLLRRRLRRRLRLRRRLRRLRRLRLRLLLRRRLRRRLRRLRRLRLRRRLRRLLRRLRRLRLLRLRLRRLRLLRLRLRRRLRRLRLLRLRLLRRLRLRRLLLRLRRLRRRLLLRRLRLRRRLLRRLLLRRRLRRRLLLRRLLRLRRLRLRRLLLRLRRLLLLRRLLRRRLRRLRRLRLRLLRLRRRLLRRLLRRLRRLRRLRRLRLLRRLRRRLRLRLLLRRRLLRRRLRRLRRLLLLRRRR";
    //static String stepsInstruction = "RL";
    static List<String> leftInstruction = new ArrayList<>();
    static List<String> rightInstruction = new ArrayList<>();
    static List<String> stepId = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        convertTextToInstruction();

        score2("VRN");

    }

    static void convertTextToInstruction() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/ChallengeResources/Challenge8Text"));

        int lines = 716;
        int gap = 2;

        for (int i = 0; i < gap; i++) {
            scan.nextLine();
        }

        for (int i = gap; i < lines; i++) {

            String currentLine = scan.nextLine();

            stepId.add(currentLine.substring(0, currentLine.indexOf(' ')));
            leftInstruction.add(currentLine.substring(currentLine.indexOf('(')+1, currentLine.indexOf(',')));
            rightInstruction.add(currentLine.substring(currentLine.indexOf(',')+2, currentLine.length()-1));

        }

    }

    static void score2(String startId){

        int currentScore = 1;

        if (currentScore > stepsInstruction.length()){
            stepsInstruction += stepsInstruction;
        }

        String currentId = startId;

        while (!currentId.equals("ZZZ")) {

            if (currentScore > stepsInstruction.length()){
                stepsInstruction += stepsInstruction;
            }

            if (stepsInstruction.charAt(currentScore - 1) == 'L') {

                if (!leftInstruction.get(getNumIdOf(currentId)).equals("ZZZ")) {

                    currentId = stepId.get(getNumIdOf(leftInstruction.get(getNumIdOf(currentId))));
                    currentScore++;

                } else {

                    System.out.println(currentScore);
                    break;

                }

            } else {

                if (!rightInstruction.get(getNumIdOf(currentId)).equals("ZZZ")) {

                    currentId = stepId.get(getNumIdOf(rightInstruction.get(getNumIdOf(currentId))));
                    currentScore++;

                } else {

                    System.out.println(currentScore);
                    break;

                }

            }
        }

    }

    static int score(String currentId, int currentScore){

        if (currentScore > stepsInstruction.length()){
            stepsInstruction += stepsInstruction;
        }

        if (stepsInstruction.charAt(currentScore-1) == 'L'){

            if (!leftInstruction.get(getNumIdOf(currentId)).equals("ZZZ")){

                System.out.println(stepId.get(getNumIdOf(leftInstruction.get(getNumIdOf(currentId)))));

                return score(stepId.get(getNumIdOf(leftInstruction.get(getNumIdOf(currentId)))), ++currentScore);

            } else {

                return currentScore;

            }

        } else {

            if (!rightInstruction.get(getNumIdOf(currentId)).equals("ZZZ")){

                return score(stepId.get(getNumIdOf(rightInstruction.get(getNumIdOf(currentId)))), ++currentScore);

            } else {

                return currentScore;

            }

        }

    }

    static int getNumIdOf(String id) {

        return stepId.indexOf(id);

    }
}
