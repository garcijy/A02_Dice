import java.util.Random;
import java.util.Scanner;

public class Craps
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();


        int die1 = 0;       //value of 1st die
        int die2 = 0;       //value of 2nd die
        int sum = 0;        //total of both
        int point = 0;      //the point if the first roll sets one
        boolean done = false;       // used to end the point loop
        String playAgain = "";      //Y or N

        //outer loop: play a new game while user says Y
        do
        {           //first roll: nextInt(6) gives 0 to 5, so adding 1 makes it 1 to 6
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            sum = die1 + die2;
            System.out.println("\nYou rolled " + die1 + " + " + die2 + " = " + sum);


            // case i: craps, game over w a loss
            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! You crapped out and lost.");
            }
            // case ii: game over with win
            else if (sum == 7 || sum == 11)
            {
                System.out.println("You win!");
            }
            // case iii: the sum becomes the point
            else
            {
                point = sum;
                System.out.println("The point is now " + point);


                // keep rolling until they make the point or roll a 7
                done = false;
                do {
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum + " ");

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        done = true;
                    } else if (sum == 7) {
                        System.out.println("Got a 7 and lost!");
                        done = true;
                    } else {
                        System.out.println("Trying for point");
                    }
                }
                while (!done);

                }
                do
                {
                    System.out.println("Play  again? [Y/N]: ");
                    playAgain = input.nextLine();
                    if (!playAgain.equalsIgnoreCase("Y") && !playAgain.equalsIgnoreCase("N"))
                    {
                        System.out.println("You have to enter Y or N");
                    }
                }
                while (!playAgain.equalsIgnoreCase("Y") && !playAgain.equalsIgnoreCase("N"));

            }
            while (playAgain.equalsIgnoreCase("Y"));     //Y= start new game

            System.out.println("\nThanks for playing!");
        }

    }