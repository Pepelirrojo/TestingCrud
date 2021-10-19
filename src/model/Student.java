package model;

public class Student {

	int id;
	String name;
	String surname;
	double averageGrade;
	String sex;
	
	public Student(int id, String name, String surname, double averageGrade, String sex) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.averageGrade = averageGrade;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student " + id + ", name=" + name + ", surname=" + surname + ", averageGrade=" + averageGrade
				+ ", sex=" + sex ;
	}
	
	
}
