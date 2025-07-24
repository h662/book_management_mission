package com.h662.book_management_mission.repository;

import com.h662.book_management_mission.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(Book book) {
         jdbcTemplate.update(
                "INSERT INTO books(title, author_id, published_date) VALUES(?,?,?)",
                book.getTitle(), book.getAuthorId(), book.getPublishedDate()
        );
    }
}
