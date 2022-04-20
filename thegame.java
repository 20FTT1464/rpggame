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
        String CharName = "character";

        // Set Modifiers to 100%, so able to stack mods
        // Character Skill { HP, MP, STR, DEF, SC } # initial
        int[] charSk = {5, 5, 5, 5, 5};
        // modifier { HP, MP, STR, DEF, SC }
        int[] skMod = {100, 100, 100, 100, 100};

        while (true) { // character naming loop
            System.out.print("Please type in your character name: ");
            Scanner nameInput = new Scanner(System.in);

            CharName = nameInput.nextLine();
            System.out.println("Your character name is " + CharName);

            System.out.println("Are you satisfied with the name?");
            Scanner iConfirm = new Scanner(System.in);
            
            if(iConfirm.nextLine().equals("yes")){
                break;
            } 
        }

        String nameInputcheck;
        while (true) {
            String wrong = "";
            if (wrong.equals("wrong")) {
                System.out.println("pls choose one of the classes.");    
            }
            System.out.println("Choose Character Class: ");
            System.out.println("1. Knight ");
            System.out.println("2. Mage ");
            Scanner nameInput = new Scanner(System.in);
            nameInputcheck = nameInput.nextLine(); 
            if (nameInputcheck.equals("1")) {
                System.out.println("+20% STR");
                System.out.println("+20% DEF");
                skMod[2] += 20;
                skMod[3] += 20;
                break;
            } else if (nameInputcheck.equals("2")) {
                System.out.println("+20% STR");
                System.out.println("+20% DEF");
                skMod[1] += 20;
                skMod[4] += 20;
                break;
            } else {
                wrong = "wrong";
            }
        }


        
        

    }

    static void loadGame() {
        System.out.println("Load saved games amongus");
    }
    public static void main(String[] args) {
        gameHomepage();

    }
}