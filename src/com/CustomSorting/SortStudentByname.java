package com.CustomSorting;

import java.util.Comparator;

import Sdbms.Student;

public class SortStudentByname implements Comparator<Student> {
	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getName().compareTo(y.getName());//--> gives ascending order
		
	}
}



//x--> object to be be inserted and   y->> alredy existing  object


