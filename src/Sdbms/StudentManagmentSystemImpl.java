package Sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.CustomSorting.SortStudentByAge;
import com.CustomSorting.SortStudentById;
import com.CustomSorting.SortStudentByMarks;
import com.CustomSorting.SortStudentByname;
import com.jsp.customException.InvalidChoiceException;
import com.jsp.customException.StudentNotFoundException;

public class StudentManagmentSystemImpl implements StudentManagementSystem{

	//key----> is Student Id --> <String> and  value-----> is Student Object--><Student>

	Map<String, Student> db=new LinkedHashMap<String, Student>();
	Scanner scan =new Scanner(System.in);



	@Override
	public void addStudent()
	{
		//Accept age,name, & marks
		//create a student object
		//Map--> db--> add Entry -->put()--> id,object
		//print the student Id

		System.out.println("Enter the age");
		int age=scan.nextInt();

		System.out.println("Enter the name");
		String name=scan.next();

		System.out.println("Enter the marks");
		int marks=scan.nextInt();

		Student std=new Student(age,name,marks);

		// Adding entry (student id & Student Object)
		db.put(std.getId(), std);

		System.out.println("Student record inserted sucessfully");
		System.out.println("your Student id is "+std.getId());

	}
	@Override
	public void removeStudent()
	{
		System.out.println("enter the Student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Yes!!! student record present");
			db.remove(id);
			System.out.println("Given record is removed successfully");


		}
		else
		{
			//StudentNotFoundException  -> Custom message
			try
			{
				String message="student with "+ id+" not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent()
	{
		if(!db.isEmpty())
		{
			System.out.println("No. of student record found "+ db.size());
			db.clear();
			System.out.println("Studnet record removed successfully");
		}
		else
		{
			//StudentNotFoundException  -> Custom message
			//giving different message to same Exception class
			try
			{
				String message="There is No student records to remove";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}	
	}
	@Override
	public void DisplayStudent()
	{
		//Accepts Student id --> jsp101,Jsp101,JSP101
		//convert to upercase
		//checking if Id is persent or not by Containskey()
		// if--> get the values (Student object) ->> use getter methods
		// else--> StudentnotfoundException
		System.out.println("enter the Student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Yes!!, student record present");
			Student s=db.get(id);
			System.out.println( "ID : "+s.getId());
			System.out.println("name : "+ s.getName());
			System.out.println("marks are : "+ s.getMarks());
			System.out.println( "Age is : "+s.getAge());
			System.out.println(".........");

			//      here TiString is overriden SO you will get same out as above by print s(reference)
			//				System.out.println(s);
		}
		else
		{
			//StudentNotFoundException  -> Custom message
			try
			{
				String message="student with "+ id+" not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void DisplayAllStudents()
	{
		// display Students records ehrn db is not empty
		if(!db.isEmpty())
		{
			System.out.println("student records are as fallows");
			System.out.println(".....................");
			Set<String>	keys=db.keySet();

			for(String key:keys)
			{
				// printing the Student objects as toString is overridden
				System.out.println(db.get(key));
			}
		}
		else
		{
			//StudentNotFoundException  -> Custom message
			try
			{
				String message="No student records to Display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()
	{
		//Accept id and convert to upercase
		// check present or not
		//if --> get th studnet object
		// 1.update age 2.name 3.marks
		// use Switch case1:Setage()...........default:InvalidchoiceException
		//else --> StudentNotFoundException

		System.out.println("enter the Student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Yes!!, student record present");
			Student s=db.get(id);
			System.out.println("enter the choice to update");
			System.out.println("1.update Age\n 2.update name\n 3. update marks");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the new age");
				int age=scan.nextInt();
				s.setAge(age);
				System.out.println("Age updated sucessfully");
				break;
			case 2:
				System.out.println("Enter the new name");
				String name=scan.next();
				s.setName(name);
				System.out.println(" Name updated sucessfully");
				System.out.println();
				break;
			case 3:
				System.out.println("Enter the new marks");
				int marks=scan.nextInt();
				s.setMarks(marks);
				System.out.println("Marks updated sucessfully");
				break;
			default:
				try
				{
					String message="Invalid choice, please enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());

				}
			}
		}
		else
		{
			//StudentNotFoundException  -> Custom message
			try
			{
				String message="student with "+ id+" not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void countStudent()
	{
		System.out.println("Available Student records is "+db.size());
	}
	@Override
	public void SortStudnet()
	{

		//object of Array list and reference of list storing it in student object
		List<Student> list=new ArrayList<>() ;

		//converting map into set (keys) using keyset()
		Set<String> keys=db.keySet();

		//traversing keys from set
		for(String key:keys)
		{
			Student s=db.get(key);// getting value (student object)
			list.add(s);// adding values (student object) into list
			// list.add(db.get(key));
		}

		System.out.println("1.Sort Student By ID\n2.Sort Student BY Age");
		System.out.println("3.Sort Student By Name\n4.Sort Student BY Marks");
		System.out.println("enter the choice");
		int choice=scan.nextInt();

		switch(choice)
		{
		case 1:
			Collections.sort(list,new SortStudentById());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(list,new SortStudentByAge());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(list,new SortStudentByname());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		default:
			try
			{
				String message="Invalid choice, please enter valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void findStudentWithHigestMarks()
	{
		if(!db.isEmpty())
		{
			List<Student> list=new ArrayList<>() ;
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				Student s=db.get(key);// getting value (student object)
				list.add(s);// adding values (student object) into list
				// list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println("Higest Marks is: "+ list.get(list.size()-1));
		}
		else
		{
			//StudentNotFoundException  -> Custom message
			try
			{
				String message="No student records to Display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void findStudentWithLowestMarks()
	{
		if(!db.isEmpty())
		{
		List<Student> list=new ArrayList<>() ;
		Set<String> keys=db.keySet();
		for(String key:keys)
		{
			Student s=db.get(key);// getting value (student object)
			list.add(s);// adding values (student object) into list
			// list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Lowest Marks is: "+ list.get(0));
		}
		else
		{
			//StudentNotFoundException  -> Custom message
			try
			{
				String message="No student records to Display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}

