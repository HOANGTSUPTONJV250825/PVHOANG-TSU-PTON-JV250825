package com.example.library.Repository;

import com.example.library.Model.entity.Author;
import com.example.library.Model.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface BookRepository extends JpaRepository<book,Long> {
    List<book> findByTitleContainingIgnoreCase (String keyword);

    @Query("SELECT b FROM book b WHERE b.price > (SELECT AVG(b2.price)FROM book b2)")
    List<book> findBooksAboutAveragePrice();

    @Query(value = "SELECT a.author_name AS authorName, COUNT(b.bookid) AS bookCount "+
    "FROM authors a LEFT JOIN books b ON a.authorid = b.author_id "+
    "GROUP BY a.authorid,a.author_name ", nativeQuery = true)
    List<Map<String, Object>> CountBooksByAuthor();
}
