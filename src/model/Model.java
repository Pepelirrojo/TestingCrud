package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Model {
	ApiRequest myApiRequest;
	String urlPath;

	public Model() {
		myApiRequest = new ApiRequest();
		urlPath = "http://localhost/TestingCrud/";
	}

	public HashMap<Integer, Student> myStudents() {
		HashMap<Integer, Student> myStudents = new HashMap<Integer, Student>();
		String response;
		try {
			response = myApiRequest.getRequest(urlPath + "getAllStudents.php");
			JSONObject responseJson = (JSONObject) JSONValue.parse(response);
			String state = (String) responseJson.get("state");
			if (state.equals("ok")) {
				JSONArray studentsJsonArray = (JSONArray) responseJson.get("students");
				for (int i = 0; i < studentsJsonArray.size(); i++) {
					JSONObject studentRow = (JSONObject) studentsJsonArray.get(i);
					int id = Integer.parseInt((String) studentRow.get("id"));
					String name = (String) studentRow.get("name");
					String surname = (String) studentRow.get("surname");
					double averageGrade = Double.parseDouble((String) studentRow.get("averageGrade"));
					String sex = (String) studentRow.get("sex");
					Student student = new Student(id, name, surname, averageGrade, sex);
					myStudents.put(student.getId(), student);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myStudents;
	}

	public boolean insertStudent(Student myStudent) {
		JSONObject jsonStudent = new JSONObject();
		jsonStudent.put("name", myStudent.getName());
		jsonStudent.put("surname", myStudent.getSurname());
		jsonStudent.put("averageGrade", myStudent.getAverageGrade());
		jsonStudent.put("sex", myStudent.getSex());
		try {
			String response = myApiRequest.postRequest(urlPath + "insertStudent.php", jsonStudent.toJSONString());
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateStudent(Student myStudent) {

	
		JSONObject jsonStudent = new JSONObject();
		jsonStudent.put("id", myStudent.getId());
		jsonStudent.put("name", myStudent.getName());
		jsonStudent.put("surname", myStudent.getSurname());
		jsonStudent.put("averageGrade", myStudent.getAverageGrade());
		jsonStudent.put("sex", myStudent.getSex());
		
		try {
			String response = myApiRequest.postRequest(urlPath + "updateStudent.php", jsonStudent.toJSONString());;
			System.out.println(response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR, student's data was not changed");
			
		}

		return false;

	}
}
