import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Driverscript {

    public WebDriver setDriver(){
        System.setProperty("webdriver.chrome.driver" ,  "/Users/sepandim/Downloads/SeleniumDemo/src/test/resources/chromedriver");
        return new ChromeDriver();
    }
}
