package com.example.library.Service;

import com.example.library.Model.entity.Author;
import com.example.library.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
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

    public Author findByAuthorID(int ID){
        return authorRepository.FindByID(ID).orElse(null);
    }

    public Author updateAuthor(int ID, Author request){
        if (authorRepository.FindByID(ID).isPresent()){
            authorRepository.updateAuthor(ID,request);
            return request;
        }
        return null;
    }

    public boolean delAuthor(int ID){
       Author findAuthor = authorRepository.FindByID(ID).orElse(null);
       if (findAuthor == null){
           return false;
       }
       if (findAuthor != null && findAuthor.getAuthorName().equalsIgnoreCase("Admin")){
           return false;
       }
       authorRepository.delAuthor(ID);
       return true;

    }

    public List<Author> findAuthorByName(String findName){
        return authorRepository.findAll().stream()
                .filter(e->e.getAuthorName().toLowerCase().contains(findName))
                .collect(Collectors.toList());
    }
}
