package MultiThreading;


import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;

import java.util.concurrent.*;

public class ConnectionPoolExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int maxPoolSize = 5;
        ConnectionPool connectionPool = ConnectionPool.getInstance(maxPoolSize);

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        Future<String>[] connectionFutures = new Future[7];

        for (int i = 0; i < 5; i++) {
            connectionFutures[i] = executorService.submit(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    connection.connect();
                    return "Connected";
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Waiting";
                }
            });
        }

        for (int i = 5; i < 7; i++) {
            connectionFutures[i] = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);  // Delay for 2 seconds
                    Connection connection = connectionPool.getConnection();
                    connection.connect();
                    return "Connected";
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Waiting";
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
            } else {
                System.out.println("Waiting for connection");
            }
        }

        executorService.shutdown();
    }
}

