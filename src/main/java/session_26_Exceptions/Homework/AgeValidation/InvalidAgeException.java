package session_26_Exceptions.Homework.AgeValidation;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
}
