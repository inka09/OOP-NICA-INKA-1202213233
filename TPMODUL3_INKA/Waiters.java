package TPMODUL3_INKA;

public class Waiters implements Runnable{
    private final int orderQty;
    private final int CustomerID;
    static int foodPrice = 2500;

    public Waiters(int orderQty, int CustomerID){
        this.orderQty = orderQty;
        this.CustomerID = CustomerID;
    }

    @Override
    public void run(){
        while (true){
            getFood();
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void orderInfo(){
        System.out.println("==========================================");
        System.out.println("Customer ID : " + this.CustomerID);
        System.out.println("Number of Food : " + this.orderQty);
        System.out.println("Total Price : " + this.orderQty + foodPrice);
        System.out.println("==========================================");
    }

    public void getFood(){
        synchronized(Restaurant.getLock()){

            System.out.println("Waiter : The Food is ready to deliver");
            Restaurant restaurant = new Restaurant();
            restaurant.setWaitingForPickup(false);

            if (Restaurant.getFoodNumber() == this.orderQty + 1){
                orderInfo();
                System.exit(0);
            }

            Restaurant.getLock().notifyAll();
            System.out.println("Waiter : Tell the Restaurant to make another Food\n");
        }
    }
}