package session_12_OOP_3.Homework.SmartHome.ExternalIntegrations;

import com.fasterxml.jackson.databind.JsonNode;

public class NewsService extends JsonReader {
    private static final String API_KEY = "API_KEY";
    private static final String urlString = String.format(
            "https://newsdata.io/api/1/news?apikey=%s&country=ro&language=en",
            API_KEY
    );

    public static NewsArticle getOneLocalNews() {
        try {
            JsonNode root = getJsonNode(urlString);

            JsonNode firstResult = root.path("results").get(0);
            if (firstResult == null || firstResult.isNull()) return null;

            String title = firstResult.path("title").asText();
            String description = firstResult.path("description").asText();

            return new NewsArticle(title, description);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
