package com.example.Calendar;

import java.util.List;
import javax.persistence.ElementCollection;
public class GroupCalendar{
	@ElementCollection
	private List<Task> tasks; 
}