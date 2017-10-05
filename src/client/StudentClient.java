package client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import core.Student;
import service.ServicePresets;

public class StudentClient extends GenericClient<Student> {
	private static final String SERVICE_ROOT = "students";
	private static final String SERVICE_URL = String.format("%s/%s", generateServiceRootUrl(), SERVICE_ROOT);

	private Client client;
	private WebTarget resource;

	/**
	 * 
	 * Constructor
	 */
	public StudentClient() {
		init();
	}

	@Override
	public List<Student> readAll() {
		List<Student> students = null;

		GenericType<List<Student>> list = new GenericType<List<Student>>() {
		};
		Invocation invocation = resource.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).buildGet();
		Response response = invocation.invoke();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			students = response.readEntity(list);
		}

		return students;
	}

	@Override
	public Student read(String entityId) {
		Student student = null;

		Invocation invocation = resource.path("/{uuid}").resolveTemplate("uuid", entityId)
				.request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE).buildGet();
		Response response = invocation.invoke();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			student = response.readEntity(Student.class);
		}

		return student;
	}

	public Student readByUniqueIdentifier(String identifier, String value) {
		Student student = null;

		Invocation invocation = resource.queryParam(identifier, value).request(ServicePresets.PRIMARY_OBJECT_MEDIA_TYPE)
				.buildGet();
		Response response = invocation.invoke();
		if (response.getStatusInfo().equals(Response.Status.OK)) {
			student = response.readEntity(Student.class);
		}
		return student;
	}

	@Override
	public boolean create(Student entity) {
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
	public boolean update(String entityId, Student entity) {
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
