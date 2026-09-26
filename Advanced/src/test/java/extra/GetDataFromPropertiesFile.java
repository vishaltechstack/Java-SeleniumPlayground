package extra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
    public static void main(String[] args) throws IOException {
//      Step 1: Create a Java Representation Object(JRO) of the physical file.
        FileInputStream fis = new FileInputStream("D:\\Software Testing Workspace\\AutomationTesting\\AdvancedSelenium\\AdvancedAutomationWithQSpider\\src\\test\\resources\\CommonData.properties");

//      Step 2: We will load all the keys by using non-static method → <load(fis)> of properties class.
        Properties prop = new Properties();
        prop.load(fis);

//      Step 4: We will get the value by using getPropeties() and pass the key in double quotes("")
        String browser = prop.getProperty("browser");
        System.out.println(browser);

//        don't forget to close the file
        fis.close();
    }
}
