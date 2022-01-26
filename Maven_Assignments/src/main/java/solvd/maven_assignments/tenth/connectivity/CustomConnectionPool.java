package tenth_solvd_assignment.connectivity;

import java.util.ArrayList;

public class CustomConnectionPool {
    // SINGLE INSTANCE
    private static CustomConnectionPool instance;
    private final int maxConnections;
    private final ArrayList<CustomConnection> pool;
    private final ArrayList<CustomConnection> occupiedConnections;

    private CustomConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;

        this.pool = new ArrayList<>(this.maxConnections);
        this.occupiedConnections = new ArrayList<>(this.maxConnections);

        for (int i = 0; i < this.maxConnections; i++) {
            this.pool.add(new CustomConnection());
        }
    }

    public static CustomConnectionPool getInstance() {
        if (instance == null) {
            instance = new CustomConnectionPool(5);
        }

        return instance;
    }

    public boolean hasAvailableConnections() {
        return !pool.isEmpty();
    }

    public synchronized CustomConnection getConnection() throws RuntimeException {
        if (pool.isEmpty() || occupiedConnections.size() > this.maxConnections) {
            throw new RuntimeException("No available connections!");
        }

        CustomConnection connection = pool.remove(pool.size() - 1);
        occupiedConnections.add(connection);
        return connection;
    }

    public synchronized boolean releaseConnection(CustomConnection connection) {
        pool.add(connection);
        return occupiedConnections.remove(connection);
    }
}
