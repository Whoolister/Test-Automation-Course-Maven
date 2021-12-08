package tenth_solvd_assignment.connectivity;

import java.util.ArrayList;

public class ConnectionPool {
	// SINGLE INSTANCE
	private static ConnectionPool instance;
	private ArrayList<Connection> pool;
	private ArrayList<Connection> occupiedConnections;
	private final int maxConnections;

	private ConnectionPool(int maxConnections) {
		this.maxConnections = maxConnections;

		this.pool = new ArrayList<>(this.maxConnections);
		this.occupiedConnections = new ArrayList<>(this.maxConnections);

		for (int i = 0; i < this.maxConnections; i++) {
			this.pool.add(new Connection());
		}
	}

	public static ConnectionPool getInstance(int maxConnections) {
		if (instance == null) {
			instance = new ConnectionPool(maxConnections);
		}

		return instance;
	}

	public boolean hasAvailableConnections() {
		return !pool.isEmpty();
	}

	public synchronized Connection getConnection() throws RuntimeException {
		if (pool.isEmpty() || occupiedConnections.size() > this.maxConnections) {
			throw new RuntimeException("No available connections!");
		}

		Connection connection = pool.remove(pool.size() - 1);
		occupiedConnections.add(connection);
		return connection;
	}

	public synchronized boolean releaseConnection(Connection connection) {
		pool.add(connection);
		return occupiedConnections.remove(connection);
	}
}
