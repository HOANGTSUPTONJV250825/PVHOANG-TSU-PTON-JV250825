package EXERCISE81;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise81 {
    public static void main(String[] args) {
        List<animal> animals = new ArrayList<>();
        dog dog1 = new dog("chihuahua",3,"chihuahua");
        dog dog2 = new dog("bob",5,"bitbull");
        cat cat1 = new cat("mini", 1, "gold");
        cat cat2 = new cat("kawai", 1, "moon");
        animals.add(dog1);
        animals.add(dog2);
        animals.add(cat1);
        animals.add(cat2);
        for (animal a: animals){
            a.displayInfor();
            a.makeSound();
        }

    }
}
