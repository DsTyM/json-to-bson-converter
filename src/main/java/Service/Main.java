package Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import org.bson.BsonDocument;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

public class Main {
  public static void main(String[] args) throws URISyntaxException, IOException {
    var objectMapper = new ObjectMapper();

    var fileString = new String(Files.readAllBytes(Paths.get(Objects.requireNonNull(Main.class.getResource("../jsonFile.json")).toURI())));

    var jsonArray = objectMapper.readTree(fileString);

    var outputString = new StringBuilder();
    outputString.append("[\n");
    for (JsonNode json : jsonArray) {
      var bsonDocument = BsonDocument.parse(json.toString());
      var jsonWriterSettings = JsonWriterSettings.builder().outputMode(JsonMode.SHELL).indent(true).build();
      outputString.append(bsonDocument.toJson(jsonWriterSettings));
      if (!json.equals(jsonArray.get(jsonArray.size() - 1))) {
        outputString.append(",\n");
      }
    }
    outputString.append("\n]");

    System.out.println(outputString);
    Files.write(Paths.get("./bsonFile.txt"), outputString.toString().getBytes(StandardCharsets.UTF_8));
  }
}
