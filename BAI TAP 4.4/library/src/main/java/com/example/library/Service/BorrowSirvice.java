package com.example.library.Service;

import com.example.library.Model.dto.BorrowTicketDTO;
import com.example.library.Model.entity.BorrowTicket;
import com.example.library.Model.entity.book;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.BorrowTicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowSirvice {
    private final BookRepository bookRepository;
    private final BorrowTicketRepository borrowTicketRepository;

    public BorrowSirvice(BookRepository bookRepository, BorrowTicketRepository borrowTicketRepository) {
        this.bookRepository = bookRepository;
        this.borrowTicketRepository = borrowTicketRepository;
    }

    @Transactional
    public BorrowTicketDTO borrowBook(long bookId, String studentName){
        book findBook = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("404 - khong tim thay sach"));
        boolean isAlreadyBorrowed = borrowTicketRepository.existsByBookIdAndStatus(bookId,"BORROWED");
        if (isAlreadyBorrowed){
            throw new RuntimeException("400 - sach hien da co nguoi muon");
        }
        BorrowTicket ticket = new BorrowTicket();
        ticket.setStudentName(studentName);
        ticket.setBook(findBook);
        ticket.setBorrowDate(LocalDate.now());
        ticket.setStatus("BORROWED");
        borrowTicketRepository.save(ticket);

        return new BorrowTicketDTO(
                ticket.getStudentName(),
                findBook.getTitle(),
                findBook.getAuthor().getAuthorName(),
                ticket.getBorrowDate()
        );

    }
}
