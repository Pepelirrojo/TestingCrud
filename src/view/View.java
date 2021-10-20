package view;

import java.util.Scanner;

import controller.Controller;
import model.Student;

public class View {
	Controller myController;

	public Controller getMyController() {
		return myController;
	}

	public void setMyController(Controller myController) {
		this.myController = myController;
	}

	public void Initialize() {
		System.out.println("Welcome to Griso School");
		System.out.println("Select one option:\n1.Show Students\n2.Insert Student\n3.Update Student\n4.Delete Student");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String option = (String) sc.next();
			switch (option) {
			case "1": {
				for (Student student : myController.ShowStudents()) {
					System.out.println(student.toString());
				}
				break;
			}
			case "2": {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Surname: ");
				String surname = sc.next();
				System.out.print("Average Grade: ");
				double averageGrade = Double.parseDouble(sc.next());
				System.out.print("Gender: ");
				String gender = sc.next();
				Student myStudent = new Student(0, name, surname, averageGrade, gender);
				System.out.println(myController.InsertStudent(myStudent));
				break;
			}
			case "3": {
				System.out.print("Insert the ID of the student you wish to change:\n");
				for (Student student : myController.ShowStudents()) {
					System.out.println(student.toString());
				}
				System.out.print("ID: ");
				int id = sc.nextInt();
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Surname: ");
				String surname = sc.next();
				System.out.print("Average Grade: ");
				double averageGrade = Double.parseDouble(sc.next());
				System.out.print("Gender: ");
				String gender = sc.next();
				Student myStudent = new Student(id, name, surname, averageGrade, gender);
				System.out.println(myController.updateStudent(myStudent));
				break;
			}
			case "4":{
				System.out.print("Insert the ID of the student you wish to delete:\n");
				for (Student student : myController.ShowStudents()) {
					System.out.println(student.toString());
				}
				System.out.print("ID: ");
				int id = sc.nextInt();
				Student myStudent = new Student(id);
				System.out.println(myController.deleteStudent(myStudent));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
			System.out.println("Select one option:\n1.Show Students\n2.Insert Student\n3.Update Student\n4. Delete Student");
		}
	}
}
