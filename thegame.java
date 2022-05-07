import java.util.Scanner;

class thegame {
    public static void main(String[] args) {
        Scanner uinput = new Scanner(System.in);

        // variable setups
        boolean gameover = false;
        Integer CharLVL = 0; // save
        Integer CharEXP = 0; // save
        Integer AvailableSP = 0; // save
        String CharName = "character"; // save
        String CharClassName = "none"; // save
        Integer coins = 0; // save
        String[] enemy = { "thieves", "bandit", "goblin" };
        String[] charSt = { "HP", "MP", "STR", "DEF", "SC", "PER" };
        double[] charSk = { 0, 0, 0, 0, 0, 0 }; // save
        double[] skMod = { 0, 0, 0, 0, 0, 0 }; // save
        int[] aPoints = { 0, 0, 0, 0, 0, 0 }; // save
        double healthbar = 0;
        double manabar = 0;
        double strength = 0;
        double defence = 0;
        Integer gameprogress = 0; // save
        Integer gameprogresscounter = 0; // save
        String[] Inventory = new String[50]; // save

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
        Integer[] skdamage = { 2, 1 };
        Integer[] skusages = { 30, 80 };

        // skill mage
        String[] skillmage = { "Extra balls", "Balls All Around Me" };
        Integer[] skillmagestatus = { 0, 0 }; // 0 = locked || 1 = unlocked // save
        Integer[] smdamage = { 2, 1 };
        Integer[] smusages = { 30, 80 };

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
                        lowfood += 2;
                        lowpot += 2;
                        if (CharClassName.equals("Knight")) {
                            knightarbasic += 1;
                            swordbasic += 1;
                        } else if (CharClassName.equals("Mage")) {
                            robebasic += 1;
                            staffbasic += 1;
                        }
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
                if (gameover == true) {
                    break;
                }
                // start of story <==== increasing step / checking for new maps
                // #code
                gameprogress++;
                Integer progresscounter = gameprogress / 10;
                double isbattle = Math.random() * 100;
                Integer battledecide = (int) isbattle;

                Integer leveluptop = CharLVL * 100;
                if (CharEXP > leveluptop) {
                    CharLVL += 1;
                    CharEXP = CharEXP - leveluptop;
                    SkillMovePoint += 2;
                } else {

                }
                if (battledecide < 69) { // 69 percent to trigger battle
                    // start check battling system
                    double enemyQty = Math.random() * 3;
                    Integer enemyQtyint = (int) enemyQty;

                    String[] currentEnemy;
                    Integer[] monsterMaxHP;
                    Integer[] monsterCurHP;
                    double minMonsterHp = ((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100)
                            - ((((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100) / 100) * 10);
                    double maxMonsterHp = ((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100)
                            + ((((((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100) / 100) * 500);
                    double enQty = Math.random() * 3;
                    Integer enQtyint = (int) enQty;
                    double EnmHP = Math.random() * (maxMonsterHp - minMonsterHp);
                    Integer EnmHPint = (int) EnmHP;
                    currentEnemy = new String[enemyQtyint];
                    monsterMaxHP = new Integer[enemyQtyint];
                    monsterCurHP = new Integer[enemyQtyint];

                    for (int i = 0; i < enemyQty - 1; i++) {
                        currentEnemy[i] = enemy[enQtyint];
                        monsterMaxHP[i] = (int) (minMonsterHp + EnmHPint);
                        monsterCurHP[i] = (int) (minMonsterHp + EnmHPint);
                    }
                    while (true) {
                        boolean allowdamage = false;
                        if (healthbar < 0) {
                            gameover = true;
                        }
                        if (gameover == true) {
                            break;
                        }
                        double totalhealth = (((charSk[0] + aPoints[0]) / 100) * skMod[0]) * 100;
                        double totalmana = (((charSk[1] + aPoints[1]) / 100) * skMod[1]) * 100;
                        double totalstrength = (((charSk[2] + aPoints[2]) / 100) * skMod[2]) * 100;
                        double totaldefence = (((charSk[3] + aPoints[3]) / 100) * skMod[3]) * 100;
                        Integer enemydeathchecker = 0;
                        for (int i = 0; i < monsterCurHP.length; i++) {
                            if (monsterCurHP[i] < 0) {
                                enemydeathchecker++;
                            } else {
                                if (healthbar == 0) {
                                    healthbar = totalhealth;
                                    manabar = totalmana;
                                    strength = totalstrength;
                                    defence = totaldefence;
                                } else {

                                }

                            }
                        }

                        if (healthbar > totalhealth) {
                            healthbar = totalhealth;
                        } else if (manabar > totalmana) {
                            manabar = totalmana;
                        } else {

                        }

                        if (enemydeathchecker == currentEnemy.length) {
                            CharEXP += 10;
                            coins += 1;
                            break;
                        } else {
                            if (load == true) {
                                // healthbar = loadvaluehere;
                            } else {

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
                                allowdamage = true;
                                for (int i = 0; i < currentEnemy.length; i++) {
                                    if (monsterCurHP[i] > 0) {
                                        System.out.println((i + 1) + ". " + currentEnemy[i] + " " + monsterCurHP[i]
                                                + "/ " + monsterMaxHP[i]);
                                    } else {
                                        System.out.println((i + 1) + ". " + currentEnemy[i] + " Dead");
                                    }
                                }
                                Scanner attack = new Scanner(System.in);
                                Integer attackEnm = attack.nextInt();
                                if (attackEnm == 1) {
                                    (monsterCurHP[attackEnm - 1]) -= ((int) totalstrength);
                                } else if (attackEnm == 2) {
                                    (monsterCurHP[attackEnm - 1]) -= ((int) totalstrength);
                                } else if (attackEnm == 3) {
                                    (monsterCurHP[attackEnm - 1]) -= ((int) totalstrength);
                                } else {

                                }

                            } else if (bsscanstr.equals("2")) {
                                // skill
                                if (CharClassName.equals("Knight")) {
                                    for (int i = 0; i < skillknight.length; i++) {
                                        System.out.print((i + 1) + ". " + skillknight[i]);
                                        if (skillknightstatus[i] == 1) {
                                            System.out.println(" Usable");
                                        } else {
                                            System.out.println(" Locked");
                                        }
                                    }
                                } else if (CharClassName.equals("Mage")) {
                                    for (int i = 0; i < skillmage.length; i++) {
                                        System.out.print((i + 1) + ". " + skillmage[i]);
                                        if (skillmagestatus[i] == 1) {
                                            System.out.println(" Usable");
                                        } else {
                                            System.out.println(" Locked");
                                        }
                                    }
                                }
                                System.out.println("type exit to exit");
                                Scanner skilluse = new Scanner(System.in);
                                String skillus = skilluse.nextLine();

                                if (skillus.equals("1")) {
                                    if (CharClassName.equals("Knight")) {
                                        if (skillknightstatus[0] == 1) {
                                            for (int i = 0; i < currentEnemy.length; i++) {
                                                if (monsterCurHP[i] > 0) {
                                                    System.out.println(
                                                            (i + 1) + ". " + currentEnemy[i] + " " + monsterCurHP[i]
                                                                    + "/ " + monsterMaxHP[i]);
                                                } else {
                                                    System.out.println((i + 1) + ". " + currentEnemy[i] + " Dead");
                                                }
                                            }
                                            Scanner attack = new Scanner(System.in);
                                            Integer attackEnm = attack.nextInt();
                                            if (attackEnm == 1) {
                                                (monsterCurHP[attackEnm - 1]) -= (((int) totalstrength) / 100) * 120;
                                            } else if (attackEnm == 2) {
                                                (monsterCurHP[attackEnm - 1]) -= (((int) totalstrength) / 100) * 120;
                                            } else if (attackEnm == 3) {
                                                (monsterCurHP[attackEnm - 1]) -= (((int) totalstrength) / 100) * 120;
                                            } else {

                                            }
                                            manabar -= skusages[0];
                                            allowdamage = true;
                                        } else {
                                            System.out.println("Not Unlocked");
                                            break;
                                        }
                                    } else if (CharClassName.equals("Mage")) {
                                        if (skillmagestatus[0] == 1) {
                                            for (int i = 0; i < currentEnemy.length; i++) {
                                                if (monsterCurHP[i] > 0) {
                                                    System.out.println(
                                                            (i + 1) + ". " + currentEnemy[i] + " " + monsterCurHP[i]
                                                                    + "/ " + monsterMaxHP[i]);
                                                } else {
                                                    System.out.println((i + 1) + ". " + currentEnemy[i] + " Dead");
                                                }
                                            }
                                            Scanner attack = new Scanner(System.in);
                                            Integer attackEnm = attack.nextInt();
                                            if (attackEnm == 1) {
                                                (monsterCurHP[attackEnm - 1]) -= (((int) totalstrength) / 100) * 120;
                                            } else if (attackEnm == 2) {
                                                (monsterCurHP[attackEnm - 1]) -= (((int) totalstrength) / 100) * 120;
                                            } else if (attackEnm == 3) {
                                                (monsterCurHP[attackEnm - 1]) -= (((int) totalstrength) / 100) * 120;
                                            } else {

                                            }
                                            manabar -= smusages[0];
                                            allowdamage = true;
                                        } else {
                                            System.out.println("Not Unlocked");
                                            break;
                                        }
                                    }
                                } else if (skillus.equals("2")) {
                                    if (CharClassName.equals("Knight")) {
                                        if(skillknightstatus[1]==1){
                                            for (int i = 0; i < monsterCurHP.length; i++) {
                                                (monsterCurHP[i]) -= (((int) totalstrength) / 100) * 150;
                                            }
                                            manabar -= skusages[1];
                                            allowdamage = true;
                                        } else {
                                            System.out.println("Not Unlocked");
                                            break;
                                        }
                                    } else if (CharClassName.equals("Mage")) {
                                        if(skillknightstatus[1]==1){
                                            for (int i = 0; i < monsterCurHP.length; i++) {
                                                (monsterCurHP[i]) -= (((int) totalstrength) / 100) * 150;
                                            }
                                            manabar -= smusages[1];
                                            allowdamage = true;
                                        } else {
                                            System.out.println("Not Unlocked");
                                            break;
                                        }
                                    }
                                } else if (skillus.equals("exit")) {
                                    break;
                                }

                            } else if (bsscanstr.equals("3")) {
                                // equip

                                System.out.println("what would you like to equip?");
                                System.out.println("1.armor");
                                System.out.println("2.weapon");

                                Scanner equip = new Scanner(System.in);
                                String quip = equip.nextLine();
                                String mor = "";

                                if (equip.equals("1")) {
                                    System.out.println("which armor would you like to equip?");
                                    System.out.println("1.knightarmor");
                                    System.out.println("2.robe");

                                    Scanner armor = new Scanner(System.in);
                                    mor = armor.nextLine();
                                } else if (equip.equals("2")) {
                                    System.out.println("which weapon would you like to equip?");
                                    System.out.println("1.sword");
                                    System.out.println("2.staff");

                                    Scanner weapon = new Scanner(System.in);
                                    String pon = weapon.nextLine();
                                } else {
                                    System.out.println("you haven't equip anything");
                                }

                                System.out.println("select a material rank");
                                System.out.println("1.basic");
                                System.out.println("2.standard");
                                System.out.println("3.elite");

                                Scanner rank = new Scanner(System.in);
                                String ank = rank.nextLine();

                                if (rank.equals(1)) {
                                    System.out.println(" you have selected basic");
                                } else if (rank.equals(2)) {
                                    System.out.println(" you have selected standard");
                                } else if (rank.equals(3)) {
                                    System.out.println(" you have selected elite");
                                } else {
                                    System.out.println(" you haven't selected material rank");
                                }

                                // armor/knight armor/basic/ suiiii
                                if (quip.equals("1") && mor.equals("1") && ank.equals("1") && knightarbasic != 0) {
                                    defence *= 30;
                                    defence /= 100;
                                    knightarbasic--;

                                    // armor/knight armor/standard
                                } else if (quip.equals("1") && mor.equals("1") && ank.equals("2")
                                        && knightarstandard != 0) {
                                    defence *= 50;
                                    defence /= 100;
                                    knightarstandard--;

                                    // armor/knight armor/elite
                                } else if (quip.equals("1") && mor.equals("1") && ank.equals("3")
                                        && knightarelite != 0) {
                                    defence *= 70;
                                    defence /= 100;
                                    knightarelite--;

                                    // armor/robe/basic
                                } else if (quip.equals("1") && mor.equals("2") && ank.equals("1") && robebasic != 0) {
                                    defence *= 20;
                                    defence /= 100;
                                    manabar *= 10;
                                    manabar /= 100;
                                    robebasic--;

                                    // armor/robe/stnadard
                                } else if (quip.equals("1") && mor.equals("2") && ank.equals("2")
                                        && robestandard != 0) {
                                    defence *= 40;
                                    defence /= 100;
                                    manabar *= 30;
                                    manabar /= 100;
                                    robestandard--;

                                    // armor/robe/elite
                                } else if (quip.equals("1") && mor.equals("2") && ank.equals("3") && robeelite != 0) {
                                    defence *= 60;
                                    defence /= 100;
                                    manabar *= 50;
                                    manabar /= 100;
                                    robeelite--;

                                    // weapon/sword/basic
                                } else if (quip.equals("2") && mor.equals("1") && ank.equals("1") && swordbasic != 0) {
                                    strength *= 30;
                                    strength /= 100;
                                    swordbasic--;

                                    // weapon/sword/standard
                                } else if (quip.equals("2") && mor.equals("1") && ank.equals("2")
                                        && swordstandard != 0) {
                                    strength *= 50;
                                    strength /= 100;
                                    swordstandard--;
                                    // weapon/sword/elite
                                } else if (quip.equals("2") && mor.equals("1") && ank.equals("3") && swordelite != 0) {
                                    strength *= 70;
                                    strength /= 100;
                                    swordelite--;
                                    // weapon/staff/basic
                                } else if (quip.equals("2") && mor.equals("2") && ank.equals("1") && staffbasic != 0) {
                                    strength *= 10;
                                    strength /= 100;
                                    manabar *= 10;
                                    manabar /= 100;
                                    staffbasic--;
                                    // weapon/staff/standard
                                } else if (quip.equals("2") && mor.equals("2") && ank.equals("2")
                                        && staffstandard != 0) {
                                    strength *= 20;
                                    strength /= 100;
                                    manabar *= 20;
                                    manabar /= 100;
                                    staffstandard--;
                                    // weapon/staff/elite
                                } else if (quip.equals("2") && mor.equals("2") && ank.equals("3") && staffelite != 0) {
                                    strength *= 30;
                                    strength /= 100;
                                    manabar *= 40;
                                    manabar /= 100;
                                    staffelite--;
                                }

                            } else if (bsscanstr.equals("4")) {
                                // consume here

                                String cons = "";
                                while (true) {

                                    System.out.println("what do you want to consume");
                                    System.out.println("1.potion (mp)");
                                    System.out.println("2.food (hp)");
                                    System.out.println("3.power up (str)");
                                    Scanner consume = new Scanner(System.in);

                                    cons = consume.nextLine();

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
                                System.out.print("1.low ");
                                if (cons.equals("1")) {
                                    System.out.println(lowpot);
                                } else if (cons.equals("2")) {
                                    System.out.println(lowfood);
                                } else if (cons.equals("3")) {
                                    System.out.println(lowpow);
                                }
                                System.out.print("2.med ");
                                if (cons.equals("1")) {
                                    System.out.println(midpot);
                                } else if (cons.equals("2")) {
                                    System.out.println(midfood);
                                } else if (cons.equals("3")) {
                                    System.out.println(midpow);
                                }
                                System.out.print("3.high ");
                                if (cons.equals("1")) {
                                    System.out.println(highpot);
                                } else if (cons.equals("2")) {
                                    System.out.println(highfood);
                                } else if (cons.equals("3")) {
                                    System.out.println(highpow);
                                }

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
                                if (conscu.equals("yes")) {

                                    if (cons.equals("1") && grd.equals("1") && lowpot != 0) {
                                        manabar += 30;
                                        lowpot--;
                                        System.out.println("you current mana is" + manabar);
                                    }

                                    else if (cons.equals("1") && grd.equals("2") && midpot != 0) {
                                        manabar += 45;
                                        midpot--;
                                        System.out.println("you current mana is" + manabar);
                                    } else if (cons.equals("1") && grd.equals("3") && highpot != 0) {
                                        manabar += 60;
                                        highpot--;
                                        System.out.println("you current mana is" + manabar);
                                    } else if (cons.equals("2") && grd.equals("1") && lowfood != 0) {
                                        healthbar += 30;
                                        lowfood--;
                                        System.out.println("you current hp is" + healthbar);
                                    } else if (cons.equals("2") && grd.equals("2") && midfood != 0) {
                                        healthbar += 45;
                                        midfood--;
                                        System.out.println("you current hp is" + healthbar);
                                    } else if (cons.equals("2") && grd.equals("3") && highfood != 0) {
                                        healthbar += 60;
                                        highfood--;
                                        System.out.println("you current hp is" + totalhealth);
                                    } else if (cons.equals("3") && grd.equals("1") && lowpow != 0) {
                                        strength += 30;
                                        lowpow--;
                                        System.out.println("you current hp is" + strength);
                                    } else if (cons.equals("3") && grd.equals("2") && midpow != 0) {
                                        strength += 45;
                                        midpow--;
                                        System.out.println("you current hp is" + strength);
                                    } else if (cons.equals("3") && grd.equals("3") && highpow != 0) {
                                        strength += 60;
                                        highpow--;
                                        System.out.println("you current hp is" + strength);
                                    }

                                    else {
                                        System.out.println("nothing has increase");
                                    }

                                }
                            } else if (bsscanstr.equals("5")) {
                                // run
                                double catmode = Math.random() * 100;
                                Integer catmoment = (int) catmode;
                                if (catmoment < 20) {
                                    break;
                                } else {
                                    System.out.println("You failed to run! no legs OvO");
                                }
                            }
                        }
                        if (allowdamage == true) {
                            double enemydamagedealer = Math.random() * 100;
                            Integer edd = (int) enemydamagedealer;
                            healthbar = healthbar - ((80 + enemydamagedealer) * enemyQty);
                        } else {
                        }

                    }

                    // end battling
                } else {
                    if (gameprogress % 10 == 0) {
                        // story trigger
                        if (gameprogresscounter == 0) {
                            // first part go here

                            // first part end
                            gameprogresscounter++;
                        } else if (gameprogresscounter == 1) {
                            // second

                            gameprogresscounter++;
                        } else if (gameprogresscounter == 2) {
                            // third

                            gameprogresscounter++;
                        }

                    } else {
                        System.out.println("Name: " + CharName);
                        System.out.println("Level: " + CharLVL);
                        System.out.println("EXP: " + CharEXP + "/" + (CharLVL * 100));
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
                            while (true) {
                                System.out.println("Learn Skill");
                                if (CharClassName.equals("Knight")) {
                                    for (int i = 0; i < skillknight.length; i++) {
                                        System.out.println(
                                                (i + 1) + ". " + skillknight[i] + " Unlock Cost:" + (i + 1) * 10);
                                    }
                                } else if (CharClassName.equals("Mage")) {
                                    for (int i = 0; i < skillmage.length; i++) {
                                        System.out.println(
                                                (i + 1) + ". " + skillmage[i] + " Unlock Cost:" + (i + 1) * 10);
                                    }
                                }
                                System.out.println("type exit for exit");

                                Scanner SkillVibes = new Scanner(System.in);
                                String SV = SkillVibes.nextLine();

                                if (SV.equals("1")) {
                                    if (SkillMovePoint > 10) {
                                        if (CharClassName.equals("Knight")) {
                                            skillknightstatus[0] = 1;
                                        } else if (CharClassName.equals("Mage")) {
                                            skillmagestatus[0] = 1;
                                        }
                                        SkillMovePoint -= 10;
                                    } else {
                                        System.out.println("Lacking them points");
                                    }

                                } else if (SV.equals("2")) {
                                    if (SkillMovePoint > 20) {
                                        if (CharClassName.equals("Knight")) {
                                            skillknightstatus[1] = 1;
                                        } else if (CharClassName.equals("Mage")) {
                                            skillmagestatus[1] = 1;
                                        }
                                        SkillMovePoint -= 20;
                                    } else {
                                        System.out.println("Lacking them points");
                                    }

                                } else if (SV.equals("exit")) {
                                    break;
                                } else {

                                }

                            }

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
                            System.out.println("May I help you?");
                            System.out.println("1. Purchase");
                            System.out.println("2. Sell");
                            System.out.println("3. Back");
                            Scanner trade = new Scanner(System.in);
                            String tradeMerch = trade.nextLine();
                            if (tradeMerch.equals("1")) {
                                // show money

                                System.out.print("$" + " ");
                                System.out.println(coins);

                                // show item

                                System.out.println("Pick your destiny");
                                System.out.println("1. Armory");
                                System.out.println("2. Weaponry");
                                System.out.println("3. Back");

                                Scanner buy = new Scanner(System.in);
                                String buyTrade = buy.nextLine();

                                if (buyTrade.equals("1")) {

                                    System.out.println(knightarbasic);
                                    System.out.println(knightarstandard);
                                    System.out.println(knightarelite);
                                    System.out.println(robebasic);
                                    System.out.println(robestandard);
                                    System.out.println(robeelite);

                                } else if (buyTrade.equals("2")) {

                                    System.out.println(swordbasic);
                                    System.out.println(swordstandard);
                                    System.out.println(swordelite);
                                    System.out.println(staffbasic);
                                    System.out.println(staffstandard);
                                    System.out.println(staffelite);

                                } else if (buyTrade.equals("3")) {
                                    break;
                                }

                                // show inventory

                            } else if (tradeMerch.equals("2")) {
                                // show money
                                System.out.print("$" + " ");
                                System.out.println(coins);
                                // show inventory

                            } else if (tradeMerch.equals("3")) {
                                break;
                            } else {
                                System.out.println("Please choose those 3 options!");
                            }

                        }

                    }
                }

                // start check story scene
                // #code
                // end story scene
            }
            if (gameover == true) {
                System.out.println(
                        "  ________    _____      _____  ___________ ____________   _________________________ ");
                System.out.println(
                        " /  _____/   /  _  \\    /     \\ \\_   _____/ \\_____  \\   \\ /   /\\_   _____/\\______   \\");
                System.out.println(
                        "/   \\  ___  /  /_\\  \\  /  \\ /  \\ |    __)_   /   |   \\   Y   /  |    __)_  |       _/");
                System.out.println(
                        "\\    \\_\\  \\/    |    \\/    Y    \\|        \\ /    |    \\     /   |        \\ |    |   \\");
                System.out.println(
                        " \\______  /\\____|__  /\\____|__  /_______  / \\_______  /\\___/   /_______  / |____|_  /");
                System.out.println(
                        "        \\/         \\/         \\/        \\/          \\/                 \\/         \\/ ");
            }

            // end of story
            // ps inventory stuff or any stats stuff go to line 25 -> 30 ish
        }
    }
}