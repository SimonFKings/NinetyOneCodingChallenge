import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NinetyOne {


    public static void main(String[] args) {
    convertToWords("input.txt");

    }

    public static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public static final String[] tens = {
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };
public static void convertToWords(String filename){
    try {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            int number = Integer.parseInt(line.replaceAll("\\D+",""));


            System.out.println(getWord(number));
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
    public static String getWord(final int n) {
//        if (n < 0) {
//            return "minus " + convert(-n);
//        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + getWord(n % 100);
        }

        if (n < 1000000) {
            return getWord(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + getWord(n % 1000);
        }

        if (n < 1000000000) {
            return getWord(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + getWord(n % 1000000);
        }

        return getWord(n / 1000000000) + " billion"  + ((n % 1000000000 != 0) ? " " : "") + getWord(n % 1000000000);
    }
}
