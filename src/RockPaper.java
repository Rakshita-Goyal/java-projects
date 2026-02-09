
import java.util.Random;
import java.util.Scanner;

import java.lang.*;


public class RockPaper {
    public static void main(String[] args) {

Scanner sc=new Scanner(System.in);
Random random=new Random();

        String[] choices = {"rock", "paper", "scissors"};
        System.out.println("Enter rock, paper or scissors:");

        String userChoice=sc.nextLine().toLowerCase();
        int randomIndex= random.nextInt(3);
        String computerChoice=choices[randomIndex];
System.out.println("computers choice"+computerChoice);
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a Tie!");
        }
        else if (userChoice.equals("rock") && computerChoice.equals("scissors") ||
                userChoice.equals("scissors") && computerChoice.equals("paper") ||
                userChoice.equals("paper") && computerChoice.equals("rock")) {
            System.out.println("You Win!");
        }
        else if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
            System.out.println("Computer Wins!");
        }

        else {
            System.out.println("Invalid input!");
        }
sc.close();
    }
}