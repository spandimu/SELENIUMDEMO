import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class UIGoogleTest extends BaseClass{
    @BeforeTest
    void init(){
        driver.get(ContactDataConstants.googleURL);
    }

    @Test
    public void googleSearch() throws IOException {
        setText("//input[@title='Search']","Hello World");
        webElementXpath("(//input[@value='Google Search'])[2]").click();

        System.out.println(webElementXpath("//*[@id='rso']/div[4]//h3").getText());
        assertEquals(webElementXpath("//*[@id='rso']/div[4]//h3").getText().contains("Hello"),true);
    }
}
