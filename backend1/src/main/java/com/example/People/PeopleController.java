package com.example.People;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.People.People.PeopleType;
import com.example.Course.Course;
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
    @GetMapping("/getStudent/{name}")
    List<People> getStudent(@PathVariable String name) {
    	return repository.findByName(name);
    }
    @PostMapping("/newStudent")
    void newStudent(@RequestBody People student) {
    	student.setPeople(PeopleType.Student);
    	repository.save(student);
    }
    @GetMapping("/getInstructor/{name}")
    List<People> getInstrucor(@PathVariable String name) {
    	return repository.findByName(name);
    }
    @PostMapping("/newInstructor")
    void newInstructor(@RequestBody People instructor) {
    	instructor.setPeople(PeopleType.Instructor);
    	repository.save(instructor);
    }

    // Single item

    @GetMapping("/people?id={id}")
    People one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException(id));
    }
    
    @GetMapping("/instructors/{course}")
    List<People> findInstructorsOfCourse(@PathVariable Course course){
    	return repository.findByAllCoursesAndPeople(course, PeopleType.Instructor);
    }

    @PutMapping("/people?id={id}")
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

    @DeleteMapping("/people?id={id}")
    void deletePeople(@PathVariable Long id) {
        repository.deleteById(id);
    }
}