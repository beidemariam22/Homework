package MultiThreading;


class Connection {
    private boolean isConnected;

    public Connection() {
        isConnected = false;
    }

    public void connect() {
        System.out.println("Connected to mock database");
        isConnected = true;
    }

    public void disconnect() {
        System.out.println("Disconnected from mock database");
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
