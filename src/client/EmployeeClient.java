package client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import core.Employee;
import service.ServicePresets;

/**
 * 
 * Client implementation for accessing Employee resources.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 */
public class EmployeeClient extends GenericClient<Employee> {
	private static final String SERVICE_PATH = "employees";
	private static final String SERVICE_URL = String.format("%s/%s", getServiceRootUrl(), SERVICE_PATH);

	private Client client;
	private WebTarget resource;

	/**
	 * 
	 * Constructor
	 */
	public EmployeeClient() {
	}

	@Override
	public List<Employee> readAll() {
		List<Employee> employees = null;

		GenericType<List<Employee>> list = new GenericType<List<Employee>>() {
		};
		Response response = resource.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).get();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			employees = response.readEntity(list);
		} else {
			reportUnsuccessful(response);
		}

		return employees;
	}

	@Override
	public Employee read(String entityId) {
		Employee employee = null;

		Response response = resource.path("/{uuid}").resolveTemplate("uuid", entityId)
				.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).get();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			employee = response.readEntity(Employee.class);
		} else {
			reportUnsuccessful(response);
		}

		return employee;
	}

	public Employee readByUniqueIdentifier(String identifier, String value) {
		Employee employee = null;

		Response response = resource.queryParam(identifier, value).request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE)
				.get();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			employee = response.readEntity(Employee.class);
		} else {
			reportUnsuccessful(response);
		}
		return employee;
	}

	@Override
	public String create(Employee entity) {
		String entityId = null;

		Response response = resource.request().post(Entity.entity(entity, ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE));
		if (response.getStatusInfo().equals(Response.Status.CREATED)) {
			entityId = response.getEntityTag().getValue();
		} else {
			reportUnsuccessful(response);
		}
		return entityId;
	}

	@Override
	public boolean delete(String entityId) {
		boolean opResult = false;

		Response response = resource.path("/{uuid}").resolveTemplate("uuid", entityId).request().delete();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			opResult = true;
		} else {
			reportUnsuccessful(response);
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
		} else {
			reportUnsuccessful(response);
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
