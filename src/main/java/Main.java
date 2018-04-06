import java.util.Scanner;
import java.util.*;

public class Main {

    // It shows depend of the hour a greetings if it is morning, afternoon or night
    public static String Hour(){
        GregorianCalendar currTime = new GregorianCalendar();
        String date = "";
        double hour  = currTime.get(Calendar.HOUR_OF_DAY);
        if ((hour > 6.00) && (hour <=11.59)){
            date ="Good Morning";
        }
        else {
            if ((hour > 12) && (hour <=19.59)){
                date = "Good Afternoon";
            }
            else{
                date= "Good Night";
            }
        }
        return date;
    }

    // Main Method
    public static void main(String[] args) {
        // Slot machine object
        SlotMachine maq = new SlotMachine();
        // Keyboard input data
        Scanner input = new Scanner(System.in);
        int number;
        String x = " ";
        boolean word = false;

        do {
            try{
                // Game start ...
                System.out.println("Your current balance is $" + maq.getBalance() + ", Type your bet");
                number = input.nextInt();

                // The game ends if you press "0"
                if(number == 0){
                    break;
                }
                // if your bet is negative or is higher that your current balance, shows error
                while (number < 0 || number > maq.getBalance()) {
                    System.out.println("Error, Type again ...");
                    System.out.println("Your current balance is $" + maq.getBalance() + ", Type your bet");
                    number = input.nextInt();
                    // The game ends if you press "0"
                    if (number == 0) {
                        System.out.println("Thanks for playing, your final balance is: $" + maq.getBalance());
                        System.out.println(Main.Hour());
                        System.out.println(" ... Made by Ariel Vejar ...");
                        return;
                    }
                }
                maq.Bets(number);
                // End of game
                if(maq.getBalance() == 0){
                    System.out.println("Best luck next time you come to see us");
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("Error, Type again ...");
                input.nextLine();
                continue;
            }
        }while(true); // End of game pressing "0"

        // Credits
        System.out.println("Thanks for playing, your final balance is: $" + maq.getBalance());
        System.out.println(Main.Hour());
        System.out.println(" ... Made by Ariel Vejar ...");
    }
}
