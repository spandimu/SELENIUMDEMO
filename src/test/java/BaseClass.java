import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseClass extends Driverscript{

    WebDriver driver;

    public BaseClass() {
        super();
        this.driver =  setDriver();
    }

    @BeforeSuite
    void setup(){
        driver = getDriver();
        driver.manage().window().maximize();
    }

    public WebElement webElementXpath(String xpath)
    {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement webElementLinkText(String linkText)
    {
        return driver.findElement(By.linkText(linkText));
    }

    public void setText(String xpath, String text) throws IOException {
        webElementXpath(xpath).sendKeys(text);
//        File srcFile = webElementXpath(xpath).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFileToDirectory(srcFile,new File(ClassLoader.g));
    }

    public boolean isElementDisplayed(String xpath) {
        return webElementXpath(xpath).isDisplayed();
    }

    public WebDriver getDriver(){
        return driver;
    }

    @AfterSuite
    void teardown(){
        driver.quit();
    }

}
