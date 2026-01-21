package EXERCISE113;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise112 {
    public static void main(String[] args) {
        List <message> messageList = new ArrayList<>();
        List<message> filteredMessages;
        List<message> filteredMessageWithDate;
        Scanner sc = new Scanner(System.in);
        message sendMessage;
        String name;
        String content;
        LocalDateTime timeStamp;
        do {
            System.out.println("nhap ten nguoi dung hoac exit de thoat:");
            name = sc.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            System.out.println("nhap noi dung tin nhan:");
            content = sc.nextLine();
            timeStamp = LocalDateTime.now();
            sendMessage = new message(timeStamp,name,content);
            messageList.add(sendMessage);
            System.out.println("nhap 'history' de xem lich su tin nhan, nhap 'filter' de loc tin nhan theo nguoi gui, hoac nhap 'date' de loc theo ngay:");
            String choose = sc.nextLine();
            if (choose.equals("history")){
                System.out.println("danh sach tin nhan");
                messageList.forEach(System.out::println);
            }else if (choose.equalsIgnoreCase("filter")){
                System.out.println("nhap ten nguoi gui de loc:");
                String senderName = sc.nextLine();

                filteredMessages = messageList.stream()
                        .filter(m -> m.getSender().trim()
                                .equalsIgnoreCase(senderName.trim()))
                        .toList();

                if (filteredMessages.isEmpty()) {
                    System.out.println("Khong tim thay tin nhan cua " + senderName);
                } else {
                    filteredMessages.forEach(System.out::println);
                }

            }else if (choose.equals("date")){
                String time;
                System.out.println("nhap vao (YYYY-MM-DD)");
                time = sc.nextLine();
                filteredMessageWithDate = messageList.stream().filter(m ->m.getTimeStamp().toLocalDate().toString().equals(time)).toList();
                if (filteredMessageWithDate.isEmpty()){
                    System.out.println("khong tim thay tin nhan");
                }else {
                    filteredMessageWithDate.forEach(System.out::println);
                }
            }
        }while (!name.equalsIgnoreCase("exit"));
    }
}
