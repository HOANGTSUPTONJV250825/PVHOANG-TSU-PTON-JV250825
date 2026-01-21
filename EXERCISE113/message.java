package EXERCISE113;

import java.time.LocalDateTime;

public class message {
    private String Sender;
    private String Content;
    private LocalDateTime TimeStamp;

    public message() {
    }

    public message(LocalDateTime timeStamp, String sender, String content) {
        TimeStamp = timeStamp;
        Sender = sender;
        Content = content;
    }

    public String getSender() {
        return Sender;
    }

    public String getContent() {
        return Content;
    }

    public LocalDateTime getTimeStamp() {
        return TimeStamp;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        TimeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return String.format("|%20s | %-15s | %-30s|",
                TimeStamp,
                Sender,
                Content
        );
    }
}
