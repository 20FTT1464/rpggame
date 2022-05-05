import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class battlesystem {

    public static void main(String[] args) {
        String userInput;
        String userInputTwo;
        String[] consumeable = { "estusflask", "raysoflight", "buffalodrill", "filosofistone" };
        String[] enemy = { "bandits", "dragon", "bear", "thieves", "knights", "berzerker", "brutes" };
        String[] weapon = { "blade", "sword", "dagger", "hammer" };
        int randEnemy = (int) (Math.random() * 7);
        String test = enemy[randEnemy];
        System.out.println(enemy[randEnemy]);

        if (test == enemy[randEnemy]) {

            System.out.println("Do you want to equip your weapon? ");
            System.out.println("1. Yes ");
            System.out.println("2. No ");
            Scanner userInputConfirm = new Scanner(System.in);
            userInput = userInputConfirm.nextLine();

            if (userInput.equals("1")) {
                System.out.println("weapons equipped!");
            } else if (userInput.equals("2")) {
                System.out.println("Please equip your weapon");

            }
            System.out.println("Do you want to use consumeable? ");
            System.out.println("1. Yes ");
            System.out.println("2. No ");
            Scanner userInputConfirmTwo = new Scanner(System.in);
            userInputTwo = userInputConfirmTwo.nextLine();

            if (userInputTwo.equals("1")) {
                System.out.println("Consumeable used! ");
                System.out.println(Arrays.toString(consumeable));
            } else if (userInputTwo.equals("2")) {
                

            }

        }
    }
}