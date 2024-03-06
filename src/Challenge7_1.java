import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Challenge7_1 {

    public static List<String> handList = new ArrayList<>();
    public static List<String> bidList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        handInitializer();

        for (int i = 0; i < handList.size(); i++) {
            for (int j = 0; j < handList.size(); j++) {

                if (handPower(handList.get(i)) < handPower(handList.get(j))){

                    String TEMP = handList.get(i);

                    handList.set(i, handList.get(j));
                    handList.set(j, TEMP);

                    TEMP = bidList.get(i);

                    bidList.set(i, bidList.get(j));
                    bidList.set(j, TEMP);

                }

            }
        }

        // do tego miejsca git

        for (int i = 0; i < handList.size(); i++) {
            for (int j = 0; j < handList.size(); j++) {

                handComparator(handList.get(i), handList.get(j), i, j, handPower(handList.get(i)), handPower(handList.get(j)));

            }
        }

        System.out.println(handList);

        long sum = 0;

        for (int i = 0; i < bidList.size(); i++) {

            sum += (i + 1)*Long.parseLong(bidList.get(i));

        }

        System.out.println(sum);

    }

    static void handInitializer() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/ChallengeResources/Challenge7Text"));

        int lines = 1000;

        for (int i = 0; i < lines; i++) {

            String currentLine = scan.nextLine();

            handList.add(currentLine.substring(0, currentLine.indexOf(' ')));
            bidList.add(currentLine.substring(currentLine.indexOf(' ')+1));

        }

    }

    static int cardPower(char card){

        return switch (card){

            case 'A' -> 13;
            case 'K' -> 12;
            case 'Q' -> 11;
            case 'J' -> 10;
            case 'T' -> 9;
            case '9' -> 8;
            case '8' -> 7;
            case '7' -> 6;
            case '6' -> 5;
            case '5' -> 4;
            case '4' -> 3;
            case '3' -> 2;
            case '2' -> 1;
            default -> 0;

        };

    }

    static int handPower(String hand){

        Set<Character> handCount = new HashSet<>();

        for (int i = 0; i < 5; i++) {

            handCount.add(hand.charAt(i));

        }

        switch (handCount.size()){

            case 1:
                return 7;
            case 4:
                return 2;
            case 5:
                return 1;

        }

        if (handCount.size() == 2 || handCount.size() == 3){

            return countChar(hand, handCount);

        }

        return 0;

    }

    static int countChar(String hand, Set<Character> handCards){

        for (char x : handCards){

            int MAX = 0;

            int count = 0;

            for (int i = 0; i < 5; i++) {

                if (x == hand.charAt(i)){

                    count++;

                }

            }

            if (count > MAX){
                MAX = count;
            }


            if (handCards.size() == 2){

                if (MAX == 4){

                    return 6;

                } else if (MAX == 3){

                    return 5;

                }

            } else if (handCards.size() == 3) {

                if (MAX == 3){

                    return 4;

                } else if (MAX == 2){

                    return 3;

                }

            }

        }

        return 0;

    }

    static void handComparator(String a, String b, int indexA, int indexB, int powerA, int powerB){

        if (powerA == powerB){

            a = a.replaceAll("A" , "M");
            a = a.replaceAll("K" , "L");
            a = a.replaceAll("Q" , "K");
            a = a.replaceAll("J" , "J");
            a = a.replaceAll("T" , "I");
            a = a.replaceAll("9" , "H");
            a = a.replaceAll("8" , "G");
            a = a.replaceAll("7" , "F");
            a = a.replaceAll("6" , "E");
            a = a.replaceAll("5" , "D");
            a = a.replaceAll("4" , "C");
            a = a.replaceAll("3" , "B");
            a = a.replaceAll("2" , "A");

            b = b.replaceAll("A" , "M");
            b = b.replaceAll("K" , "L");
            b = b.replaceAll("Q" , "K");
            b = b.replaceAll("J" , "J");
            b = b.replaceAll("T" , "I");
            b = b.replaceAll("9" , "H");
            b = b.replaceAll("8" , "G");
            b = b.replaceAll("7" , "F");
            b = b.replaceAll("6" , "E");
            b = b.replaceAll("5" , "D");
            b = b.replaceAll("4" , "C");
            b = b.replaceAll("3" , "B");
            b = b.replaceAll("2" , "A");

            List<String> help = new ArrayList<>();

            help.add(a);
            help.add(b);

            Collections.sort(help);

            if (help.get(0).equals(a)){

                    String TEMP = handList.get(indexA);

                    handList.set(indexA, handList.get(indexB));
                    handList.set(indexB, TEMP);

                    TEMP = bidList.get(indexA);

                    bidList.set(indexA, bidList.get(indexB));
                    bidList.set(indexB, TEMP);

                }

            }

        }

}

