package controller;

import model.Model;
import model.Student;
import view.View;

public class Controller {
	Model myModel;
	View myView;

	public Model getMyModel() {
		return myModel;
	}

	public void setMyModel(Model myModel) {
		this.myModel = myModel;
	}

	public View getMyView() {
		return myView;
	}

	public void setMyView(View myView) {
		this.myView = myView;
	}

	public void ShowStudents() {
		for (Student myStudent : myModel.myStudents().values()) {
			System.out.println(myStudent);
		}
	}
	
	public void InsertStudent(Student myStudent) {
		myModel.insertStudent(myStudent);
	}
	
	public void updateStudent(Student myStudent) {
		myModel.updateStudent(myStudent);
	}
	
	public void deleteStudent(Student myStudent) {
		myModel.deleteStudent(myStudent);
		
	}

}
