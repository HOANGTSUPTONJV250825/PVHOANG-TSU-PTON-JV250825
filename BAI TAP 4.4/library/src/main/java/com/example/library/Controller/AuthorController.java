package com.example.library.Controller;

import com.example.library.Model.dto.AuthorRequest;
import com.example.library.Model.entity.Author;
import com.example.library.Service.AuthorSirvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorSirvice authorSirvice;

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors(){
        return ResponseEntity.ok(authorSirvice.findAllAuthorInfor());
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author createAt = authorSirvice.createAuthorInfor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAt);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<?> findAuthorByID(@PathVariable int ID){
        Author author = authorSirvice.findByAuthorID(ID);
        if (author !=null){
            return ResponseEntity.ok(author);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("khong tim thay tac gia nay");
        }
    }

    @PutMapping("/{ID}")
    public ResponseEntity<?> updateAuthorInfor(@PathVariable long ID,@RequestBody AuthorRequest request){
        ResponseEntity<?> author = authorSirvice.updateAuthor(ID, request);
        if (author != null){
            return ResponseEntity.ok(author);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("khong tim thay thong tin tac gia");
        }
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<String> delAuthor(@PathVariable int ID){
        Author author = authorSirvice.findByAuthorID(ID);
        if (author == null){
            return ResponseEntity.notFound().build();
        }
        if ("Admin".equalsIgnoreCase(author.getAuthorName().toLowerCase())){
            return ResponseEntity.badRequest().body("Lỗi: Không thể xóa tác giả có vai trò Admin");
        }
        authorSirvice.delAuthor(ID);
        return ResponseEntity.ok("Xóa thành công");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Author>> findAuthorByName(@RequestParam String name){
        return ResponseEntity.ok(authorSirvice.findAuthorByName(name));
    }
}