import java.io.*;
import java.util.Scanner;

public class Save {
    public static void main(String[] args) throws IOException {

            // save
            String[] save = { "Amongus1", "Amongus2", "Amongus3" };
            System.out.print("Please enter slot name: ");
            Scanner gs = new Scanner(System.in);
    
            File file = new File(gs.nextLine()+".txt");
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
    
            if(file.exists()) {
                while(true) {
                    System.out.println("Do you want to overwrite?");
                        Scanner ovcon = new Scanner(System.in);
                            if (ovcon.nextLine().equals("yes")) {
                                System.out.println("Enter description: ");
                                break;
                            }
                            else if(ovcon.nextLine().equals("no")) {
                                System.out.print("Please enter slot name: ");
                                Scanner gamsa = new Scanner(System.in);
    
                                File newfi = new File(gamsa.nextLine()+".txt");
                                if (newfi.createNewFile()) {
                                    System.out.println("File created: " + newfi.getName());
                                } else {
                                    System.out.println("File already exists.");
                                }
                                    
                                FileWriter type = new FileWriter(newfi);
                                for (int i = 0; i < save.length; i++) {
                                    type.write(save[i] + System.lineSeparator());
                                }
                                    type.close();
                                }
                                else {
                                    System.out.println("Input only yes/no.");
                            }
                        }
                    }
                }
            }