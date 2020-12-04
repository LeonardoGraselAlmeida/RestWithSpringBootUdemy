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

    @ApiOperation("Find all Person")
    @GetMapping
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    @ApiOperation("Find one person by id")
    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @ApiOperation("Create new person")
    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return services.create(person);
    }

    @ApiOperation("Update infos of person")
    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return services.update(person);
    }

    @ApiOperation("Delete one person by id")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }
}
