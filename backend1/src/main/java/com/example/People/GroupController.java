package com.example.People;
import com.example.People.GroupPeopleUnionRepository;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Course.*;
@RestController
class GroupController {

    private final GroupRepository repository;
    private final PeopleRepository peopleRepository;
    private final GroupPeopleUnionRepository groupPeopleUnionRepository;
    public GroupController(GroupRepository repository,
    						PeopleRepository peopleRepository,
    						GroupPeopleUnionRepository groupPeopleUnionRepository) {
        this.repository = repository;
        this.peopleRepository = peopleRepository;
        this.groupPeopleUnionRepository = groupPeopleUnionRepository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/allGroups")
    List<Group> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/newGroup")
    Group newGroup(@RequestBody Group newGroup) {
        return repository.save(newGroup);
    }
    
    //Groups of a course
    @GetMapping("/coursefindgroup/{id}")
    List<Group> getGroupsOfCourse(@PathVariable Course id){
    	return repository.findByCourseOrderByName(id);
    }

    // Single item

    @GetMapping("/allGroups/{id}")
    Group one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
    }

    @PutMapping("/newGroup/{id}")
    Group replaceGroup(@RequestBody Group newGroup, @PathVariable Long id) {

        return repository.findById(id)
                .map(group -> {
                    group.setName(newGroup.getName());
                    group.setGroupNo(newGroup.getGroupNo());
                    //group.setGroupGrade(newGroup.getGroupGrade());
                    group.setAllPeople(newGroup.getAllPeople());
                    //group.setGroupTasks(newGroup.getGroupTasks());
                    return repository.save(group);
                })
                .orElseGet(() -> {
                    newGroup.setId(id);
                    return repository.save(newGroup);
                });
    }
    @PostMapping("/leaveGroup/{group}/{student}")
    void leaveGroup(@PathVariable Group group, People student) {
    	List<People> currentPeople = new ArrayList<People>();
    	//List<GroupPeopleUnion> unions = group.
    	//currentPeople.remove(student);
    	if(currentPeople.isEmpty()) {
    		repository.deleteById(group.getId());
    	}
    	else {
    		//group.setAllPeople(currentPeople);
    	}
    }

    @PutMapping("/joinGroup/{group}/{student}")
   Group joinGroup(@PathVariable Group group,@PathVariable People student) {
    	/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("jp-ok");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();*/
        
        List<People> currentPeople = group.getAllPeople();
        if (group.getCourse().getUnassignedStudents().contains(student)) {
            student.addGroup(group);
        }
        return group;
      
        //entityManager.persist(group);
        //transaction.commit();
    }

    @PostMapping("/joinGroup/{group}/{student1}/{student2}")
    Group joinGroupWithFriend(@PathVariable Group group,@PathVariable People student1,@PathVariable People student2) {
    	List<People> unAssignedStudents = group.getCourse().getUnassignedStudents();
    	if (unAssignedStudents.contains(student1) 
    			&& unAssignedStudents.contains(student2)) {
            student1.addGroup(group);
            student2.addGroup(group);
        }
       return group;
    }
    @PostMapping("/{course}/addGroup/{student}")
    public Group addGroup(@PathVariable Course course,@PathVariable People student, @RequestBody String name) {
    	Group group = new Group();
    	group.setName(name);
    	group.setCourse(course);
    	
    	student.addGroup(group);
    	repository.save(group);
    	
    	return group;
    }
    @DeleteMapping("/allGroups/{id}")
    void deleteGroup(@PathVariable Long id) {
        repository.deleteById(id);
    }
}