package com.example.Form;

public class AssignmentEnum{
		// Shows if homework is group or student homework
		public enum AssignmentType{
			GroupAssignment,
			StudentAssignment
		}
		// Shows if it is uploaded by instructor or instructor graded all artifacts
		public enum AssignmentStatus{
			Uploaded,
			Past
		}
	}