package com.example.library.Service;

import com.example.library.Model.dto.AuthorRequest;
import com.example.library.Model.entity.Author;
import com.example.library.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorSirvice {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthorInfor(){
        return authorRepository.findAll();
    }

    public Author createAuthorInfor(Author author){
        authorRepository.save(author);
        return author;
    }

    public Author findByAuthorID(long ID){
        return authorRepository.findById(ID).orElse(null);
    }

    public ResponseEntity<?> updateAuthor(long ID, AuthorRequest request){
        Author author = authorRepository.findById(ID).orElse(null);
            if (author == null){
                return new ResponseEntity<>("tac gia khong ton tai", HttpStatus.BAD_REQUEST);
            }else {
                Author author1 = new Author();
                author1.setAuthorName(request.getAuthorname());
                author1.setAuthorEmail(request.getAuthoremail());
                return new ResponseEntity<>(authorRepository.save(author1),HttpStatus.CREATED);
            }
    }

    public boolean delAuthor(long ID){
        Author findAuthor = authorRepository.findById(ID).orElse(null);
        if (findAuthor == null){
            return false;
        }
        if (findAuthor != null && findAuthor.getAuthorName().equalsIgnoreCase("Admin")){
            return false;
        }
        authorRepository.deleteById(ID);
        return true;

    }

    public List<Author> findAuthorByName(String findName){
        return authorRepository.findAll().stream()
                .filter(e->e.getAuthorName().toLowerCase().contains(findName))
                .collect(Collectors.toList());
    }
}