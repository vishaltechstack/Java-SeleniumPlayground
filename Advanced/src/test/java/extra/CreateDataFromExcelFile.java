package extra;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateDataFromExcelFile {
    public static void main(String[] args) throws IOException {
//        Step1: create the java rep object (JRO) of the physical file
        FileInputStream fis = new FileInputStream("");

//        Step2: get the access of workbook by using WorkbookFactory <<c>>
        Workbook wb = WorkbookFactory.create(fis);

//        Step3: get the access of Sheet by using getSheet() and pass the sheetname
        Sheet sh = wb.getSheet("Organization");

//        Step4: get the access of Row by using getRow() and pass the row index
        Row r = sh.getRow(2);

//        Step5: get the access of Cell by using getCow() and pass the cell index
        Cell c = r.getCell(0);

//        Step6: get the value by using getStringCellValue()
        String orgName = c.getStringCellValue();
        System.out.println(orgName);

//        Don't forget to close the file

    }
}
