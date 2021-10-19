package view;

import java.util.Scanner;

import controller.Controller;

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
		System.out.println("Select one option:\n1.Show Students");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String option = (String) sc.next();
			switch (option) {
			case "1": {
				myController.ShowStudents();
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
		}
	}
}
