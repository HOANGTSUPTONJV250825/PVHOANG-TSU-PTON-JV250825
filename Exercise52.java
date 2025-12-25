package EXERCISE52;

public class Exercise52 {
    public static void main(String[] args){
        StringBuilder beforeStr = new StringBuilder("Hello, Java World!");
        System.out.println("chuoi ban dau: "+beforeStr);

        System.out.println("chuoi sau khi xoa: "+beforeStr.delete(5,10));
        System.out.println("chuoi sau khi thay the: "+beforeStr.replace(7,12,"Universe"));


    }
}
