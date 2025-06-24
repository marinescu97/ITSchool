package session_31_DesignPattern;

class DatbaseConnection{
    private String connectionString;
    private static DatbaseConnection instance;

    private DatbaseConnection(){
        connectionString = "jdbc:mysql://localhost:3306/db";
    }

    public static synchronized DatbaseConnection getInstance(){
        if (instance == null){
            instance = new DatbaseConnection();
        }

        return instance;
    }

    public void connect(){
        System.out.println("Connects to: " + connectionString);
    }
}

public class Singleton {
    public static void main(String[] args) {
        DatbaseConnection db = DatbaseConnection.getInstance();
        db.connect();
        System.out.println(db);

        DatbaseConnection db2 = DatbaseConnection.getInstance();
        System.out.println(db2);
    }
}
