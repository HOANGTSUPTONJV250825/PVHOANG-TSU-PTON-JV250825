package com.example.library.Repository;

import com.example.library.Model.entity.BorrowTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowTicketRepository extends JpaRepository<BorrowTicket,Long> {
    @Query("SELECT COUNT(bt.id)>0 FROM BorrowTicket bt WHERE bt.book.bookID = :bookId AND bt.status = :status")
    boolean existsByBookIdAndStatus(@Param("bookId") long bookId,@Param("status")String status);

}
