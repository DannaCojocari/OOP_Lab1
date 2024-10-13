package lab_solution;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {
    public static JsonNode read(String path) throws IOException
    {
        // ObjectMapper instance - JSON parsing
        ObjectMapper mapper = new ObjectMapper();

        // parsing the file into a JsonNode object
        FileReader file = new FileReader(path);

        return mapper.readTree(file).get("data");
    }
}
