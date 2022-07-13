package project.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import project.testData.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {
    private static String configPath = "src/main/java/project/config/config.json";
    private static String datasetCase3 = "src/main/java/project/testData/datasetCase3.json";
    private static String datasetCase5 = "src/main/java/project/testData/datasetCase5.json";

    private static Object fetchData(String path, String key) {
        Object object = null;
        try (FileReader reader = new FileReader(path)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            object = jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static String browserLanguage() {
        return (String) fetchData(configPath, "chrome language");
    }

    public static String BrowserName() {
        return (String) fetchData(configPath, "browser");
    }


    public static int parstimeOut() {
        return Integer.parseInt((String) fetchData(configPath, "time out"));
    }

    public static String parseURL() {
        return (String) fetchData(configPath, "url");
    }


    public static String Incognito() {
        return (String) fetchData(configPath, "incognito");
    }

    public static String startMaximized() {
        return (String) fetchData(configPath, "chrome maximized");
    }


    public static List<User> userData() {
        User user = null;
        List<String> list = new ArrayList<>();
        List<User> userlist = new ArrayList<>();
        JSONArray userdata = (JSONArray) fetchData(datasetCase3, "user");

        for (Object it : userdata) {
            JSONObject jsonObject = (JSONObject) it;
            String firstName = (String) jsonObject.get("first name");
            String lastName = (String) jsonObject.get("last name");
            String email = (String) jsonObject.get("email");
            String age = (String) jsonObject.get("age");
            String salary = (String) jsonObject.get("salary");
            String department = (String) jsonObject.get("department");

            userlist.add(new User(firstName, lastName, email, age, salary, department));
        }

        return userlist;
    }

    public static int age() {
        return (int) (long) fetchData(datasetCase5, "age");
    }

}