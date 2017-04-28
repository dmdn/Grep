import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("!!!You have not entered text");
            System.exit(0);
        }


        boolean searching = true;

        do {
            ArrayList<String> strArr = new ArrayList<>();

            Scanner in = new Scanner(System.in);
            System.out.print("Enter the search string: ");
            String word = in.nextLine();


            for (String arg : args) {

                StringBuffer strBuffer = new StringBuffer(arg);

                if (arg.matches("^[\\W].*")) {
                    strBuffer.deleteCharAt(0);
                }

                if (arg.matches(".*[\\W]")) {
                    strBuffer.deleteCharAt(strBuffer.length()-1);
                }

                Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

                Matcher matcher = pattern.matcher(String.valueOf(strBuffer));

                if (matcher.matches()) {
                    strArr.add(String.valueOf(strBuffer));
                }
            }

            if (strArr.size() == 0) {
                System.out.println("You entered an empty string or The word was not found");
            } else {
                for (int i = 0; i < strArr.size(); i++) {
                    System.out.print(strArr.get(i));
                    if (strArr.get(i) != strArr.get(strArr.size()-1)){
                        System.out.print(", ");
                    }
                }
                System.out.println("");
            }



            Scanner in1 = new Scanner(System.in);
            System.out.println("You want to search the string (y/n)?");
            String word1 = in1.nextLine();

            if (word1.equals("n")) {
                System.out.println("EXIT!");
                searching = false;
                System.exit(0);
            } else if (word1.equals("y")) {
                searching = true;
            } else {
                System.out.println("You gave the wrong answer!");
            }


        }
        while(searching);
        System.exit(0);

    }



}
