package com.example.People;
import javax.persistence.Embeddable;
import java.lang.Override;
import javax.persistence.Column;
import java.io.Serializable;


// Old design

@Embeddable
public class GroupPeopleKey implements Serializable{
	@Column(name = "group_id")
	private Long groupId;
	
	@Column(name = "people_id")
	private Long peopleId;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	public GroupPeopleKey() {}
	public GroupPeopleKey(Long groupId,
						   Long peopleId) {
		this.peopleId = peopleId;
		this.groupId = groupId;
	}
}