package generic_utility;

import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtility {
    public static String getDataFromJsonFile(String key) throws IOException, ParseException {
        FileReader fr = new FileReader("D:\\Software Testing Workspace\\Automation Using Java\\AdvancedSeleniumPlayground\\src\\test\\resources\\cd.json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jObj = (JSONObject) obj;
        String value = jObj.get(key).toString();
        return value;

    }

    public static String getDataFromExcelFile(String sheetName, int rowIndex, int cellIndex) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Software Testing Workspace\\Automation Using Java\\AdvancedSeleniumPlayground\\src\\test\\resources\\VTiger Test Script.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row r = sh.getRow(rowIndex);
        Cell c = r.getCell(cellIndex);
        String value = c.getStringCellValue();
        return value;
    }
}
