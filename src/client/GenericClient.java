package client;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import util.PropertyLoader;

/**
 * 
 * This class provides an universal, generic template for accessing resources
 * within a service. It also provides common methods and utilities for accessing
 * resources.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 *
 * @param <T>
 *            The data type represented by the resource this client will access.
 */
public abstract class GenericClient<T> {
	/*
	 * Format: protocol://host:port/rootpath
	 */
	private static final String URL_FORMAT = "%s://%s:%s/%s";
	private static final String PROPERTIES_NAMESPACE = "/config/service.properties";
	private static final PropertyLoader serviceProperties = new PropertyLoader(PROPERTIES_NAMESPACE);

	private StatusType lastUnsuccessfulStatus = null;

	/**
	 * Constructor.
	 */
	public GenericClient() {
		init();
	}

	/**
	 * 
	 * Initialize the service client instance.
	 * 
	 * <p>
	 * This function is implicitly called by the class constructor and should
	 * initialize all variables and implement everything necessary in order connect
	 * to and access the resource.
	 * </p>
	 */
	protected abstract void init();

	/**
	 *
	 * Closes the client instance and all associated resources.
	 * 
	 * <p>
	 * Any resources opened in the {@link #GenericClient#init} method should be
	 * closed here.
	 * </p>
	 */
	public abstract void close();

	/**
	 * 
	 * Retrieves a List of all entities contained within the resource. This method
	 * is idempotent.
	 * 
	 * @return A List of all entities contained within this resource.
	 */
	public abstract List<T> readAll();

	/**
	 * 
	 * Creates a new instance of the specified entity within the resource. This
	 * method is not idempotent.
	 * 
	 * @param entity
	 *            Entity to create within this resource.
	 * @return A String containing the ID of the newly created entity or null if
	 *         creation failed.
	 */
	public abstract String create(T entity);

	/**
	 * 
	 * Retrieves the entity stored under the specified id within the resource. This
	 * method is idempotent.
	 * 
	 * @param entityId
	 *            The id of the entity to retrieve.
	 * @return An instance of the retrieved entity, or null if no such entity exists
	 *         within the resource.
	 */
	public abstract T read(String entityId);

	/**
	 * 
	 * Updates the entity stored under the specified id with the data from an
	 * updated entity object. This method is idempotent.
	 * 
	 * @param entityId
	 *            The ID of the entity to update.
	 * @param entity
	 *            The updated entity.
	 * @return true if the operation was successful, false otherwise.
	 */
	public abstract boolean update(String entityId, T entity);

	/**
	 * 
	 * Deletes the entity stored under the specified id. This method is idempotent.
	 * 
	 * @param entityId
	 *            The ID of the entity to delete.
	 * @return true if the operation was successful, false otherwise.
	 */
	public abstract boolean delete(String entityId);

	/**
	 * 
	 * Provides a facility to allow implementing classes to report server responses
	 * that indicate an unsuccessful request. Successful or neutral responses are
	 * silently ignored by this method.
	 * 
	 * @param response
	 *            The response we want to report.
	 */
	protected void reportUnsuccessful(Response response) {
		Status.Family statusFamily = response.getStatusInfo().getFamily();
		if (statusFamily.equals(Status.Family.CLIENT_ERROR) || statusFamily.equals(Status.Family.SERVER_ERROR)) {
			lastUnsuccessfulStatus = response.getStatusInfo();
		}
	}

	/**
	 * @return The {@link javax.ws.rs.core.Response.Status} for the latest reported
	 *         unsuccessful request, or null if no reports have been made.
	 */
	public StatusType getLastUnsuccessfulStatus() {
		return lastUnsuccessfulStatus;
	}

	/**
	 * 
	 * @return String representation of the URL of the service as stored in the
	 *         default service properties.
	 */
	public static String getServiceRootUrl() {
		String protocol = serviceProperties.getProperty("protocol");
		String host = serviceProperties.getProperty("host");
		String port = serviceProperties.getProperty("port");
		String rootpath = serviceProperties.getProperty("rootpath");
		return String.format(URL_FORMAT, protocol, host, port, rootpath);
	}
}
