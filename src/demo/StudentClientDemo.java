package demo;

import java.util.ArrayList;
import java.util.List;

import client.StudentClient;
import core.PhoneNumber;
import core.Student;

public class StudentClientDemo {
	public static void main(String[] args) {
		StudentClient client = new StudentClient();

		System.out.println("TEST: readAll");
		List<Student> students = client.readAll();

		for (Student s : students) {
			System.out.println(s);
		}

		Student student = new Student();
		student.setCedula("07100000007");
		student.setStudentId("CI-0007");
		student.setFirstName("James");
		student.setFirstSurname("Bond");
		student.setEmail("bond.james@sis.gov.uk");
		student.setAddress("PO Box 1300, London SE1 1BD");
		student.setStatus(Student.Status.ACTIVE);
		student.setPhoneNumbers(new ArrayList<PhoneNumber>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new PhoneNumber("0800789321", PhoneNumber.Type.WORK));
			}
		});
		
		System.out.println("TEST: create");
		client.create(student);
		
		students = client.readAll();

		for (Student s : students) {
			System.out.println(s);
		}
		
		student = client.readByUniqueIdentifier("cedula", "07100000007");
		student.setMiddleName("Herbert");
		
		System.out.println("TEST: update");
		client.update(student.getEntityId(), student);
		
		students = client.readAll();

		for (Student s : students) {
			System.out.println(s);
		}
		
		System.out.println("TEST: delete");
		client.delete(student.getEntityId());
		
		students = client.readAll();

		for (Student s : students) {
			System.out.println(s);
		}
		
		client.close();

	}
}
