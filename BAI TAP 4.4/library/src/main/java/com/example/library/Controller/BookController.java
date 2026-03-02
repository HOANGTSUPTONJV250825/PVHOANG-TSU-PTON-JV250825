package com.example.library.Controller;

import com.example.library.Model.dto.BookRequest;
import com.example.library.Model.entity.book;
import com.example.library.Service.bookSirvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private bookSirvice bookSirvice;

    @GetMapping
    public ResponseEntity<List<book>> getAllBooks(){
        return new ResponseEntity<>(bookSirvice.findAllBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookSirvice.addBook(bookRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBookByID(@PathVariable long ID){
        book book = bookSirvice.findBookByID(ID);
        if (book != null){
            return new ResponseEntity<>(book,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("book not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<book>> searchByTitle(@RequestParam String title){
        return ResponseEntity.ok(bookSirvice.searchByTitle(title));
    }

    @GetMapping("premium")
    public ResponseEntity<List<book>> getBookHightPrice(){
        return ResponseEntity.ok(bookSirvice.getBookHightPrice());
    }

    @GetMapping("/stats/by-author")
    public ResponseEntity<List<Map<String,Object>>> statisticsByAuthor(){
        return ResponseEntity.ok(bookSirvice.statisticsByAuthor());
    }
}
