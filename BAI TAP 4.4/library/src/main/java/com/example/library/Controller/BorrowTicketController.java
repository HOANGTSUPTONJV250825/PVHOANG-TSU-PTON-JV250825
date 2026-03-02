package com.example.library.Controller;

import com.example.library.Model.dto.BorrowTicketDTO;
import com.example.library.Service.BorrowSirvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/borrow")
public class BorrowTicketController {

    private final BorrowSirvice borrowSirvice;

    public BorrowTicketController(BorrowSirvice borrowSirvice) {
        this.borrowSirvice = borrowSirvice;
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<?> borrowBook(@PathVariable long bookId,@RequestParam String studentName){
        try {
            BorrowTicketDTO response = borrowSirvice.borrowBook(bookId,studentName);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (RuntimeException e){
            if (e.getMessage().contains("404")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
