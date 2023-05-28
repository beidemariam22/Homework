package Connection;

import java.util.concurrent.*;

public class ConnectionPoolExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int maxPoolSize = 5;
        ConnectionPool connectionPool = ConnectionPool.getInstance(maxPoolSize);

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        Future<String>[] connectionFutures = new Future[7];

        Semaphore semaphore = new Semaphore(5); // Create a semaphore with 5 permits

        for (int i = 0; i < 7; i++) {
            final int threadIndex = i; // Save the thread index

            connectionFutures[i] = executorService.submit(() -> {
                try {
                    Connection connection = null;
                    if (threadIndex < 5) {
                        connection = connectionPool.getConnection();
                        connection.connect();
                    }
                    semaphore.acquire(); // Acquire a permit from the semaphore
                    if (threadIndex >= 5) {
                        TimeUnit.SECONDS.sleep(2); // Wait for 2 seconds
                        connection = connectionPool.getConnection();
                        connection.connect();
                    }
                    return "Connected";
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Waiting for connection"; // Modified message for waiting threads
                } finally {
                    semaphore.release(); // Release the acquired permit
                }
            });
        }

        for (int i = 0; i < 7; i++) {
            String result = connectionFutures[i].get();
            if (result.equals("Connected")) {
                Connection connection = connectionPool.getConnection();
                System.out.println("Acquired connection: " + connection);
                connectionPool.releaseConnection(connection);
                System.out.println("Released connection");
            } else if (result.equals("Waiting for connection")) { // Add condition to display waiting message
                System.out.println(result);
            }
        }

        executorService.shutdown();
    }
}

