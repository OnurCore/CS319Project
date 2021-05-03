package com.example.People;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.EmbeddedId;
import javax.persistence.MapsId;
import javax.persistence.Column;
import javax.persistence.FetchType;
import java.util.Date;

// Old design

@Entity
@Table(name = "group_people_union")
public class GroupPeopleUnion {
 
    @EmbeddedId
    private GroupPeopleKey id;
 
    @ManyToOne
    @MapsId("groupId")
    private Group group;
 
    @ManyToOne
    @MapsId("peopleId")
    private People people;
 
    public GroupPeopleKey getId() {
		return id;
	}

	public void setId(GroupPeopleKey id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	@Column(name = "created_on")
    private Date createdOn = new Date();
 
    private GroupPeopleUnion() {}
 
    public GroupPeopleUnion(Group group, People people) {
        this.group = group;
        this.people = people;
        this.id = new GroupPeopleKey(group.getId(), people.getId());
    }
}