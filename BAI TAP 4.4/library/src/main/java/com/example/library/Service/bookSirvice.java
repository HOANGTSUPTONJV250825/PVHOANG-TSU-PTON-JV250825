package com.example.library.Service;

import com.example.library.Model.dto.BookRequest;
import com.example.library.Model.entity.Author;
import com.example.library.Model.entity.book;
import com.example.library.Repository.AuthorRepository;
import com.example.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class bookSirvice {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<?> addBook(BookRequest bookRequest){
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElse(null);
        if (author == null){
            return new ResponseEntity<>("tac gia khong ton tai", HttpStatus.BAD_REQUEST);
        }else {
            book newBook = new book();
            newBook.setAuthor(author);
            newBook.setTitle(bookRequest.getTitle());
            newBook.setPrice(bookRequest.getPrice());
            return new ResponseEntity<>(bookRepository.save(newBook),HttpStatus.CREATED);
        }
    }

    public List<book> findAllBooks(){
        return bookRepository.findAll();
    }

    public book findBookByID(long ID){
        return bookRepository.findById(ID).orElse(null);
    }

    public List<book> searchByTitle(String keyword){
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<book> getBookHightPrice(){
        return bookRepository.findBooksAboutAveragePrice();
    }

    public List<Map<String,Object>> statisticsByAuthor(){
        return bookRepository.CountBooksByAuthor();
    }

}
