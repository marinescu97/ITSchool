package session_32_CleanCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SinglePrincipleAfter {
}

class UserValidation{
    public void validation(String username, String email, String password){
        // validare
        if (username == null || username.length() < 2){
            throw new IllegalArgumentException("Username must not be null and should have min 2 chars.");
        }

        if (!email.contains("@")){
            throw new IllegalArgumentException("Invalid email format");
        }

        if (password.length() < 6){
            throw new IllegalArgumentException("Password must be at least 6 chars.");
        }
    }
}

class UserRepository{
    public void saveUser(String username, String email, String password){
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
    }
}

class EmailService{
    public void sendEmail(String username, String email){
        try {
            // Email implementation
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class UserRegistrationService{
    private UserValidation userValidation;
    private UserRepository repository;
    private EmailService emailService;

    public UserRegistrationService(UserValidation userValidation, UserRepository repository, EmailService emailService) {
        this.userValidation = userValidation;
        this.repository = repository;
        this.emailService = emailService;
    }

    public void registrationUser(String username, String email, String password){
        userValidation.validation(username, email, password);
        repository.saveUser(username, email, password);
        emailService.sendEmail(username, email);
    }
}
