import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Load {
    public static void main(String[] args) throws IOException {
      
            //load
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