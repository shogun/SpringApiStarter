package com.shn.spr.bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuthorRepository repository;



    public Page<Author> getAuthors(int limit) {
        return repository.findAll(new PageRequest(0, limit));
    }

    public Author save(Author author) {
        return repository.save(author);
    }

    public Author findOne(Long id) {
        return repository.findOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
