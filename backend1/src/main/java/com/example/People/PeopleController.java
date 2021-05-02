package com.example.People;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PeopleController {

    private final PeopleRepository repository;

    PeopleController(PeopleRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/people")
    List<People> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/people")
    People newPeople(@RequestBody People newPeople) {
        return repository.save(newPeople);
    }

    // Single item

    @GetMapping("/people/{id}")
    People one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException(id));
    }

    @PutMapping("/people/{id}")
    People replacePeople(@RequestBody People newPeople, @PathVariable Long id) {

        return repository.findById(id)
                .map(people -> {
                    people.setName(newPeople.getName());
                    people.setContactInfo(newPeople.getContactInfo());
                    return repository.save(people);
                })
                .orElseGet(() -> {
                    newPeople.setId(id);
                    return repository.save(newPeople);
                });
    }

    @DeleteMapping("/people/{id}")
    void deletePeople(@PathVariable Long id) {
        repository.deleteById(id);
    }
}