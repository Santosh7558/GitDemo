package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {

        //json to string
        String jsonContent = FileUtils.readFileToString(new File(filepath));

        //string to hasmap---jackson databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;
    }
}
