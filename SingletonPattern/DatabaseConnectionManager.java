public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private String connectionString;

    private DatabaseConnectionManager(String connectionString) {
        this.connectionString = connectionString;
    }

    public static DatabaseConnectionManager getInstance(String connectionString) {
        if (instance == null) {
            instance = new DatabaseConnectionManager(connectionString);
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to the database with connection string: " + connectionString);
    }

    public void disconnect() {
        System.out.println("Disconnecting from the database");
    }
}
