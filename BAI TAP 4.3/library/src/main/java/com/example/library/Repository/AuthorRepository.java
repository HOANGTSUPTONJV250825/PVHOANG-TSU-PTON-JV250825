package com.example.library.Repository;

import com.example.library.Model.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        authors.add(new Author(1,"Admin","nna@gmail.com"));
        authors.add(new Author(2,"Nam Cao","nc@gmail.com"));
        authors.add(new Author(3,"To Hoai","th@gmail.com"));
    }

    public List<Author> findAll(){
        return authors;
    }

    public void save(Author author){
        authors.add(author);
    }

    public Optional<Author> FindByID(int ID){
        return authors.stream().filter(a->a.getAuthorID() == ID).findFirst();
    }

    public void updateAuthor(int ID,Author request){
        FindByID(ID).ifPresent(e->{
            e.setAuthorName(request.getAuthorName());
            e.setAuthorEmail(request.getAuthorEmail());
        });
    }

    public boolean delAuthor(int ID){
        return authors.removeIf(e->e.getAuthorID() == ID);
    }
}
