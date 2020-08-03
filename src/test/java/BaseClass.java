import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class BaseClass extends Driverscript{

    WebDriver driver;

    public BaseClass() {
        super();
        this.driver =  setDriver();
    }

    @BeforeTest
    void setup(){
        driver = getDriver();
        driver.manage().window().maximize();
        driver.get("http://www.seleniumframework.com/Practiceform/");
    }

    public WebElement webElementXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement webElementLinkText(String linkText){
        return driver.findElement(By.linkText(linkText));
    }

    public void setText(String xpath, String text) throws IOException {
        webElementXpath(xpath).sendKeys(text);
//        File srcFile = webElementXpath(xpath).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFileToDirectory(srcFile,new File(ClassLoader.g));
    }

    public WebDriver getDriver(){
        return driver;
    }

    @AfterTest
    void teardown(){
        driver.quit();
    }

}
