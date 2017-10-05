package client;

import java.util.List;

import util.PropertyLoader;

public abstract class GenericClient<T> {
	/*
	 * Standard format in which the connection string must be generated
	 * protocol://host:port/rootpath
	 */
	private static final String URL_FORMAT = "%s://%s:%s/%s";
	private static final String PROPERTIES_NAMESPACE = "/config/service.properties";
	private static final PropertyLoader serviceProperties = new PropertyLoader(PROPERTIES_NAMESPACE);

	/**
	 * 
	 * Initialize service client instance and all associated resources.
	 */
	public abstract void init();

	/**
	 *
	 * Close service client instance and all associated resources.
	 */
	public abstract void close();

	/**
	 * @return A List of all entities contained in this resource.
	 */
	public abstract List<T> readAll();

	/**
	 * 
	 * Creates a new instance of the specified entity in this resource. Successive
	 * calls to this method are not idempotent.
	 * 
	 * @param entity
	 *            Entity to create within this resource.
	 * @return
	 */
	public abstract boolean create(T entity);

	/**
	 * 
	 * Retrieves the entity identified by the specified id within the resource.
	 * 
	 * @param entityId
	 *            The id of the entity to retrieve.
	 * @return An instance of the retrieved entity, or null if no such entity exists
	 *         within the resource.
	 */
	public abstract T read(String entityId);

	/**
	 * 
	 * Updates the entity identified by the specified id with the specified entity.
	 * 
	 * @param entityId
	 *            The id of the entity to update.
	 * @param entity
	 *            The new entity.
	 * @return
	 */
	public abstract boolean update(String entityId, T entity);

	/**
	 * 
	 * Deletes the entity identified by the specified id.
	 * 
	 * @param entityId
	 *            The id of the entity to delete.
	 * @return
	 */
	public abstract boolean delete(String entityId);

	/**
	 * 
	 * @return String representation of the URL of the service as stored in default
	 *         properties.
	 */
	public static String generateServiceRootUrl() {
		String protocol = serviceProperties.getProperty("protocol");
		String host = serviceProperties.getProperty("host");
		String port = serviceProperties.getProperty("port");
		String rootpath = serviceProperties.getProperty("rootpath");
		return String.format(URL_FORMAT, protocol, host, port, rootpath);
	}
}
