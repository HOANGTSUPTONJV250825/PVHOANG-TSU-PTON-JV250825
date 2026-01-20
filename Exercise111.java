package EXERCISE111;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Exercise111 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("cac so chan trong phuong thuc:");
        numbers.forEach(num->{
            if (num % 2 == 0){
                System.out.println(num);
            }
        });
        System.out.println("tong tat ca cac so trong danh sach la");
        int sum = numbers.stream().mapToInt(num -> num).sum();
        System.out.println(sum);
    }

}
