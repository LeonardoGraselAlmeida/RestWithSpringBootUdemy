package br.com.leonardoalmeida.restwithspringbootudemy.controller;

import br.com.leonardoalmeida.restwithspringbootudemy.data.vo.PersonVO;
import br.com.leonardoalmeida.restwithspringbootudemy.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @ApiOperation("Find all person")
    @GetMapping
    public List<PersonVO> findAll() {
        return services.findAll();
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
