package com.shn.spr.bookstore;

import com.shn.spr.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(
        path = "/author",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AuthorController {

    @Autowired
    private AuthorService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Author> getAuthors(@RequestParam(name = "limit", defaultValue = "20") int limit,
            HttpServletResponse response) {
        return service.getAuthors(limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody @Validated Author author) {
        return service.save(author);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable("id") Long id) {
        Author author = service.findOne(id);
        RestPreconditions.checkFound(author);
        return author;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Author delete(@PathVariable("id") Long id) {
        Author author = service.findOne(id);
        RestPreconditions.checkFound(author);
        service.delete(id);

        return author;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Author put(@PathVariable("id") Long id, @RequestBody @Validated Author author) {

        RestPreconditions.checkFound(service.findOne(id));
        RestPreconditions.checkId(id, author.getId());
        return service.save(author);
    }

}
