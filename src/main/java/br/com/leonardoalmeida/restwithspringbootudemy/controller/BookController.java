package br.com.leonardoalmeida.restwithspringbootudemy.controller;

import br.com.leonardoalmeida.restwithspringbootudemy.data.vo.BookVO;
import br.com.leonardoalmeida.restwithspringbootudemy.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    private BookServices services;

    @ApiOperation("Find all books")
    @GetMapping
    public List<BookVO> findAll() {
        return services.findAll();
    }

    @ApiOperation("Find one book by id")
    @GetMapping(value = "/{id}")
    public BookVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @ApiOperation("Create new book")
    @PostMapping
    public BookVO create(@RequestBody BookVO book) {
        return services.create(book);
    }

    @ApiOperation("Update infos of book")
    @PutMapping
    public BookVO update(@RequestBody BookVO book) {
        return services.update(book);
    }

    @ApiOperation("Delete one book by id")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }
}
