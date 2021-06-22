import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    private static void wrongInput(){
        //Wrong Input message.
        System.out.println("Invalid choice, please try again.");
    }
    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList();
        String answer = "Y";
        //Welcome screen:
        System.out.println("Welcome to the currency converter.");
        while(answer.toLowerCase(Locale.ROOT).equals("y")){
            System.out.println("Please choose an option (1/2/3)");
            System.out.println("1. Dollars to Shekels.");
            System.out.println("2. Shekels to Dollars.");
            System.out.println("3. Shekels to Euros.");
            int coinChoice = 5;
            while((coinChoice != 1) && (coinChoice != 2) && (coinChoice != 3)) {
                Scanner user1 = new Scanner(System.in);
                if (! user1.hasNextInt()){
                    // Different type input check.
                    wrongInput();
                    continue;
                }
                coinChoice = user1.nextInt();
                if ((coinChoice != 1) && (coinChoice != 2) & (coinChoice != 3)){
                    // Different int input check.
                    wrongInput();
                }
            }
            // Choice screen:
            System.out.println("Please enter the amount to convert.");
            double inputValue = -1.0;
            while (inputValue < 0.0){
                Scanner user2 = new Scanner(System.in);
                if (! user2.hasNextDouble()){
                    // Different type input check.
                    wrongInput();
                    continue;
                }
                inputValue = user2.nextDouble();
                if (inputValue < 0.0){
                    // negative double input check.
                    wrongInput();
                }
            }
            Coin mode;
            String resultOutput = "";
            Result result0 = null;
            if (coinChoice == 2){
                // User chose 2.
                mode = InputFactory.coinType(Coins.ILS);
                double result = mode.calculate(inputValue);
                result0 = new Result(result, "Dollars to Shekels.");
            }else if (coinChoice == 1)
            {
                //User chose 1.
                mode = InputFactory.coinType(Coins.USD);
                double result = mode.calculate(inputValue);
                result0 = new Result(result, "Shekels to Dollars.");
            }
            else
            {
                //User chose 3.
                mode = InputFactory.coinType(Coins.EUR);
                double result = mode.calculate(inputValue);
                result0 = new Result(result, "Euros to Shekels.");
            }
            //Result screen:
            resultOutput = result0.getResult() + " " + result0.getConversion();
            results.add(resultOutput);
            System.out.println("The result is " + resultOutput);
            answer = "A";
            System.out.println("Would you like to convert again? (Y/N)");
            while ((!answer.equals("y")) && (!answer.equals("n"))) {
                Scanner user3 = new Scanner(System.in);
                answer = user3.next().toLowerCase(Locale.ROOT);
                if ((!answer.equals("y")) && (!answer.equals("n"))) {
                    // Wrong input check.
                    wrongInput();
                }
            }
            }
        // End screen:
        System.out.println("Thanks for using our currency converter.");
        System.out.println("Your results are:");
        // Results list output.
        for (String result : results) {
            System.out.println(result);
        }
        // Writing to file.
        FileWriter writer = new FileWriter("output.txt");
        for(String str: results) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        }
    }
