import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Driverscript {

    public WebDriver setDriver(){
        System.setProperty("webdriver.chrome.driver" ,  "/Users/sethusumi/Downloads/SELENIUMDEMO/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
