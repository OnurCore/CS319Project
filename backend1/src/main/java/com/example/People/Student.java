package com.example.People;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import com.example.Grades.Grade;


public class Student extends People{
	
	//private Grade peerGrade;

	/*public Grade getPeerGrade() {
		return peerGrade;
	}

	public void setPeerGrade(Grade peerGrade) {
		this.peerGrade = peerGrade;
	}*/
}