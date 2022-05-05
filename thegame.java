import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class thegame {
    public static void main(String[] args) {
        Scanner uinput = new Scanner(System.in);

        // variable setups
        String[] charSt = { "HP", "MP", "STR", "DEF", "SC", "PER" };
        double[] charSk = { 0, 0, 0, 0, 0, 0 };
        double[] skMod = { 0, 0, 0, 0, 0, 0 };

        // variable setups ends
        // Home page

        System.out.println("Welcome!");
        System.out.println("1. New Game");
        System.out.println("2. Load");

        System.out.print("Choose Number to Continue: ");

        String emptyCheck = uinput.nextLine();
        System.out.println("");
        if (emptyCheck == "") {
            System.out.println("Please type in one of the choices");
        } else {
            int nuinput = Integer.parseInt(emptyCheck);

            if (nuinput == 1) { // Userinput 1 AKA New Game
                System.out.println("Starting new game");
                String CharName = "character";

                // Set Modifiers to 100%, so able to stack mods
                // Character Skill { HP, MP, STR, DEF, SC, PER } # initial
                for (int i = 0; i < charSk.length; i++) {
                    charSk[i] = 5;
                }
                // modifier { HP, MP, STR, DEF, SC, PER }
                for (int i = 0; i < skMod.length; i++) {
                    skMod[i] = 100;
                }

                while (true) { // character naming loop
                    System.out.print("Please type in your character name: ");
                    Scanner nameInput = new Scanner(System.in);

                    CharName = nameInput.nextLine();
                    System.out.println("");
                    System.out.println("Your character name is " + CharName);

                    System.out.println("Are you satisfied with the name?");
                    Scanner iConfirm = new Scanner(System.in);

                    if (iConfirm.nextLine().equals("yes")) {
                        System.out.println("");
                        break;
                    }
                }

                String nameInputcheck;
                String CharClassName = "none";
                while (true) {
                    while (true) {
                        // Class Choosing
                        System.out.println("Choose Character Class: ");
                        System.out.println("1. Knight ");
                        System.out.println("2. Mage ");
                        Scanner nameInput = new Scanner(System.in);
                        nameInputcheck = nameInput.nextLine();
                        System.out.println("");
                        // Knight
                        if (nameInputcheck.equals("1")) {
                            System.out.println("+20% STR");
                            System.out.println("+20% DEF");
                            System.out.print("Are you sure? (yes/no): ");
                            Scanner nameInputconfirm = new Scanner(System.in);
                            CharClassName = "Knight";
                            if (nameInputconfirm.nextLine().equals("yes")) {
                                System.out.println("");
                                break;
                            }
                            // Mage
                        } else if (nameInputcheck.equals("2")) {
                            System.out.println("+20% MP");
                            System.out.println("+20% SC");
                            System.out.print("Are you sure? (yes/no): ");
                            Scanner nameInputconfirm = new Scanner(System.in);
                            CharClassName = "Mage";
                            if (nameInputconfirm.nextLine().equals("yes")) {
                                System.out.println("");
                                break;
                            }
                        } else {
                            System.out.println("pls choose one of the classes.");
                        }
                    }

                    // Assigning the modifier
                    if (nameInputcheck.equals("1")) {
                        skMod[2] += 20;
                        skMod[3] += 20;
                        break;
                    } else if (nameInputcheck.equals("2")) {
                        skMod[1] += 20;
                        skMod[4] += 20;
                        break;
                    } else {

                    }
                }

                // Allocatable skill point rolling mechanism
                int roll = 0;
                while (true) {
                    roll = (int) (Math.random() * ((20 - 1) + 1)) + 1;
                    System.out.println("Rolled sp is " + roll);
                    System.out.print("Are you satisfied with rolled sp? (yes/no): ");
                    Scanner rollconfirm = new Scanner(System.in);
                    if (rollconfirm.nextLine().equals("yes")) {
                        System.out.println("");
                        break;
                    }
                }
                while (true) {
                    int[] aPoints = { 0, 0, 0, 0, 0, 0 };

                    while (true) {
                        System.out.println(
                                "________________________________________________________________________________________________________________________________");
                        String titleFormat = "%-20s %-20s %-20s %-20s %-20s";
                        System.out.format(titleFormat, "", "", "Character Stats", "", "");
                        System.out.println("");
                        String charFormat = "%-20s %-20s";
                        System.out.format(charFormat, "Name: " + CharName, "Class: " + CharClassName);
                        System.out.println("");
                        System.out.println(
                                "________________________________________________________________________________________________________________________________");
                        String statFormat = "|| %-20s || %-20s || %-20s || %-20s || %-20s";
                        System.out.format(statFormat, "Name", "Points", "Modifiers", "Total Points", "Allocated");
                        System.out.println("");
                        for (int i = 0; i < charSk.length; i++) {
                            System.out.format(statFormat, charSt[i], charSk[i], "%" + (skMod[i] - 100),
                                    (((charSk[i] + aPoints[i]) / 100) * skMod[i]), "+" + aPoints[i]);
                            System.out.println("");
                        }
                        System.out.println("Current Allocatable SP: " + roll);
                        System.out.println("1. Allocate SP Points");
                        System.out.println("2. Continue");
                        Scanner alcon = new Scanner(System.in);
                        if (alcon.nextLine().equals("1")) {
                            System.out.println("");
                            while (true) {
                                String alsure = "not";
                                System.out.println("Choose One of the Following to change");
                                for (int i = 0; i < charSk.length; i++) {
                                    System.out.println((i + 1) + ". " + charSt[i] + " " + charSk[i]);
                                }
                                Integer allocateds = 0;
                                Scanner allocate = new Scanner(System.in);
                                allocateds = allocate.nextInt();
                                if (allocateds == 1 || allocateds == 2 || allocateds == 3
                                        || allocateds == 4 || allocateds == 5 || allocateds == 6) {
                                    while (true) {
                                        String indecsure = "not";
                                        System.out.println("1. increase");
                                        System.out.println("2. decrease");
                                        String indecvar = "";
                                        Scanner indec = new Scanner(System.in);
                                        indecvar = indec.nextLine();
                                        System.out.println("");
                                        if (indecvar.equals("1") || indecvar.equals("2")) {
                                            while (true) {
                                                System.out.println("by how much?");
                                                Scanner howmuch = new Scanner(System.in);
                                                Integer hmvar = 0;
                                                hmvar = howmuch.nextInt();
                                                if (indecvar.equals("1")) {
                                                    System.out.println(charSt[allocateds - 1] + " Skill points:"
                                                            + charSk[allocateds - 1] + " allocated:"
                                                            + aPoints[allocateds - 1]
                                                            + " total:"
                                                            + (charSk[allocateds - 1] + aPoints[allocateds - 1]));
                                                    System.out.println(
                                                            "are you sure you want to increase "
                                                                    + charSt[allocateds - 1]
                                                                    + " by " + hmvar + "?");
                                                } else if (indecvar.equals("2")) {
                                                    System.out.println(charSt[allocateds - 1] + " Skill points:"
                                                            + charSk[allocateds - 1] + " allocated:"
                                                            + aPoints[allocateds - 1]
                                                            + " total:"
                                                            + (charSk[allocateds - 1] + aPoints[allocateds - 1]));
                                                    System.out.println(
                                                            "are you sure you want to decrease "
                                                                    + charSt[allocateds - 1]
                                                                    + " by " + hmvar + "?");
                                                }
                                                Scanner usure = new Scanner(System.in);
                                                if (usure.nextLine().equals("yes")) {
                                                    System.out.println("");
                                                    if (indecvar.equals("1") && hmvar > 0 && hmvar <= roll) {
                                                        aPoints[allocateds - 1] = aPoints[allocateds - 1] + hmvar;
                                                        roll = roll - hmvar;
                                                        indecsure = "sure";
                                                        break;
                                                    } else if (indecvar.equals("2") && hmvar > 0
                                                            && hmvar <= aPoints[allocateds - 1]) {
                                                        aPoints[allocateds - 1] = aPoints[allocateds - 1] - hmvar;
                                                        roll = roll + hmvar;
                                                        indecsure = "sure";
                                                        break;
                                                    } else if (indecvar.equals("1") && hmvar > roll) {
                                                        System.out.println(
                                                                "You exceeded your available allocatable points");
                                                    } else {
                                                        System.out.println(
                                                                "You removed more points than what you allocated");
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            System.out.println("please choose one of the options");
                                        }
                                        if (indecsure.equals("sure")) {
                                            alsure = "sure";
                                            break;
                                        } else {
                                        }
                                    }
                                } else {
                                    System.out.println("please choose one of the following options");
                                }
                                if (alsure.equals("sure")) {
                                    break;
                                } else {
                                }
                            }

                        } else if (alcon.nextLine().equals("2")) {
                            System.out.println("");
                            break;
                        } else {
                            System.out.println("please choose one of the following");
                        }

                    }

                    System.out.println("are you sure you want to continue? yes/no");
                    Scanner cont = new Scanner(System.in);
                    if (cont.nextLine().equals("yes")) {
                        System.out.println("");
                        break;
                    } else {

                    }

                }
            } else if (nuinput == 2) { // Userinput 2 AKA load
                System.out.println("Load saved games amongus");
            }

            // Battle System

            String battleInput;
            String battleInputTwo;
            String battleInputThree;
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
                Scanner battleInputConfirm = new Scanner(System.in);
                battleInput = battleInputConfirm.nextLine();
    
                if (battleInput.equals("1")) {
                    System.out.println("weapons equipped!");
                } else if (battleInput.equals("2")) {
                    System.out.println("Please equip your weapon");
    
                }
                System.out.println("Do you want to use consumeable? ");
                System.out.println("1. Yes ");
                System.out.println("2. No ");
                Scanner battleInputConfirmTwo = new Scanner(System.in);
                battleInputTwo = battleInputConfirmTwo.nextLine();
    
                if (battleInputTwo.equals("1")) {
                    System.out.println("Pick one ");
                    System.out.println(Arrays.toString(consumeable));
                    Scanner battleConsume = new Scanner(System.in);
                    battleInputThree = battleConsume.nextLine();
                    if(battleInputThree == "estusflask" || battleInputThree == "raysoflight" || battleInputThree == "buffalodrill" || battleInputThree == "filosofistone"){
                        System.out.print("consumeable used!");
                    };
                    
                    
                    
                } else if (battleInputTwo.equals("2")) {
                    
                    System.out.println("No consumeable used! ");
                }
    
    
    
    
            }

            }

            // end of load

            // start of story <==== increasing step / checking for new maps
            // #code

            // start check story scene
            // #code
            // end story scene

            // start check battling system
            // #code
            // end battling

            // end of story
            // ps inventory stuff or any stats stuff go to line 25 -> 30 ish
        }
    }
}