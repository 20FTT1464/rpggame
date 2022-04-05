import java.util.Scanner;

class thegame {

    // Homepage for the game
    static void gameHomepage() {
        Scanner uinput = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("1. New Game");
        System.out.println("2. Load");
        
        System.out.print("Choose Number to Continue: ");

        String emptyCheck = uinput.nextLine();
        if (emptyCheck == "") {
            System.out.println("Please type in one of the choices");
        } else {
            int nuinput = Integer.parseInt(emptyCheck);
            
            if (nuinput == 1) { // Userinput 1 AKA New Game
                newGame();
            } else if (nuinput == 2) { // Userinput 2 AKA load
                loadGame();
            } else {
                System.out.println(nuinput + " is not in the choices");
            }
        }

    }

    static void newGame() {
        System.out.println("Starting new game");
        String nConfirm = "no";

        while (nConfirm != "yes") {
            System.out.print("Please type in your character name: ");
            Scanner nameInput = new Scanner(System.in);

            String CharName = nameInput.nextLine();
            System.out.println("Your character name is " + CharName);

            System.out.println("Do Want to confirm and continue? yes / no");
            Scanner iConfirm = new Scanner(System.in);
            nConfirm = iConfirm.nextLine();

        } 
        
    }

    static void loadGame() {
        System.out.println("Load saved games amongus");
    }
    public static void main(String[] args) {
        gameHomepage();

    }
}