import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NinetyOne {


    public static void main(String[] args) {
    convertToWords("input.txt");

    }


public static void convertToWords(String filename){
    try {
        Scanner fileScanner = new Scanner(new File(filename));
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner  = new Scanner(line);
            boolean valid = false;
            while (lineScanner.hasNext()) {

//                long number = Long.parseLong(line.replaceAll("\\D+", ""));
                if (lineScanner.hasNextLong()) {
                    long input = lineScanner.nextLong();

                    String next = lineScanner.next();
                    if(!next.matches(".*\\d.*")) {
                        System.out.println(getWord(input));
                        valid = true;
                        break;
                    }else{
                        valid = false;
                    }
                }


                   lineScanner.next();

            }
            if(!valid)
                System.out.println("number invalid");

            lineScanner.close();
        }

        fileScanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
    public static String getWord( long n) {
      String[] units = {
                "", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
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

        if (n < 20) {
            return units[(int) n];
        }

        if (n < 100) {
            return tens[(int) (n / 10)] + ((n % 10 != 0) ? "-" : "") + units[(int) (n % 10)];
        }

        if (n < 1000) {
            return units[(int) (n / 100)] + " hundred" + ((n % 100 != 0) ? " and " : "") + getWord(n % 100);
        }

        if (n < 1000000) {
            String result = getWord(n / 1000) + " thousand" ;
            if(getWord(n % 1000).contains("and")){
                result = result + ", " + getWord(n % 1000);
            }else
                result = result + " and " +getWord(n%1000);
            return  result;

        }

        if (n < 1000000000) {
            String result = getWord(n / 1000000) + " million";

            if(getWord(n % 1000000).contains("and"))
                result = result + ", " + getWord(n % 1000000);
            else
                result = result + " and " + getWord(n % 1000000);
            return result;

//            return getWord(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + getWord(n % 1000000);
        }


        String result = getWord(n / 1000000000) + " billion";
        if(getWord(n % 1000000000).contains("and"))
            result = result + ", " + getWord(n % 1000000000);
        else
            result = result + " and " + getWord(n % 1000000000);

        return result;
              //  + ((n % 1000000000 != 0) ? " " : "") + getWord(n % 1000000000);
    }
}
