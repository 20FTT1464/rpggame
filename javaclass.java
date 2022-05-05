import java.util.Scanner;

public class javaclass {

    public static void main(String[] args) {
        System.out.println("what do you want to consume");
        System.out.println("1.potion");
        System.out.println("2.food");
        System.out.println("3.power up");

        
        Scanner consume = new Scanner(System.in);
         
        String cons = consume.nextLine();

             if( cons.equals("1")){
                System.out.println("you have selected potion");

            }else if( cons.equals("2")){
                System.out.println("you have selected food");
            }else if( cons.equals("3")){
                System.out.println("you have selected power up");

            } else{
                System.out.println("Please select an item");
            }

            System.out.println("select a grade");
            System.out.println("1.low");
            System.out.println("2.med");
            System.out.println("3.high");

            Scanner grade = new Scanner(System.in);
            
            String grd = grade.nextLine();

                if( grd.equals("1")){
                    System.out.println("low grade item has been selected");
                }
                else if( grd.equals("2")){
                    System.out.println("medium grade item has been selected");
                }
                else if( grd.equals("3")){
                    System.out.println("high grade item has been selected");
                }
                else{
                    System.out.println("low grade item has been selected");
                }

    

        
        

        

        
       


    }

}