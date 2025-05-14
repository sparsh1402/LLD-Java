package org.lld.creationalPatterns.singleton;
class DatabaseConnection{
    private static DatabaseConnection instance;
    private DatabaseConnection(){
        System.out.println("Database connection created");
    }
    public static DatabaseConnection getInstance(){
        if(instance == null){
            synchronized (DatabaseConnection.class) { // Double-checked locking to ensure thread safety
                instance = new DatabaseConnection();
            }
        }
        return instance;
    }
    public void connect(){
        System.out.println("Connected to the database");
    }
}
public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.connect();
    }
}
