import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NinetyOne {


    public static void main(String[] args) {
    convertToWords("input.txt");

    }


public static void convertToWords(String filename){

    try
    {
        //Scanner used to check each line of the file
        Scanner fileScanner = new Scanner(new File(filename));
        while(fileScanner.hasNextLine()) {
            //A new scanner to check individual lines
            String line = fileScanner.nextLine();
            Scanner lineScanner  = new Scanner(line);
            //Check if an input is valid from the line
            boolean valid = false;

            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextLong()) {
                    long input = lineScanner.nextLong();
                    //Check if the next input contains another number to ensure this input is valid
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

        //The condition checks if the a second word is needed then adds a dash if so
        if (n < 100) {
            return tens[(int) (n / 10)] + ((n % 10 != 0) ? "-" : "") + units[(int) (n % 10)];
        }

        // The checks if an and word is needed after the hundred word
        if (n < 1000) {
            return units[(int) (n / 100)] + " hundred" + ((n % 100 != 0) ? " and " : "") + getWord(n % 100);
        }


        //Check if the next word contains an and, if so add a comma. If the current word is before the last, add an "and"
        if (n < 1000000) {
            String result = getWord(n / 1000) + " thousand" ;
            if(getWord(n % 1000).contains("and")){
                return result + ", " + getWord(n % 1000);
            }else if (n % 1000 != 0 )
                return  result + " and " +getWord(n%1000);
                else
                    return  result;



        }

        if (n < 1000000000) {
            String result = getWord(n / 1000000) + " million";

            if(getWord(n % 1000000).contains("and"))
                return result + ", " + getWord(n % 1000000);
            else if (n % 1000000 != 0)
                return  result + " and " + getWord(n % 1000000);
            else
                return result;

        }


        String result = getWord(n / 1000000000) + " billion";
        if(getWord(n % 1000000000).contains("and"))
            return result + ", " + getWord(n % 1000000000);
        else if(n % 1000000000 != 0)
            return result + " and " + getWord(n % 1000000000);
        else
            return result;
    }
}
