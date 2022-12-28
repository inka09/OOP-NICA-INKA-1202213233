package MODUL3_INKA;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        
        Calculation c = new Calculation();
        Thread thread = new Thread(c);
        Scanner input = new Scanner(System.in);
        boolean repeat = true;

        do {
            System.out.println("""
                    ==Menu Program==
                    1. Square
                    2. Circle
                    3. Trapezoid
                    Select menu : 
                    """);
            try{
                int menu = input.nextInt();
                System.out.println();

                switch(menu){

                    case 1 :
                        System.out.println("Enter the length od the side of the square : ");
                        double side = input.nextDouble();

                        c.setSquare(side);
                        thread.start();
                        thread.join();

                        System.out.println("\n The calculation result : " + c.getSquare());
                        break;
                    
                    case 2 :
                        System.out.println("Enter the radius of the circle : ");
                        double radius = input.nextDouble();

                        c.setCircle(radius);
                        thread.start();
                        thread.join();

                        System.out.println("\nThe calculation result: " + c.getCircle());

                    case 3 :
                        System.out.print("Insert the side of the base of the trapezoid : ");
                        double alas = input.nextDouble();

                        System.out.print("Enter the upper side of the trapezoid : ");
                        double atas = input.nextDouble();

                        System.out.print("Enter the height of the trapezoid : ");
                        double tinggi = input.nextDouble();

                        c.setTrapezoid(alas, atas, tinggi);

                        thread.start();
                        thread.join();

                        System.out.println("\nThe calculation result: " + c.getTrapezoid());
                        break;
                         
                    case 0 :
                        System.out.println("The program is finished");

                    default :
                        System.out.println("\nOptions not available\n");

                        continue;
                    }
                repeat = false;
            }
            catch(InputMismatchException e) {
                System.out.println("\n====Error: Input must be a number====\n");
                input.next();

            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e);
                System.out.println();

            } catch (InterruptedException e) {
                System.out.println(e);
            }

        } while (repeat);
        input.close();
    }
}