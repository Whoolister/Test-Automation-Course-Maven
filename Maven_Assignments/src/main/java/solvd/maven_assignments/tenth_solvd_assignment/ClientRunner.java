package tenth_solvd_assignment;

import java.util.ArrayList;
import java.util.logging.Level;

import tenth_solvd_assignment.connectivity.Connection;
import tenth_solvd_assignment.connectivity.ConnectionPool;
import tenth_solvd_assignment.utilities.MyLogger;

public class ClientRunner {
	private static final MyLogger LOG = new MyLogger(ClientRunner.class.getName());
	private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);

	public static void main(String[] args) {
		LOG.setupLogger();

		Runnable runnable = () -> {
			Thread currentThread = Thread.currentThread();
			String threadName = currentThread.getName();

			try {
				Thread.sleep(500);
				while (!CONNECTION_POOL.hasAvailableConnections()) {
					LOG.info(threadName + " queued");
					Thread.sleep(1000);
				}
				createConnection(threadName);
			} catch (InterruptedException e) {
				LOG.log(Level.SEVERE, e.getMessage());
			}
		};

		run(runnable);
	}

	public static void createConnection(String threadName) throws InterruptedException {
		Connection connection = CONNECTION_POOL.getConnection();

		connection.ping(threadName);
		connection.authorize(threadName);
		connection.status(threadName);

		Thread.sleep(1000);

		CONNECTION_POOL.releaseConnection(connection);
	}

	public static void run(Runnable runnable) {
		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			threads.add(new Thread(runnable, "thread " + i));
			threads.get(i).start();
		}
	}
}
