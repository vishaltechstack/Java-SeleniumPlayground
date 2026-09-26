package extra;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetDataFromJsonFile {
    public static void main(String[] args) throws IOException, ParseException {
//  Step1: Create a JRO of the physical file
        FileReader fr = new FileReader("./src/test/resources/cd.json");

//  Step2: Pass the JRO non-static method => parse(fr) to connect to object
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);

//  Step3: Downcast object to JSONObject to get the value
        JSONObject jObj = (JSONObject) obj;

//  Step4: By using get() and passing the ket get the value
        String username = jObj.get("username").toString();
        String password = jObj.get("password").toString();
        System.out.println("username: " + username);
        System.out.println("password: " + password);

    }
}