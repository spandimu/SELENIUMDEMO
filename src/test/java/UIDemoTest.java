import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;

import java.io.IOException;

public class UIDemoTest extends BaseClass{

    @BeforeTest
    void init(){
        driver.get(ContactDataConstants.practiceURL);
    }

   @Test
   public void Verify_elementsTest() throws InterruptedException {

       boolean isElementPresent = false;
       int i=0;
       ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");

       while(i<10) {
           try {
               isElementPresent = webElementXpath("(//a[@id='periodicElement'])[6]").isDisplayed();
           }catch (NoSuchElementException e){
               Thread.sleep(3000);
           }
           if(isElementPresent)
               break;
           i++;
       }

       assertEquals(webElementXpath("(//a[@id='periodicElement'])[6]").getText(),"Element5");

   }

    @Test
    public void Verify_propertiesTest() {
        assertEquals(webElementXpath("//div[@class='widget-title']").getText(),"CONTACT US");
        assertEquals(webElementLinkText("This is a link").getAttribute("href"),"http://www.seleniumframework.com/");
        assertEquals(webElementLinkText("This is a link").getText(),"This is a link");
    }

    @Test
    public void Verify_ContactUsForm_ClearTest() throws IOException {
        boolean btnSubmitCheck = isElementDisplayed("//a[@class='dt-btn dt-btn-m dt-btn-submit']");

        if(btnSubmitCheck){
            setText(UIMapContactus.NAME_XPATH,ContactDataConstants.FIRST_NAME);
            setText(UIMapContactus.EMAIL_XPATH,ContactDataConstants.EMAIL);
            setText(UIMapContactus.PHONE_XPATH,ContactDataConstants.PHONE);
            setText(UIMapContactus.COUNTRY_XPATH,ContactDataConstants.COUNTRY);
            setText(UIMapContactus.COMPANY_XPATH,ContactDataConstants.COMPANY);
            setText(UIMapContactus.MESSAGE_XPATH,ContactDataConstants.MESSAGE);

            assertEquals(webElementXpath(UIMapContactus.NAME_XPATH).getAttribute("value"),ContactDataConstants.FIRST_NAME);
            assertEquals(webElementXpath(UIMapContactus.EMAIL_XPATH).getAttribute("value"),ContactDataConstants.EMAIL);
            assertEquals(webElementXpath(UIMapContactus.PHONE_XPATH).getAttribute("value"),ContactDataConstants.PHONE);
            assertEquals(webElementXpath(UIMapContactus.COUNTRY_XPATH).getAttribute("value"),ContactDataConstants.COUNTRY);
            assertEquals(webElementXpath(UIMapContactus.COMPANY_XPATH).getAttribute("value"),ContactDataConstants.COMPANY);
            assertEquals(webElementXpath(UIMapContactus.MESSAGE_XPATH).getAttribute("value"),ContactDataConstants.MESSAGE);


            webElementXpath(UIMapContactus.CLEAR_XPATH).click();

            assertEquals(webElementXpath(UIMapContactus.NAME_XPATH).getAttribute("value"),"");
            assertEquals(webElementXpath(UIMapContactus.EMAIL_XPATH).getAttribute("value"),"");
            assertEquals(webElementXpath(UIMapContactus.PHONE_XPATH).getAttribute("value"),"");
            assertEquals(webElementXpath(UIMapContactus.COUNTRY_XPATH).getAttribute("value"),"");
            assertEquals(webElementXpath(UIMapContactus.COMPANY_XPATH).getAttribute("value"),"");
            assertEquals(webElementXpath(UIMapContactus.MESSAGE_XPATH).getAttribute("value"),"");



        }

    }


    @Test
    public void Validate_subscribe() throws IOException {
        setText(UIMapContactus.SUBSCRIBE_XPATH,ContactDataConstants.EMAIL);
        webElementXpath(UIMapContactus.SUBSCRIBE_BTN_XPATH).click();
    }


}
