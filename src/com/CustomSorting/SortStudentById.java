package com.CustomSorting;

import java.util.Comparator;

import Sdbms.Student;

public class SortStudentById implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getId().compareTo(y.getId());//--> gives ascending order
		
	}

}

// x--> object to be be inserted and   y->> alredy existing  object
