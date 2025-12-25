package EXERCISE55;

public class Exercise55 {
    public static void main(String[] args){
        long startTime, endTime;
        String str = "hello";
        startTime = System.currentTimeMillis();
        for (int i = 0;i<1000000;i++){
            str += "world";
        }
        endTime = System.currentTimeMillis();
        System.out.println("thoi gian lam viec cua String: "+(endTime - startTime)+" ms");

        StringBuilder strB = new StringBuilder("hello");
        startTime = System.currentTimeMillis();
        for (int i = 0;i<1000000;i++){
            strB.append("world");
        }
        endTime = System.currentTimeMillis();
        System.out.println("thoi gian lam viec cua StringBuilder: "+(endTime - startTime)+" ms");

        StringBuffer strBu = new StringBuffer("hello");
        startTime = System.currentTimeMillis();
        for (int i = 0;i<1000000;i++){
            strBu.append("world");
        }
        endTime = System.currentTimeMillis();
        System.out.println("thoi gian lam viec cua StringBuffer: "+(endTime - startTime)+" ms");


    }
}
