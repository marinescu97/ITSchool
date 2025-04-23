package session_12_OOP_3.Homework.SmartHome.ExternalIntegrations;

import com.fasterxml.jackson.databind.JsonNode;

public class WeatherService extends JsonReader {
    private static final String urlString = "https://api.open-meteo.com/v1/forecast?latitude="
            + 44.18 + "&longitude=" + 28.63 + "&current_weather=true"; // Constanta

    public static WeatherData getCurrentWeather() {
        try {
            JsonNode root = getJsonNode(urlString);
            JsonNode current = root.get("current_weather");

            return new WeatherData(
                    current.get("temperature").asDouble(),
                    current.get("weathercode").asInt()
            );

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
