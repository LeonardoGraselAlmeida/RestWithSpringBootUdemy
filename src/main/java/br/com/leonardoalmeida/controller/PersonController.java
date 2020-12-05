package br.com.leonardoalmeida.controller;

import br.com.leonardoalmeida.data.vo.PersonVO;
import br.com.leonardoalmeida.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @ApiOperation("Find all people")
    @GetMapping
    public Page<PersonVO> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "order", defaultValue = "asc") String order
    ) {
        var orderDirection = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, limit, Sort.by(orderDirection, "firstName"));
        return services.findAll(pageable);
    }

    @ApiOperation("Find all people")
    @GetMapping(value = "/findPersonByName/{firstName}")
    public Page<PersonVO> findPersonByName(
            @PathVariable("firstName") String firstName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "order", defaultValue = "asc") String order
    ) {
        var orderDirection = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, limit, Sort.by(orderDirection, "firstName"));
        return services.findPersonByName(firstName, pageable);
    }

    @ApiOperation("Find a specific person by your ID")
    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @ApiOperation("Create a new person")
    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return services.create(person);
    }

    @ApiOperation("Update a specific person by your ID")
    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return services.update(person);
    }

    @ApiOperation("Delete a specific person by your ID")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }

    @ApiOperation("Disable a specific person by your ID")
    @PatchMapping(value = "/{id}")
    public PersonVO disableById(@PathVariable("id") Long id) {
        return services.disablePerson(id);
    }
}
