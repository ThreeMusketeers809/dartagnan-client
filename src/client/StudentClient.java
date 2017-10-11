package client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import core.Student;
import service.ServicePresets;

/**
 * 
 * Client implementation for accessing Student resources.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 */
public class StudentClient extends GenericClient<Student> {
	private static final String SERVICE_PATH = "students";
	private static final String SERVICE_URL = String.format("%s/%s", getServiceRootUrl(), SERVICE_PATH);

	private Client client;
	private WebTarget resource;

	/**
	 * 
	 * Constructor
	 */
	public StudentClient() {
	}

	@Override
	public List<Student> readAll() {
		List<Student> students = null;

		GenericType<List<Student>> list = new GenericType<List<Student>>() {
		};
		Response response = resource.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).get();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			students = response.readEntity(list);
		} else {
			reportUnsuccessful(response);
		}

		return students;
	}

	@Override
	public Student read(String entityId) {
		Student student = null;

		Response response = resource.path("/{uuid}").resolveTemplate("uuid", entityId)
				.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).get();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			student = response.readEntity(Student.class);
		} else {
			reportUnsuccessful(response);
		}

		return student;
	}

	public Student readByUniqueIdentifier(String identifier, String value) {
		Student student = null;

		Response response = resource.queryParam(identifier, value).request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE)
				.get();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			student = response.readEntity(Student.class);
		} else {
			reportUnsuccessful(response);
		}

		return student;
	}

	@Override
	public String create(Student entity) {
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
	public boolean update(String entityId, Student entity) {
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
