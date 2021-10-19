package controller;

import model.Model;
import view.View;

public class Main {
	public static void main(String[] args) {
		Model myModel = new Model();
		Controller myController = new Controller();
		View myView = new View();
		myController.setMyModel(myModel);
		myController.setMyView(myView);
		myView.setMyController(myController);
		myView.Initialize();
	}
}
