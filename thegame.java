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
                                for (int i = 0; i < currentEnemy.length; i++) {
                                    if (monsterCurHP[i] > 0) {
                                        System.out.println((i + 1) + ". " + currentEnemy[i] + " " + monsterCurHP[i]
                                                + "/ " + monsterMaxHP[i]);
                                    } else {
                                        System.out.println((i + 1) + ". " + currentEnemy[i] + " Dead");
                                    }
                                }
                                System.out.println("4. exit");
                                Scanner attack = new Scanner(System.in);
                                Integer attackEnm = attack.nextInt();
                                if (attackEnm == 1) {
                                    (monsterCurHP[attackEnm - 1]) -= ((int) totalstrength);
                                    allowdamage = true;
                                } else if (attackEnm == 2) {
                                    (monsterCurHP[attackEnm - 1]) -= ((int) totalstrength);
                                    allowdamage = true;
                                } else if (attackEnm == 3) {
                                    (monsterCurHP[attackEnm - 1]) -= ((int) totalstrength);
                                    allowdamage = true;
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
                        if(gameprogresscounter==0){
                            //first part go here
                            //story 1
                            Scanner s = new Scanner(System.in);
                            System.out.println("A mysterious person found Aleph looking very hopeless and helpless. He went to Aleph and help him.");
                            s.nextLine();
                            System.out.println("The mysterious person ask, \"You must be Aleph?\"");
                            s.nextLine();
                            System.out.println("Aleph: Who are you? How did you find me?");
                            s.nextLine();
                            System.out.println("Mysterious person: I am Imposter.");
                            s.nextLine();
                            System.out.println("Aleph: Please help me get out of here.");
                            s.nextLine();
                            System.out.println("Imposter: I will show you the way but...you have one problem.");
                            s.nextLine();
                            System.out.println("Aleph: What is it?");
                            s.nextLine();
                            System.out.println("Imposter: The only way for you to get out of here is to have the strength, power and willingness to fight all the enemies.");
                            s.nextLine();
                            System.out.println("Aleph: But I have nothing...sigh");
                            s.nextLine();
                            System.out.println("Imposter: Quick! We're being attack.");
                            s.nextLine();
                            // first part end
                            gameprogresscounter++;

                        } else if (gameprogresscounter==1) {
                            //second
                            Scanner w = new Scanner(System.in);
                            System.out.println("Aleph: Phew! That was close. We did great right?");
                            w.nextLine();
                            System.out.println("No response.");
                            w.nextLine();
                            System.out.println("Aleph: Right?");
                            w.nextLine();
                            System.out.println("Aleph look behind him saw Impostor slowly fading off.");
                            w.nextLine();
                            System.out.println("Imposter: You have to do this on your own now.");
                            w.nextLine();
                            System.out.println("Aleph: Wait. I have no where to go.");
                            w.nextLine();
                            System.out.println("Imposter: You will be fine.");
                            w.nextLine();
                            System.out.println("Aleph was left alone, did not know where to go. At that moment, someone approach him.");
                            w.nextLine();
                            System.out.println("Someone: Hello, mas Aleph! I am Eren Yeager. You can call me Eren.");
                            w.nextLine();
                            System.out.println("Aleph: Hello, Eren.");
                            w.nextLine();
                            System.out.println("Eren: I see that you are trap in this forest and you are trying to get out from here, right?");
                            w.nextLine();
                            System.out.println("Aleph: Yes. Can you help me please?");
                            w.nextLine();
                            System.out.println("Eren: I will help you get out from here.");
                            w.nextLine();
                            System.out.println("Aleph: Thank you!");
                            w.nextLine();
                            System.out.println("Eren: There is a way. Come on...through here.");
                            w.nextLine();
                            System.out.println("Aleph and Eren's move along the forest, leading him unknowingly into deeper forest.");
                            w.nextLine();
                            System.out.println("Aleph: How long are we getting out of this forest?");
                            w.nextLine();
                            System.out.println("Eren: Almost there...");
                            w.nextLine();
                            System.out.println("Aleph senses that Eren was lying and brought him into a scary looking place. Then, Eren ran away from the enemy leaving Aleph alone to fight.");
                            w.nextLine();
                            gameprogresscounter++;

                        } else if (gameprogresscounter==2) {
                            //third
                            Scanner t = new Scanner(System.in);
                            System.out.println("Aleph: Argh, that was painful!");
                            t.nextLine();
                            System.out.println("\"Boo!\"");
                            t.nextLine();
                            System.out.println("Aleph: Ahhh.... W-Who are you?");
                            t.nextLine();
                            System.out.println("Lady: Hahaha. Hello, I am Sakura. I can heal you.");
                            t.nextLine();
                            System.out.println("Aleph: Please.");
                            t.nextLine();
                            System.out.println("Sakura: Please wait for a moment. Let me check your injuries.");
                            t.nextLine();
                            System.out.println("Sakura: Drink this they can heal you up. Also, eat this then you have maximum energy.");
                            t.nextLine();
                            System.out.println("Aleph drank the potion and ate the food. So now Aleph has heal up.");
                            t.nextLine();
                            System.out.println("Sakura: Now that you heal up. You must rest.");
                            t.nextLine();
                            System.out.println("Aleph: But I have no time to rest. I must go home.");
                            t.nextLine();
                            System.out.println("Sakura: Hmm...well I can not let you go on your own with this kind of state. I will go and help you.");
                            t.nextLine();
                            System.out.println("Aleph: All right, that is fine with me. The more the merrier.");
                            t.nextLine();
                            System.out.println("While on their way out. They saw an enemy coming towards them. Aleph and Sakura were on their position and getting ready to attack.");
                            t.nextLine();
                            gameprogresscounter++;

                        } else if (gameprogresscounter==3) {
                            Scanner q = new Scanner(System.in);
                            System.out.println("Aleph: By now, I must be called \"The Youngest Hero that has been fighting all these enemies from nothing.\" Am I right?");
                            q.nextLine();
                            System.out.println("Sakura: Don't bluff yourselves. We still have more to go.");
                            q.nextLine();
                            System.out.println("Aleph: Ouch!");
                            q.nextLine();
                            System.out.println("Sakura: Oh my..are you hurt? Where? Let me see.");
                            q.nextLine();
                            System.out.println("Aleph: I was just joking. Hahahaha. A little joke won't hurt, do you?");
                            q.nextLine();
                            System.out.println("Sakura: No..no you are right.");
                            q.nextLine();
                            System.out.println("Aleph and Sakura's move to a place where they can set up a bonfire not too far from a lake.");
                            q.nextLine();
                            System.out.println("Sakura's gave Aleph a potion for him to heal up.");
                            q.nextLine();
                            System.out.println("As they were having a deep conversation with each other. Aleph looked around and saw an enemy roaming around near the lake.");
                            q.nextLine();
                            System.out.println("He quietly told Sakura. Sakura was alerted getting ready to atttack.");
                            q.nextLine();
                            gameprogresscounter++;

                        } else if (gameprogresscounter==4) {
                            Scanner x = new Scanner(System.in);
                            System.out.println("Then Aleph finishes off the enemy by slaughtering the enemy's head in one swift movement.");
                            x.nextLine();
                            System.out.println("Aleph: Did you see that?");
                            x.nextLine();
                            System.out.println("Then, Aleph saw Sakura was bleeding profusely.");
                            x.nextLine();
                            System.out.println("Aleph: No..no don't leave me yet.");
                            x.nextLine();
                            System.out.println("Sakura: I am sorry, I can not promise you that. Here take this.");
                            x.nextLine();
                            System.out.println("Aleph cried as Sakura's slowly fading off.");
                            x.nextLine();
                            System.out.println("As Aleph stood up, he accidentally slid off a rock while walking. Then, he fell onto the river.");
                            x.nextLine();
                            System.out.println("After that, Aleph woke up from his dream only to be disappointed that it was all a dream.");
                            x.nextLine();
                            gameprogresscounter++;

                        } else {}

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
                                System.out.println("Current Skill Points: "+ SkillMovePoint);
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
                                    if (SkillMovePoint >= 10) {
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
                                    if (SkillMovePoint >= 20) {
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

                                System.out.print(" " + "g");
                                System.out.println(coins);

                                // show item

                                System.out.println("Pick your destiny");
                                System.out.println("1. Armory");
                                System.out.println("2. Weaponry");
                                System.out.println("3. Back");

                                Scanner buy = new Scanner(System.in);
                                String buyTrade = buy.nextLine();

                                if (buyTrade.equals("1")) {

                                    System.out.println("Pick your armory grade");
                                    System.out.println("1. Basic");
                                    System.out.println("2. Standard");
                                    System.out.println("3. Elite");

                                    Scanner grade = new Scanner(System.in);
                                    String buyGrade = buy.nextLine();

                                    if (buyGrade.equals("1")) {

                                        System.out.println("Knight Ar Basic"+knightarbasic);
                                        System.out.println("Robe Basic"+robebasic);

                                        Scanner basic = new Scanner(System.in);
                                        String basicTrade = basic.nextLine();

                                        if(basicTrade.equals("1")){

                                            int priceKnightBasic = (int)(coins-25);
                                            System.out.println(priceKnightBasic);

                                        }else if(basicTrade.equals("2")){

                                            int priceRobeBasic = (int)(coins-27);
                                            System.out.println(priceRobeBasic);
                                        }

                                    } else if (buyGrade.equals("2")) {

                                        System.out.println("Knight Standard"+knightarstandard);
                                        System.out.println("Robe Standard"+robestandard);

                                        Scanner standard = new Scanner(System.in);
                                        String standardTrade = standard.nextLine();

                                        if(standardTrade.equals("1")){

                                            int priceKnightStandard = (int)(coins-40);
                                            System.out.println(priceKnightStandard);

                                        }else if(standardTrade.equals("2")){

                                            int priceRobeStandard = (int)(coins-42);
                                            System.out.println(priceRobeStandard);

                                           

                                        }
                                        

                                    } else if (buyGrade.equals("3")) {

                                        System.out.println("Knight Ar Elite"+knightarelite);
                                        System.out.println("Robe Elite"+robeelite);

                                        
                                        Scanner elite = new Scanner(System.in);
                                        String eliteTrade = elite.nextLine();

                                        if(eliteTrade.equals("1")){

                                            int priceKnightElite = (int)(coins-70);
                                            System.out.println(priceKnightElite);

                                        }else if(eliteTrade.equals("2")){

                                            int priceRobeElite = (int)(coins-72);
                                            System.out.println(priceRobeElite);

                                           

                                        }
                                        

                                    }

                                } else if (buyTrade.equals("2")) {

                                    System.out.println("Pick your weaponry grade");
                                    System.out.println("1. Basic");
                                    System.out.println("2. Standard");
                                    System.out.println("3. Elite");

                                    Scanner merch = new Scanner(System.in);
                                    String merchTrade = merch.nextLine();

                                    if (merchTrade.equals("1")) {

                                        System.out.println("Sword Basic" + swordbasic);
                                        System.out.println("Staff Basic" + staffbasic);

                                        Scanner basicWeapon = new Scanner(System.in);
                                        String basicTrade = basicWeapon.nextLine();

                                        if(basicTrade.equals("1")){
                                            int priceSwordBasic = (int)(coins-20);
                                            System.out.println(priceSwordBasic);
                                        }else if(basicTrade.equals("2")){
                                            int priceStaffBasic = (int)(coins-23);
                                            System.out.println(priceStaffBasic);
                                        }

                                    } else if (merchTrade.equals("2")) {

                                        System.out.println("Staff Standard" + swordstandard);
                                        System.out.println("Sword Standard"+ staffstandard);

                                        Scanner standardWeapon = new Scanner(System.in);
                                        String standardTrade = standardWeapon.nextLine();

                                        if(standardTrade.equals("1")){
                                            int priceSwordStandard = (int)(coins-32);
                                            System.out.println(priceSwordStandard);
                                        }else if(standardTrade.equals("2")){
                                            int priceStaffStandard = (int)(coins-34);
                                            System.out.println(priceStaffStandard);
                                        }



                                    } else if (merchTrade.equals("3")) {

                                        System.out.println("Staff Elite" + swordelite);
                                        System.out.println("Sword Elite"+ staffelite);

                                        Scanner eliteWeapon = new Scanner(System.in);
                                        String eliteTrade = eliteWeapon.nextLine();

                                        
                                        if(eliteTrade.equals("1")){
                                            int priceSwordElite = (int)(coins-32);
                                            System.out.println(priceSwordElite);
                                        }else if(eliteTrade.equals("2")){
                                            int priceStaffElite = (int)(coins-34);
                                            System.out.println(priceStaffElite);
                                        }


                                    }

                                    

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
                                System.out.println("Don't you wanna buy something my friend?");
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