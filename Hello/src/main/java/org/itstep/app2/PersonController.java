package org.itstep.app2;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person(1L, "Иван", "Иванов"));
        persons.add(new Person(2L, "John", "Doe"));
    }

    @GetMapping({"", "/"})
    public List<Person> getAllPersons() {
        return persons;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        Person person = persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (person == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}

/*
  fetch('http://localhost:8080/users', {
    method: 'GET'
  })
  .then(response=>response.json());

fetch('http://localhost:8080/persons', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"id":3,"name": "Jane", "surname": "Doe"})
          });

  fetch('http://localhost:8080/persons', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({"name":"noname"})
  });

  fetch('http://localhost:8080/persons', {
    method: 'DELETE'
  });
 */
