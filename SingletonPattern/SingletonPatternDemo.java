public class SingletonPatternDemo {
    public static void main(String[] args) {
        DatabaseConnectionManager manager1 = DatabaseConnectionManager.getInstance("jdbc:mysql://localhost:3306/mydb");
        manager1.connect();

        DatabaseConnectionManager manager2 = DatabaseConnectionManager.getInstance("jdbc:mysql://localhost:3306/anotherdb");
        manager2.connect();

        manager1.disconnect();
        manager2.disconnect();
    }
}
