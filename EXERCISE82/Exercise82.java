package EXERCISE82;

import java.util.ArrayList;
import java.util.List;

public class Exercise82 {
    public static void main(String[] args) {
        List<vehicle> vehicles = new ArrayList<>();
        car car1 = new car("toyota",160);
        bike bike1 = new bike("honda",120);
        vehicles.add(car1);
        vehicles.add(bike1);
        for (vehicle v:vehicles){
            v.start();
            v.displayInfor();
        }
    }
}
