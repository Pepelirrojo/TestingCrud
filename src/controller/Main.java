package controller;

import model.DBManager;

public class Main {
	public static void main(String[] args) {
		DBManager myDbManager = new DBManager();
		myDbManager.myStudents();
	}
}
