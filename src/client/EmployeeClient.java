package client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import core.Employee;
import service.ServicePresets;

public class EmployeeClient extends GenericClient<Employee> {
	private static final String SERVICE_ROOT = "employees";
	private static final String SERVICE_URL = String.format("%s/%s", generateServiceRootUrl(), SERVICE_ROOT);

	private Client client;
	private WebTarget resource;

	/**
	 * 
	 * Constructor
	 */
	public EmployeeClient() {
		init();
	}

	@Override
	public List<Employee> readAll() {
		List<Employee> employees = null;

		GenericType<List<Employee>> list = new GenericType<List<Employee>>() {
		};
		Invocation invocation = resource.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).buildGet();
		Response response = invocation.invoke();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			employees = response.readEntity(list);
		}

		return employees;
	}

	@Override
	public Employee read(String entityId) {
		Employee employee = null;

		Invocation invocation = resource.path("/{uuid}").resolveTemplate("uuid", entityId)
				.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).buildGet();
		Response response = invocation.invoke();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			employee = response.readEntity(Employee.class);
		}

		return employee;
	}

	public Employee readByUniqueIdentifier(String identifier, String value) {
		Employee employee = null;

		Invocation invocation = resource.queryParam(identifier, value).request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE)
				.buildGet();
		Response response = invocation.invoke();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			employee = response.readEntity(Employee.class);
		}
		return employee;
	}

	@Override
	public boolean create(Employee entity) {
		boolean opResult = false;

		Response response = resource.request().post(Entity.entity(entity, ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE));
		if (response.getStatusInfo().equals(Response.Status.CREATED)) {
			opResult = true;
		}
		return opResult;
	}

	@Override
	public boolean delete(String entityId) {
		boolean opResult = false;

		Response response = resource.path("/{uuid}").resolveTemplate("uuid", entityId).request().delete();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			opResult = true;
		}

		return opResult;
	}

	@Override
	public boolean update(String entityId, Employee entity) {
		boolean opResult = false;

		Response response = resource.path("/{uuid}").resolveTemplate("uuid", entityId).request()
				.put(Entity.entity(entity, ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE));
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			opResult = true;
		}

		return opResult;
	}
	
	@Override
	public void init() {
		client = ClientBuilder.newClient();
		resource = client.target(SERVICE_URL);
	}

	@Override
	public void close() {
		client.close();
	}
}
