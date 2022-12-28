package MODUL3_INKA;

public class Calculation implements Runnable {
    double radius, side, area;
    double phi = 3.14;

    //setter square
    public void setSquare(double side) {
        if (side>0){
            this.area = side * side;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    //getter square
    public double getSquare(){
        return area;
    }

    //setter circle
    public void setCircle(double radius){
        if (radius>0){
            this.area = phi * radius* radius;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    //getter circle
    public double getCircle(){
       return area; 
    }

    public void setTrapezoid(double a, double b, double t){
        if(a>0 && b>0 && t>0){
            this.area = 0.5 * (a + b) * t;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public double getTrapezoid(){
        return area;
    }

    @Override
    public void run(){
        System.out.println("====Program will start in====");

        for(int i = 3; i > 0 ; i--){
            System.out.println("Starting with thread " + i);

            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException a){
                a.printStackTrace();
            }
        }
    }
}
