package session_16_Hash.Homework.Challenge;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class XMLToJSON {
    public static void main(String[] args) {
        String xmlPath = "Files/Homework_session_16/Bookstore.xml";
        String jsonPath = xmlPath.replace("xml", "json");

        File xmlFile = new File(xmlPath);
        File jsonFile = new File(jsonPath);
        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(xmlFile);
            String rootName = document.getDocumentElement().getNodeName();

            XmlMapper xmlMapper = new XmlMapper();
            JsonNode innerNode = xmlMapper.readTree(xmlFile);

            ObjectMapper jsonMapper = new ObjectMapper();

            JsonNode rootWrapped = jsonMapper.createObjectNode().set(rootName, innerNode);

            DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter() {
                @Override
                public void writeObjectFieldValueSeparator(JsonGenerator g) throws IOException {
                    g.writeRaw(": ");
                }

                @Override
                public DefaultPrettyPrinter createInstance() {
                    return this;
                }
            };
            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);

            jsonMapper.writer(prettyPrinter).writeValue(jsonFile, rootWrapped);

            System.out.println("JSON printed to file " + jsonFile.getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error converting XML to JSON: " + e.getMessage());
        }
    }
}
