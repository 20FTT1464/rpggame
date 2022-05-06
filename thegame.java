import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

class thegame {
    public static void main(String[] args) {
        Scanner uinput = new Scanner(System.in);

        // variable setups
        Integer CharLVL = 0;
        Integer AvailableSP = 0;
        String CharName = "character";
        String CharClassName = "none";
        Integer coins = 0;
        String [] enemy = {"thieves", "bandit", "goblin"};
        String[] charSt = { "HP", "MP", "STR", "DEF", "SC", "PER" };
        double[] charSk = { 0, 0, 0, 0, 0, 0 };
        double[] skMod = { 0, 0, 0, 0, 0, 0 };
        int[] aPoints = { 0, 0, 0, 0, 0, 0 };
        double healthbar = 0;
        double manabar = 0;
        double strength = 0;
        double defence = 0;
        Integer gameprogress = 0;
        String[] Inventory = {};
        String[] skillknight = {"Extra Slash", "Circular Slash", "Stun"};
        Integer[] skdamage = { 2, 1, 1 };
        Integer[] skusages = { 30, 80, 40 };

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
                coins = 50;
                CharLVL = 1;

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
                        String alconstr = alcon.nextLine();
                        if (alconstr.equals("1")) {
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
                                                            + charSk[allocateds - 1] + " Allocated:"
                                                            + aPoints[allocateds - 1]
                                                            + " total:"
                                                            + (charSk[allocateds - 1] + aPoints[allocateds - 1]));
                                                    System.out.println(
                                                            "are you sure you want to increase "
                                                                    + charSt[allocateds - 1]
                                                                    + " by " + hmvar + "?");
                                                } else if (indecvar.equals("2")) {
                                                    System.out.println(charSt[allocateds - 1] + " Skill points:"
                                                            + charSk[allocateds - 1] + " Allocated:"
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

                        } else if (alconstr.equals("2")) {
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
                        AvailableSP += roll;
                        break;
                    } else {

                    }

                }
            } else if (nuinput == 2) { // Userinput 2 AKA load
                System.out.println("Load saved games amongus");
            }

            // end of load
            Boolean load = false;
            while (true) {
                // start of story <==== increasing step / checking for new maps
                // #code
                gameprogress++;
                Integer progresscounter = gameprogress / 10;
                double isbattle = Math.random() * 100;
                Integer battledecide = (int) isbattle;

                if (battledecide < 69) { // 69 percent to trigger battle
                    // start check battling system
                   
                    double enemyQty = Math.random()*3;
                    System.out.println(enemyQty);
                    Integer enemyQtyint = (int)enemyQty;

                    String [] currentEnemy = {};
                    Integer [] monsterMaxHP = {};
                    Integer [] monsterCurHP = {};

                    for (int i = 0; i < enemyQty-1; i++) {
                        double minMonsterHp = ((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100) - ((((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100)/100)*10);
                        double maxMonsterHp = ((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100) + ((((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100)/100)*10);
                        double enQty = Math.random()*3;
                        Integer enQtyint = (int)enQty;
                        double EnmHP = Math.random()*(maxMonsterHp-minMonsterHp);
                        Integer EnmHPint = (int)EnmHP;
                        currentEnemy = new String[enemyQtyint];
                        monsterMaxHP = new Integer[enemyQtyint];
                        monsterCurHP = new Integer[enemyQtyint];
                        currentEnemy[i]=enemy[enQtyint];
                        monsterMaxHP[i]=(int)(minMonsterHp+EnmHP);
                        monsterCurHP[i]=(int)(minMonsterHp+EnmHP);
                    }
                    while (true) {
                        double totalhealth = (((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100;
                        double totalmana = (((charSk[1] + aPoints[1]) / 100) * skMod[1]) * 100;
                        double totalstrength = (((charSk[2] + aPoints[2]) / 100) * skMod[2]) * 100;
                        double totaldefence = (((charSk[3] + aPoints[3]) / 100) * skMod[3]) * 100;
                        if (load == true) {
                            // healthbar = loadvaluehere;
                        } else {
                            healthbar = totalhealth;
                            manabar = totalmana;
                            strength = totalstrength;
                            defence = totaldefence;
                        }
                        Double moduluscalhealth = (totalhealth / 100) * 10;
                        Double moduluscalmana = (totalmana / 100) * 10;
                        Double moduluscalstrength = (totalstrength / 100) * 10;
                        Double moduluscaldefence = (totaldefence / 100) * 10;
                        System.out.print("HP ||");
                        for (int i = 0; i < totalhealth; i++) {
                            if (i % moduluscalhealth == 0 && i < healthbar) {
                                System.out.print("=");
                            } else if (i % moduluscalhealth == 0 && i > healthbar) {
                                System.out.print("-");
                            }
                        }
                        System.out.println("|| " + healthbar + "/" + totalhealth);
                        System.out.print("MP ||");
                        for (int i = 0; i < totalmana; i++) {
                            if (i % moduluscalmana == 0 && i < manabar) {
                                System.out.print("=");
                            } else if (i % moduluscalmana == 0 && i > manabar) {
                                System.out.print("-");
                            }
                        }
                        System.out.println("|| " + manabar + "/" + totalmana);
                        System.out.println(
                                "________________________________________________________________________________________________________________________________");
                        System.out.println("Options");
                        System.out.println("1. Attack");
                        System.out.println("2. Skill");
                        System.out.println("3. Equip");
                        System.out.println("4. Consume");
                        System.out.println("5. Run");
                        Scanner bsscan = new Scanner(System.in);
                        String bsscanstr = bsscan.nextLine();
                        if (bsscanstr.equals("1")) {
                            // fight
                            for (int i=0; i<currentEnemy.length; i++){
                                System.out.println(currentEnemy[i] + " " + monsterCurHP[i] + "/ " + monsterMaxHP[i]);
                            }
                            Scanner attack = new Scanner(System.in);
                            Integer attackEnm = attack.nextInt();
                            if (attackEnm==1){
                                (monsterCurHP[attackEnm-1]) -= ((int)totalstrength);
                            } else if (attackEnm==2){
                                (monsterCurHP[attackEnm-1]) -= ((int)totalstrength);
                            } else if (attackEnm==3){
                                (monsterCurHP[attackEnm-1]) -= ((int)totalstrength);
                            } else {

                            }

                        } else if (bsscanstr.equals("2")) {
                            // skill

                        } else if (bsscanstr.equals("3")) {
                            // equip
                            
                            

                            System.out.println("what would you like to equip?");
                            System.out.println( "1.armor");
                            System.out.println("2.weapon");
                            
                            Scanner equip = new Scanner(System.in);
                            String  quip  = equip.nextLine();
                            String  mor  = "";

                                if ( equip.equals("1")){
                                    System.out.println("which armor would you like to equip?");
                                    System.out.println( "1.knightarmor");
                                    System.out.println("2.robe");

                                    Scanner armor = new Scanner(System.in);
                                    mor  = armor.nextLine();
                                }
                                else if (equip.equals("2")){
                                    System.out.println("which weapon would you like to equip?");
                                    System.out.println( "1.sword");
                                    System.out.println("2.staff");

                                    Scanner weapon = new Scanner(System.in);
                                    String  pon  = weapon.nextLine();
                                }
                                else{
                                    System.out.println("you haven't equip anything");
                                }

                                
                                


                            

                            

                            System.out.println("select a material rank");
                            System.out.println( "1.basic");
                            System.out.println("2.standard");
                            System.out.println("3.elite");

                            Scanner rank = new Scanner(System.in);
                            String  ank = rank.nextLine();

                            if ( rank.equals(1)){
                                System.out.println(" you have selected basic"); 
                            }
                            else if( rank.equals(2)){
                                System.out.println(" you have selected standard");
                            }
                            else if( rank.equals(3)){
                                System.out.println(" you have selected elite");
                            }
                            else{
                                System.out.println(" you haven't selected material rank");
                            }

                            //armor/knight armor/basic/ suiiii
                            if ( quip.equals("1") && mor.equals("1") && ank.equals("1") ){
                                defence*=30;
                                defence/=100;
                                 
                            //armor/knight armor/standard
                            }else if( quip.equals("1") && mor.equals("1") && ank.equals("2")){
                                defence*=50;
                                defence/=100;
                            
                                //armor/knight armor/elite  
                            }else if( quip.equals("1") && mor.equals("1") && ank.equals("3")){
                                defence*=70;
                                defence/=100;
                            
                                //armor/robe/basic    
                            }else if( quip.equals("1") && mor.equals("2") && ank.equals("1")){
                                defence*=20;
                                defence/=100;
                                manabar*=10;
                                manabar/=100;
                            
                                //armor/robe/stnadard    
                            }else if( quip.equals("1") && mor.equals("2") && ank.equals("2")){
                                defence*=40;
                                defence/=100;
                                manabar*=30;
                                manabar/=100;
                            
                                //armor/robe/elite    
                            }else if( quip.equals("1") && mor.equals("2") && ank.equals("3")){
                                defence*=60;
                                defence/=100;
                                manabar*=50;
                                manabar/=100;
                                
                                //weapon/sword/basic    
                            }else if( quip.equals("2") && mor.equals("1") && ank.equals("1")){
                                
                            
                                //weapon/sword/standard    
                            }else if( quip.equals("2") && mor.equals("1") && ank.equals("2")){
                            //weapon/sword/elite    
                            }else if( quip.equals("2") && mor.equals("1") && ank.equals("3")){
                            //weapon/staff/basic    
                            }else if( quip.equals("2") && mor.equals("2") && ank.equals("1")){
                            //weapon/staff/standard    
                            }else if( quip.equals("2") && mor.equals("2") && ank.equals("2")){
                            //weapon/staff/elite    
                            }else if( quip.equals("2") && mor.equals("2") && ank.equals("3")){
                            }     
                            






                            

                        } else if (bsscanstr.equals("4")) {
                            // consume here

                            String cons = "";
                            while (true) {

                                Scanner consume = new Scanner(System.in);

                                cons = consume.nextLine();

                                System.out.println("what do you want to consume");
                                System.out.println("1.potion (mp)");
                                System.out.println("2.food (hp)");
                                System.out.println("3.power up (str)");

                                if (cons.equals("1")) {
                                    System.out.println("you have selected potion");
                                    break;
                                } else if (cons.equals("2")) {
                                    System.out.println("you have selected food");
                                    break;
                                } else if (cons.equals("3")) {
                                    System.out.println("you have selected power up");
                                    break;
                                } else {
                                    System.out.println("Please select an item");
                                }

                            }

                            System.out.println("select a grade");
                            System.out.println("1.low");
                            System.out.println("2.med");
                            System.out.println("3.high");

                            Scanner grade = new Scanner(System.in);

                            String grd = grade.nextLine();

                            if (grd.equals("1")) {
                                System.out.println("low grade item has been selected");
                            } else if (grd.equals("2")) {
                                System.out.println("medium grade item has been selected");
                            } else if (grd.equals("3")) {
                                System.out.println("high grade item has been selected");
                            } else {
                                System.out.println("choose 1,2 or 3 only");
                            }

                            System.out.println("are you sure you want to consume?");
                            System.out.println("yes");
                            System.out.println("no");

                            Scanner conscon = new Scanner(System.in);

                            String conscu = conscon.nextLine();
                            while (conscu.equals("yes")) {

                            }

                            if (cons.equals("1") && grd.equals("1")) {
                                manabar += 30;
                                System.out.println("you current mana is" + manabar);
                            }

                            else if (cons.equals("1") && grd.equals("2")) {
                                manabar += 45;
                                System.out.println("you current mana is" + manabar);
                            } else if (cons.equals("1") && grd.equals("3")) {
                                manabar += 60;
                                System.out.println("you current mana is" + manabar);
                            } else if (cons.equals("2") && grd.equals("1")) {
                                healthbar += 30;
                                System.out.println("you current hp is" + healthbar);
                            } else if (cons.equals("2") && grd.equals("2")) {
                                healthbar += 45;
                                System.out.println("you current hp is" + healthbar);
                            } else if (cons.equals("2") && grd.equals("3")) {
                                healthbar += 60;
                                System.out.println("you current hp is" + totalhealth);
                            } else if (cons.equals("3") && grd.equals("1")) {
                                totalstrength += 30;
                                System.out.println("you current hp is" + totalstrength);
                            } else if (cons.equals("3") && grd.equals("2")) {
                                totalstrength += 45;
                                System.out.println("you current hp is" + totalstrength);
                            } else if (cons.equals("3") && grd.equals("3")) {
                                totalstrength += 60;
                                System.out.println("you current hp is" + totalstrength);
                            }

                            else {
                                System.out.println("nothing has increase");
                            }
                        } else if (bsscanstr.equals("5")) {
                            // run
                        }

                        break;
                    }
                    // end battling
                } else {
                    if (gameprogress % 10 == 0) {
                        // story trigger
                    } else {
                        System.out.println("Name: " + CharName);
                        System.out.println("Level: " + CharLVL);
                        // exp bar go here later
                        System.out.println("Coins: " + coins + " g");
                        System.out.println("");
                        System.out.println("Progress:");

                        System.out.print("||");
                        for (int i = 0; i <= 10; i++) {
                            if (i <= progresscounter) {
                                System.out.print("X");
                            } else if (i > progresscounter) {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("|| " + progresscounter + "/10");
                        System.out.println("");

                        System.out.println(
                                "________________________________________________________________________________________________________________________________");
                        System.out.println("1. Continue");
                        System.out.println("2. Save");
                        System.out.println("3.Load");
                        System.out.println("4. Level & Stats");
                        System.out.println("5. Learn Skill");
                        System.out.println("6. Inventory");
                        System.out.println("7.Trading");

                        Scanner progressmenu = new Scanner(System.in);
                        String progressmenuchecker = progressmenu.nextLine();

                        if (progressmenuchecker.equals("1")) {
                            System.out.println(" ");
                        } else if (progressmenuchecker.equals("2")) {
                            // SAVE
                        } else if (progressmenuchecker.equals("3")) {
                            // LOAD
                        } else if (progressmenuchecker.equals("4")) {
                            // LEVEL & STATS
                        } else if (progressmenuchecker.equals("5")) {
                            // LEARN SKILL
                            System.out.println("Learn Skill");
                            

                        } else if (progressmenuchecker.equals("6")) {
                            // INVENTORY
                            for (int i = 0; i < Inventory.length; i++) {
                                System.out.println(Inventory[i]);
                            }
                            System.out.println("");
                            System.out.print("press enter to exit:");
                            Scanner invout = new Scanner(System.in);

                        } else if (progressmenuchecker.equals("7")) {
                            // TRADING
                        }

                    }
                }

                // start check story scene
                // #code
                // end story scene
            }
            // end of story
            // ps inventory stuff or any stats stuff go to line 25 -> 30 ish
        }
    }
}