package session_32_CleanCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SinglePrincipleBefore {

}

class UserRegistration{
    public void registrationUser(String username, String email, String password){
        // validare
        if (username == null || username.length() < 2){
            throw new IllegalArgumentException("Username must not be null and should have min 2 chars.");
        }

        if (!email.contains("@")){
            throw new IllegalArgumentException("Invalid email format");
        }

        // add user to DB
        try(Connection connection = DriverManager.getConnection("idk idk")) {
            String sql = "insert into users(username, email, password) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            // Email implementation
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
