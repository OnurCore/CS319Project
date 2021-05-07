package com.example.People;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.example.People.People;


@Entity
@Table
public class GroupRequest{
	public enum GroupRequestStatus{
		NotEvaluated,
		Rejected,
		Accepted
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private People sender;
	
	@ManyToOne
	private Group requestedGroup;

	private String text;
	
	private GroupRequestStatus status;
	
	private Date date;

	public Long getId() {
		return id;
	}

	// getters setters
	
	public void setId(Long id) {
		this.id = id;
	}

	public People getSender() {
		return sender;
	}

	public void setSender(People sender) {
		this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Group getRequestedGroup() {
		return requestedGroup;
	}

	public void setRequestedGroup(Group requestedGroup) {
		this.requestedGroup = requestedGroup;
	}

	public GroupRequestStatus getStatus() {
		return status;
	}

	public void setStatus(GroupRequestStatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}