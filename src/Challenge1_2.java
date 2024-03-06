import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge1_2 {
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

    static String fixedLine(String line){

        String[] nums = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 3; i < line.length(); i++) {

            for (String textNum : nums) {

                String lineSub = line.substring(0, i);

                if (lineSub.contains(textNum)){

                    switch (textNum){

                        case "one":
                            lineSub = lineSub.replaceFirst(textNum, "1");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "two":
                            lineSub = lineSub.replaceFirst(textNum, "2");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "three":
                            lineSub = lineSub.replaceFirst(textNum, "3");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "four":
                            lineSub = lineSub.replaceFirst(textNum, "4");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "five":
                            lineSub = lineSub.replaceFirst(textNum, "5");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "six":
                            lineSub = lineSub.replaceFirst(textNum, "6");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "seven":
                            lineSub = lineSub.replaceFirst(textNum, "7");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "eight":
                            lineSub = lineSub.replaceFirst(textNum, "8");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "nine":
                            lineSub = lineSub.replaceFirst(textNum, "9");
                            line = lineSub + line.substring(i) + stringFix(textNum);
                            return line.replaceAll("X", "");

                    }


                }

            }

        }

        return line.replaceAll("X", "");

    }

    static String fixedLine2(String line){

        String[] nums = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = line.length()-2; i >= 0; i--) {

            for (String textNum : nums) {

                String lineSub = line.substring(i);

                if (lineSub.contains(textNum)){

                    switch (textNum){

                        case "one":
                            lineSub = lineSub.replaceFirst(textNum, "1");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "two":
                            lineSub = lineSub.replaceFirst(textNum, "2");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "three":
                            lineSub = lineSub.replaceFirst(textNum, "3");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "four":
                            lineSub = lineSub.replaceFirst(textNum, "4");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "five":
                            lineSub = lineSub.replaceFirst(textNum, "5");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "six":
                            lineSub = lineSub.replaceFirst(textNum, "6");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "seven":
                            lineSub = lineSub.replaceFirst(textNum, "7");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "eight":
                            lineSub = lineSub.replaceFirst(textNum, "8");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");
                        case "nine":
                            lineSub = lineSub.replaceFirst(textNum, "9");
                            line = line.substring(0, i) + lineSub + stringFix(textNum);
                            return line.replaceAll("X", "");

                    }


                }

            }

        }

        return line.replaceAll("X", "");

    }


    static int[] numFinder(Scanner scan, int lines){

        int[] num = new int[lines];

        for (int i = 0; i < lines; i++) {

            String line = scan.nextLine();

            String currentLine = fixedLine2(fixedLine(line));

            System.out.print(line + "\t" + currentLine + " ");

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

            System.out.print(num[i] + "\n");

        }



        return num;

    }

    static String stringFix(String old){

        return "X".repeat(Math.max(0, old.length() - 1));

    }
}