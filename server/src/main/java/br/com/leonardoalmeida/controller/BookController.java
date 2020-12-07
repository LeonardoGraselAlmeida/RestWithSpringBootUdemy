package br.com.leonardoalmeida.controller;

import br.com.leonardoalmeida.data.vo.BookVO;
import br.com.leonardoalmeida.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    private BookServices services;

    @ApiOperation("Find all books")
    @GetMapping
    public Page<BookVO> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "order", defaultValue = "asc") String order
    ) {
        var orderDirection = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, limit, Sort.by(orderDirection, "title"));
        return services.findAll(pageable);

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
