import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstLine_Of_Code {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        EdgeDriver driver1 = new EdgeDriver();

//        After UpCasting.............................
        WebDriver driver2 = new ChromeDriver();
        WebDriver driver3 = new EdgeDriver();


        /*
        WebDriver is the type
        → driver is reference variable
        → new is keyword, which will create random memory space in heap area
        → ChromeDriver(), this constructor call will do 3 jobs:
            1> it will start the server
            2> it will launch the empty browser
            3> it will load, register and re-initialize the non-static member.
         */


//        After Runtime Polymorphism................................
        WebDriver driver4 = new ChromeDriver();
                  driver4 = new EdgeDriver();
    }
}
