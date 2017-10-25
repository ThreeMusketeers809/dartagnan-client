package demo;

import java.util.ArrayList;
import java.util.List;

import client.EmployeeClient;
import core.entities.Employee;
import core.entities.PhoneNumber;

public class EmployeeClientDemo {
	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();

		System.out.println("TEST: readAll");
		List<Employee> employees = client.readAll();

		for (Employee e : employees) {
			System.out.println(e);
		}

		Employee employee = new Employee();
		employee.setCedula("05800000007");
		employee.setFirstName("James");
		employee.setFirstSurname("Bond");
		employee.setEmail("bond.james@sis.gov.uk");
		employee.setRole(Employee.Role.SUPPORT);
		employee.setPhoneNumbers(new ArrayList<PhoneNumber>() {
			private static final long serialVersionUID = 1L;

			{
				add(new PhoneNumber("0800789321", PhoneNumber.Type.WORK));
			}
			{
				add(new PhoneNumber("0800789322", PhoneNumber.Type.HOME));
			}
		});

		System.out.println("TEST: create");
		String uuid = client.create(employee);

		employees = client.readAll();

		for (Employee e : employees) {
			System.out.println(e);
		}

		employee = client.read(uuid);
		employee.setMiddleName("Herbert");

		System.out.println("TEST: update");
		client.update(uuid, employee);

		employees = client.readAll();

		for (Employee e : employees) {
			System.out.println(e);
		}

		System.out.println("TEST: delete");
		client.delete(uuid);

		employees = client.readAll();

		for (Employee e : employees) {
			System.out.println(e);
		}

		client.close();

	}
}
