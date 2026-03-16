import java.util.Scanner;
import java.util.Random;

public class CrapsGame
{
    public static void main()
    {
        Random rnd = new Random();

        int die1;
        int die2;
        int crapsRoll;
        int point;
        int rollCount;
        String playAgainYN;

        boolean win = false;
        boolean finish = false;
        boolean gotplayAgain = false;
        boolean playAgain =false;

        Scanner in = new Scanner(System.in);

        do {
            rollCount = 1;
            playAgainYN = "";
            win = false;
            finish = false;
            gotplayAgain = false;
            playAgain = false;

            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;

            System.out.println("CRAPS GAME");
            System.out.println("______________________\n");
            System.out.println("Roll " + rollCount);
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + crapsRoll);

            if (crapsRoll==2 || crapsRoll==3 || crapsRoll==12) {
                System.out.println("Craps! You Lose! ");
                win = false;
                finish = true;
            } else if (crapsRoll==7 || crapsRoll==11){
                System.out.println("Natural! You Win!");
                win = true;
                finish = true;
            } else
            {
                rollCount++;
                point = crapsRoll;
                System.out.println("Trying for point: " + point);
                do{
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;

                    System.out.println("Roll " + rollCount);
                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + crapsRoll);

                    if (crapsRoll==7)
                    {
                        System.out.println("Got a seven and lost! ");
                        win = false;
                        finish = true;
                    }
                    else if(crapsRoll==point)
                    {
                        System.out.println("Made point and won!");
                        win = true;
                        finish = true;
                    }
                    else
                    {
                        rollCount++;
                        System.out.println("Trying for point: " + point);
                    }
                }while(!finish);
            }
            do{
                System.out.print("\nPlay Again? [Y/N]: ");
                playAgainYN = in.nextLine();
                playAgainYN = playAgainYN.toUpperCase();
                if (playAgainYN.equals("Y") || playAgainYN.equals("N"))
                {
                    gotplayAgain = true;
                    if (playAgainYN.equals("Y"))
                        playAgain = true;
                    else
                        System.exit(0);
                }
                else
                    System.out.println("Invalid input. Try again.");
            } while(!gotplayAgain);
        } while (playAgain);
    }
}