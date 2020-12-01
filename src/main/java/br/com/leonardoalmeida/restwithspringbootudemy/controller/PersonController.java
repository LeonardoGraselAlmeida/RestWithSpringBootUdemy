package br.com.leonardoalmeida.restwithspringbootudemy.controller;

import br.com.leonardoalmeida.restwithspringbootudemy.model.Person;
import br.com.leonardoalmeida.restwithspringbootudemy.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping
    public List<Person> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }
}
