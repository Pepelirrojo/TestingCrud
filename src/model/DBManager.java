package model;

import java.io.IOException;
import java.util.HashMap;

public class DBManager {
	ApiRequest myApiRequest;
	String urlPath;
	
	public DBManager(){
		myApiRequest = new ApiRequest();
		urlPath = "http://localhost/TestingCrud/";
	}
	
	public HashMap<Integer, Student> myStudents(){
		String response;
		try {
			response = myApiRequest.getRequest(urlPath + "getAllStudents.php");
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
