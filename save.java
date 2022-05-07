import java.io.*;
import java.util.Scanner;

public class save {
    public static void main(String[] args) throws IOException {

        Integer CharLVL = 0; // save
        Integer CharEXP = 0; // save
        Integer AvailableSP = 0; // save
        String CharName = "character"; // save
        String CharClassName = "none"; // save
        Integer coins = 0; // save
        String[] enemy = { "thieves", "bandit", "goblin" };
        String[] charSt = { "HP", "MP", "STR", "DEF" };
        double[] charSk = { 0, 0, 0, 0 }; // save
        double[] skMod = { 0, 0, 0, 0 }; // save
        int[] aPoints = { 0, 0, 0, 0 }; // save
        double healthbar = 0;
        double manabar = 0;
        double strength = 0;
        double defence = 0;
        Integer gameprogress = 0; // save
        Integer gameprogresscounter = 0; // save

        // String[] armory1 = { "knight armor basic", "knight armor standard", "knight
        // armor elite" };
        Integer knightarbasic = 0; // save
        Integer knightarstandard = 0; // save
        Integer knightarelite = 0; // save
        // String[] armory2 = { "robe basic", "robe standard", "robe elite" };
        Integer robebasic = 0; // save
        Integer robestandard = 0; // save
        Integer robeelite = 0; // save
        // String[] weaponry1 = { "swordbasic", "swordstandard", "swordelite" };
        Integer swordbasic = 0; // save
        Integer swordstandard = 0; // save
        Integer swordelite = 0; // save
        // String[] weaponry2 = { "staffbasic", "staffstandard", "staffelite" };
        Integer staffbasic = 0; // save
        Integer staffstandard = 0; // save
        Integer staffelite = 0; // save

        // String[] potions = { "lowpotion", "midpotion", "highpotion" };
        Integer lowpot = 0; // save
        Integer midpot = 0; // save
        Integer highpot = 0; // save
        // String[] foods = { "lowfood", "midfood", "highfood" };
        Integer lowfood = 0; // save
        Integer midfood = 0; // save
        Integer highfood = 0; // save
        // String[] powerups = { "lowpowup", "midpowup", "highpowp" };
        Integer lowpow = 0; // save
        Integer midpow = 0; // save
        Integer highpow = 0; // save
        Integer SkillMovePoint = 0;
        // skill knight
        String[] skillknight = { "Extra Slash", "Circular Slash" };
        Integer[] skillknightstatus = { 0, 0 }; // 0 = locked || 1 = unlocked // save
        Integer[] skusages = { 30, 80 };

        // skill mage
        String[] skillmage = { "Extra balls", "Balls All Around Me" };
        Integer[] skillmagestatus = { 0, 0 }; // 0 = locked || 1 = unlocked // save
        Integer[] smusages = { 30, 80 };

        // save
        String[] save = {"CharLVL", "CharEXP", "AvailableSP", "CharName", "CharClassName", "coins", "charSk", "skMod", "aPoints", "gameprogress", "gameprogresscounter",
        "knightarbasic", "knightarstandard", "knightarelite", "robebasic", "robestandard", "robeelite", "swordbasic", "swordstandard", "swordelite", "staffbasic",
        "staffstandard", "staffelite", "lowpot", "midpot", "highpot", "lowfood", "midfood", "highfood", "lowpow", "midpow", "highpow", "skillknight", "skillknightstatus",
        "skusages", "skillmage", "skillmagestatus", "smusages"};
        
        while (true) {
            System.out.print("Please enter slot name: ");
            Scanner gs = new Scanner(System.in);

            File file = new File(gs.nextLine() + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < save.length; i++) {
                writer.write(save[i] + System.lineSeparator());
            }
            writer.close();

            if (file.exists()) {
                System.out.println("Do you want to overwrite?");
                Scanner ovcon = new Scanner(System.in);
                String line = ovcon.nextLine();
                    if (line.equals("yes")) {
                        System.out.println("Enter description: ");
                        Scanner ercon = new Scanner(System.in);
                        String ayat = ercon.nextLine();
                        break;
                    } else if (line.equals("no")) {
                    }
            }
            
            String[] load;
            Scanner fileReader = new Scanner(file);
            load = new String[3]; 
            int loader = 0;
            while (fileReader.hasNextLine()) {
              load[loader] = fileReader.nextLine();
              loader++;
            }

            System.out.println("loader 1" + " " + load[0]);
            System.out.println("loader 2" + " " + load[1]);
            System.out.println("loader 3" + " " + load[2]);
            fileReader.close();
        }
    }
}