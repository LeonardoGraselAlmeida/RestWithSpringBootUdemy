package br.com.leonardoalmeida.restwithspringbootudemy.repository;

import br.com.leonardoalmeida.restwithspringbootudemy.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
