package Sdbms;

import java.util.Scanner;

import com.jsp.customException.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println("welcome to student Database Project");
		System.out.println(".......................................");
		Scanner scanner=new Scanner(System.in);
		StudentManagementSystem managementSystem=new StudentManagmentSystemImpl();

		while(true)
		{
			System.out.println();
			System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
			System.out.println(" 1:Add Student\n 2.Remove Student\n 3.Remove All Student  ");
			System.out.println(" 4.Display Student\n 5.Display All Students\n 6.Update Student ");
			System.out.println(" 7.Count Student\n 8.Sort Studnet\n 9.Find Student With Higest Marks");
			System.out.println(" 10.Find Student With Lowest Marks \n 11.Exit\n");
			System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
			System.out.println("Enter the choice");
			int choice =scanner.nextInt();

			switch(choice)
			{
			case 1:
				managementSystem.addStudent();
				break;
			case 2:
				managementSystem. removeStudent();
				break;
			case 3:
				managementSystem.removeAllStudent();
				break;
			case 4:
				managementSystem. DisplayStudent();
				break;
			case 5:
				managementSystem. DisplayAllStudents();
				break;
			case 6:
				managementSystem. updateStudent();
				break;
			case 7:
				managementSystem. countStudent();
				break;
			case 8:
				managementSystem.SortStudnet();
				break;
			case 9:
				managementSystem. findStudentWithHigestMarks();
				break;
			case 10:
				managementSystem. findStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("=====Thank You=====");
				System.exit(0);
				break;
			default :
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
			System.out.println(".............");
		}


	}

}


