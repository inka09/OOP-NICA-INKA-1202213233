package TPMODUL3_INKA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Restaurant food = new Restaurant();
        int customerID, orderQty;

        try{
            
            System.out.println("Enter Customer ID: ");
            customerID = input.nextInt();

            System.out.println("Enter how much food to make: ");
            orderQty = input.nextInt();

            Thread thread1 = new Thread(food);
            Waiters waiters = new Waiters(orderQty, customerID);
            Thread thread2 = new Thread(waiters);

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        }
        catch (Exception e){
            System.out.println("Input must be Interger");
        }

        input.close();
    }
}