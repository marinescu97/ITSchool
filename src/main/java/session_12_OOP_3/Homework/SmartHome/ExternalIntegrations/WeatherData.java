package session_12_OOP_3.Homework.SmartHome.ExternalIntegrations;

public record WeatherData(double temperature, int weatherCode) {

    public boolean isRainy() {
        return weatherCode >= 60 && weatherCode <= 67;
    }
}
