package MultiThreading;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingQueue<Connection> pool;
    private int maxPoolSize;
    private Lock lock;

    private ConnectionPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        pool = new ArrayBlockingQueue<>(maxPoolSize);
        lock = new ReentrantLock();
    }

    public static ConnectionPool getInstance(int maxPoolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(maxPoolSize);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        lock.lock();
        try {
            if (pool.isEmpty()) {
                Connection connection = new Connection();
                connection.connect();
                return connection;
            } else {
                return pool.take();
            }
        } finally {
            lock.unlock();
        }
    }

    public void releaseConnection(Connection connection) {
        lock.lock();
        try {
            if (pool.size() <= maxPoolSize) {
                pool.offer(connection);
            } else {
                connection.disconnect();
            }
        } finally {
            lock.unlock();
        }
    }
}
