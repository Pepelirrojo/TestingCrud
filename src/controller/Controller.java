package controller;

import java.util.Collection;

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

	public Collection<Student> ShowStudents() {
		return myModel.myStudents().values();
	}

	public String InsertStudent(Student myStudent) {
		return myModel.insertStudent(myStudent) ? "Inserted Student: " + myStudent.getName() : "Not Inserted";
	}

	public String updateStudent(Student myStudent) {
		return myModel.updateStudent(myStudent) ? "Update Student: " + myStudent.toString() : "Not Updated";
	}

	public String deleteStudent(Student myStudent) {
		return myModel.deleteStudent(myStudent) ? "Deleted Student: " + myStudent.toString() : "Not Deleted";
	}

}
